
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class boysDetails extends JFrame{
    public static JLabel c;
    public static JTable table;
    public static JScrollPane scrollPane;
    public static DefaultTableModel model;
    public static DefaultTableCellRenderer cellRenderer;
    public static Container h;
    public static JButton roomate1,roomate2,showmy,goback;
    public static JLabel name,rno,r1,r2,rno1,hn,contact,cc;
    public static JLabel label;
    static final String DB_URL = "jdbc:mysql://localhost:3306/boys_hostel_module";
    static final String USER = "root";
    static final String PASS = "";
    static public Object[][]data;
    public static  boolean status;
    Connection conn;
    Statement st;
    public static String nn;
    
    public boysDetails(String NAME){
        nn=NAME;
        setTitle("COURCE DETAIL PAGE");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Font font2=new Font("Agency FB",Font.BOLD,25);
        Font font=new Font("Algerian",Font.BOLD,40);
        h=getContentPane();
       
        setBackground(Color.CYAN);
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
        setLayout(null);
        
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
             st = conn.createStatement();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
         JPanel panel=new JPanel();
         panel.setLayout(null);
         panel.setBounds(10,10,1500,100);
         panel.setBackground(Color.ORANGE);
         Border br=BorderFactory.createLineBorder(Color.BLACK,2);
         panel.setBorder(br);
         roomate1=new JButton("Roomate1");
         roomate1.setBounds(20,20,150,60);
         roomate1.setBorder(br);
         roomate1.setFont(font2);
         panel.add(roomate1);
         roomate2=new JButton("Roomate2");
         roomate2.setBounds(190,20,150,60);
         roomate2.setBorder(br);
         roomate2.setFont(font2);
         panel.add(roomate2);
         showmy=new JButton("My Profile");
         showmy.setBounds(360,20,150,60);
         showmy.setBorder(br);
         showmy.setFont(font2);
         panel.add(showmy);
        
         label=new JLabel(" MY DETAILS ");
         label.setBounds(800,20,500,60);
         label.setFont(font);
         panel.add(label);
         goback=new JButton("Go back");
         goback.setBounds(1300,20,150,60);
         goback.setBorder(br);
         goback.setFont(font2);
         panel.add(goback);
         h.add(panel);    
         setVisible(true);
         roomate2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    st = conn.createStatement();
                   String query="Select Roommate_2 from boys where Boys_name='"+NAME+"'";
                   ResultSet res=st.executeQuery(query);
                   String romm1="";
                   if(res.next()){
                        romm1=res.getString("Roommate_2"); 
                   }
                    if(romm1.length()==0){
                        JOptionPane.showMessageDialog(null,"You Dont Have Roommate 2 or he must have not registered","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        String q2="Select * from boys where Boys_name='"+romm1+"'";
                        res=st.executeQuery(q2);
                        if(res.next()==false){
                            JOptionPane.showMessageDialog(null,"Can't find Details","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JPanel panel2=new JPanel();
                            panel2.setLayout(new BorderLayout());
                            panel2.setBounds(70,150,1400,600);
                            h.add(panel2);
                            panel2.setBackground(Color.green);
                            String Name="",Rno="",ROOM="",CONTACT="",HOSTELNAME="";
                            String query3="Select * from boys where Boys_name='"+romm1+"'";
             ResultSet res3=st.executeQuery(query3);
             if(res3.next()){
                 Name=res3.getString("Boys_name");
                 Rno=res3.getString("rollno");
                 CONTACT=res3.getString("Contact");
                 ROOM=res3.getString("RoomNo");
                 HOSTELNAME=res3.getString("Hostel_name");
             }
        
        name=new JLabel("NAME -> "+Name);
		name.setBounds(500,150,400,50);
		name.setFont(font2);
        rno=new JLabel("ROLL NO. -> "+Rno);
		rno.setBounds(500,200,400,40);
		rno.setFont(font2);
        contact=new JLabel("CONTACT -> "+CONTACT);
		contact.setBounds(500,250,400,40);
		contact.setFont(font2);
		rno1=new JLabel("ROOM NO -> "+ROOM);
		rno1.setBounds(500,300,250,40);
		rno1.setFont(font2);
		hn=new JLabel("Hostel Name -> "+HOSTELNAME);
		hn.setFont(font2);
		hn.setBounds(500,350,250,40);
        cc=new JLabel("");
		cc.setFont(font2);
		cc.setBounds(500,400,250,40);
		panel2.add(name);
        panel2.add(rno);
        panel2.add(contact);
        panel2.add(rno1);
        panel2.add(hn);
        panel2.add(cc);
        
        setVisible(true);

                        }

                    }
                }
                catch(SQLException d){
                    d.printStackTrace();
                }
               
                
            }
             
         });


         roomate1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    conn = DriverManager.getConnection(DB_URL, USER, PASS);
                    st = conn.createStatement();
                   String query="Select Roommate_1 from boys where Boys_name='"+NAME+"'";
                   ResultSet res=st.executeQuery(query);
                   String romm1="";
                   if(res.next()){
                        romm1=res.getString("Roommate_1"); 
                   }
                    if(romm1.length()==0){
                        JOptionPane.showMessageDialog(null,"You Dont Have Roommate 1 or he must have not registered","Error",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        String q2="Select * from boys where Boys_name='"+romm1+"'";
                        res=st.executeQuery(q2);
                        if(res.next()==false){
                            JOptionPane.showMessageDialog(null,"Can't find Details","Error",JOptionPane.ERROR_MESSAGE);
                        }
                        else{
                            JPanel panel2=new JPanel();
                            panel2.setLayout(new BorderLayout());
                            panel2.setBounds(70,150,1400,600);
                            h.add(panel2);
                            panel2.setBackground(Color.green);
                            String Name="",Rno="",ROOM="",CONTACT="",HOSTELNAME="";
                            String query3="Select * from boys where Boys_name='"+romm1+"'";
             ResultSet res3=st.executeQuery(query3);
             if(res3.next()){
                 Name=res3.getString("Boys_name");
                 Rno=res3.getString("rollno");
                 CONTACT=res3.getString("Contact");
                 ROOM=res3.getString("RoomNo");
                 HOSTELNAME=res3.getString("Hostel_name");
             }
        
             name=new JLabel("NAME -> "+Name);
             name.setBounds(500,150,400,50);
             name.setFont(font2);
             rno=new JLabel("ROLL NO. -> "+Rno);
             rno.setBounds(500,200,400,40);
             rno.setFont(font2);
             contact=new JLabel("CONTACT -> "+CONTACT);
             contact.setBounds(500,250,400,40);
             contact.setFont(font2);
             rno1=new JLabel("ROOM NO -> "+ROOM);
             rno1.setBounds(500,300,250,40);
             rno1.setFont(font2);
             hn=new JLabel("Hostel Name -> "+HOSTELNAME);
             hn.setFont(font2);
             hn.setBounds(500,350,250,40);
             cc=new JLabel("");
             cc.setFont(font2);
             cc.setBounds(500,400,250,40);
             panel2.add(name);
             panel2.add(rno);
             panel2.add(contact);
             panel2.add(rno1);
             panel2.add(hn);
             panel2.add(cc);
        
        setVisible(true);

                        }

                    }
                }
                catch(SQLException d){
                    d.printStackTrace();
                }
               
                
            }
             
         });
         showmy.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel panel2=new JPanel();
                panel2.setLayout(new BorderLayout());
                panel2.setBounds(70,150,1400,600);
                h.add(panel2);
                panel2.setBackground(Color.CYAN);
               
               String Name="",Rno="",R1="",R2="",ROOM="",CONTACT="",HOSTELNAME="";
         try {
               conn = DriverManager.getConnection(DB_URL, USER, PASS);
               st = conn.createStatement();
            
             String query="Select * from boys where Boys_name='"+NAME+"'";
             ResultSet res=st.executeQuery(query);
             if(res.next()){
                 Name=res.getString("Boys_name");
                 Rno=res.getString("rollno");
                 R2=res.getString("Roommate_2");
                 CONTACT=res.getString("Contact");
                 ROOM=res.getString("RoomNo");
                 R1=res.getString("Roommate_1");
                 HOSTELNAME=res.getString("Hostel_name");
             }
        
        name=new JLabel("NAME -> "+Name);
		name.setBounds(500,150,400,50);
		name.setFont(font2);
        rno=new JLabel("ROLL NO. -> "+Rno);
		rno.setBounds(500,200,400,40);
		rno.setFont(font2);
		r1=new JLabel("Roommate 1 -> "+R1);
		r1.setBounds(500,250,400,40);
		r1.setFont(font2);
		r2=new JLabel("Roommate 2 -> "+R2);
		r2.setBounds(500,300,500,40);
		r2.setFont(font2);
        contact=new JLabel("CONTACT -> "+CONTACT);
		contact.setBounds(500,350,400,40);
		contact.setFont(font2);
		rno1=new JLabel("ROOM NO -> "+ROOM);
		rno1.setBounds(500,400,250,40);
		rno1.setFont(font2);
		hn=new JLabel("Hostel Name -> "+HOSTELNAME);
		hn.setFont(font2);
		hn.setBounds(500,450,250,40);
        cc=new JLabel("");
		cc.setFont(font2);
		cc.setBounds(500,500,250,40);
		panel2.add(name);
        panel2.add(r1);
        panel2.add(rno);
        panel2.add(contact);
        panel2.add(r2);
        panel2.add(rno1);
        panel2.add(hn);
        panel2.add(cc);
        
        setVisible(true);

        
		
        } catch (SQLException k) {
            
            k.printStackTrace();
        }
                
                
                
            }
             
         });
         goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                BoysHosteldashboard ox=new BoysHosteldashboard(nn);
                setVisible(false);
                ox.setVisible(true);

            }
             
         });
    }
    public static void main(String[] args) {
      new boysDetails("");
    }
}