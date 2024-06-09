package com.example.fornecedores.controller;

import java.util.List;
import java.util.Optional;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.fornecedores.model.Supplier;
import com.example.fornecedores.model.SupplierCategory;
import com.example.fornecedores.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/supplier")
public class SupplierController {
	@Autowired
	private SupplierService supplierService;
	
	@PostMapping
	public ResponseEntity<Supplier> save(@Valid @RequestBody Supplier supplier) {
		Supplier createdSupplier = supplierService.save(supplier);
		return new ResponseEntity<>(createdSupplier, HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Supplier>> findAll(
		@RequestParam String searchTerm,
		@RequestParam int page,
		@RequestParam int size)
		{
		List<Supplier> supliers = supplierService.findAll(searchTerm, page, size);
		if (supliers.isEmpty()) {
			return ResponseEntity.ok(null);
		} else {
			return ResponseEntity.ok(supliers);
		}
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<Supplier>> findByCategory(
		@PathVariable String category,
		@RequestParam int page,
		@RequestParam int size
		) {
		
		List<Supplier> suppliers = supplierService.findByCategory(SupplierCategory.valueOf(category), page, size);
		return ResponseEntity.ok(suppliers);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Optional<Supplier>> findById(@PathVariable Long id) throws BadRequestException {
		Optional<Supplier> supplier = supplierService.findById(id);
		if (supplier.isPresent()) {
			return ResponseEntity.ok(supplier);
		}
		return ResponseEntity.ok(null);

	}

	@PutMapping("/{id}")
	public Supplier update(@PathVariable Long id, @Valid @RequestBody Supplier supplier) throws BadRequestException {
		return supplierService.update(id, supplier);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) throws BadRequestException {
		supplierService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
