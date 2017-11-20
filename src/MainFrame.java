
import UI.ImageDisplay;
import UI.SwingImageDisplay;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame{
    private ImageDisplay imageDisplay;
    
    public MainFrame() {
        
        this.setTitle("ImageViewer");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(imageDisplay());
        this.getContentPane().add(toolBar(), BorderLayout.SOUTH);
        this.setVisible(true);
    }
    
    private JPanel toolBar(){
        JPanel panel = new JPanel();
        panel.add(prevButton());
        panel.add(nextButton());
        return panel;
    }
    
    private JButton prevButton(){
        JButton button = new JButton("<");
        button.addActionListener(new ActionListener() {
        @Override
           public void actionPerformed(ActionEvent e) {
               prevImage();
            } 
        });
        return button;
    }
    
    private void prevImage(){
        getImageDisplay().show(getImageDisplay().current().prev());
    }
    
    private JButton nextButton(){
        JButton button = new JButton(">");
        button.addActionListener(new ActionListener() {
        @Override
           public void actionPerformed(ActionEvent e) {
                nextImage();
            } 
        });
        return button;
    }
    
    private void nextImage(){
        getImageDisplay().show(getImageDisplay().current().next());
    }
    
    private JPanel imageDisplay(){
        imageDisplay = new SwingImageDisplay();
        return (JPanel) imageDisplay;
    }
    
    public ImageDisplay getImageDisplay(){
        return imageDisplay;
        
    }
}
