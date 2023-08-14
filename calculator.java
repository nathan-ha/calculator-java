import java.awt.*; 
import javax.swing.*; 

public class calculator {
    public static void addComponentsToPane(Container pane) {
        pane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pane.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();

        JButton button1 = new JButton("1", null);
        constraints.gridx = 0;
        constraints.gridy = 1;
        pane.add(button1, constraints);

        JButton button2 = new JButton("2", null);
        constraints.gridx = 1;
        constraints.gridy = 1;
        pane.add(button2, constraints);

        JButton button3 = new JButton("3", null);
        constraints.gridx = 2;
        constraints.gridy = 1;
        pane.add(button3, constraints);

        JButton button4 = new JButton("4", null);
        constraints.gridx = 0;
        constraints.gridy = 2;
        pane.add(button4, constraints);

        JButton button5 = new JButton("5", null);
        constraints.gridx = 1;
        constraints.gridy = 2;
        pane.add(button5, constraints);
        
        JButton button6 = new JButton("6", null);
        constraints.gridx = 2;
        constraints.gridy = 2;
        pane.add(button6, constraints);

        JButton button7 = new JButton("7", null);
        constraints.gridx = 0;
        constraints.gridy = 3;
        pane.add(button7, constraints);

        JButton button8 = new JButton("8", null);
        constraints.gridx = 1;
        constraints.gridy = 3;
        pane.add(button8, constraints);

        JButton button9 = new JButton("9", null);
        constraints.gridx = 2;
        constraints.gridy = 3;
        pane.add(button9, constraints);

        JButton button0 = new JButton("0", null);
        constraints.gridx = 1;
        constraints.gridy = 4;
        pane.add(button0, constraints);

        JButton buttonEquals = new JButton("=", null);
        constraints.gridx = 2;
        constraints.gridy = 4;
        pane.add(buttonEquals, constraints);

        JButton buttonClear = new JButton("CE", null);
        constraints.gridx = 0;
        constraints.gridy = 4;
        pane.add(buttonClear, constraints);

        JButton buttonAdd = new JButton("+", null);
        constraints.gridx = 3;
        constraints.gridy = 1;
        pane.add(buttonAdd, constraints);

        JButton buttonSubtract = new JButton("-", null);
        constraints.gridx = 3;
        constraints.gridy = 2;
        pane.add(buttonSubtract, constraints);

        JButton buttonMultiply = new JButton("*", null);
        constraints.gridx = 3;
        constraints.gridy = 3;
        pane.add(buttonMultiply, constraints);

        JButton buttonDivide = new JButton("/", null);
        constraints.gridx = 3;
        constraints.gridy = 4;
        pane.add(buttonDivide, constraints);

        JLabel text = new JLabel("placeholder!", null, 0);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 3;
        constraints.ipady = 20;
        pane.add(text, constraints);
    }

    public static void createWindow() {
        JFrame frame = new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentsToPane(frame.getContentPane());

        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        createWindow();
        //TODO: Add logic
    }
}