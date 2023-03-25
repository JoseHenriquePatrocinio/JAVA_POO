package model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Estoque {

    protected List<Produto> listaDoEstoque = new ArrayList<>();
    protected List<Produto> listaDeCadastro = new ArrayList<>();
    protected List<Cupom> listaDeCupom = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("0.00");

    public void adicionarEstoque(String codigo, int quantidade) {

        for (int i = 0; i < listaDeCadastro.size(); i++) {
            Produto produto = listaDeCadastro.get(i);
            if (produto.getCodigo().contains(codigo) && produto.getQuantidade() == 0) {
                produto.setQuantidade(quantidade);
                listaDoEstoque.add(produto);
            } else if (produto.getCodigo().contains(codigo) && produto.getQuantidade() != 0) {
                int qtdeEstq = produto.getQuantidade();
                qtdeEstq += quantidade;
                produto.setQuantidade(qtdeEstq);
            }
        }
    }

    public String gerarListaDeProdutoEstq() {
        String info = "";
        double preco = 0;
        int i = 0;
        for (Produto produto : listaDoEstoque) {
            i++;
            preco = produto.getPreco();
            info += i + ". Codigo: " + produto.getCodigo() + "\n";
            info += i + ". Descrição: " + produto.getDescricao() + "\n";
            info += i + ". Preço: " + df.format(preco) + "\n";
            info += i + ". Quantidade: " + produto.getQuantidade() + "\n";
            info += "\n";

        }
        return info;

    }

    public String gerarListaDeCadastro() {
        String info = "";
        double preco = 0;
        int i = 0;
        for (Produto produto : listaDeCadastro) {
            i++;
            preco = produto.getPreco();
            info += i + ". Codigo: " + produto.getCodigo() + "\n";
            info += i + ". Descrição: " + produto.getDescricao() + "\n";
            info += i + ". Preço: " + df.format(preco) + "\n";
            info += "\n";

        }
        return info;
    }

    public void venderProduto(String codigo, int quantidade) {

        for (int i = 0; i < listaDoEstoque.size(); i++) {
            Produto produto = listaDoEstoque.get(i);
            if (produto.getCodigo().contains(codigo)) {
                int qtdeEstq = produto.getQuantidade();
                qtdeEstq -= quantidade;
                produto.setQuantidade(qtdeEstq);
            }
        }
    }

    public void removerProduto(String codigo) {

        for (int i = 0; i < listaDoEstoque.size(); i++) {
            Produto produto = listaDoEstoque.get(i);
            if (produto.getCodigo().contains(codigo) && produto.getQuantidade() == 0) {
                listaDoEstoque.remove(produto);
            }
        }
    }

    public String gerarValorTotal() {
        String valor = "";
        double total = 0;
        for (int i = 0; i < this.listaDeCupom.size(); i++) {
            Cupom cupom = this.listaDeCupom.get(i);
            total = cupom.getValor();
            valor += df.format(total);
        }

        return valor;

    }

    public void cadastrarCupom(Cupom cupom) {

        listaDeCupom.add(cupom);

    }

    public String gerarCupom() {
        String info = "";
        double valor = 0;
        for (Cupom cupom : listaDeCupom) {
            valor = cupom.getValor();
            info += "Data: " + cupom.getData() + "\n";
            info += "Desc: " + cupom.getDescricao() + "\n";
            info += "Qtde.vendida: " + cupom.getQtdeVenda() + "\n";
            info += "Valor total: " + df.format(valor) + "\n" + "\n";

        }
        return info;
    }

    public void cadastrarProduto(Produto produto) {

        listaDeCadastro.add(produto);

    }

    public String retornaDescricao(String codigo) {
        String descricao = "";

        for (int i = 0; i < listaDoEstoque.size(); i++) {
            Produto produto = listaDoEstoque.get(i);
            if (produto.getCodigo().contains(codigo)) {
                descricao = produto.getDescricao();
            }
        }
        return descricao;
    }

    public int retornaQuantidade(String codigo) {
        int quantidade = 0;

        for (int i = 0; i < listaDoEstoque.size(); i++) {
            Produto produto = listaDoEstoque.get(i);
            if (produto.getCodigo().contains(codigo)) {
                quantidade = produto.getQuantidade();
            }
        }
        return quantidade;
    }

    public double retornaValorTotal(String codigo, int quantidade) {
        double valorTotal = 0;

        for (int i = 0; i < listaDoEstoque.size(); i++) {
            Produto produto = listaDoEstoque.get(i);
            if (produto.getCodigo().contains(codigo)) {
                valorTotal = produto.getPreco();
                valorTotal = valorTotal * quantidade;
            }
        }

        return valorTotal;
    }

    public boolean verificaCodigo(String codigo) {

        for (int i = 0; i < listaDeCadastro.size(); i++) {
            Produto produto = listaDeCadastro.get(i);
            if (produto.getCodigo().equals(codigo)) {
                return true;
            }
        }
        return false;
    }

}
