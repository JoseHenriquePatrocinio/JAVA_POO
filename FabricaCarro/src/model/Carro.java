package model;

public class Carro {

    protected String cor;
    protected String modelo;
    protected String motor;
    protected String marca;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Carro() {
        setCor(cor);
        setModelo(modelo);
        setMotor(motor);
        setMarca(marca);
    }

}

