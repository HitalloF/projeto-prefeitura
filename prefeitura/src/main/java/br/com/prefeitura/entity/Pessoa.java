package br.com.prefeitura.entity;


import javax.persistence.*;

@Entity
@Table(name="pessoa")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String cargo;

    private Double salario;

    public Pessoa(Long id, String name, String cargo, Double salario) {
        this.id = id;
        this.name = name;
        this.cargo = cargo;
        this.salario = salario;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCargo() {
        return cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public Pessoa()
    {}
}
