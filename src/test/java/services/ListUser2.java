package services;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

public class ListUser2 extends BaseRequest{
	@Test
	public void testListUserWithValidPageNumber() {
		
		request.given()
		.get("api/users?page=2")
		.then()
		.assertThat()
		.statusCode(200)
		.and()
		.body(containsString("ad"));
		
		System.out.println("Done");
	
		
	}

	

}
