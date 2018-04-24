package trogol;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GameOver extends JFrame{

	private JFrame frame;
	private final JLabel lblGameOver = new JLabel("GAME OVER");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GameOver window = new GameOver();
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
	public GameOver() {
		getContentPane().setBackground(Color.RED);
		getContentPane().setLayout(null);
		lblGameOver.setHorizontalAlignment(SwingConstants.CENTER);
		lblGameOver.setForeground(Color.BLACK);
		lblGameOver.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblGameOver.setBounds(60, 71, 335, 99);
		getContentPane().add(lblGameOver);
		
		JLabel lblTryAgain = new JLabel("TRY AGAIN");
		lblTryAgain.setHorizontalAlignment(SwingConstants.CENTER);
		lblTryAgain.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 20));
		lblTryAgain.setBounds(117, 210, 190, 26);
		getContentPane().add(lblTryAgain);
		
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(50, 50, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
