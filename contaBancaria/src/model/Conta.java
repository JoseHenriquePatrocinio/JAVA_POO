package model;

import java.util.ArrayList;
import java.util.List;

public class Conta {

    private String titularDaConta;
    private String tipoConta;
    private double saldo;
    private List<Movimentacao> listaDeMovimentacao = new ArrayList<>();

    public void depositar(double valor) {

        saldo += valor;

    }

    public void sacar(double valor) {

        saldo -= valor;

    }

    public String gerarSaldo() {
        String saldo;

        saldo = "Saldo da conta: R$" + this.getSaldo();
        return saldo;

    }

    public String gerarDadosDaConta() {
        String info;

        info = "Titular da conta: " + this.getTitularDaConta();
        info += "\nTipo de conta: " + this.getTipoConta();
        info += "\nSaldo da conta: R$" + this.getSaldo();

        return info;

    }

    public String gerarExtrato() {
        String extrato = "";

        for (Movimentacao movimentacao : listaDeMovimentacao) {

            extrato += movimentacao.getData() + " - " + movimentacao.getTipoMov() + " - R$" + movimentacao.getValor()
                    + "\n";

        }
        return extrato;

    }

    public String gerarExtratoDepositos(String deposito) {

        String extDep = "";

        for (int i = 0; i < listaDeMovimentacao.size(); i++) {

            Movimentacao movimentacao = listaDeMovimentacao.get(i);

            if (movimentacao.getTipoMov().contains(deposito)) {

                extDep += movimentacao.getData() + " - " + movimentacao.getTipoMov() + " - R$" + movimentacao.getValor()
                        + "\n";

            }

        }
        return extDep;

    }

    public String gerarExtratoSaques(String saque) {

        String extSac = "";

        for (int i = 0; i < listaDeMovimentacao.size(); i++) {

            Movimentacao movimentacao = listaDeMovimentacao.get(i);

            if (movimentacao.getTipoMov().contains(saque)) {

                extSac += movimentacao.getData() + " - " + movimentacao.getTipoMov() + " - R$" + movimentacao.getValor()
                        + "\n";

            }

        }
        return extSac;

    }

    public void adicionarMovimentacao(Movimentacao movimentacao) {
        listaDeMovimentacao.add(movimentacao);
    }

    public String getTitularDaConta() {
        return titularDaConta;
    }

    public void setTitularDaConta(String titularDaConta) {
        this.titularDaConta = titularDaConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Movimentacao> getListaDeMovimentacao() {
        return listaDeMovimentacao;
    }

    public void setListaDeMovimentacao(List<Movimentacao> listaDeMovimentacao) {
        this.listaDeMovimentacao = listaDeMovimentacao;
    }

    public Conta() {
        setTitularDaConta(titularDaConta);
        setTipoConta(tipoConta);
        setSaldo(saldo);
    }

}

