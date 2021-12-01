
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.*;
class Studentdashboard extends JFrame{
    public static Container h;
	public static JButton std,gpa,cd,logout;
    public static JLabel wel;
    static String nn,rnn;
    public Studentdashboard(String NAME){
        nn=NAME;
        
        setTitle("DASHBOARD PAGE");
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
        std=new JButton("Student Details");
        std.setBounds(730,250,200,50);
        std.setFont(font2);
        cd=new JButton("Cource Details");
        cd.setBounds(730,360,200,50);
        cd.setFont(font2);
        gpa=new JButton("GPA Calculator");
        gpa.setBounds(730,470,200,50);
        gpa.setFont(font2);
        logout=new JButton("LOG OUT");
        logout.setBounds(730,580,200,50);
        logout.setFont(font2);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        std.setCursor(cur);
        cd.setCursor(cur);
        gpa.setCursor(cur);
        logout.setCursor(cur);
        c.add(std);
        c.add(cd);
        c.add(gpa);
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
                StudentLoginForm oj=new StudentLoginForm("STUDENT");
                setVisible(false);
                oj.setVisible(true);
                
            }
            
        });
        std.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                StudentDetails sl=new StudentDetails(NAME);
                
                sl.setVisible(true);
                setVisible(false);
            }
            
        });
        cd.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                CourceDetails sl=new CourceDetails(NAME);
                setVisible(false);
                sl.setVisible(true);
            }
            
        });
        gpa.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               GPAcalculator sl=new GPAcalculator(NAME);
                setVisible(false);
                sl.setVisible(true);
            }
            
        });
        
        
       

    }
    public static void main(String[] args) {
        new Studentdashboard(nn);
        
    }
}