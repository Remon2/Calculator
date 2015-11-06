public class Operation {

	private String operand1;
	private String operand2;
	private String value;
	private char sign;

	public Operation() {
		operand1 = "";
		operand2 = "";
		sign = ' ';
		value = "x";
	}

	public Operation(String op1, String op2, char s) {
		this.operand1 = op1;
		this.operand2 = op2;
		this.sign = s;
		value = "x";
	}

	public String getOperand1() {
		return operand1;
	}

	public void setOperand1(String operand1) {
		this.operand1 = operand1;
	}

	public String getOperand2() {
		return operand2;
	}

	public void setOperand2(String operand2) {
		this.operand2 = operand2;
	}

	public char getSign() {
		return sign;
	}

	public void setSign(char sign) {
		this.sign = sign;
	}

	public double evaluate() {
		Double result = null;
//		System.out.println("operand1 = " + operand1);
//		System.out.println("operand2 = " + operand2);
		Double left_Operand = Double.parseDouble(operand1);
		Double right_Operand = Double.parseDouble(operand2);
		if (sign == '+') {
			result = left_Operand + right_Operand;
		} else if (sign == '-') {
			result = left_Operand - right_Operand;
		} else if (sign == '*') {
			result = left_Operand * right_Operand;
		} else if (sign == '/') {
			result = left_Operand / right_Operand;
		}
		value = result + "";
		return result;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
