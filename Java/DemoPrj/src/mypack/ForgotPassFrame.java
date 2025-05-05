package mypack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ForgotPassFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField t1;
	private JTextField t2;
	private JTextField t3;
	private JTextField t4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ForgotPassFrame frame = new ForgotPassFrame();
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
	public ForgotPassFrame() {
		setTitle("College Pro");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel l1 = new JLabel("Enter Student E-mail ID");
		l1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		l1.setBounds(40, 31, 160, 17);
		contentPane.add(l1);
		
		JLabel l2 = new JLabel("Enter your OTP");
		l2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		l2.setBounds(40, 70, 160, 17);
		contentPane.add(l2);
		
		JLabel l3 = new JLabel("Enter your Password");
		l3.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		l3.setBounds(40, 111, 160, 17);
		contentPane.add(l3);
		
		JLabel l4 = new JLabel("Confirm Password");
		l4.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		l4.setBounds(40, 151, 160, 17);
		contentPane.add(l4);
		
		t1 = new JTextField();
		t1.setBounds(224, 24, 169, 25);
		contentPane.add(t1);
		t1.setColumns(10);
		
		JButton b1 = new JButton("Register");
		b1.setMnemonic('R');
		b1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		b1.setBounds(40, 201, 105, 25);
		contentPane.add(b1);
		
		JButton b2 = new JButton("Close");
		b2.setMnemonic('C');
		b2.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		b2.setBounds(167, 199, 85, 28);
		contentPane.add(b2);
		
		JLabel l5 = new JLabel("Login");
		l5.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
		l5.setBounds(308, 202, 85, 21);
		contentPane.add(l5);
		
		t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(224, 67, 169, 25);
		contentPane.add(t2);
		
		t3 = new JTextField();
		t3.setColumns(10);
		t3.setBounds(224, 108, 169, 25);
		contentPane.add(t3);
		
		t4 = new JTextField();
		t4.setColumns(10);
		t4.setBounds(224, 148, 169, 25);
		contentPane.add(t4);
	}
}
