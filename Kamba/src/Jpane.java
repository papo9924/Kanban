import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;


public class Jpane extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jpane frame = new Jpane();
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
	public Jpane() {
		setBackground(Color.GRAY);
		setTitle("Kamban");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 333, 351);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Button MARICA = new Button("ADD");
		MARICA.setBounds(45, 263, 103, 46);
		contentPane.add(MARICA);
		
		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setBounds(46, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(133, 11, 103, 20);
		contentPane.add(textPane);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(46, 42, 69, 14);
		contentPane.add(lblDescription);
		
		JTextPane textPane_1 = new JTextPane();
		textPane_1.setBounds(133, 42, 129, 62);
		contentPane.add(textPane_1);
		
		JLabel lblNewLabel_1 = new JLabel("State");
		lblNewLabel_1.setBounds(46, 114, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JTextPane textPane_2 = new JTextPane();
		textPane_2.setBounds(133, 139, 103, 20);
		contentPane.add(textPane_2);
		
		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(46, 139, 46, 14);
		contentPane.add(lblCategory);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Alta", "Media ", "Baja"}));
		comboBox.setToolTipText("Alta\r\nMedia\r\nBaja\r\n");
		comboBox.setBounds(133, 115, 103, 20);
		contentPane.add(comboBox);
		
		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(46, 164, 46, 14);
		contentPane.add(lblPriority);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Alta", "Media", "Baja"}));
		comboBox_1.setToolTipText("Alta\r\nMedia\r\nBaja\r\n");
		comboBox_1.setBounds(133, 170, 103, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblOwner = new JLabel("Owner");
		lblOwner.setBounds(46, 199, 46, 14);
		contentPane.add(lblOwner);
		
		JTextPane textPane_3 = new JTextPane();
		textPane_3.setBounds(133, 193, 103, 20);
		contentPane.add(textPane_3);
		
		JLabel lblDuedate = new JLabel("Duedate");
		lblDuedate.setBounds(46, 224, 46, 14);
		contentPane.add(lblDuedate);
		
		JTextPane textPane_4 = new JTextPane();
		textPane_4.setBounds(133, 224, 103, 20);
		contentPane.add(textPane_4);
		
		Button button = new Button("Cancelar");
		button.setActionCommand("Cancel");
		button.setBounds(206, 263, 93, 46);
		contentPane.add(button);
	}
}
