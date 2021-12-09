/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos.entidades;

/**
 *
 * @author M
 */
public class Professor {

    //Atributos
    private int id = 0;
    private int matricula = 0;
    private String nome = "";
    private String telefone = "";
    private String email = "";
    private String endereco = "";
    private String titulacao = "";
    private Escola escola = null;

    //Metodos
    public Professor() {
    }

    public Professor(int id, int matricula, String nome, String telefone,
            String email, String endereco, String titulacao, Escola escola) {
        this.id = id;
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.titulacao = titulacao;
        this.escola = escola;
    }

    public Professor(Professor obj) {
        this.id = obj.getId();
        this.matricula = obj.getMatricula();
        this.nome = obj.getNome();
        this.telefone = obj.getTelefone();
        this.email = obj.getEmail();
        this.endereco = obj.getEndereco();
        this.titulacao = obj.getTitulacao();
        this.escola = obj.getEscola();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public Escola getEscola() {
        return escola;
    }

    public void setEscola(Escola escola) {
        this.escola = escola;
    }

    @Override
    public String toString() {
        return "Professor{" + "id=" + id
                + ", matricula=" + matricula
                + ", nome=" + nome
                + ", telefone=" + telefone
                + ", email=" + email
                + ", endereco=" + endereco
                + ", titulacao=" + titulacao
                + ", escola=" + escola
                + '}';
    }

}
