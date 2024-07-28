package API.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import API.endpoints.UserEndpoints;
import API.endpoints.UserEndpoints2;
import API.payloads.User;
import io.restassured.response.Response;
import junit.framework.Assert;

public class UserTests {

	Faker faker;
	User user = new User();
	public Logger logger;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		user.setId(faker.idNumber().hashCode());
		user.setFirstname(faker.name().firstName());
		user.setUsername(faker.name().fullName());
		user.setLastname(faker.name().lastName());
		user.setEmail(faker.internet().emailAddress());
		user.setPhone(faker.phoneNumber().cellPhone());
		user.setPassword(faker.internet().password());

		// for logs
		logger = LogManager.getLogger(this.getClass());

	}

	@Test(priority = 1)
	public void testPostUser() throws IOException {
		logger.info("******** Creating User **********");
		Response response = UserEndpoints.createUser(user);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("******** User created ********");

	}

	@Test(priority = 2)
	public void testGetUser() throws IOException {
		logger.info("******** Getting  user ********");
		Response response = UserEndpoints.getUser(this.user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.statusCode(), 200);
		logger.info("******** User info displayed ********");
	}

	@Test(priority = 3)
	public void updateUser() throws IOException {
		logger.info("******** updating user ********");
		user.setPhone(faker.phoneNumber().cellPhone());
		Response response = UserEndpoints.updateUser(user, this.user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@Test(priority = 4)
	public void deleteUser() throws IOException {
		logger.info("******** deleting user ********");
		Response response = UserEndpoints.deleteUser(this.user.getUsername());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
