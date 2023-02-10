package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class View_Customer_Details extends JFrame {
    Font f;
  JTable t;
    String x[]={"Username","Name","Age","Date of Birth","Address","Phone","Email","Gender","Country"};
    String y[][]=new String [20][10];
    int i=0,j=0;

    View_Customer_Details()
    {

        super("All Customer Details");
        setSize(1300,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);

        //create Connection
        try
        {
            Connection_Class obj=new Connection_Class();
            String q="select * from customerinfo";
            ResultSet set=obj.stmt.executeQuery(q);

            while (set.next())
            {
                y[i][j++]=set.getString("Username");
                y[i][j++]=set.getString("Name");
                y[i][j++]=set.getString("Age");
                y[i][j++]=set.getString("DOB");
                y[i][j++]=set.getString("Address");
                y[i][j++]=set.getString("Phone");
                y[i][j++]=set.getString("Email");
                y[i][j++]=set.getString("Gender");
                y[i][j++]=set.getString("Country");
                i++;
                j=0;
            }
            t=new JTable(y,x);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        t.setFont(f);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        JScrollPane js=new JScrollPane(t);
        add(js);

    }

    public static void main(String[] args)
    {
       new View_Customer_Details().setVisible(true);
    }
}
