package bicycle;

public class KiaSeat 
extends Seat{
	   
	   
	   //고유 속성 필드
	   //===============================================
	   
	   private Bicycle bicycle;
	   
	   String brand;      //브랜드
	   String model;      //모델
	   String color;      //색상
	   String material;   //재료 [가죽,충전재,철제]
	   double weight;      //무게
	   int price;      //가격
	   
	   
	   //상태 필드
	   //================================================
	       
	   
	   boolean hold; //안장을 고정합니다.
	   boolean sit = true;
	   int Hight = 0;
	   
	   
	   //메소드 필드
	   
	   public void setKiaSeat(Bicycle bicycle) {
			this.bicycle = bicycle;
			
			System.out.println("KiaSeat::setKiaSeat(bicycle) invoked.");
		}//setBicycle

	  
	   
	   @Override
	   void getOn() {
		   System.out.println("KiaSeat::getOn() invoked.");
		   
		   sit = true;
	   }//On
	   
	   @Override
	   void getOff() {
		   System.out.println("KiaSeat::getOn() invoked.");
		   
		   sit = false;
	   }//Off
	   
	   @Override
	   void hold (boolean locking) {
		   System.out.println("KiaSeat::hold(locking) invoked.");
		   
		   if(this.hold == true && locking == true) { //안장이 잠겨있고 잠구려고 할 떄 이미 고정되었다고 출력
			   System.out.println("이미 안장이 고정되어 있습니다.");
			   
		   } else if (this.hold == false && locking == true) { //안장이 풀려있고 고정하려고 할때 고정한다고 출력
				   System.out.println("안장을 고정합니다.");
			       this.hold = true; 
			       
		   }  else {								   //안장이 잠겨있고 풀려고 할 떄 푼다고 출력
			       System.out.println("안장을 풉니다.");
			       this.hold = false;}//if - else
	   }// hold 안장 고정 메소드 
	   
		public void setBicycle(Bicycle bicycle) {
		this.bicycle = bicycle;
		
		System.out.println("KiaSeat::setBicycle(bicycle) invoked.");
		} //setBicycle

		@Override
	   void setting (int i) {
		   System.out.println("KiaSeat::setting(i) invoked.");
			
			if(0 < i && i < 5) { // 1~4사이의 높이로 안장을 세팅
			   System.out.println("안장을 풉니다.");
			   this.hold = false;
			   
			   System.out.println("안장을 i높이에 맞춥니다.");
			   this.Hight = i;
			   
			   System.out.println("안장을 고정합니다.");
			   this.hold = true; 
		   
		   } else {            //안장의 높이가 맞지 않다면 안정의 높이가 맞지 않다고 출력
			   System.out.println("높이가 맞지 않습니다.");
			   
		}//if-else
		   
	}//setting메소드
	   
	   //키 입력 메소드
		@Override
	   void seatSetting(int height) {
			System.out.println("KiaSeat::seatsetting(height) invoked.");
			
			if(180 <= height) {
			   setting(4);
		   } else if(170 <= height && height < 180) {
			   setting(3);
		   } else if (160 <= height && height < 170) {
			   setting (2);
		   } else {setting (1);} //else - if
	   }
	   //seatSetting    
		   
		   void brocken() {
			   System.out.println("KiaSeat::brocken() invoked.");
			   
			   System.out.println("안장이 고장났습니다");
		   }
		   
	       
	   //생성자
	   //================================================
	   
	   
	   public KiaSeat(){}//기본 생성자
	   
	   
	   public KiaSeat(int price) {
	      this(null, null, null, null, 0.0, price);
	      
	   }//가격 입력 생성자
	   
	   
	   public KiaSeat(String brand,String model, String color, String material,double weight, int price) {
	      this(brand, model, color, material, weight, price, false);
	      
	   }//고유 속성 생성자
	   
	   
	   public KiaSeat (boolean hold) {
	      this(null, null, null, null, 0.0, 0, hold);
	      
	   }//안장 on/off 생성자
	   
	   
	   public KiaSeat(String brand,String model, String color, String material,
	       double weight, int price, boolean hold) {
	      
	      this.brand = brand;         //브랜드
	      this.model = model;         //모델
	      this.color = color;         //색상
	      this.material = material;   //재료
	      this.weight = weight;      //무게
	      this.price = price;         //가격
	      this.hold = hold;         //안장 고정 on/off
	      
	   }//전체 생성자
	   
	   
	   
	   //===================================================
	   
	   
}//class

