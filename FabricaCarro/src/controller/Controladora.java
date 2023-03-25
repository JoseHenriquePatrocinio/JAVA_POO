package controller;

import view.EntradaSaida;


import model.*;

public class Controladora {

    private Fabrica fabrica = new Fabrica();

    public void exibeMenu() {
        int opcao;
        boolean verificar=false;

        do {

            opcao = EntradaSaida.solicitaOpcao();

            switch (opcao) {

                case 0://Fabricar carros
                    verificar = true;

                    int quantidade = EntradaSaida.solicitaQtde();
                    while(quantidade<=0) {
                        quantidade = EntradaSaida.solicitaQtde();
                        EntradaSaida.msgErro();
                    }

                    for (int i = 0; i < quantidade; i++) {
                        Carro carro = new Carro();
                        carro.setCor(EntradaSaida.solicitaCor(i + 1));
                        carro.setModelo(EntradaSaida.solicitaModelo(i + 1));
                        carro.setMotor(EntradaSaida.solicitaMotor(i + 1));
                        carro.setMarca(EntradaSaida.solicitaMarca(i + 1));
                        this.fabrica.fabricarCarro(carro);
                        fabrica.gerarInfo();
                    }

                    break;

                case 1://Vender um carro
                    if(verificar==false) {
                        EntradaSaida.msgAviso();
                        break;
                    }

                    String cor = (String) EntradaSaida.solicitaCorVenda();
                    String modelo = (String) EntradaSaida.solicitaModeloVenda();


                    this.fabrica.venderCarro(cor, modelo);



                    break;

                case 2://Ver informações dos carros

                    fabrica.mostrarInfo();

                    break;

            }

        } while (opcao != 3);

        EntradaSaida.exibeMsgEncerraPrograma();

        System.exit(0);

    }

}

