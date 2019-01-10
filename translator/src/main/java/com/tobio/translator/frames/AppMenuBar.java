package com.tobio.translator.frames;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

public class AppMenuBar extends JMenuBar {

    private static final long serialVersionUID = 1L;


    protected AppMenuBar(Map<String, Object> params) {
        super();

        this.init(params);
    }


    public static AppMenuBar newInstance(Map<String, Object> params) {
        return new AppMenuBar(params);
    }


    protected void init(Map<String, Object> params) {

        JMenu mainMenu = this.createMainMenu();

        this.add(mainMenu);

    }


    protected JMenu createMainMenu() {
        return AppMenu.newInstance(new HashMap<>());
    }

}
