package com.recklessMo.rpc.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.*;

public class CDDH {

    private Set<String> questionSet = new HashSet<>();

    public void start() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpget = new HttpGet("http://htpmsg.jiecaojingxuan.com/msg/current");
        ResponseHandler<MyJsonObject> rh = new ResponseHandler<MyJsonObject>() {
            @Override
            public MyJsonObject handleResponse(
                    final HttpResponse response) throws IOException {
                StatusLine statusLine = response.getStatusLine();
                HttpEntity entity = response.getEntity();
                if (statusLine.getStatusCode() >= 300) {
                    throw new HttpResponseException(
                            statusLine.getStatusCode(),
                            statusLine.getReasonPhrase());
                }
                if (entity == null) {
                    throw new ClientProtocolException("Response contains no content");
                }
                Gson gson = new GsonBuilder().create();
                ContentType contentType = ContentType.getOrDefault(entity);
                Charset charset = contentType.getCharset();
                Reader reader = new InputStreamReader(entity.getContent(), charset);
                return gson.fromJson(reader, MyJsonObject.class);
            }
        };
        while (true) {
            try {
                MyJsonObject res = httpclient.execute(httpget, rh);
                if (res.getMsg().equals("成功")) {
                    String desc = res.getData().getEvent().getDesc();
                    String question = desc;
                    String options = res.getData().getEvent().getOptions();
                    if (!questionSet.contains(question)) {
                        inner(question, options);
                        questionSet.add(question);
                    }
                } else {
                    System.out.println(new Date() + ", 等待题目！");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            Thread.sleep(500);
        }
    }

    public void inner(String question, String options) throws Exception{
        System.out.println("get question:   " + question);
        System.out.println(options);
        Gson gson = new GsonBuilder().create();
        List<String> answerList = gson.fromJson(options, List.class);
        String questionNew = question.trim().replaceAll(" *", "");
        String questionUrl = "https://www.baidu.com/s?wd=" + URLEncoder.encode(questionNew, "UTF-8");
        open(questionUrl);
        StringBuilder sb = new StringBuilder(questionNew);
        for (String answer : answerList) {
            String answerNew = answer.trim().replaceAll(" *", "");
            sb.append(answerNew);
            sb.append(" ");
        }
        String str = sb.toString();
        String questionNewUrl = "https://www.baidu.com/s?wd=" + URLEncoder.encode(str, "UTF-8");
        open(questionNewUrl);
    }

    public void open(String url) throws Exception {
        //启用系统默认浏览器来打开网址。
        //判断是否支持Desktop扩展,如果支持则进行下一步
        Runtime rt = Runtime.getRuntime();
        rt.exec("open " + url);
    }

    public static void main(String[] args) throws Exception {

        CDDH cddh = new CDDH();

        cddh.start();

//
//        String question = "下列那部  不是迪士尼制作的？ ";
//        String options = "[\" 侯耀文\",\"侯耀 中\",\" 侯耀华\"]";
//        cddh.inner(question, options);

    }


}

class MyJsonObject {
    private int code;
    private String msg;
    private Inner data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Inner getData() {
        return data;
    }

    public void setData(Inner data) {
        this.data = data;
    }
}

class Inner {
    private String type;
    private InnerEvent event;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public InnerEvent getEvent() {
        return event;
    }

    public void setEvent(InnerEvent event) {
        this.event = event;
    }
}

class InnerEvent {
    private int answerTime;
    private String desc;
    private int displayOrder;
    private int liveId;
    private String options;
    private int questionId;
    private long showTime;
    private int status;
    private String type;

    InnerEvent() {
    }

    public int getAnswerTime() {
        return answerTime;
    }

    public void setAnswerTime(int answerTime) {
        this.answerTime = answerTime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(int displayOrder) {
        this.displayOrder = displayOrder;
    }

    public int getLiveId() {
        return liveId;
    }

    public void setLiveId(int liveId) {
        this.liveId = liveId;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public long getShowTime() {
        return showTime;
    }

    public void setShowTime(long showTime) {
        this.showTime = showTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}