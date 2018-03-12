package Presentacion;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import Negocio.Controlventa;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.ComponentOrientation;

public class VistaVentacalzado extends JFrame {

	private JPanel contentPane;
	private JTextField txtidproducto;
	private JTable table1;
	private Controlventa control;
	private JTable table;
	
	
	public DefaultTableModel modelo = new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Modelo", "Tipo", "Color", "Talla", "Costo", "Disponibles", "Pares a vender"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class, Double.class, Double.class, Integer.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		};
	private JTextField txtMontoUnitario;
	private JTextField txtIVA;
	private JTextField txtTotal;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaVentacalzado frame = new VistaVentacalzado();
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
	public VistaVentacalzado() {
		
		setTitle("Venta de calzado");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 605, 352);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel Idlabel = new JLabel("ID Producto");
		Idlabel.setBounds(10, 21, 86, 26);
		contentPane.add(Idlabel);
		
		txtidproducto = new JTextField();
		txtidproducto.setBounds(137, 24, 86, 20);
		contentPane.add(txtidproducto);
		txtidproducto.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 81, 502, 74);
		contentPane.add(scrollPane);
		
		 
		
		table = new JTable();
		table.setFocusable(false);
		table.getTableHeader().setReorderingAllowed(false);
		table.setModel(modelo);
		table.getColumnModel().getColumn(6).setPreferredWidth(107);
		scrollPane.setViewportView(table);
		
		JButton btnBuscar = new JButton("Buscar");
		//Validamos si los datos son correctos, y ejecutamos la búsqueda en este método.
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtidproducto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Ingrese id de producto a buscar");
				}else
				control.buscaProducto(Integer.valueOf(txtidproducto.getText()));
		}});
		btnBuscar.setBounds(252, 23, 89, 23);
		contentPane.add(btnBuscar);
		
		JButton btnContinuar = new JButton("Continuar");
		//Validamos si los datos son correctos, y ejecutamos la impresión del ticket.
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtMontoUnitario.getText().equals("")||txtIVA.getText().equals("")||txtTotal.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Imposible pasar a imprimir ticket");
				}else
				control.creaTicket();
			}
		});
		btnContinuar.setBounds(475, 279, 89, 23);
		contentPane.add(btnContinuar);
		
		JButton btnCancelar = new JButton("Cancelar");
		//Cerramos la ventana.
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelar.setBounds(351, 279, 89, 23);
		contentPane.add(btnCancelar);
		
		JLabel lblmonto = new JLabel("Monto por unidad");
		lblmonto.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblmonto.setBounds(331, 166, 111, 26);
		contentPane.add(lblmonto);
		
		JLabel lblIva = new JLabel("IVA (16%)");
		lblIva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIva.setBounds(367, 190, 75, 26);
		contentPane.add(lblIva);
		
		JLabel lblTotal = new JLabel("Total");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(405, 227, 53, 20);
		contentPane.add(lblTotal);
		
		txtMontoUnitario = new JTextField();
		txtMontoUnitario.setEditable(false);
		txtMontoUnitario.setBounds(458, 171, 86, 20);
		contentPane.add(txtMontoUnitario);
		txtMontoUnitario.setColumns(10);
		
		txtIVA = new JTextField();
		txtIVA.setEditable(false);
		txtIVA.setBounds(458, 195, 86, 20);
		contentPane.add(txtIVA);
		txtIVA.setColumns(10);
		
		txtTotal = new JTextField();
		txtTotal.setEditable(false);
		txtTotal.setBounds(458, 229, 86, 20);
		contentPane.add(txtTotal);
		txtTotal.setColumns(10);
		
		JButton btnCalcularTotal = new JButton("Calcular Total");
		//Validamos si ya hay producto seleccionado, para calcular su costo y total
		btnCalcularTotal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtidproducto.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "No es posible calcular el total");
				}else
				control.calculatotal();
			}
		});
		btnCalcularTotal.setBounds(170, 194, 128, 23);
		contentPane.add(btnCalcularTotal);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnAtras.setBounds(241, 279, 89, 23);
		contentPane.add(btnAtras);
		
		
		
	}
	//Instanciamos control a nuestra vista.

	public void setControl(Controlventa control) {
		this.control=control;
		
	}
	//Estos métodos nos sirven para agregar datos a los textfields que despliegan los costos.
	
	public void setMontototal(String txt) {
		txtTotal.setText(txt);
	}
	
	public void setIva(String txt) {
		txtIVA.setText(txt);
	}
	
	public void setMontounitario(String txt) {
		txtMontoUnitario.setText(txt);
	}
	
	//Al ya estar calculados, solo los retornamos, para la impresión del ticket.

	public String getIva() {
		return txtIVA.getText();
	}

	public String getTotal() {
		return txtTotal.getText();
	}
}
