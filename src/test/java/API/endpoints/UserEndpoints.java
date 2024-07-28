package API.endpoints;

import static io.restassured.RestAssured.given;

import API.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UserEndpoints {

	public static Response createUser(User userPayload) {
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(userPayload)
		.when()
			.post(Routes.postUrl);
		System.out.println("post URL: "+Routes.postUrl);
		return response;
		
	}
	
	public static Response getUser(String username) {
		Response response = given()
			.pathParam("username", username)
		.when()
			.get(Routes.getUrl);
		System.out.println("get URL: "+Routes.getUrl);
		return response;
	}
	
	public static Response updateUser(User userPayload, String username) {
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(userPayload)
			.pathParam("username", username)
		.when()
			.put(Routes.updateUrl);
		System.out.println("upd URL: "+Routes.updateUrl);
		return response;
		
	}
	
	public static Response deleteUser(String username) {
		Response response = given()
			.pathParam("username", username)
		.when()
			.delete(Routes.deleteUrl);
		System.out.println("del URL: "+Routes.deleteUrl);
		return response;
	}
	
	
}
