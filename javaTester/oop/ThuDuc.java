package oop;

public class ThuDuc {

	public static void main(String[] args) {
		HCM hcm = new HCM();

		hcm.bridge = "Cau Ong Lanh";
		System.out.println(hcm.getBridge());

		hcm.setBridge("Cau Calmet");
		System.out.println(hcm.getBridge());

		hcm.setFood("Banh mi");
		System.out.println(hcm.getFood());

		hcm.clickToLoginButton();
		
		hcm.setMarket("BigC");
		System.out.println(hcm.getMarket());
	}

}
