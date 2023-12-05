package library.management.system;

import java.time.LocalDate;


public class Borrow {

	private int user_id;
	private int admin_id;
	private int book_id;
	private LocalDate start_date;
	private LocalDate end_date;

	public Borrow(int user_id, int admin_id, int book_id, LocalDate start_date, LocalDate end_date) {
		this.user_id = user_id;
		this.admin_id = admin_id;
		this.book_id = book_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}
	public Borrow() {
		this.user_id = 0;
		this.admin_id = 0;
		this.book_id = 0;
		this.start_date = null;
		this.end_date = null;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getAdmin_id() {
		return admin_id;
	}

	public void setAdmin_id(int admin_id) {
		this.admin_id = admin_id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public LocalDate getStart_date() {
		return start_date;
	}

	public void setStart_date(LocalDate start_date) {
		this.start_date = start_date;
	}

	public LocalDate getEnd_date() {
		return end_date;
	}

	public void setEnd_date(LocalDate end_date) {
		this.end_date = end_date;
	}
}
