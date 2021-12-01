
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;
import java.awt.*;
class GPAcalculator extends JFrame{
   public static Container h;
   public static JLabel marks,label,se,flat,dccn,oe,pe,dbms,selab,dccnlab,dbmslab,shelllab;
   public static JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10;
   public static JButton cal,goback,clear;
   static final String DB_URL = "jdbc:mysql://localhost:3306/computer_science_module";
   static final String USER = "root";
   static final String PASS = "";
   Connection conn;
   Statement st;
	public GPAcalculator(String x) {
        setTitle("GPA CALCULATOR");
        setSize(1500,800);
        setLocation(20, 20);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		JLabel c=new JLabel(new ImageIcon("maincodes/images/gpa.png"));
	    h.add(c);
        Font font2=new Font("Agency FB",Font.BOLD,25);
        Border br=BorderFactory.createLineBorder(Color.BLACK,2);
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
        se=new JLabel("Software Engineering ");
        se.setBounds(330,200,400,40);
        se.setFont(font2);
        t1=new JTextField();
        t1.setBounds(250,200,70,40);
        t1.setFont(font2);
        dbms=new JLabel("Database Management System ");
        dbms.setBounds(330,270,400,40);
        dbms.setFont(font2);
        t2=new JTextField();
        t2.setBounds(250,270,70,40);
        t2.setFont(font2);
        flat=new JLabel("Formal Language and Automata Theory ");
        flat.setBounds(330,340,400,40);
        flat.setFont(font2);
        t3=new JTextField();
        t3.setBounds(250,340,70,40);
        t3.setFont(font2);
        dccn=new JLabel("Data Communucation and Computer Networks ");
        dccn.setBounds(330,410,400,40);
        dccn.setFont(font2);
        t4=new JTextField();
        t4.setBounds(250,410,70,40);
        t4.setFont(font2);
        pe=new JLabel("Program Elective ");
        pe.setBounds(330,480,400,40);
        pe.setFont(font2);
        t5=new JTextField();
        t5.setBounds(250,480,70,40);
        t5.setFont(font2);
        oe=new JLabel("OEPN Elective ");
        oe.setBounds(330,550,400,40);
        oe.setFont(font2);
        t6=new JTextField();
        t6.setBounds(250,550,70,40);
        t6.setFont(font2);
        selab=new JLabel("SE LAB ");
        selab.setBounds(800,200,400,40);
        selab.setFont(font2);
        t7=new JTextField();
        t7.setBounds(720,200,70,40);
        t7.setFont(font2);
        dccnlab=new JLabel("DCCN LAB ");
        dccnlab.setBounds(800,270,400,40);
        dccnlab.setFont(font2);
        t8=new JTextField();
        t8.setBounds(720,270,70,40);
        t8.setFont(font2);
        dbmslab=new JLabel("DBMS LAB ");
        dbmslab.setBounds(800,340,400,40);
        dbmslab.setFont(font2);
        t9=new JTextField();
        t9.setBounds(720,340,70,40);
        t9.setFont(font2);
        shelllab=new JLabel("SHELL LAB ");
        shelllab.setBounds(800,410,400,40);
        shelllab.setFont(font2);
        t10=new JTextField();
        t10.setBounds(720,410,70,40);
        t10.setFont(font2);
        label=new JLabel("A+=10 (90-100) , A=9 (80-89) , B=8 (70-79) , C=7 (60-69) , D=6 (50-59) , E=5 (40-49) , F=0 (<40) ");
        label.setBounds(400,660,900,50);
        label.setFont(font2);
        goback=new JButton("GO BACK");
        clear=new JButton("Clear");
        cal=new JButton("Calculate");
        cal.setBounds(600,550,150,40);
        cal.setFont(font2);
        clear.setBounds(800,550,150,40);
        clear.setFont(font2);
        goback.setBounds(1000,550,150,40);
        goback.setFont(font2);
        marks=new JLabel(" Your GPA IS -> 9.3");
        marks.setBounds(1050,300,280,50);
        marks.setFont(new Font("Agency FB",Font.BOLD,40));
        marks.setBorder(br);
        goback.setBorder(br);
        cal.setBorder(br);
        clear.setBorder(br);
        marks.setForeground(Color.ORANGE);
        marks.setVisible(false);
        c.add(marks);
        
        
        c.add(se);
        c.add(t1);
        c.add(dbms);
        c.add(t2);
        c.add(flat);
        c.add(t3);
        c.add(dccn);
        c.add(t4);
        c.add(pe);
        c.add(t5);
        c.add(oe);
        c.add(t6);
        c.add(selab);
        c.add(t7);
        c.add(dccnlab);
        c.add(t8);
        c.add(dbmslab);
        c.add(t9);
        c.add(shelllab);
        c.add(t10);
        c.add(label);
        c.add(cal);
        c.add(goback);
        c.add(clear);
        setVisible(true);
        int grade[]={10,9,8,7,6,5,0};
        String[] gr={"A+","A","B","C","D","E","F"};
        ArrayList<String> grd= new ArrayList<String>(Arrays.asList(gr));
        goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Studentdashboard ff=new Studentdashboard(x);
                setVisible(false);
                ff.setVisible(true);
                
            }

        });
        clear.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {


                t1.setText("");
                t2.setText("");
                t3.setText("");
                t4.setText("");
                t5.setText("");
                t6.setText("");
                t7.setText("");
                t8.setText("");
                t9.setText("");
                t10.setText("");
                marks.setVisible(false);
            }
            
        });
        cal.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                int count=0;
                String tt1=t1.getText();
                String tt2=t2.getText();
                String tt3=t3.getText();
                String tt4=t4.getText();
                String tt5=t5.getText();
                String tt6=t6.getText();
                String tt7=t7.getText();
                String tt8=t8.getText();
                String tt9=t9.getText();
                String tt10=t10.getText();
                count=(tt1.length()==0)?count+1:count;
                count=(tt2.length()==0)?count+1:count;
                count=(tt3.length()==0)?count+1:count;
                count=(tt4.length()==0)?count+1:count;
                count=(tt5.length()==0)?count+1:count;
                count=(tt6.length()==0)?count+1:count;
                count=(tt7.length()==0)?count+1:count;
                count=(tt8.length()==0)?count+1:count;
                count=(tt9.length()==0)?count+1:count;
                count=(tt10.length()==0)?count+1:count;
                if(count>0){
					JOptionPane.showMessageDialog(null,"FILL THE Grader Properly","Error",JOptionPane.ERROR_MESSAGE);
				}
                else{
                    double sum=0;
                    int index=grd.indexOf(tt4);
                    sum=sum+grade[index]*4;
                    index=grd.indexOf(tt7);
                    sum=sum+grade[index]*1.5;
                    index=grd.indexOf(tt8);
                    sum=sum+grade[index]*1.5;
                    index=grd.indexOf(tt9);
                    sum=sum+grade[index]*1.5;
                    index=grd.indexOf(tt10);
                    sum=sum+grade[index]*1.5;
                    index=grd.indexOf(tt1);
                    sum=sum+grade[index]*3;
                    index=grd.indexOf(tt2);
                    sum=sum+grade[index]*3;
                    index=grd.indexOf(tt3);
                    sum=sum+grade[index]*3;
                    index=grd.indexOf(tt5);
                    sum=sum+grade[index]*3;
                    index=grd.indexOf(tt6);
                    sum=sum+grade[index]*3;
                    sum=sum/25.0;
                    String ans=Double.toString(sum);
                    ans=ans.substring(0,3);
                    marks.setText(" Your GPA is -> "+ans);
                    marks.setVisible(true);
                

                }

                
            }
            
        });
		
	    
		
        
	}
	public static void main(String[] args) {
	 new GPAcalculator("");
	}

}


