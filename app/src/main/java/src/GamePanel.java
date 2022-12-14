package src;

import javax.swing.JPanel;
import java.awt.*;

import src.core.Game;
import src.core.KeyHandler;
import src.core.MouseHandler;

public class GamePanel extends JPanel implements Runnable {

    public static final int ORIG_TILE_SIZE = 16;
    public static final int SCALE = 3;
    public static final int TILE_SIZE = ORIG_TILE_SIZE * SCALE;
    public static final int MAX_SCREEN_COLS = 16;
    public static final int MAX_SCREEN_ROWS = 12;
    public static final int SCREEN_WIDTH = TILE_SIZE * MAX_SCREEN_COLS;
    public static final int SCREEN_HEIGHT = TILE_SIZE * MAX_SCREEN_ROWS;

    // THREAD
    private Thread gameThread;

    // GAME SETTINGS
    private final int FPS = 60;

    // GAME
    private final Game game;

    // DEBUG
    public static boolean debug;

    public GamePanel(final Game game) {

        this.game = game;

        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        //this.setBackground(Color.BLACK);
        this.setDoubleBuffered(true);
        this.setFocusable(true);
        this.requestFocus();

        // CREATE AND REGISTER KEYLISTENER.
        final KeyHandler keyHandler = new KeyHandler(game);
        final MouseHandler mouseHandler = new MouseHandler(game);

        addKeyListener(keyHandler);
        addMouseMotionListener(mouseHandler);
        addMouseListener(mouseHandler);

        // WE MAKE SURE GAME WILL BE INIT CORRECTLY.
        game.init();
    }

    public void start() {

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;
        long timer = 0;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            long deltaTime = currentTime - lastTime;

            delta += deltaTime / drawInterval;
            timer += deltaTime;
            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }

            if (timer >= 1000000000) {
                timer = 0;
            }
        }

    }

    public final void update() {
        game.update();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        game.draw(g2d);
        g2d.dispose();
    }
}
