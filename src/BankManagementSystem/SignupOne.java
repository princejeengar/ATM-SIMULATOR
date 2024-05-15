package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class SignupOne extends JFrame implements ActionListener {
    long random;
    JTextField nameText, FnameText, emailText, addressText, cityText, stateText, pinText;
    JButton Next;
    JRadioButton male, female, Other, married, unmarried, other;
    JDateChooser date;
    SignupOne(){
        setLayout(null);

        Random ran = new Random();
        random = Math.abs((ran.nextLong()% 9000L)+ 1000L);


        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel pd = new JLabel("Page 1: Personal Details");
        pd.setFont(new Font("Raleway", Font.BOLD, 22));
        pd.setBounds(290, 80, 400, 30);
        add(pd);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 22));
        name.setBounds(100, 140, 100, 30);
        add(name);

        nameText = new JTextField();
        nameText.setFont(new Font("Raleway", Font.BOLD, 14));
        nameText.setBounds(300, 140, 400, 30);
        add(nameText);

        JLabel Fname = new JLabel("Father's Name:");
        Fname.setFont(new Font("Raleway", Font.BOLD, 22));
        Fname.setBounds(100, 190, 200, 30);
        add(Fname);

        FnameText = new JTextField();
        FnameText.setFont(new Font("Raleway", Font.BOLD, 14));
        FnameText.setBounds(300, 190, 400, 30);
        add(FnameText);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 22));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        date = new JDateChooser();
        date.setBounds(300, 240, 400, 30);
        add(date);

        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 22));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300, 290, 60, 30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450, 290, 120, 30);
        female.setBackground(Color.WHITE);
        add(female);

        Other = new JRadioButton("Other");
        Other.setBounds(600, 290, 120, 30);
        Other.setBackground(Color.WHITE);
        add(Other);

        ButtonGroup groupGender = new ButtonGroup();
        groupGender.add(male);
        groupGender.add(female);
        groupGender.add(Other);

        JLabel Email = new JLabel("Email:");
        Email.setFont(new Font("Raleway", Font.BOLD, 22));
        Email.setBounds(100, 340, 200, 30);
        add(Email);

        emailText = new JTextField();
        emailText.setFont(new Font("Raleway", Font.BOLD, 14));
        emailText.setBounds(300, 340, 400, 30);
        add(emailText);

        JLabel Married = new JLabel("Maritial Status:");
        Married.setFont(new Font("Raleway", Font.BOLD, 22));
        Married.setBounds(100, 390, 200, 30);
        add(Married);

        married = new JRadioButton("Married");
        married.setBounds(300, 390, 120, 30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450, 390, 120, 30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(600, 390, 120, 30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup groupMaritial = new ButtonGroup();
        groupMaritial.add(married);
        groupMaritial.add(unmarried);
        groupMaritial.add(other);

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 22));
        address.setBounds(100, 440, 200, 30);
        add(address);

        addressText = new JTextField();
        addressText.setFont(new Font("Raleway", Font.BOLD, 14));
        addressText.setBounds(300, 440, 400, 30);
        add(addressText);

        JLabel city = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 22));
        city.setBounds(100, 490, 200, 30);
        add(city);

        cityText = new JTextField();
        cityText.setFont(new Font("Raleway", Font.BOLD, 14));
        cityText.setBounds(300, 490, 400, 30);
        add(cityText);

        JLabel State = new JLabel("State:");
        State.setFont(new Font("Raleway", Font.BOLD, 22));
        State.setBounds(100, 540, 200, 30);
        add(State);

        stateText = new JTextField();
        stateText.setFont(new Font("Raleway", Font.BOLD, 14));
        stateText.setBounds(300, 540, 400, 30);
        add(stateText);

        JLabel Pincode = new JLabel("Pincode:");
        Pincode.setFont(new Font("Raleway", Font.BOLD, 22));
        Pincode.setBounds(100, 590, 200, 30);
        add(Pincode);

        pinText = new JTextField();
        pinText.setFont(new Font("Raleway", Font.BOLD, 14));
        pinText.setBounds(300, 590, 400, 30);
        add(pinText);

        Next = new JButton("Next");
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setFont(new Font("Raleway", Font.BOLD, 14));
        Next.setBounds(620, 660, 80, 30);
        Next.addActionListener(this);
        add(Next);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = "" + random;
        String name = nameText.getText();
        String Fname = FnameText.getText();
        String dob = ((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender = null;
        if(male.isSelected()){
            gender = "Male";
        }else if(female.isSelected()){
            gender = "Female";
        }else if(Other.isSelected()){
            gender = "Other";
        }
        String email = emailText.getText();
        String maritial = null;
        if(married.isSelected()){
            maritial = "Married";
        }else if(unmarried.isSelected()){
            maritial = "Unmarried";
        }else if(other.isSelected()){
            maritial = "Other";
        }
        String address = addressText.getText();
        String city = cityText.getText();
        String state = stateText.getText();
        String pin = pinText.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
            }else{
                Conn c = new Conn();
                String query = "Insert into signup values('"+formno+"','"+name+"','"+Fname+"','"+dob+"','"+gender+"','"+email+"','"+maritial+"','"+address+"','"+city+"','"+pin+"','"+state+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){
        new SignupOne();
    }
}