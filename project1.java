import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;



class frame extends Frame implements ActionListener,KeyListener{
    String mode;
    JLabel heading, date,Summary,List,Mobno;
    JLabel Name, Code, Liter, Fat, SNF, Amount, AVg_Qty, Avg_Fat, Avg_Snf, Rate;
    JTextField name, code, liter, fat, snf, amount, avg_qty, avg_fat, avg_snf, rate,h2,mobno;
    JPanel Buttons;
    JButton ok,settings,report,close,add,update;
    int c,r,temp=1,flag;
    Float am,rate1;
    Connection cn;
    String sql;
    Statement stm,stm1,stm2,stm4;
    ResultSet rs,rs1,rs2,rs3;
    PreparedStatement prstm;
    String n1,dt;
    String f,s,l;
    LocalDate date1 ;
    JScrollPane jsp1;
    

    frame() {
        setTitle("project");
        setLayout(null);
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;

        setSize(width, height);
        ImageIcon img = new ImageIcon("p3.jpg");
        heading = new JLabel("", img, JLabel.CENTER);
        heading.setBounds(0, -70, width, height);
        Border lineborder = BorderFactory.createLineBorder(Color.RED);
        heading.setBorder(lineborder);

        add(heading);
        
        Buttons=new JPanel();
       // ok=new JButton("OK");
        //close=new JButton("Close");

        Name = new JLabel("Name");
        Code = new JLabel("Code");
        Mobno = new JLabel("Mob.No");
        Liter = new JLabel("Liter");
        Fat = new JLabel("Fat");
        SNF = new JLabel("Snf");
        Amount = new JLabel("Amount");
        AVg_Qty = new JLabel("AVG.Qty");
        Avg_Fat = new JLabel("Avg.Fat");
        Avg_Snf = new JLabel("Avg.snf");
        Rate = new JLabel("Rate");
        h2=new JTextField("Prevoius Day`s Milk Collection");
       
        name = new JTextField();
        code = new JTextField();
        mobno = new JTextField();
        liter = new JTextField();
        fat = new JTextField();
        snf = new JTextField();
        amount = new JTextField();
        avg_qty = new JTextField();
        avg_fat = new JTextField();
        avg_snf = new JTextField();
        rate = new JTextField();
        Buttons=new JPanel();
        
        Summary=new JLabel("Summary");
        List=new JLabel("List");
        add=new JButton("ADD");
        update=new JButton("UPDATE");

        ImageIcon okimg=new ImageIcon("ok.jpg");
        Image i=okimg.getImage();
        Image new_img=i.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        okimg=new ImageIcon(new_img);
        ok=new JButton("OK",okimg);
           
        ImageIcon setting=new ImageIcon("setting.png");
        Image i1=setting.getImage();
        Image new_img1=i1.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        setting=new ImageIcon(new_img1);
        settings=new JButton("Setting",setting);
 
        ImageIcon cls=new ImageIcon("close.png");
        Image i3=cls.getImage();
        Image new_img3=i3.getScaledInstance(50,50,Image.SCALE_SMOOTH);
        cls=new ImageIcon(new_img3);
        close=new JButton("Close",cls);

        // setbounds
        Name.setBounds(30, 210, 100, 30);
        name.setBounds(150, 215, 350, 30);
        Code.setBounds(30, 290, 100, 20);
        code.setBounds(150, 290, 100, 30);
        Mobno.setBounds(290,290,100,20);
        mobno.setBounds(400,290,100,30);
        Liter.setBounds(30, 360, 100, 20);
        liter.setBounds(150, 360, 100, 30);
        Fat.setBounds(30, 420, 100, 20);
        fat.setBounds(150, 420, 100, 30);
        SNF.setBounds(30, 480, 100, 20);
        snf.setBounds(150, 480, 100, 30);
        Amount.setBounds(30, 540, 100, 20);
        amount.setBounds(150, 540, 100, 30);
        
        //summery table
        Summary.setBounds(970,200,100,30);
        List.setBounds(980,300,100,30);

        add.setBounds(950,700,80,30);
        update.setBounds(1060,700,80,30);
        heading.add(List);
        add(add);
        add(update);

        
        String col[] = {"Milk","Member","Liter","Fat","SNF","Amount","Sales" };

        String Data[] = {"Cow","0","0","0","0","0","0" };
        DefaultTableModel model1=new DefaultTableModel();
        model1.setColumnIdentifiers(col);
        model1.addRow(Data);
        JTable table2=new JTable(model1);
        
        int v1=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
        int h1=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
        jsp1=new JScrollPane(table2,v1,h1);
        jsp1.setBounds(700,250,600,38);
        heading.add(jsp1);

        AVg_Qty.setBounds(290, 360, 100, 30);
        avg_qty.setBounds(400, 360, 100, 30);
        Avg_Fat.setBounds(290, 420, 100, 30);
        avg_fat.setBounds(400, 420, 100, 30);
        Avg_Snf.setBounds(290, 480, 100, 30);
        avg_snf.setBounds(400, 480, 100, 30);
        Rate.setBounds(290, 540, 100, 30);
        rate.setBounds(400, 540, 100, 30);
        h2.setBounds(10,600,655,20);
        Buttons.setBounds(520,200,150,397);
        ok.setBounds(530,220,80,60);
        settings.setBounds(530,320,80,60);
        close.setBounds(530,420,80,60);
        
         // add
        heading.add(name);
        heading.add(Name);
        heading.add(Code);
        heading.add(code);
        heading.add(Mobno);
        heading.add(mobno);
        heading.add(Liter);
        heading.add(liter);
        heading.add(Fat);
        heading.add(fat);
        heading.add(SNF);
        heading.add(snf);
        heading.add(Amount);
        heading.add(amount);
        heading.add(AVg_Qty);
        heading.add(avg_qty);
        heading.add(Avg_Fat);
        heading.add(avg_fat);
        heading.add(Avg_Snf);
        heading.add(avg_snf);
        heading.add(Rate);
        heading.add(rate);
        heading.add(h2);
        heading.add(Buttons);
        Buttons.add(ok);
        Buttons.add(settings);
        Buttons.add(close);
        heading.add(Summary);
        
        name.setBorder(BorderFactory.createEmptyBorder());
        Buttons.setBorder(BorderFactory.createLineBorder(Color.black,1));
        Buttons.setBackground(Color.WHITE);
        liter.setBackground(Color.PINK);
        fat.setBackground(Color.PINK);
        snf.setBackground(Color.PINK);
        h2.setBackground(Color.PINK);
        h2.setHorizontalAlignment(JTextField.CENTER);

         ok.setHorizontalTextPosition(JButton.CENTER);
         ok.setVerticalTextPosition(JButton.BOTTOM);
         settings.setHorizontalTextPosition(JButton.CENTER);
         settings.setVerticalTextPosition(JButton.BOTTOM);
         close.setHorizontalTextPosition(JButton.CENTER);
         close.setVerticalTextPosition(JButton.BOTTOM);
        
         code.setToolTipText("Press Enter");
         snf.setToolTipText("Press Enter");
        h2.setEditable(false);
          date1 = LocalDate.now();
        System.out.println(date);
        LocalTime time = LocalTime.now();
        
        DateTimeFormatter formate = DateTimeFormatter.ofPattern("hh:mm a");
        String ctime = time.format(formate);
       // System.out.println(ctime);
        
        System.out.println(date1);

        if (ctime.contains("AM")) {
            mode = "evening";
        } else
            mode = "Moring";
            
            
        JLabel date = new JLabel(date1 + "(" + mode + ")");
        heading.add(date);
        date.setBounds(1200, 130, 120, 30);
// prevoius collection table0
   
       try{
        cn=DriverManager.getConnection("jdbc:mysql:///project","root","root");
        stm=cn.createStatement();
        stm1=cn.createStatement();
        stm2=cn.createStatement();
        stm4=cn.createStatement();
       }catch(Exception e)
       {
        e.printStackTrace();
       }
      
      // addd listeners
      close.addActionListener(this);
      ok.addActionListener(this);
      code.addKeyListener(this);
      snf.addKeyListener(this);
      add.addActionListener(this);
      update.addActionListener(this);
      setVisible(true);
    }
    public void keyTyped(KeyEvent e)
    {    
          
    }
    public void keyPressed(KeyEvent e)
    { 
        if(e.getKeyChar()==e.VK_ENTER)
        {
            temp++;
            
        }
        if(e.getKeyChar()==e.VK_ENTER && (temp%2)==0)
        {
         try {
                 
                c=Integer.parseInt(code.getText());
                System.out.println(c);
                rs=stm.executeQuery("select avg(fat),avg(snf),avg(liter) from milk_info where code="+c+"");
                rs.first();
                f=Float.toString(rs.getFloat(1));
                s=Float.toString(rs.getFloat(2));
                l=Float.toString(rs.getFloat(3));
                
                avg_fat.setText(f);
                avg_snf.setText(s);
                avg_qty.setText(l);

                rs1=stm1.executeQuery("select name from per_info where code="+c+"");
                rs1.first();
                n1=rs1.getString(1);
                
                name.setText(n1);
                try {
                    
                
                rs2=stm2.executeQuery("select * from milk_info where code="+c+" and mode='"+mode+"' order by date desc limit 5");
            } catch (Exception e3) {
                // TODO: handle exception
                e3.printStackTrace();
            }
                rs2.first();
                rs1.close();
                rs.close();

                DefaultTableModel model=new DefaultTableModel();              
                String heads[]={"date","Liter","Fat","Snf","Rate","Amount"};
                
                model.setColumnIdentifiers(heads);
                for(int i=0;i<5;i++)
                {
                String data[]={rs2.getString(7),rs2.getString(2),rs2.getString(3),rs2.getString(4),rs2.getString(5),rs2.getString(6)};
                model.addRow(data);

                JTable table=new JTable(model);
                table.setEnabled(false);
                int v=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
                int h=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
                JScrollPane jsp=new JScrollPane(table,v,h);
                jsp.setBounds(10,620,650,500);
                heading.add(jsp);
                rs2.next();
                }
                 
                
            } catch (Exception e1) {
                // TODO: handle exception
            }
        }
            if(e.getKeyChar()==e.VK_ENTER && (temp%2)==1)
            {  
                try {
                    if(liter.getText().length()>0 && snf.getText().length()>0 && fat.getText().length()>0)
                    {
                    Float l1=Float.parseFloat(liter.getText());
                    Float f1=Float.parseFloat(fat.getText());
                    Float s1=Float.parseFloat(snf.getText());
                    if(l1>0 && f1>0 && s1>0)
                    {
                        
                        if(f1<3)
                        {
                            rate1=25f;
                        }
                       else if(f1>=3 && f1<3.5)
                        {
                            rate1=28f;
                        }
                        else if(f1>=3.5 && f1<4.0)
                        {
                            rate1=30f;
                        }
                        else if(f1>=4.0)
                        {
                            rate1=35f;
                        }
                        am=rate1*l1;
                        String temp,temp1;
                        temp=Float.toString(rate1);
                        temp1=Float.toString(am);
                        rate.setText(temp);
                        amount.setText(temp1);
                       //Stsrem.out.println(rate1);    
                    }
                    
                }
                } catch (Exception e1) {
                    // TODO: handle exception
                }
                
            }
            
            
       
    }
    public void keyReleased(KeyEvent e)
    {
        
    }
     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {

            new Add();
        }
        if(e.getSource()==update)
        {
            new UpdateInfo();
        }
        if(e.getSource()==close)
        {
        
            System.exit(0);
        }
        if(e.getSource()==ok)
        {
            flag=0;
            try {
                
             
           int c1=Integer.parseInt(code.getText()); 
           int l=Integer.parseInt(liter.getText()); 
           float f=Float.parseFloat(fat.getText()); 
           float s=Float.parseFloat(snf.getText());  
           String r=rate.getText();
           String a=amount.getText();
           
           rs=stm.executeQuery("select code from milk_info where date='"+date1+"' and mode='"+mode+"' ");
           rs.beforeFirst();
           while(rs.next())
           {
               int k=rs.getInt(1);
               if(k==c1)
               flag=1;

           }
           rs.close();
           //dt
           //mode
           if(flag==0)
           {
           sql="insert into milk_info values("+c1+","+l+","+f+","+s+","+r+","+a+",'"+date1+" ','"+mode+"' )";
           prstm=cn.prepareStatement(sql);
           prstm.execute();
           prstm.close();
            //display summary
            jsp1.setVisible(false);
           String col1[] = {"Milk","Member","Liter","Fat","SNF","Amount","Sales" };
           
           rs3=stm4.executeQuery("select sum(code),sum(liter),avg(fat),avg(snf),sum(amount) from milk_info where date='"+date1+"' and mode='"+mode+"'");
           rs3.beforeFirst();
           rs3.next();
           String t=rs3.getString(1);
           String t1=rs3.getString(2);
           String t2=rs3.getString(3);
           String t3=rs3.getString(4);
           String t4=rs3.getString(5);



        
          String data1[] = {"Cow",t,t1,t2,t3,t4,"0" };
          DefaultTableModel model2=new DefaultTableModel();
          model2.setColumnIdentifiers(col1);
          model2.addRow(data1);
          JTable table3=new JTable(model2);

          int v2=ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
          int h2=ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
          JScrollPane jsp2=new JScrollPane(table3,v2,h2);
          jsp2.setBounds(700,250,600,40);
          heading.add(jsp2);
          
       //display list
       rs1=stm1.executeQuery("select * from milk_info where date='"+date1+"' and mode='"+mode+"' ");
       String column[] = {"Code","Liter","Fat","SNF","Rate","Amount"};
       rs1.beforeFirst();
       DefaultTableModel model4=new DefaultTableModel();
       model4.setColumnIdentifiers(column);
       while(rs1.next())
       {
        String data[]={rs1.getString(1),rs1.getString(2),rs1.getString(3),rs1.getString(4),rs1.getString(5),rs1.getString(6),rs1.getString(7)};
        model4.addRow(data);
        JTable table4=new JTable(model4);
        table4.setEnabled(false);
        JScrollPane jsp4=new JScrollPane(table4);
        jsp4.setBounds(700,370,600,400);
        heading.add(jsp4);
       }
           }
           else{
            JOptionPane.showMessageDialog(null, "Check Code");
           }
       
           } catch (Exception e5) {
            // TODO: handle exception
            e5.printStackTrace();
        }
         
        
         }
    }
}

class project1 {
    public static void main(String args[]) {
        new frame();
    }
}
