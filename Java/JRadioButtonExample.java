import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JRadioButtonExample extends JFrame implements ActionListener {

    // Declare radio buttons
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;

    // Declare a button group to group the radio buttons
    private ButtonGroup group;

    // Declare a label to display the selected option
    private JLabel label;

    public JRadioButtonExample() {
        // Set up the frame
        setTitle("JRadioButton Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create radio buttons
        option1 = new JRadioButton("Option 1");
        option2 = new JRadioButton("Option 2");
        option3 = new JRadioButton("Option 3");

        // Add action listeners to the radio buttons
        option1.addActionListener(this);
        option2.addActionListener(this);
        option3.addActionListener(this);

        // Group the radio buttons to allow only one selection at a time
        group = new ButtonGroup();
        group.add(option1);
        group.add(option2);
        group.add(option3);

        // Create a label to display the selected option
        label = new JLabel("Select an option");

        // Set up the layout and add components
        setLayout(new FlowLayout());
        add(option1);
        add(option2);
        add(option3);
        add(label);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Update the label with the selected option
        if (e.getSource() == option1) {
            label.setText("You selected Option 1");
        } else if (e.getSource() == option2) {
            label.setText("You selected Option 2");
        } else if (e.getSource() == option3) {
            label.setText("You selected Option 3");
        }
    }

    public static void main(String[] args) {
        // Run the program
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new JRadioButtonExample().setVisible(true);
            }
        });
    }
}
