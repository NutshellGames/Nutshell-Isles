/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
public class Main
{
	public static void main(String[] args) {
		printLogo();
		
		System.out.println("\u001B[1;31m\u2606\u001B[0m Common");
		
		Utils.blankInput();
		
		Unit testDummy = Data.createPremadeUnit(0);
		Items SmallExpBoost = Data.createPremadeItem(0);
		Items MediumExpBoost = Data.createPremadeItem(1);
		Items LargeExpBoost = Data.createPremadeItem(2);
		
		testDummy.gainExp(20000);
		
		System.out.println(testDummy);
		
		SmallExpBoost.equip(testDummy);
		
		testDummy.gainExp(20000);
		
		System.out.println(testDummy);
		
		testDummy.setLevel(1);
		
		MediumExpBoost.equip(testDummy);
		
		testDummy.gainExp(20000);
		
		System.out.println(testDummy);
		
		testDummy.setLevel(1);
		
		LargeExpBoost.equip(testDummy);
		
		testDummy.gainExp(20000);
		
		System.out.println(testDummy);
		
		for (int i = 0; i < Data.getItems().size(); i++) {
		    System.out.println(Data.getItems().get(i).getName());
		}
	}
	
	static void printLogo() {
	    System.out.println(" /$$   /$$             /$$              /$$                 /$$ /$$       /$$$$$$           /$$                    ");
		System.out.println("| $$$ | $$            | $$             | $$                | $$| $$      |_  $$_/          | $$                    ");
		System.out.println("| $$$$| $$ /$$   /$$ /$$$$$$   /$$$$$$$| $$$$$$$   /$$$$$$ | $$| $$        | $$    /$$$$$$$| $$  /$$$$$$   /$$$$$$$");
		System.out.println("| $$ $$ $$| $$  | $$|_  $$_/  /$$_____/| $$__  $$ /$$__  $$| $$| $$        | $$   /$$_____/| $$ /$$__  $$ /$$_____/");
		System.out.println("| $$  $$$$| $$  | $$  | $$   |  $$$$$$ | $$  \\ $$| $$$$$$$$| $$| $$        | $$  |  $$$$$$ | $$| $$$$$$$$|  $$$$$$ ");
		System.out.println("| $$\\  $$$| $$  | $$  | $$ /$$\\____  $$| $$  | $$| $$_____/| $$| $$        | $$   \\____  $$| $$| $$_____/ \\____  $$");
		System.out.println("| $$ \\  $$|  $$$$$$/  |  $$$$//$$$$$$$/| $$  | $$|  $$$$$$$| $$| $$       /$$$$$$ /$$$$$$$/| $$|  $$$$$$$ /$$$$$$$/");
		System.out.println("|__/  \\__/ \\______/    \\___/ |_______/ |__/  |__/ \\_______/|__/|__/      |______/|_______/ |__/ \\_______/|_______/ ");
	}
}
