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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 *En esta clase se produce el desarrollo del juego trogols
 */
public class JuegoTrogols extends JFrame{

/**
 *  No sé que poner xD
 */
	private JFrame frame;
	private JPanel panel_1;
//	private Info Info1=new Info();
	private JLabel lblUsuario;
	private JPanel Panel;
	private Graphics g;
    private Graphics f;
	int x1=10,y1=10,ancho1=50,alto1=50;
//	private Usuario user;
	private JButton btnEmpezar;
	private JButton btnArriba;
//	public void setUsuario(Usuario Usuario1) {
//			user=Usuario1;
//	}
//	private Imagen img;
	
	

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
		lblUsuario.setBounds(126, 84, 205, 26);
		getContentPane().add(lblUsuario);
		
		btnEmpezar = new JButton("Empezar");
		btnEmpezar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				lblUsuario.setText("Usuario: "+user.CualesmiUsuario());
//				Pintar();
								
			}
		});
		btnEmpezar.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEmpezar.setBounds(516, 40, 99, 30);
		getContentPane().add(btnEmpezar);
		
		JButton btnInfo = new JButton("Info");
		btnInfo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				Info1.setBounds(516,40,550,350);
//				Info1.setVisible(true);
			}
		});
		btnInfo.setFont(new Font("Arial", Font.PLAIN, 15));
		btnInfo.setBounds(516, 80, 99, 30);
		getContentPane().add(btnInfo);
		
		Panel = new JPanel();
		Panel.setBackground(new Color(255, 255, 255));
		Panel.setBounds(34, 139, 400, 320);
		getContentPane().add(Panel);
		
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
		
		JSpinner Puntos = new JSpinner();
		Puntos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Puntos.setBounds(96, 49, 36, 33);
		panel_1.add(Puntos);
		
		JSpinner Energía = new JSpinner();
		Energía.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Energía.setBounds(96, 106, 36, 33);
		panel_1.add(Energía);
		
		btnArriba = new JButton("Arriba");
		btnArriba.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnArriba.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				moverArriba();
				
			}
		});
		btnArriba.setBounds(530, 352, 85, 21);
		getContentPane().add(btnArriba);
		
		JButton btnIzquierda = new JButton("Izquierda");
		btnIzquierda.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnIzquierda.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				moverIzq();
			}
		});
		btnIzquierda.setBounds(472, 383, 99, 21);
		getContentPane().add(btnIzquierda);
		
		JButton btnDerecha = new JButton("Derecha");
		btnDerecha.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDerecha.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
//				moverDcha();
			}
		});
		btnDerecha.setBounds(581, 383, 91, 21);
		getContentPane().add(btnDerecha);
		
		JButton btnAbajo = new JButton("Abajo");
		btnAbajo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbajo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				moverAbajo();
			}
		});
		btnAbajo.setBounds(530, 414, 85, 21);
		getContentPane().add(btnAbajo);
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
	

//	public Imagen Pintar() {
//	
//		Imagen I=new Imagen("Imagenes/fantasma.jpg");
//		g=Panel.getGraphics();
//		I.setX(x1);
//		I.setY(y1);
//		I.setAncho(ancho1);
//		I.setAlto(alto1);
//		x1=I.getX();
//		y1=I.getY();
//		ancho1=I.getAncho();
//		alto1=I.getAlto();
//		
//		I.Mostrar(g);
//		
//		return I;
//	}
//	private void moverArriba() {
//		Figura F=new Figura(x1,y1,ancho1,alto1);
//		f=Panel.getGraphics();
//		F.Ocultar(f,Panel.getBackground());
//	    y1=y1-10;
//	    Pintar();
//   }
//	private void moverAbajo() {
//		Figura F=new Figura(x1,y1,ancho1,alto1);
//		f=Panel.getGraphics();
//		F.Ocultar(f,Panel.getBackground());
//	    y1=y1+10;
//	    Pintar();
// }
//	private void moverIzq() {
//		Figura F=new Figura(x1,y1,ancho1,alto1);
//		f=Panel.getGraphics();
//		F.Ocultar(f,Panel.getBackground());
//	    x1=x1-10;
//	    Pintar();
// }
//	private void moverDcha() {
//		Figura F=new Figura(x1,y1,ancho1,alto1);
//		f=Panel.getGraphics();
//		F.Ocultar(f,Panel.getBackground());
//	    x1=x1+10;
//	    Pintar();
// }
	
}
