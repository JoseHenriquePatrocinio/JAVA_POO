package controller;

import model.*;
import view.EntradaSaida;

public class Controladora {

    private Conta conta = new Conta();
    Movimentacao movimentacao = null;

    public void exibeMenu() {
        int opcao;

        conta.setTitularDaConta(EntradaSaida.solicitaTitular());
        conta.setTipoConta(EntradaSaida.solicitaTipo());

        do {

            opcao = EntradaSaida.solicitaOpcao();

            switch (opcao) {

                case 0:

                    String depositar = "Deposito";
                    double valor = EntradaSaida.solicitarInformacoesDeposito();
                    while (valor <= 0) {
                        EntradaSaida.msgErro();
                        valor = EntradaSaida.solicitarInformacoesDeposito();
                    }
                    this.conta.depositar(valor);

                    movimentacao = new Movimentacao();

                    movimentacao.setTipoMov(depositar);
                    movimentacao.setValor(valor);
                    movimentacao.setData(EntradaSaida.data());
                    this.conta.adicionarMovimentacao(movimentacao);

                    break;

                case 1:

                    double verificarSaldo = conta.getSaldo();
                    if (verificarSaldo < -999) {
                        EntradaSaida.saldoNegativo();
                        break;
                    }

                    String sacar = "Saque";
                    valor = EntradaSaida.solicitarInformacoesSaque();
                    while (valor <= 0) {
                        EntradaSaida.msgErro();
                        valor = EntradaSaida.solicitarInformacoesSaque();
                    }
                    this.conta.sacar(valor);

                    movimentacao = new Movimentacao();

                    movimentacao.setTipoMov(sacar);
                    movimentacao.setValor(valor);
                    movimentacao.setData(EntradaSaida.data());
                    this.conta.adicionarMovimentacao(movimentacao);

                    break;

                case 2:
                    String saldo = conta.gerarSaldo();
                    EntradaSaida.exibirSaldo(saldo);
                    break;

                case 3:
                    String dados = conta.gerarDadosDaConta();
                    EntradaSaida.exibirDadosDaConta(dados);

                    break;

                case 4:
                    String extrato = conta.gerarExtrato();
                    EntradaSaida.exibirExtratoCompleto(extrato);

                    break;

                case 5:
                    depositar = "Deposito";
                    String listaDep = conta.gerarExtratoDepositos(depositar);
                    EntradaSaida.exibirExtratoDeDepositos(listaDep);

                    break;

                case 6:
                    sacar = "Saque";
                    String listaSac = conta.gerarExtratoSaques(sacar);
                    EntradaSaida.exibirExtratoDeSaques(listaSac);

                    break;

            }

        } while (opcao != 7);

        EntradaSaida.exibeMsgEncerraPrograma();

        System.exit(0);

    }

}
