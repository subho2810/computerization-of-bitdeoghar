
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class StudentRegister extends JFrame{
	
	public static Container h;
	public static JLabel Name,Email,Rno,Contact,Gpa,Gender,label,Address,Password;
	public static JTextField name,email,rno,contact,gpa,gender;
	public static JTextArea address;
	public static JButton register,gotologin;
	public static JPasswordField pswd;
   static final String DB_URL = "jdbc:mysql://localhost:3306/computer_science_module";
   static final String USER = "root";
   static final String PASS = "";
   Connection conn;
   Statement st;
	public StudentRegister() {
        setTitle("Register FORM");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
		
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/final.png"));
	    h.add(c);
		Font font=new Font("Century Schoolbook",Font.BOLD,20);
        Font font2=new Font("Agency FB",Font.BOLD,25);
		Border br=BorderFactory.createLineBorder(Color.BLACK,2);
		label=new JLabel("STUDENT");
		label.setFont(new Font("Agency FB",Font.BOLD,40));
		label.setBounds(800,150,300,50);
		Name=new JLabel("NAME");
		name=new JTextField("");
		Name.setBounds(400,250,120,50);
		Name.setFont(font2);
		name.setBounds(520,250,300,40);
		name.setFont(font);
		Email=new JLabel("EMAIL ID");
		email=new JTextField("");
		Email.setBounds(900,250,200,40);
		Email.setFont(font2);
		email.setBounds(1000,250,300,40);
		email.setFont(font);
		Rno=new JLabel("ROLL NO.");
		rno=new JTextField("");
		Rno.setBounds(400,350,200,40);
		Rno.setFont(font2);
		rno.setBounds(520,350,200,40);
		rno.setFont(font);
		Contact=new JLabel("CONTACT");
		contact=new JTextField("");
		Contact.setBounds(900,350,200,40);
		Contact.setFont(font2);
		contact.setBounds(1000,350,200,40);
		contact.setFont(font);
		Address=new JLabel("ADDRESS");
		address=new JTextArea("");
		Address.setBounds(900,450,200,40);
		Address.setFont(font2);
		address.setBounds(1000,450,400,100);
		address.setFont(font);
		Gpa=new JLabel("GPA");
		gpa=new JTextField("");
		Gpa.setBounds(400,450,100,40);
		Gpa.setFont(font2);
		gpa.setBounds(520,450,100,40);
		gpa.setFont(font);
		Gender=new JLabel("GENDER");
		gender=new JTextField("");
		Gender.setFont(font2);
		Gender.setBounds(400,550,100,40);
		gender.setBounds(520,550,100,40);
		gender.setFont(font);
		Password=new JLabel("PASSWORD");
        pswd=new JPasswordField("");
		Password.setFont(font2);
		pswd.setFont(font);
		Password.setBounds(400,650,100,40);
		pswd.setBounds(520,650,200,40);
		register =new JButton("Click To Save");
		register.setFont(font2);
		register.setBounds(800,650,200,50);
		gotologin =new JButton("Go to Login");
		gotologin.setFont(font2);
		gotologin.setBounds(1050,650,200,50);
		pswd.setBorder(br);
		address.setBorder(br);
		contact.setBorder(br);
		name.setBorder(br);
		gpa.setBorder(br);
		rno.setBorder(br);
		email.setBorder(br);
		gender.setBorder(br);
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        register.setCursor(cur);
		gotologin.setCursor(cur);
	    c.add(label);
		c.add(gotologin);
		c.add(register);
		c.add(Password);
		c.add(pswd);
		c.add(Gender);
		c.add(gender);
		c.add(Gpa);
		c.add(gpa);
		c.add(Address);
		c.add(address);
		c.add(Contact);
		c.add(contact);
		c.add(Rno);
		c.add(rno);
		c.add(email);
		c.add(Email);
		c.add(Name);
		c.add(name);
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
		try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
             st = conn.createStatement();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
		        
		register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
                try{
					int count=0;
					String NAME=name.getText();
					String EMAIL=email.getText();
					String RNO=rno.getText();
					String GENDER=gender.getText();
					char ch[]=pswd.getPassword();
					String PASSWORD="";
					for(int i=0;i<ch.length;i++){PASSWORD=PASSWORD+ch[i];}
					String ADDRESS=address.getText();
					String CONTACT=contact.getText();
					String GPA=(gpa.getText());
					count=(NAME.length()==0)?count+1:count;
					count=(RNO.length()==0)?count+1:count;
					count=(EMAIL.length()==0)?count+1:count;
					count=(ADDRESS.length()==0)?count+1:count;
					count=(GENDER.length()==0)?count+1:count;
					count=(ch.length==0)?count+1:count;
					count=(CONTACT.length()==0)?count+1:count;
					count=(GPA.length()==0)?count+1:count;
				ResultSet res=st.executeQuery("Select name,rollno from student where name='"+NAME+"' or rollno='"+RNO+"' or email='"+EMAIL+"'");
				if(res.next()==true){
					JOptionPane.showMessageDialog(null,"Already Registered Try Again","Error",JOptionPane.ERROR_MESSAGE);
							
				}
				else if(count>0){
					JOptionPane.showMessageDialog(null,"FILL THE FORM  PROPERLY","Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					String x="Insert into student(rollno,name,email,address,contact,gender,gpa,image,password) values('"+RNO+"','"+NAME+"','"+EMAIL+"','"+ADDRESS+"','"+CONTACT+"','"+GENDER.toLowerCase()+"','"+GPA+"','"+RNO+"','"+PASSWORD+"')";
					st.executeUpdate(x);
					JOptionPane.showMessageDialog(null," ✌ User Registered ✌","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				name.setText("");
				rno.setText("");
				email.setText("");
				gpa.setText("");
				address.setText("");
				contact.setText("");
				pswd.setText("");
				gender.setText("");

				
				}
				catch(SQLException h){
					h.printStackTrace();
				}
				
			}
			
		});
		gotologin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				StudentLoginForm lg=new StudentLoginForm("STUDENT");
				setVisible(false);
				lg.setVisible(true);
				
				
			}
			
		});
        
	}
	public static void main(String[] args) {
	 new StudentRegister();
	}

}