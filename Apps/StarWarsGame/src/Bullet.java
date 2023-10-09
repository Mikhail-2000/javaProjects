import java.awt.*;

public class Bullet {
    private int x=0, y=0;
    private Image avatar;
    double r = 0; // угол поворота
    private int count = 0;

    public Bullet(int x, int y, Image avatar, double ship_r) {
        this.x = x;
        this.y = y;
        this.avatar = avatar;
        this.avatar = this.avatar.getScaledInstance(80, 50, Image.SCALE_DEFAULT );
        this.r = ship_r;
    }

    public void moveTo() {
        count += 1;
        int dx = (int) (Math.cos(r) * 15);
        int dy = (int) (Math.sin(r) * 15);
        x = x - dx;
        y = y - dy;

    }

    public void draw(Graphics g) {
            moveTo();
            Graphics2D g2d = (Graphics2D) g;
            g2d.rotate(r, x + avatar.getWidth(null) / 2, y + avatar.getHeight(null) / 2);
            g2d.drawImage(avatar, this.x, this.y, null);
            g2d.rotate(-r, x + avatar.getWidth(null) / 2, y + avatar.getHeight(null) / 2);

    }

}
