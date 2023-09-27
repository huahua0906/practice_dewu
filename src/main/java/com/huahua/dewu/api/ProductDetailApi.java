package com.huahua.dewu.api;

import com.huahua.dewu.model.ProductDetail;
import com.huahua.dewu.model.Result;
import com.huahua.dewu.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * api模块
 * 返回给前端渲染页面的接口，会调用service中的接口
 */

@Controller
@RequestMapping("/api/productdetail")
public class ProductDetailApi {

    @Autowired
    private ProductDetailService productDetailService;
    /**
     * 根据商品Id获取商品详情
     *
     */
    @GetMapping("/productId")
    @ResponseBody
    @CrossOrigin
    public Result<List<ProductDetail>> getProductDetails(@RequestParam("productId") String productId) {

        Result<List<ProductDetail>> result = new Result<>();

        List<ProductDetail> productDetails = productDetailService.getByProductId(productId);

        result.setData(productDetails);
        result.setSuccess(true);
        return result;

    }
}
