import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class SaveEvent implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		String st = e.getActionCommand();
		if (st.equals("<")) {
			if (Calculator.index >= 0) {
				if (Calculator.index - 1 >= 0&& !Calculator.operation[Calculator.index - 1].getValue().equals("x")) {
					Calculator.index--;
					Calculator.display
							.setText(Calculator.operation[Calculator.index]
									.getOperand1()
									+ Calculator.operation[Calculator.index]
											.getSign()
									+ Calculator.operation[Calculator.index]
											.getOperand2());
					Calculator.resultLabel
							.setText(Calculator.operation[Calculator.index].getValue());
				}
			} else
				return;
		} else if (st.equals(">")) {
			if (Calculator.index < 4) {
				if (Calculator.index + 1 <= 4
						&& !Calculator.operation[Calculator.index + 1]
								.getValue().equals("x")) {
					Calculator.index++;
					Calculator.display
					.setText(Calculator.operation[Calculator.index]
							.getOperand1()
							+ Calculator.operation[Calculator.index]
									.getSign()
							+ Calculator.operation[Calculator.index]
									.getOperand2());
					Calculator.resultLabel
					.setText(Calculator.operation[Calculator.index].getValue());
				}
			} else
				return;
		}
	}
}
