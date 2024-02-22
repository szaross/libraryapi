package com.library.api.dto;

import com.library.api.models.Loan;
import lombok.Data;

import java.time.LocalDate;
@Data
public class LoanDto {
    private long id;
    private LocalDate start_time;
    private LocalDate end_time;
    private long bookCopyId;
    private long userId;
    private boolean is_returned;

    public static class LoanDtoBuilder{
        public static LoanDto fromLoan(Loan loan){
            LoanDto dto = new LoanDto();
            dto.set_returned(loan.is_returned());
            dto.setId(loan.getId());
            dto.setUserId(loan.getUser().getId());
            dto.setStart_time(loan.getStart_time());
            dto.setEnd_time(loan.getEnd_time());
            dto.setBookCopyId(loan.getBookCopy().getId());

            return dto;
        }
    }
}
