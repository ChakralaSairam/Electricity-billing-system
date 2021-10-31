/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Electricity;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DebitCard extends JFrame implements ActionListener{
    JLabel l1,l2,l3;
    JTextField t1,t2;
    Choice c1;
    JButton b1,b2;
    String meter;
    String month;
    DebitCard(String meter,String month){
        this.meter=meter;
        this.month=month;
        setLayout(null);
        
        setBounds(500, 100, 900, 600);
        
        JLabel title = new JLabel("Debit Card");
        title.setFont(new Font("Tahoma", Font.BOLD, 24));
        title.setBounds(120, 5, 400, 30);
        add(title);
        
        l1 = new JLabel("Bank Name");
        l1.setBounds(35, 80, 200, 20);
        add(l1);
        
        c1=new Choice();
        c1.setBounds(300, 80, 200, 20);
        c1.add("State Bank of India");
        c1.add("Central Bank of India");
        c1.add("HDFC Bank");
        c1.add("ICICI Bank");
        c1.add("Axis Bank");
        add(c1);
                
        l2 = new JLabel("Card Number");
        l2.setBounds(35, 180, 200, 20);
        add(l2);
        
        t1 = new JTextField();
        t1.setBounds(300, 180, 200, 20);
        add(t1);
        
        l3 = new JLabel("CVV");
        l3.setBounds(35, 280, 200, 20);
        add(l3);
        
        
        t2 = new JTextField();
        t2.setBounds(300, 280, 200, 20);
        add(t2);
        
        b1 = new JButton("Pay bill");
        b1.setBounds(100, 400, 100, 25);
        add(b1);
        
        b2 = new JButton("Back");
        b2.setBounds(350, 400, 100, 25);
        add(b2);
        
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);

        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        getContentPane().setBackground(Color.WHITE); 
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == b1){
            if(t1.getText().equals("") || t2.getText().equals("")){
                JOptionPane.showMessageDialog(null,"Missing details");
            }
            else
                {
                    try{
                        Conn c = new Conn();
                        //c.s.executeUpdate("UPDATE bill SET status='"+"Paid"+"' WHERE meter="+meter);
                        c.s.executeUpdate("UPDATE bill SET status='"+"Paid"+"'"+ "WHERE meter='"+meter+"' AND month='"+month+"'");
            
                        this.setVisible(false);
                        }catch(Exception e){System.out.println("wrong");}
                            
                }
        }
        if(ae.getSource() == b2){
            this.setVisible(false);
            new PayBill("").setVisible(true);
        }
    }
            
    public static void main(String[] args){
        new DebitCard("","").setVisible(true);
    }
}
