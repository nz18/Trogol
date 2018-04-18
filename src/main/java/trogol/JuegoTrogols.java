package trogol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

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
	private JLabel lblUsuario;
	private JPanel Panel;
	protected Graphics g;
	protected Graphics f;
	int x1, y1, ancho1, alto1;
	private Usuario user;
	private JButton btnEmpezar;
	public void setUsuario(Usuario Usuario1) {
		user = Usuario1;
	}
	private int maxFantasmas=4;
	private int maxComida=5;
	private int i=0;
	private int j=0;
	private JSpinner Puntos;
	private JSpinner Energía;
	private JLabel GameOver;
	private int [] posGhostX= new int[maxFantasmas];
	private int [] posGhostY= new int[maxFantasmas];
	private int posMonsX;
	private int posMonsY;
	private int [] posComidaX= new int[maxComida];
	private int [] posComidaY= new int[maxComida];
	Boolean comp1=false;
	Boolean comp2=false;

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
				while(i<maxFantasmas) {
					PintarGhost();
				}
				while(i<maxComida) {
					PintarComida();
				}
				while(j<1) {
					PintarMons();
				    j=j+1;
				}
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
		
		GameOver = new JLabel("<html>---- G ----------------<br>-------- A ------------<br>---------- M ---------<br>------------- E -------<br>---- O ----------------<br>-------- V ------------<br>---------- E ----------<br>------------- R -------<html>");
		GameOver.setBounds(87, 10, 234, 300);
		Panel.add(GameOver);
		GameOver.setHorizontalAlignment(SwingConstants.CENTER);
		GameOver.setForeground(Color.RED);
		GameOver.setBackground(Color.WHITE);
		GameOver.setFont(new Font("Arial Black", Font.BOLD, 25));
		GameOver.setVisible(false);

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
		Puntos.setEnabled(false);
		Puntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Puntos.setBounds(96, 49, 36, 33);
		panel_1.add(Puntos);

		Energía = new JSpinner();
		Energía.setEnabled(false);
		Energía.setModel(new SpinnerNumberModel(10, 0, 100, 1));
		Energía.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Energía.setBounds(96, 106, 36, 33);
		panel_1.add(Energía);

		JButton btnArriba = new JButton("Arriba");
		btnArriba.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				try {
					Energía.setValue(Energía.getPreviousValue());
					Puntos.setValue(Puntos.getNextValue());
					f = Panel.getGraphics();
					Personaje mons = new Personaje("../Imagenes/monster.jpg");
					mons.Ocultar(f, Panel.getBackground());
					mons.moverArriba(0);
					PintarMons();
					ComprobarGhost();
					ComprobarComida1();
					Fantasma ghost=new Fantasma("../Imagenes/fantasma.jpg", Energía, g , Panel);
					ghost.run();
									
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	GameOver.setVisible(true);
		           
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
					f = Panel.getGraphics();
					Personaje mons = new Personaje("../Imagenes/monster.jpg");
					mons.Ocultar(f, Panel.getBackground());
					mons.moverIzquierda(0);
					PintarMons();
					ComprobarGhost();
					ComprobarComida1();
					Fantasma ghost=new Fantasma("../Imagenes/fantasma.jpg", Energía, g , Panel);
					ghost.run();
									
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	GameOver.setVisible(true);
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
					f = Panel.getGraphics();
					Personaje mons = new Personaje("../Imagenes/monster.jpg");
					mons.Ocultar(f, Panel.getBackground());
					mons.moverDerecha(Panel.getWidth());
					PintarMons();
					ComprobarGhost();
					ComprobarComida1();
					Fantasma ghost=new Fantasma("../Imagenes/fantasma.jpg", Energía, g , Panel);
					ghost.run();
									
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	GameOver.setVisible(true);
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
					f = Panel.getGraphics();
					Personaje mons = new Personaje("../Imagenes/monster.jpg");
					mons.Ocultar(f, Panel.getBackground());
					mons.moverAbajo(Panel.getHeight());
					PintarMons();
					ComprobarGhost();
					ComprobarComida1();
					Fantasma ghost=new Fantasma("../Imagenes/fantasma.jpg", Energía, g , Panel);
					ghost.run();
									
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	GameOver.setVisible(true);
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
					f = Panel.getGraphics();
					Personaje mons = new Personaje("../Imagenes/monster.jpg");
					mons.Ocultar(f, Panel.getBackground());
					mons.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
					PintarMons();
					ComprobarGhost();
					ComprobarComida1();
					Fantasma ghost=new Fantasma("../Imagenes/fantasma.jpg", Energía, g , Panel);
					ghost.run();
									
		        } catch (Exception e) {
		        	Energía.setValue(0);
		        	GameOver.setVisible(true);
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

	public Fantasma PintarGhost() {


		Fantasma ghost=new Fantasma("../Imagenes/fantasma.jpg", Energía, g , Panel);
		for(i=0; i<maxFantasmas; i=i+1) {
			ghost.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
			g = Panel.getGraphics();
			posGhostX[i]=ghost.getX();
			posGhostY[i]=ghost.getY();
			ghost.Mostrar(g);
		
		}
		return ghost;
	}
	public Personaje PintarMons() {

		Personaje mons= new Personaje("../Imagenes/monster.jpg");
		g = Panel.getGraphics();
		posMonsX=mons.getX();
		posMonsY=mons.getY();
		mons.Mostrar(g);
				
		return mons;
	}
	public Comida PintarComida() {

		Comida comida= new Comida("../Imagenes/Hamburguesa.jpg");
		for(i=0; i<maxComida; i=i+1) {
			comida.ColocarAleatorio(Panel.getWidth(), Panel.getHeight());
			g = Panel.getGraphics();
			posComidaX[i]=comida.getX();
			posComidaY[i]=comida.getY();
			comida.Mostrar(g);
		}
		return comida;
	}
	public void ComprobarGhost() {
		for(i=0; i<maxFantasmas; i=i+1) {
			if(posGhostX[i]==posMonsX&&posGhostY[i]==posMonsY) 
				Energía.setValue(0);
		}
	}
		
	public void ComprobarComida1() {
		for(i=0; i<=maxComida||comp1==true; i=i+1) {
			if(posComidaX[i]==posMonsX&&posComidaY[i]==posMonsY) { 
				comp1=true;
			}else {
				comp1=false;
			}
		}
	}
	public void ComprobarComida2() {
		for(i=0; i<=maxComida||comp2==true; i=i+1) {
			for(j=0; i<=maxFantasmas||comp2==true; j=j+1) {
				if(posComidaX[i]==posMonsX&&posComidaY[i]==posMonsY) { 
				comp1=true;
			}else {
				comp1=false;
				}
			}
		}
	}
}