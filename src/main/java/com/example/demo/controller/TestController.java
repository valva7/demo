package com.example.demo.controller;

import com.example.demo.dto.ResponseDTO;
import com.example.demo.dto.TestRequestBodyDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("test") // 리소스
public class TestController {

    @GetMapping
    public String testController(){
        return "Hello World! ";
    }

    @GetMapping("/testGetMapping") // http://localhost:8080/test/testGetMapping
    public String testControllerWithPath(){
        return "Hello World! testGetMapping!";
    }

    @GetMapping("/{id}") // https://localhost:8080/test/123
    public String testControllerWithPathVariables(@PathVariable(required = false) int id){
        return "Hello World! ID : " + id;
    }

    @GetMapping("/testRequestParam") // http://localhost:8080/test/testRequestParam?id=123
    public String testControllerRequestParam(@RequestParam(required = false) int id){
        return "Hello World! ID : " + id;
    }

    @GetMapping("/testRequestBody") // http://localhost:8080/test/testRequestBody + API 테스트 툴(PostMan)을 이용해 JSON 오브젝트 전달 {'id':123, 'message':hello}
    public String testControllerRequestBody(@RequestBody TestRequestBodyDTO testRequestBodyDTO){
        return "Hello World! ID : " + testRequestBodyDTO.getId() + ", Message : " + testRequestBodyDTO.getMessage();
    }

    @GetMapping("/testResponseBody") // http://localhost:8080/test/testResponseBody
    public ResponseDTO<String> testControllerResponsBody(){
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseDTO");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return response;
    }

    @GetMapping("/testResponseEntity") // http://localhost:8080/test/testResponseEntity
    public ResponseEntity<?> testControllerResponseEntity(){
        List<String> list = new ArrayList<>();
        list.add("Hello World! I'm ResponseEntity. And tou get 400!");
        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
        return ResponseEntity.badRequest().body(response);
        // return ResponseEntity.ok().body(response); // http status 정상으로 응답
    }
}
