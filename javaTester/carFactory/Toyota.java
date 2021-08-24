package carFactory;

public class Toyota implements ICar{

	@Override
	public void viewCar() {
		System.out.println("View Toyota car");
	}

	@Override
	public void driverCar() {
		System.out.println("Drive Toyota car");
	}

}
