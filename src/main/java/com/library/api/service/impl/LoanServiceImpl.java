package com.library.api.service.impl;

import com.library.api.dto.BookDto;
import com.library.api.dto.BookResponse;
import com.library.api.dto.LoanDto;
import com.library.api.dto.LoanResponse;
import com.library.api.exceptions.AuthorNotFoundException;
import com.library.api.models.Book;
import com.library.api.models.BookCopy;
import com.library.api.models.Loan;
import com.library.api.models.User;
import com.library.api.repositories.BookCopyRepository;
import com.library.api.repositories.LoanRepository;
import com.library.api.repositories.UserRepository;
import com.library.api.service.LoanService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanServiceImpl implements LoanService {
    private final LoanRepository loanRepository;
    private final UserRepository userRepository;
    private final BookCopyRepository bookCopyRepository;

    public LoanServiceImpl(LoanRepository loanRepository, UserRepository userRepository, BookCopyRepository bookCopyRepository) {
        this.loanRepository = loanRepository;
        this.userRepository = userRepository;
        this.bookCopyRepository = bookCopyRepository;
    }

    @Override
    public LoanDto getLoanById(long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Loan not found."));
        return LoanDto.LoanDtoBuilder.fromLoan(loan);
    }

    @Override
    public LoanDto createLoan(LoanDto loanDto) {
        User user = userRepository.findById(loanDto.getUserId()).orElseThrow(() -> new AuthorNotFoundException("User not found."));
        BookCopy bookCopy = bookCopyRepository.findById(loanDto.getBookCopyId()).orElseThrow(() -> new AuthorNotFoundException("Book copy not found."));

        Loan loan = Loan.builder()
                .start_time(loanDto.getStart_time())
                .end_time(loanDto.getEnd_time())
                .is_returned(false)
                .user(user)
                .bookCopy(bookCopy)
                .build();
        Loan saved = loanRepository.save(loan);
        return LoanDto.LoanDtoBuilder.fromLoan(saved);
    }

    @Override
    public LoanDto returnLoan(long id) {
        Loan loan = loanRepository.findById(id).orElseThrow(() -> new AuthorNotFoundException("Loan not found."));
        loan.set_returned(true);
        Loan saved = loanRepository.save(loan);
        return LoanDto.LoanDtoBuilder.fromLoan(saved);
    }

    @Override
    public LoanResponse getAllLoans(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        Page<Loan> page = loanRepository.findAll(pageable);

        List<LoanDto> allLoans = page
                .getContent()
                .stream()
                .map(LoanDto.LoanDtoBuilder::fromLoan)
                .toList();

        return LoanResponse.builder()
                .totalPages(page.getTotalPages())
                .loans(allLoans)
                .pageNo(page.getNumber())
                .pageSize(page.getSize())
                .last(page.isLast())
                .build();
    }
}
