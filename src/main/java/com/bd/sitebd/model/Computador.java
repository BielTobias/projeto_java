package com.bd.sitebd.model;

public class Computador {
    
    private int id;
    private String modelo;
    private String defeito;

    public Computador(){ // é utilizado para criar uma instância da classe Computador sem inicializar os valores
                         // pode ser usado, por exemplo, quando o formulário não tem informações iniciais
    }

    public Computador(int id, String modelo, String defeito) {
        this.id = id;
        this.modelo = modelo;
        this.defeito = defeito;
    }

    public Computador(String modelo, String defeito) { //construtor sem id pois o mesmo é gerado automaticamente
        this.modelo = modelo;
        this.defeito = defeito;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDefeito() {
        return defeito;
    }

    public void setDefeito(String defeito) {
        this.defeito = defeito;
    }
}