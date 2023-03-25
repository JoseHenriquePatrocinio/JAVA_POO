package model;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;



public class Fabrica {

    protected List<Carro> listaDeCarros = new ArrayList<>();

    public void venderCarro(String cor, String modelo) { // retirar carro do array

        boolean verificador = false;
        for (int i = 0; i < this.listaDeCarros.size(); i++) {
            Carro carro = listaDeCarros.get(i);
            if (carro.getModelo().contains(modelo) && carro.getCor().contains(cor)) {
                listaDeCarros.remove(carro);
                verificador = true;
            }

        }

        if (verificador == false) {
            JOptionPane.showMessageDialog(null, "Carro não encontrado");
        }

    }

    public void fabricarCarro(Carro carro) { // adicionar carro no array

        listaDeCarros.add(carro);

    }

    public void gerarInfo() {
        int i = 0;
        for (Carro carro : listaDeCarros) {

            i++;
            System.out.println("Modelo do " + i + "º carro: " + carro.getModelo() + "\n");
            System.out.println("Cor do " + i + "º carro: " + carro.getCor() + "\n");
            System.out.println("Motor do " + i + "º carro: " + carro.getMotor() + "\n");
            System.out.println("Marca do " + i + "º carro: " + carro.getMarca() + "\n");
            System.out.println("\n");
        }

    }

    public void mostrarInfo() {
        int i = 0;
        for (Carro carro : listaDeCarros) {
            String info = "";
            i++;
            info = "Modelo " + i + "º carro: " + carro.getModelo() + "\n";
            info += "Cor " + i + "º carro: " + carro.getCor() + "\n";
            info += "Motor " + i + "º carro: " + carro.getMotor() + "\n";
            info += "Marca " + i + "º carro: " + carro.getMarca() + "\n";
            info += "\n";
            JOptionPane.showMessageDialog(null, info);
        }

    }

}
