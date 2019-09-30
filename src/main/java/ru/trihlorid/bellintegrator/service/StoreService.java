package ru.trihlorid.bellintegrator.service;

import ru.trihlorid.bellintegrator.entity.ProductEntity;
import ru.trihlorid.bellintegrator.entity.Result;

public interface StoreService {

    Result addProduct(ProductEntity productEntity);

    Result findProduct(ProductEntity productEntity);

    Result deleteProduct(ProductEntity productEntity);

    Result rewriteProduct(ProductEntity productEntity);

    Result findHeels();

}
