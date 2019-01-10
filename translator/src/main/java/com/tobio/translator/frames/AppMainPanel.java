package com.tobio.translator.frames;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class AppMainPanel extends JFrame {

    private static final long     serialVersionUID = 1L;

    protected static AppMainPanel instance;

    public JScrollPane            scrollPanel;
    public JPanel                 mainPanel;

    public JPanel                 translationsPanel;
    public JPanel                 translationSuppliersPanel;


    public static AppMainPanel getInstance() {
        if (AppMainPanel.instance == null) {
            AppMainPanel.instance = new AppMainPanel();
        }
        return AppMainPanel.instance;
    }


    protected AppMainPanel() {
        super("Traductor by Tobío");

        this.init();

    }


    protected void init() {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addComponents();

        this.setSize(1000, 1000);
        this.pack();

        this.addIconImage();
    }


    protected void addIconImage() {

        URL url = Thread.currentThread().getContextClassLoader().getResource("images/icon1.png");
        Toolkit kit = Toolkit.getDefaultToolkit();
        Image img = kit.createImage(url);
        this.setIconImage(img);
    }


    protected void addComponents() {

        JMenuBar menubar = this.createMenuBar();

        this.translationsPanel = this.createTranslationsPanel();
        this.translationSuppliersPanel = this.createTranslationSuppliersPanel();

        this.mainPanel = new JPanel();
        this.mainPanel.setLayout(new GridLayout());

        this.scrollPanel = new JScrollPane();
        this.scrollPanel = new JScrollPane(this.translationsPanel);

        this.changeState(States.MENU_TRANSLATIONS_STATE);
        this.setJMenuBar(menubar);

        this.add(this.mainPanel);

    }


    public void changeState(int state) {
        switch (state) {
            case States.MENU_TRANSLATIONS_STATE:
                this.mainPanel.removeAll();
                this.mainPanel.add(this.scrollPanel);
                this.mainPanel.revalidate();
                this.mainPanel.repaint();
                break;
            case States.MENU_PROVEEDORES_STATE:
                this.mainPanel.removeAll();
                this.mainPanel.add(this.translationSuppliersPanel);
                this.mainPanel.revalidate();
                this.mainPanel.repaint();
                break;
            default:
                break;
        }
    }


    public JPanel createTranslationSuppliersPanel() {
        return TranslationSuppliersPanel.getInstance(new GridBagLayout(), new HashMap<>());
    }


    protected JPanel createTranslationsPanel() {
        return TranslationsPanel.newInstance(new GridBagLayout(), new HashMap<>());
    }


    protected JMenuBar createMenuBar() {
        return AppMenuBar.newInstance(new HashMap<>());
    }

}
