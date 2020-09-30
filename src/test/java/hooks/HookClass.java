package hooks;

import java.io.IOException;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HookClass {
	@Before
	public void setup() {

	}

	@After
	public void tearDown() throws IOException {
	}
}
