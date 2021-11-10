package org.mateusz;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.Map;

public class MyWindow extends JFrame {

    MyWindow() {
        Logins log=new Logins();
        log.readFromFIle();

        setTitle("Loging Screeen"); //nazwa okna
        setSize(new Dimension(640, 480)); //ustawienie wymiarów
        setResizable(false); //uniemozliwienie zmiany wymiarow
        setLocationRelativeTo(null); //wycentrowanie otwieranego okna

        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(5, 5, 617, 435);
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        contentPane.add(panel);

        JTextField user = new JTextField();
        user.setBounds(200, 170, 220, 20);
        user.setFont(new Font("Sans Serif", Font.PLAIN, 16));

        JPasswordField password = new JPasswordField();
        password.setBounds(200, 200, 220, 20);
        password.setFont(new Font("Sans Serif", Font.PLAIN, 16));



        JButton buttons = new JButton("Sign in");
        buttons.setFocusable(false);
        buttons.setBounds(200, 230, 100, 30);
        buttons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Map.Entry<String,String> entry : log.logins.entrySet()){
                    if(entry.getKey().equals(user.getText()) &&
                            entry.getValue().equals(new String(password.getPassword()))){
                        panel.setBackground(new Color(68, 168, 17));
                        return;
                    }
                }
                panel.setBackground(new Color(184, 20, 20));
                password.setText(null);
            }
        });

        JButton buttonc = new JButton("Cancel");
        buttonc.setFocusable(false);
        buttonc.setBounds(320, 230, 100, 30);
        buttonc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               user.setText(null);
               password.setText(null);
               panel.setBackground(Color.GRAY);
            }
        });

        JLabel userlabel = new JLabel("User:");
        userlabel.setForeground(Color.BLACK);
        userlabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        userlabel.setBounds(160, 170, 50, 20);

        JLabel passwordlabel = new JLabel("Password:");
        passwordlabel.setForeground(Color.BLACK);
        passwordlabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        passwordlabel.setBounds(130, 200, 100, 20);

        panel.add(passwordlabel);
        panel.add(userlabel);
        panel.add(password);
        panel.add(user);
        panel.add(buttons);
        panel.add(buttonc);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);


    }
}
