
import java.sql.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
 class EditDetails extends JFrame{
    public static Container h;
	public static JButton pswd,GPA,Contact,EMAIL,goback;
    static final String DB_URL = "jdbc:mysql://localhost:3306/computer_science_module";
    static final String USER = "root";
    static final String PASS = "";
    Connection conn;
    Statement st;
    public EditDetails(String N){
        setTitle("MODULE PAGE");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/editprofile.png"));
	    h.add(c);
        Font font2=new Font("Agency FB",Font.BOLD,30);
        pswd=new JButton("Edit Password");
        pswd.setBounds(750,200,200,70);
        pswd.setFont(font2);
        Contact=new JButton("Edit Contact");
        Contact.setBounds(750,310,200,70);
        Contact.setFont(font2);
        GPA=new JButton("Edit GPA");
        GPA.setBounds(750,420,200,70);
        GPA.setFont(font2);
        EMAIL=new JButton("Edit EMAIL");
        EMAIL.setBounds(750,520,200,70);
        EMAIL.setFont(font2);
        goback=new JButton("Go Back");
        goback.setBounds(750,620,200,70);
        goback.setFont(font2);

        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        pswd.setCursor(cur);
        Contact.setCursor(cur);
        GPA.setCursor(cur);
        EMAIL.setCursor(cur);
        c.add(pswd);
        c.add(Contact);
        c.add(GPA);
        c.add(EMAIL);
        c.add(goback);
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
        
        pswd.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
                try{
                    JFrame frame=new JFrame();
                    String query1="SeLect * from student where name='"+N+"'";
                    ResultSet res=st.executeQuery(query1);
                    String pass="";
                    if(res.next()){
                        pass=res.getString("password");
                    }
                    JPanel panel = new JPanel(new BorderLayout(5, 5));
                    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
                    label.add(new JLabel("current Password", SwingConstants.RIGHT));
                    label.add(new JLabel("new Password", SwingConstants.RIGHT));
                    panel.add(label, BorderLayout.WEST);
                    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
                    JPasswordField currentpassword = new JPasswordField();
                    controls.add(currentpassword);
                    JPasswordField newpassword = new JPasswordField();
                    controls.add(newpassword);
                    panel.add(controls, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(frame, panel, "Edit Password", JOptionPane.QUESTION_MESSAGE);
                      char ch[]=currentpassword.getPassword();
					  String PASSWORD="";
					  for(int i=0;i<ch.length;i++){PASSWORD=PASSWORD+ch[i];}
                    if(pass.equals(PASSWORD)==true){
                      char ch1[]=newpassword.getPassword();
					  String PASSWORD1="";
					  for(int i=0;i<ch1.length;i++){PASSWORD1=PASSWORD1+ch1[i];}
                      String query2="Update student set password='"+PASSWORD1+"' where name='"+N+"'";
                      st.executeUpdate(query2);
                      JOptionPane.showMessageDialog(null," ✌ Password  changed ✌","Message",JOptionPane.INFORMATION_MESSAGE);
				}

                    
                    else{
                        JOptionPane.showMessageDialog(null," ✌ Current Password invalid  ✌","Message",JOptionPane.ERROR_MESSAGE);
                    }
                        
                }
                catch(SQLException h){
                    h.printStackTrace();
                }
                

            }
            
        });
        Contact.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JFrame frame=new JFrame();
                   
                    JPanel panel = new JPanel(new BorderLayout(5, 5));
                    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
                    label.add(new JLabel("new  Contact", SwingConstants.RIGHT));
                    panel.add(label, BorderLayout.WEST);
                    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
                    JTextField newContact = new JTextField();
                    controls.add(newContact);
                    panel.add(controls, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(frame, panel, "Edit Contact", JOptionPane.QUESTION_MESSAGE);
                     ResultSet res=st.executeQuery("Select * from student where contact='"+newContact.getText()+"'");
                     if(res.next()==true){
                        JOptionPane.showMessageDialog(null," ✌ Contact Already Registered ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                     }
                     else if(newContact.getText().length()==0){
                        JOptionPane.showMessageDialog(null," ✌ Fill the Contact ✌","Message",JOptionPane.ERROR_MESSAGE);
                     }
                     else{
                        String query2="Update student set contact='"+newContact.getText()+"' where name='"+N+"'";
                        st.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null," ✌ Contact Changed ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                     }
                      
                        
                }
                catch(SQLException h){
                    h.printStackTrace();
                }
                
            }

        });
        EMAIL.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JFrame frame=new JFrame();
                   
                    JPanel panel = new JPanel(new BorderLayout(5, 5));
                    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
                    label.add(new JLabel("new  EMAIL", SwingConstants.RIGHT));
                    panel.add(label, BorderLayout.WEST);
                    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
                    JTextField newEMAIL = new JTextField();
                    controls.add(newEMAIL);
                    panel.add(controls, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(frame, panel, "Edit EMAIL", JOptionPane.QUESTION_MESSAGE);
                     ResultSet res=st.executeQuery("Select * from student where email='"+newEMAIL.getText()+"'");
                     if(res.next()==true){
                        JOptionPane.showMessageDialog(null," ✌ Email Already Registered ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                     }
                     else if(newEMAIL.getText().length()==0){
                        JOptionPane.showMessageDialog(null," ✌ Fill the EMAIL ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                     }
                     else{
                        String query2="Update student set email='"+newEMAIL.getText()+"' where name='"+N+"'";
                        st.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null," ✌ EMAIL CHANGED ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                     }
                      
                        
                }
                catch(SQLException h){
                    h.printStackTrace();
                }
                
            }

        });
        GPA.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JFrame frame=new JFrame();
                   
                    JPanel panel = new JPanel(new BorderLayout(5, 5));
                    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
                    label.add(new JLabel("present new GPA", SwingConstants.RIGHT));
                    panel.add(label, BorderLayout.WEST);
                    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
                    JTextField newGPA = new JTextField();
                    controls.add(newGPA);
                    panel.add(controls, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(frame, panel, "Edit EMAIL", JOptionPane.QUESTION_MESSAGE);
                     ResultSet res=st.executeQuery("Select * from student where gpa='"+newGPA.getText()+"'");
                     if(res.next()==true){
                        JOptionPane.showMessageDialog(null," ✌ Contact Already Registered ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                     }
                     else if(newGPA.getText().length()==0){
                        JOptionPane.showMessageDialog(null," ✌ Fill the GPA ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                     }
                     else{
                        String query2="Update student set gpa='"+newGPA.getText()+"' where name='"+N+"'";
                        st.executeUpdate(query2);
                        JOptionPane.showMessageDialog(null," ✌ GPA CHANGED ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                     }
                      
                        
                }
                catch(SQLException h){
                    h.printStackTrace();
                }
                
            }

        });

        goback.addActionListener(new ActionListener(){

            
            public void actionPerformed(ActionEvent e) {
                StudentDetails obb=new StudentDetails(N);
                setVisible(false);
                obb.setVisible(true);    
            }  
        });
        
       
    }
    
    public static void main(String[] args) {
        new EditDetails("");
        
    }
}