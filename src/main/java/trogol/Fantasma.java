package trogol;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JSpinner;

public class Fantasma extends Personaje implements Runnable{
	
	private Thread hilo;
	private Image ghost;

	private Graphics g;
	private JPanel Panel;
	private Personaje mons;

	private Fantasma [] vGhost= new Fantasma[maxFantasmas];
	int espera;
	
	public Fantasma(String archivoImagen,JSpinner energia, Graphics g, JPanel Panel,Personaje mons, Comida [] vComida, Fantasma [] vGhost, int espera)
	  {
		super(archivoImagen);
		this.energia=energia;
		this.g=g;
		this.Panel=Panel;
		ghost=new ImageIcon(getClass().getResource("/fantasma.jpg")).getImage(); 
    	super.setAlto(ghost.getHeight(null));
		super.setAncho(ghost.getWidth(null));
		this.espera=espera;
		this.mons=mons;
		
		for(int i=0; i<maxFantasmas; i++) {
			this.vGhost[i]=vGhost[i];
		}
		
		if (hilo == null) {
			hilo = new Thread(this);
			hilo.start();

			}

		
	  }
	  
	@Override
	public void run() {
		while((Integer)energia.getValue()>0) {
			moverFantasma();
			comprobarFinalPartida();
			try{ 
				Thread.sleep(espera);
			} catch(InterruptedException e){}	
		}
			
		
	}
	/**
	 * Mueve aleatoriamente los fantasmas hacia izquierda, derecha, arriba o abajo
	 */
	public void mover() {
		
		Random r=new Random();
		int mov=r.nextInt(4);
		
		switch(mov) {
		case 0:{ 
			
			moverArriba(0);
					
		    break;}
		
		case 1:{
			
			moverIzquierda(0);

		    break;}
			
		case 2:{ 
			
			moverDerecha(Panel.getWidth());
	
		    break;}
		
		case 3:{
			
		    moverAbajo(Panel.getHeight());
			
		    break;}
		default:{}
		}
	}
	  @Override
	    public void mostrar(Graphics g) {
	    	g.drawImage(ghost, super.getX(), super.getY(), null);
	    	
	    }
	  
	  /**
		 * Mueve el fantasma a una posicion en la que no haya ni comida ni otro fantasma
		 */
	  public void moverFantasma() {
	    boolean fantasmaMovido=false;
		ocultar(g,Panel.getBackground());
	    while(!fantasmaMovido&&(int) energia.getValue()>0) {
			/*almacenamos la posicion*/
					
	    	int x=getX();
			int y=getY();
					
			/*tratamos de moverlo*/

			mover();
			if(getX() == mons.getX() && getY() == mons.getY())
				energia.setValue(-1);
					
			boolean coincideComida=false;
			for(int contComida=0; contComida<maxComida; contComida++) {
				if(getX()==JuegoTrogols.vComida[contComida].getX()&&getY()==JuegoTrogols.vComida[contComida].getY()){
					coincideComida=true; 
					JuegoTrogols.vComida[contComida].mostrar(g);
				}
			}
					
			boolean coincideFantasma=false;
			for(int contFantasma=0; contFantasma<maxFantasmas; contFantasma++) {
				if(vGhost[contFantasma]!=null&&vGhost[contFantasma].getX()==getX()&& vGhost[contFantasma].getY()==getY()) {
					coincideFantasma=true;
				}
			}
					
			if(!coincideComida && !coincideFantasma){
				fantasmaMovido=true;
			}else{
				setX(x);
				setY(y);
			}
					
		}
	    mostrar(g);
	    	 
	  }
	  
	  
}