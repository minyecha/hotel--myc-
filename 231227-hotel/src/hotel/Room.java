package hotel;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Room {
	private String room; // 호수
	private String roomType; // 싱글 인지 더블인지
	private String roomstate; // 방상태 O X
	private String customerName;
	private String cphoneNumber;
	private boolean isReserved; // 예약
	private Date checkInTime; // 체크인

	public Room(String room, String roomType, String roomstate, String customerName, String cphoneNumber) {
		this.room = room;
		this.roomType = roomType;
		this.roomstate = roomstate;
		this.customerName = customerName;
		this.cphoneNumber = cphoneNumber;
		this.isReserved = false; // 예약 안된 빈 방

	}
	
	// 호실만 출력
	public Room(String room){
		this.room = room;
	}

	public Room() {

	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomstate() {
		return roomstate;
	}

	public void setRoomstate(String roomstate) {
		this.roomstate = roomstate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCphoneNumber() {
		return cphoneNumber;
	}

	public void setCphoneNumber(String cphoneNumber) {
		this.cphoneNumber = cphoneNumber;
	}

	public boolean isReserved() {
		return isReserved;
	}

	public void reservedRoom() {
		isReserved = true;
	}

	public void cancleReservedtion() {
		isReserved = false;
	}

	public void displayRoomInfo() {
		System.out.print("방 번호: " + room);
		System.out.print(" / 방 타입: " + roomType);
		System.out.print(" / 예약자 성명: " + customerName);
		System.out.print(" / 예약자 번호: " + cphoneNumber);
		System.out.println(" / 방 상태: " + roomstate);
		System.out.println("--------------------------");
		System.out.println();
	}

	
}