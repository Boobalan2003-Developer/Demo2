package mypack;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollBar;


public class Demo1
{
	JFrame jf = new JFrame("Notepad Clone");
	JScrollBar scroll1 = new JScrollBar();
	JMenu filemenu= new JMenu("File");
	JMenu editmenu = new JMenu("Edit");
	JMenu viewmenu = new JMenu("View");
	JMenuBar menubar = new JMenuBar();
	JMenuItem item1,item2,item3,item4,item5,item6,item7,item8,item9,item10,item11,item12,item13,item14,item15,item16,item17,item18,item19;
	
	
	void controls()
	{
		jf.add(menubar);
	}
	
	void ShowFrame()
	{
		controls();
		jf.setSize(500,300);
		jf.setDefaultCloseOperation(jf.EXIT_ON_CLOSE);
		jf.setLocation(10,20);
		jf.setVisible(true);
	}
	
	Demo1()
	{
		ShowFrame();
	}
	
	public static void main(String Args[])
    {
		
		new Demo1();
    } 	
}

