package com.marcelo.applistadecompras.controller;

import com.marcelo.applistadecompras.model.Categoria;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CategoriaController implements ICrud<Categoria> {
    @Override
    public void insert(Categoria obj) {
        Realm realm = Realm.getDefaultInstance();

        Number primaryKey = realm.where(Categoria.class).max("id");

        int autoIncrementPrimaryKey = (primaryKey == null) ? 1 : primaryKey.intValue() + 1;

        obj.setId(autoIncrementPrimaryKey);

        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void update(Categoria obj) {

        Realm realm = Realm.getDefaultInstance();

        Categoria categoria = realm.where(Categoria.class).equalTo("id", obj.getId()).findFirst();

        if (categoria != null) {

            realm.beginTransaction();
            categoria.setNomeDaCategoria(obj.getNomeDaCategoria());
            categoria.setImagemCategoria(obj.getImagemCategoria());
            realm.commitTransaction();
        }

        realm.close();
    }

    @Override
    public void delete(Categoria obj) {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<Categoria> results =
                realm.where(Categoria.class).equalTo("id", obj.getId()).findAll();

        results.deleteAllFromRealm();

        realm.commitTransaction();

        realm.close();
    }

    @Override
    public void deleteById(int id) {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<Categoria> results =
                realm.where(Categoria.class).equalTo("id", id).findAll();

        results.deleteAllFromRealm();

        realm.commitTransaction();

        realm.close();
    }

    @Override
    public List<Categoria> listar() {
        return null;
    }
}
