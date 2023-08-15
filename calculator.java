import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 
import java.util.ArrayList;

public class calculator {
    private static String totalString;
    private static String currentEntry;
    private static String currentOperator;
    private static boolean pressedEnter;
    private static ArrayList<JButton> buttons;

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException e) {
            return false;
        }     
        return true;
    }

    public static void addButton(Container pane, String text, int x, int y) {
        JButton button = new JButton(text, null);
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = x;
        constraints.gridy = y;
        constraints.ipadx = 20;
        pane.add(button, constraints);
        buttons.add(button);
    }

    public static void handleEvent(ActionEvent event) {
        JButton button = (JButton)event.getSource();
        String buttonName = button.getText();

        if (buttonName.equals("CE")) {
            if (currentEntry.equals("0")) {
                totalString = "0";
            } else {
                currentEntry = "0";
            }
        } else if (isNumber(buttonName)) {
            if (pressedEnter) {
                totalString += buttonName;
            } else {
                currentEntry += buttonName;
            }
        } else if (buttonName.equals("=")) {
            double tempTotal;
            double tempCurrentEntry; 
            if (currentOperator.equals("")) return;
            if (currentEntry.equals("")) {
                return;
            } else {
                tempCurrentEntry = Double.parseDouble(currentEntry);
            }
            if (totalString.equals("")) {
                tempTotal = 0;
            } else {
                tempTotal = Double.parseDouble(totalString);
            }
            switch (currentOperator) {
                case "+": totalString = Double.toString((double)(tempTotal + tempCurrentEntry)); break;
                case "-": totalString = Double.toString((double)(tempTotal - tempCurrentEntry)); break;
                case "*": totalString = Double.toString((double)(tempTotal * tempCurrentEntry)); break;
                case "/": totalString = Double.toString((double)(tempTotal / tempCurrentEntry)); break; // I don't understand
            }
            currentOperator = "";
            currentEntry = "0";
            pressedEnter = true;
        } else if (buttonName.equals("+") || buttonName.equals("-") || buttonName.equals("*") || buttonName.equals("/")) {
            currentOperator = buttonName;
            pressedEnter = false;
        } 
        System.out.println(totalString);
    }

    public static void addEventListenerToButtons() {
        for (JButton b : buttons) {
            b.addActionListener( new ActionListener() {
                public void actionPerformed(ActionEvent event) {
                    handleEvent(event);
                }
            });
        }
    }
    public static void addComponentsToPane(Container pane) {
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());
        addButton(pane, "0", 1, 4);
        addButton(pane, "1", 0, 1);
        addButton(pane, "2", 1, 1);
        addButton(pane, "3", 2, 1);
        addButton(pane, "4", 0, 2);
        addButton(pane, "5", 1, 2);
        addButton(pane, "6", 2, 2);
        addButton(pane, "7", 0, 3);        
        addButton(pane, "8", 1, 3);
        addButton(pane, "9", 2, 3);
        addButton(pane, "=", 2, 4);
        addButton(pane, "CE", 0, 4);
        addButton(pane, "+", 3, 1);
        addButton(pane, "-", 3, 2);
        addButton(pane, "*", 3, 3);
        addButton(pane, "/", 3, 4);

        GridBagConstraints constraints = new GridBagConstraints();
        JLabel text = new JLabel("placeholder!", null, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.ipady = 20;
        pane.add(text, constraints);
    }

    public static void createWindow() {
        JFrame frame = new JFrame("cool calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addComponentsToPane(frame.getContentPane());
        addEventListenerToButtons();
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        totalString = "0";
        currentEntry = "0";
        currentOperator = "";
        pressedEnter = true;
        buttons = new ArrayList<JButton>();
        createWindow();
        // TODO: add text to text box
    }
}