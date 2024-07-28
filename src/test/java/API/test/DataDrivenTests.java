package API.test;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import API.endpoints.UserEndpoints;
import API.payloads.User;
import API.utilities.DataProviders;
import io.restassured.response.Response;
import junit.framework.Assert;

public class DataDrivenTests {



	@Test(priority = 1, dataProvider = "all", dataProviderClass = DataProviders.class)
	public void testPostUser(String userId, String name, String firstname, String lastname, String email,
			String password, String phoneno, String userstatus) {

		User user = new User();
		user.setId(Integer.parseInt(userId));
		user.setUsername(name);
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setPhone(phoneno);
		user.setUserStatus(Integer.parseInt(userstatus));

		Response response = UserEndpoints.createUser(user);
		Assert.assertEquals(response.getStatusCode(), 200);

	}
	
	@Test(priority = 2, dataProvider = "username", dataProviderClass = DataProviders.class)
	public void getUserByName(String username) {
		
		Response response = UserEndpoints.getUser(username);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}
	
	@Test(priority = 3, dataProvider = "username", dataProviderClass = DataProviders.class)
	public void deleteUserByName(String username) {
		
		Response response = UserEndpoints.deleteUser(username);
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
