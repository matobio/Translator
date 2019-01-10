package com.tobio.translator.frames;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import com.tobio.translator.utils.Constants;

public class TranslationSuppliersPanel extends JPanel {

    private static final long                  serialVersionUID = 1L;

    protected static TranslationSuppliersPanel instance;

    protected ButtonGroup                      buttonGroup      = new ButtonGroup();

    protected JRadioButton                     btnGoogle        = new JRadioButton(Constants.KEY_GOOGLE_API_TRANSLATOR);

    protected transient List<JRadioButton>     buttonList       = new ArrayList<>();


    protected TranslationSuppliersPanel(LayoutManager layout, Map<String, Object> params) {
        super(layout);

        this.init(params);

    }


    public static TranslationSuppliersPanel getInstance(LayoutManager layout, Map<String, Object> params) {
        if (TranslationSuppliersPanel.instance == null) {
            TranslationSuppliersPanel.instance = new TranslationSuppliersPanel(layout, params);
        }
        return TranslationSuppliersPanel.instance;
    }


    protected void init(Map<String, Object> params) {

        this.initializeComponents();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panel1 = this.createPanel();

        this.add(panel1);

    }


    protected JPanel createPanel() {

        JPanel panel1 = new JPanel(new GridBagLayout());

        // Add buttons to group
        this.buttonGroup.add(this.btnGoogle);

        // Add the buttons
        panel1.add(this.btnGoogle);

        // Set the panel border
        TitledBorder border = new TitledBorder(Constants.PROVEDORES);
        border.setTitleJustification(TitledBorder.LEFT);
        border.setTitlePosition(TitledBorder.TOP);
        border.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));

        panel1.setBorder(border);

        return panel1;
    }


    protected void initializeComponents() {

        this.buttonList.add(this.btnGoogle);

        this.btnGoogle.setSelected(true);

    }


    public List<JRadioButton> getButtonList() {
        return this.buttonList;
    }


    public String getTranslatorKey() {

        for (JRadioButton button : this.buttonList) {
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
}
