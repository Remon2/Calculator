import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoardListener implements KeyListener {

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode = e.getKeyCode();
		switch (keyCode) {
		case KeyEvent.VK_EQUALS:
			Calculator.equal.doClick();
//			Calculator.display.setText(Calculator.result);
			break;

		case 10:
			Calculator.equal.doClick();
//			Calculator.display.setText(Calculator.result);
			break;
		case KeyEvent.VK_0:
			Calculator.zero.doClick();
			return;
		case KeyEvent.VK_NUMPAD0:
			Calculator.zero.doClick();
			return;
		case KeyEvent.VK_1:
			Calculator.one.doClick();
			return;
		case KeyEvent.VK_NUMPAD1:
			Calculator.one.doClick();
			return;
		case KeyEvent.VK_2:
			Calculator.two.doClick();
			return;

		case KeyEvent.VK_NUMPAD2:
			Calculator.two.doClick();
			return;
		case KeyEvent.VK_3:
			Calculator.three.doClick();
			return;
		case KeyEvent.VK_NUMPAD3:
			Calculator.three.doClick();
			return;
		case KeyEvent.VK_4:
			Calculator.four.doClick();
			return;
		case KeyEvent.VK_NUMPAD4:
			Calculator.four.doClick();
			return;
		case KeyEvent.VK_5:
			Calculator.five.doClick();
			return;
		case KeyEvent.VK_NUMPAD5:
			Calculator.five.doClick();
			return;
		case KeyEvent.VK_6:
			Calculator.six.doClick();
			return;
		case KeyEvent.VK_NUMPAD6:
			Calculator.six.doClick();
			return;

		case KeyEvent.VK_7:
			Calculator.seven.doClick();
			return;
		case KeyEvent.VK_NUMPAD7:
			Calculator.seven.doClick();
			return;
		case KeyEvent.VK_8:
			Calculator.eight.doClick();
			return;
		case KeyEvent.VK_NUMPAD8:
			Calculator.eight.doClick();
			return;
		case KeyEvent.VK_9:
			Calculator.nine.doClick();
			return;
		case KeyEvent.VK_NUMPAD9:
			Calculator.nine.doClick();
			return;

		case KeyEvent.VK_ADD:
			Calculator.plus.doClick();
			return;

		case KeyEvent.VK_MINUS:
			Calculator.minus.doClick();
			return;

		case 109:
			Calculator.minus.doClick();
			return;
		case KeyEvent.VK_MULTIPLY:
			Calculator.multiply.doClick();
			return;

		case KeyEvent.VK_DIVIDE:
			Calculator.divide.doClick();
			return;

		case KeyEvent.VK_CLOSE_BRACKET:
			Calculator.close_Bracket.doClick();
			return;

		case KeyEvent.VK_OPEN_BRACKET:
			Calculator.open_Bracket.doClick();
			return;

		case 110:
			Calculator.decimal.doClick();
			return;

		case 46:
			Calculator.decimal.doClick();
			return;

		case 67:
			Calculator.clear.doClick();
			return;

		case 127:
			Calculator.delete.doClick();
			return;

		case 8:
			Calculator.delete.doClick();
			return;
		case 27:
			System.exit(0);
			return;
		case 37:
			Calculator.prev.doClick();
			return;

		case 39:
			Calculator.next.doClick();
			return;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

}
