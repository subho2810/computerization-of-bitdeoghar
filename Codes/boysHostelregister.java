
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
class boysHostelregister extends JFrame{
	
	public static Container h;
	public static JLabel Name,Roomno,Rno,Hostelname,R1,R2,label,Contact,Password;
	public static JTextField name,roomno,rno,hostelname,r1,r2,contact;
	
	public static JButton register,gotologin;
	public static JPasswordField pswd;
   static final String DB_URL = "jdbc:mysql://localhost:3306/boys_hostel_module";
   static final String USER = "root";
   static final String PASS = "";
   Connection conn;
   Statement st;
	public boysHostelregister() {
        setTitle(" Boys Hostel Register FORM");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
		
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/boysregister.png"));
	    h.add(c);
		Font font=new Font("Century Schoolbook",Font.BOLD,20);
        Font font2=new Font("Agency FB",Font.BOLD,25);
		Border br=BorderFactory.createLineBorder(Color.BLACK,2);
		label=new JLabel("BOYS");
		label.setFont(new Font("Agency FB",Font.BOLD,40));
		label.setBounds(950,150,300,50);
		Name=new JLabel("NAME");
		name=new JTextField("");
		Name.setBounds(500,250,120,50);
		Name.setFont(font2);
		name.setBounds(620,250,300,40);
		name.setFont(font);
		Roomno=new JLabel("ROOM NO.");
		roomno=new JTextField("");
		Roomno.setBounds(1000,250,200,40);
		Roomno.setFont(font2);
		roomno.setBounds(1150,250,200,40);
	    roomno.setFont(font);
		Rno=new JLabel("ROLL NO.");
		rno=new JTextField("");
		Rno.setBounds(500,350,200,40);
		Rno.setFont(font2);
		rno.setBounds(620,350,200,40);
		rno.setFont(font);
		Hostelname=new JLabel("HOSTEL NAME");
		hostelname=new JTextField("");
		Hostelname.setBounds(1000,350,200,40);
		Hostelname.setFont(font2);
		hostelname.setBounds(1150,350,200,40);
		hostelname.setFont(font);
		Contact=new JLabel("CONTACT");
		contact=new JTextField("");
		Contact.setBounds(1000,450,200,40);
		Contact.setFont(font2);
		contact.setBounds(1150,450,200,50);
		contact.setFont(font);
		R1=new JLabel("ROOMATE 1");
		r1=new JTextField("");
		R1.setBounds(500,450,100,40);
		R1.setFont(font2);
		r1.setBounds(620,450,200,40);
		r1.setFont(font);
		R2=new JLabel("ROOMATE 2");
		r2=new JTextField("");
		R2.setFont(font2);
		R2.setBounds(500,550,100,40);
		r2.setBounds(620,550,200,40);
		r2.setFont(font);
		Password=new JLabel("PASSWORD");
        pswd=new JPasswordField("");
		Password.setFont(font2);
		pswd.setFont(font);
		Password.setBounds(500,650,100,40);
		pswd.setBounds(620,650,200,40);
		register =new JButton("Click To Save");
		register.setFont(font2);
		register.setBounds(900,650,200,50);
		gotologin =new JButton("Go to Login");
		gotologin.setFont(font2);
		gotologin.setBounds(1150,650,200,50);
		pswd.setBorder(br);
		contact.setBorder(br);
		hostelname.setBorder(br);
		name.setBorder(br);
		r1.setBorder(br);
		rno.setBorder(br);
		roomno.setBorder(br);
		r2.setBorder(br);
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        register.setCursor(cur);
		gotologin.setCursor(cur);
	    c.add(label);
		c.add(gotologin);
		c.add(register);
		c.add(Password);
		c.add(pswd);
		c.add(R1);
		c.add(r1);
		c.add(R2);
		c.add(r2);
		c.add(contact);
		c.add(Contact);
		c.add(hostelname);
		c.add(Hostelname);
		c.add(Rno);
		c.add(rno);
		c.add(roomno);
		c.add(Roomno);
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
					String ROOMNO=roomno.getText();
					String RNO=rno.getText();
					String Room1=r1.getText();
					char ch[]=pswd.getPassword();
					String PASSWORD="";
					for(int i=0;i<ch.length;i++){PASSWORD=PASSWORD+ch[i];}
					String CONTACT=contact.getText();
					String HOSTELNAME=hostelname.getText();
					String Room2=(r2.getText());
					count=(NAME.length()==0)?count+1:count;
					count=(RNO.length()==0)?count+1:count;
					count=(ROOMNO.length()==0)?count+1:count;
					count=(CONTACT.length()==0)?count+1:count;
					count=(Room1.length()==0)?count+1:count;
					count=(ch.length==0)?count+1:count;
					count=(HOSTELNAME.length()==0)?count+1:count;
					count=(Room2.length()==0)?count+1:count;
				ResultSet res=st.executeQuery("Select Boys_name,rollno from boys where Boys_name='"+NAME+"' or rollno='"+RNO+"'");
				if(res.next()==true){
					JOptionPane.showMessageDialog(null,"Already Registered Try Again","Error",JOptionPane.ERROR_MESSAGE);
							
				}
				else if(count>0){
					JOptionPane.showMessageDialog(null,"FILL THE FORM  PROPERLY","Error",JOptionPane.ERROR_MESSAGE);
				}
				else{
					String x="Insert into boys(Boys_name,rollno,Roomno,Roommate_1,Roommate_2,Contact,Hostel_name,password) values('"+NAME+"','"+RNO+"','"+ROOMNO+"','"+Room1+"','"+Room2+"','"+CONTACT+"','"+HOSTELNAME+"','"+PASSWORD+"')";
					st.executeUpdate(x);
					JOptionPane.showMessageDialog(null," ✌ User Registered ✌","Message",JOptionPane.INFORMATION_MESSAGE);
				}
				name.setText("");
				rno.setText("");
				roomno.setText("");
				r1.setText("");
				contact.setText("");
				hostelname.setText("");
				pswd.setText("");
				r2.setText("");

				
				}
				catch(SQLException h){
					h.printStackTrace();
				}
				
			}
			
		});
		gotologin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				loginboys lg=new loginboys();
				setVisible(false);
				lg.setVisible(true);
				
				
			}
			
		});
        
	}
	public static void main(String[] args) {
	 new boysHostelregister();
	}

}