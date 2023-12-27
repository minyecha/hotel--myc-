package hotel;

import java.util.Scanner;

public class Employee { // 직원.
	String id;
	String pw;

	public Employee(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public static void Manager() { // 매니저 페이지

	}

	public static void DeskStaff() { // 데스크직원 페이지

	}

	public static void CleanStaff() { // 청소직원 페이지

	}

	public static void login() {
		Function f = new Function();
		f.initializeRoom();
		Room r = new Room();
		// Room r = f.getRooms().get(0); // 201

		Scanner scan = new Scanner(System.in);
		boolean loggedIn = false;
//		Room r = null;

		while (!loggedIn) {
			System.out.println("아이디를 입력하세요.");
			String id = scan.nextLine();
			System.out.println("비밀번호를 입력하세요.");
			String pw = scan.nextLine();

			if ("aaaa".equals(id) && "aaaa".equals(pw)) {
				System.out.println("매니저님 안녕하세요.");
				loggedIn = true; 
				while (loggedIn) {
					System.out.println("1. 객실 상태 확인  2. 객실 예약  3. 예약 취소  4. 워크인  5. 체크인  6. 체크아웃  7. 고객 정보로 검색  0. 로그아웃 ");
					int select = scan.nextInt();
					scan.nextLine();
					switch (select) {
					case 1:
						System.out.println("1. 객실상태확인");
						// f.initializeRoom();
						f.displayRoomStatus();
						break;
					case 2:
						System.out.println("2. 객실 예약");
						System.out.println("고객의 성명을 입력하세요.");
						String name = scan.nextLine();
						r.setCustomerName(name);
						System.out.println("");
						System.out.println("고객의 번호를 입력하세요.");
						String phoneNumber = scan.nextLine();
						r.setCphoneNumber(phoneNumber);
						f.reservation(f.getRooms(), name, phoneNumber);

						break;
					case 3:
						System.out.println("3. 예약 취소");
						System.out.println("고객의 성명을 입력하세요.");
						String cancleName = scan.nextLine();
						System.out.println("고객의 번호를 입력하세요.");
						String canclePhoneNumber = scan.nextLine();
						System.out.println("고객의 호실을 입력하세요.");
						String cancleRoomNumber = scan.nextLine();
						f.cancleReservation(cancleName, canclePhoneNumber,cancleRoomNumber);
						break;
					case 4:
						System.out.println("4. 워크인");
						System.out.println("고객의 성명을 입력하세요.");
						String wname = scan.nextLine();
						System.out.println("고객의 전화번호를 입력하세요.");
						String wphoneNumber = scan.nextLine();
						System.out.println("");
						f.Walkin(f.getRooms(), wname, wphoneNumber);

						break;
					case 5:
						System.out.println("5. 체크인");
						System.out.println("고객의 성명을 입력하세요.");
						String cname = scan.nextLine();
						System.out.println("고객의 전화번호를 입력하세요.");
						String cphoneNumber = scan.nextLine();
						System.out.println("고객의 호실을 입력하세요.");
						String cRoomNumber = scan.nextLine();
						System.out.println("");

						f.checkIn(cname, cphoneNumber,cRoomNumber );
						break;
					case 6:
						System.out.println("6. 체크아웃");
						System.out.println("고객의 성명을 입력하세요.");
						String oname = scan.nextLine();
						System.out.println("고객의 번호를 입력하세요.");
						String ophoneNumber = scan.nextLine();
						System.out.println("고객의 호실을 입력하세요.");
						String oRoomNumber = scan.nextLine();

//						System.out.println(oname + "님 안녕히가세요.");
						f.checkOut(oname, ophoneNumber,oRoomNumber);
						break;
					case 7:
						System.out.println("7. 고객 정보로 검색");
						System.out.println("고객의 성명을 입력하세요.");
						String fName = scan.nextLine();
						System.out.println("고객의 번호를 입력하세요.");
						String fPhone = scan.nextLine();
						f.findCustomer(fName, fPhone);
						break;
						
					case 0:
						System.out.println("0. 로그아웃");
						loggedIn = false;

						break;
					default:
						System.out.println("번호를 잘못 입력하였습니다. 다시 적어주세요.");
					}

				}
				
			} else if ("dddd".equals(id) && "dddd".equals(pw)) {
				System.out.println("데스크 직원님 안녕하세요.");
				loggedIn = true;
				while (loggedIn) {
					System.out.println("1. 객실 상태 확인  2. 객실 예약  3. 예약 취소  4. 워크인  5. 체크인  6. 체크아웃  7. 고객 정보로 검색  0. 로그아웃 ");
					int select = scan.nextInt();
					scan.nextLine();
					switch (select) {
					case 1:
						System.out.println("1. 객실상태확인");
						// f.initializeRoom();
						f.displayRoomStatus();
						break;
					case 2:
						System.out.println("2. 객실 예약");
						System.out.println("고객의 성명을 입력하세요.");
						String name = scan.nextLine();
						r.setCustomerName(name);
						System.out.println("");
						System.out.println("고객의 번호를 입력하세요.");
						String phoneNumber = scan.nextLine();
						r.setCphoneNumber(phoneNumber);
						f.reservation(f.getRooms(), name, phoneNumber);

						break;
					case 3:
						System.out.println("3. 예약 취소");
						System.out.println("고객의 성명을 입력하세요.");
						String cancleName = scan.nextLine();
						System.out.println("고객의 번호를 입력하세요.");
						String canclePhoneNumber = scan.nextLine();
						System.out.println("고객의 호실을 입력하세요.");
						String cancleRoomNumber = scan.nextLine();
						f.cancleReservation(cancleName, canclePhoneNumber,cancleRoomNumber);
						break;
					case 4:
						System.out.println("4. 워크인");
						System.out.println("고객의 성명을 입력하세요.");
						String wname = scan.nextLine();
						System.out.println("고객의 전화번호를 입력하세요.");
						String wphoneNumber = scan.nextLine();
						System.out.println("");
						f.Walkin(f.getRooms(), wname, wphoneNumber);

						break;
					case 5:
						System.out.println("5. 체크인");
						System.out.println("고객의 성명을 입력하세요.");
						String cname = scan.nextLine();
						System.out.println("고객의 전화번호를 입력하세요.");
						String cphoneNumber = scan.nextLine();
						System.out.println("고객의 호실을 입력하세요.");
						String cRoomNumber = scan.nextLine();
						System.out.println("");

						f.checkIn(cname, cphoneNumber,cRoomNumber );
						break;
					case 6:
						System.out.println("6. 체크아웃");
						System.out.println("고객의 성명을 입력하세요.");
						String oname = scan.nextLine();
						System.out.println("고객의 번호를 입력하세요.");
						String ophoneNumber = scan.nextLine();
						System.out.println("고객의 호실을 입력하세요.");
						String oRoomNumber = scan.nextLine();

//						System.out.println(oname + "님 안녕히가세요.");
						f.checkOut(oname, ophoneNumber,oRoomNumber);
						break;
					case 7:
						System.out.println("7. 고객 정보로 검색");
						System.out.println("고객의 성명을 입력하세요.");
						String fName = scan.nextLine();
						System.out.println("고객의 번호를 입력하세요.");
						String fPhone = scan.nextLine();
						f.findCustomer(fName, fPhone);
						break;
						
					case 0:
						System.out.println("0. 로그아웃");
						loggedIn = false;

						break;
					default:
						System.out.println("번호를 잘못 입력하였습니다. 다시 적어주세요.");
					}

				}

			} else if ("cccc".equals(id) && "cccc".equals(pw)) {
				System.out.println("청소부님 안녕하세요.");
				CleanStaff();
				loggedIn = true;

			} else {
				System.out.println("아이디, 비밀번호가 아닙니다.");
			}
		}

	}

}