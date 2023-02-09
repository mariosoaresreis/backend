package pt.com.altice;

import java.util.UUID;

public class ServiceUnitTestBase extends ServiceTestBase {

	protected String generateCorrelationId() {
		return UUID.randomUUID().toString();
	}
}
