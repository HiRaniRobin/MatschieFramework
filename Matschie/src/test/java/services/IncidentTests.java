package services;

import java.io.File;

import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

public class IncidentTests extends BaseRequest{
	
	
	@Test
	public void getIncidents(){
		request
			.get("incident")
			.then()
			.assertThat()
			.statusCode(200)
			.body(containsString("number"),containsString("sys_id1"))
			.extract().response();
				
	}
	
	@Test
	public void createIncident(){
		request
			.body(new File("./data/incident1.json"))
			.post("incident")
			.then()
			.assertThat()
			.statusCode(201)
			.body(containsString("number"),containsString("sys_id"));		
	}
}
