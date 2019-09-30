package ru.trihlorid.bellintegrator.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.trihlorid.bellintegrator.service.StoreService;
import ru.trihlorid.bellintegrator.entity.ProductEntity;
import ru.trihlorid.bellintegrator.entity.Result;
import ru.trihlorid.bellintegrator.repository.StoreRepository;
import ru.trihlorid.bellintegrator.validation.Validator;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class StoreServiceImpl implements StoreService {

    private final StoreRepository storeRepository;
    private final Validator validator;

    @Override
    public Result addProduct(ProductEntity productEntity) {
        if (validator.addValidate(productEntity)) {
            if (isAlreadyIn(storeRepository.findAll().getProductList(), productEntity) > 0) {
                return new Result("Такой продукт уже есть в хранилище", 1, null);
            } else {
                return storeRepository.addProduct(productEntity);
            }
        } else {
            return new Result("Ошибка валидации", 2, null);
        }
    }

    @Override
    public Result findProduct(ProductEntity productEntity) {
        if (validator.findValidate(productEntity)) {
            if (productEntity.getName() == null || productEntity.getBrand() == null) {
                if (productEntity.getName() == null) {
                    if (storeRepository.findAll().getProductList().stream().anyMatch(p -> productEntity.getBrand().equals(p.getBrand()))) {
                        return new Result("Success", 0, storeRepository.findAll().getProductList().stream()
                                .filter(p -> productEntity.getBrand().equals(p.getBrand()))
                                .collect(Collectors.toList()));
                    } else {
                        return new Result("Не найдено", 1, null);
                    }
                } else {
                    if (storeRepository.findAll().getProductList().stream().anyMatch(p -> productEntity.getName().equals(p.getName()))) {
                        return new Result("Success", 0, storeRepository.findAll().getProductList().stream()
                                .filter(p -> productEntity.getName().equals(p.getName()))
                                .collect(Collectors.toList()));
                    } else {
                        return new Result("Не найдено", 1, null);
                    }
                }
            } else {
                if (isAlreadyIn(storeRepository.findAll().getProductList(), productEntity) > 0) {
                    return new Result("Success", 0, storeRepository.findAll().getProductList().stream()
                            .filter(p -> productEntity.getBrand().equals(p.getBrand()))
                            .filter(p -> productEntity.getName().equals(p.getName()))
                            .collect(Collectors.toList()));
                } else {
                    return new Result("Не найдено", 1, null);
                }
            }
        } else {
            return new Result("Ошибка валидации", 2, null);
        }
    }

    @Override
    public Result deleteProduct(ProductEntity productEntity) {
        if (validator.findValidate(productEntity)) {
            if (findProduct(productEntity).getProductList().size() > 0) {
                return storeRepository.delete(productEntity);
            } else {
                return new Result("Не найдено", 1, null);
            }
        } else {
            return new Result("Ошибка валидации", 2, null);
        }
    }

    @Override
    public Result rewriteProduct(ProductEntity productEntity) {
        if (validator.addValidate(productEntity)) {
            storeRepository.delete(productEntity);
            return storeRepository.addProduct(productEntity);
        } else {
            return new Result("Ошибка валидации", 2, null);
        }
    }

    @Override
    public Result findHeels() {
        return new Result("Success", 0, storeRepository.findAll().getProductList().stream()
                .filter(p -> p.getQuantity() < 6)
                .collect(Collectors.toList()));
    }

    private Long isAlreadyIn(List<ProductEntity> list, ProductEntity productEntity) {
        return list.stream()
                .filter(p -> productEntity.getName().equals(p.getName()))
                .filter(p -> productEntity.getBrand().equals(p.getBrand()))
                .count();
    }
}
