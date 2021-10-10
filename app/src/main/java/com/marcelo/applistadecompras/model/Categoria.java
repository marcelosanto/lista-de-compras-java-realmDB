package com.marcelo.applistadecompras.model;

import java.util.List;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

public class Categoria extends RealmObject {

    @PrimaryKey
    private int id;

    @Required
    private String nomeDaCategoria;

    private int totalDeProdutos;

    private byte[] imagemCategoria;

    @Ignore
    private List<String> tituloCategoriaSpinner;

    @Ignore
    private List<Categoria> categorias;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeDaCategoria() {
        return nomeDaCategoria;
    }

    public void setNomeDaCategoria(String nomeDaCategoria) {
        this.nomeDaCategoria = nomeDaCategoria;
    }

    public int getTotalDeProdutos() {
        return totalDeProdutos;
    }

    public void setTotalDeProdutos(int totalDeProdutos) {
        this.totalDeProdutos = totalDeProdutos;
    }

    public byte[] getImagemCategoria() {
        return imagemCategoria;
    }

    public void setImagemCategoria(byte[] imagemCategoria) {
        this.imagemCategoria = imagemCategoria;
    }

    public List<String> getTituloCategoriaSpinner() {
        return tituloCategoriaSpinner;
    }

    public void setTituloCategoriaSpinner(List<String> tituloCategoriaSpinner) {
        this.tituloCategoriaSpinner = tituloCategoriaSpinner;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }
}
