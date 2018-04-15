package trogol;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;

public class Imagen extends Figura{
    protected static String archivoImagen;    
    protected Image img=null;
    
    Imagen (String archivoImagen)
    {
    	super(x, y, ancho, alto);
    	img=new ImageIcon(getClass().getResource(archivoImagen)).getImage();      
    	super.setAlto(img.getHeight(null));
    	super.setAncho(img.getWidth(null));
    	
    }
    
    @Override
    public void Mostrar(Graphics g) {
    	   	
    	g.drawImage(img, super.getX(), super.getY(), null);
    	
    	   
        
        return;
    }

		
}