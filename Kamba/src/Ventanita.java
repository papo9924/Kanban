import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Color;


public class Ventanita extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventanita frame = new Ventanita();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ventanita() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblTitulo = new JLabel("Titulo");
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		
		JLabel lblEstado = new JLabel("Estado");
		
		JLabel lblCategoria = new JLabel("Categoria");
		
		JLabel lblPrioridad = new JLabel("Prioridad");
		
		JLabel lblOwner = new JLabel("Owner");
		
		JLabel lblDuedate = new JLabel("DueDate");
		
		JLabel lblNewLabel = new JLabel("Tareas");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JTextPane textPane = new JTextPane();
		
		JTextPane textPane_1 = new JTextPane();
		
		JTextPane textPane_3 = new JTextPane();
		
		JTextPane textPane_4 = new JTextPane();
		
		JTextPane textPane_5 = new JTextPane();
		
		JTextPane textPane_6 = new JTextPane();
		
		JTextPane textPane_7 = new JTextPane();
		
		JButton btnAceptar = new JButton("Crear Dato");
		
		JButton btnAceptar_1 = new JButton("Aceptar");
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblTitulo)
								.addComponent(lblDescripcion)
								.addComponent(lblEstado)
								.addComponent(lblCategoria)
								.addComponent(lblPrioridad)
								.addComponent(lblOwner)
								.addComponent(lblDuedate))
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(10)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(textPane_6, GroupLayout.DEFAULT_SIZE, 204, Short.MAX_VALUE)
										.addComponent(textPane_7)
										.addComponent(textPane_5)))
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(textPane_4))
									.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
										.addGap(10)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
											.addComponent(textPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
											.addComponent(textPane_3, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 133, GroupLayout.PREFERRED_SIZE)
											.addComponent(textPane_1, Alignment.LEADING))))))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(163)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnAceptar, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
							.addComponent(btnAceptar_1)))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(7)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblTitulo)
						.addComponent(textPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblDescripcion)
						.addComponent(textPane_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblEstado)
						.addComponent(textPane_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblCategoria)
						.addComponent(textPane_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblPrioridad)
						.addComponent(textPane_7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblOwner)
						.addComponent(textPane_6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblDuedate)
						.addComponent(textPane_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnAceptar)
						.addComponent(btnAceptar_1)))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
