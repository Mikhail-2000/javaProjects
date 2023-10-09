import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
    private Ship beerShip; // корабль с медведями
    private Ship vodkaShip;

    private Image background = null;
    public GamePanel() {
        Image beer_ship_image = null;
        Image vodka_ship_image = null;
        Image beer_ship_bullet_image = null;
        Image vodka_ship_bullet_image = null;

        try {
            background = ImageIO.read(new File("BackGround.png"));
            background = background.getScaledInstance(1000, 800, Image.SCALE_DEFAULT );
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Неправильный путь до изображения :c");
        }

        try {
            beer_ship_image = ImageIO.read(new File("Ship1.png"));
            beer_ship_image = beer_ship_image.getScaledInstance(200, 40, Image.SCALE_DEFAULT );
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Неправильный путь до изображения :c");
        }
        try {
            vodka_ship_image = ImageIO.read(new File("Ship2.png"));
            vodka_ship_image = vodka_ship_image.getScaledInstance(200, 200, Image.SCALE_DEFAULT );

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Неправильный путь до изображения :c");
        }
        try {
            beer_ship_bullet_image = ImageIO.read(new File("Bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Неправильный путь до изображения :c");
        }
        try {
            vodka_ship_bullet_image = ImageIO.read(new File("Bullet.png"));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Неправильный путь до изображения :c");
        }

        beerShip = new Ship(100, 100, beer_ship_image, beer_ship_bullet_image);
        vodkaShip = new Ship(300, 300, vodka_ship_image, vodka_ship_bullet_image);

        setFocusable(true);

        addKeyListener(this);

        Timer timofei = new Timer(20, this);
        timofei.start();

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(background, 0, 0, null);
        beerShip.draw(g);
        vodkaShip.draw(g);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        beerShip.moveTo();
        vodkaShip.moveTo();
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == 87) beerShip.setUp(true);
        if (e.getKeyCode() == 83) beerShip.setDown(true);
        if (e.getKeyCode() == 65) beerShip.setLeft(true);
        if (e.getKeyCode() == 68) beerShip.setRight(true);
        if (e.getKeyCode() == 32) beerShip.shoot();
        if (e.getKeyCode() == 38) vodkaShip.setUp(true);
        if (e.getKeyCode() == 40) vodkaShip.setDown(true);
        if (e.getKeyCode() == 37) vodkaShip.setLeft(true);
        if (e.getKeyCode() == 39) vodkaShip.setRight(true);
        if (e.getKeyCode() == 10) vodkaShip.shoot();
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 87) beerShip.setUp(false);
        if (e.getKeyCode() == 83) beerShip.setDown(false);
        if (e.getKeyCode() == 65) beerShip.setLeft(false);
        if (e.getKeyCode() == 68) beerShip.setRight(false);
        if (e.getKeyCode() == 38) vodkaShip.setUp(false);
        if (e.getKeyCode() == 40) vodkaShip.setDown(false);
        if (e.getKeyCode() == 37) vodkaShip.setLeft(false);
        if (e.getKeyCode() == 39) vodkaShip.setRight(false);
    }
}
