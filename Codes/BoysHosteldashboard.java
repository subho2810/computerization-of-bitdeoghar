
import javax.swing.*;



import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.*;
class BoysHosteldashboard extends JFrame{
    public static Container h;
	public static JButton std,logout,hostelimages,mess_menu;
    public static JLabel wel;
    static String nn,rnn;
    public BoysHosteldashboard(String NAME){
        nn=NAME;
        
        setTitle("DASHBOARD PAGE");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/boyshosteldashboard.PNG"));
	    h.add(c);
        Font font2=new Font("Agency FB",Font.BOLD,30);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
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
        std=new JButton("Boys Details");
        std.setBounds(730,250,200,50);
        std.setFont(font2);
        hostelimages=new JButton("HOSTEL Images");
        hostelimages.setBounds(730,360,200,50);
        hostelimages.setFont(font2);
        mess_menu=new JButton("Mess MENU");
        mess_menu.setBounds(730,470,200,50);
        mess_menu.setFont(font2);
        logout=new JButton("LOG OUT");
        logout.setBounds(730,580,200,50);
        logout.setFont(font2);
        std.setCursor(cur);
        hostelimages.setCursor(cur);
        mess_menu.setCursor(cur);
        logout.setCursor(cur);
        c.add(std);
        c.add(hostelimages);
        c.add(mess_menu);
        c.add(logout);
        setVisible(true);
        mess_menu.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                messMenu jj=new messMenu(NAME);
                setVisible(false);
                jj.setVisible(true);
                
            }
            
        });
        std.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                boysDetails ogg=new boysDetails(NAME);
                setVisible(false);
                ogg.setVisible(true);
                
            }
            
        });
        hostelimages.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                hostelimages ogg=new hostelimages(NAME);
                setVisible(false);
                ogg.setVisible(true);
                
            }
            
        });
        logout.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                loginboys oj=new loginboys();
                setVisible(false);
                oj.setVisible(true);
                
            }
            
        });
        
        
       

    }
    public static void main(String[] args) {
        new BoysHosteldashboard("");
        
    }
}