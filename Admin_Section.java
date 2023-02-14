package CAB_BOOKING;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Admin_Section extends JFrame implements ActionListener {

    JLabel l1;
    JButton b1,b2,b3,b4;
    Font f,f1;
    JPanel p1;

    Admin_Section(){
        super("Admin Section");
        setLocation(450,250);
        setSize(400,270);

        f = new Font("Arial",Font.BOLD,20);
        f1 = new Font("Arial",Font.BOLD,15);
        l1 = new JLabel("Admin Section");

        l1.setHorizontalAlignment(JLabel.CENTER);

        b1 = new JButton("Intercity Driver"); //Naming Buttons
        // Setting Background and Foreground Color
        b1.setBackground(Color.CYAN);  //
        b1.setForeground(Color.WHITE);

        b2 = new JButton("Intracity Driver");
        b2.setBackground(Color.CYAN);
        b2.setForeground(Color.WHITE);

        b3 = new JButton("Transport Driver");
        b3.setBackground(Color.CYAN);
        b3.setForeground(Color.WHITE);

        b4 = new JButton("Signup");
        b4.setBackground(Color.CYAN);
        b4.setForeground(Color.WHITE);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        l1.setFont(f); // Declaring font for label and Buttons
        b1.setFont(f1);
        b2.setFont(f1);
        b3.setFont(f1);
        b4.setFont(f1);

        p1 = new JPanel(); // Panel p1 for label and buttons
        p1.setLayout(new GridLayout(5,1,10,10));
        p1.add(l1);
        p1.add(b1);
        p1.add(b2);
        p1.add(b3);
        p1.add(b4);

        setLayout(new BorderLayout(10,10));
        // Positioning Panel to Center
        add(p1,"Center");

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == b1) { // While Button b1 Clicked Respected Task will occur
            new Add_Intercity_Driver().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == b2) {
            new Add_Intracity_Driver().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == b3) {
            new Add_Transport_Driver().setVisible(true);
            this.setVisible(false);
        }
        if (e.getSource() == b4) {
            new SignUp().setVisible(true);
            this.setVisible(false);
        }
    }
    public static void main(String[] args) {
        new Admin_Section().setVisible(true);
    }
}
