package bicycle;

public class Seat {
   
   
   //고유 속성 필드
   //===============================================
   
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
   
   
   
   void getOn() {
	   
   }//On
   
   void getOff() {
	   
   }//Off
   
   
   //메소드 필드
   
   void hold (boolean locking) {
	  
   }// hold 안장 고정 메소드 
   
	
   void setting (int i) {
	  
	   
}//setting메소드
   
   //자전거 메소드에 적어넣을 메소드
   void seatSetting(int height) {
	  
   }
   //seatSetting    
	   
	   void brocken() {
		   System.out.println("안장이 고장났습니다");
	   }
	   
       
   //생성자
   //================================================
   
   
   public Seat(){}//기본 생성자
   
   
   public Seat(int price) {
      this(null, null, null, null, 0.0, price);
      
   }//가격 입력 생성자
   
   
   public Seat(String brand,String model, String color, String material,double weight, int price) {
      this(brand, model, color, material, weight, price, false);
      
   }//고유 속성 생성자
   
   
   public Seat (boolean hold) {
      this(null, null, null, null, 0.0, 0, hold);
      
   }//안장 on/off 생성자
   
   
   public Seat(String brand,String model, String color, String material,
       double weight, int price, boolean hold) {
      
      this.brand = brand;         //브랜드
      this.model = model;         //모델
      this.color = color;         //색상
      this.material = material;   //재료
      this.weight = weight;      //무게
      this.price = price;         //가격
      this.hold = hold;         //안장 고정 on/off
      
   }//전체 생성자

public void setBicycle(Bicycle bicycle) {
	
	
} //setBicycle
   
   
   
   //===================================================
   
   
}//class