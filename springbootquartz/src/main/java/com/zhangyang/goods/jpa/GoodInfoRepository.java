package com.zhangyang.goods.jpa;

import com.zhangyang.goods.entity.GoodInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * ========================
 */
public interface GoodInfoRepository
    extends JpaRepository<GoodInfoEntity,Long>
{
}
