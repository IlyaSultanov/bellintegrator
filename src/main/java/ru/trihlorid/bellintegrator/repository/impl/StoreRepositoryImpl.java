package ru.trihlorid.bellintegrator.repository.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.trihlorid.bellintegrator.entity.ProductEntity;
import ru.trihlorid.bellintegrator.entity.Result;
import ru.trihlorid.bellintegrator.repository.StoreRepository;
import ru.trihlorid.bellintegrator.storage.Storage;

@Repository
@AllArgsConstructor
public class StoreRepositoryImpl implements StoreRepository {

    private final Storage storage;

    @Override
    public Result findAll() {
        return storage.findAll();
    }

    @Override
    public Result addProduct(ProductEntity productEntity) {
        return storage.addProduct(productEntity);
    }

    @Override
    public Result delete(ProductEntity productEntity) {
        return storage.delete(productEntity);
    }

}