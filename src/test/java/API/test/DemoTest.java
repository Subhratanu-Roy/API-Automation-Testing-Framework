package API.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DemoTest {

	@Test
	void fetchXlData() throws Exception {
		Logger logger = LogManager.getLogger(this.getClass());
		logger.info("1st log");
		System.out.println("log example");
		logger.info("2nd log");

	}
}
