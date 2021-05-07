package com.ipartek.calculadora;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Window2 {

	private static final int DISPLAY_LENGHT = 12;
	private JFrame frame;
	private String left = "0", operation = "", right = "0";
	private Boolean isNegative = false;
	private Boolean afterOperation = false;
	private Boolean afterEqual = false;

	private JLabel display;
	private JButton buttonWitchGetFocus;

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

	public String getOperation() {
		return operation;
	}

	public void setOperation(String sign) {
		this.operation = sign;
	}

	public void setOperation(char sign) {
		this.operation = String.valueOf(sign);
	}

	public String getRight() {
		return right;
	}

	public void setRight(String right) {
		this.right = right;
	}

	public void setDisplay() {
		if (afterOperation == false) {
			display.setText(getRight());

		}
		buttonWitchGetFocus.requestFocus();
	}

	public void setDisplay(String str) {
		if (afterOperation == false) {
			display.setText(str);
		}
		buttonWitchGetFocus.requestFocus();
	}

	public void showError() {
		display.setText("Error");
	}

	private void addDigit(char key) {
		if (getRight().length() < DISPLAY_LENGHT) {
			afterOperation = false;
			if (afterEqual == true) {
				setRight("0");
				afterEqual = false;
			}
			setRight(getRight() + key);
			// System.out.println(getRight());
			if (key != '.')
				setRight(new BigDecimal(getRight()).toString()); // remove 0 before
			setDisplay();

		}
	}

	private void addOperation() {
		setLeft(getRight());
		setRight("0");
		afterOperation = true;
		setDisplay();
		buttonWitchGetFocus.requestFocus();

	}

	private void addOperation(char key) {
		setOperation(key);
		addOperation();
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
		// disable tab
		JButton btnGetFocus = new JButton("");
		buttonWitchGetFocus = btnGetFocus;
		btnGetFocus.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
//				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
//					System.out.println("Pressed");
//					// doOperation();
//				}

				char key = e.getKeyChar();
				switch (key) {
				case '1':
				case '2':
				case '3':
				case '4':
				case '5':
				case '6':
				case '7':
				case '8':
				case '9':
				case '0':
				case '.':
					addDigit(key);
					break;
				case '+':
				case '-':
				case '*':
				case '/':
					addOperation(key);
					break;
				default:
					break;
				}
			}
		});

		btnGetFocus.setBounds(1, 1, 0, 0);
		btnGetFocus.setFocusTraversalKeysEnabled(false); // this disable tab funtionality
		frame.getContentPane().add(btnGetFocus);

		JLabel lblDisplay = new JLabel("0");

		display = lblDisplay;
		lblDisplay.setForeground(Color.BLACK);
		lblDisplay.setBackground(Color.LIGHT_GRAY);
		lblDisplay.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplay.setFont(new Font("Tahoma", Font.PLAIN, 32));
		lblDisplay.setBounds(10, 11, 220, 42);
		frame.getContentPane().add(lblDisplay);

		JButton btnSign = new JButton("-");
		btnSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BigDecimal bd = new BigDecimal(getRight()).abs();
				if (isNegative == false) {
					isNegative = true;
					bd = bd.negate();
				} else {
					isNegative = false;
				}
				setRight(bd.toString());
				setDisplay();
			}
		});
		btnSign.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnSign.setBounds(16, 280, 48, 40);
		frame.getContentPane().add(btnSign);

		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('0');
			}
		});
		btn0.setBounds(74, 280, 48, 40);
		frame.getContentPane().add(btn0);

		JButton btnDecimal = new JButton(".");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('.');
			}
		});
		btnDecimal.setBounds(132, 280, 48, 40);
		frame.getContentPane().add(btnDecimal);

		JButton btnEquals = new JButton("=");
		btnEquals.setBackground(Color.GRAY);
		btnEquals.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doOperation();
			}
		});
		btnEquals.setBounds(190, 280, 48, 40);
		frame.getContentPane().add(btnEquals);

		JButton btn1 = new JButton("1");

		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('1');
			}
		});
		btn1.setBounds(16, 229, 48, 40);
		frame.getContentPane().add(btn1);

		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('4');
			}
		});
		btn4.setBounds(16, 178, 48, 40);
		frame.getContentPane().add(btn4);

		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('7');
			}
		});
		btn7.setBounds(16, 127, 48, 40);
		frame.getContentPane().add(btn7);

		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('2');
			}
		});
		btn2.setBounds(74, 229, 48, 40);
		frame.getContentPane().add(btn2);

		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('5');
			}
		});
		btn5.setBounds(74, 178, 48, 40);
		frame.getContentPane().add(btn5);

		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('8');
			}
		});
		btn8.setBounds(74, 127, 48, 40);
		frame.getContentPane().add(btn8);

		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('3');
			}
		});
		btn3.setBounds(132, 229, 48, 40);
		frame.getContentPane().add(btn3);

		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('6');
			}
		});
		btn6.setBounds(132, 178, 48, 40);
		frame.getContentPane().add(btn6);

		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addDigit('9');
			}
		});
		btn9.setBounds(132, 127, 48, 40);
		frame.getContentPane().add(btn9);

		JButton btnPlus = new JButton("+");
		btnPlus.setBackground(Color.GRAY);
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setOperation("+");
				addOperation();
			}
		});
		btnPlus.setBounds(190, 229, 48, 40);
		frame.getContentPane().add(btnPlus);

		JButton btnSubtract = new JButton("-");
		btnSubtract.setBackground(Color.GRAY);
		btnSubtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLeft(getRight()); // move from right to left
				setOperation("-");
				addOperation();
			}
		});
		btnSubtract.setBounds(190, 178, 48, 40);
		frame.getContentPane().add(btnSubtract);

		JButton btnMultiplication = new JButton("X");
		btnMultiplication.setBackground(Color.GRAY);
		btnMultiplication.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLeft(getRight()); // move from right to left
				setOperation("X");
				addOperation();
			}
		});
		btnMultiplication.setBounds(190, 127, 48, 40);
		frame.getContentPane().add(btnMultiplication);

		JButton btnDivision = new JButton("/");
		btnDivision.setBackground(Color.GRAY);
		btnDivision.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setLeft(getRight()); // move from right to left
				setOperation("/");
				addOperation();
			}
		});
		btnDivision.setBounds(190, 76, 48, 40);
		frame.getContentPane().add(btnDivision);

		JButton btnClearAll = new JButton("C");
		btnClearAll.setBackground(Color.ORANGE);
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

		btnClearRight.setBackground(Color.ORANGE);
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
		btnDeleteLast.setBackground(Color.ORANGE);
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

	private void doOperation() {
		BigDecimal leftInterno = null;
		BigDecimal rightInterno = null;
		BigDecimal result = new BigDecimal("0");
		char operation;

		if (getOperation().length() > 0) {
			operation = getOperation().charAt(0);
		} else
			return;
		if (getLeft().length() > 0) {
			leftInterno = new BigDecimal(getLeft());
		} else
			return;
		if (getRight().length() > 0) {
			rightInterno = new BigDecimal(getRight());
		} else
			return;
		if (operation == '+') {
			result = leftInterno.add(rightInterno);
			if (result.toString().length() >= DISPLAY_LENGHT) {
				// error
				System.out.println("Display overflow");
				return;
			} else {
				setLeft(getRight());
				setRight(result.toString());
			}
		}
		if (operation == '-') {
			result = leftInterno.subtract(rightInterno);
			setLeft(getRight());
			setRight(result.toString());
		}
		if (operation == 'X') {
			result = leftInterno.multiply(rightInterno);
			if (result.toString().length() >= DISPLAY_LENGHT) {
				// error
				// System.out.println("Display overflow");
				showError();
				return;
			} else {
				setLeft(getRight());
				setRight(result.toString());
			}
		}
		if (operation == '/') {
			if (rightInterno.compareTo(BigDecimal.ZERO) == 0) {
				// error
				// System.out.println("Divide by zero");
				showError();
				return;
			}
			result = leftInterno.divide(rightInterno, DISPLAY_LENGHT - 2, RoundingMode.HALF_EVEN);
			setLeft(getRight());
			setRight(result.toString());
		}
		afterEqual = true;
		setDisplay();
		setOperation("");
	}

}
