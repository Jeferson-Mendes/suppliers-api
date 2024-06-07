package com.example.fornecedores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.fornecedores.entities.Supplier;
import com.example.fornecedores.repository.SupplierRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public void run(String... args) throws Exception {
		if (supplierRepository.count() == 0) {
            Supplier record1 = new Supplier();
            record1.setName("Super tintas");
            record1.setCategory("Tintas para impressora");
            record1.setFullAddress("Rua tal, 10, Centro, Fortaleza, CE");
            record1.setPhoneNumber("(85) 1 9999-9999");
            record1.setEmail("supertintas@email.com");

            Supplier record2 = new Supplier();
            record2.setName("All tech informática");
            record2.setCategory("Acessórios para informática");
            record2.setFullAddress("Rua X, 100, Salesianos, Juazeiro do Norte, CE");
            record2.setPhoneNumber("(88) 9 9999-9999");
            record2.setEmail("alltech@email.com");

            supplierRepository.save(record1);
            supplierRepository.save(record2);

            System.out.println("Suppliers data has been seeded");
        } else {
            System.out.println("Suppliers data already seeded.");
        }
	}
}
