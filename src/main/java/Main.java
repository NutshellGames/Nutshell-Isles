public class Main
{
	public static void main(String[] args) {
		Format.printLogo("brown");

		Utils.blankInput();
		
		Unit testDummy = Data.createPremadeUnit(0);
		Items SmallExpBoost = Data.createPremadeItem(0);
		Items MediumExpBoost = Data.createPremadeItem(1);
		Items LargeExpBoost = Data.createPremadeItem(2);

		testDummy.equipItem(SmallExpBoost);

		Data.addToParty(testDummy);
		Data.addItem(SmallExpBoost);
		Data.addItem(MediumExpBoost);
		Data.addItem(LargeExpBoost);

		for (int i = 0; i < 11; i++) {
		    Data.saveData("file " + i);
			Utils.pause(1);
		}
		

		for (int i = 0; i < Data.getParty().size(); i++) {
		    System.out.println(Data.getParty().get(i));
		}
		System.out.println("\n\n");
		
		for (int i = 0; i < Data.getItems().size(); i++) {
		    System.out.println(Data.getItems().get(i));
		}
	}
}
