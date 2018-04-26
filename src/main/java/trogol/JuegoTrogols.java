package trogol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.SwingConstants;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SpinnerNumberModel;

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
	private JButton btnEmpezar;
	public void setUsuario(Usuario Usuario1) {
		user = Usuario1;
	}
	private int maxMonstruos=1;
	public int maxFantasmas=4;
	public int maxComida=5;
	private JSpinner Puntos;
	private JSpinner Energía;
	public Personaje [] vGhost= new Personaje[maxFantasmas];
	public Personaje [] vComida= new Personaje[maxComida];
	private Personaje mons;
	
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

		btnEmpezar = new JButton("Empezar");
		btnEmpezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				lblUsuario.setText("Usuario: " + user.CualesmiUsuario());
				if(mons!=null) {
					for(int i=0; i<maxFantasmas; i=i+1) {
						vGhost[i].Ocultar(g, Panel.getBackground());
						vGhost[i]=null;
					}
					for(int i=0; i<maxComida; i=i+1) {
						vComida[i].Ocultar(g,Panel.getBackground());
						vComida[i]=null;
					}
					mons.Ocultar(g, Panel.getBackground());
					mons=null;
				}
				Energía.setValue(10);
				Puntos.setValue(0);
				gameOver1.setVisible(false);
				InicializarTablero();
				
				
				
					
					
			}

		});
		btnEmpezar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEmpezar.setBounds(516, 40, 99, 30);
		getContentPane().add(btnEmpezar);

		JButton btnInfo = new JButton("Info");
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Info1.setBounds(516, 40, 550, 350);
				Info1.setVisible(true);
			}
		});
		btnInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInfo.setBounds(516, 80, 99, 30);
		getContentPane().add(btnInfo);

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

		Puntos = new JSpinner();
		Puntos.setModel(new SpinnerNumberModel(0, null, null, 1));
		Puntos.setEnabled(false);
		Puntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Puntos.setBounds(96, 49, 66, 33);
		panel_1.add(Puntos);

		Energía = new JSpinner();
		Energía.setEnabled(false);
		Energía.setModel(new SpinnerNumberModel(10, 0, 100, 1));
		Energía.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Energía.setBounds(96, 106, 66, 33);
		panel_1.add(Energía);

		JButton btnArriba = new JButton("Arriba");
		btnArriba.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					Energía.setValue(Energía.getPreviousValue());
					Puntos.setValue(Puntos.getNextValue());
					g = Panel.getGraphics();
					mons.Ocultar(g, Panel.getBackground());
					mons.moverArriba(0);
					mons.Mostrar(g);
					for(int i=0; i<maxFantasmas; i=i+1) {
						if(vGhost[i].getX()==mons.getX()&&vGhost[i].getY()==mons.getY()) {
							Energía.setValue(-1);
						}
						int x=vGhost[i].getX();
						int y=vGhost[i].getY();
						((Fantasma)vGhost[i]).run();
						
						if(IsPosicionVacia(vGhost[i],vComida)==false) {
							vGhost[i].setX(x);
							vGhost[i].setY(y);
							vGhost[i].Mostrar(g);
							
						}
						
						for(int j=0; j<maxFantasmas; j=j+1) {
							if(i!=j&&vGhost[i].getX()==vGhost[j].getX()&&vGhost[i].getY()==vGhost[j].getY()) {
								vGhost[i].setX(x);
								vGhost[i].setY(y);
								vGhost[i].Mostrar(g);
							}
						}
					}
						
					
					if(IsPosicionVacia(mons,vComida)==false) {
						AumentarEnergia(mons,vComida);
						
					}
					for(int j=0;j<maxComida; j=j+1){
						
						vComida[j].Mostrar(g);
						mons.Mostrar(g);
					}
					
					if(IsPosicionVacia(mons,vGhost)==false) {
						Energía.setValue(-1);
					}
					for(int i=0; i<maxFantasmas; i=i+1) {
						vGhost[i].Mostrar(g);
					}
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	gameOver1.setBounds(50, 50, 450, 350);
					gameOver1.setVisible(true);
				}							

			}
		});
		btnArriba.setBounds(554, 352, 85, 21);
		getContentPane().add(btnArriba);

		JButton btnIzquierda = new JButton("Izquierda");
		btnIzquierda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Energía.setValue(Energía.getPreviousValue());
					Puntos.setValue(Puntos.getNextValue());
					g = Panel.getGraphics();
					mons.Ocultar(g, Panel.getBackground());
					mons.moverIzquierda(0);
					mons.Mostrar(g);
					for(int i=0; i<maxFantasmas; i=i+1) {
						if(vGhost[i].getX()==mons.getX()&&vGhost[i].getY()==mons.getY()) {
							Energía.setValue(-1);
						}
						int x=vGhost[i].getX();
						int y=vGhost[i].getY();
						((Fantasma)vGhost[i]).run();
						
						if(IsPosicionVacia(vGhost[i],vComida)==false) {
							vGhost[i].setX(x);
							vGhost[i].setY(y);
							vGhost[i].Mostrar(g);
							
						}
						for(int j=0; j<maxFantasmas; j=j+1) {
							if(i!=j&&vGhost[i].getX()==vGhost[j].getX()&&vGhost[i].getY()==vGhost[j].getY()) {
								vGhost[i].setX(x);
								vGhost[i].setY(y);
								vGhost[i].Mostrar(g);
							}
						}
						
					}
					
					if(IsPosicionVacia(mons,vComida)==false) {
						AumentarEnergia(mons,vComida);
						
					}
					for(int j=0;j<maxComida; j=j+1){
						
						vComida[j].Mostrar(g);
						mons.Mostrar(g);
					}
					if(IsPosicionVacia(mons,vGhost)==false) {
						Energía.setValue(-1);
					}
					for(int i=0; i<maxFantasmas; i=i+1) {
						vGhost[i].Mostrar(g);
					}
				
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	gameOver1.setBounds(50, 50, 450, 350);
					gameOver1.setVisible(true);		           
		        }			
			}
		});
		btnIzquierda.setBounds(491, 383, 99, 21);
		getContentPane().add(btnIzquierda);

		JButton btnDerecha = new JButton("Derecha");
		btnDerecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Energía.setValue(Energía.getPreviousValue());
					Puntos.setValue(Puntos.getNextValue());
					g = Panel.getGraphics();
					mons.Ocultar(g, Panel.getBackground());
					mons.moverDerecha(Panel.getWidth());
					mons.Mostrar(g);
					for(int i=0; i<maxFantasmas; i=i+1) {
						if(vGhost[i].getX()==mons.getX()&&vGhost[i].getY()==mons.getY()) {
							Energía.setValue(-1);
						}
						int x=vGhost[i].getX();
						int y=vGhost[i].getY();
						((Fantasma)vGhost[i]).run();
						
						if(IsPosicionVacia(vGhost[i],vComida)==false) {
							vGhost[i].setX(x);
							vGhost[i].setY(y);
							vGhost[i].Mostrar(g);
							
						}
						for(int j=0; j<maxFantasmas; j=j+1) {
							if(i!=j&&vGhost[i].getX()==vGhost[j].getX()&&vGhost[i].getY()==vGhost[j].getY()) {
								vGhost[i].setX(x);
								vGhost[i].setY(y);
								vGhost[i].Mostrar(g);
							}
						}
					}
					if(IsPosicionVacia(mons,vComida)==false) {
						AumentarEnergia(mons,vComida);
						
					}
					for(int j=0;j<maxComida; j=j+1){
						
						vComida[j].Mostrar(g);
						mons.Mostrar(g);
					}
					if(IsPosicionVacia(mons,vGhost)==false) {
						Energía.setValue(-1);
					}
					for(int i=0; i<maxFantasmas; i=i+1) {
						vGhost[i].Mostrar(g);
					}
				
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	gameOver1.setBounds(50, 50, 450, 350);
					gameOver1.setVisible(true);		           
		        }			
			}
		});
		btnDerecha.setBounds(607, 383, 91, 21);
		getContentPane().add(btnDerecha);

		JButton btnAbajo = new JButton("Abajo");
		btnAbajo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Energía.setValue(Energía.getPreviousValue());
					Puntos.setValue(Puntos.getNextValue());
					g = Panel.getGraphics();
					mons.Ocultar(g, Panel.getBackground());
					mons.moverAbajo(Panel.getHeight());
					mons.Mostrar(g);
					for(int i=0; i<maxFantasmas; i=i+1) {
						if(vGhost[i].getX()==mons.getX()&&vGhost[i].getY()==mons.getY()) {
							Energía.setValue(-1);
						}
						int x=vGhost[i].getX();
						int y=vGhost[i].getY();
						((Fantasma)vGhost[i]).run();
						
						if(IsPosicionVacia(vGhost[i],vComida)==false) {
							vGhost[i].setX(x);
							vGhost[i].setY(y);
							vGhost[i].Mostrar(g);
							
						}
						for(int j=0; j<maxFantasmas; j=j+1) {
							if(i!=j&&vGhost[i].getX()==vGhost[j].getX()&&vGhost[i].getY()==vGhost[j].getY()) {
								vGhost[i].setX(x);
								vGhost[i].setY(y);
								vGhost[i].Mostrar(g);
							}
						}
						
					}
					
					if(IsPosicionVacia(mons,vComida)==false) {
						AumentarEnergia(mons,vComida);
						
					}
					for(int j=0;j<maxComida; j=j+1){
						
						vComida[j].Mostrar(g);
						mons.Mostrar(g);
					}
					if(IsPosicionVacia(mons,vGhost)==false) {
						Energía.setValue(-1);
					}
					for(int i=0; i<maxFantasmas; i=i+1) {
						vGhost[i].Mostrar(g);
					}
									
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	gameOver1.setBounds(50, 50, 450, 350);
					gameOver1.setVisible(true);		           
		        }			
			}
		});
		btnAbajo.setBounds(554, 414, 85, 21);
		getContentPane().add(btnAbajo);
		
		JButton btnHiperespacio = new JButton("Hiperespacio");
		btnHiperespacio.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				try {
					Energía.setValue(Energía.getPreviousValue());
					Puntos.setValue(Puntos.getNextValue());
					g = Panel.getGraphics();
					mons.Ocultar(g, Panel.getBackground());
					mons.ColocarAleatorio(Panel.getWidth(),Panel.getHeight());
					mons.Mostrar(g);
					for(int i=0; i<maxFantasmas; i=i+1) {
						if(vGhost[i].getX()==mons.getX()&&vGhost[i].getY()==mons.getY()) {
							Energía.setValue(-1);
						}
						int x=vGhost[i].getX();
						int y=vGhost[i].getY();
						((Fantasma)vGhost[i]).run();
						
						if(IsPosicionVacia(vGhost[i],vComida)==false) {
							vGhost[i].setX(x);
							vGhost[i].setY(y);
							vGhost[i].Mostrar(g);
							
						}
						for(int j=0; j<maxFantasmas; j=j+1) {
							if(i!=j&&vGhost[i].getX()==vGhost[j].getX()&&vGhost[i].getY()==vGhost[j].getY()) {
								vGhost[i].setX(x);
								vGhost[i].setY(y);
								vGhost[i].Mostrar(g);
							}
						}
					}
					
					if(IsPosicionVacia(mons,vComida)==false) {
						AumentarEnergia(mons,vComida);
						
					}
					for(int j=0;j<maxComida; j=j+1){
					
						vComida[j].Mostrar(g);
						mons.Mostrar(g);
					}
					if(IsPosicionVacia(mons,vGhost)==false) {
						Energía.setValue(-1);
					}
					for(int i=0; i<maxFantasmas; i=i+1) {
						vGhost[i].Mostrar(g);
					}
									
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	gameOver1.setBounds(50, 50, 450, 350);
					gameOver1.setVisible(true);		           
		        }			
			}
		});
		btnHiperespacio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnHiperespacio.setBounds(516, 445, 172, 21);
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
	private void InicializarTablero() {
		g=Panel.getGraphics();
		Fantasma ghost=new Fantasma("../Imagenes/fantasma.jpg", Energía, g , Panel);
		int contFantasma=0;
		do {
			ghost.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
			if(IsPosicionVacia(ghost,vGhost)){
				vGhost[contFantasma]=ghost;
				vGhost[contFantasma].Mostrar(g);
				contFantasma=contFantasma+1;
				ghost=new Fantasma("../Imagenes/fantasma.jpg", Energía, g , Panel);
			}
		}while(contFantasma<maxFantasmas);
		
		Comida comida= new Comida("../Imagenes/Hamburguesa.jpg");
		int contComida=0;
			do {
				comida.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
				if(IsPosicionVacia(comida,vGhost)&&IsPosicionVacia(comida,vComida)){
					vComida[contComida]=comida;
					vComida[contComida].Mostrar(g);
					contComida=contComida+1;
					comida= new Comida("../Imagenes/Hamburguesa.jpg");
				}
		}while(contComida<maxComida);
			

		mons= new Personaje("../Imagenes/monster.jpg");
		int contMonstruo=0;
		do{
			mons.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
			if(IsPosicionVacia(mons,vComida)&&IsPosicionVacia(mons,vGhost)){
				mons.Mostrar(g);
				contMonstruo=contMonstruo+1;
			}
		}while(contMonstruo<maxMonstruos);
		
		
	}
	private boolean IsPosicionVacia(Personaje pers, Personaje [] vector) {
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
					do{
						vector[i].ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
					}while(IsPosicionVacia(vector[i],vector));
					vector[i].Mostrar(g);
					Random r=new Random();
					int e=r.nextInt(10)+1;
					Energía.setValue((Integer)Energía.getValue()+e);
				}
			}
			
		}
		return;
	}
	
	
}