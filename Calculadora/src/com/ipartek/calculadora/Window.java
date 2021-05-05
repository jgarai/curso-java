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
	 */
	public Window() {
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
		tFnumero1.setText("0");
		tFnumero1.setBounds(19, 40, 90, 20);
		frame.getContentPane().add(tFnumero1);
		tFnumero1.setColumns(10);

		tFnumero2 = new JTextField();
		tFnumero2.setText("0");
		tFnumero2.setBounds(169, 40, 90, 20);
		frame.getContentPane().add(tFnumero2);
		tFnumero2.setColumns(10);

		JComboBox cBoperacion = new JComboBox();
		cBoperacion.setModel(new DefaultComboBoxModel(new String[] { "+", "-", "*", "/" }));
		cBoperacion.setBounds(119, 39, 40, 22);
		frame.getContentPane().add(cBoperacion);

		JLabel lblResultado = new JLabel("0");
		lblResultado.setHorizontalAlignment(SwingConstants.RIGHT);
		lblResultado.setBounds(364, 43, 60, 14);
		frame.getContentPane().add(lblResultado);

		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Double numero1 = Double.parseDouble(tFnumero1.getText());
				Double numero2 = Double.parseDouble(tFnumero2.getText());
				Integer operacion = cBoperacion.getSelectedIndex();
				if (operacion == 0) { // suma
					String result = new String();
					result += result.format("%s", numero1 + numero2);
					lblResultado.setText(result);
					tFnumero1.setText("" + numero1);
					tFnumero2.setText("" + numero2);
				}
				if (operacion == 1) { // resta
					String result = new String();
					result += result.format("%s", numero1 - numero2);
					lblResultado.setText(result);
					tFnumero1.setText("" + numero1);
					tFnumero2.setText("" + numero2);
				}
				if (operacion == 2) { // multiplicacion
					String result = new String();
					result += result.format("%s", numero1 + numero2);
					lblResultado.setText(result);
					tFnumero1.setText("" + numero1);
					tFnumero2.setText("" + numero2);
				}
				if (operacion == 3) { // division
					String result = new String();
					if (numero2 == 0) {
						result += "NaN";
					} else {
						result += result.format("%s", numero1 / numero2);
					}
					lblResultado.setText(result);
					tFnumero1.setText("" + numero1);
					tFnumero2.setText("" + numero2);
				}

			}
		});
		btnCalcular.setBounds(269, 39, 85, 23);
		frame.getContentPane().add(btnCalcular);

	}
}
