package entity;

import java.math.BigDecimal;

public class Seller {
    private Long id;
    private String cpf;
    private String name;
    private BigDecimal salary;
    private BigDecimal totalSales;

    public Seller() {}

    public Seller(String cpf, String name, BigDecimal salary) {
        this.cpf = cpf;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales;
    }

    public void increaseTotalSales(BigDecimal totalSales) {
        this.totalSales = totalSales.add(totalSales);
    }
}
