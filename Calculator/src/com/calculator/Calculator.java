package com.calculator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;

public class Calculator extends JFrame implements ActionListener {
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[13];
    JButton addButton, subButton, mulButton, divButton, cosButton, sinButton, logButton;
    JButton decButton, equButton, delButton, clrButton, negButton, powButton;
    JPanel panel;
    String message = "";

    // Define customized font
    Font myFont = new Font("Ink Free", Font.BOLD, 26);

    //formatting values
    DecimalFormat df = new DecimalFormat("#.###");

    double num1 = 0, num2 = 0, result = 0;
    char operator;

    Calculator() {
        // Frame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(420, 550);
        setLayout(null);
        setTitle("Functional Calculator");
        getContentPane().setBackground(new Color(5, 65, 90));

        // Set icon for application
        Image icon = Toolkit.getDefaultToolkit().getImage("");
        setIconImage(icon);

        // Text field settings
        textfield = new JTextField();
        textfield.setBounds(50, 25, 300, 60);
        textfield.setFont(myFont);
        textfield.setEditable(false);
        textfield.setBackground(Color.WHITE);

        // Creating new JButtons
        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Del");
        clrButton = new JButton("Clr");
        negButton = new JButton("(-)");
        cosButton = new JButton("cos");
        sinButton = new JButton("sin");
        logButton = new JButton("log");
        powButton = new JButton("^");

        // Assigning JButtons to functions
        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;
        functionButtons[8] = negButton;
        functionButtons[9] = cosButton;
        functionButtons[10] = sinButton;
        functionButtons[11] = logButton;
        functionButtons[12] = powButton;

        for (int i = 0; i < functionButtons.length; i++) {
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }

        for (int i = 0; i < numberButtons.length; i++) {
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        // Define below buttons separately
        negButton.setBounds(50, 430, 100, 50);
        delButton.setBounds(150, 430, 100, 50);
        clrButton.setBounds(250, 430, 100, 50);

        // Panel settings
        panel = new JPanel();
        panel.setBounds(50, 100, 300, 300);
        panel.setLayout(new GridLayout(5, 5, 10, 10));
        panel.setBackground(Color.ORANGE);
        panel.setName("Functional Calculator");

        // Adding all buttons to the panel
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton);
        panel.add(divButton);
        panel.add(cosButton);
        panel.add(sinButton);
        panel.add(logButton);
        panel.add(powButton);

        // Adding panel and additional 4 Buttons to the frame
        add(panel);
        add(negButton);
        add(delButton);
        add(clrButton);
        add(textfield);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Assigning operators and making calculations based on the operator
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == numberButtons[i]) {
                textfield.setText(textfield.getText().concat(String.valueOf(i)));
            }
        }
        try {
            if (!textfield.getText().equals("")) {
                if (e.getSource() == decButton) {
                    textfield.setText(textfield.getText().concat("."));
                }
                if (e.getSource() == addButton) {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '+';
                    textfield.setText("");
                }
                if (e.getSource() == subButton) {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '-';
                    textfield.setText("");
                }
                if (e.getSource() == mulButton) {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '*';
                    textfield.setText("");
                }
                if (e.getSource() == divButton) {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '/';
                    textfield.setText("");
                }
                if (e.getSource() == cosButton) {
                    num1 = Double.parseDouble(textfield.getText());
                    double c = Math.toRadians(num1);
                    result = Math.cos(c);
                    textfield.setText(String.valueOf(df.format(result)));
                }
                if (e.getSource() == sinButton) {
                    num1 = Double.parseDouble(textfield.getText());
                    double c = Math.toRadians(num1);
                    result = Math.sin(c);
                    textfield.setText(String.valueOf(df.format(result)));
                }
                if (e.getSource() == logButton) {
                    num1 = Double.parseDouble(textfield.getText());
                    result = Math.log(num1);
                    textfield.setText(String.valueOf(df.format(result)));
                }
                if (e.getSource() == powButton) {
                    num1 = Double.parseDouble(textfield.getText());
                    operator = '^';
                    textfield.setText("");
                }
                if (e.getSource() == equButton) {
                    num2 = Double.parseDouble(textfield.getText());
                    message = "";

                    switch (operator) {
                        case '+':
                            result = num1 + num2;
                            break;
                        case '-':
                            result = num1 - num2;
                            break;
                        case '*':
                            result = num1 * num2;
                            break;
                        case '/':
                            if (num2 == 0) {
                                JOptionPane.showMessageDialog(this, "Please don't use 0 as division number", "E R R O R: / by zero", JOptionPane.WARNING_MESSAGE);
                                textfield.setText("");
                                textfield.repaint();
                            }
                            result = num1 / num2;
                            break;
                        case '^':
                            result = Math.pow(num1,num2);
                            break;
                    }
                    textfield.setText(String.valueOf(df.format(result)));
                    num1 = result; // if we want to continue with this number to calculations
                }
                if (e.getSource() == clrButton) {
                    textfield.setText("");
                }
                if (e.getSource() == delButton) {  // It will delete the last item by each click until nothing left
                    String str = textfield.getText();
                    textfield.setText("");
                    for (int i = 0; i < str.length() - 1; i++) {
                        String strnew = str.substring(0, str.length() - 1);
                        textfield.setText(strnew);
                    }
                }
                if (e.getSource() == negButton) {  // get the number and make it negative by multiplying with -1
                    double temp = Double.parseDouble(textfield.getText());
                    temp *= -1;
                    textfield.setText(String.valueOf(temp));
                }
            } else if (textfield.getText().equals("")) { //In case the user doesn't enter any valid number
                JOptionPane.showMessageDialog(this, "Please enter any number!", "Attention", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception exception) {
            message = exception.getMessage();
            JOptionPane.showMessageDialog(this, message);
        }
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
    }
}
