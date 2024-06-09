package com.example.fornecedores.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.fornecedores.model.Supplier;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    
    @Query("FROM Supplier s " +
           "WHERE LOWER(s.name) like %:searchTerm% " +
           "OR LOWER(s.email) like %:searchTerm% " +
           "OR LOWER(s.fullAddress) like %:searchTerm%")
    List<Supplier> findAll(@Param("searchTerm") String searchTerm, Pageable pageable);

    List<Supplier> findByCategory(String category, Pageable pageable);
}
