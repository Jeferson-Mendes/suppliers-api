package com.example.fornecedores.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.fornecedores.model.Supplier;
import com.example.fornecedores.model.SupplierCategory;

public interface SupplierRepository extends CrudRepository<Supplier, Long> {
    
    @Query("FROM Supplier s " +
           "WHERE LOWER(s.name) like %:searchTerm% " +
           "OR LOWER(s.email) like %:searchTerm% " +
           "OR LOWER(s.description) like %:searchTerm%")
    List<Supplier> findAll(@Param("searchTerm") String searchTerm, Pageable pageable);

    List<Supplier> findByCategory(SupplierCategory category, Pageable pageable);
}
