package temp7;

public class ArrayCreateByValueListExample1 {
	public static void main(String[] args) {
		//1. 값의 목록을 가지고, 배열 객체 생성: 이때는, 중괄호 기호({})를 사용한다.
		//배열의 크기(=길이): 배열 안에 들어있는 요소의 개수
		int[] scores = {83, 90, 87};
		
		//2. 특정 배열의 원소(=요소)에 접근하여 사용
		System.out.println("scores[0]: " + scores[0]);
		System.out.println("scores[1]: " + scores[1]);
		System.out.println("scores[2]: " + scores[2]);
		
		//3. 배열의 순회(Traverse)
		int sum = 0;
		for(int index = 0; index < scores.length; index++) {	//.length: 배열의 길이
			sum += scores[index];			//복합대입연산자: +=
		} //for
		
		//4. 배열에 있는 데이터를 이용하여, 새로운 정보 생성
		System.out.println("총합: " + sum);
		double avg = (double) sum / 3;
		System.out.println("평균: " + avg);
	} //main
} //end class
