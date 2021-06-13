package cn.urovo.blog.lesson30;


import com.mongodb.*;

import java.util.Arrays;

/**
 * @program: blog
 * @description
 * @author: zheng
 * @create: 2021-03-14 21:23
 **/
public class Test {

    public static void main(String[] args) {

        DBCollection coll = null;

        DB db = getDb("admin");

        try {
            coll = db.getCollection("mycol");
        } catch (Exception e) {
            e.printStackTrace();
        }

        //构建一条数据
        BasicDBObject doc = new BasicDBObject("name", "mongo").append(
                "info", new BasicDBObject("ver", "3.0"));

        //插入数据
//        coll.insert(doc);

        //通过findOne()查找一个符合条件的文档
        DBObject myDoc = coll.findOne();
//        System.out.println(myDoc);
        //构建测试数据
//        for (int i = 0; i < 100; i++) {
//            coll.insert(new BasicDBObject("i", i));
//        }

        //查询所有, 遍历打印数据
        DBCursor cursor = coll.find();
        try {
            while (cursor.hasNext()) {
                System.out.println(cursor.next());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            cursor.close();
        }

        //也可以指定查询的条件
//        BasicDBObject query = new BasicDBObject("i", 71);
//        DBCursor cursor1 = coll.find(query);
//        try {
//            while (cursor1.hasNext()) {
//                System.out.println("2021年3月14日21:53:11" + cursor1.next());
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            cursor1.close();
//        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //db.getCollection('mycol').find({i: {$gte: 50}})
        BasicDBObject query2 = new BasicDBObject("i", new BasicDBObject("$gte", 50));
        DBCursor cursor2 = coll.find(query2);
        try {
            while (cursor2.hasNext()) {
                System.out.println("2021年3月14日22:02:27" + cursor2.next());
            }
        } finally {
            cursor2.close();
        }

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");

        //更新操作
        BasicDBObject query = new BasicDBObject("i", 70);
        BasicDBObject up = new BasicDBObject("$set", new BasicDBObject("i", 100));
        coll.update(query, up);

        //插入操作
        WriteResult result = coll.insert(new BasicDBObject("i", 71));

        //删除操作
        BasicDBObject query3 = new BasicDBObject("i", 71);
        WriteResult remove = coll.remove(query3);
        System.out.println(remove);


    }

    private static DB getDb(String dbName) {
        String sURI = String.format(
                "mongodb://%s:%s@%s:%d/%s", "admin", "admin", "47.115.53.135", 27017, "admin");
        MongoClientURI uri = new MongoClientURI(sURI);
        MongoClient mongoClient = new MongoClient(uri);
        DB db = mongoClient.getDB(dbName);
        return db;
    }
}
