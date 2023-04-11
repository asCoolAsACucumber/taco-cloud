package com.example.tacos;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author moon
 * @Date 2023/4/6 21:02
 * @Description taco订单的领域对象：定义了客户如何指定他们想要订购的taco并明确支付信息和投递信息
 */
@Data
public class TacoOrder {
    private String deliveryName;
    private String deliverStreet;
    private String deliveryCity;
    private String deliveryState;
    private String deliveryZip;
    private String ccNumber;
    private String ccExpiration;
    private String ccVVV;

    private List<Taco> tacos= new ArrayList<>();

    public void addTaco(Taco taco) {
        this.tacos.add(taco);
    }
}
