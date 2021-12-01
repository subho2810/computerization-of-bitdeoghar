
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.*;
class Facultydashboard extends JFrame{
    public static Container h;
	public static JButton std,cd,logout;
    public static JLabel wel;
    public static String nn,rnn;
    public Facultydashboard(String NAME){
        nn=NAME;
        
        setTitle(" Faculty DASHBOARD PAGE");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/Studentdashboard.PNG"));
	    h.add(c);
        Font font2=new Font("Agency FB",Font.BOLD,30);
        Font font3=new Font("Agency FB",Font.BOLD,65);
        wel =new JLabel("WELCOME     "+NAME);
        wel.setBounds(500,50,800,80);
        wel.setFont(font3);
        std=new JButton("Faculty Details");
        std.setBounds(730,250,200,50);
        std.setFont(font2);
        cd=new JButton("Student OVERALL DATA");
        cd.setBounds(700,360,300,50);
        cd.setFont(font2);
        
        logout=new JButton("LOG OUT");
        logout.setBounds(730,480,200,50);
        logout.setFont(font2);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        std.setCursor(cur);
        cd.setCursor(cur);
        logout.setCursor(cur);
        c.add(std);
        c.add(cd);
        c.add(logout);
        c.add(wel);
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
        logout.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                FacultyLoginForm ojj=new FacultyLoginForm("FACULTY");
                setVisible(false);
                ojj.setVisible(true);
                
            }
            
        });
        std.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                FacultyDetails sll=new FacultyDetails(NAME);
                setVisible(false);
                sll.setVisible(true);
            }
            
        });
        cd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                StudentsData sld=new StudentsData(NAME);
                setVisible(false);
                sld.setVisible(true);
            }
            
        });
        
        
       

    }
    public static void main(String[] args) {
        new Facultydashboard(nn);
        
    }
}