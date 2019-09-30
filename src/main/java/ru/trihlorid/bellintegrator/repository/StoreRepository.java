package ru.trihlorid.bellintegrator.repository;

import ru.trihlorid.bellintegrator.entity.ProductEntity;
import ru.trihlorid.bellintegrator.entity.Result;

public interface StoreRepository {

    Result findAll();

    Result addProduct(ProductEntity productEntity);

    Result delete(ProductEntity productEntity);

}
