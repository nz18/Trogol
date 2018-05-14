package trogol;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;

/**
 * TODO: Explicar que es esta clase
 * En esta clase se produce el login del jugador, comprobándose que ni usuario ni contraseña estén vacíos
 */
  public class Principal {
 
	/**
	 * Documentar los atributos  
	 * 
	 * La ventana en la que aparece el login es el JFrame.
	 * En Nombre y Password escribimos los datos necesarios para formar un usuario.
	 * Los diferentes JLabel muestran los mensajes de bienvenido o error según los datos de usuario.
	 * Juego1 se hace visible si los datos de usuario son correctos.
	 * Estos datos de usuario son almacenados en la clase Usuario.
	 * 
	 */
	private JFrame frame;
	private JTextField Nombre;
	private JTextField Password;
	private JLabel lblBienvenido;
	private JLabel lblError;
	private JuegoTrogols Juego1=new JuegoTrogols();
	private JLabel lblBienvenido_1;
	private Usuario Usuario;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
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
	public Principal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 10));
		frame.setBounds(100, 100, 500, 320);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTROGOLS = new JLabel("TROGOLS");
		lblTROGOLS.setForeground(Color.RED);
		lblTROGOLS.setFont(new Font("Arial", Font.BOLD, 22));
		lblTROGOLS.setBounds(165, 10, 122, 47);
		frame.getContentPane().add(lblTROGOLS);
		
		JLabel lblAutorJorgeNozal = new JLabel("Autor: Jorge Nozal Mart\u00EDn");
		lblAutorJorgeNozal.setFont(new Font("Arial", Font.ITALIC, 15));
		lblAutorJorgeNozal.setBounds(141, 67, 186, 28);
		frame.getContentPane().add(lblAutorJorgeNozal);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNombre.setBounds(62, 116, 86, 30);
		frame.getContentPane().add(lblNombre);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPassword.setBounds(62, 156, 86, 28);
		frame.getContentPane().add(lblPassword);
		
		Nombre = new JTextField();
		Nombre.setHorizontalAlignment(SwingConstants.CENTER);
		Nombre.setFont(new Font("Arial", Font.PLAIN, 15));
		Nombre.setBounds(151, 116, 202, 30);
		Nombre.setColumns(10);
		frame.getContentPane().add(Nombre);
		
		
		Password = new JTextField();
		Password.setHorizontalAlignment(SwingConstants.CENTER);
		Password.setFont(new Font("Arial", Font.PLAIN, 15));
		Password.setColumns(10);
		Password.setBounds(151, 156, 202, 30);
		frame.getContentPane().add(Password);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				crearUsuario();
				Usuario=crearUsuario();
				if(lblBienvenido.isVisible()==true) {
					Juego1.setSize(800,550);
					Juego1.setUsuario(Usuario);
					Juego1.setVisible(true);
					
				}
				
			}
		});
		btnAceptar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAceptar.setBounds(178, 197, 100, 28);
		frame.getContentPane().add(btnAceptar);
		
		lblBienvenido = new JLabel("");
		lblBienvenido.setForeground(Color.RED);
		lblBienvenido.setFont(new Font("Arial", Font.BOLD, 20));
		lblBienvenido.setBounds(62, 241, 336, 30);
		lblBienvenido.setVisible(false);
		frame.getContentPane().add(lblBienvenido);
		
		lblError = new JLabel("Error, nombre o contrase\u00F1a vac\u00EDos");
		lblError.setFont(new Font("Arial", Font.BOLD, 20));
		lblError.setBounds(62, 232, 336, 47);
		lblError.setVisible(false);
		frame.getContentPane().add(lblError);
		
		lblBienvenido_1 = new JLabel("Bienvenido");
		lblBienvenido_1.setForeground(Color.RED);
		lblBienvenido_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblBienvenido_1.setBounds(62, 243, 202, 28);
		frame.getContentPane().add(lblBienvenido_1);
		
	}
	
	public Usuario crearUsuario() {
				
		if(Nombre.getText().isEmpty()==false&&Password.getText().isEmpty()==false) {
			lblBienvenido.setVisible(true);
			lblBienvenido.setText("Bienvenido, "+Nombre.getText()); 
			lblError.setVisible(false);
			lblBienvenido_1.setVisible(false);
			Usuario U=new Usuario(Nombre.getText(),Password.getText());
			return U;
			} 
		else {
			  lblError.setVisible(true);
			  lblBienvenido.setVisible(false);
			  lblBienvenido_1.setVisible(false);
			  return null;
			  }
		

	}
}
