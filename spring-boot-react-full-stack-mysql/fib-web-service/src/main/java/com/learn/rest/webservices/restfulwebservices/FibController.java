package com.learn.rest.webservices.restfulwebservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Array;
import java.util.*;

@RestController
public class FibController {

    @Autowired
    FibStoreRepository fibStoreRepository;
    @Autowired
    FibRepository fibRepository;

    @Autowired
    ApplicationContext applicationContext;
    @GetMapping(path = "/")
    public String home() {
        return "Welcome to Rest API Full stack APP";
    }

    @CrossOrigin(origins = "*")
    @GetMapping(path = "/values/current")
    public  ResponseEntity<List> getAllFibValues() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String>  list  = new ArrayList<String>();
        for (int i =0; i <=100; i++) {
            fibStoreRepository.findAllById(Collections.singleton(i)).forEach(fibStore -> {
                if (fibStore != null) {
                    list.add(String.valueOf(fibStore.value));
                }
            });
        }
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin",
                "*");

        return ResponseEntity.ok()
                //.headers(responseHeaders)
                .body(list);
    }
    @CrossOrigin(origins = "*")
    @GetMapping(path = "/values/all")
    public  ResponseEntity<String> getAllIndexes() {
        StringBuilder stringBuilder = new StringBuilder();
        fibRepository.findAll().forEach(fib -> {
            stringBuilder.append(fib.getId()+",");
        });
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("Access-Control-Allow-Origin",
                "*");
        return ResponseEntity.ok()
                .body(stringBuilder.toString());

    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/values")
    public ResponseEntity<Object> storeFib(@RequestBody Fib fib) {
        Optional<FibStore> fibStoreOptional = fibStoreRepository.findById(fib.getId());
        if (!fibStoreOptional.isPresent()) {
            StringRedisTemplate template = applicationContext.getBean(StringRedisTemplate.class);
            template.convertAndSend("fib2", String.valueOf(fib.getId()));
            fibRepository.save(fib);
        }
        return ResponseEntity.ok().build();
    }

}
