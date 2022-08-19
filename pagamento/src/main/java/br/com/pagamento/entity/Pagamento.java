package br.com.Pagamento.entity;

import java.io.Serializable;

public class Pagamento implements Serializable {
    private static  final long serialVersionUID = 1L;

    private String name;
    private Double pagamentoMensal;
    private Integer meses;


    public Pagamento(){

    }

    public Pagamento(String name, Double pagamentoMensal, Integer meses) {
        this.name = name;
        this.pagamentoMensal = pagamentoMensal;
        this.meses = meses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPagamentoMensal(Double pagamentoMensal) {
        this.pagamentoMensal = pagamentoMensal;
    }

    public void setMeses(Integer meses) {
        this.meses = meses;
    }

    public String getName() {
        return name;
    }

    public Double getPagamentoMensal() {
        return pagamentoMensal;
    }

    public Integer getMeses() {
        return meses;
    }

    public Double getTotal(){
        return meses * pagamentoMensal;
    }
}
