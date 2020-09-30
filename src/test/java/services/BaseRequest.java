package services;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

	protected RequestSpecification request;

	@BeforeClass
	public void setEndPoint() throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));

		RestAssured.baseURI = "https://" + prop.getProperty("server") + "/";

	}

}
