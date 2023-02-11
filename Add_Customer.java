package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Add_Customer extends JFrame implements ActionListener {
     JLabel id,id1,id2,id3,id4,id5,id6,id7,id8,id9,id10,id11,id12,id13;
     JFrame f;
     JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13;
     JButton b1,b2;
    Add_Customer(){

        //Providing frame title
        f=new JFrame("Add Customer details");
        f.setBackground(Color.WHITE);
        f.setLayout(null);

       id=new JLabel();
       f.setBounds(0,0,900,600);
       f.setLayout(null);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("CAB_BOOKING/image/taxi.jpg"));
        Image i1=img.getImage().getScaledInstance(800,800,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);





        //creating heading
        id1=new JLabel("Add Customer Details");
        id1.setBounds(280,30,550,50);
        id1.setForeground(Color.BLACK);
        id1.setFont(new Font("Arial",Font.BOLD,30));
        id.add(id1);
        f.add(id1);


        //Creating username
        id2=new JLabel("Username");
        id2.setBounds(50,150,150,30);
        id2.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id2);
        f.add(id2);

        //creating textField for username
        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        f.add(t1);


        //creating name
        id3=new JLabel("Name");
        id3.setBounds(450,150,200,30);
        id3.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id3);
        f.add(id3);

        //creating texfield for name
        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        f.add(t2);


       //creating age
        id4=new JLabel("Age");
        id4.setBounds(50,200,100,30);
        id4.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id4);
        f.add(id4);

        //creating textfield for age
        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        f.add(t3);

        //creating Date of Birth
        id5=new JLabel("Date of Birth");
        id5.setBounds(450,200,200,30);
        id5.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id5);
        f.add(id5);

        //creating textfield for DOB
        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        f.add(t4);


        //creating Addresss
        id6=new JLabel("Address");
        id6.setBounds(50,250,100,30);
        id6.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id6);
        f.add(id6);

        //creating textfield for Address
        t5=new JTextField();
        t5.setBounds(200,250,150,30);
        f.add(t5);

        //creating Phone
        id7=new JLabel("Phone");
        id7.setBounds(450,250,200,30);
        id7.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id7);
        f.add(id7);

        //creating textfield for Phone
        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        f.add(t6);


        //creating E-Mail ID
        id8=new JLabel("E-mail ID");
        id8.setBounds(50,300,100,30);
        id8.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id8);
        f.add(id8);

        //creating textfield for E-Mail ID
        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        f.add(t7);


        //creating Country
        id9=new JLabel("Country");
        id9.setBounds(450,300,200,30);
        id9.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id9);
        f.add(id9);

        //creating textfield for Country
        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        f.add(t8);


        //creating Gender

        id10=new JLabel("Gender");
        id10.setBounds(50,350,150,30);
        id10.setFont(new Font("Arial",Font.BOLD,25));
        id.add(id10);
        f.add(id10);


        //creating textfield for Gender
        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        f.add(t9);


        //creating Aadhar
        id11=new JLabel("Aadhar");
        id11.setBounds(450,350,200,30);
        id11.setFont(new Font("Arial",Font.BOLD,20));
        id.add(id11);
        f.add(id11);

        //creating textfield for Aadhar
        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        f.add(t10);


        //creating Buttons

        b1=new JButton("Submit");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(200,450,130,30);
        b1.addActionListener(this);
        f.add(b1);

        b2=new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.setBounds(550,450,130,30);
        b2.addActionListener(this);
        f.add(b2);

        f.setVisible(true);
       f.setSize(800,800);
       f.setLocation(300,100);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

     if (e.getSource()==b1)
     {
      String Username =t1.getText();
      String Name=t2.getText();
      String Age=t3.getText();
      String DOB=t4.getText();
      String Address=t5.getText();
      String Phone=t6.getText();
      String Email=t7.getText();
      String Country=t8.getText();
      String Gender=t9.getText();
      String Aadhar=t10.getText();

      //Add a connection to database
      try
      {
       Connection_Class obj=new Connection_Class();
       String q="insert into customerinfo values('"+Username+"','"+Name+"','"+Age+"','"+DOB+"','"+Address+"','"+Phone+"','"+Email+"','"+Country+"','"+Gender+"','"+Aadhar+"')";
       obj.stmt.executeUpdate(q);
       JOptionPane.showMessageDialog(null,"Details successfully Inserted");
       f.setVisible(false);
       new HomePage();
      }
      catch (Exception ee)
      {
       ee.printStackTrace();
      }







     }
     if(e.getSource()==b2)
     {
      f.setVisible(false);
     }

    }

    public static void main(String[] args) {
        new Add_Customer().setVisible(true);
    }
}
