package ru.trihlorid.bellintegrator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@ApiModel(description = "Продукт")
@Data
public class ProductEntity {

    @JsonProperty("name")
    @ApiModelProperty("Наименование продукта")
    private String name;

    @JsonProperty("brand")
    @ApiModelProperty("Наименование бренда")
    private String brand;

    @JsonProperty("cost")
    @ApiModelProperty("Цена")
    private BigDecimal cost;

    @JsonProperty("quantity")
    @ApiModelProperty("Количество")
    private Long quantity;

}