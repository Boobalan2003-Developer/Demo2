package collegePkg;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class demo1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					demo1 frame = new demo1();
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
	public demo1() {
		setMinimumSize(new Dimension(1536, 864));
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int h=(int)d.getHeight();
		int w=(int)d.getWidth();
		
		System.out.println("\n\t"+h+"\n\t"+w);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1578, 878);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel bl = new JLabel("Welcome Screen");
		bl.setFont(new Font("Tahoma", Font.PLAIN, 20));
		bl.setBounds(1380, 10, 160, 85);
		contentPane.add(bl);
	}

}
