package lottoNumbers;

import java.awt.AWTException;

public class LottoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindNumbers findNumbers = new FindNumbers();
		findNumbers.displayLottoNumbers();
		findNumbers.clearConsole();
		try {
			findNumbers.wipeConsole();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
