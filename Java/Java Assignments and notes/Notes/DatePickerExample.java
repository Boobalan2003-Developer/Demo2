import javax.swing.*;
import org.jdatepicker.impl.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Properties;

public class DatePickerExample extends JFrame {
    
    public DatePickerExample() {
        setTitle("Date Picker Example");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // Create date picker
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        
        // Add date picker to panel
        JPanel panel = new JPanel();
        panel.add(new JLabel("Select Date:"));
        panel.add(datePicker);
        
        // Add a button to show selected date
        JButton button = new JButton("Show Date");
        panel.add(button);
        
        // Add Action Listener to button
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                String selectedDate = dateFormat.format(datePicker.getModel().getValue());
                JOptionPane.showMessageDialog(null, "Selected Date: " + selectedDate);
            }
        });
        
        add(panel);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new DatePickerExample().setVisible(true);
            }
        });
    }
    
    // Custom formatter for the date picker
    public class DateLabelFormatter extends JFormattedTextField.AbstractFormatter {
        private String datePattern = "yyyy-MM-dd";
        private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

        @Override
        public Object stringToValue(String text) throws java.text.ParseException {
            return dateFormatter.parseObject(text);
        }

        @Override
        public String valueToString(Object value) {
            if (value != null) {
                return dateFormatter.format(value);
            }
            return "";
        }
    }
}
