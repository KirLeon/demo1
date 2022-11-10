package com.example.demo.service;

import com.example.demo.production.Production;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class ProductionServiceOperator implements ProductionService{

    //Хранилище продукции
    private static final Map<Integer, Production> PRODUCTION_REPOSITORY_MAP = new HashMap<>();

    //Переменная для генерации ID продукции
    private static final AtomicInteger PRODUCTION_ID_HOLDER = new AtomicInteger();


    @Override
    public void create(Production prod) {
        final int prodId = PRODUCTION_ID_HOLDER.incrementAndGet();
        prod.setId(prodId);
        PRODUCTION_REPOSITORY_MAP.put(prodId, prod);
    }

    @Override
    public List<Production> readAll() {
        return new ArrayList<>(PRODUCTION_REPOSITORY_MAP.values());
    }

    @Override
    public Production read(int id) {
        return PRODUCTION_REPOSITORY_MAP.get(id);
    }

    @Override
    public boolean update(Production prod, int id) {
        if(PRODUCTION_REPOSITORY_MAP.containsKey(id)){
            prod.setId(id);
            PRODUCTION_REPOSITORY_MAP.put(id, prod);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        return PRODUCTION_REPOSITORY_MAP.remove(id) != null;
    }
}
