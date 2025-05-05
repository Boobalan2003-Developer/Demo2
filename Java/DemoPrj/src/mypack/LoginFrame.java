package mypack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;

public class LoginFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setTitle("CollegePro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 307);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel title = new JLabel("Login");
		title.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 16));
		title.setBounds(255, 32, 58, 28);
		contentPane.add(title);
		
		JLabel l1 = new JLabel("E-mail ID");
		l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		l1.setBounds(103, 92, 99, 20);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Password");
		l2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		l2.setBounds(103, 141, 99, 20);
		contentPane.add(l2);
		
		t1 = new JTextField();
		t1.setBounds(218, 90, 207, 28);
		contentPane.add(t1);
		t1.setColumns(10);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(218, 139, 207, 28);
		contentPane.add(t2);
		
		JButton b1 = new JButton("Register");
		b1.setMnemonic('r');
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		b1.setBounds(69, 197, 95, 28);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Close");
		b2.setMnemonic('C');
		b2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		b2.setBounds(218, 197, 95, 28);
		contentPane.add(b2);
		
		JLabel l3 = new JLabel("Forgot Password?");
		l3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		l3.setBounds(369, 203, 126, 17);
		contentPane.add(l3);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(485, 112, 0, 120);
		contentPane.add(separator);
	}
}
