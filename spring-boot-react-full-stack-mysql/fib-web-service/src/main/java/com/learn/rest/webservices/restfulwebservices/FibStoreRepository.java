package com.learn.rest.webservices.restfulwebservices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface FibStoreRepository extends JpaRepository<FibStore, Integer> {
}

