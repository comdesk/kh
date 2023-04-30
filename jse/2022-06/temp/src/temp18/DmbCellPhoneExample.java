package temp18;

public class DmbCellPhoneExample {
	
	//(1) extends 키워드를 이용한 두 클래스 간에 "상속관계"가 형성되었을 때,
	//자식 객체를 생성한다면 "부모 없는 자식 없듯이" 힙에는 먼저 "부모" 객체가 생성되고
	//이어서 "자식"객체가 생성된다 => 확인해보자
	
	//(2) 부모 객체가 물려준 필드와 메소드를 내 것처럼 사용해보자.
	public static void main(String[] args) {
		//Step.1 DmbCellPhone 객체 생성
		//		 (*주의사항*) 부모 객체부터 "완전하게" 먼저 생성되고,
		//		 이후에, "자식객체"가 완전하게 생성됨.
		DmbCellPhone dmbCellPhone = new DmbCellPhone("자바폰", "검정", 10);
		
		//Step.2 CellPhone으로부터 상속 받은 필드를 사용해보자
		//		 상속 받은 필드는 부모 것이 아니라 "내" 것
		System.out.println("모델: " + dmbCellPhone.model);	//부모가 물려준 필드 사용
		System.out.println("색상: " + dmbCellPhone.color);	//부모가 물려준 필드 사용
		System.out.println("채널: " + dmbCellPhone.channel);
		
		//Step.3 CellPhone으로부터 상속 받은 메소드 호출
		// 상속 받은 메소드는 부모 것이 아니라 "내" 것
		
		//Step.3-1 아래의 호출된 메소드는 모두 부모객체로부터 상속받은 메소드를 호출하여 사용
		//내 것처럼 쓰나 부모 객체의 메소드를 호출한 것과 결과는 다르지 않다.
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("여보세요");
		dmbCellPhone.receiveVoice("안녕하세요! 저는 홍길동인데요");
		dmbCellPhone.sendVoice("아~ 예 반갑습니다");
		dmbCellPhone.hangUp();
		
		//Step.3-2 아래의 호출된 메소드는 모두 자식객체가 원래 가지고 있던 메소드 호출
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(12);
		dmbCellPhone.turnOffDmb();
		
		//Step.3-3 super 키워드를 이용한, 부모 멤버의 직접 사용(물려받은 것을 쓴 게 아님)
		dmbCellPhone.invokeAllMehotdsOfParentDirectly();
		
		dmbCellPhone.invokeAllInheritedMehotd();
		
	} //main
} //end class










