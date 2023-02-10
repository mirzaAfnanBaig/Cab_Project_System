package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public  class Login extends JFrame implements ActionListener {

    JFrame f;
    JPanel p;
    JLabel l1,l2,l3,l4;
    JPasswordField p1;
    JTextField t1,t2,t3;
    JButton b1,b2;


    Login()
    {
        f=new JFrame();
        f.setBackground(Color.white);
        f.setLayout(null);

        l1=new JLabel();
        l1.setBounds(0,0,580,350);
        l1.setLayout(null);

        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("CAB_BOOKING/image/original.jpeg"));
        Image i1=img.getImage().getScaledInstance(580,350,Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        l1.setIcon(img1);

        l2=new JLabel("Login Account");
        l2.setBounds(190,30,500,50);
        l2.setFont(new Font("Airal",Font.BOLD,30));
        l2.setForeground(Color.white);
        l1.add(l2);
        f.add(l1);

        l3=new JLabel("Username : ");
        l3.setBounds(120,150,150,30);
        l3.setForeground(Color.WHITE);
        l3.setFont(new Font("Airal",Font.BOLD,30));
        l1.add(l3);


        l4=new JLabel("Password : ");
        l4.setBounds(120,170,150,30);
        l4.setFont(new Font("Airal",Font.BOLD,30));
        l4.setForeground(Color.WHITE);
        l1.add(l4);

        t1=new JTextField();
        t1.setBounds(320,120,150,30);
        l1.add(t1);

        //creating text space for password

        p1=new JPasswordField();
        p1.setBounds(320,170,150,30);
        l1.add(p1);

        //creating buttons for login page

        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setBounds(120,220,150,40);

        b2=new JButton("SignUp");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setBounds(320,220,150,40);

        l1.add(b1);
        l1.add(b2);

        b1.addActionListener(this);
        b2.addActionListener(this);


        f.setVisible(true);
        f.setSize(580,340);
        f.setLocation(300,100);
        f.setResizable(false);  // we can't make page small and large





    }

    @Override
    public void actionPerformed(ActionEvent ee)
    {
        if (ee.getSource()==b1)
        {
            try
            {
                Connection_Class obj=new Connection_Class();
                String name=t1.getText();
                String pass=p1.getText();

                //Write a query to fetch a data and compare
                String q="select * from signup where username='"+name+"' and password='"+pass+"'";
                ResultSet rs=obj.stmt.executeQuery(q);

                if (rs.next())
                {
                    new HomePage().setVisible(true);
                    System.out.println("Login");
                    f.setVisible(false);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"you have Entered Wrong Username or Password");
                    f.setVisible(false);
                    f.setVisible(true);
                }


            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        if(ee.getSource()==b2)
        {
            this.f.setVisible(false);
            new SignUp();
        }

    }

    public static void main(String[] args) {
        new Login();
    }
}
