
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.sql.*;

class Add extends JFrame implements ActionListener,KeyListener
{
    JPanel pn;
    JLabel _code,_name,_mno,_email;
    JTextField cd,nm,mnum,eml;
    JButton add;
    Connection cn;
    String sql;
    Statement stm,stm1;
    PreparedStatement prstm;
    ResultSet rs,rs1;
    int cc;


    Add()
    {
       super("Add details");
       setSize(600,400);
       setLayout(null);
       setLocation(300,160);
        
       // memory allocation
       pn=new JPanel();
       pn.setLayout(null);
       pn.setBackground(Color.PINK);
       _code=new JLabel("Code");
       _name=new JLabel("Name");
       _mno=new JLabel("Mobile no");
       _email=new JLabel("email");
       cd= new JTextField();
       nm= new JTextField();
       mnum= new JTextField();
       eml= new JTextField();
       add=new JButton("Add");
      
       Font fnt=new Font("Calibri",Font.BOLD,15);
       _code.setFont(fnt);
       cd.setFont(fnt);
       _name.setFont(fnt);
       nm.setFont(fnt);
       _mno.setFont(fnt);
       mnum.setFont(fnt);
       _email.setFont(fnt);
       eml.setFont(fnt);

       cd.setEnabled(false);
       //add.setFont(fnt);
       


       //setBounds
       pn.setBounds(0,0,600,400);

       _code.setBounds(200,80,60,30);
       _name.setBounds(200,140,60,30);
       _mno.setBounds(200,200,70,30);
       _email.setBounds(200,260,60,30);

       cd.setBounds(280,80,150,30);
       nm.setBounds(280,140,150,30);
       mnum.setBounds(280,200,150,30);
       eml.setBounds(280,260,150,30);

       add.setBounds(280,330,60,30);

       // add 
       add(pn);            pn.add(_code);
       pn.add(_name);      pn.add(_mno);
       pn.add(_email);     pn.add(cd);
       pn.add(nm);         pn.add(mnum);
       pn.add(eml);        pn.add(add);


       // add Listeners
       add.addActionListener(this);
       mnum.addKeyListener(this);


       try {
        cn=DriverManager.getConnection("jdbc:mysql:///project","root","root");
   
        stm=cn.createStatement();
        stm1=cn.createStatement();
        rs=stm.executeQuery("select code from per_info order by code desc ");
        rs.beforeFirst();
        rs.next();
        cc=rs.getInt(1)+1;
        String cod=Integer.toString(cc);
        cd.setText(cod);
        rs.close();
        stm.close();
       
       } catch (Exception e) {
        e.printStackTrace();
       }



      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
            String s1,s2,s3;
            s1=nm.getText();
            s2=mnum.getText();
            s3=eml.getText();
             if(s1.length()>0 && s2.length()==10 && s3.length()>11)
             {
                try 
                {
                 rs1=stm1.executeQuery("select code from per_info order by code desc ");
                 rs1.beforeFirst();
                 int temp,temp1=0;
                 while(rs1.next())
                 {
                    temp=rs1.getInt(1);
                    if(temp==cc)
                    { temp1=1;
                        JOptionPane.showMessageDialog(null,cc+"code already present ");
                        break;

                    }
                 }

                if(temp1==0)
                {
                sql="insert into per_info values ("+cc+",'"+s1+"','"+s2+"','"+s3+"')";
                prstm=cn.prepareStatement(sql);
                prstm.execute();
                prstm.close();
                JOptionPane.showMessageDialog(null,"Your Code is "+cc);
                }
               
                } catch (Exception e1) 
                {
                     e1.printStackTrace();
                }
                
             }
             else
             {
                JOptionPane.showMessageDialog(null,"Enter all Fields");
             }
        }
        
    }
    public void keyTyped(KeyEvent e)
    {
     if(Character.isDigit(e.getKeyChar()) && mnum.getText().length()<10   )
     {
        
        
     }
     else
     {
         e.consume();
     }
    }
    public void keyReleased(KeyEvent e)
    {
 
    }
    public void keyPressed(KeyEvent e)
    {
 
    }
     
    public static void main(String[] args) {
        new Add(); 
    }
}
