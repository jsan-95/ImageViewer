package UI;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import model.Image;
public class SwingImageDisplay extends JPanel implements ImageDisplay{
    
    private Image currentImage;
    
    public SwingImageDisplay() {
        super(new BorderLayout());
    }
    
    @Override
    public void show(Image image) {
        this.removeAll();
        this.currentImage=image;
        this.add(new JPanel(){
            @Override
            public void paint(Graphics g){
                g.drawImage(imageOf(image), 0, 0, this.getWidth(), this.getHeight(), null);
            }
        });
        this.updateUI();
    }

    @Override
    public Image current() {
        return currentImage;
    }
    
    BufferedImage imageOf(Image imagen){
        try {
            return ImageIO.read(imagen.stream());
        } catch (IOException ex) {
            Logger.getLogger(SwingImageDisplay.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
