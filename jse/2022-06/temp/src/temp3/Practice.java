package temp3;

//1. 동굴 높이를 측정한다 => 100m
//2. 하루에 올라갈 수 있는 최대 거리 측정 => 20m
//3. 하루에 미끄러지는 높이 => 5m
//4. 동굴을 올라간다.
//5. 올라간 총 높이와 동굴의 높이를 비교한다.
//6. 올라간 총 높이 보다 동굴의 높이가 적다면 잠을 잔다.
//7. 4,5,6번의 과정을 반복하다가 현재 올라간 총 높이가 동굴의 높이를 초과하면 동굴을 빠져나온다. (올라간 높이 > 동굴 높이)
//8. 빠져나오는 데까지 걸린 일수를 확인한다.

public class Practice {
	public static void main(String[] args) {

		int depth = 100; // 동굴 높이
		int climbing = 20; // 하루에 올라갈 수 있는 높이
		int sliding = 5; // 하루에 미끄러지는 높이

		int sum = 0; // 총 올라간 높이
		int day = 0; // 일수

		for (day = 1; ; day++) {

			sum = sum + climbing; // 하루에 올라가는 높이
			if (sum < depth) { // 올라간 총 높이 보다 동굴의 높이가 더 높다면 잠을 잔다. 
				sum = sum - sliding; // 자는 동안 손실되는 높이 측정
				System.out.println(day + "일째 " + sum + "m 등반");

			} else { // 현재 올라간 총 높이가 동굴의 높이를 초과하면 동굴을 빠져나온다.
				System.out.println();
				System.out.println(day + "일째 탈출");
				break;
			} // if-else
		} // for
	} // main
} // end class
