package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ListUsersStepDefinition {
	
private Response post;
	
	@Given("end point is given")
	public void initEndPoint() {		
		RestAssured.baseURI ="https://reqres.in/";		
	}
	
	@When("user submits the post request with numeric page value")
	public void hitRequest() {
		post = RestAssured.given().post();		
	}
	
	@Then("verify status code is correct")
	public void verify() {
		post.then().assertThat().statusCode(415);
		
	}

}
