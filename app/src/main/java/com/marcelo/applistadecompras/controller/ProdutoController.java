package com.marcelo.applistadecompras.controller;

import com.marcelo.applistadecompras.model.Produto;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class ProdutoController implements ICrud<Produto> {
    @Override
    public void insert(Produto obj) {

        Realm realm = Realm.getDefaultInstance();

        Number primaryKey = realm.where(Produto.class).max("id");

        int autoIncrementPrimaryKey = (primaryKey == null) ? 1 : primaryKey.intValue() + 1;

        obj.setId(autoIncrementPrimaryKey);

        realm.beginTransaction();
        realm.copyToRealm(obj);
        realm.commitTransaction();
        realm.close();
    }

    @Override
    public void update(Produto obj) {
        Realm realm = Realm.getDefaultInstance();

        Produto produto = realm.where(Produto.class).equalTo("id", obj.getId()).findFirst();

        if (produto != null) {

            realm.beginTransaction();

            produto.setDataDaInclusao(obj.getDataDaInclusao());
            produto.setNomeDoProduto(obj.getNomeDoProduto());
            produto.setQuantidade(obj.getQuantidade());
            produto.setUnidadeDeMedida(obj.getUnidadeDeMedida());
            produto.setCodigoDeBarras(obj.getCodigoDeBarras());
            produto.setPrecoPago(obj.getPrecoPago());
            produto.setImagemProduto(obj.getImagemProduto());

            realm.commitTransaction();
        }

        realm.close();
    }

    @Override
    public void delete(Produto obj) {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<Produto> results =
                realm.where(Produto.class).equalTo("id", obj.getId()).findAll();

        results.deleteAllFromRealm();

        realm.commitTransaction();

        realm.close();

    }

    @Override
    public void deleteById(int id) {
        Realm realm = Realm.getDefaultInstance();

        realm.beginTransaction();

        RealmResults<Produto> results =
                realm.where(Produto.class).equalTo("id", id).findAll();

        results.deleteAllFromRealm();

        realm.commitTransaction();

        realm.close();
    }

    @Override
    public List<Produto> listar() {
        return null;
    }
}
