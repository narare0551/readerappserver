package vo;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String serial_num;

	

	
	public Member(String id, String pw, String name, String serial_num) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.serial_num = serial_num;

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
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getSerial_num() {
		return serial_num;
	}
	public void setSerial_num(String Serial_num) {
		this.serial_num = serial_num;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", pw=" + pw + ", name=" + name + ", serial_num=" + serial_num + "]";
	}
	
}
