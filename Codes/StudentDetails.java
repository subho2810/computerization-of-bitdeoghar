
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.awt.*;
class StudentDetails extends JFrame{
    public static Container h;
	public static JLabel name,rno,email,gpa,gender,address,contact;
	public static JButton EditDetails,goback;
   static final String DB_URL = "jdbc:mysql://localhost:3306/computer_science_module";
   static final String USER = "root";
   static final String PASS = "";
   Connection conn;
   Statement st;
   static  String nn,rnn;
	public StudentDetails(String NAME) {
        nn=NAME;
        
        setTitle("Student Detail Page");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
		
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/studentDetail.png"));
	    h.add(c);
		
        Font font2=new Font("Agency FB",Font.BOLD,25);
		
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
        goback =new JButton("GO BACK");
        EditDetails=new JButton("EDIT DETAILS");
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        goback.setCursor(cur);
        EditDetails.setCursor(cur);
        goback.setFont(font2);
        EditDetails.setFont(font2);
        EditDetails.setBounds(950,250,200,50);
        goback.setBounds(950,350,200,50);
        c.add(EditDetails);
        c.add(goback);
        
        
         String Name="",Rno="",Address="",Contact="",Gpa="",Email="",Gender="",image="";
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
             st = conn.createStatement();
             String query="Select * from student where name='"+NAME+"'";
             ResultSet res=st.executeQuery(query);
             if(res.next()){
                 Name=res.getString("name");
                 Rno=res.getString("rollno");
                 Address=res.getString("address");
                 Contact=res.getString("contact");
                 Gpa=res.getString("gpa");
                 Email=res.getString("email");
                 Gender=res.getString("gender");
                 image=res.getString("image");
             }
        ImageIcon icon=new ImageIcon("maincodes/images/"+image+".png");
        JLabel label=new JLabel("",icon,JLabel.CENTER);
        label.setBounds(320,340, 500, 500);
        c.add(label);
        name=new JLabel("NAME -> "+Name);
		name.setBounds(230,150,400,50);
		name.setFont(font2);
		email=new JLabel("EMAIL ID -> "+Email);
		email.setBounds(230,250,400,40);
		email.setFont(font2);
		rno=new JLabel("ROLL NO. -> "+Rno);
		rno.setBounds(230,200,400,40);
		rno.setFont(font2);
		contact=new JLabel("CONTACT -> "+Contact);
		contact.setBounds(230,300,400,40);
		contact.setFont(font2);
		address=new JLabel("ADDRESS -> "+Address);
		address.setBounds(230,350,500,40);
		address.setFont(font2);
		gpa=new JLabel("GPA -> "+Gpa);
		gpa.setBounds(230,400,250,40);
		gpa.setFont(font2);
		gender=new JLabel("GENDER -> "+Gender);
		gender.setFont(font2);
		gender.setBounds(230,450,250,40);
		c.add(name);
        c.add(email);
        c.add(rno);
        c.add(contact);
        c.add(address);
        c.add(gpa);
        c.add(gender);

        
		
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        setVisible(true);
        EditDetails.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                EditDetails obj=new EditDetails(NAME);
                setVisible(false);
                obj.setVisible(true);
                
            }
            
        });
        goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Studentdashboard mg=new Studentdashboard(nn);
                setVisible(false);
                mg.setVisible(true);
                
            }
            
        });
		 
	}
	public static void main(String[] args) {
	 new StudentDetails("");
	}

}

