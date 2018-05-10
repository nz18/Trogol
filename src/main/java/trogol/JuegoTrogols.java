package trogol;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
//import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

/**
 * En esta clase se produce el desarrollo del juego trogols
 */
public class JuegoTrogols extends JFrame {

	/**
	 * No sé que poner xD
	 */
	private JFrame frame;
	private JPanel panel_1;
	private Info Info1 = new Info();
	private GameOver gameOver1=new GameOver();
	private JLabel lblUsuario;
	private JPanel Panel;
	protected Graphics g;
	private Usuario user;
	public JButton btnEmpezar;
	public JButton btnInfo;
	public JButton btnArriba;
	public JButton btnAbajo;
	public JButton btnIzquierda;
	public JButton btnDerecha;
	public JButton btnHiperespacio;
	
	public void setUsuario(Usuario Usuario1) {
		user = Usuario1;
	}
	private int maxMonstruos=1;
	public int maxFantasmas=4;
	public static int maxComida=5;
	private JSpinner puntos;
	protected JSpinner energia;
	public Fantasma [] vGhost= new Fantasma[maxFantasmas];
	public static Comida [] vComida= new Comida[maxComida];
	public Personaje mons;
	private boolean partidaIniciada= false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JuegoTrogols window = new JuegoTrogols();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JuegoTrogols() {
		getContentPane().setLayout(null);

		JLabel lblTrogols = new JLabel("TROGOLS");
		lblTrogols.setForeground(Color.RED);
		lblTrogols.setHorizontalAlignment(SwingConstants.CENTER);
		lblTrogols.setFont(new Font("Arial", Font.BOLD, 20));
		lblTrogols.setBounds(187, 38, 124, 30);
		getContentPane().add(lblTrogols);

		lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial", Font.ITALIC, 15));
		lblUsuario.setBounds(121, 78, 205, 26);
		getContentPane().add(lblUsuario);

		Panel = new JPanel();
		Panel.setBackground(Color.WHITE);
		Panel.setBounds(31, 155, 450, 350);
		getContentPane().add(Panel);
		Panel.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(500, 152, 172, 172);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblEnerga = new JLabel("Energ\u00EDa");
		lblEnerga.setFont(new Font("Arial", Font.PLAIN, 15));
		lblEnerga.setBounds(10, 106, 63, 18);
		panel_1.add(lblEnerga);

		JLabel lblPuntos = new JLabel("Puntos");
		lblPuntos.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPuntos.setBounds(10, 51, 56, 13);
		panel_1.add(lblPuntos);

		JLabel lblInformacin = new JLabel("Informaci\u00F3n");
		lblInformacin.setFont(new Font("Arial", Font.BOLD, 15));
		lblInformacin.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacin.setBounds(41, 10, 91, 18);
		panel_1.add(lblInformacin);

		puntos = new JSpinner();
		puntos.setModel(new SpinnerNumberModel(0, null, null, 1));
		puntos.setEnabled(false);
		puntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		puntos.setBounds(96, 49, 66, 33);
		panel_1.add(puntos);

		energia = new JSpinner();
		energia.setEnabled(false);
		energia.setModel(new SpinnerNumberModel(10, 0, 100, 1));
		energia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		energia.setBounds(96, 106, 66, 33);
		panel_1.add(energia);
		
		/*Botones y listeners*/
		btnEmpezar = new JButton("Empezar");
		btnEmpezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnEmpezar.isEnabled())
					botonEmpezar();
			}

		});
		btnEmpezar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEmpezar.setBounds(516, 40, 99, 30);
		btnEmpezar.setEnabled(true);
		getContentPane().add(btnEmpezar);

		btnInfo = new JButton("Info");
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnInfo.isEnabled()){
					Info1.setBounds(516, 40, 550, 350);
					Info1.setVisible(true);
				}
			}
		});
		btnInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInfo.setBounds(516, 80, 99, 30);
		btnInfo.setEnabled(true);
		getContentPane().add(btnInfo);

		btnArriba = new JButton("Arriba");
		btnArriba.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnArriba.isEnabled())
					botonArriba();							
			}

		});
		btnArriba.setBounds(554, 352, 85, 21);
		btnArriba.setEnabled(false);
		getContentPane().add(btnArriba);

		btnIzquierda = new JButton("Izquierda");
		btnIzquierda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnIzquierda.isEnabled())
					botonIzquierda();			
			}
		});
		btnIzquierda.setBounds(491, 383, 99, 21);
		btnIzquierda.setEnabled(false);
		getContentPane().add(btnIzquierda);

		btnDerecha = new JButton("Derecha");
		btnDerecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnDerecha.isEnabled())
					botonDerecha();			
			}
		});
		btnDerecha.setBounds(607, 383, 91, 21);
		btnDerecha.setEnabled(false);
		getContentPane().add(btnDerecha);

		btnAbajo = new JButton("Abajo");
		btnAbajo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbajo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnAbajo.isEnabled())
					botonAbajo();			
			}
		});
		btnAbajo.setBounds(554, 414, 85, 21);
		btnAbajo.setEnabled(false);
		getContentPane().add(btnAbajo);
		
		btnHiperespacio = new JButton("Hiperespacio");
		btnHiperespacio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(btnHiperespacio.isEnabled())
					botonHiperespacio();			
			}

			
		});
		btnHiperespacio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHiperespacio.setBounds(516, 445, 172, 21);
		btnHiperespacio.setEnabled(false);
		getContentPane().add(btnHiperespacio);
		
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 850, 850);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
/**
 * Metodo que inicializa los componentes del juego
 */
	private void inicializarTablero() {
		g=Panel.getGraphics();
		/*Colocamos el Monstruo*/	
		mons= new Personaje("../Imagenes/monster.jpg");
		int contMonstruo=0;
		do{
			mons.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
			mons.mostrar(g);
			contMonstruo=contMonstruo+1;

		}while(contMonstruo<maxMonstruos);
		
		/*Insertamos las hamburguesas*/
//		Comida comida= new Comida("../Imagenes/Hamburguesa.jpg");
//		int contComida=0;
//			do {
//				comida.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
//				if(isPosicionVacia(comida,vComida)&&(mons.getX()!=comida.getX()||mons.getY()!=comida.getY())){
//					vComida[contComida]=comida;
//					vComida[contComida].mostrar(g);
//					contComida=contComida+1;
//					comida= new Comida("../Imagenes/Hamburguesa.jpg");
//				}
//		}while(contComida<maxComida);
			
			Comida comida=null;
			for(int contComida=0;contComida<maxComida;contComida++){
				comida=new Comida("../Imagenes/Hamburguesa.jpg");
				comida.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
				while(!isPosicionVacia(comida,vComida)||(mons.getX()==comida.getX()&&mons.getY()==comida.getY())){
					comida.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
				}
				vComida[contComida]=comida;
				vComida[contComida].mostrar(g);
			}
		
		/*Insertamos los fantasmas en el tablero*/
//		Fantasma ghost=new Fantasma("../Imagenes/fantasma.jpg", energia, g , Panel,mons,vComida,vGhost);
//		int contFantasma=0;
//		do {
//			ghost.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
//			if(isPosicionVacia(ghost,vGhost)&&(mons.getX()!=ghost.getX()||mons.getY()!=ghost.getY())&&isPosicionVacia(ghost,vComida)){
//				vGhost[contFantasma]=ghost;
//				vGhost[contFantasma].mostrar(g);
//				contFantasma=contFantasma+1;
//				ghost=new Fantasma("../Imagenes/fantasma.jpg", energia, g , Panel, mons, vComida,vGhost);
//			}
//		}while(contFantasma<maxFantasmas);
		
		

			
		Fantasma ghost=null;
		for(int contFantasma=0;contFantasma<maxFantasmas;contFantasma++){
			ghost=new Fantasma("../Imagenes/fantasma.jpg", energia, g , Panel,mons,vComida,vGhost,1000);
			ghost.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
			while(!isPosicionVacia(ghost,vGhost)||(mons.getX()==ghost.getX()&&mons.getY()==ghost.getY())||!isPosicionVacia(ghost,vComida)){
				ghost.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
			}
			vGhost[contFantasma]=ghost;
			vGhost[contFantasma].mostrar(g);
		}

	}
	
	/**
	 * 
	 * Comprobamos si la posición de un objeto del juego esta libre con respecto a un vector de objetos
	 */
	private boolean isPosicionVacia(Personaje pers, Personaje [] vector) {
		boolean vacio=true;
		int tamano=vector.length;
		
		for(int i=0; i<tamano && vacio==true; i=i+1) {
			if(null !=vector[i]) {
				if(pers.getX()==vector[i].getX() && pers.getY()==vector[i].getY()) {
					vacio=false;
				}
			}
		}
		return vacio;
		
	}
	
	
	private void AumentarEnergia(Personaje pers,Personaje [] vector) {
		boolean vacio=true;
		int tamano=vector.length;
		int i;
		for(i=0; i<tamano && vacio==true; i=i+1) {
			if(null !=vector[i]) {
				if(pers.getX()==vector[i].getX() && pers.getY()==vector[i].getY()) {
					vacio=false;
					Comida comida=new Comida("../Imagenes/Hamburguesa.jpg");
					do{
						comida.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
					}while(!isPosicionVacia(comida,vComida)&&!isPosicionVacia(comida,vGhost)&&(mons.getX()==comida.getX()&&mons.getY()==comida.getY()));
					vector[i]=comida;
					for(int j=0; j<maxComida; j++) {
						vector[j].mostrar(g);
					}
					Random r=new Random();
					int e=r.nextInt(10)+1;
					energia.setValue((Integer)energia.getValue()+e);
					if((int) energia.getValue()>100)
						energia.setValue(100);
				}
			}
			
		}
		return;
	}

/**
 * 
 */
private void botonEmpezar() {
	lblUsuario.setText("Usuario: " + user.CualesmiUsuario());
	/*Si no es la primera vez que empezamos la partida debemos borrar todos los personajes*/
	if(mons!=null) {
		for(int i=0; i<maxFantasmas; i=i+1) {
			vGhost[i].ocultar(g, Panel.getBackground());
			vGhost[i]=null;
		}
		for(int i=0; i<maxComida; i=i+1) {
			vComida[i].ocultar(g,Panel.getBackground());
			vComida[i]=null;
		}
		mons.ocultar(g, Panel.getBackground());
		mons=null;
	}
	energia.setValue(10);
	puntos.setValue(0);
	gameOver1.setVisible(false);
	inicializarTablero();
	 
	jugarPartida();
}
/**
 * 
 */
private void botonArriba() {
	try {
		energia.setValue(energia.getPreviousValue());
		puntos.setValue(puntos.getNextValue());
		g = Panel.getGraphics();
		mons.ocultar(g, Panel.getBackground());
		mons.moverArriba(0);
		mons.mostrar(g);
		
		if(!isPosicionVacia(mons,vGhost)) {
			energia.setValue(-1);
		}	
		
		if(isPosicionVacia(mons,vComida)==false) {
			AumentarEnergia(mons,vComida);
			
		}
		comprobarFinalPartida();

    } catch (Exception e) {
    	energia.setValue(0);
    	comprobarFinalPartida();
    	
	}
}

/**
 * 
 */
private void botonIzquierda() {
	try {
		energia.setValue(energia.getPreviousValue());
		puntos.setValue(puntos.getNextValue());
		g = Panel.getGraphics();
		mons.ocultar(g, Panel.getBackground());
		mons.moverIzquierda(0);
		mons.mostrar(g);

		if(!isPosicionVacia(mons,vGhost)) {
			energia.setValue(-1);
		}
		
		
		if(isPosicionVacia(mons,vComida)==false) {
			AumentarEnergia(mons,vComida);
			
		}
		comprobarFinalPartida();

	
	} catch (Exception e) {
		energia.setValue(0);
		comprobarFinalPartida();
			           
	}
}

/**
 * 
 */
private void botonDerecha() {
	try {
		energia.setValue(energia.getPreviousValue());
		puntos.setValue(puntos.getNextValue());
		g = Panel.getGraphics();
		mons.ocultar(g, Panel.getBackground());
		mons.moverDerecha(Panel.getWidth());
		mons.mostrar(g);
		if(!isPosicionVacia(mons,vGhost)) {
			energia.setValue(-1);
		}
		
		if(isPosicionVacia(mons,vComida)==false) {
			AumentarEnergia(mons,vComida);
			
		}
		comprobarFinalPartida();

	
	} catch (Exception e) {
		energia.setValue(0);
		comprobarFinalPartida();
			           
	}
}

/**
 * 
 */
private void botonAbajo() {
	try {
		energia.setValue(energia.getPreviousValue());
		puntos.setValue(puntos.getNextValue());
		g = Panel.getGraphics();
		mons.ocultar(g, Panel.getBackground());
		mons.moverAbajo(Panel.getHeight());
		mons.mostrar(g);
		if(!isPosicionVacia(mons,vGhost)) {
			energia.setValue(-1);
		}
		
		if(isPosicionVacia(mons,vComida)==false) {
			AumentarEnergia(mons,vComida);
			
		}
		comprobarFinalPartida();
						
	} catch (Exception e) {
		energia.setValue(0);
		comprobarFinalPartida();
		}
		
}
/**
 * 
 */
private void botonHiperespacio() {
	try {
		energia.setValue(energia.getPreviousValue());
		puntos.setValue(puntos.getNextValue());
		g = Panel.getGraphics();
		mons.ocultar(g, Panel.getBackground());
		mons.ColocarAleatorio(Panel.getWidth(),Panel.getHeight());
		mons.mostrar(g);
		if(!isPosicionVacia(mons,vGhost)) {
			energia.setValue(-1);
		}
		
		if(isPosicionVacia(mons,vComida)==false) {
			AumentarEnergia(mons,vComida);
			
		}
		comprobarFinalPartida();
		
		
    } catch (Exception e) {
    	energia.setValue(0);
    	comprobarFinalPartida();
    		           
    }
}
   private void jugarPartida(){
	   partidaIniciada=true;
	   if (partidaIniciada){
//		 /**Acciones a llevar a cabo cada turno*/
			btnEmpezar.setEnabled(false);
		    btnArriba.setEnabled(true);
			btnAbajo.setEnabled(true);
			btnIzquierda.setEnabled(true);
			btnDerecha.setEnabled(true);
			btnHiperespacio.setEnabled(true);			
	    }
      }


   public void comprobarFinalPartida(){
	   if((int) energia.getValue() <= 0){
		   partidaIniciada=false;
		   gameOver1.setBounds(50, 50, 450, 350);
		   gameOver1.setVisible(true);
		   if(gameOver1.isVisible()) {
			    btnEmpezar.setEnabled(true);
				btnArriba.setEnabled(false);
				btnAbajo.setEnabled(false);
				btnIzquierda.setEnabled(false);
				btnDerecha.setEnabled(false);
				btnHiperespacio.setEnabled(false);
			    
		   }
	   }
	   
   }
}