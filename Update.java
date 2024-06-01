import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;

class frame2 extends JFrame
{   // declaration
    JCheckBox cb1,cb2;
    JLabel Heading; 
    JLabel code,name,mno,email;
    JTextField cd1,nm1,mnum1,eml1; 
    JButton update;

   frame2()
   {
    super("update");
    setSize(600,400);
    setLayout(null);
    setLocation(300,160);
    
    // memory allocation
    Heading=new JLabel("<html><h2 style='color:PINK;'>UPDATE INFO</h1></html>");
    
    cb1=new JCheckBox("<html><h3>Person_Info</h1></html>");
    cb2=new JCheckBox("<html><h3>Milk_Info</h1></html>");
    update=new JButton();

    // Add to frmae
    add(cb1);    add(cb2);
    add(Heading);

    //setBounds
    Heading.setBounds(250,20,200,30);
    cb1.setBounds(150,70,150,30);
    cb2.setBounds(350,70,150,30);



    setVisible(true);
   }
}

class update
{
    public static void main(String[] args) 
    {
        new frame2();
    }
}