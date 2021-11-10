package org.mateusz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Map;

//klasa z konstruktorem MyWindow, który obsługuje GUI
public class MyWindow extends JFrame {
    MyWindow() {

        Logins log=new Logins(); //utworzenie obiektu z danymi do logowania
        log.readFromFIle(); //wczytanie z pliku

        setTitle("Loging Screeen"); //nazwa okna
        setSize(new Dimension(640, 480)); //ustawienie wymiarów
        setResizable(false); //uniemozliwienie zmiany wymiarow
        setLocationRelativeTo(null); //wycentrowanie otwieranego okna

        JPanel panel = new JPanel(); //wyjściowa kanwa
        panel.setBackground(Color.GRAY);
        panel.setLayout(null);
        add(panel);//dodanie panelu do JFrame

        JTextField user = new JTextField(); //tworzenie pola tekstowego
        user.setBounds(200, 170, 220, 20);
        user.setFont(new Font("Sans Serif", Font.PLAIN, 16));


        JPasswordField password = new JPasswordField(); //tworzenie pola z hasłem
        password.setBounds(200, 200, 220, 20);
        password.setFont(new Font("Sans Serif", Font.PLAIN, 16));


        JButton buttons = new JButton("Sign in"); //tworzenie przycisku logowania
        buttons.setFocusable(false);
        buttons.setBounds(200, 230, 100, 30);
        buttons.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(Map.Entry<String,String> entry : log.logins.entrySet()){
                    if(entry.getKey().equals(user.getText()) && //sprawdzanie zgodności nazwy użytkownika i hasła
                            Arrays.equals(entry.getValue().toCharArray(),password.getPassword())){
                        panel.setBackground(new Color(68, 168, 17)); //ustawienie koloru na zielony
                        return;
                    }
                }
                panel.setBackground(new Color(184, 20, 20)); //ustawienie koloru na czerwony
                password.setText(null); //reset hasła po złym jego wpisaniu
                return;
            }
        });

        JButton buttonc = new JButton("Cancel"); //tworzenie przycisku, który czyści zawartość obu pół i resetuje kolor planszy
        buttonc.setFocusable(false);
        buttonc.setBounds(320, 230, 100, 30);
        buttonc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) { //czyszczenie pól i zmiana koloru na wyjściowy
               user.setText(null);
               password.setText(null);
               panel.setBackground(Color.GRAY);
            }
        });

        JLabel userlabel = new JLabel("User:"); //tworzenie etykiety User
        userlabel.setForeground(Color.BLACK);
        userlabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        userlabel.setBounds(160, 170, 50, 20);

        JLabel passwordlabel = new JLabel("Password:"); //tworzenie etykiety password
        passwordlabel.setForeground(Color.BLACK);
        passwordlabel.setFont(new Font("Sans Serif", Font.PLAIN, 14));
        passwordlabel.setBounds(130, 200, 100, 20);

        panel.add(passwordlabel);//dodwanie elementów do wyświetlania na panelu
        panel.add(userlabel);
        panel.add(password);
        panel.add(user);
        panel.add(buttons);
        panel.add(buttonc);

        setDefaultCloseOperation(EXIT_ON_CLOSE);//zakończenie działania programu po naciśnięciu X
        setVisible(true); //zmiana widoczności okna
    }


}
