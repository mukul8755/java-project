package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class about extends JFrame implements ActionListener {
    JLabel j1,j2;
    JButton b1;
    about() {
        setSize(500,300);
        setLayout(new FlowLayout());
        ImageIcon i = new ImageIcon("C:\\Users\\mukul\\IdeaProjects\\Java\\src\\com\\company\\m.png");
        JLabel j2 = new JLabel(i,JLabel.CENTER);
        add(j2);
        j1 = new JLabel("Developed by Mukul Sharma");
        j1.setFont(new Font("", Font.BOLD,30));
        j2.setFont(new Font("", Font.BOLD,30));
        add(j1);
        b1 = new JButton("Ok");
        b1.setFont(new Font("", Font.BOLD,30));

        add(b1);
        setVisible(true);
        b1.addActionListener(this);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }


    public static void main(String[] args) {
       new about();
    }
}
