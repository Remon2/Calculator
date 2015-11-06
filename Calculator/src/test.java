

public class test {
	static String operand1 = "";
	static String operand2 = "";
	static char sign = ' ';

	public static void convert(String expression) {
		char[] exp = expression.toCharArray();
		int temp = 0;
		boolean flag = true;
		if (exp[0] == '-') {
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
		sign = exp[temp];
		temp++;
		if (exp[temp] == '-') {
			operand2 = "-";
			temp++;
		} else if (exp[temp] == '+') {
			temp++;
		}
		for (int i = temp; i < exp.length; i++) {
			operand2 += exp[i];
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
		operator = arr[temp];
		temp++;
		if (arr[temp] == '-') {
			num2 = "-";
			temp++;
		} else if (arr[temp] == '+') {
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

	public static void main(String[] args) {
		String st = "556.9*+96.5+54";
		System.out.println(isValid(st));
		if (isValid(st))
			convert(st);
		System.out.println(operand1);
		System.out.println(sign);
		System.out.println(operand2);

		// System.out.println(st.replace(y+x+"", ""));
	}
}
