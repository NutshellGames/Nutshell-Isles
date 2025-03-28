public class Main
{
	public static void main(String[] args) {
		Format.printLogo("brown");

		Unit unit = Data.createPremadeUnit(0);
		Status burn = Data.createPremadeStatus(4);

		System.out.println(burn);

		unit.addStatus(burn);
		System.out.println(unit);

		unit.tickAllStatuses();
		System.out.println(burn);

		Utils.blankInput();

		unit.tickAllStatuses();
		System.out.println(burn);

		Utils.blankInput();

		unit.tickAllStatuses();
		System.out.println(burn);

		Utils.blankInput();

		System.out.println(unit);

		Utils.blankInput();
	}
}
