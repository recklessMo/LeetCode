package com.recklessMo.rpc.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.Date;
import java.util.List;

public class ZSCR {

    public void start() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        for (int i = 51804032; i < 66258108; i++) {
            HttpGet httpget = new HttpGet("http://service.h7tuho5mf.cn/api/v1/cash/conversion?uid=" + i);
            CloseableHttpResponse response1 = httpclient.execute(httpget);
            try {
                System.out.println(response1.getStatusLine());
                HttpEntity entity1 = response1.getEntity();
                System.out.println(EntityUtils.toString(entity1, "UTF-8"));
            } finally {
                response1.close();
            }
            Thread.sleep(600);
        }
    }

    public void open(String url) throws Exception {
        //启用系统默认浏览器来打开网址。
        //判断是否支持Desktop扩展,如果支持则进行下一步
        Runtime rt = Runtime.getRuntime();
        rt.exec("open " + url);
    }

    public static void main(String[] args) throws Exception {
        new ZSCR().start();
//        Gson gson = new GsonBuilder().create();
//        String options = "[\"侯耀文\",\"侯耀中\",\"侯耀华\"]";
//        List<String> answerList = gson.fromJson(options, List.class);
//        System.out.println(answerList);
    }

}
