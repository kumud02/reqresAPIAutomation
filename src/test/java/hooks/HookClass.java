package hooks;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookClass {
	@Before
	public void setup() {
		System.out.println("Setup Done");

	}

	@After
	public void tearDown() throws IOException {
		System.out.println("Tear Down");
	}
}
