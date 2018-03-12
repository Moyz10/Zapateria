package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Negocio.Controlventa;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaCambiocalzado extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldFolioventa;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblIdProductonuevo;
	private JTextField textFieldIdproductonuevo;
	private JButton btnBuscar;
	private JScrollPane scrollPane_1;
	private JTable table_1;
	private JButton btnCancelar;
	private JButton btnContinuar;
	private Controlventa control;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaCambiocalzado frame = new VistaCambiocalzado();
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
	public VistaCambiocalzado() {
		
		setResizable(false);
		setTitle("Cambio de calzado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450,380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFolioDeVenta = new JLabel("Folio de venta");
		lblFolioDeVenta.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFolioDeVenta.setBounds(23, 22, 96, 28);
		contentPane.add(lblFolioDeVenta);
		
		textFieldFolioventa = new JTextField();
		textFieldFolioventa.setBounds(140, 28, 86, 20);
		contentPane.add(textFieldFolioventa);
		textFieldFolioventa.setColumns(10);
		
		JButton btnDevolver = new JButton("Devolver");
		btnDevolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textFieldFolioventa.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese folio de venta");
				}else {
					
				}
			}
		});
		btnDevolver.setBounds(258, 27, 89, 23);
		contentPane.add(btnDevolver);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 61, 350, 43);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"Modelo", "Talla", "Color", "Cantidad"
			}
		));
		scrollPane.setViewportView(table);
		
		lblIdProductonuevo = new JLabel("ID Producto (Nuevo)");
		lblIdProductonuevo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdProductonuevo.setBounds(23, 153, 136, 20);
		contentPane.add(lblIdProductonuevo);
		
		textFieldIdproductonuevo = new JTextField();
		textFieldIdproductonuevo.setBounds(178, 155, 86, 20);
		contentPane.add(textFieldIdproductonuevo);
		textFieldIdproductonuevo.setColumns(10);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(288, 154, 89, 23);
		contentPane.add(btnBuscar);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 184, 424, 43);
		contentPane.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, Boolean.TRUE, null},
			},
			new String[] {
				"Modelo", "Talla", "Color", "Disponibles", "", "Cantidad"
			}
		) {
			Class[] columnTypes = new Class[] {
				Object.class, Object.class, Object.class, Object.class, Boolean.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table_1);
		
		btnCancelar = new JButton("Cancelar");
		//Agregamos un listener al botón, en este caso solo se cierra la ventana.
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(208, 238, 89, 23);
		contentPane.add(btnCancelar);
		
		btnContinuar = new JButton("Continuar");
		//Agregamos un listener al botón, en este caso continua a la impresión de ticket.
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnContinuar.setBounds(307, 238, 89, 23);
		contentPane.add(btnContinuar);
	}
	//Asignamos control a nuestra vista.

	public void setControl(Controlventa control) {
		this.control=control;
		
	}

}
