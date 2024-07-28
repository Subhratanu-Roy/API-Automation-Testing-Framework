package API.endpoints;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import API.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints2 {
	static Logger log = LogManager.getLogger();

	static Properties getUrl() throws IOException {
		Properties prop = new Properties();

		FileInputStream fis = new FileInputStream(
				new File(System.getProperty("user.dir") + "//resources//routes.properties"));
		prop.load(fis);
		return prop;

	}

//	public UserEndpoints2() throws IOException {
//		System.out.println("I am at UserEndpoints2");
//		FileInputStream fis = new FileInputStream(
//				new File(System.getProperty("user.dir") + "//resources//routes.properties"));
//		prop.load(fis);
//		log = LogManager.getLogger(this.getClass());
//	}

	public static Response createUser(User userPayload) throws IOException {

		String postUrl = getUrl().getProperty("postUrl");
		System.out.println("Post url: " + postUrl);
		log.info(postUrl);
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayload).when()
				.post(postUrl);
		return response;

	}

	public static Response getUser(String username) throws IOException {
		String getUrl = getUrl().getProperty("getUrl");
		System.out.println("Get url: " + getUrl);
		log.info(getUrl);
		Response response = given().pathParam("username", username).when().get(getUrl);
		return response;
	}

	public static Response updateUser(User userPayload, String username) throws IOException {
		String updateUrl = getUrl().getProperty("updateUrl");
		System.out.println("Update url: " + updateUrl);
		log.info(updateUrl);
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(userPayload)
				.pathParam("username", username).when().put(updateUrl);
		return response;

	}

	public static Response deleteUser(String username) throws IOException {
		String deleteUrl = getUrl().getProperty("deleteUrl");
		System.out.println("Delete url: " + deleteUrl);
		log.info(deleteUrl);
		Response response = given().pathParam("username", username).when().delete(deleteUrl);
		return response;
	}

}
