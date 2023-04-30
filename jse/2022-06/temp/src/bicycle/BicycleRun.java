package bicycle;

import java.util.Scanner;

/*
 *  	##### 시나리오 & 알고리즘 ##### 
 *   ( 마지막 도착지점은 30km를 달리고 나면 종료 되게끔 설정.)
 *   1. 각 부품객체를 생성
 * 	 2. 각 부품 객체별로 부모 class에는 규격을 작성
 *   3. 각 부품 객체별로 2개 ( Kumho & Kia ) 자식 객체 생성
 *   4. 안장의 높이를 조절 ( 사람의 키 입력 ) => Seat에 메소드 존재
 *   5. 처음 출발을 기어 3단, 페달 60회로 출발 => Pedal에 분당 회전수 & 속도 메소드 존재 
 *   6. 10km 도달 후 장애물을 만난다는 메소드와 함께 방향 선택 ( 선택하는 방향에 따라 고장 날수 있고, 회피하여 진행 할 수 있으나, 10km에서는 회피 할 수 있게끔 설정) 
 *   7. 20km까지 오르막길을 직진해서 올라가는 것으로 정하였기 때문에 오르막길에서는 1단에 60회 페달로 입력해 놓았기 때문에, KumhoPedal 메소드에서의 case로 속도 10으로 진행
 *   8. 20km 지점에 도달하여 또 다시 장애물을 만나서 방향을 선택 ( 10km와 동일하게 선택하는 방향에 따라 고장 날수 있고, 회피하여 진행 할수 있으나, 20km에서는 고장날수 있게끔 설정)
 *   9. 고장이 나게 된다면 6가지 중에 1가지를 랜덤하게 출력하게 끔하여 어느것이 고장이 났고, 그 부품이 Kumho 제품에서 kia 제품으로 바뀌었다고 출력.
 *   10. 20km에서부터 30km 까지는 4단에 분당 회전수 60회로 설정하여 속도 40으로 설정하여 달린다. 
 *   11. 맨 마지막인 30km에 도달 직전에 브레이크를 작동 시키고 자식Brake에서 장력 조절 값과 감속 중인 메세지 출력 
 *   12. 현재속도가 0km이면 stop하고 30km를 완주하였다고 하고 끝낸다.    
 */


public class BicycleRun {
	
	public static void main(String[] args) {
		// 1) 부품 객체 생성
		GearBox gearBox = new KumhoGearBox();
		HandleBar handleBar = new KumhoHandleBar();
		Pedal pedal = new KumhoPedal();
		Seat seat = new KumhoSeat();
		FrontTire frontTire = new KumhoFrontTire();
		RearTire rearTire = new KumhoRearTire();
		Brake brake = new KumhoBrake();
		
		// 2) 완성 자전거 객체 생성
		
		Bicycle bicycle = new Bicycle(gearBox, handleBar, pedal, seat, frontTire, rearTire, brake);
		
		// 3) 각 실제 부품 설정
		gearBox.setBicycle(bicycle);
		handleBar.setBicycle(bicycle);
		pedal.setBicycle(bicycle);
		seat.setBicycle(bicycle);
		frontTire.setBicycle(bicycle); 
		rearTire.setBicycle(bicycle);
		brake.setBicycle(bicycle);
		
		
		// 4) 사람 생성
		Driver driver = new Driver();
		
		int select1 = 0;
		System.out.println("======================================");
		System.out.println("   	  안장을 설정합니다.");
		System.out.println("       키를 입력해주세요       ");
		System.out.println("======================================");
		System.out.print(">> ");
		
		
		Scanner sc = new Scanner(System.in);
		select1 = sc.nextInt();
		
		driver.setSeat(bicycle, select1);	// Driver에 있는 setSeat 메소드 호출
//		안장높이조절
		
		driver.getOn(bicycle);				// Driver에 있는 getOn 메소드 호출
//		앉다
		
		driver.setGear(bicycle, 3);			//Driver에 있는 setGear 메소드 호출
//		기어 3단
		
		driver.go(bicycle);					// Driver에 있는 go 메소드 호출
//		직진
		
		driver.press(bicycle, 60);			// Driver에 있는 press 메소드 호출
//		60회
		
		System.out.println("출발합니다.");
		System.out.println("평지를 10km까지 직진으로 달립니다.");
		
		
		System.out.println("10km구간에서 장애물을 만났습니다.");
		System.out.println("====================================");
		System.out.println("       방향을 선택합니다.");
		System.out.println("1. 왼쪽, 2. 오른쪽, 3. 직진");
		System.out.println("====================================");
		System.out.print(">> ");
		//왼쪽 혹은 오른쪽을 선택에서 장애물을 회피합니다.
		int select2 = sc.nextInt();
		
		if(select2 == 1) {
			System.out.println("왼쪽으로 피합니다.");
		} else if(select2 == 2) {
			System.out.println("오른쪽으로 피합니다.");
		} else {
			System.out.println("직진해서 장애물에 부딪혔으므로 부품을 교체합니다.");
		}	// if - else
		
		driver.setGear(bicycle, 1);
//		1단
		
		driver.go(bicycle);
//		직진
		
		driver.press(bicycle, 60);   
//		60회
		
		System.out.println("20km까지 오르막길을 직진해서 올라갑니다.");

		
		
		System.out.println("20km지점에서 장애물을 만났습니다.");
		System.out.println("====================================");
		System.out.println("방향을 선택합니다.");
		System.out.println("1. 왼쪽, 2. 오른쪽, 3. 직진");
		System.out.println("====================================");
		System.out.print(">> ");
		
		int select3 = sc.nextInt();
		
		if(select3 == 1) {
			System.out.println("왼쪽으로 핸들을 돌렸으나 장애물을 피하지 못했습니다.");
		} else if(select3 == 2) {
			System.out.println("오른쪽으로 핸들을 돌렸으나 장애물을 피하지 못했습니다.");
		} else {
			System.out.println("직진해서 장애물에 부딪혔으므로 부품을 교체합니다.");
		}	// if - else
		
//		직진을 선택해서 고장낸다.
//		Osticle. | Handle을 사용해서 회피 밎 고장
//		고장은 랜덤으로 Math.ramdom 사용, 부품 교체한다.
		
	int num = (int)(Math.random()* 6) + 1;		// Math 랜덤으로 6가지 case 문중에서 랜덤으로 장비를 고장내고 kumho장비로 장착되어있던것들 kia장비로 교체하게 된다. 	
		
		switch(num) {
		case 1:
			System.out.println("Kumho 앞쪽 타이어가 고장이므로 Kia타이어로 교체합니다.");
			frontTire = new KiaFrontTire();
			break;
		case 2:
			System.out.println("Kumho핸들이 고장이므로 Kia핸들로 교체합니다.");
			handleBar = new KiaHandleBar();
			break;
		case 3:
			System.out.println("Kumho기어가 고장이므로 Kia기어로 교체합니다.");
			gearBox = new KiaGearBox();
			break;
		case 4:
			System.out.println("Kumho안장이 고장이므로 Kia안장으로 교체합니다.");
			seat = new KiaSeat();
			break;
		case 5:
			System.out.println("Kumho패달이 고장이므로 Kia패달로 교체합니다.");
			pedal = new KiaPedal();
			break;
		case 6:
			System.out.println("Kumho브레이크가 고장이므로 Kia브레이크로 교체합니다.");
			brake = new KiaBrake();
			break;
		}	//switch
//		============ 20km ~ 30km 내리막길 구간
		driver.setGear(bicycle, 4);			// Driver에 있는 setGear 메소드 호출
//		4
		
		driver.go(bicycle);					// Driver에 있는 go 메소드 호출
//		직진
		
		driver.press(bicycle, 60);   		// Driver에 있는 press 메소드 호출
//		60회
		
		driver.setadj(bicycle, 4);			// Driver에 있는 setadj 메소드 호출
//		브레이크를 밟으면 감속한다.(감속도가 높으면 더 빨리 스피드가 0이 된다.)		
		driver.stop(bicycle);				// Driver에 있는 stop 메소드 호출
//		맨마지막 30km에 도착했을때 stop
		
		driver.getOff(bicycle);				// Driver에 있는 getOff 메소드 호출
		sc.close();
		System.out.println("====================================");
		System.out.println("30km를 완주했습니다. 수고하셨습니다.");
		System.out.println("====================================");
		

		
		
		
		
	}	// main
}	// class
