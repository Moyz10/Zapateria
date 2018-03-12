package Presentacion;
import java.awt.Choice;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Negocio.ControlLogin;


import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class VistaLogin extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textPassword;
	private ControlLogin control;
	Choice choice = new Choice();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaLogin frame = new VistaLogin();
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
	public VistaLogin() {
		setTitle("Ventana principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblZapateria = new JLabel("Zapateria el Ahorro");
		lblZapateria.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblZapateria.setBounds(159, 10, 192, 19);
		contentPane.add(lblZapateria);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(18, 27, 100, 100);
		contentPane.add(lblIcon);
		ImageIcon imgIcon = new ImageIcon(VistaLogin.class.getResource("/presentacion/userIcon.png"));
		Image user = imgIcon.getImage();
		Image userScaled = user.getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
		imgIcon = new ImageIcon(userScaled);
		lblIcon.setIcon(imgIcon);
	
		
		
		textUser = new JTextField();
		//Agregamos un caretListener para que se actualice el textfield sobre cada entrada.
		
		textUser.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				control.recibeUsuario(textUser.getText());
			}
		});
		textUser.setBounds(131, 147, 214, 26);
		contentPane.add(textUser);
		textUser.setColumns(10);
		
		textPassword = new JPasswordField();
		//Agregamos un caretListener para que se actualice el textfield sobre cada entrada
		textPassword.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent e) {
				control.recibeContraseña(textPassword.getText());
			}
		});
		textPassword.setBounds(131, 197, 214, 26);
		contentPane.add(textPassword);
		textPassword.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(28, 152, 61, 16);
		contentPane.add(lblUsuario);
		
		JLabel lblpass = new JLabel("Contraseña");
		lblpass.setBounds(28, 202, 71, 16);
		contentPane.add(lblpass);
		
		JButton btnIngresar = new JButton("Ingresar");
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Tomamos parámetros para validar.y dependiendo de esto mostramos errores o la ventana siguiente.
				if(choice.getSelectedItem().equals("Vendedor")) {
					control.recibeTipo("Vendedor");
					control.validaingreso();
					
				}else 
					if(choice.getSelectedItem().equals("Selecciona...")){
					JOptionPane.showMessageDialog(null, "Selecciona tipo de ingreso, por favor");
				}else 
					if(choice.getSelectedItem().equals("Administrador")) {
						JOptionPane.showMessageDialog(null, "Ingresaste como: Administrador, bienvenido");
						
					}
				
			}
		});
		btnIngresar.setBounds(327, 243, 117, 29);
		contentPane.add(btnIngresar);
		
		choice.setForeground(Color.BLACK);
		choice.setBounds(200, 74, 130, 20);
		contentPane.add(choice);
		choice.addItem("Selecciona...");
		choice.addItem("Vendedor");
		choice.addItem("Administrador");
		
		JLabel lblCargo = new JLabel("Cargo");
		lblCargo.setBounds(159, 74, 61, 16);
		contentPane.add(lblCargo);
	}
	//Instanciamos control a nuestra vista.
	public void setControl(ControlLogin controllog) {
		this.control=controllog;
		
	}
}
