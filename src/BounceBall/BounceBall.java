package BounceBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BounceBall extends JFrame {
    private JPanel canvas;

    public BounceBall() {
        setSize(500, 300);
        setTitle("Bouncing Ball                *Group_of_Amazing_People*");

        Container container = getContentPane();
        canvas = new JPanel();
        container.add(canvas, "Center");


        JPanel panel = new JPanel();
        add(panel, "Start", new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                Ball ball = new Ball(canvas);
                ball.start();
            }
        });
        add(panel, "Stop", new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                canvas.setVisible(false);
                Ball ball = new Ball(canvas);
                ball.stop();
            }
        });
        add(panel, "Exit", new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                canvas.setVisible(false);
                System.exit(5);
            }
        });
        container.add(panel, "South");
    }

    public void add(Container container, String title, ActionListener
            listener) {
        JButton button = new JButton(title);
        container.add(button);
        button.addActionListener(listener);
    }
}
