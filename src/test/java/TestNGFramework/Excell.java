package TestNGFramework;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Excell {
@DataProvider
public Object[][] getdata() {
	Object [][]data=new Object[3][2];
	data[0][0]= "user1";
	data[0][1]= "user1";
	data[1][0]= "user1";
	data[1][1]= "user1";
	data[2][0]= "user1";
	data[2][1]= "user1";
	return data;
}
@Test(dataProvider="getdata")
public void take(String user, String pass) {
	
	System.out.println("Username:"+user+"password:"+pass);
}
}
