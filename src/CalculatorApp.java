import javax.swing.*;

import java.awt.*;

public class CalculatorApp extends JFrame {

    private final int HEIGHT = 700;
    private final int WIDTH = 600;

    // Main Frame
    private JFrame mainFrame;

    // Number Buttons
    final int sizeOfNumberButtons = 10;
    static JButton[] numButtons;

    // Button Panel
    private JPanel buttonPanel;
    
    // TextField Panel
    private JPanel textPanel;
    
    // Textfields
    private final int textFieldHeight = 175;
    static JTextField equationTextField;
    static JTextField userTextField;
    
    //Colors
    private final Color userTextFieldFontColor = Color.white;
    private final Color buttonPanelColor = new Color(10, 15, 21);
    private final Color textFieldColor = new Color(10, 15, 21);
    static  final Color operatorButtonColor = new Color(20, 25, 31);
    static  final Color equalButtonColor = new Color(102,178,255);
    static  final Color buttonColor = new Color(10, 15, 21);
    static  final Color buttonTextColor = Color.white;

    // Text font
    private final Font userTextFieldFont = new Font("Roboto", Font.PLAIN, 50);
    private final Font textFont = new Font("Roboto", Font.PLAIN, 26);

    // Operator Buttons
    String[] buttonLabels = { "+", "-", "x", "÷", "C", "Delete", ",", "=", "x^n", "√x", " " };
    private final int numberOfOperators = buttonLabels.length;
    static JButton[] operatorButtons;
    static JButton addButton, subButton, multiplyButton,
        divideButton, clearButton, delButton, decimalButton, equalButton, powerButton, squareRootButton;

    CalculatorApp() {

        // Initialize components
        operatorButtons();
        numberButtons();
        textFieldPanel();
        buttonPanel();

        setUpMainFrame();

    }

    private void operatorButtons() {

        operatorButtons = new JButton[numberOfOperators];
        for (int i = 0; i < numberOfOperators; i++) {
            operatorButtons[i] = new JButton(buttonLabels[i]);
            operatorButtons[i].setFont(textFont);
            operatorButtons[i].setFocusable(false);
            operatorButtons[i].setBackground(buttonColor);
            operatorButtons[i].setForeground(buttonTextColor);
            operatorButtons[i].setBorder(null);
            operatorButtons[i].addMouseListener(new Calculator());
            operatorButtons[i].setBorder(new ButtonBorders(0));
        }

        // Initialize Buttons
        addButton = operatorButtons[0];
        subButton = operatorButtons[1];
        multiplyButton = operatorButtons[2];
        divideButton = operatorButtons[3];
        clearButton = operatorButtons[4];
        delButton = operatorButtons[5];
        decimalButton = operatorButtons[6];
        equalButton = operatorButtons[7];
        powerButton = operatorButtons[8];
        squareRootButton = operatorButtons[9];

        addButton.setBackground(operatorButtonColor);
        subButton.setBackground(operatorButtonColor);
        multiplyButton.setBackground(operatorButtonColor);
        divideButton.setBackground(operatorButtonColor);
        equalButton.setBackground(equalButtonColor);

    }

    private void textFieldPanel() {
        textPanel = new JPanel();
        userTextField();
        equationTextField();
        textPanel.setBackground(buttonColor);
        textPanel.setLayout(new BorderLayout());
        textPanel.add(userTextField ,BorderLayout.CENTER);
        textPanel.add(equationTextField, BorderLayout.SOUTH);
    }


    private void equationTextField(){
        equationTextField = new JTextField();
        equationTextField.setFocusable(false);
        equationTextField.setFont(textFont);
        equationTextField.setHorizontalAlignment(SwingConstants.RIGHT); 
        equalButton.setForeground(userTextFieldFontColor);
        equationTextField.setBackground(textFieldColor);
        equationTextField.setBorder(null);

    }

    private void userTextField() {
        userTextField = new JTextField("0 ");
        userTextField.setFocusable(false);
        userTextField.setFont(userTextFieldFont);
        userTextField.setHorizontalAlignment(SwingConstants.RIGHT);
        userTextField.setForeground(userTextFieldFontColor);
        userTextField.setPreferredSize(new Dimension(0, textFieldHeight));
        userTextField.setBackground(textFieldColor);
        userTextField.setBorder(null);
    }

    private void numberButtons() {
        numButtons = new JButton[sizeOfNumberButtons];
        for (int i = 0; i < sizeOfNumberButtons; i++) {
            numButtons[i] = new JButton();
            numButtons[i].setBackground(Color.black);
            numButtons[i].setFocusable(false);
            numButtons[i].setText(String.valueOf(i));
            numButtons[i].setFont(textFont);
            numButtons[i].setForeground(buttonTextColor);
            numButtons[i].setBackground(buttonColor);
            numButtons[i].setBorder(null);
            numButtons[i].addMouseListener(new Calculator());
            numButtons[i].setBorder(new ButtonBorders(0));
        }
    }

    private void buttonPanel() {
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 4, 20, 10));
        buttonPanel.setBackground(buttonPanelColor);

        // First row
        buttonPanel.add(squareRootButton);
        buttonPanel.add(powerButton);
        buttonPanel.add(clearButton);
        buttonPanel.add(addButton);

        // Second row
        buttonPanel.add(numButtons[1]);
        buttonPanel.add(numButtons[2]);
        buttonPanel.add(numButtons[3]);
        buttonPanel.add(subButton);

        // Third row
        buttonPanel.add(numButtons[4]);
        buttonPanel.add(numButtons[5]);
        buttonPanel.add(numButtons[6]);
        buttonPanel.add(multiplyButton);

        // Fourth row
        buttonPanel.add(numButtons[7]);
        buttonPanel.add(numButtons[8]);
        buttonPanel.add(numButtons[9]);
        buttonPanel.add(divideButton);

        // Fifth row
        buttonPanel.add(decimalButton);
        buttonPanel.add(numButtons[0]);
        buttonPanel.add(operatorButtons[5]);
        buttonPanel.add(equalButton); // Equal button

    }

    private void setUpMainFrame() {

        mainFrame = new JFrame();
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setResizable(true);
        mainFrame.setTitle("Calculator");

        mainFrame.add(textPanel, BorderLayout.NORTH);
        mainFrame.add(buttonPanel, BorderLayout.CENTER);

    }

    public static void main(String[] args) throws Exception {

        SwingUtilities.invokeLater(() -> {
            new CalculatorApp();
        });

    }
}
