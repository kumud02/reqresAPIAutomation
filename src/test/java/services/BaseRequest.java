package services;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseRequest {

	protected RequestSpecification request;

	@BeforeClass
	public void setEndPoint() throws FileNotFoundException, IOException {

		Properties prop = new Properties();
		prop.load(new FileInputStream(new File("./src/test/resources/config.properties")));

		RestAssured.baseURI = "https://" + prop.getProperty("server") + "/";
		request = RestAssured.given().log().all().contentType(ContentType.JSON);

		System.out.println(prop.getProperty("server"));
	}

	@AfterTest
	public void removeUnnecessaryFiles() throws IOException {
		System.out.println("After test");

		String[] pathnames;
		BufferedReader reader;
		String rootDirectory = "target/allure-results/";
		File f = new File(rootDirectory);
		pathnames = f.list();
		List<String> fileToDelete = new LinkedList<String>();

		for (String pathname : pathnames) {
			// Print the names of files and directories

			reader = new BufferedReader(new FileReader(rootDirectory + pathname));
			String line = reader.readLine();
			while (line != null) {
				if (line.contains("Runs Cucumber Scenarios") || line.contains("Default suite")) {
					fileToDelete.add(rootDirectory + pathname);
					System.out.println("File " + rootDirectory + pathname + "  should be deleted");

				}

				// read next line
				line = reader.readLine();

			}
			reader.close();
		}

		for (String filename : fileToDelete) {
			File toDeleteFile = new File(filename);
			//
			if (toDeleteFile.delete()) {
				System.out.println("File deleted successfully");
			} else {
				System.out.println("Failed to delete the file");
			}
		}

		System.out.println(fileToDelete);

	}

}
