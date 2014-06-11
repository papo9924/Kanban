import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JProgressBar;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

@SuppressWarnings("serial")
public class Jpanel extends JFrame {

	private JLayeredPane contentPane;
	private JTextField titulo;
	private JTextField descripcion;
	private JTextField categoria;
	private JTextField usuario;
	private JTextField date;
	private JComboBox<State> Estado;//<State> hace referencia a la clase State
	private JComboBox Prioridad;
	JButton Aceptar = new JButton("Add");
	JButton Cancel = new JButton("Cancel");

	public Jpanel() {
		setForeground(Color.GRAY);
		setTitle("Kamba-GRM");
		initialize();
		addListeners();
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jpanel frame = new Jpanel();
					frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void clean() {
		titulo.setText("");
		descripcion.setText("");
		Estado.setSelectedIndex(0);
		categoria.setText("");
		usuario.setText("");
		date.setText(new Date().toString());
	}

	private  void isEmpty(String message, JTextComponent text)
		throws EmptyComponentException{
			if("".equals(text.getText().trim())){
				throw new EmptyComponentException(message, text);
			}
		}


	private void verify()throws Exception{
		isEmpty("Tittle field is empty", titulo);
		isEmpty("Description fields is emptu", descripcion);
		isEmpty("Category field is empty", categoria);
		isEmpty("User field is empty", usuario);
		isEmpty("Due Date field is empty",date);
	}


	public boolean save(){
		Task task=new Task();
		task.setTitle(titulo.getText());
		task.setDescription(descripcion.getText());
		task.setState(Estado.getItemAt(Estado.getSelectedIndex()));
		task.setCategory(new Category(categoria.getText()));
		task.setPriority((short)Prioridad.getSelectedItem());
		task.setOwner(usuario.getText());
		SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy");
		System.out.println(task.getTitle());
		try {
		 task.setDueDate(formatter.parse(date.getText()));
		} catch (ParseException e) {
			return false;
		}
		task.setCreateDate(new Date());

		return Program.dashboard.add(task);
	}

	private class TaskAction implements ActionListener {
		@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if (source instanceof JButton) {
			if (Aceptar == source) {
				try{
					verify();
					if (JOptionPane.YES_OPTION == JOptionPane.showConfirmDialog(null,"Quieres agregar esta tarea?","Confirmacion",
									JOptionPane.YES_NO_OPTION,
									JOptionPane.INFORMATION_MESSAGE)) {
						if (save()) {
							JOptionPane.showMessageDialog(null,"Se ha agregado");
							clean();
						}
					}
				}catch(EmptyComponentException ex){
					JOptionPane.showMessageDialog(null, ex.getMessage(),"Validation error", JOptionPane.ERROR_MESSAGE);
					ex.getComponent().requestFocus();


			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, ex.getMessage(),"Validation error", JOptionPane.ERROR_MESSAGE);
			}

			} else if (Cancel == source) {
				dispose();
			}
		}
	}
}

	public void addListeners() {
		TaskAction ta = new TaskAction();
		Aceptar.addActionListener(ta);
		Cancel.addActionListener(ta);
	}

	public void initialize() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 490, 516);
		contentPane = new JLayeredPane();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabelTITLE = new JLabel("Kamba-GRM");
		lblNewLabelTITLE.setBounds(133, 11, 263, 37);
		contentPane.add(lblNewLabelTITLE);

		titulo = new JTextField();
		titulo.setBounds(166, 69, 265, 20);
		contentPane.add(titulo);
		titulo.setColumns(10);

		descripcion = new JTextField();
		descripcion.setColumns(10);
		descripcion.setBounds(166, 119, 265, 53);
		contentPane.add(descripcion);

		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(59, 117, 90, 22);
		contentPane.add(lblDescription);

		JLabel lblTitle = new JLabel("Title");
		lblTitle.setBounds(59, 66, 37, 24);
		contentPane.add(lblTitle);

		JLabel lblState = new JLabel("State");
		lblState.setBounds(59, 198, 42, 22);
		contentPane.add(lblState);

		JLabel lblCategory = new JLabel("Category");
		lblCategory.setBounds(59, 252, 73, 22);
		contentPane.add(lblCategory);

		JLabel lblPriority = new JLabel("Priority");
		lblPriority.setBounds(59, 312, 56, 22);
		contentPane.add(lblPriority);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(59, 357, 38, 22);
		contentPane.add(lblUser);

		JLabel lblDueDate = new JLabel("Due Date");
		lblDueDate.setBounds(59, 403, 76, 22);
		contentPane.add(lblDueDate);

		categoria = new JTextField();
		categoria.setColumns(10);
		categoria.setBounds(166, 254, 265, 20);
		contentPane.add(categoria);

		usuario = new JTextField();
		usuario.setColumns(10);
		usuario.setBounds(166, 359, 265, 20);
		contentPane.add(usuario);

		date = new JTextField();
		date.setColumns(10);
		date.setBounds(166, 405, 265, 20);
		contentPane.add(date);

		Estado = new JComboBox<State>(State.values());
		//final JComboBox Estado = new JComboBox();
		Estado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String state=(String)Estado.getSelectedItem();
				JOptionPane.showMessageDialog(null,"Has seleccionado el estado: "+state);
			}
		});
		Estado.setModel(new DefaultComboBoxModel(new String[] {"Backlog", "DO TO", "IN PROGRESS", "DONE"}));
				Estado.setBounds(166, 200, 265, 20);
		contentPane.add(Estado);

		Prioridad = new JComboBox();
		//final JComboBox Prioridad = new JComboBox();
		Prioridad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String priority=(String)Prioridad.getSelectedItem();
				JOptionPane.showMessageDialog(null,"Has seleccionado la prioridad: "+priority);
			}
		});
		Prioridad.setModel(new DefaultComboBoxModel(new String[] {"...", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		Prioridad.setBounds(166, 312, 265, 20);
		contentPane.add(Prioridad);

		Aceptar.setBounds(154, 443, 89, 23);
		contentPane.add(Aceptar);

		//JButton Cancel = new JButton("Cancel");
		Cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		}); 
		Cancel.setBounds(253, 443, 89, 23);
		contentPane.add(Cancel);
	}
}

