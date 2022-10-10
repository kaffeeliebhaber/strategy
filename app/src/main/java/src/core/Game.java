package src.core;

import java.awt.event.MouseEvent;

import java.awt.Graphics2D;

public interface Game {

    void init();

    void keyPressed(final int keyCode);

    void keyReleased(final int keyCode);

    void mouseDragged(MouseEvent e);

    void mouseMoved(MouseEvent e);

    void mouseEntered(MouseEvent e);

    void mouseExited(MouseEvent e);

    void mouseClicked(MouseEvent e);

    void mousePressed(MouseEvent e);

    void mouseReleased(MouseEvent e);

    void update();

    void draw(Graphics2D g2D);

}
