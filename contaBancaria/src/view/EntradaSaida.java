package view;

import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int solicitaOpcao() {

        String[] opcoes = { "Depositar", "Sacar", "Ver saldo", "Dados da conta", "Extrato completo",
                "Extrato de depositos", "Extrato de saques", "Sair" };

        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);

        return menu.getSelectedIndex();

    }

    public static String solicitaTitular() {
        String nome;
        nome = JOptionPane.showInputDialog("Digite o nome do titular da conta");
        return nome;
    }

    public static String solicitaTipo() {

        String tipo = "";
        String[] opcoes = { "Corrente", "Poupança" };
        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione o tipo da conta", JOptionPane.OK_CANCEL_OPTION);

        for (int i = 0; i < 2; i++) {
            if (i == menu.getSelectedIndex()) {
                tipo = opcoes[i];
            }
        }

        return tipo;
    }

    public static double solicitarInformacoesDeposito() {

        double valorDep = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe o valor do deposito"));
        return valorDep;
    }

    public static double solicitarInformacoesSaque() {

        double valorSac = Double.parseDouble(JOptionPane.showInputDialog(null,"Informe o valor do saque"));
        return valorSac;

    }

    public static void exibirSaldo(String saldo) {

        JOptionPane.showMessageDialog(null,saldo);

    }

    public static void exibirDadosDaConta(String dados) {

        JOptionPane.showMessageDialog(null,dados);

    }

    public static void exibirExtratoCompleto(String extrato) {

        JOptionPane.showMessageDialog(null,extrato);

    }

    public static void exibirExtratoDeDepositos(String listaDep) {

        JOptionPane.showMessageDialog(null,listaDep);

    }

    public static void exibirExtratoDeSaques(String listaSac) {

        JOptionPane.showMessageDialog(null,listaSac);

    }

    public static void exibeMsgEncerraPrograma() {
        JOptionPane.showMessageDialog(null, "O programa será encerrado!");
    }

    public static String data() {

        Calendar calendario = Calendar.getInstance();
        String data = "";
        data+= calendario.get(Calendar.DATE) + "/" + calendario.get(Calendar.MONTH) + "/" + calendario.get(Calendar.YEAR);

        return data;
    }

    public static void msgErro() {
        JOptionPane.showMessageDialog(null, "Digite um valor válido");
    }

    public static void saldoNegativo() {
        JOptionPane.showMessageDialog(null, "Limite de saque atingido");
    }
}
