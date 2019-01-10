package com.tobio.translator;

import javax.swing.JFrame;

import com.tobio.translator.frames.AppMainPanel;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {

        JFrame menu = AppMainPanel.getInstance();

        menu.setVisible(true);
    }
}
