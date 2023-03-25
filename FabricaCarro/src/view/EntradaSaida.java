package view;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class EntradaSaida {

    public static int solicitaOpcao() {

        String[] opcoes = { "Fabricar carros", "Vender um carro", "Ver informa��es dos carros", "Sair" };

        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione a op��o desejada", JOptionPane.OK_CANCEL_OPTION);

        return menu.getSelectedIndex();

    }

    public static void exibeMsgEncerraPrograma() {
        JOptionPane.showMessageDialog(null, "O programa ser� encerrado!");
    }

    public static String solicitaCor(int ordem) {

        String cor = "";
        String[] opcoes = { "Preto", "Branco", "Prata", "Azul" };
        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Cor desejada do " + ordem + "� carro", JOptionPane.OK_CANCEL_OPTION);

        for (int i = 0; i < 4; i++) {
            if (i == menu.getSelectedIndex()) {
                cor = opcoes[i];
            }
        }

        return cor;
    }

    public static String solicitaModelo(int ordem) {

        String modelo = "";
        String[] opcoes = { "Hatchback", "Sed�", "SUV", "Esportivo" };
        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Modelo desejado do " + ordem + "� carro",
                JOptionPane.OK_CANCEL_OPTION);

        for (int i = 0; i < 4; i++) {
            if (i == menu.getSelectedIndex()) {
                modelo = opcoes[i];
            }
        }

        return modelo;
    }

    public static String solicitaMotor(int ordem) {

        String motor = "";
        String[] opcoes = { "1.0", "2.0", "V6", "V8" };
        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Motor desejado do " + ordem + "� carro",
                JOptionPane.OK_CANCEL_OPTION);

        for (int i = 0; i < 4; i++) {
            if (i == menu.getSelectedIndex()) {
                motor = opcoes[i];
            }
        }

        return motor;
    }

    public static String solicitaMarca(int ordem) {

        String marca = "";
        String[] opcoes = { "Toyota", "Volkswagen", "Fiat", "Chevrolet" };
        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Marca desejada do " + ordem + "� carro",
                JOptionPane.OK_CANCEL_OPTION);

        for (int i = 0; i < 4; i++) {
            if (i == menu.getSelectedIndex()) {
                marca = opcoes[i];
            }
        }

        return marca;
    }

    public static int solicitaQtde() {
        return Integer.parseInt(JOptionPane.showInputDialog("Digite a quantidade de carros que deseja fabricar"));
    }

    public static Object solicitaCorVenda() {

        String[] opcoes = { "Preto", "Branco", "Prata", "Azul" };

        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione cor do carro", JOptionPane.OK_CANCEL_OPTION);

        return menu.getSelectedItem();
    }

    public static Object solicitaModeloVenda() {
        String[] opcoes = { "Hatchback", "Sed�", "SUV", "Esportivo" };

        JComboBox<String> menu = new JComboBox<String>(opcoes);
        JOptionPane.showConfirmDialog(null, menu, "Selecione modelo do carro", JOptionPane.OK_CANCEL_OPTION);

        return menu.getSelectedItem();
    }

    public static void msgErro() {
        JOptionPane.showMessageDialog(null, "Digite um valor v�lido");
    }

    public static void msgAviso() {
        JOptionPane.showMessageDialog(null, "Nenhum carro foi fabricado");
    }

}
