package BounceBall;

import javax.swing.*;
import java.awt.*;
import java.io.InvalidClassException;

import static java.awt.Color.BLUE;

public class Ball extends Thread {
    JPanel box;
    int width = 20, height = 20, front = 0, back = 0, bounceDown = 3, bounceSide = 3;

    public Ball(JPanel panel) {
        box = panel;
    }

    public void draw() {
        Graphics graphics = box.getGraphics();
        graphics.fillOval( front, back, width, height);
        graphics.dispose();
    }

    public void move() {
        if (!box.isVisible())
            return;
        Graphics graphics = box.getGraphics();
        graphics.setXORMode(box.getBackground());
        graphics.fillOval(front, back, width, height);
        front += bounceDown;
        back += bounceSide;

        Dimension dimension = box.getSize();
        if (front < 0) {
            front = 0;
            bounceDown = -bounceDown;
        }
        if (front + width >= dimension.width) {
            front = dimension.width - width;
            bounceDown = -bounceDown;
        }
        if (back < 0) {
            back = 0;
            bounceSide = -bounceSide;
        }
        if (back + height >= dimension.height) {
            back = dimension.height - height;
            bounceSide = -bounceSide;
        }
        graphics.fillOval(front, back, width, height);
        graphics.dispose();
    }

    public void run() {
        try {
            draw();
            for (int i = 1; i <= 2000; i++) {
                move();
                sleep(20);
            }
        } catch (Exception e) {
        }
    }
}
