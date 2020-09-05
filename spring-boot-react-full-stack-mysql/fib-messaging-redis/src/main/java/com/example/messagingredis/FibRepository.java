package com.example.messagingredis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
    public interface FibRepository extends CrudRepository<FibStore, String> {
}

