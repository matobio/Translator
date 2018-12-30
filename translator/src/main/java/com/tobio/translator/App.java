package com.tobio.translator;

import java.util.HashMap;

import javax.swing.JFrame;

import com.tobio.translator.menus.JMainMenu;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        JFrame menu = JMainMenu.newInstance(new HashMap<String, Object>());

    }
}
