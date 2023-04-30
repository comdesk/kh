package temp9;

public class Practice5_1 {
	public static void main(String[] args) {
		int[] yoseph = {100, 70, 80};      
		int[] trinity = {87, 67, 77};      
		int[] pyramid = {77, 97, 100};            
		int [][]scores = { yoseph , trinity, pyramid };            
		int sum;      
		int yosephTotal = 0;      
		int trinityTotal = 0;      
		int pyramidTotal = 0;
		double yosephAvg = 0.0;
		double trinityAvg = 0.0;
		double pyramidAvg = 0.0;
		
		//총합 구하기
		for (int i = 0; i < scores.length;i++) {         
			sum = 0;         
			for(int j = 0; j < 3; j++) {                        
				sum += scores[i][j];                        
				if(i == 0) {               
					if(j == 2) {                  
						yosephTotal = sum;                  
						break;
						} 
					}                              
				else if(i == 1) {               
					if(j == 2) {                  
						trinityTotal = sum;}
					}                               
				else if(i == 2) {               
					if(j == 2) {                  
						pyramidTotal = sum;}
					}                                 
				}//inner for               
			}//outer for 
		
		//평균구하기
		yosephAvg = (double) yosephTotal/yoseph.length;
		trinityAvg = (double)trinityTotal/trinity.length;
		pyramidAvg = (double) pyramidTotal/pyramid.length;
		
		//총합, 평균 출력
		System.out.println("yoseph의 총합 : " + yosephTotal + "  yoseph의 평균 :" + yosephAvg);      
		System.out.println("trinity의 총합 : " + trinityTotal + "  trinity의 평균 :" + trinityAvg);      
		System.out.println("pyramid의 총합 : " + pyramidTotal + "  pyramid의 평균 :" + pyramidAvg);
		
		//총합 비교하기
		if(yosephTotal > trinityTotal) {
			if(yosephTotal > pyramidTotal) {
				System.out.println("최대총합: yoseph");
			} else {
				System.out.println("최대총합: pyramid");
			} //if-else
		} else {
			if(trinityTotal > pyramidTotal) {
				System.out.println("최대총합: trinity");
			} else {
				System.out.println("최대총합: pyramid");
			}
		}
		
		//평균 비교하기
		if(yosephAvg < trinityAvg) {
			if(yosephAvg < pyramidAvg) {
				System.out.println("최소평균: yoseph");
			} else {
				System.out.println("최소평균: pyramid");
			} //if-else
		} else {
			if(trinityAvg < pyramidAvg) {
				System.out.println("최소평균: trinity");
			} else {
				System.out.println("최소평균: pyramid");
			}
		}
	} //main
} //end class
