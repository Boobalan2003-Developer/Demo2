package mypack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class NotepadClone {
	
	JFrame jf = new JFrame("Notepad Clone");
	JScrollBar scroll1 = new JScrollBar();
	JTextArea textarea1= new JTextArea();
	JMenu filemenu= new JMenu("File");
	JMenu editmenu = new JMenu("Edit");
	JMenu viewmenu = new JMenu("View");
	JMenuBar menubar = new JMenuBar();
	JFileChooser filechooser = new JFileChooser();
	JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19;
	
	
	void layoutControls()
	{
		//set Mnemonic keys for menu bar items...!
		filemenu.setMnemonic('f');
		editmenu.setMnemonic('e');
		viewmenu.setMnemonic('v');
		
		//Setup for Menu Items..!
		item1 = new JMenuItem("New");
		item1.setMnemonic('n');
		
		item2 = new JMenuItem("Open");
		item2.setMnemonic('o');
		
		item3 = new JMenuItem("Save");
		item3.setMnemonic('s');
		
		item4 = new JMenuItem("Save as");
		item4.setMnemonic('a');
		
		//adding menu items to file menu..!
		filemenu.add(item1);
		filemenu.add(item2);
		filemenu.add(item3);
		filemenu.add(item4);
		
		filemenu.addSeparator();
		
		
		item5 = new JMenuItem("Print Preview");
		item5.setMnemonic('p');
		
		item6 = new JMenuItem("Page Setup");
		item6.setMnemonic('g');
		
		//adding menu items to file menu..!
		filemenu.add(item5);
		filemenu.add(item6);
		
		filemenu.addSeparator();
		
		item7 = new JMenuItem("Exit");
		item7.setMnemonic('q');
		
		//adding menu item to file menu..!
		filemenu.add(item7);
		
		item8 = new JMenuItem("Cut");
		item8.setMnemonic('x');
		
		item9 = new JMenuItem("Copy");
		item9.setMnemonic('c');
		
		item10 = new JMenuItem("Paste");
		item10.setMnemonic('p');
		
		//adding menu items to edit menu..!
		editmenu.add(item8);
		editmenu.add(item9);
		editmenu.add(item10);
		
		editmenu.addSeparator();
		
		item11 = new JMenuItem("Find");
		item11.setMnemonic('f');
		
		item12 = new JMenuItem("Find Next");
		item12.setMnemonic('i');
		
		item13 = new JMenuItem("Find Previous");
		item13.setMnemonic('p');
		
		//adding menu items to edit menu..!
		editmenu.add(item11);
		editmenu.add(item12);
		editmenu.add(item13);
		
		editmenu.addSeparator();
		
		item14 = new JMenuItem("Replace");
		item14.setMnemonic('r');
		
		item15 = new JMenuItem("Go To");
		item15.setMnemonic('g');
		
		//adding menu items to edit menu..!
		editmenu.add(item14);
		editmenu.add(item15);
		
		editmenu.addSeparator();
		
		item16 = new JMenuItem("Font");
		item16.setMnemonic('f');
		
		//adding menu item to edit menu..!
		editmenu.add(item16);
		
		item17 = new JMenuItem("Zoom");
		item17.setMnemonic('z');
		
		item18 = new JMenuItem("Status Bar");
		item18.setMnemonic('b');
		
		item19 = new JMenuItem("Word Wrap");
		item19.setMnemonic('w');
		
		//adding menu items to view menu..!
		viewmenu.add(item17);
		viewmenu.add(item18);
		viewmenu.add(item19);
		
		//adding menu bars to Main Menu..!
		menubar.add(filemenu);
		menubar.add(editmenu);
		menubar.add(viewmenu);
		
		//add text area & scroll bar to Frame..!
		jf.add(textarea1);
		jf.add(scroll1,BorderLayout.EAST);
	}
	
	void listener(int W, int H)
	{
		item1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame jf1 =  new JFrame("Notepad Clone");
				jf1.setSize(W,H);
				layoutControls();
				jf1.setJMenuBar(menubar);
				jf1.setVisible(true);
			}
		});
		item2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				filechooser.showOpenDialog(jf);
			}
		});
		item3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				filechooser.showSaveDialog(jf);
			}
		});
		item7.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int res = JOptionPane.showConfirmDialog(jf, "Are you sure want to exit..?","NotePad Clone",2);
				if(res==0)
				{
					System.exit(0);
				}
			}
		});
	}
	
	void showFrame(int W,int H)
	{
		jf.setSize(W,H);
		//add menu bar to Frame..!
		jf.setJMenuBar(menubar);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
	NotepadClone(int W,int H)
	{
		layoutControls();
		listener(W,H);
		showFrame(W,H);
	}
	
	public static void main(String args[])
	{
		Dimension d =Toolkit.getDefaultToolkit().getScreenSize();
		int screen_H= (int)d.getHeight();
		int screen_W = (int)d.getWidth();
		
		new NotepadClone(screen_W,screen_H);
	}
}
