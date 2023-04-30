package temp35;

import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
//@EqualsAndHashCode	//비지니스 로직은 아니지만 수학적으로 자동으로 이중판정알고리즘을 넣어줌.
@ToString
@AllArgsConstructor
public class Member {
	public String name;
	public int age;
	
	//Set과 Map Collection에서는 요소객체의 중복을 판정해서
	//중복된 객체는 아예 저장시키지 않도록 구현되어 있습니다. 때문에
	//중복을 허용하지 않는 Set의 요소객체나 Map의 키 객체에 대해서
	//hashCode() 메소드와 equals() 메소드 2개로 이중 중복판정알고리즘으로 중복여부를 판정한다.
	//이때, hashCode(), equals() 2개의 메소드를 어디까지나 "비지니스 관점"으로
	//중복 여부를 판정하도록 개발자가 직접 "재정의(Overriding)"해야 한다.
	
	//예: 두 회원 객체의 중복 여부
	@Override
	public boolean equals(Object obj) {
		log.trace("equals({}) invoked.", obj);
		
		if(obj instanceof Member) {
			Member member = (Member) obj;
			return member.name.equals(name) && (member.age == age);	//비지니스 로직
		} else {
			return false;
		} //if-else
	} //equals
	
	@Override
	public int hashCode() {	//객체의 OID 생성(어디까지나 OOP 관점 => 비지니스 관점으로 바꿔서 구현)
		log.trace("hashCode() invoked.");
		
		return name.hashCode() + age;	//비지니스 로직
	} //hashCode
} //end class







