package com.learn.rest.webservices.restfulwebservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface FibRepository extends JpaRepository<Fib, String> {
}

