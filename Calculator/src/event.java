import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Stack;

import javax.swing.JOptionPane;

public class event implements ActionListener {

	private String result = "";

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();
		Calculator.index = 4;
		if (buttonString.equals("1")) {
			Calculator.display.setText(Calculator.display.getText() + "1");
		} else if (buttonString.equals("2")) {
			Calculator.display.setText(Calculator.display.getText() + "2");
		} else if (buttonString.equals("3")) {
			Calculator.display.setText(Calculator.display.getText() + "3");
		} else if (buttonString.equals("4")) {
			Calculator.display.setText(Calculator.display.getText() + "4");
		} else if (buttonString.equals("5")) {
			Calculator.display.setText(Calculator.display.getText() + "5");
		} else if (buttonString.equals("6")) {
			Calculator.display.setText(Calculator.display.getText() + "6");
		} else if (buttonString.equals("7")) {
			Calculator.display.setText(Calculator.display.getText() + "7");
		} else if (buttonString.equals("8")) {
			Calculator.display.setText(Calculator.display.getText() + "8");
		} else if (buttonString.equals("9")) {
			Calculator.display.setText(Calculator.display.getText() + "9");
		} else if (buttonString.equals("0")) {
			Calculator.display.setText(Calculator.display.getText() + "0");
		} else if (buttonString.equals(".")) {
			if (Calculator.display.getText().contains("Math Error !")
					|| Calculator.display.getText().contains("Invalid Input !")) {
				Calculator.display.setText("Invalid Input !");
				return;
			}
			if (checkDot())
				Calculator.display.setText(Calculator.display.getText() + ".");
		} else if (buttonString.equals("+")) {
			if (!(Calculator.resultLabel.getText().equals("")
					|| Calculator.resultLabel.getText().equals(
							"Invalid Input !") || Calculator.resultLabel
					.getText().equals("Invalid Expression!"))
					&& Calculator.display.getText().equals("")
					&& isValid(Calculator.display.getText()))
				Calculator.display.setText(Calculator.resultLabel.getText());
			String operation_Exp = Calculator.display.getText();
			Calculator.display.setText(Calculator.display.getText() + "+");
		} else if (buttonString.equals("-")) {
			if (!(Calculator.resultLabel.getText().equals("")
					|| Calculator.resultLabel.getText().equals(
							"Invalid Input !") || Calculator.resultLabel
					.getText().equals("Invalid Expression!"))
					&& Calculator.display.getText().equals("")
					&& isValid(Calculator.display.getText()))
				Calculator.display.setText(Calculator.resultLabel.getText());
			String operation_Exp = Calculator.display.getText();
			Calculator.display.setText(Calculator.display.getText() + "-");
		} else if (buttonString.equals("*")) {
			if (!(Calculator.resultLabel.getText().equals("")
					|| Calculator.resultLabel.getText().equals(
							"Invalid Input !") || Calculator.resultLabel
					.getText().equals("Invalid Expression!"))
					&& Calculator.display.getText().equals("")
					&& isValid(Calculator.display.getText()))
				Calculator.display.setText(Calculator.resultLabel.getText());
			String operation_Exp = Calculator.display.getText();
			Calculator.display.setText(Calculator.display.getText() + "*");
		} else if (buttonString.equals("/")) {
			if (!(Calculator.resultLabel.getText().equals("")
					|| Calculator.resultLabel.getText().equals(
							"Invalid Input !") || Calculator.resultLabel
					.getText().equals("Invalid Expression!"))
					&& Calculator.display.getText().equals("")
					&& isValid(Calculator.display.getText()))
				Calculator.display.setText(Calculator.resultLabel.getText());
			String operation_Exp = Calculator.display.getText();
			Calculator.display.setText(Calculator.display.getText() + "/");
		} else if (buttonString.equals("=")) {
			String exp = Calculator.display.getText();
			if (isValid(exp)) {
				Calculator.oper1 = "";
				Calculator.oper2 = "";
				convert(exp);
				if(Calculator.operator == '/'
						&& Double.parseDouble(Calculator.oper2) == 0) {
					JOptionPane.showMessageDialog(null, "Math Error!");
					return;
				}
				for (int j = 0; j < 4; j++) {
					Calculator.operation[j] = Calculator.operation[j + 1];
				}
				Calculator.operation[4] = new Operation(Calculator.oper1,
						Calculator.oper2, Calculator.operator);
				Calculator.display.setText(exp);
				Calculator.resultLabel.setText(Calculator.operation[4]
						.evaluate() + "");
				Calculator.index2++;
			} else {
				Calculator.display.setText(exp);
				// Calculator.resultLabel.setText("Invalid Expression!");
				JOptionPane.showMessageDialog(null, "Invalid Expression!");
			}
		} else if (buttonString.equals("C")) {
			Calculator.display.setText("");
			Calculator.resultLabel.setText("         ");
		} else if (buttonString.equals("Delete")) {
			char[] expre = Calculator.display.getText().toCharArray();
			String update = "";
			for (int i = 0; i < expre.length - 1; i++) {
				update += expre[i];
			}
			Calculator.display.setText(update);
		}
	}

	private boolean checkDot() {
		String expression = Calculator.display.getText();
		String operand1 = "", operand2 = "";
		char sign = ' ';
		char[] exp = expression.toCharArray();
		int temp = 0;
		boolean flag = true;
		if (exp.length >= 1 && exp[0] == '-') {
			operand1 = "-";
			temp++;
		}
		for (int i = temp; i < exp.length; i++) {
			if (i != 0 && exp[i] == '+' || exp[i] == '-' || exp[i] == '*'
					|| exp[i] == '/') {
				break;
			}
			if (exp[i] != '+')
				operand1 += exp[i];
			temp++;
		}
		if (temp < exp.length)
			sign = exp[temp];
		temp++;
		if (temp < exp.length)
			if (exp[temp] == '-') {
				operand2 = "-";
				temp++;
			} else if (exp[temp] == '+') {
				temp++;
			}
		for (int i = temp; i < exp.length; i++) {
			operand2 += exp[i];
		}
		if (sign == ' ') {
			if (operand1.contains(".")) {
				return false;
			} else {
				return true;
			}
		} else {
			if (operand2.contains(".")) {
				return false;
			} else {
				return true;
			}
		}
	}

	public static void convert(String expression) {
		char[] exp = expression.toCharArray();
		int temp = 0;
		boolean flag = true;
		if (exp[0] == '-') {
			Calculator.oper1 = "-";
			temp++;
		}
		for (int i = temp; i < exp.length; i++) {
			if (i != 0 && exp[i] == '+' || exp[i] == '-' || exp[i] == '*'
					|| exp[i] == '/') {
				break;
			}
			if (exp[i] != '+')
				Calculator.oper1 += exp[i];
			temp++;
		}
		Calculator.operator = exp[temp];
		temp++;
		if (exp[temp] == '-') {
			Calculator.oper2 = "-";
			temp++;
		} else if (exp[temp] == '+') {
			temp++;
		}
		for (int i = temp; i < exp.length; i++) {
			Calculator.oper2 += exp[i];
		}
	}

	public static boolean isValid(String st) {
		if (st.length() < 3) {
			return false;
		}
		char[] arr = st.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != '.'
					&& (arr[i] != '+' && arr[i] != '-' && arr[i] != '*' && arr[i] != '/')
					&& (arr[i] < '0' || arr[i] > '9')) {
				return false;
			}
		}
		if ((arr[0] != '+' && arr[0] != '-') && (arr[0] < '0' || arr[0] > '9')) {
			return false;
		}

		String num1 = "", num2 = "";
		char operator = ' ';
		int temp = 0;
		boolean flag = true;
		if (arr[0] == '-') {
			num1 = "-";
			temp++;
		}
		for (int i = temp; i < arr.length; i++) {
			if (i != 0 && arr[i] == '+' || arr[i] == '-' || arr[i] == '*'
					|| arr[i] == '/') {
				break;
			}
			if (arr[i] != '+')
				num1 += arr[i];
			temp++;
		}
		if (temp < arr.length) {
			operator = arr[temp];
			temp++;
		}
		if (temp < arr.length && arr[temp] == '-') {
			num2 = "-";
			temp++;
		} else if (temp < arr.length && arr[temp] == '+') {
			temp++;
		}
		for (int i = temp; i < arr.length; i++) {
			num2 += arr[i];
		}

		if (operator != '+' && operator != '-' && operator != '*'
				&& operator != '/') {
			return false;
		}
		char[] arr1 = num1.toCharArray();
		char[] arr2 = num2.toCharArray();

		if (arr1[0] != '+' && arr1[0] != '-'
				&& (arr1[0] < '0' || arr1[0] > '9')) {
			return false;
		}
		if (arr2[0] != '+' && arr2[0] != '-'
				&& (arr2[0] < '0' || arr2[0] > '9')) {
			return false;
		}
		for (int i = 1; i < arr1.length; i++) {
			if (arr1[i] != '.' && (arr1[i] < '0' || arr1[i] > '9')) {
				return false;
			}
		}
		for (int i = 1; i < arr2.length; i++) {
			if (arr2[i] != '.' && (arr2[i] < '0' || arr2[i] > '9')) {
				return false;
			}
		}

		return true;
	}

}
