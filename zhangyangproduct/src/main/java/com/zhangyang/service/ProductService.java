package com.zhangyang.service;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.zhangyang.dao.ProductDao;
import com.zhangyang.model.Product;
import com.zhangyang.utils.SolrUtil;
import com.zhangyang.vo.ProductVo;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;

/**
 * @Author: ZhangYang
 * @Date: 2019/5/25 11:17
 */
@Service
public class ProductService {

    @Autowired
    ProductDao productDao;

    @Autowired
    RedisService redisService;

    public void insertProduct(Product product){
        try {
            int id=productDao.insertProduct(product);
            String productjson=JSONObject.toJSONString(product);
            redisService.setkey(product.getId()+"",productjson);
            Map<String,Object>mapVlue = new HashMap<String,Object>();
            mapVlue.put("id",product.getId());
            mapVlue.put("producttitle",product.getProducttitle());
            SolrUtil.addIndex2(mapVlue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Product findproductbyid(int id){
        String value=redisService.getkey(id+"");
        Product product=JSONObject.parseObject(value,Product.class);
        if(product==null){
            product=productDao.findproductbyid(id);
        }
        //System.out.println(value);
        return product;
    }

    public void auditProduct(int id,int auditstate){
        Product product=new Product();
        product.setId(id);
        product.setAuditstate(auditstate);
        product.setAudittime(new Date());
        productDao.auditProduct( product);
    }
    public void upateProduct(Product product){
        productDao.upateProduct(product);
    }
    public void deleteProductbyid(int id){
        productDao.deleteProductbyid(id);
    }
    public List<Product> queryProductbyvo(ProductVo productVo){
        return  productDao.queryProductbyvo(productVo);
    }
    public void updateProductbyproductstatus(int id,int productstatus){
        Product product=new Product();
        product.setId(id);
        product.setProductstatus(productstatus);
        productDao.updateProductbyproductstatus(product);
    }

    public List<Product> queryProductbyids(String keyword){
        List<String>ids=null;
        try {
            ids=SolrUtil.searchqyinfofromsolr(keyword);
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(ids==null||ids.size()==0){
            ids=null;
        }
        return productDao.queryProductbyids(ids);
    }

    public void upateProductbyquartz(Product product){
         productDao.upateProductbyquartz(product);
    }

    public Product findproductbyidwithoutredis(int id){
       Product product=productDao.findproductbyid(id);
       return product;
    }
}
