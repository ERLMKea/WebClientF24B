package org.example.webclientf24b.controller;

import org.example.webclientf24b.service.MyService;
import org.example.webclientf24b.student.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class MyController {

    @Autowired
    MyService myService;

    @GetMapping("/datax")
    public Mono<String> getDatax() {
        Mono<String> res = myService.fetchHellox();
        return res;
    }

    @GetMapping("/data")
    public String getData() {
        String res = myService.fetchHello();
        return res;
    }

    @GetMapping("/students")
    public Mono<List<Student>> getStudents() {
        Mono<List<Student>> res = myService.fetchStudents();
        return res;
    }


}