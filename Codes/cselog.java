
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
 class cselog extends JFrame{
    public static Container h;
	public static JButton std,fac,goback;
    public cselog(){
        setTitle("LOG PAGE");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/cselog.png"));
	    h.add(c);
        Font font2=new Font("Agency FB",Font.BOLD,30);
        std=new JButton("Sign in as Student");
        std.setBounds(250,420,300,70);
        std.setFont(font2);
        fac=new JButton("Sign in as Faculty");
        fac.setBounds(1000,420,300,70);
        fac.setFont(font2);
        goback=new JButton("Go BACK");
        goback.setBounds(630,620,300,70);
        goback.setFont(font2);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        goback.setCursor(cur);
        std.setCursor(cur);
        c.add(goback);
        c.add(fac);
        c.add(std);
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
        goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                modules mg=new modules();
                setVisible(false);
                mg.setVisible(true);
                
            }
            
        });
        std.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                StudentLoginForm stg=new StudentLoginForm("STUDENT");
                setVisible(false);
                stg.setVisible(true);
                
            }
            
        });
        fac.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                FacultyLoginForm stg=new FacultyLoginForm("FACULTY");
                setVisible(false);
                stg.setVisible(true);
                
            }
            
        });
    }
    public static void main(String[] args) {
        new cselog();
        
    }
}
