import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

public class Calculator implements MouseListener {

    private static final char addButton = '+';
    private static final char subButton = '-';
    private static final char mulButton = 'x';
    private static final char divButton = '÷';
    private static final char powerButton = '^';

    private static Double firstNumber = 0d;
    private static Double secondNumber = 0d;
    private static Double result = 0d;
    private static char operator;
    private static boolean clicked = false;
    private static boolean checkEqualButtonClicked = false;


    private Integer intCheck(Double num){
        Integer integer = num.intValue();
        if(integer  - num == 0) return integer;
        return null;
    } 

    private void setUserTextField(Double num){
        if(intCheck(num) !=null){
            CalculatorApp.userTextField.setText(String.valueOf(intCheck(num)));
        }else{
            CalculatorApp.userTextField.setText(String.valueOf(result));
        }
    }

    private void setEquationTextField(Double num){
       if(checkEqualButtonClicked){ // If equation already existed in textfield and user clicked equal button again methods sets text to result
            if(intCheck(num)!=null){
                CalculatorApp.equationTextField.setText(String.valueOf(intCheck(Double.valueOf(CalculatorApp.userTextField.getText()))));
            }else{
                CalculatorApp.equationTextField.setText(CalculatorApp.userTextField.getText());
            }
       }else{
        if(intCheck(num) !=null){
            CalculatorApp.equationTextField.setText(CalculatorApp.equationTextField.getText() + " " + intCheck(num));
        }else{
            CalculatorApp.equationTextField.setText(CalculatorApp.equationTextField.getText() + " " + secondNumber);
        }
       }
    }
    @Override
    public void mouseClicked(MouseEvent e) {

        JButton button = (JButton) e.getSource();
        if (!clicked) { // Remove the zero at begining after first click
            clicked = true;
            CalculatorApp.userTextField.setText(" ");
        }

        for (int i = 0; i < 10; i++) {
            if (e.getSource() == CalculatorApp.numButtons[i]) {
                CalculatorApp.userTextField
                        .setText(CalculatorApp.userTextField.getText() + CalculatorApp.numButtons[i].getText());
            }
        }
        try {

            if (e.getSource() == CalculatorApp.addButton || e.getSource() == CalculatorApp.subButton
                    || e.getSource() == CalculatorApp.multiplyButton || e.getSource() == CalculatorApp.divideButton) {
                firstNumber = Double.parseDouble(CalculatorApp.userTextField.getText());

                if (e.getSource() == CalculatorApp.addButton)
                    operator = addButton;
                if (e.getSource() == CalculatorApp.subButton)
                    operator = subButton;
                if (e.getSource() == CalculatorApp.multiplyButton)
                    operator = mulButton;
                if (e.getSource() == CalculatorApp.divideButton)
                    operator = divButton;

                checkEqualButtonClicked = false;
                CalculatorApp.equationTextField.setText(CalculatorApp.userTextField.getText() +" "+ button.getText());
                CalculatorApp.userTextField.setText(" ");

            }

            if (e.getSource() == CalculatorApp.decimalButton) {
                CalculatorApp.userTextField.setText(CalculatorApp.userTextField.getText().concat("."));
            }

            if (e.getSource() == CalculatorApp.clearButton) {
                CalculatorApp.userTextField.setText(" ");
                CalculatorApp.equationTextField.setText(" ");
            }

            if (e.getSource() == CalculatorApp.powerButton) {
                firstNumber = Double.parseDouble(CalculatorApp.userTextField.getText());
                operator = powerButton;
                CalculatorApp.userTextField.setText(" ");

            }

            if (e.getSource() == CalculatorApp.squareRootButton) {
                firstNumber = Double.parseDouble(CalculatorApp.userTextField.getText());
                result = Math.sqrt(firstNumber);
                CalculatorApp.userTextField.setText(String.valueOf(result));

            }

            if (e.getSource() == CalculatorApp.delButton) {
                String text = CalculatorApp.userTextField.getText();
                CalculatorApp.userTextField.setText(" ");
                for (int i = 0; i < text.length() - 1; i++) {
                    CalculatorApp.userTextField.setText(CalculatorApp.userTextField.getText() + text.charAt(i));
                }
            }
            if (e.getSource() == CalculatorApp.equalButton) {

                secondNumber = Double.parseDouble(CalculatorApp.userTextField.getText());
                setEquationTextField(secondNumber);
                checkEqualButtonClicked = true;
                switch (operator) {

                    case addButton:
                        result = firstNumber + secondNumber;
                        break;
                    case subButton:
                        result = firstNumber - secondNumber;
                        break;
                    case mulButton:
                        result = firstNumber * secondNumber;
                        break;
                    case divButton:
                        result = firstNumber / secondNumber;
                        break;

                    case powerButton:
                        result = Math.pow(firstNumber, secondNumber);
                        break;
                }
                
                setUserTextField(result);
                
            }

        } catch (Exception e1) {
            if (e.getSource() == CalculatorApp.addButton)
                operator = addButton;
            if (e.getSource() == CalculatorApp.subButton)
                operator = subButton;
            if (e.getSource() == CalculatorApp.multiplyButton)
                operator = mulButton;
            if (e.getSource() == CalculatorApp.divideButton)
                operator = divButton;

            CalculatorApp.userTextField.setText(" ");
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == CalculatorApp.equalButton)
            button.setBackground(new Color(153, 204, 255));
        else
            button.setBackground(new Color(21, 30, 41));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        JButton button = (JButton) e.getSource();
        if (button == CalculatorApp.equalButton)
            button.setBackground(CalculatorApp.equalButtonColor);
        else if (button == CalculatorApp.addButton || button == CalculatorApp.subButton ||
                button == CalculatorApp.multiplyButton || button == CalculatorApp.divideButton)
            button.setBackground(CalculatorApp.operatorButtonColor);

        else
            button.setBackground(CalculatorApp.buttonColor);

    }

}