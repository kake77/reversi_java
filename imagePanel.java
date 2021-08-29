import javax.imageio.ImageIO;
import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.awt.Graphics;

public class imagePanel extends JPanel {
    Image img=null;
    public imagePanel(String imgPath){
        setBackground(Color.black);
        try{
            img=ImageIO.read(new File(imgPath));
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0, 0, this);
    }
}
