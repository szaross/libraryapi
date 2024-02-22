package com.library.api.repositories;

import com.library.api.models.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan,Long> {
}
