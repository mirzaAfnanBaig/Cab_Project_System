package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class Delete_Customer extends JFrame implements ActionListener {
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12;
    JButton b1,b2;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9;
    Font f,f1;
    Choice ch;

    Delete_Customer(){
        super("Delete Customer"); // Interface name
        setLocation(50,10);
        setSize(1080,720);

        // Font details
        f = new Font("Arial",Font.BOLD,25);
        f1 = new Font("Arial",Font.BOLD,18);

        ch = new Choice();
        try {
            Connection_Class obj = new Connection_Class(); // Creating connection
            String q = "select Username from customerinfo";
            ResultSet rest = obj.stmt.executeQuery(q);
            while (rest.next()){
                ch.add(rest.getString("Username"));
            }
        }catch (Exception y){
            y.printStackTrace();
        }
        // Declaring Label Names
        l1 = new JLabel("Delete Customer");
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Age");
        l5 = new JLabel("Date of Birth");
        l6 = new JLabel("Address");
        l7 = new JLabel("Phone");
        l8 = new JLabel("Email");
        l9 = new JLabel("Country");
        l10 = new JLabel("Gender");
        l11 = new JLabel("Aadhar");

        // Initializing textFields
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();

        // set editable put false, so changes may not occur
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        t8.setEditable(false);
        t9.setEditable(false);


        // Naming Buttons
        b1 = new JButton("Delete Customer Information");
        b2 = new JButton("Back");

        l1.setHorizontalAlignment(JLabel.CENTER); // Interface name putted into Center

        b1.addActionListener(this);
        b2.addActionListener(this);

        // Declaring Fonts to the Labels, Fields and Buttons
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        ch.setFont(f1);

        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);
        t9.setFont(f1);

        b1.setFont(f1);
        b2.setFont(f1);

        b1.setBackground(Color.BLACK);
        b2.setBackground(Color.RED);

        b1.setForeground(Color.WHITE);
        b2.setForeground(Color.WHITE);

        p1 = new JPanel(); // Panel P1 for Name of interface
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel(); // Panel P2 for attributes such as choice,Labels, textFields and Buttons
        p2.setLayout(new GridLayout(11,2,10,10));

        p2.add(l2);
        p2.add(ch);
        p2.add(l3);
        p2.add(t1);
        p2.add(l4);
        p2.add(t2);
        p2.add(l5);
        p2.add(t3);
        p2.add(l6);
        p2.add(t4);
        p2.add(l7);
        p2.add(t5);
        p2.add(l8);
        p2.add(t6);
        p2.add(l9);
        p2.add(t7);
        p2.add(l10);
        p2.add(t8);
        p2.add(l11);
        p2.add(t9);
        p2.add(b1);
        p2.add(b2);

        p3 = new JPanel(); // Panel for Image
        p3.setLayout(new GridLayout(1,1,10,10));

        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("Cab_booking/Image/taxi.jpg"));
        Image img1 = img.getImage().getScaledInstance(400,500,Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img1);
        l12 = new JLabel(ic1);

        p3.add(l12);
        setLayout(new BorderLayout(10,10));
        // Positioning Panels
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");

        ch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    Connection_Class obj2 = new Connection_Class(); // Connection class for table data

                    String username = ch.getSelectedItem();
                    String q1 = "select * from customerinfo where Username ='"+username+"'"; // Query for selecting customer information from respected username
                    ResultSet rest1 = obj2.stmt.executeQuery(q1);
                    while (rest1.next()){
                        t1.setText(rest1.getString("Name"));
                        t2.setText(rest1.getString("Age"));
                        t3.setText(rest1.getString("DOB"));
                        t4.setText(rest1.getString("Address"));
                        t5.setText(rest1.getString("Phone"));
                        t6.setText(rest1.getString("Email"));
                        t7.setText(rest1.getString("Country"));
                        t8.setText(rest1.getString("Gender"));
                        t9.setText(rest1.getString("Aadhar")); // Aadhaar is correct one
                    }
                }catch (Exception b){
                    b.printStackTrace();
                }

            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1){
            String username = ch.getSelectedItem();
            try {
                Connection_Class obj3 = new Connection_Class();
                // Query for deleting all the data from respected table by using username
                String q = "delete from customerinfo where Username='"+username+"'";
                String q1 = "delete from transport where Username='"+username+"'";
                String q2 = "delete from intercitycab where Username='"+username+"'";
                String q3 = "delete from intracitycab where Username='"+username+"'";
                int find = obj3.stmt.executeUpdate(q);
                if (find == 1){ // If performed successfully then this message will show and further execution will held on
                    JOptionPane.showMessageDialog(null,"Record Deleted Successfully");
                    obj3.stmt.executeUpdate(q1);
                    obj3.stmt.executeUpdate(q2);
                    obj3.stmt.executeUpdate(q3);
                    this.setVisible(false);
                    new View_Customer_Details().setVisible(true);
                }
                else { // if operation unsuccessful then this message will show
                    JOptionPane.showMessageDialog(null, "Check the Details Carefully!");
                }
            }catch (Exception k){
                k.printStackTrace();
            }
        }
        if (e.getSource() == b2){ // Click on Back button to exit interface
            this.setVisible(false);
//            System.exit(0);
        }
    }
    public static void main(String[] args) {
        new Delete_Customer().setVisible(true);
    }
}
