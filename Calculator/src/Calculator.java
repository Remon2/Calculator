import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Calculator extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Operation[] operation = new Operation[5];
	static String result = "";
	static JTextField display;
	static JLabel resultLabel;
	static JPanel panel1, panel2;
	static JButton one, two, three, four, five, six, seven, eight, nine, zero,
			plus, minus, multiply, divide, decimal, equal, clear,
			open_Bracket, close_Bracket, prev, next, delete;

	static int index = 0;
	static int index2 = 0;
	static String oper1 = "", oper2 = "";
	static char operator = ' ';

	@SuppressWarnings("deprecation")
	public Calculator() {
		setVisible(true);
		setTitle("Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(500,250 );
		 setResizable(false);

		for (int i = 0; i < 5; i++) {
			operation[i] = new Operation();
		}



		delete = new JButton("Delete");
		delete.setFont(new Font("Arial", 1, 15));
		delete.setCursor(new Cursor(HAND_CURSOR));
		
		display = new JTextField(20);
		display.setEditable(false);
		display.setSize(200, 10);

		resultLabel = new JLabel("         ");

		resultLabel.setSize(200, 10);

		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.add(display, BorderLayout.NORTH);
		panel1.add(resultLabel, BorderLayout.SOUTH);
		add(panel1, BorderLayout.NORTH);

		prev = new JButton("<");
		prev.setFont(new Font("Arial", 1, 22));
		prev.setCursor(new Cursor(HAND_CURSOR));
		next = new JButton(">");
		next.setFont(new Font("Arial", 1, 22));
		next.setCursor(new Cursor(HAND_CURSOR));
		clear = new JButton("C");
		clear.setFont(new Font("Arial", 1, 22));
		clear.setCursor(new Cursor(HAND_CURSOR));
		seven = new JButton("7");
		seven.setFont(new Font("Arial", 1, 22));
		seven.setCursor(new Cursor(HAND_CURSOR));
		eight = new JButton("8");
		eight.setFont(new Font("Arial", 1, 22));
		eight.setCursor(new Cursor(HAND_CURSOR));
		nine = new JButton("9");
		nine.setFont(new Font("Arial", 1, 22));
		nine.setCursor(new Cursor(HAND_CURSOR));
		divide = new JButton("/");
		divide.setFont(new Font("Arial", 1, 22));
		divide.setCursor(new Cursor(HAND_CURSOR));
		four = new JButton("4");
		four.setFont(new Font("Arial", 1, 22));
		four.setCursor(new Cursor(HAND_CURSOR));
		five = new JButton("5");
		five.setFont(new Font("Arial", 1, 22));
		five.setCursor(new Cursor(HAND_CURSOR));
		six = new JButton("6");
		six.setFont(new Font("Arial", 1, 22));
		six.setCursor(new Cursor(HAND_CURSOR));
		multiply = new JButton("*");
		multiply.setFont(new Font("Arial", 1, 22));
		multiply.setCursor(new Cursor(HAND_CURSOR));
		open_Bracket = new JButton("(");
		open_Bracket.setFont(new Font("Arial", 1, 22));
		open_Bracket.setCursor(new Cursor(HAND_CURSOR));
		close_Bracket = new JButton(")");
		close_Bracket.setFont(new Font("Arial", 1, 22));
		close_Bracket.setCursor(new Cursor(HAND_CURSOR));
		one = new JButton("1");
		one.setFont(new Font("Arial", 1, 22));
		one.setCursor(new Cursor(HAND_CURSOR));
		two = new JButton("2");
		two.setFont(new Font("Arial", 1, 22));
		two.setCursor(new Cursor(HAND_CURSOR));
		three = new JButton("3");
		three.setFont(new Font("Arial", 1, 22));
		three.setCursor(new Cursor(HAND_CURSOR));
		minus = new JButton("-");
		minus.setFont(new Font("Arial", 1, 22));
		minus.setCursor(new Cursor(HAND_CURSOR));
		equal = new JButton("=");
		equal.setFont(new Font("Arial", 1, 22));
		equal.setCursor(new Cursor(HAND_CURSOR));
		zero = new JButton("0");
		zero.setFont(new Font("Arial", 1, 22));
		zero.setCursor(new Cursor(HAND_CURSOR));
		decimal = new JButton(".");
		decimal.setFont(new Font("Arial", 1, 22));
		decimal.setCursor(new Cursor(HAND_CURSOR));
		plus = new JButton("+");
		plus.setFont(new Font("Arial", 1, 22));
		plus.setCursor(new Cursor(HAND_CURSOR));

		panel2 = new JPanel();
		panel2.setLayout(new GridLayout(5, 4, 6, 6));

		panel2.add(equal, 0, 0);
		panel2.add(prev, 0, 1);
		panel2.add(next, 0, 2);
		panel2.add(delete, 0, 3);
		panel2.add(decimal, 1, 0);
		panel2.add(zero, 1, 1);
		panel2.add(clear, 1, 2);
		panel2.add(divide, 1, 3);
		panel2.add(seven, 4, 0);
		panel2.add(eight, 4, 1);
		panel2.add(nine, 4, 2);
		panel2.add(plus, 4, 3);
		panel2.add(four, 3, 0);
		panel2.add(five, 3, 1);
		panel2.add(six, 3, 2);
		panel2.add(minus, 3, 3);
		panel2.add(one, 2, 0);
		panel2.add(two, 2, 1);
		panel2.add(three, 2, 2);
		panel2.add(multiply, 2, 3);

		add(panel2, BorderLayout.CENTER);
		event e = new event();
		KeyBoardListener key = new KeyBoardListener();
		display.addKeyListener(key);

		one.addActionListener(e);
		two.addActionListener(e);
		three.addActionListener(e);
		four.addActionListener(e);
		five.addActionListener(e);
		six.addActionListener(e);
		seven.addActionListener(e);
		eight.addActionListener(e);
		nine.addActionListener(e);
		zero.addActionListener(e);
		plus.addActionListener(e);
		minus.addActionListener(e);
		multiply.addActionListener(e);
		divide.addActionListener(e);
		open_Bracket.addActionListener(e);
		close_Bracket.addActionListener(e);
		decimal.addActionListener(e);
		equal.addActionListener(e);
		delete.addActionListener(e);
		clear.addActionListener(e);

		SaveEvent save = new SaveEvent();
		prev.addActionListener(save);
		next.addActionListener(save);

		
		delete.setBackground(new Color(255,116,114));
		display.setBackground(Color.white);
		prev.setBackground(new Color(153,239,255));
		next.setBackground(new Color(153,239,255));
		clear.setBackground(new Color(255,255,178));
		seven.setBackground(new Color(178,216,194));
		eight.setBackground(new Color(178,216,194));
		nine.setBackground(new Color(178,216,194));
		divide.setBackground(new Color(180,216,255));
		four.setBackground(new Color(178,216,194));
		decimal.setBackground(new Color(178,216,194));
		five.setBackground(new Color(178,216,194));
		six.setBackground(new Color(178,216,194));
		multiply.setBackground(new Color(180,216,255));
		one.setBackground(new Color(178,216,194));
		two.setBackground(new Color(178,216,194));
		three.setBackground(new Color(178,216,194));
		minus.setBackground(new Color(180,216,255));
		plus.setBackground(new Color(180,216,255));
		zero.setBackground(new Color(178,216,194));
		equal.setBackground(new Color(194,255,155));
		
		
		setSize(350, 350);
	}

	public static void main(String[] args) {
		new Calculator();
	}
}
