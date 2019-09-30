package ru.trihlorid.bellintegrator.storage;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.trihlorid.bellintegrator.entity.ProductEntity;
import ru.trihlorid.bellintegrator.entity.Result;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class Storage {

    private final List<ProductEntity> storage = new ArrayList<>();


    public Result findAll() {
        return new Result("Success", 0, storage);
    }

    public Result addProduct(ProductEntity productEntity) {
        storage.add(productEntity);
        ArrayList<ProductEntity> result = new ArrayList<>();
        result.add(productEntity);
        return new Result("Success", 0, result);
    }

    public Result delete(ProductEntity productEntity) {
        if (productEntity.getName() == null || productEntity.getBrand() == null) {
            if (productEntity.getName() == null) {
                storage.removeIf(ent -> ent.getBrand().equals(productEntity.getBrand()));
                return new Result("Success", 0, null);
            } else {
                storage.removeIf(ent -> ent.getName().equals(productEntity.getName()));
                return new Result("Success", 0, null);
            }
        } else {
            storage.removeIf(ent -> ent.getName().equals(productEntity.getName()) && ent.getBrand().equals(productEntity.getBrand()));
            return new Result("Success", 0, null);
        }
    }
}