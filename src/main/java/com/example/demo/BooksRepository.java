package com.example.demo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BooksRepository extends CrudRepository<Books, Integer>  
{   
    Optional<Books> findById(Integer id);

}