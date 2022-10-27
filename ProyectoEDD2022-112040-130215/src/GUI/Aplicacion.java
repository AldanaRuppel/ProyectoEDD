package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class Aplicacion extends JFrame {

	private JPanel contentPane;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Aplicacion frame = new Aplicacion();
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
	public Aplicacion() {
		setFont(new Font("Microsoft JhengHei", Font.BOLD, 14));
		setForeground(Color.WHITE);
		setTitle("Banco Nuevo DCIC");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 662);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaptionBorder);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 17));
		lblNombre.setBounds(226, 172, 85, 27);
		contentPane.add(lblNombre);
		
		JTextArea textNombre = new JTextArea();
		textNombre.setBounds(306, 176, 160, 22);
		contentPane.add(textNombre);
		
		JLabel lblApellido = new JLabel("Apellido :");
		lblApellido.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 17));
		lblApellido.setBounds(226, 218, 85, 27);
		contentPane.add(lblApellido);
		
		JTextArea textApellido = new JTextArea();
		textApellido.setBounds(306, 222, 160, 22);
		contentPane.add(textApellido);
		
		JLabel lblDni = new JLabel("DNI :");
		lblDni.setFont(new Font("Microsoft JhengHei UI", Font.PLAIN, 17));
		lblDni.setBounds(226, 265, 85, 27);
		contentPane.add(lblDni);
		
		JTextPane textDNI = new JTextPane();
		textDNI.setBounds(304, 265, 162, 19);
		contentPane.add(textDNI);
		
		JLabel lblCodigoAcceso = new JLabel("Codigo de Acceso :");
		lblCodigoAcceso.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 16));
		lblCodigoAcceso.setBounds(285, 317, 160, 27);
		contentPane.add(lblCodigoAcceso);
		
		JButton btnIngresar = new JButton("Ingresar ");
		btnIngresar.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 17));
		btnIngresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnIngresar.setBounds(285, 411, 160, 21);
		contentPane.add(btnIngresar);
		
		JLabel lblNewLabel = new JLabel("DCIC BANK");
		lblNewLabel.setForeground(SystemColor.activeCaptionText);
		lblNewLabel.setBackground(SystemColor.activeCaption);
		lblNewLabel.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 24));
		lblNewLabel.setBounds(285, 57, 252, 59);
		contentPane.add(lblNewLabel);
		
		password = new JPasswordField();
		password.setFont(new Font("Microsoft JhengHei", Font.PLAIN, 15));
		password.setBounds(279, 354, 187, 19);
		contentPane.add(password);
	}
}
