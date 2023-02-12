package CAB_BOOKING;

import javax.swing.*;
import javax.xml.transform.Result;
import java.awt.*;
import java.sql.ResultSet;

public class View_BookedCab extends JFrame {
  Font f;
  JTable t1;
  String x[] = {"Book ID","Username","Driver Name","Car","Source","Destination","Price"};
  String y[][] = new String[20][10]; // 20 rows and 10 columns
  int i = 0, j = 0;
  View_BookedCab(){

    super("All Booked Cab Record");
    setSize(1300,400);
    setLocation(0,10);
    f = new Font("MS UI Gothic",Font.BOLD,17);

    try {
      Connection_Class obj = new Connection_Class();
      String q = "select * from intracitycab";
      ResultSet rest = obj.stmt.executeQuery(q);

      while (rest.next()){
        y[i][j++]=rest.getString("BookId");
        y[i][j++]=rest.getString("UserName");
        y[i][j++]=rest.getString("DriverName");
        y[i][j++]=rest.getString("Car");
        y[i][j++]=rest.getString("source");
        y[i][j++]=rest.getString("Destination");
        y[i][j++]=rest.getString("Price");
        i++;
        j=0;
      }
      t1 = new JTable(y,x);
    }catch (Exception re){
      re.printStackTrace();
    }

    t1.setFont(f);
    t1.setBackground(Color.BLACK);
    t1.setForeground(Color.WHITE);

    JScrollPane js = new JScrollPane( ); // use to scroll the information table
    add(js);
  }

  public static void main(String[] args) {
    new View_BookedCab().setVisible(true);
  }
  }
