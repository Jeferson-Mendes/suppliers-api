package com.example.fornecedores.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Supplier {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank(message = "name is required")
    @Size(min = 2, max = 100, message = "name should be of 2 - 100 characters")
	@Column(nullable = false, length = 120)
	public String name;

	@NotBlank(message = "description is required")
    @Size(min = 10, max = 400, message = "description should be of 2 - 100 characters")
	@Column(nullable = false)
	public String description;

	@NotNull(message = "category is required")
	@Enumerated(EnumType.STRING)
	public SupplierCategory category;

	@NotBlank(message = "fulladdress is required")
	@Column(nullable = false)
	public String fullAddress;

	@NotBlank(message = "phoneNumber ir required")
	@Size(min = 11, max = 16, message = "phoneNumber should be 10 - 15 characters")
	@Column(nullable = false)
	public String phoneNumber;

	@NotBlank(message = "email is required")
	@Email(message = "email should be valid")
	@Column(nullable = false)
	public String email;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SupplierCategory getCategory(){
		return category;
	}

	public void setCategory(SupplierCategory category) {
		this.category = category;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
