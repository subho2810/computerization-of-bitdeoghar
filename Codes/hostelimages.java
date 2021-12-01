import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



 class hostelimages extends JFrame {
    public static Container h;
 public hostelimages(String x) {

        final String card1Text = "Card 1";
        final String card2Text = "Card 2";
        final String card3Text = "Card 3";
        final JPanel cards; 
       
        final String FIRST = "FIRST";
        final String NEXT = "NEXT";
        final String PREVIOUS = "PREVIOUS";
        final String LAST = "LAST";

        
        setSize(1590, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        h=getContentPane();
        JPanel card1 = new JPanel();
        card1.setLayout(new BorderLayout());
        JLabel c=new JLabel(new ImageIcon("maincodes/images/img1.jpg"));
        c.setBounds(20,50,500,500);
        card1.add(c);

        JPanel card2 = new JPanel();
        card2.setLayout(new BorderLayout());
        JLabel c1=new JLabel(new ImageIcon("maincodes/images/img2.jfif"));
        c1.setBounds(20,50,500,500);
        card2.add(c1);
        
        JPanel card3 = new JPanel();
        card3.add(new JLabel("Card 3"));
        card3.setBackground(new Color(0,0,255));

        cards = new JPanel(new CardLayout());
        cards.add(card1, card1Text);
        cards.add(card2, card2Text);
        cards.add(card3, card3Text);

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

        JButton btn5 = new JButton("Go back");
        btn5.setActionCommand(LAST);
        btn5.addActionListener(cal);

        JPanel controlButtons = new JPanel();
        controlButtons.add(btn1);
        controlButtons.add(btn2);
        controlButtons.add(btn3);
        controlButtons.add(btn4);
        controlButtons.add(btn5);
        
        h.add(cards, BorderLayout.CENTER);
        h.add(controlButtons, BorderLayout.PAGE_END);
       setVisible(true);
       btn5.addActionListener(new ActionListener(){

        @Override
        public void actionPerformed(ActionEvent e) {
            BoysHosteldashboard oo=new BoysHosteldashboard(x);
            setVisible(false);
            oo.setVisible(true);
            
        }

    });

       
        
    }
    public static void main(String[] args) {
        new hostelimages("");
    }
}