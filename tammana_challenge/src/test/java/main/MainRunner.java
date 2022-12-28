package main;

import io.cucumber.core.cli.Main;

public class MainRunner {

	public static void main(String[] args) {

		Main.main(new String[] { "-g", "steps", "src/test/resources/Features" });

	}

}
