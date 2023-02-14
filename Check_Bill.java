package CAB_BOOKING;

import com.mysql.cj.protocol.Resultset;

import javax.naming.ContextNotEmptyException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Check_Bill extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField tf1,tf2,tf3,tf4;
    JButton bt1,bt2,bt3,bt4;
    JPanel p1,p2,p3;
    Choice ch1;
    Font f,f1;
    public int price = 0;
    Check_Bill(){
        super("Check Total Cab Bill"); // Heading name 
        setLocation(50,10);
        setSize(1080,720);

        // Labels names
        l1 = new JLabel("Check Total Cab Bill");
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Email");
        l5 = new JLabel("Address");
        l6 = new JLabel("Price");

        ch1 = new Choice();
        try {
            Connection_Class obj = new Connection_Class(); // Created a connection 
            String q = "select * from customerinfo";    // Query for getting all information from the customerinfo
            ResultSet rest = obj.stmt.executeQuery(q);
            while (rest.next()){
                ch1.add(rest.getString("Username"));

            }

        }catch (Exception ji){
            ji.printStackTrace();
        }
        
       tf1 = new JTextField();
       tf2 = new JTextField();
       tf3 = new JTextField();
       tf4 = new JTextField();

       // we take editable false so details must not change
       tf1.setEditable(false);
       tf2.setEditable(false);
       tf3.setEditable(false);
       tf4.setEditable(false);

       bt1 = new JButton("Intercity Cab"); // Button names
       bt2 = new JButton("Intracity Cab");
       bt3 = new JButton("Transport");
       bt4 = new JButton("Back");

       l1.setHorizontalAlignment(JLabel.CENTER); // label name Check Total Cab Bill will align to center
       bt1.addActionListener(this);
       bt2.addActionListener(this);
       bt3.addActionListener(this);
       bt4.addActionListener(this);

       f = new Font("Arial",Font.BOLD,25); // Font details
       f1 = new Font("Arial",Font.BOLD,18);

       l1.setFont(f);
       l2.setFont(f1);
       l3.setFont(f1);
       l4.setFont(f1);
       l5.setFont(f1);
       l6.setFont(f1);

       tf1.setFont(f1);
       tf2.setFont(f1);
       tf3.setFont(f1);
       tf4.setFont(f1);
       ch1.setFont(f1);

       bt1.setFont(f1);
       bt2.setFont(f1);
       bt3.setFont(f1);
       bt4.setFont(f1);

       // Coloring Background and Foreground of Buttons
       bt1.setBackground(Color.YELLOW); 
       bt2.setBackground(Color.YELLOW);
       bt3.setBackground(Color.YELLOW);
       bt4.setBackground(Color.BLACK);

       bt1.setForeground(Color.BLACK);
       bt2.setForeground(Color.BLACK);
       bt3.setForeground(Color.BLACK);
       bt4.setForeground(Color.WHITE);

       p1 = new JPanel();
       p1.setLayout(new GridLayout(1,1,10,10)); 
       // Adding value into Panel 1
       p1.add(l1);

       p2 = new JPanel();
       p2.setLayout(new GridLayout(7,2,10,10));

       // Adding values into Panel 2
       p2.add(l2);
       p2.add(ch1);
       p2.add(l3);
       p2.add(tf1);
       p2.add(l4);
       p2.add(tf2);
       p2.add(l5);
       p2.add(tf3);
       p2.add(l6);
       p2.add(tf4);
       p2.add(bt1);
       p2.add(bt2);
       p2.add(bt3);
       p2.add(bt4);
       
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));

        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("CAB_BOOKING/image/taxi2.jpg"));   // Adding a Picture into interface
        Image img=ic.getImage().getScaledInstance(500,500,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l7=new JLabel(ic1);
        p3.add(l7); // adding picture values into Panel 3

        setLayout(new BorderLayout(0,0));
        
        // Assigning positions of Panels
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");

        ch1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Connection_Class obj = new Connection_Class(); // Connected using Connection_Class
                    String userName = ch1.getSelectedItem(); // Selected values is stored here
                    String q1 = "select * from customerinfo where Username= '"+userName+"'";
                    ResultSet rest1 = obj.stmt.executeQuery(q1);

                    while (rest1.next()){
                        // Selecting the values from the table which are depend upon selected user value
                        tf1.setText(rest1.getString("Name"));
                        tf2.setText(rest1.getString("Email"));
                        tf3.setText(rest1.getString("Address"));
                    }
                    rest1.close();
                }catch (Exception hu){
                    hu.printStackTrace();
                }
            }
        });
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == bt1){
            price = 0; // Taking default value as 0
            String userName = ch1.getSelectedItem();   // Selected values is stored here
            try {
                Connection_Class obj2 = new Connection_Class(); // Connected using Connection_Class
                String q2 = "select Price from intercitycab where Username = '"+userName+"'";
                ResultSet rest1 = obj2.stmt.executeQuery(q2);
                while (rest1.next()){
                    price = price + Integer.parseInt(rest1.getString("Price")); // Price value is stored in public integer value [Price]
                }
                tf4.setText(price+""); // Price value is stored into TextFiled 4 and showed into interface
            }catch (Exception h){
                h.printStackTrace();
            }
        }
        if (e.getSource() == bt2){
            price = 0; // Taking default value as 0
            String userName = ch1.getSelectedItem();
            try {
                Connection_Class obj3 = new Connection_Class(); // Connected using Connection_Class
                String q3 = "select Price from intracitycab where username ='"+userName+"'";
                ResultSet rest1 = obj3.stmt.executeQuery(q3);
                while (rest1.next()){
                    price = price+Integer.parseInt(rest1.getString("Price"));
                }
                tf4.setText(price+"");
                rest1.close();
            }catch (Exception g){
                g.printStackTrace();
            }
        }

        if (e.getSource() == bt3){
            price = 0;
            String username = ch1.getSelectedItem();
            try {
            Connection_Class obj4 = new Connection_Class();
            String q4 = "select Price from transport where Username = '"+username+"'";
            ResultSet rest3 = obj4.stmt.executeQuery(q4);
            while (rest3.next()){
                price = price+ Integer.parseInt(rest3.getString("Price"));
            }
            tf4.setText(price+"");
            rest3.close();
            }catch (Exception t){
                t.printStackTrace();
            }
        }
        if (e.getSource() == bt4){ // Back Button for Exiting
//            this.setVisible(false);
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Check_Bill().setVisible(true);
    }
}
