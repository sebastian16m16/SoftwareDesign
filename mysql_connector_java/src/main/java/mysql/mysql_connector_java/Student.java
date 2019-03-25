package mysql.mysql_connector_java;

public class Student {
	
	int stud_id;
	String nume;
	String address;
	String birthday;
	
	public Student() {
		
	}
	public Student(String nume, String birthday, String address) {
		this.nume = nume;
		this.birthday = birthday;
		this.address = address;
	}

	public Student(int stud_id, String nume, String birthday, String address) {
		this.stud_id = stud_id;
		this.nume = nume;
		this.birthday = birthday;
		this.address = address;
	}

	/**
	 * @return the stud_id
	 */
	public int getStud_id() {
		return stud_id;
	}

	/**
	 * @param stud_id the stud_id to set
	 */
	public void setStud_id(int stud_id) {
		this.stud_id = stud_id;
	}

	/**
	 * @return the nume
	 */
	public String getNume() {
		return nume;
	}

	/**
	 * @param nume the nume to set
	 */
	public void setNume(String nume) {
		this.nume = nume;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	
}
