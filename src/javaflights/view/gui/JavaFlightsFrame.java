package javaflights.view.gui;

import javaflights.controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JavaFlightsFrame extends JFrame {
    private JLabel jlFrom = new JLabel("From:");
    private JLabel jlTo = new JLabel("To:");
    private JLabel jlWhen = new JLabel("When:");
    private JTextField jtfFrom = new JTextField("Moscow");
    private JTextField jtfTo = new JTextField("Saint_Petersburg");
    private JFormattedTextField jftf = new JFormattedTextField(new FlightDateMask(2006,11-1,20));
    private JButton search = new JButton("Search");
    private JButton reset = new JButton("Reset");
    private JTextArea found = new JTextArea("Found");

    public JavaFlightsFrame() {
        super("Java Flights Frame");
        setSize(500, 350);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initUI();
        initListeners();
    }

    private void initUI() {

        Container contentPane = getContentPane();
        JPanel rootJPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        JPanel jpTop = new JPanel(new GridLayout(3, 2, 10, 10));
        JPanel jpBut = new JPanel(new GridLayout(3, 5, 0, 0));
        JPanel jpText = new JPanel(new GridLayout(1, 1, 10, 10));
        jpTop.add(jlFrom);
        jpTop.add(jtfFrom);
        jpTop.add(jlTo);
        jpTop.add(jtfTo);
        jpTop.add(jlWhen);
        jpTop.add(jftf);
        for (int i = 0; i < 6; i++) {
            jpBut.add(new JPanel());
        }
        jpBut.add(search);
        jpBut.add(new JPanel());
        jpBut.add(reset);
        for (int i = 0; i < 6; i++) {
            jpBut.add(new JPanel());
        }
        jpText.add(found);

        rootJPanel.add(jpTop);
        rootJPanel.add(jpBut);
        rootJPanel.add(jpText);
        contentPane.add(rootJPanel);
    }

    public Insets getInsets() {
        return new Insets(40, 20, 20, 20);
    }

    private void initListeners() {
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jtfFrom.setText("");
                jtfTo.setText("");
                jftf.setText(new FlightDateMask(2006,11,20).toString());
                found.setText("");
            }
        }
        );
        search.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                found.setText(Controller.findFlightsByFromToDate(jtfFrom.getText(), jtfTo.getText(), jftf.getText()));
            }
        }
        );
    }
}

