package org.imooc.Dao;

import org.imooc.bean.Ad;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository("AdDao")
public interface AdDao {
    int insert(Ad ad);
    // int 表示数据库修改的条数 删除的时候也需要添加。
}
