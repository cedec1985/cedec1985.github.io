/**
 * 
 */
package classes;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
/**
 * 
 */
public class ImageUtils {

	public static BufferedImage redimensionnerImage(File fichierImage, int largeur, int hauteur) {
		try {
			BufferedImage imageOriginale = ImageIO.read(fichierImage);
			Image imageRedimensionnee = imageOriginale.getScaledInstance(largeur,hauteur,Image.SCALE_SMOOTH);
			
			BufferedImage bufferedRedim = new BufferedImage(largeur,hauteur,BufferedImage.TYPE_INT_RGB);
			Graphics2D g2d = bufferedRedim.createGraphics();
			g2d.drawImage(imageRedimensionnee,0,0,null);
			g2d.dispose();
			
			 return bufferedRedim;
		} catch (Exception e) {
			e.printStackTrace();
		}
	         return null;
	}
    public static BufferedImage redimensionnerImage(String labelZoom, int largeur, int hauteur) {
    	  try {
    		  File f = new File(labelZoom);
    		  BufferedImage imageOriginale = ImageIO.read(f);
    		  Image imageRedimensionnee = imageOriginale.getScaledInstance(largeur, hauteur,Image.SCALE_SMOOTH);
    		  
    		  BufferedImage bufferedRedim = new BufferedImage(largeur,hauteur,BufferedImage.TYPE_INT_RGB);
    		  Graphics2D g2d = bufferedRedim.createGraphics();
    		  g2d.drawImage(imageRedimensionnee, 0, 0, null);
    		  g2d.dispose();
    		  
    		  return bufferedRedim;
    	  }catch (Exception e) {
    		  e.printStackTrace();
    	  }
		return null;
    	
    }
	
}
