package com.tobio.translator.frames;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.tobio.translator.interfaces.ICustomTranslator;
import com.tobio.translator.translators.AbstractTranslator;
import com.tobio.translator.utils.Constants;

public class TranslationsPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    // Labels
    protected JLabel          labelSpanish     = null;
    protected JLabel          labelGallego     = null;
    protected JLabel          labelEnglish     = null;
    protected JLabel          labelPortuguese  = null;
    protected JLabel          labelChinese     = null;
    protected JLabel          labelFrances     = null;
    protected JLabel          labelGerman      = null;
    protected JLabel          labelCatalan     = null;

    // Textfields
    protected JTextArea       fieldSpanish     = null;
    protected JTextArea       fieldGallego     = null;
    protected JTextArea       fieldEnglish     = null;
    protected JTextArea       fieldPortuguese  = null;
    protected JTextArea       fieldChinese     = null;
    protected JTextArea       fieldFrances     = null;
    protected JTextArea       fieldGerman      = null;
    protected JTextArea       fieldCatalan     = null;

    protected JButton         btnTranslate     = null;
    protected JButton         btnClean         = null;


    protected TranslationsPanel(LayoutManager layout, Map<String, Object> params) {
        super(layout);

        this.init(params);

        this.addActionListeners();

        this.addValueChangeListeners();
    }


    public static TranslationsPanel newInstance(LayoutManager layout, Map<String, Object> params) {
        return new TranslationsPanel(layout, params);
    }


    protected void init(Map<String, Object> params) {

        this.initializeComponents();

        JPanel panel1 = this.createPanelHeader();
        JPanel panel2 = this.createPanelTranslations();
        JPanel panel3 = this.createPanelBotton();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(panel1);
        this.add(panel2);
        this.add(panel3);
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
        panel.add(this.labelCatalan, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        panel.add(this.fieldCatalan, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(this.labelPortuguese, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(this.fieldPortuguese, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(this.labelChinese, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        panel.add(this.fieldChinese, constraints);

        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(this.labelFrances, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        panel.add(this.fieldFrances, constraints);

        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(this.labelGerman, constraints);

        constraints.gridx = 1;
        constraints.gridy = 5;
        panel.add(this.fieldGerman, constraints);

        // Add the border
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
        this.labelCatalan = new JLabel(Constants.CATALAN);

        // Textfields
        int columns = 100;
        int rows = 2;
        this.fieldSpanish = new JTextArea(rows, columns);
        this.fieldEnglish = new JTextArea(rows, columns);

        this.fieldGallego = new JTextArea(rows, columns);
        this.fieldGallego.setEditable(false);
        this.fieldGallego.setBackground(Color.LIGHT_GRAY);

        this.fieldCatalan = new JTextArea(rows, columns);
        this.fieldCatalan.setEditable(false);
        this.fieldCatalan.setBackground(Color.LIGHT_GRAY);

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
                String translatorKey = TranslationSuppliersPanel.getInstance(null, null).getTranslatorKey();

                ICustomTranslator translator = AbstractTranslator.getTranslator(translatorKey);

                String spanishText = TranslationsPanel.this.fieldSpanish.getText();
                String englishText = TranslationsPanel.this.fieldEnglish.getText();

                if (spanishText == null) {
                    spanishText = "";
                }

                if ((englishText == null) || englishText.isEmpty()) {
                    String englishTranslation = translator.translate("es", "en", spanishText);
                    TranslationsPanel.this.fieldEnglish.setText(englishTranslation);
                    englishText = englishTranslation != null ? englishTranslation : "";
                }

                String gallegoTranslation = translator.translate("es", "gl", spanishText);
                String catalanTranslation = translator.translate("es", "ca", spanishText);
                String portugueseTranslation = translator.translate("es", "pt", spanishText);
                String franceTranslation = translator.translate("en", "fr", englishText);
                String chineseTranslation = translator.translate("en", "zh", englishText);
                String germanTranslation = translator.translate("en", "de", englishText);

                TranslationsPanel.this.fieldGallego.setText(gallegoTranslation);
                TranslationsPanel.this.fieldCatalan.setText(catalanTranslation);
                TranslationsPanel.this.fieldPortuguese.setText(portugueseTranslation);
                TranslationsPanel.this.fieldFrances.setText(franceTranslation);
                TranslationsPanel.this.fieldChinese.setText(chineseTranslation);
                TranslationsPanel.this.fieldGerman.setText(germanTranslation);

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

            TranslationsPanel.this.fieldSpanish.setText(null);
            TranslationsPanel.this.fieldEnglish.setText(null);
            TranslationsPanel.this.fieldGallego.setText(null);
            TranslationsPanel.this.fieldPortuguese.setText(null);
            TranslationsPanel.this.fieldFrances.setText(null);
            TranslationsPanel.this.fieldChinese.setText(null);
            TranslationsPanel.this.fieldGerman.setText(null);
            TranslationsPanel.this.fieldCatalan.setText(null);
        }
    }
}
