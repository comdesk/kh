package temp8;

public class ArrayCreateByNewExample {
	public static void main(String[] args) {
		int[] arr1 = new int[3];		//배열원소 기본값: 0
		
//		----------------------------------
		
		for(int i = 0; i < 3; i++) {
			//배열의 원소에 접근하기 위해, 인덱스 번호를 사용하는 것을 "인덱싱(Indexing)"이라 부른다.
			System.out.println("arr1[" + i + "]: " + arr1[i]);
		} //for
		
//		----------------------------------
		
		//인덱싱을 이용해서 배열의 원소에 값 설정
		arr1[0] = 10;
		arr1[1] = 20;
		arr1[2] = 30;
		
		for(int i = 0; i < 3; i++) {		//인덱싱을 이용한 배열의 순회(traverse)
			System.out.println("arr1[" + i + "]: " + arr1[i]);
		} //classical for
		
//		----------------------------------
		
		//새로운 배열 생성(타입별 기본값으로 원소 채움)
		double[] arr2 = new double[3];
		
		for(int i = 0; i < 3; i++) {		//인덱싱을 이용한 배열의 순회(traverse)
			System.out.println("arr2[" + i + "]: " + arr2[i]);
		} //classical for
		
//		----------------------------------
		
		arr2[0] = 0.1;
		arr2[1] = 0.2;
		arr2[2] = 0.3;
		
		for(int i = 0; i < 3; i++) {		//인덱싱을 이용한 배열의 순회(traverse)
			System.out.println("arr2[" + i + "]: " + arr2[i]);
		} //classical for
		
//		----------------------------------
		
		String[] arr3 = new String[3];
		
		for(int i = 0; i < 3; i++) {		//인덱싱을 이용한 배열의 순회(traverse)
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		} //classical for
		
//		----------------------------------
		
		arr3[0] = "1월";
		arr3[1] = "2월";
		arr3[2] = "3월";
				
		for(int i = 0; i < 3; i++) {		//인덱싱을 이용한 배열의 순회(traverse)
			System.out.println("arr3[" + i + "]: " + arr3[i]);
		} //classical for
		
//		=================================
		
		//배열을 순회할 때, 배열의 길이(=크기)를 이용해서, 반복횟수를 제한하는 게 골자.
		int[] scores = {83, 90, 87};				//값의 목록으로 배열 리터럴 생성
		
		int[] scores2 = new int[] {83, 90, 87};		//Ditto(상동). But, the above statement preferred.
//		int[] scores3 = new int[3] {83, 90, 87};	//XX: 배열의 크기는 값의 목록으로 자동결정
		
		int sum = 0;
		
		for(int i = 0; i < scores.length; i++) {	//배열변수명.length => 배열의 크기(=길이)
			sum += scores[i];
		} //for
		
		System.out.println("총합: " + sum);
		
		double avg = ((double) sum) / scores.length;
		System.out.println("평균: " + avg);
		
		
	} //main
} //end class






















