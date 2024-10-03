package com.qsj.demo_tests.ES.index;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.io.IOException;

import static com.qsj.demo_tests.constant.INDEX_TEMPLATE;

/**
 * @Description
 * @Author qsj
 * @Date 2024/07/18
 */
@SpringBootTest
public class indexTest {
 @Resource
 private RestHighLevelClient client;
    /**
     * 创建索引库
     */
    @Test
    public void createIndex() {

        CreateIndexRequest request1 = new CreateIndexRequest("test");
        request1.source(INDEX_TEMPLATE, XContentType.JSON);
        try {
            client.indices().create(request1, RequestOptions.DEFAULT);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 查询索引库
     * @throws IOException
     */
    @Test
    public void getIndex() throws IOException {
        GetIndexRequest request = new GetIndexRequest("test");
        boolean exists = client.indices().exists(request, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    /**
     * 删除索引库
     * @throws IOException
     */
    @Test
    public void deleteIndex() throws IOException {
        DeleteIndexRequest request = new DeleteIndexRequest("test");
        AcknowledgedResponse delete = client.indices().delete(request, RequestOptions.DEFAULT);
        System.out.println("删除成功");
    }
    @AfterEach
    void tearDown() throws IOException {
        this.client.close();
    }
}
