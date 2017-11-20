import java.io.File;
import model.Image;
import persistence.FileImageLoader;

public class ImageViewerPA05 {

    public static void main(String[] args) {
        File folder = new File("/Users/Yisus95/Desktop/fondos");
        FileImageLoader listImages = new FileImageLoader(folder);
        Image image = listImages.loader();
        MainFrame mainFrame = new MainFrame();
        mainFrame.getImageDisplay().show(image);
    }
}
