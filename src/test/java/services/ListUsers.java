package services;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import static org.hamcrest.Matchers.*;


public class ListUsers extends BaseRequest {
	


	@Test
	public void testListUserWithValidPageNumber() {
	
		int valid_page_number = 2;		
		
		
		RestAssured.given()
		.queryParam("page", valid_page_number)
			.get("api/users")
		.then()
		.assertThat()
			.statusCode(200)
		.and()
			.body("page", equalTo(valid_page_number))
		.and()
			.body("per_page", equalTo(6))
		.and()
			.body("total", equalTo(12))
		.and()
			.body("total_pages", equalTo(2))
		.and()
			.body("data",not(empty()) )
		.and()
			.body("data.id", not(empty()))
		.and()
			.body("data.email", not(empty()))
		.and()
			.body("data.first_name", not(empty()))
		.and()
			.body("data.last_name", not(empty()))
		.and()
			.body("data.avatar", not(empty()))
		.and()
			.body("ad", not(empty()))
		.and()
			.body("ad.company", not(empty()))
		.and()
			.body("ad.url", not(empty()))
		.and()
			.body("ad.text", not(empty()));
		
	}

	
	
	@Test(priority = 3)
	public void testListUserPageNumberAsInvalidInteger() {
		
		
		int invalid_page_number = 29;
		
		RestAssured
		.given()
		.queryParam("page", invalid_page_number)
			.get("api/users")
		.then()
		.assertThat()
			.statusCode(200)
		.and()
			.body("page", equalTo(invalid_page_number))
		.and()
			.body("per_page", equalTo(6))
		.and()
			.body("total", equalTo(12))
		.and()
			.body("total_pages", equalTo(2))
		.and()
			.body("data",(empty()) )
		.and()
			.body("data", not(hasKey("id")))
		.and()
			.body("data", not(hasKey("id")))
		.and()
			.body("data", not(hasKey("first_name")))
		.and()
			.body("data", not(hasKey("last_name")))
		.and()
			.body("data", not(hasKey("avatar")))
		.and()
			.body("ad", not(empty()))
		.and()
			.body("ad.company", not(empty()))
		.and()
			.body("ad.url", not(empty()))
		.and()
			.body("ad.text", not(empty()));
	}
	
	
	@Test(priority = 2)
	public void testListUserWithInvalidPageNumber() {
		
		int invalid_page_number = 29;	
		
		RestAssured
		.given()
		.queryParam("page", invalid_page_number)
			.get("api/users")
		.then()
		.assertThat()
			.statusCode(200)
		.and()
			.body("page", equalTo(invalid_page_number))
		.and()
			.body("per_page", equalTo(6))
		.and()
			.body("total", equalTo(12))
		.and()
			.body("total_pages", equalTo(2))
		.and()
			.body("data",(empty()) )
		.and()
			.body("data", not(hasKey("id")))
		.and()
			.body("data", not(hasKey("id")))
		.and()
			.body("data", not(hasKey("first_name")))
		.and()
			.body("data", not(hasKey("last_name")))
		.and()
			.body("data", not(hasKey("avatar")))
		.and()
			.body("ad", not(empty()))
		.and()
			.body("ad.company", not(empty()))
		.and()
			.body("ad.url", not(empty()))
		.and()
			.body("ad.text", not(empty()));
	}
}
