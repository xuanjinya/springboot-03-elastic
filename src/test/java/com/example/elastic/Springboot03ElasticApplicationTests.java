package com.example.elastic;

import com.example.elastic.bean.Article;
import com.example.elastic.bean.Book;
import com.example.elastic.repository.BookRepository;
import io.searchbox.client.JestClient;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot03ElasticApplicationTests {

    @Autowired
    JestClient jestClient;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test02() {
        Book book = new Book();
        book.setId(1);
        book.setBookName("西游记");
        book.setAuthor("吴承恩");
        bookRepository.index(book);
    }

    @Test
    public void test03() {
        List<Book> books = bookRepository.findByBookNameLike("游记");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    @Test
    public void contextLoads() {
        //1.给ES中索引保存一个文档
        Article article = new Article();
        article.setId(1);
        article.setTitle("好消息");
        article.setAuthor("张三");
        article.setContent("Hello world");
        article.setContent("Hello world");

        //构建一个索引
        Index index = new Index.Builder(article).index("atguigu").type("news").build();
        try {
            jestClient.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void search() {
        String json = "{\n" +
                "    \"query\" : {\n" +
                "        \"match\" : {\n" +
                "            \"content\" : \"Hello\"\n" +
                "        }\n" +
                "    }\n" +
                "}";
        //构建搜索
        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
        //执行
        try {
            SearchResult result = jestClient.execute(search);
            //打印出来
            System.out.println(result.getJsonString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
