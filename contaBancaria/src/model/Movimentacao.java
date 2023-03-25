package model;

public class Movimentacao {
    private String tipoMov;
    private double valor;
    private String data;

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Movimentacao() {
        setTipoMov(tipoMov);
        setValor(valor);
        setData(data);
    }


}

