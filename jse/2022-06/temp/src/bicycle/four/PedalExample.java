package bicycle.four;

public class PedalExample {
	public static void main(String[] args) {
		
		
		MyPedal pedal = new MyPedal(1000);
		GearBox gear = new GearBox(1);
		
		Bicycle bike = new Bicycle(gear, pedal);
		
		gear.setBicycle(bike);
		pedal.setBicycle(bike);
		
		pedal.press("뒤");
		
		pedal.setSpeed(100);
		
		for(int i = 1; i <= 3; i++) {
			pedal.roll();
		}
		
	} //main
} //end class
