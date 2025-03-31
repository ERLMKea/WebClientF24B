package org.example.webclientf24b.service;

import org.example.webclientf24b.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class MyService {

    private final WebClient webClient;

    @Autowired
    public MyService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://localhost:8080").build();
    }

    public Mono<String> fetchHellox() {
        Mono<String> hello = webClient
                .get()
                .uri("/hello")
                .retrieve()
                .bodyToMono(String.class);
        return hello;
    }

    public String fetchHello() {
        var obj =  webClient
                .get()
                .uri("/hello/10000")
                .retrieve();
        //.bodyToMono(String.class);

        var hello = obj.bodyToMono(String.class);
        var hej = hello.block();

        return hej;
    }

    public Mono<List<Student>> fetchStudents() {
        Mono<List<Student>> students = webClient
                .get()
                .uri("/students")
                .accept(MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<List<Student>>() {});

        return students;
    }


}