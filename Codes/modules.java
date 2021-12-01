
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
 class modules extends JFrame{
    public static Container h;
	public static JButton cse,boys,exam,padm;
    public modules(){
        setTitle("MODULE PAGE");
        setSize(1590,800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
		setLayout(new BorderLayout());
		h.setBackground(Color.BLACK);
	    JLabel c=new JLabel(new ImageIcon("maincodes/images/modules.png"));
	    h.add(c);
        Font font2=new Font("Agency FB",Font.BOLD,30);
        cse=new JButton("Computer Science Module");
        cse.setBounds(580,270,300,70);
        cse.setFont(font2);
        exam=new JButton("Examination Module");
        exam.setBounds(580,380,300,70);
        exam.setFont(font2);
        boys=new JButton("Boys Hostel Module");
        boys.setBounds(580,490,300,70);
        boys.setFont(font2);
        padm=new JButton("Planning & Development Module");
        padm.setBounds(580,600,420,70);
        padm.setFont(font2);
        Cursor cur=new Cursor(Cursor.HAND_CURSOR);
        cse.setCursor(cur);
        exam.setCursor(cur);
        boys.setCursor(cur);
        padm.setCursor(cur);
        c.add(cse);
        c.add(exam);
        c.add(boys);
        c.add(padm);
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
        cse.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
              cselog css=new cselog();
              setVisible(false);
              css.setVisible(true);
            }
            
        });
        exam.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
              Examdashboard css=new Examdashboard();
              setVisible(false);
              css.setVisible(true);
            }
            
        });
        boys.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e){
              loginboys css=new loginboys();
              setVisible(false);
              css.setVisible(true);
            }
            
        });
    }
    public static void main(String[] args) {
        new modules();
        
    }
}

