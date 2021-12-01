
import javax.swing.*;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.sql.*;
class Examdashboard extends JFrame{
    static final String DB_URL = "jdbc:mysql://localhost:3306/examination_module";
   static final String USER = "root";
   static final String PASS = "";
    public static Container h;
	public static JButton DCCN,FLAT,DBMS,SE,goback;
    public static JLabel wel;
    Connection conn;
    Statement st;
    public Examdashboard(){
        setTitle("DASHBOARD PAGE");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/examdashboard.PNG"));
	    h.add(c);
        Font font2=new Font("Agency FB",Font.BOLD,30);
        //Font font3=new Font("Agency FB",Font.BOLD,65);
        
        DCCN=new JButton("DCCN");
        DCCN.setBounds(730,250,200,50);
        DCCN.setFont(font2);
        DBMS=new JButton("DBMS");
        DBMS.setBounds(730,320,200,50);
        DBMS.setFont(font2);
        FLAT=new JButton("FLAT");
        FLAT.setBounds(730,400,200,50);
        FLAT.setFont(font2);
        SE=new JButton("SE");
        SE.setBounds(730,470,200,50);
        SE.setFont(font2);
        goback=new JButton("go back");
        goback.setBounds(730,550,200,50);
        goback.setFont(font2);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        DCCN.setCursor(cur);
        DBMS.setCursor(cur);
        FLAT.setCursor(cur);
        SE.setCursor(cur);
        goback.setCursor(cur);
        c.add(DCCN);
        c.add(DBMS);
        c.add(FLAT);
        c.add(SE);
        c.add(goback);
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
             st = conn.createStatement();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        
      
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
        DCCN.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dccntake oh=new dccntake();
                setVisible(false);
                oh.setVisible(true);
                
            }
            
        });
        DBMS.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                dbmstake oh=new dbmstake();
                setVisible(false);
                oh.setVisible(true);
                
            }
            
        });
        FLAT.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                flattake oh=new flattake();
                setVisible(false);
                oh.setVisible(true);
                
            }
            
        });
        SE.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                setake oh=new setake();
                setVisible(false);
                oh.setVisible(true);
                
            }
            
        });
        goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                modules oh=new modules();
                setVisible(false);
                oh.setVisible(true);
                
            }
            
        });
        
        
       

    }
    public static void main(String[] args) {
        new Examdashboard();
        
    }
}
