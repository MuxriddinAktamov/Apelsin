package com.company;

import com.company.dto.ProverbDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.client.support.InterceptingHttpAccessor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.util.Map;
import java.util.Set;

@Configuration
public class RestTemplate extends InterceptingHttpAccessor implements RestOperations {

//    RestTemplate restTemplate = new RestTemplate();
//    ProverbDTO dto = restTemplate.getForObject("some_url", ProverbDTO.class);
//    RestTemplate restTemplate = new RestTemplate();
//    List list = restTemplate.getForObject("some_url", List.class);

    @Override
    public <T> T getForObject(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> T getForObject(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> T getForObject(URI url, Class<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(String url, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> getForEntity(URI url, Class<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public HttpHeaders headForHeaders(String url, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public HttpHeaders headForHeaders(String url, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public HttpHeaders headForHeaders(URI url) throws RestClientException {
        return null;
    }

    @Override
    public URI postForLocation(String url, Object request, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public URI postForLocation(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public URI postForLocation(URI url, Object request) throws RestClientException {
        return null;
    }

    @Override
    public <T> T postForObject(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> T postForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> T postForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> postForEntity(URI url, Object request, Class<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public void put(String url, Object request, Object... uriVariables) throws RestClientException {

    }

    @Override
    public void put(String url, Object request, Map<String, ?> uriVariables) throws RestClientException {

    }

    @Override
    public void put(URI url, Object request) throws RestClientException {

    }

    @Override
    public <T> T patchForObject(String url, Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> T patchForObject(String url, Object request, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> T patchForObject(URI url, Object request, Class<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public void delete(String url, Object... uriVariables) throws RestClientException {

    }

    @Override
    public void delete(String url, Map<String, ?> uriVariables) throws RestClientException {

    }

    @Override
    public void delete(URI url) throws RestClientException {

    }

    @Override
    public Set<HttpMethod> optionsForAllow(String url, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public Set<HttpMethod> optionsForAllow(String url, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public Set<HttpMethod> optionsForAllow(URI url) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(URI url, HttpMethod method, HttpEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, Class<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public <T> ResponseEntity<T> exchange(RequestEntity<?> requestEntity, ParameterizedTypeReference<T> responseType) throws RestClientException {
        return null;
    }

    @Override
    public <T> T execute(String url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Object... uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> T execute(String url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor, Map<String, ?> uriVariables) throws RestClientException {
        return null;
    }

    @Override
    public <T> T execute(URI url, HttpMethod method, RequestCallback requestCallback, ResponseExtractor<T> responseExtractor) throws RestClientException {
        return null;
    }


//    @Bean
//    public RestTemplate restTemplate() {
//
//        RestTemplate restTemplate = new RestTemplate();
//        String fooResourceUrl
//                = "http://localhost:8080/spring-rest/foos";
//
//        ResponseEntity<String> response
//                = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
//        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
//    }
}
