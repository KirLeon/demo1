package com.example.demo.service;

import com.example.demo.production.Production;

import java.util.List;

public interface ProductionService {

    void create(Production prod);

    List<Production> readAll();

    Production read(int id);

    boolean update(Production prod, int id);

    boolean delete(int id);
}
