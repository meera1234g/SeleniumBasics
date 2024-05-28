package dataprovider;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name = "invaliduserCredentials") //to call using name
		// multilple cases we use dp
	public Object[][] userCredetialsData() 
	{
		Object[][] data = new Object[3][2]; // array type Object
		data[0][0] = "abctest4391@gmail.com";
		data[0][1] = "Test123";
		
		data[1][0] = "abctest439@gmail.com";
		data[1][1] = "Test1234";
		
		data[2][0] = "abctest41391@gmail.com";
		data[2][1] = " test123";
		
		return data;
	}

}
