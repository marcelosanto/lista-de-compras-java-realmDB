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
}
