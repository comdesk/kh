package temp42;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
public class Child 
	extends Parent 
	implements Serializable {
	
	public String field2;	//인스턴스 필드(자식만이 가지고 있는)
	
	//아래의 2개의 메소드의 시그니처(선언부)는 이미 정해져 있는 것으로
	//개발자가 고쳐서도 안 되고, 원래 목적에 맞게 구현해야 한다.
	
	//(1) 이 메소드는 이 클래스의 객체가 직렬화될 때, 자동으로 호출되는 콜백(Callback) 메소드
	//이 메소드는 절대로 상속받은 메소드가 아니다.
	//이유: 객체의 직렬화 과정에서 한 번 간섭할 기회를 제공하는 메소드
	
	//그럼 어떻게 Non-serializable하고 소스도 수정할 수 없는 부모 클래스의 필드를
	//어떻게 직렬화할 수 있을까? => 해답: 바로 아래 메소드의 "매개변수"
	//매개변수가 ObjectOutputStream이므로 ObjectOutputStream의 메소드 이용해서 직접 직렬화 해라
	private void writeObject(ObjectOutputStream out) throws IOException {
	   log.trace("writeObject({}) invoked.", out);

	   out.writeUTF(this.field1);		//부모가 상속해준 필드를 직접 writeXXX 메소드로 써라
	   				//this는 내것, super는 부모것
	   //아래의 메소드는 반드시 호출해줘야 함.
	   out.defaultWriteObject();	//이 메소드가 원래 호출되는 기본 직렬화 메소드임.
	} //writeObject
	
	//(2) 이 메소드는 이 클래스의 객체가 역직렬화될 때, 자동으로 호출되는 콜백(Callback) 메소드
	//이 메소드는 절대로 상속받은 메소드가 아니다.
	//이유: 객체의 역직렬화 과정에서 한 번 간섭할 기회를 제공하는 메소드
	
	//그럼 어떻게 Non-serializable하고 소스도 수정할 수 없는 부모 클래스의 필드를
	//어떻게 역직렬화할 수 있을까? => 해답: 바로 아래 메소드의 "매개변수"
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
	   log.trace("readObject({}) invoked.", in);
		
	   super.field1 = in.readUTF();	//부모가 상속해준 필드를 직접 readXXX 메소드로 읽어라
	   
	   //아래의 메소드는 반드시 호출해줘야 함.
	   in.defaultReadObject();	//이 메소드가 원래 호출되는 기본 역직렬화 메소드임.(이 콜백 메소드를 만들지 않으면)
	}
} //end class




