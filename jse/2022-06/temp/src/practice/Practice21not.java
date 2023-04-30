package practice;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice21not{
	public static int col = 0;
	public static int row = 0;
	
	//왼쪽, 오른쪽 검사하고 한 칸 밑으로 내려가는 메소드
	public static void moving(List<List<Integer>> ladder) {
			
		if(Practice21not.col > 0 && ladder.get(Practice21not.row).get(Practice21not.col-1) == 1) {
						
			Practice21not.col = Practice21not.col - 2;
			
		} //if (왼쪽 검사)
		
		if(Practice21not.col < (ladder.size()-1) && ladder.get(Practice21not.row).get(Practice21not.col+1) == 1) {
			
			Practice21not.col = Practice21not.col + 2;
		} //if (오른쪽 검사)
		
		if(Practice21not.row < (ladder.size()-1)) {
			Practice21not.row = Practice21not.row + 1;
		} //if (한 칸 밑으로)
	} //moving
	
	public static void main(String args[]) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

	    int m = Integer.parseInt(bufferedReader.readLine().trim());		// 사다리 탈 사람 수 입력 받기

//	    ===============사다리 만들기================
	    
	    List<List<Integer>> ladder = new ArrayList<>();

	    
	    for(int i = 0; i < m * 2 - 1; i++) {
	    	List<Integer> row = new ArrayList<>(10);
	    	
	    	for(int j = 0; j < m * 2 - 1; j++) {
	    		if(j % 2 == 0) {
	    			row.add(1);
	    		} else {
	    			row.add((int)(Math.random() * 2));
			    	if(j > 1) {
			    		if(row.get(j-2) == 1) {
				    		row.set(j, 0);
				    	} //if
			    	} //if	    
	    		} //if-else
	    	} //inner for
	    	ladder.add(row);
	    } //outer for

	    List<List<Integer>> copyLadder = new ArrayList<>();
	    
	    List<Integer> tempRow = new ArrayList<>();
	    
	    for(int i = 0; i < ladder.size(); i++) {
	    	tempRow.add(null);
	    } //for
	    
	    for(int i = 0; i < ladder.size(); i++) {
			   copyLadder.add(tempRow);
	    } //for
	    
		   for(int i = 0; i < ladder.size(); i++) {
			   for(int j = 0; j < ladder.size(); j++) {
				  copyLadder.get(i).set(j, ladder.get(i).get(j)); 
			   } //for
		   } //for
		for(List<Integer> rows : ladder) {
	    	System.out.println(Arrays.toString(rows.toArray()));
	    } //enhanced for
		
		for(List<Integer> rows : copyLadder) {
	    	System.out.println(Arrays.toString(rows.toArray()));
	    } //enhanced for
		
//	    ===============사다리 타기================
	   for(int i = 0; i < ladder.size(); i += 2 ) {
		   Practice21not.col = 0;
		   Practice21not.row = 0;
		   
		   col = col + i;
		   
		   for(int j = 0; j < ladder.size(); j++) {
			   Practice21not.moving(ladder);
		   } //inner for
		   
		   System.out.println(i + " 도착: " + Practice21not.col);
	   } //outer for
	    
	    
	   
	   
	   

	    
	    
	    
//	    for(List<Integer> rows : ladder) {
//	    	System.out.println(Arrays.toString(rows.toArray()));
//	    } //enhanced for
	    
	    
	} //main
	
	
} //end class
