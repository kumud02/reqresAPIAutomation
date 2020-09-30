package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class FileHandler {

	public static void deleteFile(String filename) {
		File f = new File(filename);
		if (f.delete()) {
			System.out.println("File with name" + filename + " is deleted");
		} else {
			System.out.println("File with name" + filename + " cannot be deleted");
		}
	}

	public static void deleteFile(List<String> filenameList) {
		for (String filename : filenameList) {
			File toDeleteFile = new File(filename);
			//
			if (toDeleteFile.delete()) {
				System.out.println("File deleted successfully");
			} else {
				System.out.println("Failed to delete the file");
			}
		}

	}

	public static String[] getFilenameList(String directory) {
		File f = new File(directory);
		String[] filename = f.list();
		return filename;

	}

	public static void cleanup() throws IOException {
		System.out.println("--------------------------------------------------------------");
		System.out.println("This should be done at last");
		System.out.println("--------------------------------------------------------------");

		System.out.println("After test");

		String[] pathnames;
		BufferedReader reader;
		List<String> fileToDelete = new LinkedList<String>();
		String directory = "target/allure-results/";

		pathnames = getFilenameList(directory);
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

		deleteFile(fileToDelete);

		System.out.println(fileToDelete);

	}

	public static void main(String[] args) throws IOException {
		FileHandler.cleanup();

	}

}
