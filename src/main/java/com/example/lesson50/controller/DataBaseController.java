package com.example.lesson50.controller;

import com.example.lesson50.service.DataBaseConnectivityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("/")
@RequiredArgsConstructor
public class DataBaseController {
    private final DataBaseConnectivityService dbcService;
    @GetMapping("/connect")
    public ResponseEntity<String> getConnection() {
        return new ResponseEntity<>(dbcService.openConnection(), HttpStatus.OK);
    }
}
