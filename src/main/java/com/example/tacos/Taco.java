package com.example.tacos;

import lombok.Data;

import java.util.List;

/**
 * @Author moon
 * @Date 2023/4/6 20:57
 * @Description 定义taco设计的领域对象：配料是如何组合在一起的
 */
@Data
public class Taco {
    private String name;
    private List<Ingredient> ingredients;
}
