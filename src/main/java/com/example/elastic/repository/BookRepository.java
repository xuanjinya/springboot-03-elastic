package com.example.elastic.repository;

import com.example.elastic.bean.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;


/**
 * @author huang.beijin
 * @date 2020/3/3 14:49
 * @description
 */
//需要一个 泛型，主键类型
public interface BookRepository extends ElasticsearchRepository<Book,Integer> {

}
