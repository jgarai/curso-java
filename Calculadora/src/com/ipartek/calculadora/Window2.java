package com.ipartek.calculadora;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Window2 {

	private static final int DISPLAY_LENGHT = 8;
	private JFrame frame;
	private String left = "0", sign = "", right = "0";
	private Boolean isNegative = false;
	private Boolean afterOperation = false;
	private Boolean afterEqual = false;

	private JLabel Display;

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
	 * 
	 * @throws UnsupportedLookAndFeelException
	 * @throws IllegalAccessException
	 * @throws InstantiationException
	 * @throws ClassNotFoundException
	 */
	public Window2() throws ClassNotFoundException, InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
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

	public void setDisplay() {
		if (afterOperation == false) {
			Display.setText(getRight());
		}
	}

	public void setDisplay(String str) {
		if (afterOperation == false) {
			Display.setText(str);
		}
	}

	private void addDigit(String key) {
		if (getRight().length() < DISPLAY_LENGHT) {
			afterOperation = false;
			if (afterEqual == true) {
				setRight("0");
				afterEqual = false;
			}
			setRight(getRight() + key);
			setRight(String.valueOf(Integer.parseInt(getRight()))); // remove 0 before
			setDisplay();
		}
	}

	private void addOperation() {
		setLeft(getRight());
		setRight("0");
		afterOperation = true;
		setDisplay();
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
		Display = lblDisplay;
		lblDisplay.setForeground(Color.BLACK);
		lblDisplay.setBackground(Color.LIGHT_GRAY);
		lblDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplay.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblDisplay.setBounds(10, 11, 220, 42);
		frame.getContentPane().add(lblDisplay);

		JButton btnSign = new JButton("-");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer i = Math.abs(Integer.parseInt(getRight()));
				if (isNegative == false) {
					isNegative = true;
					i = i * -1;
				} else {
					isNegative = false;
				}
				setRight(String.valueOf(i));
				setDisplay();
			}
		});
		btnSign.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSign.setBounds(16, 280, 48, 40);
		frame.getContentPane().add(btnSign);

		JButton btn0 = new JButton("0");

		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "0";
				addDigit(key);
			}
		});
		btn0.setBounds(74, 280, 48, 40);
		frame.getContentPane().add(btn0);

		JButton btnColon = new JButton(",");
		btnColon.setEnabled(false);
		btnColon.setBounds(132, 280, 48, 40);
		frame.getContentPane().add(btnColon);

		JButton btnEquals = new JButton("=");
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer leftInterno = 0;
				Integer rightInterno = 0;
				Integer result = 0;
				char operation;

				if (getSign().length() > 0) {
					operation = getSign().charAt(0);
				} else
					return;
				if (getLeft().length() > 0) {
					leftInterno = Integer.parseInt(getLeft());
				} else
					return;
				if (getRight().length() > 0) {
					rightInterno = Integer.parseInt(getRight());
				} else
					return;
				if (operation == '+') {
					result = leftInterno + rightInterno;
					setLeft(getRight());
					setRight(String.valueOf(result));
				}
				if (operation == '-') {
					result = leftInterno - rightInterno;
					setLeft(getRight());
					setRight(String.valueOf(result));
				}
				if (operation == 'X') {
					result = leftInterno * rightInterno;
					setLeft(getRight());
					setRight(String.valueOf(result));
				}
				if (operation == '/') {
					result = (int) (leftInterno / rightInterno);
					setLeft(getRight());
					setRight(String.valueOf(result));
				}
				afterEqual = true;
				setDisplay();
				setSign("");
			}
		});
		btnEquals.setBounds(190, 280, 48, 40);
		frame.getContentPane().add(btnEquals);

		JButton btn1 = new JButton("1");

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "1";
				addDigit(key);
			}
		});
		btn1.setBounds(16, 229, 48, 40);
		frame.getContentPane().add(btn1);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "4";
				addDigit(key);
			}
		});
		btn4.setBounds(16, 178, 48, 40);
		frame.getContentPane().add(btn4);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "7";
				addDigit(key);
			}
		});
		btn7.setBounds(16, 127, 48, 40);
		frame.getContentPane().add(btn7);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "2";
				addDigit(key);
			}
		});
		btn2.setBounds(74, 229, 48, 40);
		frame.getContentPane().add(btn2);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "5";
				addDigit(key);
			}
		});
		btn5.setBounds(74, 178, 48, 40);
		frame.getContentPane().add(btn5);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "8";
				addDigit(key);
			}
		});
		btn8.setBounds(74, 127, 48, 40);
		frame.getContentPane().add(btn8);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "3";
				addDigit(key);
			}
		});
		btn3.setBounds(132, 229, 48, 40);
		frame.getContentPane().add(btn3);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "6";
				addDigit(key);
			}
		});
		btn6.setBounds(132, 178, 48, 40);
		frame.getContentPane().add(btn6);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String key = "9";
				addDigit(key);
			}
		});
		btn9.setBounds(132, 127, 48, 40);
		frame.getContentPane().add(btn9);

		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setSign("+");
				addOperation();
			}

		});
		btnPlus.setBounds(190, 229, 48, 40);
		frame.getContentPane().add(btnPlus);

		JButton btnSubtract = new JButton("-");
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLeft(getRight()); // move from right to left
				setSign("-");
				addOperation();
			}
		});
		btnSubtract.setBounds(190, 178, 48, 40);
		frame.getContentPane().add(btnSubtract);

		JButton btnMultiplication = new JButton("X");
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLeft(getRight()); // move from right to left
				setSign("X");
				addOperation();
			}
		});
		btnMultiplication.setBounds(190, 127, 48, 40);
		frame.getContentPane().add(btnMultiplication);

		JButton btnDivision = new JButton("/");
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLeft(getRight()); // move from right to left
				setSign("/");
				addOperation();
			}
		});
		btnDivision.setBounds(190, 76, 48, 40);
		frame.getContentPane().add(btnDivision);

		JButton btnClearAll = new JButton("C");
		btnClearAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setRight("0");
				setLeft("0");
				setDisplay();
			}
		});
		btnClearAll.setBounds(74, 76, 48, 40);
		frame.getContentPane().add(btnClearAll);

		JButton btnClearRight = new JButton("CE");
		btnClearRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setRight("0");
				setDisplay();
			}
		});
		btnClearRight.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnClearRight.setBounds(16, 76, 48, 40);
		frame.getContentPane().add(btnClearRight);

		JButton btnDeleteLast = new JButton("<[]");
		btnDeleteLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (getRight().length() > 0) {
					String aux = getRight();
					setRight(aux.substring(0, aux.length() - 1));
				}
				if (getRight().length() == 0) {
					setRight("0");
				}
				setDisplay();

			}
		});
		btnDeleteLast.setBounds(132, 76, 48, 40);
		frame.getContentPane().add(btnDeleteLast);

	}
}
