import java.sql.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.awt.*;
class FacultyLoginForm extends JFrame{
    public static Container h;
	public static JLabel Name,Password,label;
	public static JTextField name;
	public static JButton login,signup,goback;
	public static JPasswordField pswd;
   static final String DB_URL = "jdbc:mysql://localhost:3306/computer_science_module";
   static final String USER = "root";
   static final String PASS = "";
   Connection conn;
   Statement st;
	public FacultyLoginForm(String x) {
        setTitle("LOGIN FORM");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
		
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/login.png"));
	    h.add(c);
		Font font=new Font("Century Schoolbook",Font.BOLD,20);
        Font font2=new Font("Agency FB",Font.BOLD,25);
		Border br=BorderFactory.createLineBorder(Color.BLACK,2);
		label=new JLabel(x);
		label.setFont(new Font("Agency FB",Font.BOLD,40));
		label.setBounds(870,150,300,50);
		Name=new JLabel("NAME");
		name=new JTextField("");
		Name.setBounds(740,350,120,50);
		Name.setFont(font2);
		name.setBounds(810,350,300,40);
		name.setFont(font);
		Password=new JLabel("PASSWORD");
        pswd=new JPasswordField("");
		Password.setFont(font2);
		pswd.setFont(font);
		Password.setBounds(740,450,100,40);
		pswd.setBounds(850,450,200,40);
		name.setBorder(br);
        pswd.setBorder(br);
        login =new JButton("LOGIN");
		login.setFont(font2);
		login.setBounds(750,540,150,50);
        signup =new JButton("Sign Up/Register");
		signup.setFont(font2);
		signup.setBounds(910,540,200,50);
		goback=new JButton("Go BACK");
        goback.setBounds(400,650,120,70);
        goback.setFont(font2);
		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        goback.setCursor(cur);
		signup.setCursor(cur);
		login.setCursor(cur);
        c.add(goback);
        c.add(signup);
        c.add(login);
	    c.add(label);
		c.add(Password);
		c.add(pswd);
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
        goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                cselog mg=new cselog();
                setVisible(false);
                mg.setVisible(true);
                
            }
            
        });
        signup.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                FacultyRegister rg=new FacultyRegister("FACULTY");
                setVisible(false);
                rg.setVisible(true);
                
            }
            
        });
		login.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String NAME=name.getText();
                    char ch[]=pswd.getPassword();
                    String PASSWORD="";
                    for(int i=0;i<ch.length;i++){PASSWORD=PASSWORD+ch[i];}
                    String query="Select name,password from faculty where name='"+NAME+"' and password='"+PASSWORD+"'";
                    ResultSet res=st.executeQuery(query);
                    if(res.next()==true){
                      JOptionPane.showMessageDialog(null," ✌ Press OK To LOGIN ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                      Facultydashboard oh=new Facultydashboard(NAME);
                      setVisible(false);
                      oh.setVisible(true);
                    }
                    else{
                      JOptionPane.showMessageDialog(null," ✌ NAME OR PASSWORD INVALID TRY AGAIN ✌","Message",JOptionPane.ERROR_MESSAGE);
                    }
                    name.setText("");
                    pswd.setText("");
              }
              catch(SQLException h){
                  h.printStackTrace();
              }

            }
            
        });
		
        
	}
	public static void main(String[] args) {
	new FacultyLoginForm("FACULTY");
	}

}

