package com.zhangyang.mapper;

import com.zhangyang.model.Product;
import com.zhangyang.vo.ProductVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:08
 */
@Mapper
public interface ProductMapper {
    public int insertProduct(Product product);
    public void auditProduct(Product product);
    public Product findproductbyid(int id);
    public void upateProduct(Product product);
    public void deleteProductbyid (int id);
    public List<Product> queryProductbyvo(ProductVo productVo);
    public void updateProductbyproductstatus(Product product);
    public List<Product> queryProductbyids(Map<String,List<String>>map);

}
