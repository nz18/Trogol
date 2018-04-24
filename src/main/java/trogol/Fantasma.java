package trogol;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class Fantasma extends Personaje implements Runnable{
	
	private Image ghost;
	private JSpinner Energía;
	private Graphics g;
	private JPanel Panel;
	
	public Fantasma(String archivoImagen,JSpinner Energía, Graphics g, JPanel Panel)
	  {
		super(archivoImagen);
		this.Energía=Energía;
		this.g=g;
		this.Panel=Panel;
		ghost=new ImageIcon(getClass().getResource("/fantasma.jpg")).getImage(); 
    	super.setAlto(ghost.getHeight(null));
		super.setAncho(ghost.getWidth(null));
	  }
	  
	@Override
	public void run() {
		if((Integer)Energía.getValue()>0) {
			Mover();
		}
	}
	public void Mover() {
		Random r=new Random();
		int mov=r.nextInt(4);
		Ocultar(g,Panel.getBackground());
		switch(mov) {
		case 0: 
			for(int i=0; i<maxComida; i=i+1) {
				for(int j=0; i<maxFantasmas; j=j+1) {
					if(vGhost[j].getX()!=vComida[i].getX()||(vGhost[j].getY()-50)!=vComida[i].getY()) {
						moverArriba(0);
						}
					}
			}
		    break;
		
		case 1: 
			for(int i=0; i<maxComida; i=i+1) {
				for(int j=0; i<maxFantasmas; j=j+1) {
					if((vGhost[j].getX()-50)!=vComida[i].getX()||vGhost[j].getY()!=vComida[i].getY()) {
						moverIzquierda(0);
						}
					}
			}
		    break;			
			
		case 2: 
			for(int i=0; i<maxComida; i=i+1) {
				for(int j=0; i<maxFantasmas; j=j+1) {
					if((vGhost[j].getX()+50)!=vComida[i].getX()||vGhost[j].getY()!=vComida[i].getY()) {
						moverDerecha(Panel.getWidth());
						}
					}
			}
			break;
						
		case 3:	
			for(int i=0; i<maxComida; i=i+1) {
				for(int j=0; i<maxFantasmas; j=j+1) {
					if(vGhost[j].getX()!=vComida[i].getX()||(vGhost[j].getY()+50)!=vComida[i].getY()) {
						moverAbajo(Panel.getWidth());
						}
					}
			}
			break;
		}
		Mostrar(g);
	}
	  @Override
	    public void Mostrar(Graphics g) {
	    	g.drawImage(ghost, super.getX(), super.getY(), null);
	    	
	    }
	
	    

}
