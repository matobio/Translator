package com.tobio.translator.menus;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.tobio.translator.utils.Constants;

public class JMainMenu extends JFrame {

    // Labels
    protected JLabel     labelSpanish    = null;
    protected JLabel     labelGallego    = null;
    protected JLabel     labelEnglish    = null;
    protected JLabel     labelPortuguese = null;
    protected JLabel     labelChinese    = null;
    protected JLabel     labelFrances    = null;

    // Textfields
    protected JTextField fieldSpanish    = null;
    protected JTextField fieldGallego    = null;
    protected JTextField fieldEnglish    = null;
    protected JTextField fieldPortuguese = null;
    protected JTextField fieldChinese    = null;
    protected JTextField fieldFrances    = null;

    protected JButton    btnTranslate    = null;
    protected JButton    btnClean        = null;


    public static JMainMenu newInstance(Map<String, Object> parameters) {
        return new JMainMenu(parameters);
    }


    protected JMainMenu(Map<String, Object> parameters) {

        super("Traductor");

        this.init(parameters);

        this.addActionListeners();

        this.addValueChangeListeners();
    }


    protected void init(Map<String, Object> parameters) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addComponents();

        this.setSize(1000, 1000);
        this.pack();
        this.setVisible(true);

    }


    protected void addComponents() {

        this.initializeComponents();

        JPanel panel1 = this.createPanelHeader();
        JPanel panel2 = this.createPanelTranslations();
        JPanel panel3 = this.createPanelBotton();

        JPanel mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);

        this.add(mainPanel);
    }


    protected JPanel createPanelBotton() {

        JPanel panel3 = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        // constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.WEST;
        panel3.add(this.btnTranslate, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        // constraints.gridwidth = 3;
        constraints.anchor = GridBagConstraints.EAST;
        panel3.add(this.btnClean, constraints);
        return panel3;
    }


    protected JPanel createPanelTranslations() {

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel.add(this.labelGallego, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel.add(this.fieldGallego, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(this.labelPortuguese, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(this.fieldPortuguese, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(this.labelChinese, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(this.fieldChinese, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(this.labelFrances, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(this.fieldFrances, constraints);

        return panel;
    }


    protected JPanel createPanelHeader() {

        JPanel panel1 = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        panel1.add(this.labelSpanish, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        panel1.add(this.fieldSpanish, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        panel1.add(this.labelEnglish, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel1.add(this.fieldEnglish, constraints);

        return panel1;
    }


    protected void initializeComponents() {

        // Labels
        this.labelSpanish = new JLabel(Constants.SPANISH);
        this.labelGallego = new JLabel(Constants.GALLEGO);
        this.labelEnglish = new JLabel(Constants.ENGLISH);
        this.labelPortuguese = new JLabel(Constants.PORTUGUES);
        this.labelChinese = new JLabel(Constants.CHINO);
        this.labelFrances = new JLabel(Constants.FRANCES);

        // Textfields
        int columns = 100;
        this.fieldSpanish = new JTextField(columns);
        this.fieldEnglish = new JTextField(columns);

        this.fieldGallego = new JTextField(columns);
        this.fieldGallego.setEditable(false);

        this.fieldPortuguese = new JTextField(columns);
        this.fieldPortuguese.setEditable(false);

        this.fieldChinese = new JTextField(columns);
        this.fieldChinese.setEditable(false);

        this.fieldFrances = new JTextField(columns);
        this.fieldFrances.setEditable(false);

        // Button translate
        this.btnTranslate = new JButton(Constants.TRANSLATE);
        this.btnClean = new JButton(Constants.CLEAN);
    }


    protected void addValueChangeListeners() {

    }


    protected void addActionListeners() {

        if (this.btnTranslate != null) {
            this.btnTranslate.addActionListener(new ButtonTranslateActionListener());
        }

        if (this.btnClean != null) {
            this.btnClean.addActionListener(new ButtonCleanActionListener());
        }
    }

    class ButtonTranslateActionListener implements ActionListener {

        public ButtonTranslateActionListener() {
            // Do nothing
        }


        public void actionPerformed(ActionEvent ev) {

            try {
                String spanishText = JMainMenu.this.fieldSpanish.getText();
                String englishText = JMainMenu.this.fieldEnglish.getText();

                if (spanishText == null) {
                    spanishText = "";
                }
                if (englishText == null) {
                    englishText = "";
                }

                String gallegoTranslation = GoogleTranslatorUtils.translate("es", "gl", spanishText);
                String portugueseTranslation = GoogleTranslatorUtils.translate("es", "pt", spanishText);
                String franceTranslation = GoogleTranslatorUtils.translate("en", "fr", englishText);
                String chineseTranslation = GoogleTranslatorUtils.translate("en", "zh", englishText);

                JMainMenu.this.fieldGallego.setText(gallegoTranslation);
                JMainMenu.this.fieldPortuguese.setText(portugueseTranslation);
                JMainMenu.this.fieldFrances.setText(franceTranslation);
                JMainMenu.this.fieldChinese.setText(chineseTranslation);

            } catch (Exception e) {

            }

        }
    }

    class ButtonCleanActionListener implements ActionListener {

        public ButtonCleanActionListener() {
            // Do nothing
        }


        public void actionPerformed(ActionEvent ev) {

            JMainMenu.this.fieldSpanish.setText(null);
            JMainMenu.this.fieldEnglish.setText(null);
            JMainMenu.this.fieldGallego.setText(null);
            JMainMenu.this.fieldPortuguese.setText(null);
            JMainMenu.this.fieldFrances.setText(null);
            JMainMenu.this.fieldChinese.setText(null);

        }
    }

}
