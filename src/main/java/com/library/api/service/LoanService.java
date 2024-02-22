package com.library.api.service;

import com.library.api.dto.LoanDto;
import com.library.api.dto.LoanResponse;

public interface LoanService {
    LoanDto getLoanById(long id);
    LoanDto createLoan(LoanDto loanDto);
    LoanDto returnLoan(long id);
    LoanResponse getAllLoans(int pageNo, int pageSize);
}
