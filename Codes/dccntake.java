
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.awt.*;
import java.sql.*;
 class dccntake extends JFrame{
    public static Container h;
	public static JButton takeexam,checkresult,goback;
    static final String DB_URL = "jdbc:mysql://localhost:3306/examination_module";
    static final String USER = "root";
    static final String PASS = "";
    Connection conn;
    Statement st;
    static String n="",r="";
    public dccntake(){
        setTitle("DCCN TAKE");
        setSize(600,500);
        setLocation(400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		h.setLayout(null);
        Font font2=new Font("Agency FB",Font.BOLD,30);
        takeexam=new JButton("TAKE EXAM");
        takeexam.setBounds(200,50,200,70);
        takeexam.setFont(font2);
        checkresult=new JButton("Check result");
        checkresult.setBounds(200,150,200,70);
        checkresult.setFont(font2);
        goback=new JButton("goback");
        goback.setBounds(200,250,200,70);
        goback.setFont(font2);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        takeexam.setCursor(cur);
        checkresult.setCursor(cur);
        goback.setCursor(cur);
        h.add(takeexam);
        h.add(checkresult);
        h.add(goback);
       
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
                Examdashboard oj=new Examdashboard();
                n="";
                r="";
                setVisible(false);
                oj.setVisible(true);
                
                
            }
        
        });

        checkresult.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    //String q="Select * from response where Student_name='"+n+"' and rollno='"+r+"' and Test_name='DCCN'";
                    //ResultSet rs=st.executeQuery(q);
                    JFrame frame=new JFrame();
                    JPanel panel = new JPanel(new BorderLayout(5, 5));
                    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
                    label.add(new JLabel("Name", SwingConstants.RIGHT));
                    label.add(new JLabel("Roll Number", SwingConstants.RIGHT));
                    panel.add(label, BorderLayout.WEST);
                    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
                    JTextField Name = new JTextField();
                    controls.add(Name);
                    JTextField Rollno = new JTextField();
                    controls.add(Rollno);
                    panel.add(controls, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(frame, panel, "Enter Details", JOptionPane.QUESTION_MESSAGE);
                     n=Name.getText();
                     r=Rollno.getText();
                    if(n.length()==0 || r.length()==0){
                        JOptionPane.showMessageDialog(null," ✌ Enter the details properly✌","Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        String query="Select * from response where Student_name='"+n+"' and rollno='"+r+"' and Test_name='DCCN'";
                        ResultSet res=st.executeQuery(query);
                    if(res.next()==true){
                        String sc=res.getString("score");
                        String message="Score of "+n+" in DCCN is-> "+sc;
                        JOptionPane.showMessageDialog(null,message,"Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Name not Registered","Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                }


                }
                catch(SQLException f){
                    f.printStackTrace();
                }
                
            }
            
        });
        takeexam.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    JFrame frame=new JFrame();
                    JPanel panel = new JPanel(new BorderLayout(5, 5));
                    JPanel label = new JPanel(new GridLayout(0, 1, 2, 2));
                    label.add(new JLabel("Name", SwingConstants.RIGHT));
                    label.add(new JLabel("Roll Number", SwingConstants.RIGHT));
                    panel.add(label, BorderLayout.WEST);
                    JPanel controls = new JPanel(new GridLayout(0, 1, 2, 2));
                    JTextField Name = new JTextField();
                    controls.add(Name);
                    JTextField Rollno = new JTextField();
                    controls.add(Rollno);
                    panel.add(controls, BorderLayout.CENTER);
                    JOptionPane.showMessageDialog(frame, panel, "Enter Details", JOptionPane.QUESTION_MESSAGE);
                     n=Name.getText();
                     r=Rollno.getText();
                    if(n.length()==0 || r.length()==0){
                        JOptionPane.showMessageDialog(null," ✌ Enter the details properly✌","Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        String query="Select Student_name,rollno from response where Student_name='"+n+"' and rollno='"+r+"' and Test_name='DCCN'";
                    ResultSet res=st.executeQuery(query);
                    if(res.next()==true){
                        JOptionPane.showMessageDialog(null," ✌ You have Given the Test with this name and roll number ✌","Message",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        String query2="Select * from examination where Test_name='DCCN'";
                        ResultSet res2=st.executeQuery(query2);
                        String tn="",sub="";
                        if(res2.next()){
                            tn=res2.getString("Test_name");
                            sub=res2.getString("subject_code");
                        }
                        String mainq="Insert into response(Student_name,rollno,subject_code,Test_name,score) value('"+n+"','"+r+"','"+sub+"','"+tn+"',"+0+")";
                        st.executeUpdate(mainq);
                        dccnexam exe=new dccnexam(r);
                        setVisible(false);
                        exe.setVisible(true);
                    }

                    }
                    


                }
                catch(SQLException r){
                    r.printStackTrace();
                }
                
            }
            
        });
        
    }
    public static void main(String[] args) {
        new dccntake();
        
    }
}

