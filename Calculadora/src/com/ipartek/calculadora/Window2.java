package com.ipartek.calculadora;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Window2 {

	private JFrame frame;
	private String left ="", sign = "", right = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window2 window = new Window2();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public Window2() throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

		initialize();
	}

	public String getLeft() {
		return left;
	}

	public void setLeft(String left) {
		this.left = left;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 260, 376);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDisplay = new JLabel("0");
		lblDisplay.setForeground(Color.BLACK);
		lblDisplay.setBackground(Color.LIGHT_GRAY);
		lblDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplay.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblDisplay.setBounds(10, 11, 190, 42);
		frame.getContentPane().add(lblDisplay);
		
		JButton btnSign = new JButton("-");
		btnSign.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSign.setBounds(10, 280, 40, 40);
		frame.getContentPane().add(btnSign);
		
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btn0.setBounds(60, 280, 40, 40);
		frame.getContentPane().add(btn0);
		
		JButton btnColon = new JButton(",");
		btnColon.setBounds(110, 280, 40, 40);
		frame.getContentPane().add(btnColon);
		
		JButton btnEquals = new JButton("=");
		btnEquals.setBounds(160, 280, 40, 40);
		frame.getContentPane().add(btnEquals);
		
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "1";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
				
			}
		});
		btn1.setBounds(10, 229, 40	, 40);
		frame.getContentPane().add(btn1);
		
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "4";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
			}
		});
		btn4.setBounds(10, 178, 40, 40);
		frame.getContentPane().add(btn4);
		
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "7";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
			}
		});
		btn7.setBounds(10, 127, 40, 40);
		frame.getContentPane().add(btn7);
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "2";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
			}
		});
		btn2.setBounds(60, 229, 40, 40);
		frame.getContentPane().add(btn2);
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "5";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
			}
		});
		btn5.setBounds(60, 178, 40, 40);
		frame.getContentPane().add(btn5);
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "8";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
			}
		});
		btn8.setBounds(60, 127, 40, 40);
		frame.getContentPane().add(btn8);
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "3";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
			}
		});
		btn3.setBounds(110, 229, 40, 40);
		frame.getContentPane().add(btn3);
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "6";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
			}
		});
		btn6.setBounds(110, 178, 40, 40);
		frame.getContentPane().add(btn6);
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "9";
				if(getRight().length() < 10) {
					setRight(getRight() + key);
					lblDisplay.setText(getRight());
					
				}
			}
		});
		btn9.setBounds(110, 127, 40, 40);
		frame.getContentPane().add(btn9);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setBounds(160, 229, 40, 40);
		frame.getContentPane().add(btnPlus);
		
		JButton btnSubtract = new JButton("-");
		btnSubtract.setBounds(160, 178, 40, 40);
		frame.getContentPane().add(btnSubtract);
		
		JButton btnMultiplication = new JButton("X");
		btnMultiplication.setBounds(160, 127, 40, 40);
		frame.getContentPane().add(btnMultiplication);
		
		JButton btnDivision = new JButton("/");
		btnDivision.setBounds(160, 76, 40, 40);
		frame.getContentPane().add(btnDivision);
		
	}
}
