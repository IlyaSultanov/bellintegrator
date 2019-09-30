package ru.trihlorid.bellintegrator.validation;

import org.springframework.stereotype.Component;
import ru.trihlorid.bellintegrator.entity.ProductEntity;

@Component
public class Validator {

    public boolean addValidate (ProductEntity productEntity) {
        return productEntity.getName() != null &&
                productEntity.getBrand() != null &&
                productEntity.getCost() != null &&
                productEntity.getQuantity() != null;
    }

    public boolean findValidate (ProductEntity productEntity) {
        return productEntity.getName() != null ||
                productEntity.getBrand() != null;
    }
}
