package com.huahua.dewu.service;

import com.huahua.dewu.model.Paging;
import com.huahua.dewu.param.BasePageParam;
import com.huahua.dewu.model.Product;

/**
 * service模块
 * 用于处理业务逻辑，会调用dao层类中的方法
 * 此处的方法全为interface
 */

public interface ProductService {

    /**
     * 增加或修改商品
     *
     * @param product 商品
     * @return Product
     */
    int save(Product product);

    /**
     * 分页查询商品
     *
     * @param param 商品分页参数
     * @return PagingData<Product>
     */
    Paging<Product> pageQueryProduct(BasePageParam param);

    /**
     * 根据主键id获取商品信息
     *
     * @param id 主键id
     * @return Product
     */
    Product get(String id);
}
