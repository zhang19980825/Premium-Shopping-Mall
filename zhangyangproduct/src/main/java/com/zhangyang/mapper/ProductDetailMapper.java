package com.zhangyang.mapper;

import com.zhangyang.model.Product;
import com.zhangyang.model.ProductDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/28 17:24
 */
@Mapper
public interface ProductDetailMapper {
    public int insertProductDetail(ProductDetail productDetail);
    public ProductDetail findproductdetailbyid(int productid);
}
