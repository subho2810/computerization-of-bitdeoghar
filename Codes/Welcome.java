import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
 class Welcome extends JFrame{
    public static Container h;
	public static JButton lgs;
    public Welcome(){
        setTitle("WELCOME PAGE");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/WELCOME.png"));
	    h.add(c);
        lgs=new JButton("CLICK HERE TO GET STARTED");
        lgs.setBounds(557,480 ,440,100);
        Font font2=new Font("Agency FB",Font.BOLD,30);
        lgs.setFont(font2);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        lgs.setCursor(cur);
        c.add(lgs);
        JMenuBar menubar1=new JMenuBar();
        JMenu file=new JMenu("File");
        JMenuItem item1=new JMenuItem("new");
        JMenuItem item2=new JMenuItem("open");
        JMenuItem item3=new JMenuItem("save");
        file.add(item1); 
        file.add(item2);
        file.add(item3);
        menubar1.add(file);
        JMenu Edit=new JMenu("Edit");
        JMenuItem tem1=new JMenuItem("undo");
        JMenuItem tem2=new JMenuItem("redu");
        JMenuItem tem3=new JMenuItem("cut");
        Edit.add(tem1); 
        Edit.add(tem2);
        Edit.add(tem3);
        menubar1.add(Edit);
        setJMenuBar(menubar1);
        setVisible(true);
        lgs.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                modules obb=new modules();
                setVisible(false);
                obb.setVisible(true);
                
            }
            
        });
    }
    public static void main(String[] args) {
        new Welcome();
        
    }
}
