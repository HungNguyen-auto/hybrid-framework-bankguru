package carFactory;

public class CarFactory {
	public void viewCarByType(String carTypeName) {
		switch (carTypeName) {
		case "Honda":
			Honda honda = new Honda();
			honda.viewCar();
			break;
		case "Toyota":
			Toyota toyota = new Toyota();
			toyota.viewCar();
			break;
		case "Kia":
			Kia kia = new Kia();
			kia.viewCar();
			break;
		default:
			break;
		}
	}
}
