//1. 하루에 20m를 올라갔을 때 올라간 총 높이가 100m 미만이면 5m를 내려간 후 반복하고, 100m 초과이면 동굴을 빠져나온다.
//2. 변수
//	1. 내가 올라간 총 높이: int rise
//	2. 동굴 깊이: int depth = 100;
//	3. 일 수: i
//	4. 하루 동안 올라간 높이: int dayUp = 20;
//	5. 하루에 미끄러진 높이: int dayDown = 5;
//3. 필요한 제어문: if문, for문

public class TTTTTT {
	public static void main(String[] args) {
		
		int depth = 100;
		int rise = 0;
		int dayUp = 20;
		int dayDown = 5;
		
		for(int i = 1; ;i++) {
			rise = rise + dayUp;
			if(rise < depth) {
				rise = rise - dayDown;
			} else {
				System.out.println("탈출 일 수: " + i + "일째");
				break;
			}
		}

	} //main
} //end class
