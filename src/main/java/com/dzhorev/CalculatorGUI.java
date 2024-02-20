package com.dzhorev;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class CalculatorGUI implements ActionListener {

  private JFrame calculatorFrame;
  private JTextField textField;
  private List<JButton> numbersButtons = new ArrayList<>();
  private JButton addButton, subtractButton, multiplyButton, divideButton,
                  decimalButton, equalsButton, deleteButton, clearButton;
  private List<JButton> functionButtons = new ArrayList<>();
  private Font calculatorFont = new Font("TlwgTypewriter", Font.BOLD, 30);
  private JPanel calculatorPanel;
  private double number1;
  private double number2;
  private double result;
  private char operator;

  CalculatorGUI() {
    Calculator();
  }

  public void Calculator() {
    calculatorFrame = new JFrame("Calculator");
    calculatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    calculatorFrame.setSize(420, 550);
    calculatorFrame.setLayout(null);

    addButton = new JButton("+");
    subtractButton = new JButton("-");
    multiplyButton = new JButton("*");
    divideButton = new JButton("/");
    decimalButton = new JButton(".");
    equalsButton = new JButton("=");
    deleteButton = new JButton("Delete");
    clearButton = new JButton("Clear");

    functionButtons.add(addButton);
    functionButtons.add(subtractButton);
    functionButtons.add(multiplyButton);
    functionButtons.add(divideButton);
    functionButtons.add(decimalButton);
    functionButtons.add(equalsButton);
    functionButtons.add(deleteButton);
    functionButtons.add(clearButton);

    for (JButton currentButton : functionButtons) {
      currentButton.addActionListener(this);
      currentButton.setFont(calculatorFont);
      currentButton.setFocusable(false);
    }

    for (int i = 0; i < 10; i++) {
      JButton button = new JButton(String.valueOf(i));
      numbersButtons.add(button);
      button.addActionListener(this);
      button.setFont(calculatorFont);
      button.setFocusable(false);
    }

    deleteButton.setBounds(50, 430, 145, 50);
    clearButton.setBounds(205, 430, 145, 50);

    calculatorPanel = new JPanel();
    calculatorPanel.setBounds(50, 100, 300, 300);
    calculatorPanel.setLayout(new GridLayout(4, 4, 10, 10));

    textField = new JTextField();
    textField.setBounds(50, 25, 300, 50);
    textField.setFont(calculatorFont);
    textField.setEditable(false);
    calculatorPanel.add(numbersButtons.get(1));
    calculatorPanel.add(numbersButtons.get(2));
    calculatorPanel.add(numbersButtons.get(3));
    calculatorPanel.add(addButton);
    calculatorPanel.add(numbersButtons.get(4));
    calculatorPanel.add(numbersButtons.get(5));
    calculatorPanel.add(numbersButtons.get(6));
    calculatorPanel.add(subtractButton);
    calculatorPanel.add(numbersButtons.get(7));
    calculatorPanel.add(numbersButtons.get(8));
    calculatorPanel.add(numbersButtons.get(9));
    calculatorPanel.add(multiplyButton);
    calculatorPanel.add(decimalButton);
    calculatorPanel.add(numbersButtons.get(0));
    calculatorPanel.add(equalsButton);
    calculatorPanel.add(divideButton);
    calculatorFrame.add(calculatorPanel);
    calculatorFrame.add(deleteButton);
    calculatorFrame.add(clearButton);
    calculatorFrame.add(textField);
    calculatorFrame.setVisible(true);

  }

  @java.lang.Override
  public void actionPerformed(ActionEvent e) {
    JButton sourceButton = (JButton) e.getSource();

    if (sourceButton == addButton || sourceButton == subtractButton ||
        sourceButton == multiplyButton || sourceButton == divideButton) {
      operator = sourceButton.getText().charAt(0);
      number1 = Double.parseDouble(textField.getText());
      textField.setText("");
    } else if (sourceButton == equalsButton) {
      number2 = Double.parseDouble(textField.getText());
      double result = CalculatorLogic.performOperation(number1, number2, operator);
      textField.setText(String.valueOf(result));
      number1 = result;
    } else if (sourceButton == clearButton) {
      textField.setText("");
    } else if (sourceButton == deleteButton) {
      String textFieldText = textField.getText();
      if (textFieldText.length() > 0) {
        textField.setText(textFieldText.substring(0, textFieldText.length() - 1));
      }
    } else {
      textField.setText(textField.getText() + sourceButton.getText());
    }
  }
}

