package ru.trihlorid.bellintegrator.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.trihlorid.bellintegrator.service.StoreService;
import ru.trihlorid.bellintegrator.entity.ProductEntity;
import ru.trihlorid.bellintegrator.entity.Result;

@RestController
public class StoreController {

    public static final String BASE_PREFIX = "/storage";
    public static final String ADD_PRODUCT = BASE_PREFIX + "/add";
    public static final String FIND_PRODUCT = BASE_PREFIX + "/find";
    public static final String DELETE_PRODUCT = BASE_PREFIX + "/delete";
    public static final String REWRITE_PRODUCT = BASE_PREFIX + "/rewrite";
    public static final String FIND_HEELS = BASE_PREFIX + "/heels";

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @ApiOperation("Добавление нового продукта")
    @PostMapping(ADD_PRODUCT)
    public Result addProduct(@RequestBody ProductEntity productEntity) {
        return storeService.addProduct(productEntity);
    }

    @ApiOperation("Поиск продукта")
    @PostMapping(FIND_PRODUCT)
    public Result findProduct(@RequestBody ProductEntity productEntity) {
        return storeService.findProduct(productEntity);
    }

    @ApiOperation("Удаление продукта")
    @PostMapping(DELETE_PRODUCT)
    public Result deleteProduct(@RequestBody ProductEntity productEntity) {
        return storeService.deleteProduct(productEntity);
    }

    @ApiOperation("Перезапись продукта")
    @PostMapping(REWRITE_PRODUCT)
    public Result rewriteProduct(@RequestBody ProductEntity productEntity) {
        return storeService.rewriteProduct(productEntity);
    }

    @ApiOperation("Поиск остатков")
    @PostMapping(FIND_HEELS)
    public Result findHeels() {
        return storeService.findHeels();
    }

}
