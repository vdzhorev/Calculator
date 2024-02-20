package com.dzhorev;

public class CalculatorLogic {

  private double number1;
  private double number2;
  private double result;
  private char operator;

  public static double performOperation(double number1, double number2, char operator) {
    switch (operator) {
      case '+':
        return number1 + number2;
      case '-':
        return number1 - number2;
      case '*':
        return number1 * number2;
      case '/':
        if (number2 != 0) {
          return number1 / number2;
        }else {
          throw new ArithmeticException("Cannot divide by 0!");
        }
      default:
        throw new IllegalArgumentException("Invalid operator");
    }
  }

}
