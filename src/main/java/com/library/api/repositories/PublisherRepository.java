package com.library.api.repositories;

import com.library.api.models.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
