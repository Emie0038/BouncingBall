package BounceBall;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class BounceThread extends JFrame {
    private JPanel canvas;

    public BounceThread() {
        setSize(500, 300);
        setTitle("Bouncing Ball                *Group_Amazing_People*");

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
        JRadioButton button = new JRadioButton(title);
        container.add(button);
        button.addActionListener(listener);
    }
}
