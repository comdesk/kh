package temp8;

public class AdvancedForExample {
	
	//자바언어에서는 2가지의 For문이 있다
	//(1) Classical For문 (자바초기버전부터 있었던 반복문)
	//(2) Enhanced For문 (배열같은, 여러 데이터를 가진 자료구조를 순회하는 데 특화됨)
	public static void main(String[] args) {
		int[] scores = {95, 71, 84, 93, 87};		//1-D array
		
		int sum = 0;								//배열원소의 총합 저장
		
		for(int score : scores) {
			sum = sum + score;
		} //enhanced for
		
		System.out.println("점수 총합 = " + sum);
		
		double avg = (double) sum / scores.length;	//평균 구하기
		System.out.println("점수 평균 = " + avg);

	}//main
}//end class
