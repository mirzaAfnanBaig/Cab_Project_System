package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.EventObject;


public class Update_Customer extends JFrame implements ActionListener {

    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12;
    JButton b1, b2;
    JPanel p1, p2, p3;
    JTextField t1, t2, t3, t4, t5, t6, t7, t8, t9, t10;
    Font f1, f2;
    Choice c1;
    JFrame f;


    public Update_Customer() {

        super("Update Customer");
        setSize(740, 700);
        setLocation(50, 50);

        //creating fonts
        f1 = new Font("Arial", Font.BOLD, 25);
        f2 = new Font("Arial", Font.BOLD, 18);


        //creating connection
        c1 = new Choice();
        try {
            Connection_Class obj = new Connection_Class();
            String q = "select username from customerinfo";
            ResultSet set = obj.stmt.executeQuery(q);
            while (set.next()) {
                c1.add(set.getString("Username"));
            }
        } catch (Exception ee) {
            ee.printStackTrace();
        }
        //creating Labels
        l1 = new JLabel("Update Customer");
        l1.setHorizontalAlignment(JLabel.CENTER);
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

        //creating textfield
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();

        //creating buttons
        b1 = new JButton("Update");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Back");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);

        //creating action listener to buttons
        b1.addActionListener(this);
        b2.addActionListener(this);


        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);
        l7.setFont(f2);
        l8.setFont(f2);
        l9.setFont(f2);
        l10.setFont(f2);
        l11.setFont(f2);

        t1.setFont(f2);
        t2.setFont(f2);
        t3.setFont(f2);
        t4.setFont(f2);
        t5.setFont(f2);
        t6.setFont(f2);
        t7.setFont(f2);
        t8.setFont(f2);
        t9.setFont(f2);

        c1.setFont(f2);

        //creating image
        ImageIcon ic = new ImageIcon(ClassLoader.getSystemResource("CAB_BOOKING/image/homepage1.jpg"));
        Image img = ic.getImage().getScaledInstance(1550, 800, Image.SCALE_DEFAULT);
        ImageIcon ic1 = new ImageIcon(img);
        l12 = new JLabel(ic1);


//        creating panels
//        creating 1st panel
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1, 1, 10, 10));
        p1.add(l1);

        //creating 2nd panel
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1, 1, 10, 10));
        p2.add(l12);

        //creating 3rd panel
        p3 = new JPanel();
        p3.setLayout(new GridLayout(11, 2, 10, 10));
        p3.add(l2);
        p3.add(c1);
        p3.add(l3);
        p3.add(t1);
        p3.add(l4);
        p3.add(t2);
        p3.add(l5);
        p3.add(t3);
        p3.add(l6);
        p3.add(t4);
        p3.add(l7);
        p3.add(t5);
        p3.add(l8);
        p3.add(t6);
        p3.add(l9);
        p3.add(t7);
        p3.add(l10);
        p3.add(t8);
        p3.add(l11);
        p3.add(t9);
        p3.add(b1);
        p3.add(b2);


        setLayout(new BorderLayout(10, 10));
        add(p1, "North");
        add(p2, "West");
        add(p3, "Center");


        c1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent arg0) {

                try {
                    Connection_Class obj2 = new Connection_Class();
                    String Username = c1.getSelectedItem();
                    String q1 = "select * from customerinfo where Username'" + Username + "'";
                    ResultSet set2 = obj2.stmt.executeQuery(q1);
                    while (set2.next()) {
                        t1.setText(set2.getString("Name"));
                        t2.setText(set2.getString("Age"));
                        t3.setText(set2.getString("DOB"));
                        t4.setText(set2.getString("Address"));
                        t5.setText(set2.getString("Phone"));
                        t6.setText(set2.getString("Email"));
                        t7.setText(set2.getString("Country"));
                        t8.setText(set2.getString("Gender"));
                        t9.setText(set2.getString("Aadhar"));
                    }

                } catch (Exception ee) {
                    ee.printStackTrace();
                }
            }

        });

    }


    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) {
            String Username = c1.getSelectedItem();
            String Name = t1.getText();
            String Age = t2.getText();
            String DOB = t3.getText();
            String Address = t4.getText();
            String Phone = t5.getText();
            String Email = t6.getText();
            String Country = t7.getText();
            String Gender = t8.getText();
            String Aadhar = t9.getText();


            try {
                Connection_Class obj3 = new Connection_Class();
                String q3 = "update customerinfo set name='" + Name + "',Age='" + Age + "',DOB='" + DOB + "',Address='" + Address + "',Phone='" + Phone + "',Email='" + Email + "',Country='" + Country + "',Gender='" + Gender + "',Aadhar='" + Aadhar + "'";
                int aa = obj3.stmt.executeUpdate(q3);
                if (aa == 1) {
                    JOptionPane.showMessageDialog(null, "Your Data Successfully Update");
                    this.setVisible(false);
                    System.out.println("Success");
                } else {
                    JOptionPane.showMessageDialog(null, "Please,Fill all Deatils Carefully");

                }
            } catch (Exception ee) {
                ee.printStackTrace();
            }

        }
        if (e.getSource() == b2) {
            this.setVisible(false);

        }
    }

    public static void main(String[] args) {
        new Update_Customer().setVisible(true);
    }
}




