package com.qsj.demo_tests;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import okhttp3.*;
import org.json.JSONObject;

import java.io.*;
import java.util.concurrent.TimeUnit;


/**
 * @Description
 * @Author qsj
 * @Date 2024/09/01
 */
class AI {
    public static final String API_KEY = "in68XSjw9nilgm07qr5T6H0l";
    public static final String SECRET_KEY = "2Ge6l7aTGIyEpUPrPNQUKupkpcgVMkUj";


    static final OkHttpClient HTTP_CLIENT = new OkHttpClient().newBuilder()
            .connectTimeout(3, TimeUnit.MINUTES)
            .writeTimeout(3, TimeUnit.MINUTES)
            .readTimeout(3, TimeUnit.MINUTES)
            .build();

    public static void main(String []args) throws IOException{
        String content = createJsonContent("什么是归并排序");


        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, content);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/rpc/2.0/ai_custom/v1/wenxinworkshop/chat/yi_34b_chat?access_token=" + getAccessToken())
                .method("POST", body)
                .addHeader("Content-Type", "application/json")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        System.out.println(response.body().string());

    }

    private static String createJsonContent(String userInput) throws IOException {
        // 使用 Jackson 的 ObjectMapper 创建 JSON 对象
        ObjectMapper mapper = new ObjectMapper();
        ObjectNode messageNode = mapper.createObjectNode();
        messageNode.put("role", "user");
        messageNode.put("content", userInput);

        ObjectNode rootNode = mapper.createObjectNode();
        rootNode.set("messages", mapper.createArrayNode().add(messageNode));

        // 将 JSON 对象转换为字符串
        return mapper.writeValueAsString(rootNode);
    }


    /**
     * 从用户的AK，SK生成鉴权签名（Access Token）
     *
     * @return 鉴权签名（Access Token）
     * @throws IOException IO异常
     */
    static String getAccessToken() throws IOException {
        MediaType mediaType = MediaType.parse("application/x-www-form-urlencoded");
        RequestBody body = RequestBody.create(mediaType, "grant_type=client_credentials&client_id=" + API_KEY
                + "&client_secret=" + SECRET_KEY);
        Request request = new Request.Builder()
                .url("https://aip.baidubce.com/oauth/2.0/token")
                .method("POST", body)
                .addHeader("Content-Type", "application/x-www-form-urlencoded")
                .build();
        Response response = HTTP_CLIENT.newCall(request).execute();
        return new JSONObject(response.body().string()).getString("access_token");
    }
}