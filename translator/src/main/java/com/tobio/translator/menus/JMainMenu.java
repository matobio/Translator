package com.tobio.translator.menus;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.tobio.translator.utils.Constants;
import com.tobio.translator.utils.GoogleTranslatorUtils;

public class JMainMenu extends JFrame {

    private static final long serialVersionUID = 1L;

    // Labels
    protected JLabel          labelSpanish     = null;
    protected JLabel          labelGallego     = null;
    protected JLabel          labelEnglish     = null;
    protected JLabel          labelPortuguese  = null;
    protected JLabel          labelChinese     = null;
    protected JLabel          labelFrances     = null;
    protected JLabel          labelGerman      = null;

    // Textfields
    protected JTextArea       fieldSpanish     = null;
    protected JTextArea       fieldGallego     = null;
    protected JTextArea       fieldEnglish     = null;
    protected JTextArea       fieldPortuguese  = null;
    protected JTextArea       fieldChinese     = null;
    protected JTextArea       fieldFrances     = null;
    protected JTextArea       fieldGerman      = null;

    protected JButton         btnTranslate     = null;
    protected JButton         btnClean         = null;


    public static JMainMenu newInstance(Map<String, Object> parameters) {
        return new JMainMenu(parameters);
    }


    protected JMainMenu(Map<String, Object> parameters) {

        super("Traductor by Tobío");

        try {

            this.init(parameters);

            this.addActionListeners();

            this.addValueChangeListeners();

        } catch (Exception ex) {
        }

    }


    protected void init(Map<String, Object> parameters) {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.addComponents();

        this.setSize(1000, 1000);
        this.pack();

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

        JScrollPane scrollPane = new JScrollPane(mainPanel);

        this.add(scrollPane);

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

        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(this.labelGerman, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(this.fieldGerman, constraints);

        TitledBorder border = new TitledBorder("Traducciones");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        border.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        panel.setBorder(border);

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

        TitledBorder border = new TitledBorder("Traducir ");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        border.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        panel1.setBorder(border);
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
        this.labelGerman = new JLabel(Constants.GERMAN);

        // Textfields
        int columns = 100;
        int rows = 2;
        this.fieldSpanish = new JTextArea(rows, columns);
        this.fieldEnglish = new JTextArea(rows, columns);

        this.fieldGallego = new JTextArea(rows, columns);
        this.fieldGallego.setEditable(false);
        this.fieldGallego.setBackground(Color.LIGHT_GRAY);

        this.fieldPortuguese = new JTextArea(rows, columns);
        this.fieldPortuguese.setEditable(false);
        this.fieldPortuguese.setBackground(Color.LIGHT_GRAY);

        this.fieldChinese = new JTextArea(rows, columns);
        this.fieldChinese.setEditable(false);
        this.fieldChinese.setBackground(Color.LIGHT_GRAY);

        this.fieldFrances = new JTextArea(rows, columns);
        this.fieldFrances.setEditable(false);
        this.fieldFrances.setBackground(Color.LIGHT_GRAY);

        this.fieldGerman = new JTextArea(rows, columns);
        this.fieldGerman.setEditable(false);
        this.fieldGerman.setBackground(Color.LIGHT_GRAY);

        // Button translate
        this.btnTranslate = new JButton(Constants.TRANSLATE);
        this.btnClean = new JButton(Constants.CLEAN);
    }


    protected void addValueChangeListeners() {

        this.fieldSpanish.addKeyListener(new FieldKeyListener(this.fieldSpanish));
        this.fieldEnglish.addKeyListener(new FieldKeyListener(this.fieldEnglish));
    }

    class FieldKeyListener implements KeyListener {

        protected JTextArea jTextArea = null;


        public FieldKeyListener(JTextArea jTextArea) {
            this.jTextArea = jTextArea;
        }


        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_TAB) {
                if (e.getModifiers() > 0) {
                    this.jTextArea.transferFocusBackward();
                } else {
                    this.jTextArea.transferFocus();
                }
                e.consume();
            }

        }


        @Override
        public void keyReleased(KeyEvent e) {
            // TODO Auto-generated method stub

        }


        @Override
        public void keyTyped(KeyEvent e) {
            // TODO Auto-generated method stub

        }

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


        @Override
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
                String germanTranslation = GoogleTranslatorUtils.translate("en", "de", englishText);

                JMainMenu.this.fieldGallego.setText(gallegoTranslation);
                JMainMenu.this.fieldPortuguese.setText(portugueseTranslation);
                JMainMenu.this.fieldFrances.setText(franceTranslation);
                JMainMenu.this.fieldChinese.setText(chineseTranslation);
                JMainMenu.this.fieldGerman.setText(germanTranslation);

            } catch (Exception e) {

            }

        }
    }

    class ButtonCleanActionListener implements ActionListener {

        public ButtonCleanActionListener() {
            // Do nothing
        }


        @Override
        public void actionPerformed(ActionEvent ev) {

            JMainMenu.this.fieldSpanish.setText(null);
            JMainMenu.this.fieldEnglish.setText(null);
            JMainMenu.this.fieldGallego.setText(null);
            JMainMenu.this.fieldPortuguese.setText(null);
            JMainMenu.this.fieldFrances.setText(null);
            JMainMenu.this.fieldChinese.setText(null);
            JMainMenu.this.fieldGerman.setText(null);
        }
    }

}
