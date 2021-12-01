
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.*;
import javax.swing.*;
class flatexam extends JFrame{
    public static Container h;
   static final String DB_URL = "jdbc:mysql://localhost:3306/examination_module";
   static final String USER = "root";
   static final String PASS = "";
    static final String card1Text = "Card 1";
    static final String card2Text = "Card 2";
    static final String card3Text = "Card 3";
    static final String card4Text = "Card 4";
    static public JButton submit;
     final JPanel cards; 
    static final String FIRST = "FIRST";
    static final String NEXT = "NEXT";
    static final String PREVIOUS = "PREVIOUS";
    static final String LAST = "LAST";
    static public int count=0;
    Connection conn;
    Statement st;
    static String rrn;
   public flatexam(String rr) {
       rrn=rr;
        setTitle("Formal Language and Automata Theory TEST");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
        Font font=new Font("Agency FB",Font.BOLD,20);
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

        String arr[][]=new String[4][6];
        ArrayList<String> anskey=new ArrayList<String>();
        
        try{
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            st = conn.createStatement();
            String query="Select * from flat";
            ResultSet res=st.executeQuery(query);
            int i=0;
            while(res.next()){
                int j=0;
                arr[i][j++]=Integer.toString(res.getInt("Question_number"));
                arr[i][j++]=res.getString("Question");
                arr[i][j++]=res.getString("OPTION_1");
                arr[i][j++]=res.getString("OPTION_2");
                arr[i][j++]=res.getString("OPTION_3");
                arr[i][j++]=res.getString("OPTION_4");
                anskey.add("  "+res.getString("answer"));
                i++;
            }
            System.out.println(anskey);
        }
        catch(SQLException e){
            e.printStackTrace();
        }  
        int i=0;
        JPanel card1 = new JPanel();
        card1.setLayout(null);
        card1.setBounds(10,10,1000,100);
        JLabel Question1=new JLabel("Q 1 "+arr[i][1]);
        JRadioButton op11=new JRadioButton("  "+arr[i][2]);
        JRadioButton op12=new JRadioButton("  "+arr[i][3]);
        JRadioButton op13=new JRadioButton("  "+arr[i][4]);
        JRadioButton op14=new JRadioButton("  "+arr[i][5]);
        ButtonGroup bg1=new ButtonGroup();    
        Question1.setBounds(500,100,900,50);
        op11.setBounds(500,200,300,50);
        op12.setBounds(500,250,300,50);
        op13.setBounds(500,300,300,50);
        op14.setBounds(500,350,300,50);
        Question1.setFont(new Font("Agency FB",Font.BOLD,30));
        op11.setFont(font);
        op12.setFont(font);
        op13.setFont(font);
        op14.setFont(font);
        bg1.add(op11);
        bg1.add(op12);
        bg1.add(op13);
        bg1.add(op14);
        card1.add(Question1);
        card1.add(op11);
        card1.add(op12);
        card1.add(op13);
        card1.add(op14);
        i++;
        JPanel card2 = new JPanel();
        card2.setLayout(null);
        card2.setBounds(10,10,1000,100);
        JLabel Question2=new JLabel("Q 2  "+arr[i][1]);
        JRadioButton op21=new JRadioButton("  "+arr[i][2]);
        JRadioButton op22=new JRadioButton("  "+arr[i][3]);
        JRadioButton op23=new JRadioButton("  "+arr[i][4]);
        JRadioButton op24=new JRadioButton("  "+arr[i][5]);
        ButtonGroup bg2=new ButtonGroup();    
        Question2.setBounds(500,100,900,50);
        op21.setBounds(500,200,300,50);
        op22.setBounds(500,250,300,50);
        op23.setBounds(500,300,300,50);
        op24.setBounds(500,350,300,50);
        Question2.setFont(new Font("Agency FB",Font.BOLD,30));
        op21.setFont(font);
        op22.setFont(font);
        op23.setFont(font);
        op24.setFont(font);
        bg2.add(op21);
        bg2.add(op22);
        bg2.add(op23);
        bg2.add(op24);
        card2.add(Question2);
        card2.add(op21);
        card2.add(op22);
        card2.add(op23);
        card2.add(op24);
        i++;
        JPanel card3 = new JPanel();
        card3.setLayout(null);
        card3.setBounds(10,10,1000,100);
        JLabel Question3=new JLabel("Q 3  "+arr[i][1]);
        JRadioButton op31=new JRadioButton("  "+arr[i][2]);
        JRadioButton op32=new JRadioButton("  "+arr[i][3]);
        JRadioButton op33=new JRadioButton("  "+arr[i][4]);
        JRadioButton op34=new JRadioButton("  "+arr[i][5]);
        ButtonGroup bg3=new ButtonGroup();    
        Question3.setBounds(500,100,900,50);
        op31.setBounds(500,200,300,50);
        op32.setBounds(500,250,300,50);
        op33.setBounds(500,300,300,50);
        op34.setBounds(500,350,300,50);
        Question3.setFont(new Font("Agency FB",Font.BOLD,30));
        op31.setFont(font);
        op32.setFont(font);
        op33.setFont(font);
        op34.setFont(font);
        bg3.add(op31);
        bg3.add(op32);
        bg3.add(op33);
        bg3.add(op34);
        card3.add(Question3);
        card3.add(op31);
        card3.add(op32);
        card3.add(op33);
        card3.add(op34);
        i++;

        JPanel card4 = new JPanel();
        card4.setLayout(null);
        card4.setBounds(10,10,1000,100);
        JLabel Question4=new JLabel("Q 4  "+arr[i][1]);
        JRadioButton op41=new JRadioButton("  "+arr[i][2]);
        JRadioButton op42=new JRadioButton("  "+arr[i][3]);
        JRadioButton op43=new JRadioButton("  "+arr[i][4]);
        JRadioButton op44=new JRadioButton("  "+arr[i][5]);
        ButtonGroup bg4=new ButtonGroup();    
        Question4.setBounds(500,100,900,50);
        op41.setBounds(500,200,300,50);
        op42.setBounds(500,250,300,50);
        op43.setBounds(500,300,300,50);
        op44.setBounds(500,350,300,50);
        Question4.setFont(new Font("Agency FB",Font.BOLD,30));
        op41.setFont(font);
        op42.setFont(font);
        op43.setFont(font);
        op44.setFont(font);
        bg4.add(op41);
        bg4.add(op42);
        bg4.add(op43);
        bg4.add(op44);
        card4.add(Question4);
        card4.add(op41);
        card4.add(op42);
        card4.add(op43);
        card4.add(op44);
        i++;
        cards = new JPanel(new CardLayout());
        cards.add(card1, card1Text);
        cards.add(card2, card2Text);
        cards.add(card3, card3Text);
        cards.add(card4, card4Text);

        class ControlActionListenter implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                CardLayout cl = (CardLayout) (cards.getLayout());
                String cmd = e.getActionCommand();
                if (cmd.equals(FIRST)) {
                    cl.first(cards);
                } else if (cmd.equals(NEXT)) {
                    cl.next(cards);
                } else if (cmd.equals(PREVIOUS)) {
                    cl.previous(cards);
                } else if (cmd.equals(LAST)) {
                    cl.last(cards);
                }
            }
        }
        ControlActionListenter cal = new ControlActionListenter();

        JButton btn1 = new JButton("First");
        btn1.setActionCommand(FIRST);
        btn1.addActionListener(cal);

        JButton btn2 = new JButton("Next");
        btn2.setActionCommand(NEXT);
        btn2.addActionListener(cal);

        JButton btn3 = new JButton("Previous");
        btn3.setActionCommand(PREVIOUS);
        btn3.addActionListener(cal);

        JButton btn4 = new JButton("Last");
        btn4.setActionCommand(LAST);
        btn4.addActionListener(cal);

        submit =new JButton("SUBMIT ");
        submit.setBounds(1200,600,150,50);

        JPanel controlButtons = new JPanel();
        controlButtons.add(btn1);
        controlButtons.add(btn2);
        controlButtons.add(btn3);
        controlButtons.add(btn4);
        controlButtons.add(submit);

        
        h.add(cards, BorderLayout.CENTER);
        h.add(controlButtons, BorderLayout.PAGE_END);

        
        setVisible(true);

        submit.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
               if(op11.isSelected() && anskey.contains(op11.getText()))
               count++;
               else if(op12.isSelected() && anskey.contains(op12.getText()))
               count++;
               else if(op13.isSelected() && anskey.contains(op13.getText()))
               count++;
               else if(op14.isSelected() && anskey.contains(op14.getText()))
               count++;

               if(op21.isSelected() && anskey.contains(op21.getText()))
               count++;
               else if(op22.isSelected() && anskey.contains(op22.getText()))
               count++;
               else if(op23.isSelected() && anskey.contains(op23.getText()))
               count++;
               else if(op24.isSelected() && anskey.contains(op24.getText()))
               count++;

               if(op31.isSelected() && anskey.contains(op31.getText()))
               count++;
               else if(op32.isSelected() && anskey.contains(op32.getText()))
               count++;
               else if(op33.isSelected() && anskey.contains(op33.getText()))
               count++;
               else if(op34.isSelected() && anskey.contains(op34.getText()))
               count++;

               if(op41.isSelected() && anskey.contains(op41.getText()))
               count++;
               else if(op42.isSelected() && anskey.contains(op42.getText()))
               count++;
               else if(op43.isSelected() && anskey.contains(op43.getText()))
               count++;
               else if(op44.isSelected() && anskey.contains(op44.getText()))
               count++;
               System.out.println(count);
               try{
                String query2="Update response set score='"+Integer.toString(count)+"' where rollno='"+rr+"' and Test_name='FLAT'";
                st.executeUpdate(query2);
                count=0;

               }
               catch(SQLException t){
                   t.printStackTrace();
               }
               JOptionPane.showMessageDialog(null," ✌ Exam Submitted ✌","Message",JOptionPane.INFORMATION_MESSAGE);
               flattake uu=new flattake();
               setVisible(false);
               uu.setVisible(true);
               
                
            }

        });
    }
    public static void main(String[] args) {
        new flatexam(rrn);
    }
}


