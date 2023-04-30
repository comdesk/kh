//문제 주의사항
//1. 최초에 담긴 공을 컨테이너끼리 맞교환하므로 컨테이너의 크기는 변할 수 없다.
//2. 컨테이너 수 = 볼(ball) 타입 수
//3. 한 컨테이너 크기 = 한 볼 타입의 볼 개수 (컨테이너의 번호와 볼 타입의 번호는 일치하지 않아도 된다)

//알고리즘
//1. 2차원 리스트의 각각의 행의 합(컨테이너별 크기)을 원소로 갖는 배열을 생성한다.
//2. 2차원 리스트의 각각의 열의 합(볼 타입별 개수)을 원소로 갖는 배열을 생성한다.
//3. 컨테이너의 크기와 볼 타입별 개수가 같은 것이 있는지 차례대로 비교하기 위해 2번, 3번 배열을 정렬한다.
//4. 3번에서 정렬한 두 개의 배열을 차례대로 비교하여 원소가 하나라도 같지 않으면 "Impossible",
//	 모두 같으면 "Possible"을 리턴한다.

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

class Result2 {

    public static String organizingContainers(List<List<Integer>> container) {
    	
    	
		int[] rowsum = new int[container.size()];
		int[] colsum = new int[container.size()];
		
    	for(int i = 0; i < container.size(); i++) {

    		
    		for(int j = 0; j < container.size(); j++) {
    			
    			rowsum[i] += container.get(i).get(j);		// i번째 행의 합
    			    			
    			colsum[i] += container.get(j).get(i);		// i번째 열의 합
    		} //inner for
    		
    	} //outer for
    		
		Arrays.sort(rowsum);
		Arrays.sort(colsum);
		   		
		for(int i = 0; i < rowsum.length; i++) {
			if(rowsum[i] != colsum[i]) {
				return "Impossible";
			}
		} //for
		
		return "Possible";
    	
    } //organizingContainers

} //end class

public class Practice20 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<List<Integer>> container = new ArrayList<>();

                IntStream.range(0, n).forEach(i -> {
                    try {
                        container.add(
                            Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                        );
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                String result = Result2.organizingContainers(container);

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
