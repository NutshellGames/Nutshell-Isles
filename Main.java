public class Main
{
	public static void main(String[] args) {
		Format.printLogo("brown");

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
		    System.out.println(Data.getItems().get(i));
		}
	}
}
