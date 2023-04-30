package temp9;

import java.util.Arrays;

public class Practice5 {
	public static void main(String[] args) {
		int[] yoseph = {100, 70, 80};
		int[] trinity = {87, 67, 77};
		int[] pyramid = {77, 97, 100};
		
		int[][] scores = {yoseph, trinity, pyramid};
		
		int ysum = 0;
		//yoseph의 총합 구하기
		for(int score1 : yoseph) {
			ysum += score1;
		} //for
		System.out.println("yoseph 총합: " + ysum);
		
		//yoseph의 평균구하기
		double yavg = (double) ysum / (yoseph.length); 
		System.out.println("yoseph 평균: " + yavg);
		
		int tsum = 0;
		//trinity의 총합구하기
		for(int score2 : trinity) {
			tsum += score2;
		} //for
		System.out.println("trinity 총합: " + tsum);
		
		//trinity의 평균 구하기
		double tavg = (double) tsum / trinity.length;
		System.out.println("trinity의 평균: " + tavg);
		
		int psum = 0;
		//Pyramid의 총합 구하기
		for(int score3 : pyramid) {
			psum += score3;
		} //for
		System.out.println("Pyramid 총합: " + psum);
		
		//Pyramid의 평균 구하기
		double pavg = (double) psum / pyramid.length;
		System.out.println("Pyramid의 평균: " + pavg);
			
		if(ysum > tsum) {
			if(ysum > psum) {
				System.out.println("최대총합: yoseph");
			} else {
				System.out.println("최대총합: pyramid");
			} //if-else
		} else {
			if(tsum > psum) {
				System.out.println("최대총합: trinity");
			} else {
				System.out.println("최대총합: pyramid");
			}
		}
		
		if(yavg < tavg) {
			if(yavg < pavg) {
				System.out.println("최소평균: yoseph");
			} else {
				System.out.println("최소평균: pyramid");
			} //if-else
		} else {
			if(tavg < pavg) {
				System.out.println("최소평균: trinity");
			} else {
				System.out.println("최소평균: pyramid");
			}
		}
		
	} //main
} //end class









