package view;

import java.util.Calendar;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int solicitaOpcao() {

        String[] opcoes = { "Cadastrar produtos", "Adicionar ao estoque", "Vender Produtos", "Produtos cadastrados",
                "Produtos estoque", "Cupons de venda", "Valor total", "Sair" };

        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione a opção desejada", JOptionPane.OK_CANCEL_OPTION);

        return menu.getSelectedIndex();

    }

    public static String solicitaCodigo() {

        String codigo = JOptionPane.showInputDialog(null, "Digite o codigo do produto");

        return codigo;
    }

    public static String solicitaDescricao() {

        String descricao = JOptionPane.showInputDialog(null, "Digite a descricao do produto");

        return descricao;

    }

    public static double solicitaPreco() {
        double preco = 0;
        String ver = "";
        while (true) {
            ver = JOptionPane.showInputDialog(null, "Digite o preço do produto");
            try {
                preco = Double.parseDouble(ver);
                break;
            } catch (NumberFormatException numErro) {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }

        return preco;
    }

    public static int solicitaQtdeEntrada() {

        int quantidade = 0;
        String ver = "";
        while (true) {
            ver = JOptionPane.showInputDialog(null, "Quantidade de produtos para dar entrada no estoque");
            try {
                quantidade = Integer.parseInt(ver);
                break;
            } catch (NumberFormatException numErro) {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }

        return quantidade;
    }

    public static int solicitaQtdeSaida() {

        int quantidade = 0;
        String ver = "";
        while (true) {
            ver = JOptionPane.showInputDialog(null, "Quantidade de produtos para ser vendido");
            try {
                quantidade = Integer.parseInt(ver);
                break;
            } catch (NumberFormatException numErro) {
                JOptionPane.showMessageDialog(null, "Erro");
            }
        }

        return quantidade;
    }

    public static String exibirData() {

        Calendar calendario = Calendar.getInstance();
        String data = "";
        data += calendario.get(Calendar.DATE) + "/" + calendario.get(Calendar.MONTH) + "/"
                + calendario.get(Calendar.YEAR);

        return data;
    }

    public static void exibirEstoque(String lista) {

        if(lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existe itens em estoque");
        }else {
            JOptionPane.showMessageDialog(null, lista);
        }

    }

    public static void exibirCupons(String lista) {

        if(lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foi gerado cupons");
        }else {
            JOptionPane.showMessageDialog(null, lista);
        }

    }

    public static void exibirListaCadastro(String lista) {

        if(lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não existe produtos cadastrados");
        }else {
            JOptionPane.showMessageDialog(null, lista);
        }

    }

    public static void exibeMsgEncerraPrograma() {
        JOptionPane.showMessageDialog(null, "O programa será encerrado!");
    }

    public static void exibeValorTotal(String valor) {
        if(valor.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não gerou valor");
        }else {
            JOptionPane.showMessageDialog(null, "Valor total gerado: R$" + valor);
        }
    }

    public static void MsgErro() {
        JOptionPane.showMessageDialog(null, "Erro");
        //System.exit(0);
    }

}

