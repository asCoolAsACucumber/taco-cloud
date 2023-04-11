package com.example.tacos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author moon
 * @Date 2023/4/6 20:45
 * @Description 定义taco配料
 */
@Data
public class Ingredient {
    private final String id;
    private final String name;
    private final Type type;

    public enum Type {
        WRAP, PROTEIN, VEGGIES, CHEESE, SAUCE
    }
}
