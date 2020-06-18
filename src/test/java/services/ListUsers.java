package services;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.containsString;


public class ListUsers extends BaseRequest {
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
