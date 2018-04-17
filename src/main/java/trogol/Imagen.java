package trogol;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 * Esta clase recibe un string con la dirección de una imagen y establece el ancho y alto de esta, para depués devolverla.
 *
 */
public class Imagen extends Figura{
        
    private Image img;
    
    Imagen (String archivoImagen)
    {
    	super(0,0,0,0);
		img=new ImageIcon(getClass().getResource("/fantasma.jpg")).getImage(); 
    	super.setAlto(img.getHeight(null));
		super.setAncho(img.getWidth(null));
	}
    
    @Override
    public void Mostrar(Graphics g) {
    	g.drawImage(img, super.getX(), super.getY(), null);
    }

		
}