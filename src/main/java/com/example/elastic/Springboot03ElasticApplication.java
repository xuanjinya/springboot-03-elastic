package com.example.elastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/*
* SpringBoot 默认支持两种技术和 ES 交互
*   1. Jest (默认不生效)
*     1).需要导入jest的工具包 （io.searchbox.client.JestClient;）
*   2. SpringBoot Elasticsearch
*     1).Client  clusterName clusterNodes
*     2).ElasticsearchTemplate
*     3).编写一个ElasticsearchRepository的子接口来操作ES
* */

@SpringBootApplication
public class Springboot03ElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03ElasticApplication.class, args);
    }

}
