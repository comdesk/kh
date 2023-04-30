package temp7;

public class ArrayExample2 {
	//배열의 대전제: 자바의  배열은 한 번 생성하면 ,그 크기와 원소(=요소)의 타입을 절대 바꿀 수 없다.
	public static void main(String[] args) {
		//1. 값의 목록으로 배열객체 생성
		//배열 변수의 선언과 정의를 구분
//		int scores[];	//보통 타입명 뒤에 배열타입 붙임.
		int[] scores;
		scores = new int[] {83, 90, 97};		//배열변수의 선언과 초기화를 하나의 실행문장에서 같이 한다면 중괄호만으로 가능하지만,
//		scores = {83, 90, 97};					//선언과 초기화를 구분한다면 new 연산자를 써야 함.
												//new 연산자는 클래스 생성자를 호출하는 것처럼 배열의 생성자 int[]를 호출해야 함.
		
		System.out.println("scores: " + scores);	//scores: [I@5ca881b5  [:배열, I: int
		
//		---
		
		//2. 배열의 순회(traverse)를 이용한, 배열의 모든 원소의 총합을 구하자
		int sum1 = 0;
		
		for(int index = 0; index < scores.length; index++) {	//.length: 배열의 길이
			sum1 += scores[index];	//복합대입연산자: +=
		} //for
		System.out.println("총합: " + sum1);
		
//		---
		
		//떨어져 있는 배열변수에 배열객체를 만들어 초기화 하려면,
		//아래와 같이, 반드시 new 연산자(객체생성연산자)와 배열생성자기호(type[])를 이용하여,
		//배열객체를 생성해야 한다. (***)
		int sum2 = add(new int[] {83, 90, 87});		//선언과 초기화를 구분한다면 new 연산자와 생성자를 써야 함.
//		int sum2 = add({83, 90, 87});				//{83, 90, 87}: 배열 리터럴 //xx: 배열변수의 선언과 초기화 분리
//		int sum2 = add(83, 90, 87);
		
		System.out.println("총합: " + sum2);
		System.out.println();
	} //main
	
	//(1) add 메소드: int[] scores 배열변수 선언
	//add 메소드를 호출하려면 배열변수에 값을 집어 넣어달라.
	
	//배열 객체를 받아서, 배열을 순회하여, 배열원소의 총합을 구해주는 "메소드"
	//"메소드": 객체의 행위(=기능), 예: 사랑 - 걷다/뛰다/자다 등등의 행위
	public static int add(int[] scores) {
//	public static int add(int score1, int score2, int score3) {
		int sum = 0;
		for(int i = 0; i < 3; i++) {
			sum += scores[i];
		} //for
		return sum;
	} //add
	
} //end class








