package temp37;

import java.util.Stack;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class StackExample {
	
//	LIFO(후입 선출) 자료구조를 가지는 스택의 예(동전통)
	public static void main(String[] args) {
		//1. 스택 구조를 가지는 자료 구조 생성
		Stack<Coin> coinBox = new Stack<>();
		
		//2. 스택에 동전 4개를 넣는다.(PUSH)
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(0));
		
		Coin c1000 = new Coin(1000);
		coinBox.push(c1000);			//중복 삽입
		coinBox.push(c1000);			//중복 삽입
		
		log.info("1. coinBox:{}", coinBox);
		
		//3. 스택이 비워질 때까지(empty), 요소를 하나씩 POP해서 출력
//		while(!coinBox.isEmpty()) {		//동전통이 비었는가
//			Coin coin = coinBox.pop();	//비어있지 않으면 하나를 끄집어내라
//			
//			log.info("꺼내온 동전: {} 원", coin.getValue());
//		} //while
		
		//4. Traverse
		for(Coin coin : coinBox) {
			log.info(coin);
		} //enhanced for
		//LIFO 성질은 push, pop일 때의 성질이고, 순회할 때는 list 구조라고 생각해야함.
		//먼저 들어간 것이 먼저 찍힘.

	} //main

} //end class





