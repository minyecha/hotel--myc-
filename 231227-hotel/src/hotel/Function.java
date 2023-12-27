package hotel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Function {
	private static List<Room> rooms;
	private static List<Room> viewRoom;
	private static Date checkOutTime; // 체크아웃
	private static Date checkInTime; // 체크인

	public Function() {
		initializeRoom();
	}

	public static void initializeRoom() {
		rooms = new ArrayList<>();
		for (int floor = 2; floor <= 5; floor++) {
			for (int roomNumber = 1; roomNumber <= 20; roomNumber++) {
				String roomType = (roomNumber % 2 == 0) ? "더블" : "싱글";
				String formattedRoomNumber = String.format("%d%02d", floor, roomNumber);
				rooms.add(new Room(formattedRoomNumber, roomType, "O", "", ""));
			}
		}
	}
	
	public static void viewRoom(){
		viewRoom = new ArrayList<>();
		for (int floor = 2; floor <= 5; floor++) {
			for (int roomNumber = 1; roomNumber <= 20; roomNumber++) {
				String formattedRoomNumber = String.format("%d%02d", floor, roomNumber);
				viewRoom.add(new Room(formattedRoomNumber));
			}
		}
	}
	
	
	public void displayRoomStatus() { // 모든 방을 볼수있는 메소드.

		for (Room room : rooms) {

			room.displayRoomInfo();
		}
		System.out.print("예약된 호실: ");
		for (Room room : rooms) {
			if (room.getRoomstate() == "X") {
				System.out.print(room.getRoom() + "\t");

			}

		}
		System.out.println();
		System.out.print("투숙중인 호실: ");
		for (Room room : rooms) {
			if (room.getRoomstate() == "투숙중") {
				System.out.print(room.getRoom() + "\t");
//				System.out.println();

			}

		}
		System.out.println();
		System.out.println("--------------------------");
	}

	public static void reservation(List<Room> rooms, String name, String phoneNumber) { // 예약메소드
		// boolean go = true;
		while (true) {
			System.out.println("원하는 호실을 입력해주세요.");
			Scanner sc = new Scanner(System.in);
			int input = sc.nextInt();
			// String input = String.valueOf(i);

			if ((input >= 201 && input <= 220) || (input >= 301 && input <= 320) || (input >= 401 && input <= 420)
					|| (input >= 501 && input <= 520)) {
				for (Room room : rooms) {
					if (room.getRoom().equals(String.valueOf(input)) && "O".equals(room.getRoomstate())) {
						room.setCphoneNumber(phoneNumber);
						room.setCustomerName(name);
						room.setRoomstate("X");
						room.reservedRoom();
						System.out.println("예약이 완료되었습니다.");
						return; // 유효한 방을 찾고 예약한 경우 메소드를 종료합니다.
					}
				}
				// 반복문이 유효한 방을 찾지 못한 경우
				System.out.println("해당 호실은 예약이 불가능합니다.");
			} else {
				System.out.println("올바른 호실을 입력해주세요.");
			}
		}

	}

	public static void cancleReservation(String cancleName, String canclePhoneNumber, String cancleRoomNumber) { // 예약취소메소드
		for (Room room : rooms) {

			if (room.isReserved() && room.getCustomerName().equals(cancleName)
					&& room.getCphoneNumber().equals(canclePhoneNumber)) {
				if (room.getRoom().equals(cancleRoomNumber)) {
					room.cancleReservedtion();
					room.setCustomerName(""); // 비움.
					room.setCphoneNumber("");
					room.cancleReservedtion();
					room.setRoomstate("O");
					System.out.println("예약이 취소되었습니다.");
					return;
				}

			}

		}
		System.out.println("해당 고객의 예약을 찾을 수 없습니다.");
	}

	public void checkIn(String customerName, String cphoneNumber, String cRoomNumber) { // 체크인 메소드

		for (Room room : rooms) {

			if (room.isReserved() && customerName.equals(room.getCustomerName())
					&& cphoneNumber.equals(room.getCphoneNumber())) {
				if (room.getRoom().equals(cRoomNumber)) {
					room.cancleReservedtion();
					room.setCustomerName(customerName); // 비움.
					room.setCphoneNumber(cphoneNumber);
					room.cancleReservedtion();
					room.setRoomstate("투숙중");
					System.out.println("체크인 되었습니다." + room.getRoom() + "호");
					this.checkInTime = new Date();
					System.out.println("체크인 시간은 : " + getFormattedCheckInTime());
					return;
				}

			}
			if (room.isReserved() == false && customerName.equals(room.getCustomerName())
					&& cphoneNumber.equals(room.getCphoneNumber())) {
				System.out.println("이미 체크인 하였습니다.");
				return;
			}

		}
		System.out.println("해당 고객의 정보를 찾을 수 없습니다.");
	}

	private String getFormattedCheckInTime() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(checkInTime);
	}

	private static String getFormattedCheckOutTime() { // 체크아웃시간.
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return dateFormat.format(checkOutTime);
	}

	public void checkOut(String cancleName, String canclePhoneNumber, String oRoomNumber) { // 체크아웃 메소드
		int count = 0;
		for (Room room : rooms) {
			if (room.getRoomstate().equals("투숙중") && room.getCustomerName().equals(cancleName)
					&& room.getCphoneNumber().equals(canclePhoneNumber)) {
				if (room.getRoom().equals(oRoomNumber)) {
					room.setCustomerName(""); // 비움.
					room.setCphoneNumber("");
					room.cancleReservedtion();
					room.setRoomstate("O");
					System.out.println("체크아웃 되었습니다.");
					System.out.println(cancleName + "님 안녕히가세요.");
					this.checkOutTime = new Date();
					System.out.println("체크아웃 시간은 : " + getFormattedCheckOutTime());
					count++;
					break;
				}

			}

		}
		if (count == 0) {
			System.out.println("없는 고객 입니다.");
		}

	}

	public void Walkin(List<Room> rooms, String name, String phoneNumber) { // 워크인메소드
		System.out.println("원하는 호실을 입력해주세요.");
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();

		if ((input >= 201 && input <= 220) || (input >= 301 && input <= 320) || (input >= 401 && input <= 420)
				|| (input >= 501 && input <= 520)) {
			boolean b = false;
			for (Room room : rooms) {
				if (room.getRoom().equals(String.valueOf(input)) && "O".equals(room.getRoomstate())) {
					room.setCphoneNumber(phoneNumber);
					room.setCustomerName(name);
					room.setRoomstate("투숙중");
					b = true;
					System.out.println("워크인 되셨습니다.");
					System.out.println("체크인이 완료되었습니다.");
					this.checkInTime = new Date();
					System.out.println("체크인 시간은 : " + getFormattedCheckInTime());
					break; // 예약이 가능한 방을 찾으면 루프를 빠져나갑니다.
				}
			}
			if (!b) { // 루프를 다 돌았는데도 b가 false라면 예약이 불가능한 것입니다.
				System.out.println("해당 호실은 예약이 불가능합니다.");
			}
		} else {
			System.out.println("올바른 호실을 입력해주세요.");
		}
	}
//	public void Find() {
//		String input = "304";
//		for (Room elem : f.getRooms()) {
//			if (elem.getRoom().equals(input)) {
//				elem.setCustomerName("고객 이름");
//				break;
//			}
//		}

	// }

	public List<Room> getRooms() {
		return rooms;
	}

	public static void findCustomer(String name, String phone) { // 없는 사람은 없다고 뜨고, 투숙중인지 예약중인지 출력
		boolean customerFound = false;
		for (Room room : rooms) {
			// if(!room.getCustomerName().equals(name) &&
			// !room.getCphoneNumber().equals(phone))
			if (room.getCustomerName().equals(name) && room.getCphoneNumber().equals(phone)) {
				System.out.print(room.getRoom() + "호");
				System.out.print(", 방 상태: " + room.getRoomstate());
				System.out.println();
				customerFound = true;

			}

		}
		if (!customerFound) {
			System.out.println("없는 고객정보입니다.");
		}

		System.out.println();
	}
}