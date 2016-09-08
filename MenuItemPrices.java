package net.menuItems;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class MenuItemPrices {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File menuFile=new File("menu.txt");
		File menuFilePrice=new File("menuPrice.txt");
		Scanner inputFromFile=null;
		Scanner inputFromUser=null;
		PrintWriter writeTo=null;
		double tempPrice=.0;
		String food=null;
		try{
			inputFromFile = new Scanner(menuFile);
			inputFromUser=new Scanner(System.in);
		}catch(Exception e){
			System.err.println("Trouble with input getting the menu file. "+e.toString());
		}
		try {
			writeTo=new PrintWriter(menuFilePrice);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		while(inputFromFile.hasNextLine()){
			food=inputFromFile.nextLine();
			System.out.printf("Please enter price for %s: ",food);
			tempPrice=inputFromUser.nextDouble();
			writeTo.printf("%s\t$%.2f\n",food,tempPrice);
			food=null;
			tempPrice=.0;
		}
		inputFromFile.close();
		inputFromUser.close();
		writeTo.close();
	}
}
