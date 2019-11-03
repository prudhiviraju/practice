package inheritence;

import org.testng.annotations.Test;

public class Childclass  extends ParentClas{

		
	public static void main(String[] args) {
		ParentClas p = new ParentClas();
		p.setup();
		p.url();
		p.logoverification();
		p.checkboxverificetion();
		p.teardown();
		
	}	
	
	
	
	
}
