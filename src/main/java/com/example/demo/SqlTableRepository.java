package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface SqlTableRepository extends CrudRepository<SqlTable, Integer> {

	void save(List<SqlTable> sqlTable);

}
