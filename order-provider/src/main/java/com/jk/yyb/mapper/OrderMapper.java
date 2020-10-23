package com.jk.yyb.mapper;

import com.jk.yyb.entity.OrderEntity;
import com.jk.yyb.entity.OrderEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Delete("delete from tb_order where order_id=#{id}")
    void deleteByPrimaryKey(Integer id);

    @Insert("insert into tb_order values(#{orderId},#{orderNum},#{orderName},#{orderPrice},null,#{zhifuId)")
    void insert(OrderEntity order);
    @Select("select * from tb_order o left join tb_zhifu z on o.zhifu_id=z.zhifu_id where order_id=#{id}")
    OrderEntity selectByPrimaryKey(Integer id);

    @Select("select * from tb_order o left join tb_zhifu z on o.zhifu_id=z.zhifu_id")
    List<OrderEntity> find();

    @Update("update tb_order set orderNum=#{orderNum},orderName=#{orderName},orderPrice=#{orderPrice},zhifuId=#{zhifuId} where order_id=#{id}")
    void update(OrderEntity order);
}