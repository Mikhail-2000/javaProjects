import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {
    private int xSize = 1000;
    private int ySize = 800;
    public GameFrame() throws HeadlessException {

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("StarWars");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();

        this.setBounds(dimension.width/2 - xSize/2, dimension.height/2-ySize/2, xSize, ySize);
        add(new GamePanel());
        setVisible(true);
    }
}
