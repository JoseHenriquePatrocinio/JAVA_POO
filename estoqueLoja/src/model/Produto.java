package model;

public class Produto {

    protected String codigo;
    protected String descricao;
    protected double preco;
    protected int quantidade;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto() {
        setCodigo(codigo);
        setDescricao(descricao);
        setPreco(preco);
        setQuantidade(quantidade);
    }

}
