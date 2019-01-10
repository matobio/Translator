package com.tobio.translator.translators;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;

import com.tobio.translator.interfaces.ICustomTranslator;

public class GoogleTranslator implements ICustomTranslator {

    protected static GoogleTranslator instance;


    protected GoogleTranslator() {}


    public static GoogleTranslator getInstance() {
        if (GoogleTranslator.instance == null) {
            GoogleTranslator.instance = new GoogleTranslator();
        }
        return GoogleTranslator.instance;
    }


    @Override
    public String translate(String langFrom, String langTo, String textToTranslate) {
        StringBuilder sbTranslation = new StringBuilder();

        try {
            String url = "https://translate.googleapis.com/translate_a/single?" + "client=gtx&" + "sl=" + langFrom + "&tl=" + langTo + "&dt=t&q=" + URLEncoder.encode(textToTranslate, "UTF-8");

            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestProperty("User-Agent", "Mozilla/5.0");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF8"));
            String inputLine;

            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            String inputJson = response.toString();
            JSONArray jsonArray = new JSONArray(inputJson);
            JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);

            for (int i = 0; i < jsonArray2.length(); i++) {
                if ((JSONArray) jsonArray2.get(i) != null) {
                    sbTranslation.append(((JSONArray) jsonArray2.get(i)).get(0).toString());
                }
            }

        } catch (Exception e) {

        }

        return sbTranslation.toString();
    }

}
