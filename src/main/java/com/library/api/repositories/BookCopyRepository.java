package com.library.api.repositories;

import com.library.api.models.BookCopy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookCopyRepository extends JpaRepository<BookCopy,Long> {
}
