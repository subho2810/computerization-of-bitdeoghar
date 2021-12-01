
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class StudentsData extends JFrame{
    public static JLabel c;
    public static JTable table1;
    public static JScrollPane scrollPane;
    public static DefaultTableModel model;
    public static DefaultTableCellRenderer cellRenderer;
    public static Container h;
    public static JButton showgirls,showboys,showall,goback;
    public static JLabel label;
    static final String DB_URL = "jdbc:mysql://localhost:3306/computer_science_module";
    static final String USER = "root";
    static final String PASS = "";
    static public Object[][]data1;
    public static  boolean status;
    Connection conn;
    Statement st;
    public static String nn;
    public StudentsData(String NAME){
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
         showgirls=new JButton("show girls");
         showgirls.setBounds(20,20,150,60);
         showgirls.setBorder(br);
         showgirls.setFont(font2);
         panel.add(showgirls);
         showboys=new JButton("show boys");
         showboys.setBounds(190,20,150,60);
         showboys.setBorder(br);
         showboys.setFont(font2);
         panel.add(showboys);
         showall=new JButton("show all students");
         showall.setBounds(360,20,150,60);
         showall.setBorder(br);
         showall.setFont(font2);
         panel.add(showall);
         label=new JLabel(" STUDENTS DATA ");
         label.setBounds(700,20,500,60);
         label.setFont(font);
         panel.add(label);
         goback=new JButton("Go back");
         goback.setBounds(1300,20,150,60);
         goback.setBorder(br);
         goback.setFont(font2);
         panel.add(goback);
         h.add(panel);
         setVisible(true);
         
         showall.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                data1=getStudentData(1);
                makeTable();
                setVisible(true);

                
            }
             
         });
         showgirls.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                data1=getStudentData(2);
                makeTable();
                setVisible(true);

                
            }
             
         });
         showboys.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                data1=getStudentData(3);
                makeTable();
                setVisible(true);

                
            }
             
         });
         
         
         goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Facultydashboard obb=new Facultydashboard(NAME);
                setVisible(false);
                obb.setVisible(true);
                
            }
             
         });
    }
    public Object[][] getStudentData(int x) {

		Object data[][]=null;
		try {

			String QUERY="";
            int r=0,c=6;
            switch(x){
                case 1: QUERY="select rollno,name,email,address,contact,gpa from student";
                r=53;
                break;
                case 2: QUERY="select name,email,contact,address,rollno,gpa from student where gender='female'";
                r=15;
                break;
                case 3: QUERY="select name,email,contact,address,rollno,gpa from student where gender='male'";
                r=38;
                break;
            }
            ResultSet res=st.executeQuery(QUERY);
			 data = new Object[r][c];
			int i = 0;
			while (res.next()) {
				int j = 0;
				data[i][j++] = res.getString("rollno");
				data[i][j++] = res.getString("name");
				data[i][j++] = res.getString("email");
				data[i][j++] = res.getString("address");
                data[i][j++] = res.getString("contact");
                data[i][j++] = res.getString("gpa");
				i++;
			}
			status = true;
            
		} catch (Exception e) {
			e.printStackTrace();
		}
	   return data;
    }
	@Override
	public String toString() {
		
		return (status) ? "Data Listed Successfully" : "Application Error Occured";
	}
   static  public void makeTable(){
        JPanel panel2=new JPanel();
         panel2.setBounds(300,130,1000,600);
         panel2.setBackground(Color.white);
         String columnnames[]={"ROLL NUMBER","NAME","EMAIL ID","ADDRESS","CONTACT","GPA"};
          h.add(panel2);
          DefaultTableModel model1=new DefaultTableModel(data1,columnnames);
                table1=new JTable(model1);
        TableColumn column = table1.getColumnModel().getColumn(0);
         TableColumn column11 = table1.getColumnModel().getColumn(1);
         TableColumn column21 = table1.getColumnModel().getColumn(2);
         TableColumn column31 = table1.getColumnModel().getColumn(3);
         TableColumn column41 = table1.getColumnModel().getColumn(4);
         TableColumn column51 = table1.getColumnModel().getColumn(5);
         
          table1.setRowHeight(30);
          column.setPreferredWidth(200);
          column11.setPreferredWidth(200);
          column21.setPreferredWidth(400);
          column31.setPreferredWidth(400);
          column41.setPreferredWidth(150);
          column51.setPreferredWidth(100);
          table1.setEnabled(false);
          
          JScrollPane scrollpane = new JScrollPane(table1);
          scrollpane.setPreferredSize(new Dimension(1000, 590));
          panel2.add(new JScrollPane(scrollpane));
          
   
        

    }


    public static void main(String[] args) {
        StudentsData cc=new StudentsData(nn);
        cc.setVisible(true);
    }
}
