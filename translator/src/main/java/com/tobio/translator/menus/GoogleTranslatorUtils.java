package com.tobio.translator.menus;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;

public class GoogleTranslatorUtils {

    private GoogleTranslatorUtils() {
        // Utility class
    }


    public static String translate(String langFrom, String langTo, String textToTranslate) throws Exception {

        String url = "https://translate.googleapis.com/translate_a/single?" + "client=gtx&" + "sl=" + langFrom + "&tl=" + langTo + "&dt=t&q=" + URLEncoder.encode(textToTranslate, "UTF-8");

        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestProperty("User-Agent", "Mozilla/5.0");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;

        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        String inputJson = response.toString();
        JSONArray jsonArray = new JSONArray(inputJson);
        JSONArray jsonArray2 = (JSONArray) jsonArray.get(0);
        JSONArray jsonArray3 = (JSONArray) jsonArray2.get(0);

        return jsonArray3.get(0).toString();

    }

}
