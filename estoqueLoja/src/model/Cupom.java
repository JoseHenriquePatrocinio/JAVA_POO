package model;

public class Cupom {

    protected String data;
    protected String descricao;
    protected int qtdeVenda;
    protected double valor;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQtdeVenda() {
        return qtdeVenda;
    }

    public void setQtdeVenda(int qtdeVenda) {
        this.qtdeVenda = qtdeVenda;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Cupom() {
        setData(data);
        setDescricao(descricao);
        setQtdeVenda(qtdeVenda);
        setValor(valor);
    }

}

