package UI;

import javax.swing.JPanel;
import model.Image;

public interface ImageDisplay {
    
    void show(Image imagen);
    Image current();
}
