package com.tobio.translator.frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import com.tobio.translator.interfaces.ICustomTranslator;
import com.tobio.translator.translators.AbstractTranslator;
import com.tobio.translator.utils.Constants;
import com.tobio.translator.utils.ImageUtils;

public class TranslationsPanel extends JPanel {

    private static final long                     serialVersionUID       = 1L;

    protected JPanel                              panelTranslationsHeader;
    protected JPanel                              panelTranslations;

    // Labels
    protected JLabel                              labelSpanish           = new JLabel(Constants.SPANISH);
    protected JLabel                              labelGallego           = new JLabel(Constants.GALLEGO);
    protected JLabel                              labelEnglish           = new JLabel(Constants.ENGLISH);
    protected JLabel                              labelPortuguese        = new JLabel(Constants.PORTUGUES);
    protected JLabel                              labelChinese           = new JLabel(Constants.CHINO);
    protected JLabel                              labelFrances           = new JLabel(Constants.FRANCES);
    protected JLabel                              labelGerman            = new JLabel(Constants.GERMAN);
    protected JLabel                              labelCatalan           = new JLabel(Constants.CATALAN);

    // Textfields
    protected JTextArea                           fieldSpanish           = new JTextArea();
    protected JTextArea                           fieldGallego           = new JTextArea();
    protected JTextArea                           fieldEnglish           = new JTextArea();
    protected JTextArea                           fieldPortuguese        = new JTextArea();
    protected JTextArea                           fieldChinese           = new JTextArea();
    protected JTextArea                           fieldFrances           = new JTextArea();
    protected JTextArea                           fieldGerman            = new JTextArea();
    protected JTextArea                           fieldCatalan           = new JTextArea();

    protected transient List<PanelTranslationRow> translationsPanelsList = new ArrayList<>();

    protected JButton                             btnTranslate           = null;
    protected JButton                             btnClean               = null;

    protected Point                               pPoint;
    protected MouseEvent                          mouseEventPressed;


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

        this.panelTranslationsHeader = this.createPanelTranslationsHeader();
        this.panelTranslations = this.createPanelTranslations();
        JPanel panel3 = this.createPanelBotton();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(this.panelTranslationsHeader);
        this.add(this.panelTranslations);
        this.add(panel3);
    }


    protected JPanel createPanelBotton() {

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(this.btnTranslate, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.EAST;
        panel.add(this.btnClean, constraints);
        return panel;
    }


    protected JPanel createPanelTranslations() {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.translationsPanelsList.add(new PanelTranslationRow(this.labelGallego, this.fieldGallego, 0));
        this.translationsPanelsList.add(new PanelTranslationRow(this.labelCatalan, this.fieldCatalan, 1));
        this.translationsPanelsList.add(new PanelTranslationRow(this.labelPortuguese, this.fieldPortuguese, 2));
        this.translationsPanelsList.add(new PanelTranslationRow(this.labelChinese, this.fieldChinese, 3));
        this.translationsPanelsList.add(new PanelTranslationRow(this.labelFrances, this.fieldFrances, 4));
        this.translationsPanelsList.add(new PanelTranslationRow(this.labelGerman, this.fieldGerman, 5));

        this.translationsPanelsList = this.sortPanelTranslations();
        for (PanelTranslationRow jPanel : this.translationsPanelsList) {
            panel.add(jPanel);
        }

        // Add the border
        TitledBorder border = new TitledBorder("Traducciones");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        border.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        panel.setBorder(border);

        return panel;
    }

    class MouseMotionListener implements java.awt.event.MouseMotionListener {

        protected JPanel panel;


        public MouseMotionListener(JPanel panel) {
            this.panel = panel;
        }


        @Override
        public void mouseDragged(MouseEvent e) {
            if (e.getSource() == this.panel) {
                TranslationsPanel.this.pPoint = this.panel.getLocation(TranslationsPanel.this.pPoint);
                int x = (TranslationsPanel.this.pPoint.x - TranslationsPanel.this.mouseEventPressed.getX()) + e.getX();
                int y = (TranslationsPanel.this.pPoint.y - TranslationsPanel.this.mouseEventPressed.getY()) + e.getY();
                this.panel.setLocation(x, y);
            }
        }


        @Override
        public void mouseMoved(MouseEvent e) {
            // TODO Auto-generated method stub

        }

    }

    class TranslationsMouseListener implements MouseListener {

        protected JPanel panel;


        public TranslationsMouseListener(JPanel panel) {
            this.panel = panel;
        }


        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getSource() == this.panel) {
                TranslationsPanel.this.mouseEventPressed = e;
            }
        }


        @Override
        public void mouseClicked(MouseEvent e) {}


        @Override
        public void mouseEntered(MouseEvent e) {}


        @Override
        public void mouseExited(MouseEvent e) {}


        @Override
        public void mouseReleased(MouseEvent e) {}

    }


    protected JPanel createPanelTranslationsHeader() {

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        panel.add(new PanelTranslationRow(this.labelSpanish, this.fieldSpanish, 0));
        panel.add(new PanelTranslationRow(this.labelEnglish, this.fieldEnglish, 1));

        TitledBorder border = new TitledBorder("Traducir ");
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        border.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        panel.setBorder(border);
        return panel;
    }


    protected void initializeComponents() {

        int width = 70;
        int height = 50;

        // Labels
        List<JLabel> jLabelList = Arrays.asList(this.labelSpanish, this.labelGallego, this.labelEnglish, this.labelPortuguese, this.labelChinese, this.labelFrances, this.labelGerman,
                this.labelCatalan);
        for (JLabel jLabel : jLabelList) {
            jLabel.setPreferredSize(new Dimension(width, height));
        }

        // Textfields
        int columns = 100;
        int rows = 2;

        this.fieldSpanish = new JTextArea(rows, columns);
        this.fieldEnglish = new JTextArea(rows, columns);

        List<JTextArea> jTextAreaList = Arrays.asList(this.fieldGallego, this.fieldCatalan, this.fieldPortuguese, this.fieldChinese, this.fieldFrances, this.fieldGerman);
        for (JTextArea jTextArea : jTextAreaList) {
            jTextArea.setRows(rows);
            jTextArea.setColumns(columns);
            jTextArea.setEditable(false);
            jTextArea.setBackground(Color.LIGHT_GRAY);
        }

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

    class PanelTranslationRow extends JPanel {

        private static final long serialVersionUID = 1L;

        protected JLabel          label;
        protected JTextArea       jTextArea;
        protected JButton         buttonUp         = new JButton();
        protected JButton         buttonDown       = new JButton();
        protected JButton         buttonCopy       = new JButton();

        protected int             order            = 0;


        public PanelTranslationRow(JLabel label, JTextArea jTextArea, int order) {
            super(new GridBagLayout());

            this.label = label;
            this.jTextArea = jTextArea;
            this.order = order;

            this.init();
        }


        protected void init() {
            this.createPanel();

            this.addActionListeners();
        }


        protected void addMouseListeners() {

            // this.addMouseListener(new TranslationsMouseListener(this));
            // this.addMouseMotionListener(new MouseMotionListener(this));
        }


        protected void addActionListeners() {

            this.buttonUp.addActionListener(new ButtonUpActionListener());
            this.buttonDown.addActionListener(new ButtonDownActionListener());
            this.buttonCopy.addActionListener(new ButtonCopyToClipBoardActionListener());
        }


        protected void createPanel() {

            JPanel panelButtons = this.createPanelArrowsButtons();
            JPanel panelButtonCopy = this.createButtonCopy();

            GridBagConstraints constraints = new GridBagConstraints();
            constraints.anchor = GridBagConstraints.WEST;
            constraints.insets = new Insets(10, 10, 10, 10);

            constraints.gridx = 0;
            constraints.gridy = 0;
            this.add(this.label, constraints);

            if (!this.label.getText().equals(Constants.SPANISH) && !this.label.getText().equals(Constants.ENGLISH)) {
                constraints.gridx = 1;
                constraints.gridy = 0;
                this.add(panelButtons, constraints);
            }

            constraints.gridx = 2;
            constraints.gridy = 0;
            this.add(panelButtonCopy, constraints);

            constraints.gridx = 3;
            constraints.gridy = 0;
            this.add(this.jTextArea, constraints);

        }


        protected JPanel createButtonCopy() {

            JPanel panel = new JPanel(new GridBagLayout());

            int width = 24;
            int heigth = 24;
            this.buttonCopy.setPreferredSize(new Dimension(width, heigth));

            Icon iconCopy = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource(ImageUtils.ICON_COPY2));
            this.buttonCopy.setIcon(iconCopy);

            this.buttonCopy.setBorder(null);
            this.buttonCopy.setContentAreaFilled(true);
            this.buttonCopy.setBorderPainted(false);
            panel.add(this.buttonCopy);

            return panel;
        }


        protected JPanel createPanelArrowsButtons() {

            JPanel panel = new JPanel(new GridBagLayout());
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

            Icon iconArrowUp = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource(ImageUtils.IMAGE_ARROW_UP));
            Icon iconArrowDown = new ImageIcon(Thread.currentThread().getContextClassLoader().getResource(ImageUtils.IMAGE_ARROW_DOWN));

            this.buttonUp.setIcon(iconArrowUp);
            this.buttonDown.setIcon(iconArrowDown);

            this.buttonUp.setBorder(null);
            this.buttonUp.setContentAreaFilled(true);
            this.buttonUp.setBorderPainted(false);
            this.buttonDown.setBorder(null);
            this.buttonDown.setContentAreaFilled(true);
            this.buttonDown.setBorderPainted(false);

            int width = 14;
            int heigth = 14;
            this.buttonUp.setPreferredSize(new Dimension(width, heigth));
            this.buttonDown.setPreferredSize(new Dimension(width, heigth));

            this.buttonUp.setBorder(null);
            this.buttonDown.setBorder(null);

            panel.add(this.buttonUp);
            panel.add(this.buttonDown);

            return panel;
        }


        public int getOrder() {
            return this.order;
        }


        public void setOrder(int order) {
            this.order = order;
        }

        class ButtonUpActionListener implements ActionListener {

            public ButtonUpActionListener() {

            }


            @Override
            public void actionPerformed(ActionEvent e) {
                TranslationsPanel.this.decrementOrder(PanelTranslationRow.this);
            }
        }

        class ButtonDownActionListener implements ActionListener {

            public ButtonDownActionListener() {

            }


            @Override
            public void actionPerformed(ActionEvent e) {
                TranslationsPanel.this.incrementOrder(PanelTranslationRow.this);
            }
        }


        @Override
        public String toString() {
            return this.label.getText() + ", Order --> " + this.order + "\n";
        }

        class ButtonCopyToClipBoardActionListener implements ActionListener {

            public ButtonCopyToClipBoardActionListener() {
                // Empty
            }


            @Override
            public void actionPerformed(ActionEvent e) {

                String ctc = PanelTranslationRow.this.jTextArea.getText();
                StringSelection stringSelection = new StringSelection(ctc);
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
            }
        }
    }


    protected void incrementOrder(PanelTranslationRow panel) {

        int index = this.translationsPanelsList.indexOf(panel);

        int size = this.translationsPanelsList.size();
        for (int i = 0; i < size; i++) {
            if (i == index) {
                panel.setOrder(panel.getOrder() + 1);
            }
            if (i == (index + 1)) {
                this.translationsPanelsList.get(i).setOrder(this.translationsPanelsList.get(i).getOrder() - 1);
            }
        }
        this.normalizeOrder();
        this.customRepaint();
    }


    protected void decrementOrder(PanelTranslationRow panel) {

        int index = this.translationsPanelsList.indexOf(panel);

        int size = this.translationsPanelsList.size();
        for (int i = 0; i < size; i++) {
            if (i == index) {
                panel.setOrder(panel.getOrder() - 1);
            }
            if (i == (index - 1)) {
                this.translationsPanelsList.get(i).setOrder(this.translationsPanelsList.get(i).getOrder() + 1);
            }
        }
        this.normalizeOrder();
        this.customRepaint();
    }


    private void normalizeOrder() {

        this.translationsPanelsList = this.sortPanelTranslations();
        int size = this.translationsPanelsList.size();
        for (int i = 0; i < size; i++) {
            this.translationsPanelsList.get(i).setOrder(i);
        }
    }


    protected List<PanelTranslationRow> sortPanelTranslations() {
        return this.translationsPanelsList.stream().sorted(Comparator.comparing(PanelTranslationRow::getOrder)).collect(Collectors.toList());
    }


    protected void customRepaint() {

        this.panelTranslations.removeAll();

        this.translationsPanelsList = this.sortPanelTranslations();

        for (PanelTranslationRow jPanel : this.translationsPanelsList) {
            this.panelTranslations.add(jPanel);
        }

        AppMainPanel.getInstance(null).changeState(States.MENU_TRANSLATIONS_STATE);
    }
}
