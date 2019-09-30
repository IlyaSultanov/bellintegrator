package ru.trihlorid.bellintegrator.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.util.List;

@ApiModel(description = "Статус проверки ПИН карты в Online")
@Accessors(chain = true)
@Getter
@Setter
@AllArgsConstructor
public class Result {

    @JsonProperty("message")
    @ApiModelProperty("Сообщение")
    private String message;

    @JsonProperty("code")
    @ApiModelProperty("Код")
    private int code;

    @ApiModelProperty("Список товаров")
    @JsonProperty("Product_list")
    private List<ProductEntity> productList;

}
