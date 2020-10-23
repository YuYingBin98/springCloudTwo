package com.jk.yyb.entity;


import lombok.Data;

import java.util.Date;

@Data
public class OrderEntity {

    private Integer orderId;

    private String orderNum;

    private String orderName;

    private String orderPrice;

    private Date orderTime;

    private Integer zhiFuId;

    private String zhiFuName;
}
