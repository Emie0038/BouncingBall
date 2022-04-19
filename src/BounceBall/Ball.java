package BounceBall;

import javax.swing.*;
import java.awt.*;

import static java.awt.Color.BLUE;

class Ball extends Thread {
    JPanel box;
    int side1 = 20, side2 = 20, front = 0, back = 0, speedDown = 3, speedSide = 3;

    public Ball(JPanel panel) {
        box = panel;
    }

    public void draw() {
        Graphics graphics = box.getGraphics();
        graphics.fillOval( front, back, side1, side2);
        graphics.dispose();
    }

    public void move() {
        if (!box.isVisible())
            return;
        Graphics graphics = box.getGraphics();
        graphics.setXORMode(box.getBackground());
        graphics.fillOval(front, back, side1, side2);
        front += speedDown;
        back += speedSide;
        Dimension dimension = box.getSize();
        if (front < 0) {
            front = 0;
            speedDown = -speedDown;
        }
        if (front + side1 >= dimension.width) {
            front = dimension.width - side1;
            speedDown = -speedDown;
        }
        if (back < 0) {
            back = 0;
            speedSide = -speedSide;
        }
        if (back + side2 >= dimension.height) {
            back = dimension.height - side2;
            speedSide = -speedSide;
        }
        graphics.fillOval(front, back, side1, side2);
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
