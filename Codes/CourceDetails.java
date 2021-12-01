
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class CourceDetails extends JFrame{
    public static JLabel c;
    public static JTable table;
    public static JScrollPane scrollPane;
    public static DefaultTableModel model;
    public static DefaultTableCellRenderer cellRenderer;
    public static Container h;
    public static JButton showmajor,showminor,showall,goback,showlab;
    public static JLabel label;
    static final String DB_URL = "jdbc:mysql://localhost:3306/computer_science_module";
    static final String USER = "root";
    static final String PASS = "";
    static public Object[][]data;
    public static  boolean status;
    Connection conn;
    Statement st;
    public static String nn;
    public CourceDetails(String NAME){
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
         showmajor=new JButton("Major Subject");
         showmajor.setBounds(20,20,150,60);
         showmajor.setBorder(br);
         showmajor.setFont(font2);
         panel.add(showmajor);
         showminor=new JButton("Minor Subject");
         showminor.setBounds(190,20,150,60);
         showminor.setBorder(br);
         showminor.setFont(font2);
         panel.add(showminor);
         showall=new JButton("show all Subject");
         showall.setBounds(360,20,150,60);
         showall.setBorder(br);
         showall.setFont(font2);
         panel.add(showall);
         showlab=new JButton("Show LABS");
         showlab.setBounds(550,20,150,60);
         showlab.setBorder(br);
         showlab.setFont(font2);
         panel.add(showlab);
         label=new JLabel(" COURCE DETAILS ");
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
         
         showall.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                data=getEmployeeDetails(1);
                makeTable();
                setVisible(true);

                
            }
             
         });
         showmajor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                data=getEmployeeDetails(2);
                makeTable();
                setVisible(true);

                
            }
             
         });
         showminor.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                data=getEmployeeDetails(3);
                makeTable();
                setVisible(true);

                
            }
             
         });
         showlab.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                data=getEmployeeDetails(4);
                makeTable();
                setVisible(true);

                
            }
             
         });
         
         goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                Studentdashboard obb=new Studentdashboard(NAME);
                setVisible(false);
                obb.setVisible(true);
                
            }
             
         });
    }
    public Object[][] getEmployeeDetails(int x) {

		Object[][] data = null;
		try {

			String QUERY="";
            int r=0,c=7;
            switch(x){
                case 1: QUERY="select c_name,c_id,c_type,c_credit,book1,book2,syllabus from course";
                r=11;
                break;
                case 2: QUERY="select c_name,c_id,c_type,c_credit,book1,book2,syllabus from course where major_minor='major'";
                r=4;
                break;
                case 3: QUERY="select c_name,c_id,c_type,c_credit,book1,book2,syllabus from course where major_minor='PE'";
                r=3;
                break;
                case 4: QUERY="select c_name,c_id,c_type,c_credit,book1,book2,syllabus from course where major_minor='LAB'";
                r=4;
            }
            ResultSet res=st.executeQuery(QUERY);
		

			data = new Object[r][c];

			

			int i = 0;
			
			while (res.next()) {

				int j = 0;

				data[i][j++] = res.getString("c_name");
				data[i][j++] = res.getString("c_id");
				data[i][j++] = res.getString("c_type");
				data[i][j++] = res.getString("c_credit");
				data[i][j++] = res.getString("book1");
                data[i][j++] = res.getString("book2");
                data[i][j++] = res.getString("Syllabus");

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
         String columnnames[]={"COURCE NAME","COURCE ID","COURCE TYPE","COURCE CREDIT","BOOK 1","BOOK 2","SYLLABUS"};
          h.add(panel2);
          DefaultTableModel model=new DefaultTableModel(data,columnnames);
                table=new JTable(model);
                TableColumn column = table.getColumnModel().getColumn(0);
         TableColumn column1 = table.getColumnModel().getColumn(1);
         TableColumn column2 = table.getColumnModel().getColumn(2);
         TableColumn column3 = table.getColumnModel().getColumn(3);
         TableColumn column4 = table.getColumnModel().getColumn(4);
         TableColumn column5 = table.getColumnModel().getColumn(5);
         TableColumn column6 = table.getColumnModel().getColumn(6);
          table.setRowHeight(30);
          column.setPreferredWidth(600);
          column1.setPreferredWidth(200);
          column2.setPreferredWidth(250);
          column3.setPreferredWidth(300);
          column4.setPreferredWidth(350);
          column5.setPreferredWidth(400);
          column6.setPreferredWidth(450);
          table.setEnabled(false);
          
          JScrollPane scrollpane = new JScrollPane(table);
          scrollpane.setPreferredSize(new Dimension(1000, 590));
          panel2.add(new JScrollPane(scrollpane));
          
   
        

    }


    public static void main(String[] args) {
        CourceDetails cc=new CourceDetails(nn);
        cc.setVisible(true);
    }
}
