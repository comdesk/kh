
public class App10 {
	public static void main(String[] args) {
		
		int depth = 100; //동굴 깊이
		int rise = 0;	 //총 올라간 높이
		int dayUp = 20;	 //하루에 올라가는 높이
		int dayDown = 5; //하루에 미끄러지는 높이
		int day = 0;	 //일 수
		
		for(day = 1;  ; day++) {
			rise = rise + dayUp;
			if(rise < depth) {
				rise = rise - dayDown;
				System.out.println(day + "일 째 " + "올라간 높이: " + rise + "m => 탈출 불가");
			} else {
				System.out.println(day + "일 째 " + "올라간 높이: " + rise + "m => 탈출 성공");
				System.out.println("==== " + day + "일 째 탈출 성공 ====");
				break;
			} //if-else
		} //for
	} //main
} //end class
