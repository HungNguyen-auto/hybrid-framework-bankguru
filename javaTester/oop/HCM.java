package oop;

public class HCM {
	// chỉ có thể truy cập trong phạm vi class
	private String streetName;

	//Truy cập trong package
	String bridge;
	
	//Truy cập trong package và ngoài package (phải là class con)
	protected String food;
	
	//Truy cập all
	public String market;
	
	public String getMarket() {
		return market;
	}

	public void setMarket(String market) {
		this.market = market;
	}

	protected String getFood() {
		return food;
	}

	protected void setFood(String food) {
		this.food = food;
	}

	String getBridge() {
		return bridge;
	}

	void setBridge(String bridge) {
		this.bridge = bridge;
	}

	private void setStreet(String streetName) {
		this.streetName = streetName;
	}

	private String getStreet() {
		return streetName;
	}

	public static void main(String[] args) {

		HCM hcm = new HCM();

		hcm.setStreet("Quang Trung");

		System.out.println(hcm.getStreet());

		hcm.setStreet("Nguyen Hue");

		System.out.println(hcm.getStreet());

	}
	protected static void clickToLoginButton() {
		
	}
}
