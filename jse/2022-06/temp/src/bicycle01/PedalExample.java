package bicycle01;

public class PedalExample {
	public static void main(String[] args) {
		Pedal2 pedal = new Pedal2(true, "앞");	//전달인자 값: isStep, direction
		
		pedal.step();
		pedal.run(40);							//전달인자 값: cadence
		
	} //main
} //end class
