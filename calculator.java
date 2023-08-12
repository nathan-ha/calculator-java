import java.awt.*; 
import javax.swing.*; 

public class calculator {
    public static final String[] NUMS_AS_STRINGS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
    public static final int NUM_BUTTONS = 10;

    private static void createWindow() {
        JFrame frame = new JFrame("cool frame");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
        frame.setLayout(new FlowLayout());

        JButton[] buttons = new JButton[NUM_BUTTONS];
        for (int i = 1; i < NUM_BUTTONS; i++) {
            buttons[i] = new JButton(NUMS_AS_STRINGS[i], null);
            frame.add(buttons[i]);
        }
        buttons[0] = new JButton(NUMS_AS_STRINGS[0], null); // put 0 at the end instead of beginning
        frame.add(buttons[0]);

        // TODO: add other operations and text box at top
        JButton enterButton = new JButton("Enter", null);
        JButton clearButton = new JButton("Clear", null);

        frame.add(enterButton);
        frame.add(clearButton);

        frame.setLayout(new GridLayout(4, 4));
        frame.pack(); 
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        createWindow();
        
    }
}
