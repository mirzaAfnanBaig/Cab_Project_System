package CAB_BOOKING;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Transport_Driver extends JFrame implements ActionListener {

    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5,t6;
    JPanel p1,p2;
    JButton b1,b2;
    Font f,f1;
    Add_Transport_Driver(){
        super("Add Transport Driver");
        setLocation(450,50);
        setSize(450,400);
        f = new Font("Arial", Font.BOLD,20); // Font details
        f1 = new Font("Arial",Font.BOLD,15);


        // Labels are used to show the details
        l1 = new JLabel("Add Transport Driver");
        l2=new JLabel("Driver Name");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Truck");
        l6=new JLabel("Price");
        l7=new JLabel("Distance");


        // TextField are used to get the inputted values from the user
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        b1 = new JButton("Add Transport Driver"); // Button for storing values
        b2 = new JButton("Back"); // Button for getting to previous interface

        l1.setHorizontalAlignment(JLabel.CENTER); // Putted the name [Add Transport Driver] in the middle of the interface

        b1.addActionListener(this);
        b2.addActionListener(this);

        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);

        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);

        b1.setFont(f1);
        b2.setFont(f1);

        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2 = new JPanel();
        p2.setLayout(new GridLayout(7,2,10,10));

        p2.add(l2);
        p2.add(t1);
        p2.add(l3);
        p2.add(t2);
        p2.add(l4);
        p2.add(t3);
        p2.add(l5);
        p2.add(t4);
        p2.add(l6);
        p2.add(t5);
        p2.add(l7);
        p2.add(t6);
        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");

    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b1){  // on click button will do such task
            String Name = t1.getText();
            String Source = t2.getText();
            String Destination = t3.getText();
            String Truck = t4.getText();
            String Price = t5.getText();
            String Distance = t6.getText();

            try {
                Connection_Class obj = new Connection_Class();
                // Query to store values in the transport driver
                String q = "insert into transport_driver(Driver,Source,Destination,Truck,Price,Distance) values ('"+Name+"','"+Source+"','"+Destination+"','"+Truck+"','"+Price+"','"+Distance+"') ";
                int aa = obj.stmt.executeUpdate(q);
                if (aa == 1){
                    JOptionPane.showMessageDialog(null,"Data is Successfully Stored"); // message will show if data is stored successfully
                    this.setVisible(false);
                }
                else {
                    JOptionPane.showMessageDialog(null,"Fill the Details Accordingly"); // message will show if data is stored unsuccessfully
                }
            }catch (Exception es){
                es.printStackTrace();
            }
        }

        if (e.getSource() == b2){
            this.setVisible(false);
//            new AdminSection().setVisible(true); // this class is not made yet
        }
    }

    public static void main(String[] args) {
        new Add_Transport_Driver().setVisible(true);
    }
}
