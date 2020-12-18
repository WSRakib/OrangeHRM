package pageFactory;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data {

	
	@DataProvider(name = "ages")
	public Object[][]data() {
		
		Object[][] num = new Object[][]{
			{22,"Hurayra"},
			{33,"Haque"},
			{41,"Nayan"}
		
		};
		return num;
		
	}

}


