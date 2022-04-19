package BounceBall;

import javax.swing.*;
import java.awt.*;

class Ball extends Thread {
    JPanel box;
    int P = 12, Q = 12, p = 0, q = 0, dp = 3, dq = 3;

    public Ball(JPanel pan) {
        box = pan;
    }

    public void draw() {
        Graphics g = box.getGraphics();
        g.fillOval(p, q, P, Q);
        g.dispose();
    }

    public void move() {
        if (!box.isVisible())
            return;
        Graphics g = box.getGraphics();
        g.setXORMode(box.getBackground());
        g.fillOval(p, q, P, Q);
        p += dp;
        q += dq;
        Dimension d = box.getSize();
        if (p < 0) {
            p = 0;
            dp = -dp;
        }
        if (p + P >= d.width) {
            p = d.width - P;
            dp = -dp;
        }
        if (q < 0) {
            q = 0;
            dq = -dq;
        }
        if (q + Q >= d.height) {
            q = d.height - Q;
            dq = -dq;
        }
        g.fillOval(p, q, P, Q);
        g.dispose();
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
