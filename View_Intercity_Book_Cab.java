package CAB_BOOKING;


import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class View_Intercity_Book_Cab extends Frame {

    Font f;
    JTable t1;
    String[] x = {"Book Id", "Username", "Name", "Driver Name", "Source", "Destination", "Type", "Car", "Price"}; // Row of Table
    String[][] y = new String[20][9];
    int i = 0, j = 0;

    View_Intercity_Book_Cab() {

        super("Interacity Cab ");
        setSize(1080, 720);
        setLocation(0, 10);
        f = new Font("MS UI Gothic", Font.BOLD, 17); // font type, size
        try {
            Connection_Class obj = new Connection_Class(); // connection is created on class Connection_Class we just called it
            String q = "select * from intercitycab";//  table name is intercitycab
            ResultSet rest = obj.stmt.executeQuery(q);

            while (rest.next()) {
                // Attributes of Table intercitycab
                y[i][j++] = rest.getString("BookId");
                y[i][j++] = rest.getString("UserName");
                y[i][j++] = rest.getString("Name");
                y[i][j++] = rest.getString("DriverName");
                y[i][j++] = rest.getString("source");
                y[i][j++] = rest.getString("Destination");
                y[i][j++] = rest.getString("Type");
                y[i][j++] = rest.getString("Car");
                y[i][j++] = rest.getString("Price");
                i++;
                j = 0;
            }
            t1 = new JTable(y,x);

        } catch (Exception bh) {
            bh.printStackTrace();
        }
        t1.setFont(f);
        t1.setBackground(Color.BLACK);
        t1.setForeground(Color.WHITE);
        JScrollPane js = new JScrollPane(t1); // it is used to scroll table, if data is too much
        add(js);

    }
    public static void main (String[]args){
        new View_Intercity_Book_Cab().setVisible(true);
    }
}