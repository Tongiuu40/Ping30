import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JTextField;


public class EssayFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EssayFrame window = new EssayFrame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the application.
	 */
	public EssayFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 656, 415);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 640, 373);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("prendre photo");
		btnNewButton.setBounds(22, 59, 103, 25);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("reprendre photo");
		btnNewButton_1.setBounds(22, 151, 103, 25);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("comparation");
		btnNewButton_2.setBounds(22, 249, 103, 25);
		panel.add(btnNewButton_2);
		
		textField = new JTextField();
		textField.setBounds(155, 11, 473, 351);
		panel.add(textField);
		textField.setColumns(10);
	}
}
