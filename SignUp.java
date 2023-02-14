package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUp extends JFrame implements ActionListener {

    JFrame f;
    JTextField t1,t2,t3;
    JLabel l1,l2,l3,l4;
    JPasswordField p1;
    JButton b1,b2;


    public SignUp() {

        //creating frame
        //provides window on the screen

        f=new JFrame("Create Account");
        f.setBackground(Color.white);
        f.setLayout(null);

        //creating labels
        //Display area for short text.
        //lable doesn't react to input event.

        l1=new JLabel("Username");
        l1.setBounds(40,20,100,30);
        f.add(l1);

        l2=new JLabel("Name");
        l2.setBounds(40,70,100,30);
        f.add(l2);

        l3=new JLabel("Password");
        l3.setBounds(40,120,100,30);
        f.add(l3);

        l4=new JLabel("Phone No.");
        l4.setBounds(40,170,100,30);
        f.add(l4);


        //Jtext for providing some inputs
        // editing a single line text
        t1=new JTextField();
        t1.setBounds(150,20,150,30);
        f.add(t1);

        t2=new JTextField();
        t2.setBounds(150,70,150,30);
        f.add(t2);


        t3=new JTextField();
        t3.setBounds(150,170,150,30);
        f.add(t3);

        p1=new JPasswordField();
        p1.setBounds(150,120,150,30);
        f.add(p1);

//        //ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("CAB_BOOKING/image/2.jpeg"));
//        Image i2=i1.getImage().getScaledInstance(250,250,Image.SCALE_DEFAULT);
//        ImageIcon i3=new ImageIcon(i2);
//        JLabel l5=new JLabel(i3);
//        l5.setBounds(350,70,150,150);
//        f.add(l5);

        //craeting Button

        b1=new JButton("SignUp");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(40,240,120,30);

        b2=new JButton("Back");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        b2.setBounds(180,240,120,30);

        //Providing action listener to buttons

        b1.addActionListener(this);
        b2.addActionListener(this);

        f.add(b1);
        f.add(b2);


        f.getContentPane();
        f.setVisible(true);
        f.setSize(550,340);
        f.setLocation(400,300);


    }

    @Override
    public void actionPerformed(ActionEvent ee) {
        if (ee.getSource()==b1){
            String username=t1.getText();
            String name=t2.getText();
            String password=p1.getText();
            String phone=t3.getText();

            try{
                Connection_Class obj=new Connection_Class();
                String q="insert into signup values('"+username+"', '"+name+"' ,'"+password+"', '"+phone+"')";
                int aa=obj.stmt.executeUpdate(q);
                if (aa==1){
                    JOptionPane.showMessageDialog(null,"Account Created Successfully");
                    this.setVisible(false);
                    new Login();
                }
                else {
                    JOptionPane.showMessageDialog(null,"Please fill the details Carefully");
                    this.setVisible(false);
                    this.f.setVisible(true);

                }
            }
            catch (Exception e){
                e.printStackTrace();
            }


        }
        if (ee.getSource()==b2){
            this.f.setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new SignUp();
    }
}
