package temp6;

public class TTT {
	public static void main(String[] args) {
		
		String myName = "Yoseph";
		myName = null;		//null: 그 어떤 객체의 주소(참조)도 없다.
		
		String yourName = "Pyramide";
		
		System.out.println(myName.equals(yourName));
		//equals를 쓰기 위해서는 myName에 참조가 있어야 한다.
		//myName이 null이라 equals를 쓸 수 없음.
		//equals는 String 타입이 갖고 있는 메소드.
	} //main
} //end class
