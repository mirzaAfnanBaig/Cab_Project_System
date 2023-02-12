package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Intracity_Driver extends JFrame implements ActionListener{

    JFrame f;
    JLabel l,l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    JPanel p1,p2;
    JButton b1,b2;
    Font f1,f2;
    public Add_Intracity_Driver()  {


        // Adding Headlines
        super("Add Intracity Driver");
        setLocation(400,50);
        setSize(400,450);

        //giving font

        f1=new Font("Arial",Font.BOLD,20);
        f2=new Font("Arial",Font.BOLD,17);


        //creating Labels
        //Display area for short text.
        //label doesn't react to input event.

        l1=new JLabel("Add Intracity Driver");
        l2=new JLabel("Driver Name");
        l3=new JLabel("Source");
        l4=new JLabel("Destination");
        l5=new JLabel("Car");
        l6=new JLabel("Price");


//        creating text field to take input from user

        t1=new JTextField();
        t2=new JTextField();
        t3=new JTextField();
        t4=new JTextField();
        t5=new JTextField();




        //crating Button with Action Listener
        b1=new JButton("Add");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(120,260,150,40);
        b1.addActionListener(this);


        b2=new JButton("Back");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(200,260,150,40);
        b2.addActionListener(this);


        //centring the Headline
        l1.setHorizontalAlignment(JLabel.CENTER);

//        creating panels
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);

        p2=new JPanel();
        p2.setLayout(new GridLayout(7,2,10,8));

        //Adding labels to panels

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
        p2.add(b1);
        p2.add(b2);

        setLayout(new BorderLayout(6,6));
        add(p2,"North");
        add(p2,"Center");

        //Giving Font


        l1.setFont(f1);
        l2.setFont(f2);
        l3.setFont(f2);
        l4.setFont(f2);
        l5.setFont(f2);
        l6.setFont(f2);

        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);

        b1.setFont(f1);
        b2.setFont(f1);







    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==b1)
        {
            String Name=t1.getText();
            String Source=t2.getText();
            String Destination=t3.getText();
            String Car=t4.getText();
            String Price=t5.getText();

            // Storing into databse

            try
            {

                Connection_Class obj=new Connection_Class();
                String q="insert into intracity_driver(Driver,Source,Destination,Car,Price) values ('"+Name+"','"+Source+"','"+Destination+"','"+Car+"','"+Price+"')";
                //Running the Query by
                int aa=obj.stmt.executeUpdate(q);

                //if above query runs succesfull then

                if(aa==1)
                {
                    JOptionPane.showMessageDialog(null,"Data Added Successfully");
                    this.setVisible(false);

                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please! Fill Details Carefully");
                }


            }
            catch (Exception ee)
            {
                ee.printStackTrace();
            }

        }

        if (e.getSource()==b2)
        {
            this.setVisible(false);
        }




    }

    public static void main(String[] args) {
        new Add_Intracity_Driver().setVisible(true);
    }
}