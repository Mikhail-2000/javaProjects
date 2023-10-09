import javax.imageio.stream.FileImageInputStream;
import java.awt.*;
import java.util.ArrayList;

public class Ship {
    private int x = 0, y = 0;
    private Image avatar;
    private Image bullet_image;
    private boolean left = false, right = false, up = false, down = false;
    double r = 0; // угол поворота

    private ArrayList<Bullet> bullet_vector = new ArrayList<>();

    public Ship(int x, int y, Image avatar, Image bullet_image) {
        this.x = x;
        this.y = y;
        this.avatar = avatar;
        this.bullet_image = bullet_image;
    }

    public void moveTo() {
        int dx = (int) (Math.cos(r) * 10);
        int dy = (int) (Math.sin(r) * 10);
        if (up) {
            x = x - dx;
            y = y - dy;
        }
        if (down) {
            x = x + dx;
            y = y + dy;
        }
        if (right) r = r + 0.1;
        if (left) r = r - 0.1;
    }

    public void shoot() {
        Bullet bullet = new Bullet(x, y, bullet_image, r);
        bullet_vector.add(bullet);
    }

    public void setLeft(boolean left) {
        this.left = left;
    }

    public void setRight(boolean right) {
        this.right = right;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public void setDown(boolean down) {
        this.down = down;
    }

    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.rotate(r, x + avatar.getWidth(null) / 2, y + avatar.getHeight(null) / 2);
        g2d.drawImage(avatar, this.x, this.y, null);
        g2d.rotate(-r, x + avatar.getWidth(null) / 2, y + avatar.getHeight(null) / 2);
        for (var x: bullet_vector) {x.draw(g);}
    }
}
