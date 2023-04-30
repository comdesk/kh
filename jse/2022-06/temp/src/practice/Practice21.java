package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Practice21{
	   //현재 위치
	   public static int col = 0;
	   public static int row = 0;
	   
	   
	   //왼쪽, 오른쪽 검사하고 한 칸 밑으로 내려가는 메소드
	   public static void moving(List<List<Integer>> ladder) {
	      
	     boolean isLeft = false;		// 왼쪽 검사가 실행됐는지 알려주는 플래그 변수
	      
	      if(Practice21.col > 0 && ladder.get(Practice21.row).get(Practice21.col-1) == 1) {
	         
	         Practice21.col = Practice21.col - 2;
	         
	         isLeft = true;				// 왼쪽 검사가 실행됐다면 true.
	         
	      } //if (왼쪽 검사)
	      
	      if(Practice21.col < (ladder.size()-1) && isLeft != true && ladder.get(Practice21.row).get(Practice21.col+1) == 1) {
	    	  				  					  //왼쪽 검사가 실행되지 않았을 때 오른쪽 검사 실행
	         Practice21.col = Practice21.col + 2;
	         
	      } //if (오른쪽 검사)
	      
	      if(Practice21.row < (ladder.size()-1)) {
	    	  
	         Practice21.row = Practice21.row + 1;
	         
	      } //if (한 칸 밑으로)
	   } //moving
	   
	   public static void main(String args[]) throws IOException {
		   
	       BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	       BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
	       
	       System.out.print("사다리게임 Player 수: ");
	       int m = Integer.parseInt(bufferedReader.readLine().trim());    // 사다리 탈 사람 수 입력 받기

//	       ===============사다리 만들기================
	       
	       List<List<Integer>> ladder = new ArrayList<>();	// 사다리를 2차원 리스트로 만든다.

	       
	       for(int i = 0; i < m + m - 1; i++) {				// m + m - 1인 정방행렬을 만든다.
	          List<Integer> row = new ArrayList<>();		// 리스트의 한 행을 만든다.
	          
	          for(int j = 0; j < m + m - 1; j++) {			
	             if(j % 2 == 0) {							// 짝수열(라인)의 값은 무조건 1
	                row.add(1);
	             } else {
	                row.add((int)(Math.random() * 2));		// 홀수열(가로선)의 값은 랜덤으로 넣는다.
	                if(j > 1) {								
	                   if(row.get(j-2) == 1) {				// 바로 전 홀수열(가로선)과의 합은 1이하여야 한다.
	                      row.set(j, 0);
	                   } //if
	                } //if       
	             } //if-else
	          } //inner for
	          
	          ladder.add(row);								// 2차원 리스트의 행으로 넣는다.
	          
	       } //outer for
	       
	       for(List<Integer> rows : ladder) {				// 사다리 출력
		    	System.out.println(Arrays.toString(rows.toArray()));
		   } //enhanced for
	       System.out.println("");
	       
//	       ===============사다리 타기================
	       
	      for(int i = 0; i < ladder.size(); i += 2 ) {	   // 라인 순서대로 실행한다. 항상 짝수열(라인)의 첫 행에서 시작 
	         Practice21.col = 0;
	         Practice21.row = 0;
	         
	         col = col + i;
	         
	         for(int j = 0; j < ladder.size(); j++) {
	            Practice21.moving(ladder);
	         } //inner for
	         
	         System.out.println(i/2+1 + "player 도착: " + ((Practice21.col/2)+1) + "번");
	      } //outer for
	       	   
	} //main
} //end class


