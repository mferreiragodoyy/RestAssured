package steps;


import java.net.URISyntaxException;

import io.cucumber.java.Before;
import io.restassured.RestAssured;

public class Hooks {

	@Before
	public void inicializacao () throws URISyntaxException {
		
		RestAssured.baseURI = "https://petstore.swagger.io/";
		RestAssured.useRelaxedHTTPSValidation();
		
	}
}
