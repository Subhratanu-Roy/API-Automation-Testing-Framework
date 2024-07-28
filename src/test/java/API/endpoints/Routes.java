package API.endpoints;

/*
 * https://petstore.swagger.io/v2
 * https://petstore.swagger.io/v2/user
 * https://petstore.swagger.io/v2/user/{username}
 */

public class Routes {

	public static String base_url = "https://petstore.swagger.io/v2";

	// User module
	public static String postUrl = base_url + "/user";
	public static String getUrl = base_url + "/user/{username}";
	public static String updateUrl = base_url + "/user/{username}";
	public static String deleteUrl = base_url + "/user/{username}";

}
