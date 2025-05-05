package mypack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

public class Notepad {
	
	JFrame jf;
	JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12,mi13,mi14,mi15;
	JMenu menu1,menu2,menu3;
	JTextArea ta;
	JScrollBar sc;
	JFileChooser filechooser;
	JMenuBar mb1;
  
    void createcontrols() 
    {
      jf=new JFrame("Notepad");
      
      mi1=new JMenuItem("New");	
      mi2=new JMenuItem("Open");	
      mi3=new JMenuItem("Save");	
      mi4=new JMenuItem("Save As");	
      mi5=new JMenuItem("Print");	
      mi6=new JMenuItem("close");
      mi7=new JMenuItem("Exit");	
      mi8=new JMenuItem("Cut");	
      mi9=new JMenuItem("Copy");	
      mi10=new JMenuItem("Paste");	
      mi11=new JMenuItem("Undo");	
      mi12=new JMenuItem("Delete");	
      mi13=new JMenuItem("Zoom");	
      mi14=new JMenuItem("Status Bar");	
      mi15=new JMenuItem("Word wrap");	
   
      menu1=new JMenu("File");
      menu2=new JMenu("Edit");
      menu3=new JMenu("View");
      	
      mb1=new JMenuBar();
      
      ta=new JTextArea();
      sc=new JScrollBar();
      filechooser=new JFileChooser();

    }
	void addcontrols()
	{
		
		jf.setBounds(800,100,600,400);
		
		menu1.add(mi1);
		menu1.add(mi2);
		menu1.add(mi3);
		menu1.add(mi4);
		menu1.add(mi5);
		menu1.add(mi6);
		menu1.add(mi7);

		menu2.add(mi8);
		menu2.add(mi9);
		menu2.add(mi10);
		menu2.add(mi11);
		menu2.add(mi12);
		
		menu3.add(mi13);
		menu3.add(mi14);
		menu3.add(mi15);
		
		mb1.add(menu1);
		mb1.add(menu2);
		mb1.add(menu3);
		
		jf.setJMenuBar(mb1);
		jf.add(ta);
		jf.add(sc,BorderLayout.EAST);
		
		
	}
    void addlisteners() 
    {
    mi2.addActionListener (new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				filechooser.showOpenDialog(jf);
			}
		});
	mi3.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			filechooser.showSaveDialog(jf);
		}
	});	
       mi7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					int result=JOptionPane.showConfirmDialog(jf,"Are you want to exit this page?","Confirm Dialouge",2);
					
					if(result==0) {
						System.exit(0);
					}
					
				}
			});
    }
	void showframe()
	{
		
		jf.setVisible(true);
	}
	//constructor Class
	Notepad()
	{
		createcontrols();
		addcontrols();
		addlisteners();
		showframe();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          new Notepad();
	}

}