package com.tobio.translator.frames;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.tobio.translator.utils.Constants;

public class AppMenu extends JMenu {

    private static final long serialVersionUID = 1L;

    protected JMenuItem       menuItemTranslations;
    protected JMenuItem       menuItemProveedores;


    protected AppMenu(Map<String, Object> params) {
        super(Constants.MENU);

        this.init(params);

        this.addActionListeners();
    }


    public static AppMenu newInstance(Map<String, Object> params) {
        return new AppMenu(params);
    }


    protected void init(Map<String, Object> params) {

        List<JMenuItem> menuItems = this.createMenuItems();
        for (JMenuItem menuItem : menuItems) {
            this.add(menuItem);
        }
    }


    protected List<JMenuItem> createMenuItems() {

        List<JMenuItem> menuItems = new ArrayList<>();

        this.menuItemTranslations = this.createMenuItemTranslations();
        this.menuItemProveedores = this.createMenuItemProveedores();

        menuItems.add(this.menuItemTranslations);
        menuItems.add(this.menuItemProveedores);

        return menuItems;
    }


    protected JMenuItem createMenuItemTranslations() {
        return new JMenuItem(Constants.TRANSLATIONS);
    }


    protected JMenuItem createMenuItemProveedores() {
        return new JMenuItem(Constants.PROVEDORES);
    }


    protected void addActionListeners() {

        this.menuItemTranslations.addActionListener(ev -> {
            AppMainPanel.getInstance().changeState(States.MENU_TRANSLATIONS_STATE);
        });

        this.menuItemProveedores.addActionListener(ev -> {
            AppMainPanel.getInstance().changeState(States.MENU_PROVEEDORES_STATE);
        });
    }

}
