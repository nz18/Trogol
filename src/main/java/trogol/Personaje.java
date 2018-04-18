package trogol;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;

public class Personaje extends Imagen {
	
	private Image mons;
	
	Personaje(String archivoImagen)
	  {
		super(archivoImagen);
		mons=new ImageIcon(getClass().getResource("/monster.jpg")).getImage(); 
    	super.setAlto(mons.getHeight(null));
		super.setAncho(mons.getWidth(null));
	  }
	  
	    public void ColocarAleatorio(int anchoPanel, int altoPanel)
	    {
	        int numCol,numFil,x,y;
	        Random numero;
	            
	        numCol=anchoPanel/getAncho();     // calcula el número de columnas
	        numFil=altoPanel/getAlto();       // calcula el número de filas
	        
	        numero=new Random();
	        x=numero.nextInt(numCol);            // columna aleatoria
	        y=numero.nextInt(numFil);           // fila aleatoria
	       
	       super.setX(x*super.getAncho());        // coloca la imagen en la columna aleatoria
	       super.setY(y*super.getAlto());        // coloca la imagen en la fila aleatoria
	       
	    }
	    @Override
	    public void Mostrar(Graphics g) {
	    	g.drawImage(mons, super.getX(), super.getY(), null);
	    	
	    }
	    
	    public void moverArriba(int min)
	    {
	    	// Si la coordenada Y es mayor que el min, resta a la coordenada Y su altura
	        if(super.getY() > min) {
	        	super.setY(super.getY()-super.getAlto());
	        }
	           
	    }
	    
	    public void moverAbajo(int max)
	    {
	        // Si la coordenada Y + su altura es menor que max, suma la coordenada Y la altura
	    	 if(super.getY()+super.getAlto() < max) {
		        	super.setY(super.getY()+super.getAlto());
	    	}
	    }
	    
	    public void moverIzquierda(int min)
	    {
	        // Si la coordenada X es mayor que min, resta a la coordenada X su anchura     
	    	 if(super.getX() > min) {
		        	super.setX(super.getX()-super.getAncho());
	    	 }
	    }
	    
	    public void moverDerecha(int max)
	    {
	        // Si la coordenada X + su anchura es menor que max, suma a la coordenada X su anchura
	    	 if(super.getX()+super.getAncho() < max) {
		        	super.setX(super.getX()+super.getAncho());
		     }
	    }

}
