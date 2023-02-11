package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame implements ActionListener {

    JLabel l1;
    Font f1,f2,f3;
    JPanel p1,p2;

    HomePage(){

        super("Home Page");
        setLocation(0,0);
        setSize(1080,720);



        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("CAB_BOOKING/image/taxi2.jpg"));
        Image img=ic.getImage().getScaledInstance(1080,720,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);

        //creating Font

        f1=new Font("Lucid Fax",Font.BOLD,20);
        f2=new Font("Gadugi",Font.BOLD,35);
        f3=new Font("MS UI Gothic",Font.BOLD,18);



        //crating a menu bar
        JMenuBar bar=new JMenuBar();

        JMenu menu1=new JMenu("Cutomer Profile");
        //Creating menu item of Customer profile
        JMenuItem item1=new JMenuItem("Add Customer profile");
        JMenuItem item2=new JMenuItem("View Customer profile");

        JMenu menu2=new JMenu("Manage customer");
        JMenuItem item3=new JMenuItem("Update Customer details");

        JMenu menu3=new JMenu("Book Intracity Cab");
        //creating menu item for intracity cab
        JMenuItem item5=new JMenuItem("Book Cab");
        JMenuItem item6=new JMenuItem("View Book Cab");

        JMenu menu4=new JMenu("Book Intercity Cab");
        //creating menu item for intercity cab
        JMenuItem item7=new JMenuItem("Book Intercity Cab");
        JMenuItem item8=new JMenuItem("View Intercity Book Cab");

        JMenu menu5=new JMenu("Transport");
        //creating menu item for transport
        JMenuItem item9=new JMenuItem("Book Package");
        JMenuItem item10=new JMenuItem("View Booked Package");

        JMenu menu6=new JMenu("Bill");
        //creating menu item for Bill
        JMenuItem item11=new JMenuItem("Check Bill");


        JMenu menu7=new JMenu("Delete");
        //creating menu item for delete
        JMenuItem item12=new JMenuItem("Delete Customer");

        JMenu menu8=new JMenu("About");
        //creating menu item for about
        JMenuItem item13=new JMenuItem("About");
        JMenuItem item14=new JMenuItem("Exit");


        //Adding items in menu

        menu1.add(item1);
        menu1.add(item2);
        menu2.add(item3);
        menu3.add(item5);
        menu3.add(item6);
        menu4.add(item7);
        menu4.add(item8);
        menu5.add(item9);
        menu5.add(item10);
        menu6.add(item11);
        menu7.add(item12);
        menu8.add(item13);
        menu8.add(item14);


        //Adding menu in Menu Bar

        bar.add(menu1);
        bar.add(menu2);
        bar.add(menu3);
        bar.add(menu4);
        bar.add(menu5);
        bar.add(menu6);
        bar.add(menu7);
        bar.add(menu8);


        //Giving Color

        bar.setBackground(Color.YELLOW);

        menu1.setForeground(Color.BLACK);
        menu2.setForeground(Color.BLACK);
        menu3.setForeground(Color.BLACK);
        menu4.setForeground(Color.BLACK);
        menu5.setForeground(Color.BLACK);
        menu6.setForeground(Color.BLACK);
        menu7.setForeground(Color.RED);
        menu8.setForeground(Color.BLACK);

        //Adding Color to item on fore Ground
        item12.setForeground(Color.RED);
        item14.setForeground(Color.RED);
        item1.setForeground(Color.BLACK);
        item2.setForeground(Color.BLACK);



        //Adding Color to item on BackGround
        item1.setBackground(Color.YELLOW);
        item2.setBackground(Color.YELLOW);
        item3.setBackground(Color.WHITE);
        item5.setBackground(Color.WHITE);
        item6.setBackground(Color.WHITE);
        item7.setBackground(Color.WHITE);
        item8.setBackground(Color.WHITE);
        item9.setBackground(Color.WHITE);
        item10.setBackground(Color.WHITE);
        item11.setBackground(Color.WHITE);
        item12.setBackground(Color.WHITE);

        //Adding menu Bar in Frame

        setJMenuBar(bar);
        add(l1);
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        String comnd = e.getActionCommand();
        if (comnd.equals("Add Customer profile")) {
            new Add_Customer().setVisible(true);

        }

        else if (comnd.equals("View Customer Profile")) {
            new View_Customer_Details().setVisible(true);
        }

        else if (comnd.equals("Update Customer Details")) {
            new Update_Customer().setVisible(true);
        }
//
        else if (comnd.equals("Book Cab"))
        {
            JOptionPane.showMessageDialog(null,"clickable");
            new Book_Cab().setVisible(true);
            //Book_Cab b = new Book_Cab();
//            new Book_Cab();
        }
        else if (comnd.equals("View Booked Cab"))
        {
            new View_BookedCab();
        }
//        else if (comnd.equals("Book Intercity Cab"))
//        {
//            new Book_Intercity_Cab().setVisible(true);
//        }else if (comnd.equals("View Intercity Booked Cab"))
//        {
//            new View_Intercity_Book_Cab().setVisible(true);
//        }else if (comnd.equals("Book Package"))
//        {
//            new Book_Package().setVisible(true);
//        }else if (comnd.equals("View Booked Package"))
//        {
//            new View_Booked_Package().setVisible(true);
//        }else if (comnd.equals("Check Bill"))
//        {
//            new Check_Bill().setVisible(true);
//        }else if (comnd.equals("Delete Customer"))
//        {
//            new Delete_Customer().setVisible(true);
//        }else if (comnd.equals("About"))
//        {
//            new About().setVisible(true);
//        }else if (comnd.equals("Exit"))
//        {
//            System.out.println(0);
//        }

        }


    public static void main(String[] args) {

        new HomePage().setVisible(true);

    }
}
