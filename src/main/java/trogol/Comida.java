package trogol;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Comida extends Personaje {
	
	private Image comida;
	
	Comida(String archivoImagen)
	  {
		super(archivoImagen);
		comida=new ImageIcon(getClass().getResource("/Hamburguesa.jpg")).getImage(); 
    	super.setAlto(comida.getHeight(null));
		super.setAncho(comida.getWidth(null));
	  }
	   @Override
	    public void mostrar(Graphics g) {
	    	g.drawImage(comida, super.getX(), super.getY(), null);
	    	
	    }
	    

}
