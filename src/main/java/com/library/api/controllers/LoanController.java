package com.library.api.controllers;

import com.library.api.dto.LoanDto;
import com.library.api.dto.LoanResponse;
import com.library.api.service.LoanService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/loan/")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;

    }

    @GetMapping("/{id}")
    public ResponseEntity<LoanDto> getLoanById(@PathVariable(name = "id") long id) {
        LoanDto response = loanService.getLoanById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping("/create")
    public ResponseEntity<LoanDto> createLoan(@RequestBody LoanDto loanDto) {
        LoanDto response = loanService.createLoan(loanDto);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/return/{id}")
    public ResponseEntity<LoanDto> returnLoan(@PathVariable(name = "id") long id) {
        LoanDto response = loanService.returnLoan(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<LoanResponse> getAllBooks(@RequestParam(value = "pageNo", defaultValue = "0", required = false) int pageNo,
                                                    @RequestParam(value = "pageSize", defaultValue = "5", required = false) int pageSize) {
        LoanResponse loanResponse = loanService.getAllLoans(pageNo, pageSize);

        return new ResponseEntity<>(loanResponse, HttpStatus.OK);
    }
}
