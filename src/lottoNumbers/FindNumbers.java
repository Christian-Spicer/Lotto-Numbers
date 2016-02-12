package lottoNumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class FindNumbers {

	Random randomNumber;
	ArrayList<Integer> lottoNumberArray = new ArrayList<>();
	final int maxNumber = 40;
	String[] alphabet = {"A", "B", "C", "D", "E", "F", "G", "H", "J", "K", "L", "M"};
	int amountOfLines = 0;
	
	public int randomNumber() {
		randomNumber = new Random();
		int number = randomNumber.nextInt(maxNumber);
		return number + 1;
	}
	public void checkNumberIsUnique(){
		while (lottoNumberArray.size() < 6) {
		    int random = randomNumber();
		    if (!lottoNumberArray.contains(random)) {
		    	lottoNumberArray.add(random);
		    }
		}
	}
	public void displayLottoNumbers(){
		Scanner sc = new Scanner(System.in);
		String again = "Y";
		while (again.contains("Y")){
			while (amountOfLines < 6 || amountOfLines > 12){
				System.out.print("Please choose The amount of lotto line between (6 - 12): ");
				amountOfLines = sc.nextInt();
			}
			System.out.println("\n\t\t===========================================");
			System.out.println("\t\t\t\tLotto Numbers");
			System.out.println("\t\t===========================================\n");
			for(int i = 0; i <= amountOfLines -1; i++){
				checkNumberIsUnique();
				Collections.sort(lottoNumberArray);
				System.out.printf("\t\t    Line %s:\t %2d  %2d  %2d  %2d  %2d  %2d\n\n", alphabet[i], lottoNumberArray.get(0), lottoNumberArray.get(1), lottoNumberArray.get(2), lottoNumberArray.get(3), lottoNumberArray.get(4), lottoNumberArray.get(5));
				lottoNumberArray.clear();
			}
			System.out.println("\t\t===========================================");
			amountOfLines = 0;
			System.out.print("Do you want to pick lotto numbers again? (y for Yes or n for No): ");
			again = sc.next().toUpperCase();
		}
		sc.close();
	}
	public final void clearConsole()
	{
	    try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }
	}
	public void wipeConsole() throws AWTException{
		Robot robbie = new Robot();
		//shows the Console View
		robbie.keyPress(KeyEvent.VK_ALT);
		robbie.keyPress(KeyEvent.VK_SHIFT);
		robbie.keyPress(KeyEvent.VK_Q);
		robbie.keyRelease(KeyEvent.VK_ALT);
		robbie.keyPress(KeyEvent.VK_SHIFT);
		robbie.keyPress(KeyEvent.VK_Q);
		robbie.keyPress(KeyEvent.VK_C);
		robbie.keyRelease(KeyEvent.VK_C);
		
		//clears the console
		robbie.keyPress(KeyEvent.VK_SHIFT);
		robbie.keyPress(KeyEvent.VK_F10);
		robbie.keyRelease(KeyEvent.VK_SHIFT);
		robbie.keyRelease(KeyEvent.VK_F10);
		robbie.keyPress(KeyEvent.VK_R);
		robbie.keyRelease(KeyEvent.VK_R);
	}
}
