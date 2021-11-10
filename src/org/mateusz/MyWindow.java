package org.mateusz;

import javax.swing.*;
import java.awt.*;

public class MyWindow extends JFrame {

    MyWindow(){
        setTitle("Loging Screeen");
        setSize(new Dimension(640,480));
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
}
