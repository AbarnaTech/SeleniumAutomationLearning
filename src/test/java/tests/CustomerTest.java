package tests;

import org.testng.annotations.Test;

public class CustomerTest extends BaseTest {
	@Test
    public void verifyCustomerFeature() throws Exception {
	Thread.sleep(5000);
	log.info("clicking Customer menu");
    cp.clickcust_0();
    Thread.sleep(2000);
    cp.cliccust_1();
    Thread.sleep(2000);
    cp.clickaddnew();
	}
}
