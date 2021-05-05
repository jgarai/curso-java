package com.ipartek.calculadora;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Window {

	private JFrame frame;
	private JTextField tFnumero1;
	private JTextField tFnumero2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public Window() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 125);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		tFnumero1 = new JTextField();
		tFnumero1.setHorizontalAlignment(SwingConstants.RIGHT);
		tFnumero1.setText("0");
		tFnumero1.setBounds(19, 40, 75, 20);
		frame.getContentPane().add(tFnumero1);
		tFnumero1.setColumns(10);

		tFnumero2 = new JTextField();
		tFnumero2.setHorizontalAlignment(SwingConstants.RIGHT);
		tFnumero2.setText("0");
		tFnumero2.setBounds(154, 40, 75, 20);
		frame.getContentPane().add(tFnumero2);
		tFnumero2.setColumns(10);

		JComboBox cBoperacion = new JComboBox();
		cBoperacion.setModel(new DefaultComboBoxModel(new String[] { "+", "-", "*", "/" }));
		cBoperacion.setBounds(104, 39, 40, 22);
		frame.getContentPane().add(cBoperacion);

		JLabel lblResultado = new JLabel("0");
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setBounds(314, 43, 120, 14);
		frame.getContentPane().add(lblResultado);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Double numero1 = Double.parseDouble(tFnumero1.getText());
					Double numero2 = Double.parseDouble(tFnumero2.getText());
					Integer operacion = cBoperacion.getSelectedIndex();
					String result = new String();

					if (operacion == 0) { // suma
						result = String.valueOf(numero1 + numero2);
					}
					if (operacion == 1) { // resta
						result = String.valueOf(numero1 - numero2);
					}
					if (operacion == 2) { // multiplicacion
						result = String.valueOf(numero1 * numero2);
					}
					if (operacion == 3) { // division
						result = String.valueOf(numero1 / numero2);
					}
					lblResultado.setText(result);
					tFnumero1.setText(String.valueOf(numero1));
					tFnumero2.setText(String.valueOf(numero2));

				} catch (NumberFormatException e1) {
					lblResultado.setText("NaN");
				}
			}
		});
		btnCalcular.setBounds(239, 39, 85, 23);
		frame.getContentPane().add(btnCalcular);

		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setBounds(334, 43, 20, 17);
		frame.getContentPane().add(lblNewLabel);

	}
}
