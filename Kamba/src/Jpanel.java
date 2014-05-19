import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import javax.swing.JProgressBar;

@SuppressWarnings("serial")
public class Jpanel extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox_1;

	private void clean() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
		comboBox.setSelectedIndex(0);
		comboBox_1.setSelectedIndex(0);
		textField_3.setText("");
		textField_4.setText("");
	}

	public Jpanel() {
		setTitle("Kamban");
		getContentPane().setBackground(Color.GRAY);
		getContentPane().setLayout(null);

		JLabel lblTtulo = new JLabel("T\u00EDtulo:");
		lblTtulo.setBounds(29, 41, 55, 16);
		getContentPane().add(lblTtulo);

		textField = new JTextField();
		textField.setBounds(112, 39, 198, 20);
		getContentPane().add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Descripci\u00F3n:");
		lblNewLabel.setBounds(29, 73, 71, 16);
		getContentPane().add(lblNewLabel);

		textField_1 = new JTextField();
		textField_1.setBounds(112, 73, 198, 136);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setBounds(29, 214, 55, 16);
		getContentPane().add(lblEstado);

		JLabel lblCategora = new JLabel("Categor\u00EDa:");
		lblCategora.setBounds(29, 251, 71, 16);
		getContentPane().add(lblCategora);

		JLabel lblPrioridad = new JLabel("Prioridad:");
		lblPrioridad.setBounds(29, 278, 71, 16);
		getContentPane().add(lblPrioridad);

		JLabel lblPropietario = new JLabel("Propietario:");
		lblPropietario.setBounds(29, 305, 71, 16);
		getContentPane().add(lblPropietario);

		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(29, 332, 55, 16);
		getContentPane().add(lblFecha);

		textField_2 = new JTextField();
		textField_2.setBounds(112, 249, 198, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(112, 303, 198, 20);
		getContentPane().add(textField_3);



		JButton btnNewButton = new JButton("Agregar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showConfirmDialog(null, "Desea agregar los datos?");
				String titulo = textField.getText();
				if("".equalsIgnoreCase(titulo.trim())){
					JOptionPane.showMessageDialog(null, "Titulo vacio!");
				}
				Task tarea = new Task(titulo);
				tarea.setDescription(textField_1.getText());
				String descripcion = textField_1.getText();
				if("".equalsIgnoreCase(descripcion.trim())){
					JOptionPane.showMessageDialog(null, "Descripcion vacio!!");
				}
				String Cate = textField_2.getText();
				if("".equalsIgnoreCase(Cate.trim())){
					JOptionPane.showMessageDialog(null, "Categoria vacio!!");
				}
				Category c = new Category();
				c.setDescription(textField_2.getText());
				tarea.setCategory(c);
				tarea.setState((State)comboBox.getSelectedItem());
				tarea.setPriority((short)comboBox.getSelectedItem());
				tarea.setOwner(textField_3.getText());
				String Dueno = textField_3.getText();
				if("".equalsIgnoreCase(Dueno.trim())){
					JOptionPane.showMessageDialog(null, "Dueño vacio!!");
				}
				Date date = new Date();
				tarea.setCreateDate(date);
				Calendar cal = Calendar.getInstance();  
				cal.setTime(date);  
				int foo = Integer.parseInt(textField_4.getText());
				cal.add(Calendar.DATE, foo); // add number of days
				date = cal.getTime();
				tarea.setDueDate(date);
				Program.dashboard.add(tarea);
				clean();
			}
		});
		btnNewButton.setBounds(29, 369, 103, 41);
		getContentPane().add(btnNewButton);

		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
		 			public void actionPerformed(ActionEvent e) {
		 				if(JOptionPane.showConfirmDialog(Jpanel.this, "Decea Cerrar la Ventana", "Cerrar", JOptionPane.YES_NO_OPTION)==JOptionPane.OK_OPTION){
		 					dispose();
		 				System.exit(1);}
		 			}
		 	});
		btnCancelar.setBounds(174, 369, 103, 41);
		getContentPane().add(btnCancelar);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"BACKLOG", "DO_TO", "IN_PROGRESS", "DONE"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(112, 220, 198, 25);
		getContentPane().add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Alta ", "Media ", "Baja "}));
		comboBox_1.setBounds(112, 274, 198, 25);
		getContentPane().add(comboBox_1);

		textField_4 = new JTextField();
		textField_4.setBounds(112, 334, 198, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.RED);
		progressBar.setBounds(85, 11, 146, 14);
		getContentPane().add(progressBar);
	for(int x=0;x<100;x++)
		progressBar.setValue(x);
				



	}
		private class CerrarVentana3 implements ActionListener{
			public void actionPerformed(ActionEvent e){
				dispose();
			}
		}
	public static void main(String[] args){
		JFrame labelFrame2=new Jpanel();
		labelFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		labelFrame2.setSize(350,460);
		labelFrame2.setVisible(true);
	}
}


