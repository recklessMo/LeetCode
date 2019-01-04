package com.recklessMo.leetcode.dji;

import com.alibaba.fastjson.JSON;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.util.LinkedList;
import java.util.List;


class CategoryResult {
    private int status;
    private List<Tag> tags = new LinkedList<>();

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<Tag> getTags() {
        return tags;
    }/**/

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
}

class ItemResult {
    private ItemData data = new ItemData();

    public ItemData getData() {
        return data;
    }

    public void setData(ItemData data) {
        this.data = data;
    }
}

class ItemData {
    private List<Item> items = new LinkedList<>();

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}


public class Test {

    private OkHttpClient client = new OkHttpClient();


    public List<Tag> getTags() {
        int page = 0;
        int page_size = 10;

        List<Tag> resultList = new LinkedList<>();
        CategoryResult categoryResult = null;
        do {
            page += 1;
            String url = "https://www.skypixel.com/api/website/tag_categories/category?" + "page=" + page + "&page_size=" + page_size;
            try {
                Request request = new Request.Builder().url(url).build();
                Response response = client.newCall(request).execute();
                String result = response.body().string();
                categoryResult = JSON.parseObject(result, CategoryResult.class);
                if (categoryResult.getTags() != null) {
                    resultList.addAll(categoryResult.getTags());
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {

            }
        } while (categoryResult != null && categoryResult.getTags().size() > 0);
        return resultList;
    }


    public List<Item> getVideosByTag(Tag tag) {
        int limit = 15;
        int offset = -15;
        List<Item> itemList = new LinkedList<>();
        ItemResult itemResult = null;
        do {
            offset += limit;
            String url = "https://www.skypixel.com/api/v2/tags/" + tag.getId() + "/works?lang=zh-CN&platform=web&device=desktop&sort=hot&limit=" + limit + "&offset=" + offset;
            System.out.println(url);
            try {
                Request request = new Request.Builder().url(url).build();
                Response response = client.newCall(request).execute();
                String result = response.body().string();
                itemResult = JSON.parseObject(result, ItemResult.class);
                if (itemResult.getData().getItems() != null) {
                    itemList.addAll(itemResult.getData().getItems());
                }
                Thread.sleep(50);
            } catch (Exception e) {
                offset -= limit;
                e.printStackTrace();
            } finally {

            }
        } while (itemResult != null && itemResult.getData().getItems().size() > 0);
        return itemList;
    }


    public static void main(String[] args) {

        Test test = new Test();
        List<Tag> result = test.getTags();

        for (Tag tag : result) {
            List<Item> itemList = test.getVideosByTag(tag);
            //异步插入
            new Thread(() -> {
                System.out.println("数据size" + itemList.size());
                System.out.println("准备插入!");
                DbUtils.getInstances().insertToDb(itemList);
                System.out.println("插入成功!");
            }).start();
        }


        String x = (String)null;

    }

}
