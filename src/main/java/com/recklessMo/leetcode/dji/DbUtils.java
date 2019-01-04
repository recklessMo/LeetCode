package com.recklessMo.leetcode.dji;

import com.alibaba.fastjson.JSON;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.List;

public class DbUtils {

    private static final DbUtils instances = new DbUtils();

    private DbUtils(){
    }

    public static DbUtils getInstances(){
        return instances;
    }


    private Connection getConnection() {
        String url = "jdbc:mysql://579f4faca25da.sh.cdb.myqcloud.com:4462/dji?useUnicode=true&characterEncoding=UTF-8";
        String username = "cdb_outerroot";
        String password = "Hpf123456Hpf";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }

    public void insertToDb(List<Item> dataList){
        Connection conn = getConnection();

        try {
            conn.createStatement().execute("SET names 'utf8mb4'");
        }catch (Exception e){
            e.printStackTrace();
        }

        String sql = "insert into item_data" +
                "(id,type,title,comment_count,favorite_count,like_count,view_count,image,cdn_url,play_url,slug)" +
                "values" +
                "(null,?,?,?,?,?,?,?,?,?,?)";

        for(Item item : dataList){
            PreparedStatement preparedStatement;
            try{
                preparedStatement = conn.prepareStatement(sql);
                preparedStatement.setString(1, item.getType());
                preparedStatement.setString(2, item.getTitle());
                preparedStatement.setInt(3, item.getComment_count());
                preparedStatement.setInt(4, item.getFavorite_count());
                preparedStatement.setInt(5, item.getLike_count());
                preparedStatement.setInt(6, item.getView_count());
                preparedStatement.setString(7, JSON.toJSONString(item.getImage()));
                preparedStatement.setString(8, JSON.toJSONString(item.getCdn_url()));
                preparedStatement.setString(9, item.getPlay_url());
                preparedStatement.setString(10, item.getSlug());

                preparedStatement.executeUpdate();
                preparedStatement.close();

            }catch(Exception e){
                e.printStackTrace();
                System.out.println(JSON.toJSONString(item));
            }
        }
    }


}
