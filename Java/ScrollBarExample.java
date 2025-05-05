import javax.swing.*;

public class ScrollBarExample {
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Scroll Bar Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        // Create a JTextArea with some text
        JTextArea textArea = new JTextArea(20, 30);
        textArea.setText("This is an example of a scroll bar in a JTextArea.\n" +
                         "Add more text to make the scroll bar appear.\n\n" +
                         "Scroll bars will appear automatically when needed.\n" +
                         "You can add as much text as you like here...\n\n" +
                         "Keep adding text to see the scroll bar in action...\n\n" +
                         "Swing makes it easy to add scrollable components!");

        // Wrap the JTextArea in a JScrollPane
        JScrollPane scrollPane = new JScrollPane(textArea);

        // Add the JScrollPane to the JFrame
        frame.add(scrollPane);

        // Make the frame visible
        frame.setVisible(true);
    }
}
