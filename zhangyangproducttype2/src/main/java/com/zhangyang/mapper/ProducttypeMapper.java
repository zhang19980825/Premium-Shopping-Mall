package com.zhangyang.mapper;

import com.zhangyang.model.ProductType;
import com.zhangyang.vo.ProductTypeVo;

import java.util.List;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/22 17:49
 */
public interface ProducttypeMapper {
    public void insertProducttype(ProductType productType);
    public ProductType findProducttypeByid(int id);
    public void updateProducttype(ProductType producttype);
    public List<ProductType> queryListbyvo(ProductTypeVo productTypeVo);
    public void delProducttypeByid(int id);
    public List<ProductType> listallproduct();

}
