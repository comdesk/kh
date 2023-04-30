// 알고리즘
// 1. List a의 마지막 인덱스의 값과 List b의 첫 번째 인덱스 값의 사이에 있는 List a의 공배수를 구한다.
//	  (a의 모든 원소들의 배수를 각각 구한 다음, 모든 원소에서 공통되는 배수를 공배수라고 한다.)
// 2. 1번에서 구한 공배수에서 List b의 공약수인 수를 구한다.
//	  (b의 모든 원소를 나눴을 때 모든 원소를 나누어 떨어지게 하는 공배수를 구한다.)
// 3. 2번의 값을 반환한다.



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

class Result {

    public static int getTotalX(List<Integer> a, List<Integer> b) {
//    	========================List a의 공배수 구하기===================================
    	List<Integer> multiple = new LinkedList<>();		//모든 공배수를 저장할 리스트를 생성한다.
    	
    	
    	for(Integer aElement : a) {							//a의 모든 원소들의 배수를 각각 구해, 위에서 생성한 리스트에 모두 저장한다.
    		Integer num = 0;
    		
    		for(int i = 1; num < b.get(0); i++) {			//공배수는 a의 마지막 인덱스 값과 b의 첫 번째 인덱스 값 사이에 있는 배수이므로, 배수가 b의 첫 번째 인덱스 값 사이에 해당할 때까지 구해준다.
    			num = aElement * i;											
    			
        		multiple.add(num);							//배수를 리스트에 저장한다.
    		} //inner for
									
    	} //enhanced for
    	
    	Set<Integer> multiDeduplication = new HashSet<>(multiple);		//모든 원소의 배수가 중복되어 들어있으므로 중복을 제거할 Set을 생성한다.
    	
    	
    	for(int i = 0; i < a.size() - 1; i++) {							//공통된 배수를 구해야 하므로 리스트에서 중복된 배수를 구해야 한다. 그러므로 모든 원소들의 배수가 있는 리스트에서 중복이 제거된 Set의 요소들을 제거한다.
    																	//예: List: 1, 2, 3, 3 / Set: 1, 2, 3  => List - Set: 3 (중복된 수)
    		for(Integer multiDepuli : multiDeduplication) {				//그런데 예를 들어, 만약 List a의 원소가 3개일 때, 배수가 2번만 중복되어도 공배수가 될 수 있으므로 3번이 중복될 때 공배수가 되도록 
    			multiple.remove(multiDepuli);							//배수 List에서 배수 Set의 원소들을 2번 제거한다.  
    		} //enhanced for											//예: List: 2, 4, 8 / 3, 6, 9 / 9  Set: 2, 3, 4, 6, 8, 9 => List - Set: 9
        																//=> 배수 List에서 배수 Set의 원소들을 List a의 원소의 개수 - 1번 제거한다
    	} //outer for
    	
//    =====================공배수 중에 List b의 공약수인 수를 구하기==============================	
    	
    	Set<Integer> deleted = new HashSet<>();			//공배수들 중에서 b의 모든 원소를 나누어 떨어지게 하지 못하는 공배수를 저장할 Set을 만든다.
    	
    	
    	for(Integer multi : multiple) {					//b의 원소들을 공배수로 나누었을 때 단 하나의 원소라도 나누어 떨어지게 하지 못하면 Set deleted에 담는다.
    		
    		for(int j = 0; j < b.size(); j++) {
    			
    			if(b.get(j) % multi != 0) {
    				deleted.add(multi);	
    			} //if
    			
    		} //inner for
    		
    	} //outer for
    	
    	multiple.removeAll(deleted);					//공배수들 중 b의 공약수가 아닌 수를 모두 제거한다.
    	
    	System.out.println("Multiple: " + multiple);
    	
    	return multiple.size();							//Between Two sets에 해당하는 수의 개수를 반환한다.

    } //getTotalX

} //end class

public class Practice17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));		

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);	//a 리스트의 capacity 입력

        int m = Integer.parseInt(firstMultipleInput[1]);	//b 리스트의 capacity 입력

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());		//리스트 arr 입력

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());		//리스트 brr 입력

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    } //main
} //end class