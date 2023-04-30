// getTotalX 메소드에 대한 알고리즘
// 1. 배열 b의 각각의 원소의 약수를 구한다.
//    (원소를 1부터 원소값까지 나눴을 때, 나머지가 0이면 나누는 수를 약수라고 한다.)
// 2. 1에서 구한 약수들을 List에 저장한다.
// 3. 모든 원소의 약수들에 공통으로 해당되는 수를 찾는다.
//    (List와 Set을 이용하여 중복되는 수 찾기)
// 4. 3번의 수들을 배열 a의 각각의 원소로 나누었을 때 모두 나누어 떨어지는 수의 개수를 반환한다.

package a.b.c;
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

    public static int getTotalX(List<Integer> a, List<Integer> b) {
    	List<Integer> bDivisior = new LinkedList<>();	//List b의 약수들을 저장할 List를 생성한다.
    	
    	for(int i = 0; i < b.size(); i++) {				//List b의 원소를 1부터 원소값까지 나눴을 때, 나머지가 0이면 나누는 수를 약수라고 하고, 모든 원소들에 대한 약수를 약수 List에 저장한다.
    		for(int j = 1; j <= b.get(i); j++) {
    			if(b.get(i) % j == 0) {
    				bDivisior.add(j);
    			} //if	
    		} //inner for	
    	} //outer for
    	
    	Set<Integer> bDeduplication = new HashSet<>(bDivisior);	//약수 List의 중복을 제거하기 위해 약수 List를 Set으로 변환한다.
    	
    	for(int i = 0; i < b.size() - 1; i++) {					//약수 List에서, 중복이 제거된 약수 Set의 원소들을 제거하면, 중복된 원소들만 남는다.
    		for(Integer bDepuli : bDeduplication) {				//=> 모든 원소의 약수들에 공통으로 해당되는 수(공약수)
        		bDivisior.remove(bDepuli);						//(단, 만약 List b의 원소가 3개일 때, 약수가 2번만 중복되어도 공통의 약수가 될 수 있으므로 3번이 중복될 때 공약수가 되도록 
        	} //enhanced for									// 약수 List에서 약수 Set의 원소들을 2번 제거한다. => 약수 List에서 약수 Set의 원소들을 List b의 원소의 개수 - 1번 제거한다.)
    	} //outer for

    	Set<Integer> removed = new HashSet<>();					//공약수들 중에서 List a 원소들로 나누어 떨어지지 않는 수를 제거하기 위해 Set을 생성한다.
    	
    	for(Integer bDivi : bDivisior) {						//공약수들을 a의 원소들로 나누었을 때 나머지가 0이 되지 않는 수를 Set removed에 담는다.
    		for(int i = 0; i < a.size(); i++) {					//a의 원소들로 나눈다는 게 사실은 최소공배수로 나눈다는 뜻이랑 같은듯..?
    			if(bDivi % a.get(i) != 0) {
    				removed.add(bDivi);
    			} //if
    		} //inner for
    	} //enhanced for
    	
    	bDivisior.removeAll(removed);							//공약수들 중 Set removed에 해당하는 수를 모두 제거한다.
    	    	
    	return bDivisior.size();								//개수를 반환한다.

    } //getTotalX

} //end class

public class Practice17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("C:/Temp/primitive.dat"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);	//a 리스트의 capacity 입력

        int m = Integer.parseInt(firstMultipleInput[1]);	//b 리스트의 capacity 입력

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());	//a 리스트 입력

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());	//b 리스트 입력

        int total = Result1.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    } //main
} //end class