package org.mateusz;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyWindow frame = new MyWindow();
                } catch (Exception e) {
                    e.printStackTrace(System.err);
                }
            }
    });
        Logins logins=new Logins();
        logins.readFromFIle();
}
}