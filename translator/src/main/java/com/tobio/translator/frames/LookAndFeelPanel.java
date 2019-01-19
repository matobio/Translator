package com.tobio.translator.frames;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import com.tobio.translator.lookandfeels.LookAndFeelUtils;
import com.tobio.translator.utils.Constants;

public class LookAndFeelPanel extends JPanel {

    private static final long          serialVersionUID   = 1L;

    protected JList<String>            list               = new JList<>();
    protected DefaultListModel<String> listModel          = new DefaultListModel<>();

    protected JButton                  buttonApply        = new JButton(Constants.APPLY);
    protected JButton                  buttonApplyDefault = new JButton(Constants.DEFAULT);


    protected LookAndFeelPanel(LayoutManager layout, Map<String, Object> params) {
        super(layout);

        this.init(params);

        this.addActionListeners();

    }


    public static LookAndFeelPanel newInstance(LayoutManager layout, Map<String, Object> params) {
        return new LookAndFeelPanel(layout, params);
    }


    protected void addActionListeners() {

        this.buttonApply.addActionListener(new ButtonApplyActionListener());

        this.buttonApplyDefault.addActionListener(ev -> {
            LookAndFeelUtils.getInstance().changeLookAndFeel(LookAndFeelUtils.getDefaultLookAndFeel());
        });
    }


    protected void init(Map<String, Object> params) {

        this.initializeComponents();

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JPanel panel = this.createPanel();

        this.add(panel);
    }


    protected JPanel createPanel() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout());

        JScrollPane listScroller = new JScrollPane(this.list);
        listScroller.setPreferredSize(new Dimension(250, 80));

        JPanel panel2 = this.createPanelRight();

        panel.add(listScroller);
        panel.add(panel2);
        return panel;
    }


    protected JPanel createPanelRight() {

        JPanel panel = new JPanel(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(this.buttonApplyDefault, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.anchor = GridBagConstraints.WEST;
        panel.add(this.buttonApply, constraints);

        return panel;
    }


    protected void initializeComponents() {

        this.initizliceList();

        this.initialiceButtons();

    }


    protected void initialiceButtons() {

        this.buttonApply.setPreferredSize(new Dimension(100, 40));
        this.buttonApply.setMaximumSize(new Dimension(100, 40));

        this.buttonApplyDefault.setPreferredSize(new Dimension(100, 40));
        this.buttonApplyDefault.setMaximumSize(new Dimension(100, 40));

    }


    protected void initizliceList() {

        this.addListElements();

        this.list = new JList<>(this.listModel);
        this.list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.list.setLayoutOrientation(JList.VERTICAL);
        this.list.setVisibleRowCount(3);
    }


    protected void addListElements() {

        for (String element : LookAndFeelUtils.getListLookAndFeelUtils()) {
            this.listModel.addElement(element);
        }
    }

    class ButtonApplyActionListener implements ActionListener {

        public ButtonApplyActionListener() {

        }


        @Override
        public void actionPerformed(ActionEvent e) {

            String selectedLookAndFeel = LookAndFeelPanel.this.list.getSelectedValue();

            if (selectedLookAndFeel != null) {
                LookAndFeelUtils.getInstance().changeLookAndFeel(selectedLookAndFeel);
            }

        }

    }
}
