package BounceBall;

import javax.swing.*;
import java.awt.*;
import java.io.InvalidClassException;

import static java.awt.Color.BLUE;

class Ball extends Thread {
    JPanel box;
    int width = 20, height = 20, front = 0, back = 0, speedDown = 3, speedSide = 3;

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
        front += speedDown;
        back += speedSide;

        Dimension dimension = box.getSize();
        if (front < 0) {
            front = 0;
            speedDown = -speedDown;
        }
        if (front + width >= dimension.width) {
            front = dimension.width - width;
            speedDown = -speedDown;
        }
        if (back < 0) {
            back = 0;
            speedSide = -speedSide;
        }
        if (back + height >= dimension.height) {
            back = dimension.height - height;
            speedSide = -speedSide;
        }
        graphics.fillOval(front, back, width, height);
        graphics.dispose();
    }

    public void run() {
        try {
            draw();
            for (int i = 1; i <= 1000; i++) {
                move();
                sleep(10);
            }
        } catch (Exception e) {
        }
    }
}
