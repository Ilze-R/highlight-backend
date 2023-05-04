package com.ilze.highlight.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth/demo-controller")
@RequiredArgsConstructor
public class DemoController {

  @GetMapping
  public ResponseEntity<String> sayHello(){
    return ResponseEntity.ok("Hello from secured endpoint");
  }
}
