/**
 * Copyright 2015-2016 the original author or authors.
 * HomePage: http://www.kayura.org
 */
package org.kayura.example.dao;

import java.util.Map;

import org.kayura.example.po.Product;
import org.kayura.mybatis.type.PageBounds;
import org.kayura.type.PageList;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {

	int deleteByKey(Integer id);

	int insert(Product record);

	int insertSelective(Product record);

	Product selectByKey(Integer id);

	PageList<Product> findByMap(Map<String, Object> args, PageBounds pageBounds);

	int updateBySelective(Product record);

	int updateByKey(Product record);
}