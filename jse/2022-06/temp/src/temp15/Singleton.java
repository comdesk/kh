package temp15;

public class Singleton {
	private static final Singleton MY_SELF_ADRRESS; // = new Singleton();	//정적필드
	//private => 필드를 사용 못하게. Singleton.singleton으로 사용 x
	//단 한 번만 수행되는 정적초기자에 의해(버추얼머신에 의해 보장) 단 한 번 힙에 생성된 싱글톤 타입의 객체의 주소가 들어감.
	//static을 통해 Clazz 객체는 버추얼머신과 생명주기가 동일. => 버추얼머신이 죽기 전까지는 영구적으로 객체의 주소를 갖고 잇음.
	//필드가 사라지지 않으니 싱글톤 객체는 사용중이므로 자동으로 파괴할 수 없음.(변수가 주소를 담고 있으면, 변수가 계속 살아있는 한 사용중)
	//혹시 실수로 값을 고칠 수 있기 때문에 값을 못 고치도록 final로 상수화
	
//	==================
//	모든 외부 객체에 공유할 데이터 저장
//	==================
	public int[] passwords;
	
	
	
	static {	//JVM에서 단 한 번만 실행되도록 보장하는 블록
		MY_SELF_ADRRESS = new Singleton();
	} //static initializer
	//필드에 정의해도 정적초기자로 들어와서 실행되기는 하지만 확실히 처음 실행되고 JVM에서
	//단 한 번만 실행되도록 보장하기 위해 정적초기자로 객체의 주소를 넣어준다.
	
	private Singleton() {
		System.out.println("Singleton::default constructor invoked.");
		
		//Database에서 가져온 데이터로 초기화
		this.passwords = new int[] {1, 2, 3, 4, 5};
	}	//Default Constructor => 외부에서 생성자 사용 x => 객체 생성x
	//꼭 기본 생성자 아니어도됨. (매개변수 있는 생성자도 가능). 실행문장 넣어도 됨. 필드 초기화도 됨.
	//직접 생성자를 만들면 컴파일러는 생성자에 관여하지 않음.
	//내부에서는 사용 가능하므로 객체 생성 가능
	
	//Singleton.getInstance()로 사용 가능
	public static Singleton getInstance() {	//인스턴스의 주소를 돌려주는 정적 메소드
		System.out.println("Singleton::getInstance() invoked.");
		
		return MY_SELF_ADRRESS;	//외부에서 접근 불가능했던 mySelfAddress에 접근 가능 => 단 하나의 객체에만 접근하게 되므로 같은 객체를 갖게 됨.
	} //getInstance
} //end class
//싱글톤 안에 공유하려는 데이터를 담은 필드가 있어야 함.