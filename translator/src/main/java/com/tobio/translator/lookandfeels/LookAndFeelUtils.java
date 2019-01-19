package com.tobio.translator.lookandfeels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.LookAndFeel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import com.tobio.translator.frames.AppMainPanel;

public class LookAndFeelUtils {

    protected static LookAndFeelUtils instance;

    protected static List<String>     listLookAndFeelUtils = new ArrayList<>();

    protected static LookAndFeel      defaultLookAndFeel   = null;


    protected LookAndFeelUtils() {

    }


    public void init() {

        LookAndFeelUtils.listLookAndFeelUtils.add("javax.swing.plaf.metal.MetalLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("ch.randelshofer.quaqua.QuaquaLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.noire.NoireLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.mint.MintLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.graphite.GraphiteLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add(UIManager.getSystemLookAndFeelClassName());
        LookAndFeelUtils.listLookAndFeelUtils.add("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.smart.SmartLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.aluminium.AluminiumLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.aero.AeroLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.bernstein.BernsteinLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceOfficeSilver2007LookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceOfficeBlue2007LookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceOfficeBlack2007LookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceNebulaLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.texture.TextureLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("javax.swing.plaf.synth.SynthLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceTwilightLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceNebulaBrickWallLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceModerateLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceMistSilverLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceMistAquaLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceMarinerLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceMagellanLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceGraphiteAquaLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceGeminiLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceCremeLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceBusinessLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("org.pushingpixels.substance.api.skin.SubstanceBusinessBlueSteelLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("ch.randelshofer.quaqua.QuaquaLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.luna.LunaLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.fast.FastLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
        LookAndFeelUtils.listLookAndFeelUtils.add("com.jtattoo.plaf.smart.SmartLookAndFeel");
    }


    public static LookAndFeelUtils getInstance() {
        if (LookAndFeelUtils.instance == null) {
            LookAndFeelUtils.instance = new LookAndFeelUtils();
        }
        return LookAndFeelUtils.instance;
    }


    public void changeLookAndFeel(String lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(AppMainPanel.getInstance());

        } catch (Exception ex) {
        }
    }


    public void changeLookAndFeel(LookAndFeel lookAndFeel) {
        try {
            UIManager.setLookAndFeel(lookAndFeel);
            SwingUtilities.updateComponentTreeUI(AppMainPanel.getInstance());

        } catch (Exception ex) {
        }
    }


    public static List<String> getListLookAndFeelUtils() {
        return LookAndFeelUtils.listLookAndFeelUtils;
    }


    public static void setListLookAndFeelUtils(List<String> listLookAndFeelUtils) {
        LookAndFeelUtils.listLookAndFeelUtils = listLookAndFeelUtils;
    }


    public static LookAndFeel getDefaultLookAndFeel() {
        return LookAndFeelUtils.defaultLookAndFeel;
    }


    public static void setDefaultLookAndFeel(LookAndFeel defaultLookAndFeel) {
        LookAndFeelUtils.defaultLookAndFeel = defaultLookAndFeel;
    }
}
