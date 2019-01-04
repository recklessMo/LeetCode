package com.recklessMo.leetcode.dji;

import com.alibaba.fastjson.JSON;

public class Item {

    private String type;
    private String title;
    private int comment_count;
    private int favorite_count;
    private int like_count;
    private int view_count;
    private Url image;
    private Url cdn_url;
    private String play_url;
    private String slug;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getComment_count() {
        return comment_count;
    }

    public void setComment_count(int comment_count) {
        this.comment_count = comment_count;
    }

    public int getFavorite_count() {
        return favorite_count;
    }

    public void setFavorite_count(int favorite_count) {
        this.favorite_count = favorite_count;
    }

    public int getLike_count() {
        return like_count;
    }

    public void setLike_count(int like_count) {
        this.like_count = like_count;
    }

    public int getView_count() {
        return view_count;
    }

    public void setView_count(int view_count) {
        this.view_count = view_count;
    }

    public Url getImage() {
        return image;
    }

    public void setImage(Url image) {
        this.image = image;
    }

    public Url getCdn_url() {
        return cdn_url;
    }

    public void setCdn_url(Url cdn_url) {
        this.cdn_url = cdn_url;
    }

    public String getPlay_url() {
        return play_url;
    }

    public void setPlay_url(String play_url) {
        this.play_url = play_url;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this);
    }

}
