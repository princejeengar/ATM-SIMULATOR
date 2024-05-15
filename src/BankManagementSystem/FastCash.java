package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
public class FastCash extends JFrame implements ActionListener {

    JButton rs1, rs2, rs3, rs4, rs5, rs6, exit;
    String pinnumber;
    FastCash(String pinnumber){
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWAL AMOUNT");
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(220, 300, 700, 35);
        text.setForeground(Color.WHITE);
        image.add(text);

        rs1 = new JButton("RS 100");
        rs1.setBounds(165, 415, 150, 30);
        rs1.addActionListener(this);
        image.add(rs1);

        rs2 = new JButton("RS 500");
        rs2.setBounds(355, 415, 150, 30);
        rs2.addActionListener(this);
        image.add(rs2);

        rs3 = new JButton("RS 1000");
        rs3.setBounds(165 , 450, 150, 30);
        rs3.addActionListener(this);
        image.add(rs3);

        rs4 = new JButton("RS 2000");
        rs4.setBounds(355, 450, 150, 30);
        rs4.addActionListener(this);
        image.add(rs4);

        rs5 = new JButton("RS 5000");
        rs5.setBounds(165 , 485, 150, 30);
        rs5.addActionListener(this);
        image.add(rs5);

        rs6 = new JButton("RS 10000");
        rs6.setBounds(355 , 485, 150, 30);
        rs6.addActionListener(this);
        image.add(rs6);

        exit = new JButton("BACK");
        exit.setBounds(355 , 520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        } else {
            String amount = ((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if (rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }

                if(ae.getSource() != exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insufficient Balance");
                    return;
                }

                Date date = new Date();
                String query = "insert into bank values('"+pinnumber+"', '"+date+"', 'Withdrawal', '"+amount+"')";

                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"RS "+ amount + " Debited Successfully");

                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            }catch(Exception e){
                System.out.println(e);
            }
        }
    }

    public static void main(String[] args){
        new FastCash("");
    }
}
