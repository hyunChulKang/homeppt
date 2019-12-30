package vo;

import java.util.Date;

public class ReservationVO {

	private String userId;
	private int reservationId;
	private int roomId;
	private int reservationPrice;
	private int status;
	private Date checkin;
	private Date checkout;
	private String request;
	private String paymethod;
	private int count;
	private String requests;
	
	
	public String getRequests() {
		return requests;
	}
	public void setRequests(String requests) {
		this.requests = requests;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getReservationId() {
		return reservationId;
	}
	public void setReservationId(int reservationId2) {
		this.reservationId = reservationId2;
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getReservationPrice() {
		return reservationPrice;
	}
	public void setReservationPrice(int reservationPrice) {
		this.reservationPrice = reservationPrice;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	public Date getCheckin() {
		return checkin;
	}
	public void setCheckin(Date checkin) {
		this.checkin = checkin;
	}
	public Date getCheckout() {
		return checkout;
	}
	public void setCheckout(Date checkout) {
		this.checkout = checkout;
	}
	public String getRequest() {
		return request;
	}
	public void setRequest(String request) {
		this.request = request;
	}
	public String getPaymethod() {
		return paymethod;
	}
	public void setPaymethod(String paymethod) {
		this.paymethod = paymethod;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
