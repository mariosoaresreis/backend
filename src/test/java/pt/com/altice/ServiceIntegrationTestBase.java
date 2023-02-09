package pt.com.altice;

import java.util.UUID;

import org.springframework.http.HttpHeaders;

public class ServiceIntegrationTestBase extends ServiceTestBase {

    protected HttpHeaders getHeaders() {
        final HttpHeaders headers = new HttpHeaders();
        headers.add("user", UUID.randomUUID().toString());
        return headers;
    }
}
