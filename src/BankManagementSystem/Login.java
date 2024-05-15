package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

    JButton login, clear, sign;
    JTextField cardText;
    JPasswordField pinText;

    Login(){

        setTitle("AUTOMATED TELLER MACHINE");

        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("Icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward", Font.BOLD, 38));
        text.setBounds(200, 40, 400, 40);
        add(text);

        JLabel cardno = new JLabel("Card No:");
        cardno.setFont(new Font("Raleway", Font.BOLD, 28));
        cardno.setBounds(120, 150, 150, 30);
        add(cardno);

        cardText = new JTextField();
        cardText.setBounds(300, 150, 230, 30);
        cardText.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardText);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 28));
        pin.setBounds(120, 220, 150, 30);
        add(pin);

        pinText = new JPasswordField();
        pinText.setBounds(300, 220, 230, 30);
        pinText.setFont(new Font("Arial", Font.BOLD, 14));
        add(pinText);

        login = new JButton("SIGN IN");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);

        sign = new JButton("SIGN UP");
        sign.setBounds(300, 350, 230, 30);
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.WHITE);
        sign.addActionListener(this);
        add(sign);

        getContentPane().setBackground(Color.white);

       setSize(800, 480);
       setVisible(true);
       setLocation(350, 200);
    }

    public void actionPerformed(ActionEvent ae){
         if(ae.getSource() == clear){
             cardText.setText("");
             pinText.setText("");
         }else if(ae.getSource() == login){
             Conn conn = new Conn();
             String cardnumber = cardText.getText();
             String pinnumber = pinText.getText();
             String query = "select * from login where cardnumber ='"+cardnumber+"' and pin = '"+pinnumber+"'";
             try{
                 ResultSet rs = conn.s.executeQuery(query);
                 if(rs.next()){
                     setVisible(false);
                     new Transactions(pinnumber).setVisible(true);
                 }else{
                     JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                 }
             }catch(Exception e){
                 System.out.println(e);
             }
         }else if(ae.getSource() == sign){
             setVisible(false);
             new SignupOne().setVisible(true);
         }
    }

    public static void main(String[] args){
        new Login();
    }
}