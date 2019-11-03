package encapsulation;

public class Encapsulation {

	
	
	
	private String username;
	private String password;
	
	public void user(String username,String password) {
		if((username==null|username.contains(""))) {
			System.out.println("the username cannot be null");
			System.exit(0);
		}else {
			this.username=username;
		}
		
		
		
		if(password==null|password.contains("")) {
			System.out.println("the password cannot be null");
			System.exit(0);
		}else {
			this.password=password;
		}
		
		
	}
	
	
	
	public void display() {
		
		System.out.println("the username is"+username+"/t");
		System.out.println("the password id"+password+"/t");
	}
	
}
