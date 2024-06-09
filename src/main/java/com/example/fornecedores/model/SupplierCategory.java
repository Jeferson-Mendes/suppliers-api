package com.example.fornecedores.model;

public enum SupplierCategory {
    INFORMATION_TECHNOLOGY("Hardware, Software, IT Services"),
    COMMUNICATION_SERVICES("Telephony, Internet, Communication Platforms"),
    OFFICE_SUPPLIES("Stationery, Furniture, Equipment"),
    CLEANING_AND_MAINTENANCE("General Cleaning, Building Maintenance, Security"),
    HUMAN_RESOURCES("Recruitment, Training, Benefits"),
    LOGISTICS_AND_TRANSPORTATION("Goods Transportation, Warehousing, Fleet Management"),
    MARKETING_AND_ADVERTISING("Advertising, Digital Marketing, Events"),
    LEGAL_AND_COMPLIANCE_SERVICES("Legal Services, Auditing, Compliance Consulting"),
    FINANCIAL_SERVICES("Banking, Accounting, Insurance"),
    UTILITIES("Electricity, Water, Gas");

	private final String description;

    SupplierCategory(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}

