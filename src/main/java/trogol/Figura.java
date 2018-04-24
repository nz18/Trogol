package trogol;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;

/**
 * Esta clase recibe y devuelve las coordenadas de la esquina superior izquierda, ancho y alto de una figura (un rectángulo)
 * Con esos datos luego se dibuja y se oculta un rectángulo
 */
public class Figura extends JuegoTrogols{

	protected int x;
	protected int y;
	protected int ancho;
	protected int alto;
	
	Figura(int x, int y, int ancho, int alto){
		this.x=x;
		this.y=y;
		this.ancho=ancho;
		this.alto=alto;
	}
	
	 public void setX(int x)
	    {
		 this.x=x;
	    }
	    
	 public int getX()
	    {
	        return x;      
	    }
	    
	 public void setY(int y)
	    {
	    	this.y=y;       
	    }
	    
	 public int getY()
	    {
	         return y;      
	    }

	 public void setAlto(int alto)
	    {
	    	this.alto=alto;
	    }
	 
	 public int getAlto()
	    {
	       return alto;
	    }
	
	 public void setAncho(int ancho)
	    {
	    	this.ancho=ancho;  
	    }
	    
	 public int getAncho()
	    {
		 

		 return ancho;
	    }

	 public void Mostrar(Graphics g)
	    {
	     
	    	g.setColor(Color.RED);
	    	g.fillRect(x, y, ancho, alto);
	    
	       return;
	    }
	
	 public void Ocultar(Graphics f,Color c)
	    {
	    	 f.setColor(c);
	    	 f.fillRect(x, y, ancho, alto);
	    	 
		   return;
	    }

	
}