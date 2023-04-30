package temp15;

//final 필드와 static final 필드의 차이점
//대전제: 모든 객체에 불변의 진리값을 만들고자 할 때에는 static final 상수로
//		  각 객체 안에서만 상수를 만들고자 할 때에는 그냥 final 상수로
public class Earth {
	
	//불변의 진리값으로 지구의 반지름을 static final 필드로 선언
	static final double EARTH_RADIUS; //= 6400;	//6400km
	static final double EARTH_SURFACE_AREA;		//그럼 지구의 면적은??
//						= 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	
	static {
		//* static initializer에서의 주의사항
		//(1) final이 붙지 않은 static 필드를 static initializer에서 초기화 할 때에는
		//	  정적 멤버답게 클래스명.static 필드명 = 초기값;이 허용되지만,
		//(2) final이 붙은 static 필드를 static initializer에서 초기화할 때에는
		//	  오히려 클래스명을 제거하고 필드명만으로 초기화해 줘야 한다.
//		Earth.EARTH_RADIUS = 6400;	//XX: final 때문에 선언만 해도 타입별 기본값이 들어감. => Earth. 하면 값을 고치겠다는 뜻이 됨.
		EARTH_RADIUS = 6400;		//OK
		
		//지구의 면적을 공식을 통해서 구한 값으로, static final 필드의 초기화
		EARTH_SURFACE_AREA = 4 * Math.PI * EARTH_RADIUS * EARTH_RADIUS;
	} //static initializer
} //end class
