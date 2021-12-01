
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.*;



import java.awt.*;
import java.awt.event.*;
import java.sql.*;
class messMenu extends JFrame{
    public static JLabel c;
    public static JTable table;
    public static JScrollPane scrollPane;
    public static DefaultTableModel model;
    public static DefaultTableCellRenderer cellRenderer;
    public static Container h;
    public static JButton messmenub,messTimeb,goback;
    public static JLabel label;
    static final String DB_URL = "jdbc:mysql://localhost:3306/boys_hostel_module";
    static final String USER = "root";
    static final String PASS = "";
    static public Object[][]data;
    public static  boolean status;
    Connection conn;
    Statement st;
    public static String nn;
    public messMenu(String NAME){
        nn=NAME;
        setTitle("Mess Menu PAGE");
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
        
         messmenub=new JButton("Mess Menu");
         messmenub.setBounds(80,20,150,60);
         messmenub.setBorder(br);
         messmenub.setFont(font2);
         panel.add(messmenub);
         label=new JLabel(" MESS MENU DETAILS ");
         label.setBounds(550,20,500,60);
         label.setFont(font);
         panel.add(label);
         goback=new JButton("Go back");
         goback.setBounds(1300,20,150,60);
         goback.setBorder(br);
         goback.setFont(font2);
         panel.add(goback);
         h.add(panel);
         setVisible(true);
         
         messmenub.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                data=getEmployeeDetails();
                makeTable();
                setVisible(true);

                
            }
             
         });
         
         goback.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                BoysHosteldashboard obb=new BoysHosteldashboard(NAME);
                setVisible(false);
                obb.setVisible(true);
                
            }
             
         });
    }
    public Object[][] getEmployeeDetails() {

		Object[][] data = null;
		try {

			String QUERY="";
            
            QUERY="Select * from messmenu";
            ResultSet res=st.executeQuery(QUERY);
		

			data = new Object[7][6];

			

			int i = 0;
			
			while (res.next()) {

				int j = 0;

				data[i][j++] = res.getInt("Number");
				data[i][j++] = res.getString("Weekdays");
				data[i][j++] = res.getString("breakfast");
				data[i][j++] = res.getString("Lunch");
				data[i][j++] = res.getString("Snacks");
                data[i][j++] = res.getString("Dinner");

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
         String columnnames[]={"NUMBER","WEEKDAYS","BREAKFAST","LUNCH","SNACKS","DINNER"};
          h.add(panel2);
          DefaultTableModel model=new DefaultTableModel(data,columnnames);
                table=new JTable(model);
                TableColumn column = table.getColumnModel().getColumn(0);
         TableColumn column1 = table.getColumnModel().getColumn(1);
         TableColumn column2 = table.getColumnModel().getColumn(2);
         TableColumn column3 = table.getColumnModel().getColumn(3);
         TableColumn column4 = table.getColumnModel().getColumn(4);
         TableColumn column5 = table.getColumnModel().getColumn(5);
        
          table.setRowHeight(30);
          column.setPreferredWidth(100);
          column1.setPreferredWidth(200);
          column2.setPreferredWidth(250);
          column3.setPreferredWidth(300);
          column4.setPreferredWidth(350);
          column5.setPreferredWidth(400);
          
          table.setEnabled(false);
          
          JScrollPane scrollpane = new JScrollPane(table);
          scrollpane.setPreferredSize(new Dimension(1000, 590));
          panel2.add(new JScrollPane(scrollpane));
          
   
        

    }


    public static void main(String[] args) {
       new  messMenu("");
    }
}
