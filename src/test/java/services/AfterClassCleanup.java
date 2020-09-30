package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.testng.annotations.AfterTest;

import utility.FileHandler;

public class AfterClassCleanup {
	@AfterTest
	public static void cleanup() throws IOException {
		System.out.println("--------------------------------------------------------------");
		System.out.println("This should be done at last");
		System.out.println("--------------------------------------------------------------");

		System.out.println("After test");

		String[] pathnames;
		BufferedReader reader;
		List<String> fileToDelete = new LinkedList<String>();
		String directory = "target/allure-results/";

		pathnames = FileHandler.getFilenameList(directory);
		for (String eachFile : pathnames) {
			reader = new BufferedReader(new FileReader(directory + eachFile));
			String line = reader.readLine();
			while (line != null) {
				if (line.contains("Runs Cucumber Scenarios") || line.contains("Default suite")) {
					fileToDelete.add(directory + eachFile);
					System.out.println("File " + directory + eachFile + "  should be deleted");

				}
				// read next line
				line = reader.readLine();
			}
			reader.close();
		}

		FileHandler.deleteFile(fileToDelete);

		System.out.println(fileToDelete);

	}

	

}
