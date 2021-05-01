package com.example.demo.services;


import org.aspectj.apache.bcel.classfile.Utility;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

public class JsonRestTemplate {

    ///Rest Template

    public ResponseEntity<?> postResponse(RestTemplate restTemplate, Object requestBody, String baseUrl, HttpHeaders headers, Class<?> responseObject) {
        ResponseEntity<?> response = null;
        HttpEntity<?> request = null;
        try {
            if (requestBody != null) {
                request = new HttpEntity<>(requestBody, headers);
            } else {
                request = new HttpEntity<>(headers);
            }
            baseUrl = baseUrl.trim();
           // log.error("URL  = > " + baseUrl);
            response = restTemplate.exchange(baseUrl, HttpMethod.POST,
                    request, responseObject);
        } catch (HttpStatusCodeException ex) {
            //log.error("Third-Party Service exception/error" + Utility.getAnnotationAttributes(ex));
            return new ResponseEntity<>(ex.getResponseBodyAsString(), ex.getStatusCode());

        }
        return response;

    }
}
