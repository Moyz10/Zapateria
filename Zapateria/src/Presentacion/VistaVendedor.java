package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Controlventa;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaVendedor extends JFrame {

	private JPanel contentPane;
	private Controlventa control;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVendedor frame = new VistaVendedor();
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
	public VistaVendedor() {
		
		setTitle("Vendedor");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton butVenta = new JButton("Venta de calzado");
		//Mostramos la ventana asociada al botón.
		butVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				control.muestraventadecalzado();
				
			}
		});
		butVenta.setBounds(135, 67, 145, 27);
		butVenta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPane.add(butVenta);
		
		JButton butCambio = new JButton("Cambio de calzado");
		//Mostramos la ventana asociada al botón.
		butCambio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				control.muestracambiocalzado();
				
			}
		});
		butCambio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		butCambio.setBounds(135, 136, 157, 27);
		contentPane.add(butCambio);
		
		JButton btnCancelar = new JButton("Cerrar Sesión");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null,"Sesión cerrada");
				dispose();
			}
		});
		btnCancelar.setBounds(247, 213, 157, 23);
		contentPane.add(btnCancelar);
	}
	
	//Instanciamos control a nuestra vista.

	public void setControl(Controlventa controlvent) {
		this.control=controlvent;
		
	}

}
