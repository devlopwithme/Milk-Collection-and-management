import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class UpdateInfo extends JFrame implements ActionListener {

    // Declare components
    JLabel Heading;
    JLabel milkCode, milkLiter, milkFatSnf, milkRate, milkAmount, milkDate, milkMode;
    JTextField mCode, mLiter, mFatSnf, mRate, mAmount, mDate, mMode;
    JLabel code, name, mno, email;
    JTextField cd1, nm1, mnum1, eml1;
    JButton update;
    JCheckBox cbPersonInfo,cbmilkinfo; // Use a more descriptive name
    int i=0;
    Connection cn;
    Statement stm1,stm2;
    String sql;

    public UpdateInfo() {
        super("Update");
        setSize(550, 400);
        setLayout(null);
        setLocation(300, 160);

        // Create components
        Heading = new JLabel("<html><h2><center>UPDATE INFO</center></h2></html>");
        Heading.setHorizontalAlignment(SwingConstants.CENTER); // Center alignment

        cbPersonInfo = new JCheckBox("Person Info"); 
        cbmilkinfo = new JCheckBox("Milk  Info"); 
        // Clearer label
        //person info
        code = new JLabel("Code:");
        name = new JLabel("Name:");
        mno = new JLabel("Mobile Number:");
        email = new JLabel("Email:");

        cd1 = new JTextField();
        nm1 = new JTextField();
        mnum1 = new JTextField();
        eml1 = new JTextField();

        // milk info
        milkCode = new JLabel("Code:");
        milkLiter = new JLabel("Liter:");
        milkFatSnf = new JLabel("Fat/SNF:");
        milkRate = new JLabel("Rate:");
        milkAmount = new JLabel("Amount:");
        milkDate = new JLabel("Date:");
        milkMode = new JLabel("Mode:");

        mCode = new JTextField();
        mLiter = new JTextField();
        mFatSnf = new JTextField();
        mRate = new JTextField();
        mAmount = new JTextField();
        mDate = new JTextField();
        mMode = new JTextField();

        update = new JButton("Update");

        // Add components to frame
        add(Heading);
        add(cbPersonInfo);      add(cbmilkinfo);
        add(code);              add(cd1);
        add(name);              add(nm1);
        add(mno);               add(mnum1);
        add(email);             add(eml1);
         add(update);

        // milk componenet
        add(milkCode);      add(mCode);
        add(milkLiter);     add(mLiter);
        add(milkFatSnf);    add(mFatSnf);
        add(milkRate);      add(mRate);
        add(milkAmount);    add(mAmount);
        add(milkDate);      add(mDate);
        add(milkMode);      add(mMode);
         // Set bounds for components
        Heading.setBounds(180, 20, 200, 30);
        cbPersonInfo.setBounds(150, 70, 150, 30);
        cbmilkinfo.setBounds(300, 70, 150, 30);
        update.setBounds(250,330,80,20);
        update.setVisible(false);
        // Initially hide Person Info labels and text fields
        code.setVisible(false);
        name.setVisible(false);
        mno.setVisible(false);
        email.setVisible(false);
        cd1.setVisible(false);
        nm1.setVisible(false);
        mnum1.setVisible(false);
        eml1.setVisible(false);

        milkCode.setVisible(false);
        milkLiter.setVisible(false);
        milkFatSnf.setVisible(false);
        milkRate.setVisible(false);
        milkAmount.setVisible(false);
        milkDate.setVisible(false);
        milkMode.setVisible(false);
        mCode.setVisible(false);
        mLiter.setVisible(false);
        mFatSnf.setVisible(false);
        mRate.setVisible(false);
        mAmount.setVisible(false);
        mDate.setVisible(false);
        mMode.setVisible(false);


        // Add action listener for checkbox
        cbPersonInfo.addActionListener(this);
        cbmilkinfo.addActionListener(this);
        update.addActionListener(this);
      try {
        cn=DriverManager.getConnection("jdbc:mysql:///project","root","root");
        stm1=cn.createStatement();
        stm2=cn.createStatement();
      } catch (Exception e) {
        // TODO: handle exception
        e.printStackTrace();
      }

        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cbPersonInfo) {
            boolean selected = cbPersonInfo.isSelected();
            update.setVisible(selected);
            code.setVisible(selected);
            name.setVisible(selected);
            mno.setVisible(selected);
            email.setVisible(selected);
            cd1.setVisible(selected);
            nm1.setVisible(selected);
            mnum1.setVisible(selected);
            eml1.setVisible(selected);

            // Adjust layout based on visibility (optional)
            if (selected) {
                i=1;
                milkCode.setVisible(false);
        milkLiter.setVisible(false);
        milkFatSnf.setVisible(false);
        milkRate.setVisible(false);
        milkAmount.setVisible(false);
        milkDate.setVisible(false);
        milkMode.setVisible(false);
        mCode.setVisible(false);
        mLiter.setVisible(false);
        mFatSnf.setVisible(false);
        mRate.setVisible(false);
        mAmount.setVisible(false);
        mDate.setVisible(false);
        mMode.setVisible(false);

                // Update bounds for components if Person Info is selected
                code.setBounds(100, 110, 100, 20);
                name.setBounds(100, 140, 100, 20);
                mno.setBounds(100, 170, 100, 20);
                email.setBounds(100, 200, 100, 20);
                cd1.setBounds(200, 110, 200, 20);
                nm1.setBounds(200, 140, 200, 20);
                mnum1.setBounds(200, 170, 200, 20);
                eml1.setBounds(200, 200, 200, 20);
            }
        }
        if (e.getSource() == cbmilkinfo)
        {
            boolean selected1 = cbmilkinfo.isSelected();
            update.setVisible(selected1);
            milkCode.setVisible(selected1);
            milkLiter.setVisible(selected1);
            milkFatSnf.setVisible(selected1);
            milkRate.setVisible(selected1);
            milkAmount.setVisible(selected1);
            milkDate.setVisible(selected1);
            milkMode.setVisible(selected1);
            mCode.setVisible(selected1);
            mLiter.setVisible(selected1);
            mFatSnf.setVisible(selected1);
            mRate.setVisible(selected1);
            mAmount.setVisible(selected1);
            mDate.setVisible(selected1);
            mMode.setVisible(selected1);
    
            // Adjust layout based on visibility (optional)
            if (selected1) {
            i=2;
                code.setVisible(false);
                name.setVisible(false);
                mno.setVisible(false);
                email.setVisible(false);
                cd1.setVisible(false);
                nm1.setVisible(false);
                mnum1.setVisible(false);
                eml1.setVisible(false);
                // Update bounds for components if Person Info is selected
                
                
                milkCode.setBounds(100, 110, 100, 20);
                milkLiter.setBounds(100, 140, 100, 20);
                milkFatSnf.setBounds(100, 170, 100, 20);
                milkRate.setBounds(100, 200, 100, 20);
                milkAmount.setBounds(100,230,100,30);
                milkDate.setBounds(100,260,100,20);
                milkMode.setBounds(100,290,100,20);
                mCode.setBounds(200, 110, 200, 20);
                mLiter.setBounds(200, 140, 200, 20);
                mFatSnf.setBounds(200,170,200,20);
                mRate.setBounds(200,200,200,20);
                mAmount.setBounds(200,230,200,20);
                mDate.setBounds(200,260,200,20);
                mMode.setBounds(200,290,200,20);
                          }
        }
        if(e.getSource()==update)
        {
           if(i==1)
           {
             int code=Integer.parseInt(cd1.getText());
             String name1,mono,email;
             name1=nm1.getText();
             mono=mnum1.getText();
             email=eml1.getText();
             try {
                sql="update per_info set name='"+name1+"',mono='"+mono+"',email='"+email+"' where code="+code+"";
                stm1.execute(sql);
                JOptionPane.showMessageDialog(null," Person Record Updated");
                stm1.close();
            } catch (Exception e1) {
                // TODO: handle exception
                e1.printStackTrace();
            }

             System.out.println(code+""+name1+""+mono+""+email);
           }
           if(i==2)
           {
            
            String code1,liter,fat,rate,amount;
            String date,mode;
            code1=mCode.getText();
            liter=mLiter.getText();
            fat=mFatSnf.getText();
            rate=mRate.getText();
            amount=mAmount.getText();
            date=mDate.getText();
            mode=mMode.getText();
            System.out.println(code1+""+liter+""+fat+""+rate+""+amount+""+date+""+mode);
            try {
                sql="update milk_info set code="+code1+",liter="+liter+",fat="+fat+",rate="+rate+",amount="+amount+",date='"+date+"',mode='"+mode+"' where code="+code1+"";
                stm2.execute(sql);
                JOptionPane.showMessageDialog(null," Person Record Updated");
                
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
           }
           
        }
       
    }

    public static void main(String[] args) {
        new UpdateInfo();
    }
}
