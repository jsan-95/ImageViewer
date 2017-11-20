package persistence;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Image;

public class FileImageLoader implements ImageLoader{
    private final File[] files;
    private final static String[] ImageExtensions=new String[]{"jpg","png","bmp","gif"};
    
    public FileImageLoader(File folder) {
        this.files =folder.listFiles(imageType());
    }

    public FileFilter imageType(){
        return new FileFilter(){
            @Override
            public boolean accept(File pathname){
                for(String extension:ImageExtensions)
                    if(pathname.toString().endsWith(extension))return true;
                return false;
            }
        };
    }
    
    public Image imageAt(int par){
        return new Image(){

            @Override
            public Image next() {
               return(par<files.length-1)?imageAt(par+1):imageAt(0);
            }

            @Override
            public Image prev() {
                return (par>0)? imageAt(par-1):imageAt(files.length-1);
            }

            @Override
            public String name() {
                return files[par].getName();
            }

            @Override
            public InputStream stream() {
                try {
                    return new FileInputStream(files[par].getAbsolutePath());
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(FileImageLoader.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }
        };
    }
    
    @Override
    public Image loader() {
        return imageAt(0);
    }
}
