package BankManagementSystem;

import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;


public class Withdrawal extends JFrame implements ActionListener {

    JTextField amount;
    JButton withdrawal, back;
    String pinnumber;

    Withdrawal(String pinnumber) {
        this.pinnumber = pinnumber;

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Enter the amount you want to Withdrawal");
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System", Font.BOLD, 16));
        text.setBounds(180, 300, 400, 20);
        image.add(text);

        amount = new JTextField();
        amount.setFont(new Font("Raleway", Font.BOLD, 22));
        amount.setBounds(180, 350, 310, 25);
        image.add(amount);

        withdrawal = new JButton("Withdrawal");
        withdrawal.setBounds(355, 485, 150, 30);
        withdrawal.addActionListener(this);
        image.add(withdrawal);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == withdrawal) {
            String number = amount.getText();
            Date date = new Date();
            if (number.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Please enter the amount you want to Withdrawal");
            }else if (ae.getSource() == back) {
                setVisible(false);
                new Transactions(pinnumber).setVisible(true);
            } else {
                try {
                    Conn c = new Conn();

                    ResultSet rs = c.s.executeQuery("select * from bank where pin='" + pinnumber + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (ae.getSource() != back && balance < Integer.parseInt(number)) {
                        JOptionPane.showMessageDialog(null, "Insufficient Balance");
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);
                        return;
                    }else{

                        String query = "insert into bank values('" + pinnumber + "','" + date + "','Withdraw','" + number + "')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "RS " + number + " Withdrawl successfully");
                        setVisible(false);
                        new Transactions(pinnumber).setVisible(true);

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        }
    }

    public static void main(String[] args) {
        new Withdrawal("");

    }
}