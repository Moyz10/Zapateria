package Presentacion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Negocio.Controlventa;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VistaTicket extends JFrame {

	private JPanel contentPane;
	private JPanel Ticket;
	private Controlventa controlvent;
	private JTextField textFieldFolio;
	private JTextField textFieldFecha;
	private JTextField textFieldModelo;
	private JTextField textFieldColor;
	private JTextField textFieldTalla;
	private JTextField textFieldCantidad;
	private JTextField textFieldPrecioUnitario;
	private JTextField textFieldIVA;
	private JTextField textFieldTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VistaTicket frame = new VistaTicket();
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
	
	public VistaTicket() {
		Ticket = new JPanel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 498);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		Ticket.setBounds(0, 0, 424, 372);
		contentPane.add(Ticket);
		Ticket.setLayout(null);
		
		JLabel lblNewLabelFolio = new JLabel("Folio de venta");
		lblNewLabelFolio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabelFolio.setBounds(10, 68, 97, 26);
		Ticket.add(lblNewLabelFolio);
		
		JLabel lblNewLabel = new JLabel("Zapateria \"El Ahorro\"");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(125, 0, 175, 46);
		Ticket.add(lblNewLabel);
		
		JLabel lblTicketDeVenta = new JLabel("Ticket de venta");
		lblTicketDeVenta.setBounds(166, 31, 122, 26);
		Ticket.add(lblTicketDeVenta);
		
		textFieldFolio = new JTextField();
		textFieldFolio.setEditable(false);
		textFieldFolio.setBounds(150, 73, 138, 20);
		Ticket.add(textFieldFolio);
		textFieldFolio.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Fecha");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 94, 65, 26);
		Ticket.add(lblNewLabel_1);
		
		textFieldFecha = new JTextField();
		textFieldFecha.setEditable(false);
		textFieldFecha.setBounds(150, 99, 138, 20);
		Ticket.add(textFieldFecha);
		textFieldFecha.setColumns(10);
		
		JLabel lblModelo = new JLabel("Modelo");
		lblModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModelo.setBounds(10, 122, 53, 26);
		Ticket.add(lblModelo);
		
		textFieldModelo = new JTextField();
		textFieldModelo.setEditable(false);
		textFieldModelo.setBounds(150, 130, 138, 20);
		Ticket.add(textFieldModelo);
		textFieldModelo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 156, 46, 14);
		Ticket.add(lblNewLabel_2);
		
		textFieldColor = new JTextField();
		textFieldColor.setEditable(false);
		textFieldColor.setBounds(149, 155, 139, 20);
		Ticket.add(textFieldColor);
		textFieldColor.setColumns(10);
		
		JLabel lblTalla = new JLabel("Talla");
		lblTalla.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTalla.setBounds(10, 181, 46, 14);
		Ticket.add(lblTalla);
		
		textFieldTalla = new JTextField();
		textFieldTalla.setEditable(false);
		textFieldTalla.setBounds(150, 180, 138, 20);
		Ticket.add(textFieldTalla);
		textFieldTalla.setColumns(10);
		
		JLabel lblCantidad = new JLabel("Cantidad");
		lblCantidad.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblCantidad.setBounds(10, 206, 65, 14);
		Ticket.add(lblCantidad);
		
		textFieldCantidad = new JTextField();
		textFieldCantidad.setEditable(false);
		textFieldCantidad.setBounds(149, 205, 139, 20);
		Ticket.add(textFieldCantidad);
		textFieldCantidad.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Precio Unitario");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 232, 97, 14);
		Ticket.add(lblNewLabel_3);
		
		textFieldPrecioUnitario = new JTextField();
		textFieldPrecioUnitario.setEditable(false);
		textFieldPrecioUnitario.setBounds(150, 231, 138, 20);
		Ticket.add(textFieldPrecioUnitario);
		textFieldPrecioUnitario.setColumns(10);
		
		JLabel lblIva = new JLabel("IVA (16%)");
		lblIva.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIva.setBounds(10, 257, 65, 14);
		Ticket.add(lblIva);
		
		textFieldIVA = new JTextField();
		textFieldIVA.setEditable(false);
		textFieldIVA.setBounds(150, 256, 138, 20);
		Ticket.add(textFieldIVA);
		textFieldIVA.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total a pagar (MXN)");
		lblTotal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTotal.setBounds(10, 307, 126, 14);
		Ticket.add(lblTotal);
		
		textFieldTotal = new JTextField();
		textFieldTotal.setEditable(false);
		textFieldTotal.setBounds(149, 306, 139, 20);
		Ticket.add(textFieldTotal);
		textFieldTotal.setColumns(10);
		
		JLabel lblIcon = new JLabel("");
		lblIcon.setBounds(320, 0, 104, 109);
		Ticket.add(lblIcon);
		ImageIcon imgIcon = new ImageIcon(VistaTicket.class.getResource("/presentacion/Ticket.png"));
		Image ticket = imgIcon.getImage();
		Image ticketScaled = ticket.getScaledInstance(100, 100, Image.SCALE_AREA_AVERAGING);
		imgIcon = new ImageIcon(ticketScaled);
		lblIcon.setIcon(imgIcon);
		
		JButton btnCancelar = new JButton("Cancelar");
		//Cerramos la ventana en caso de que se pulse el botón.
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelar.setBounds(185, 376, 89, 23);
		contentPane.add(btnCancelar);
		
		JButton btnImprimir = new JButton("Imprimir");
		//Imprimimos el ticket.
		btnImprimir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controlvent.imprimeTicket();
			}
		});
		btnImprimir.setBounds(303, 376, 89, 23);
		contentPane.add(btnImprimir);
		
		JButton btnTerminado = new JButton("Terminado");
		btnTerminado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnTerminado.setBounds(282, 410, 110, 23);
		contentPane.add(btnTerminado);
	}
	//Instanciamos control a nuestra vista.

	public void setControl(Controlventa controlvent) {
		this.controlvent=controlvent;
	}
	
	//Estos métodos nos sirven para agregar datos al ticket.

	public void setFolio(String txt) {
		textFieldFolio.setText(txt);
		
	}

	public void setFecha(String txt) {
		textFieldFecha.setText(txt);
		
	}

	public void setModelo(String txt) {
		textFieldModelo.setText(txt);
		
	}

	public void setColor(String txt) {
		textFieldColor.setText(txt);
		
	}

	public void setTalla(String txt) {
		textFieldTalla.setText(txt);
		
	}

	public void setCantidad(String txt) {
		textFieldCantidad.setText(txt);
		
	}

	public void setIva(String txt) {
		textFieldIVA.setText(txt);
		
	}

	public void setPrecioUnitario(String txt) {
		textFieldPrecioUnitario.setText(txt);
		
	}

	public void setTotal(String txt) {
		textFieldTotal.setText(txt);
		
	}
	
	//Retornamos el componente del Jframe que queremos imprimir, para evitar que los botones nos aparezcan en la impresión

	public JComponent getTicket() {
		return Ticket;
	}
}
