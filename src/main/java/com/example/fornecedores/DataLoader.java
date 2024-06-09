package com.example.fornecedores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.fornecedores.model.Supplier;
import com.example.fornecedores.model.SupplierCategory;
import com.example.fornecedores.repository.SupplierRepository;

@Component
public class DataLoader implements CommandLineRunner {

	@Autowired
	private SupplierRepository supplierRepository;
	
	@Override
	public void run(String... args) throws Exception {
		if (supplierRepository.count() == 0) {
            Supplier supplier1 = new Supplier();
            supplier1.setName("Tech Solutions Ltda.");
            supplier1.setDescription("Empresa especializada em soluções de hardware e software.");
            supplier1.setCategory(SupplierCategory.INFORMATION_TECHNOLOGY);
            supplier1.setFullAddress("Av. Paulista, 1234, São Paulo, SP, 01310-100");
            supplier1.setPhoneNumber("(11) 1234-5678");
            supplier1.setEmail("contact@techsolutions.com");

            Supplier supplier2 = new Supplier();
            supplier2.setName("Comunica Telecom");
            supplier2.setDescription("Consultoria em recrutamento, seleção e treinamento.");
            supplier2.setCategory(SupplierCategory.COMMUNICATION_SERVICES);
            supplier2.setFullAddress("Rua das Flores, 567, Rio de Janeiro, RJ, 20000-000");
            supplier2.setPhoneNumber("(21) 8765-4321");
            supplier2.setEmail("suporte@comunicatelecom.com");
            
            Supplier supplier3 = new Supplier();
            supplier3.setName("Office Supplies Co.");
            supplier3.setDescription("Fornecedor de materiais de escritório e mobiliário.");
            supplier3.setCategory(SupplierCategory.OFFICE_SUPPLIES);
            supplier3.setFullAddress("Rua dos Andradas, 789, Porto Alegre, RS, 90020-005");
            supplier3.setPhoneNumber("(51) 3456-7890");
            supplier3.setEmail("sales@officesupplies.com");

            Supplier supplier4 = new Supplier();
            supplier4.setName("Clean & Safe");
            supplier4.setDescription("Serviços de limpeza geral e manutenção predial.");
            supplier4.setCategory(SupplierCategory.CLEANING_AND_MAINTENANCE);
            supplier4.setFullAddress("1122 Clean St, Los Angeles, CA 90001");
            supplier4.setPhoneNumber("(456) 789-0123");
            supplier4.setEmail("info@cleanandshine.com");

            supplierRepository.save(supplier1);
            supplierRepository.save(supplier2);
            supplierRepository.save(supplier3);
            supplierRepository.save(supplier4);

            System.out.println("Suppliers data has been seeded");
        } else {
            System.out.println("Suppliers data already seeded.");
        }
	}
}
