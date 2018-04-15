package trogol;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class Info extends JFrame{

	private JFrame frame;
	private final JLabel lblInformacion = new JLabel("Informaci\u00F3n");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Info window = new Info();
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
	public Info() {
		getContentPane().setLayout(null);
		lblInformacion.setHorizontalAlignment(SwingConstants.CENTER);
		lblInformacion.setForeground(Color.RED);
		lblInformacion.setFont(new Font("Arial", Font.BOLD, 21));
		lblInformacion.setBounds(113, 10, 190, 36);
		getContentPane().add(lblInformacion);
		
		JLabel lblAutorJorgeNozal = new JLabel("Autor: Jorge Nozal Mart\u00EDn");
		lblAutorJorgeNozal.setFont(new Font("Arial", Font.PLAIN, 15));
		lblAutorJorgeNozal.setBounds(33, 83, 190, 26);
		getContentPane().add(lblAutorJorgeNozal);
		
		JLabel lblVersin = new JLabel("Versi\u00F3n: 3.0");
		lblVersin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblVersin.setBounds(33, 119, 190, 26);
		getContentPane().add(lblVersin);
		
		JLabel lblPrcticaTrogolsDesarrollada = new JLabel("<html>Pr\u00E1ctica TROGOLS desarrollada para el curso de perfeccionamiento<br>JAVA, impartido en la Universidad de Extremadura<html>");
		lblPrcticaTrogolsDesarrollada.setFont(new Font("Arial", Font.PLAIN, 15));
		lblPrcticaTrogolsDesarrollada.setBounds(33, 145, 497, 53);
		getContentPane().add(lblPrcticaTrogolsDesarrollada);
		
		JLabel lblFechaMarzo = new JLabel("Fecha: Abril 2018");
		lblFechaMarzo.setFont(new Font("Arial", Font.PLAIN, 15));
		lblFechaMarzo.setBounds(33, 215, 190, 26);
		getContentPane().add(lblFechaMarzo);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
