package com.example.fornecedores.service;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.fornecedores.entities.Supplier;
import com.example.fornecedores.repository.SupplierRepository;

@Service
public class SupplierService {
	@Autowired
	private SupplierRepository supplierRepository;
	
	public Supplier save(Supplier supplier) {
		return supplierRepository.save(supplier);
	}
	
	public List<Supplier> find() {
		return supplierRepository.findAll(Sort.by(Sort.Direction.ASC, "name"));
	}
	
	public Optional<Supplier> findById(Long id) throws BadRequestException {
		return supplierRepository.findById(id);
	}
	
	public Supplier update(Long id, Supplier supplier) throws BadRequestException {
		Supplier supplierRecord = findById(id).orElseThrow(() -> new BadRequestException("Supplier not found."));
		
		supplierRecord.name = supplier.name;
		supplierRecord.category = supplier.category;
		supplierRecord.fullAddress = supplier.fullAddress;
		supplierRecord.phoneNumber = supplier.phoneNumber;
		supplierRecord.email = supplier.email;
		
		return supplierRepository.save(supplierRecord);
	}
	
	public void delete(Long id) throws BadRequestException {
		findById(id).orElseThrow(() -> new BadRequestException("Supplier not found"));
		supplierRepository.deleteById(id);
	}

}
