package a.b.c;

//알고리즘
//
//int h: 시
//
//int m: 분
//
//1≤h≤12
//0≤m<60

//1. m이 0일 때 o’ clock으로 변환
//2. 1≤ m ≤ 30일 때 m + past + h로 변환
//3. m >30 일 때 60-m + to + h로 변환
//
//*주의: 15,45는 quarter, 30은 half로 표현


//
//1. 시와 분을 입력받는다.
//2. “시”의 배열로, 시의 범위인 1부터 12까지에 해당하는 영어 문자의 배열을 만든다.
//3. “분”의 배열로, 분의 범위의 절반인 1부터 30까지에 해당하는 영어 문자의 배열을 만든다. (문제에서 분을 영어문자로 변환할 때 1≤minutes≤30만 변환하라고 요구했기 때문에)
//4. 전달인자 h의 정수값에 해당하는 시 문자배열의 인덱스와 전달인자 m의 정수값에 해당하는 분 문자배열의 인덱스의 값으로 시간에 대한 문자열을 생성하되, 분의 범위에 따라 생성한다.
//    1. m==0일 때, h-1 + m 형식의 문자열을 생성한다.
//    2. 1≤ m ≤ 30일 때 past + m + h-1로 생성한다.
//    3. m >30 일 때 60-m + to + h로 생성한다.
//5. 4에서 생성한 문자열을 리턴하고 출력한다.

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    public static String timeInWords(int h, int m) {
    	String[] hours = {"one", "two", "three", "four", "five", "six", 
    			"seven", "eight", "nine", "ten", "eleven", "twelve"};		//“시”의 배열로, 시의 범위인 1부터 12까지에 해당하는 영어 문자의 배열을 만든다.
    	
    	String[] minutes = {"o' clock", "one minute", "two minutes", "three minutes", "four minutes", "five minutes",
    		"six minutes", "seven minutes", "eight minutes", "nine minutes", "ten minutes", "eleven minutes",
    		"twelve minutes", "thirteen minutes", "fourteen minutes", "quarter", "sixteen minutes", "seventeen minutes",
    		"eighteen minutes", "nineteen minutes", "twenty minutes", "twenty one minutes", "twenty two minutes",
    		"twenty three minutes", "twenty four minutes", "twenty five minutes", "twenty six minutes", "twenty seven minutes",
    		"twenty eight minutes", "twenty nine minutes", "half"};			//“분”의 배열로, 분의 범위의 절반인 1부터 30까지에 해당하는 영어 문자의 배열을 만든다.
    	
    	String time = "";
    	
//    	전달인자 h의 정수값에 해당하는 시 문자배열의 인덱스와 전달인자 m의 정수값에 해당하는 
//    	분 문자배열의 인덱스의 값으로 시간에 대한 문자열을 생성하되, 분의 범위에 따라 생성한다.
    	if(m == 0) {
    		time = String.format("%s %s", hours[h-1], minutes[m]);	//m==0일 때, h-1 + m 형식의 문자열을 생성한다.
    	} else if(m >= 1 && m <= 30) {
//    		time = "%s past %s".formatted(minutes[m], hours[h-1]);
    		time = String.format("%s past %s", minutes[m], hours[h-1]);	//1≤ m ≤ 30일 때 past + m + h-1로 생성한다.
    	} else {
    		time = String.format("%s to %s", minutes[60-m], hours[h]);		//m >30 일 때 60-m + to + h로 생성한다.
    	} //if-else if-else
    	
    	return time;	//위에서 생성한 문자열을 리턴한다.

    } //timeInWords

} //end class

public class Practice16 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Temp/Practice16.dat"));

        int h = Integer.parseInt(bufferedReader.readLine().trim());		//시를 입력받는다.
        
        int m = Integer.parseInt(bufferedReader.readLine().trim());		//분을 입력받는다.

        String result = Result.timeInWords(h, m);

        bufferedWriter.write(result);	//문자열을 출력한다.
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    } //main
} //end class

