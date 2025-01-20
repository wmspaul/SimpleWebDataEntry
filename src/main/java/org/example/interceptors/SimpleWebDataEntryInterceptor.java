package org.example.interceptors;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

@Slf4j
/*
 * The following class is used as an intercept for all backend calls
 * to help show specific information about the call and how long it took to execute.
 */
public class SimpleWebDataEntryInterceptor implements ClientHttpRequestInterceptor {
    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        log.info("URI: {}", request.getURI());
        log.info("REST Method: {}", request.getMethod());

        long startTime = System.currentTimeMillis();
        ClientHttpResponse response = execution.execute(request, body);
        long endTime = System.currentTimeMillis();

        log.info("Response Status Code: {}", response.getStatusCode().value());
        log.info("Execution Time: {}ms", (endTime - startTime));

        return response;
    }
}
