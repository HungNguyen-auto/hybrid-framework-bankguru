package carFactory;

public class Honda implements ICar{

	@Override
	public void viewCar() {
		System.out.println("View honda car");
	}

	@Override
	public void driverCar() {
		System.out.println("Drive honda car");
	}

}
