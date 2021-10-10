package com.marcelo.applistadecompras.controller;

import java.util.List;

public interface ICrud<T> {

    public void insert(T obj);

    public void update(T obj);

    public void delete(T obj);

    public void deleteById(int id);

    public List<T> listar();
}
