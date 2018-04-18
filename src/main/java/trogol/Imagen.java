package trogol;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

/**
 * Esta clase recibe un string con la direcci�n de una imagen y establece el ancho y alto de esta, para depu�s devolverla.
 *
 */
public class Imagen extends Figura{
        
    private Image img;
    
    Imagen (String archivoImagen)
    {
    	super(Figura.x,Figura.y,Figura.ancho,Figura.alto);
		img=new ImageIcon(getClass().getResource("/fantasma.jpg")).getImage(); 
    	super.setAlto(img.getHeight(null));
		super.setAncho(img.getWidth(null));
	}
    
    @Override
    public void Mostrar(Graphics g) {
    	g.drawImage(img, super.getX(), super.getY(), null);
    	
    }

		
}