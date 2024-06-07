package com.example.fornecedores.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.fornecedores.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
