package trogol;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;


public class Figura extends JuegoTrogols{

	static protected int x;
	static protected int y;
	static protected int ancho;
	static protected int alto;
	
	Figura(int x, int y, int ancho, int alto){
		Figura.x=x;
		Figura.y=y;
		Figura.ancho=ancho;
		Figura.alto=alto;
	}
	
	 public void setX(int x)
	    {
		 Figura.x=x;
	    }
	    
	 public int getX()
	    {
	        return x;      
	    }
	    
	 public void setY(int y)
	    {
	    	Figura.y=y;       
	    }
	    
	 public int getY()
	    {
	         return y;      
	    }

	 public void setAlto(int alto)
	    {
	    	Figura.alto=alto;
	    }
	 
	 public int getAlto()
	    {
	       return alto;
	    }
	
	 public void setAncho(int ancho)
	    {
	    	Figura.ancho=ancho;  
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

	public void getComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	
}