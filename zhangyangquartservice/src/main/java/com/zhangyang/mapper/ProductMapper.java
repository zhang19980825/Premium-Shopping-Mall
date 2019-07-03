package com.zhangyang.mapper;


import com.zhangyang.model.Product;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ProductMapper {
    public List<Product> findproductbyids(List<String> ids);

}
