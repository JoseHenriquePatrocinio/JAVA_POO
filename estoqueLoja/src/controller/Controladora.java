package controller;

import model.*;
import view.EntradaSaida;

public class Controladora {

    protected Estoque estoque = new Estoque();
    protected Produto produto = null;
    protected Cupom cupom = null;

    public void exibeMenu() {

        int opcao;

        do {

            opcao = EntradaSaida.solicitaOpcao();

            switch (opcao) {

                case 0: // Cadastra produto
                    produto = new Produto();

                    String codigo = EntradaSaida.solicitaCodigo();
                    boolean ver = estoque.verificaCodigo(codigo);
                    while (ver == true || codigo.isBlank()) {
                        EntradaSaida.MsgErro();
                        codigo = EntradaSaida.solicitaCodigo();
                        ver = estoque.verificaCodigo(codigo);
                    }

                    double preco = EntradaSaida.solicitaPreco();
                    while (preco <= 0) {
                        EntradaSaida.MsgErro();
                        preco = EntradaSaida.solicitaPreco();
                    }

                    String descricao = EntradaSaida.solicitaDescricao();
                    while (descricao.isBlank()) {
                        EntradaSaida.MsgErro();
                        descricao = EntradaSaida.solicitaDescricao();
                    }

                    produto.setDescricao(descricao);
                    produto.setCodigo(codigo);
                    produto.setPreco(preco);
                    produto.setQuantidade(0);
                    this.estoque.cadastrarProduto(produto);

                    break;

                case 1: // Entrada no estoque

                    codigo = EntradaSaida.solicitaCodigo();
                    ver = estoque.verificaCodigo(codigo);
                    if (ver == false || codigo.isBlank()) {
                        EntradaSaida.MsgErro();
                        break;
                    }

                    int quantidade = EntradaSaida.solicitaQtdeEntrada();
                    while (quantidade <= 0) {
                        EntradaSaida.MsgErro();
                        quantidade = EntradaSaida.solicitaQtdeEntrada();
                    }

                    this.estoque.adicionarEstoque(codigo, quantidade);

                    break;

                case 2: // Vende produto

                    codigo = EntradaSaida.solicitaCodigo();
                    ver = estoque.verificaCodigo(codigo);
                    if (ver == false || codigo.isBlank()) {
                        EntradaSaida.MsgErro();
                        break;
                    }
                    descricao = estoque.retornaDescricao(codigo);
                    quantidade = EntradaSaida.solicitaQtdeSaida();
                    int quantidadeEstq = estoque.retornaQuantidade(codigo);
                    if (quantidade <= 0 || quantidade > quantidadeEstq) {
                        EntradaSaida.MsgErro();
                        break;
                    }
                    this.estoque.venderProduto(codigo, quantidade);
                    this.estoque.removerProduto(codigo);

                    cupom = new Cupom();
                    cupom.setData(EntradaSaida.exibirData());
                    cupom.setDescricao(descricao);
                    cupom.setQtdeVenda(quantidade);
                    cupom.setValor(estoque.retornaValorTotal(codigo, quantidade));
                    this.estoque.cadastrarCupom(cupom);

                    break;

                case 3: // Lista de cadastro
                    String listaCadastro = estoque.gerarListaDeCadastro();
                    EntradaSaida.exibirListaCadastro(listaCadastro);
                    break;

                case 4: // Lista de estoque
                    String listaEstoque = estoque.gerarListaDeProdutoEstq();
                    EntradaSaida.exibirEstoque(listaEstoque);
                    break;

                case 5: // Lista de cupons
                    String listaCupom = estoque.gerarCupom();
                    EntradaSaida.exibirCupons(listaCupom);
                    break;

                case 6: // Valor total
                    String valorTotal = estoque.gerarValorTotal();
                    EntradaSaida.exibeValorTotal(valorTotal);
                    break;

            }

        } while (opcao != 7);

        EntradaSaida.exibeMsgEncerraPrograma();

        System.exit(0);

    }

}
