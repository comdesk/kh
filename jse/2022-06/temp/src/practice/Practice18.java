//알고리즘
//1. n: 강의의 정원, k: 강의를 시작하기 위한 최소의 인원, a: 학생들의 도착시간
//2. 학생들의 도착시간이 0보다 같거나 작으면 정시 도착, 0보다 크면 지각
//3. 정시에 도착한 학생 수가 강의 시작을 위한 최소 인원보다 적으면 수업을 취소한다.


package practice;

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

class Result1 {

    
    public static String angryProfessor(int k, List<Integer> a) {	
    int count = 0;

    for(Integer i : a) {	//강의의 정원만큼 반복하면서, 리스트(List a)의 원소가 0보다 같거나 작으면 카운터 변수에 저장한다.
        if(i <= 0) {
           count++;
        }
    } //enhanced for

    
    if(count >= k) {		//카운터 변수가 최소 인원(int k)보다 같거나 크면 수업을 취소하지 않으므로 NO, 
        return "NO";		//작으면 수업을 취소하므로 YES를 출력한다.
    } else {
        return "YES";
    } //if-else
    
    } //angryProfessor

} //end class

public class Practice18 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int k = Integer.parseInt(firstMultipleInput[1]);

                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                    .map(Integer::parseInt)
                    .collect(toList());

                String result = Result1.angryProfessor(k, a);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}