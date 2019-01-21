package com.tobio.translator;

import javax.swing.JFrame;
import javax.swing.UIManager;

import com.tobio.translator.frames.AppMainPanel;

/**
 * @author Manuel Tobio
 *
 * Params:
 *
 *     <li> -lookAndFeel: specify the look and feel class to load
 *
 */
public class App {

    public static final String ARGS_LOOK_AND_FEEL = "-lookandfeel";


    public static void main(String[] args) {

        String lookAndFeelClass = App.getParamLookAndFeel(args);

        JFrame menu = AppMainPanel.getInstance(lookAndFeelClass);

        menu.setVisible(true);
    }


    protected static String getParamLookAndFeel(String[] args) {

        String lookAndFeelClass = UIManager.getLookAndFeel().getClass().getName();
        if (args.length > 1) {

            boolean next = false;
            for (int i = 0; i < args.length; i++) {

                if (next) {
                    lookAndFeelClass = args[i];
                    break;
                }
                if (args[i].equalsIgnoreCase(App.ARGS_LOOK_AND_FEEL)) {
                    next = true;
                }
            }
        }
        return lookAndFeelClass;
    }
}
