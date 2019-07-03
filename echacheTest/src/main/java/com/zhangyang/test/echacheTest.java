package com.zhangyang.test;

/**
 * @Author: ZhangYang
 * @Date: 2019/6/1 18:08
 */
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

public class echacheTest {

    public static void main(String[] args) {

        // 1. 创建缓存管理器
        CacheManager cacheManager = CacheManager.create("D:\\Test\\zhangyangshop\\echacheTest\\src\\main\\resources\\echache.xml");

        // 2. 获取缓存对象
        Cache cache = cacheManager.getCache("HelloWorldCache");

        // 3. 创建元素
        Element element = new Element("key1", "value1");

        // 4. 将元素添加到缓存
        cache.put(element);

        // 5. 获取缓存
        Element value = cache.get("key1");
        System.out.println(value);
        System.out.println(value.getObjectValue());

        // 6. 删除元素
        cache.remove("key1");


        Dog dog = new Dog(1, "taidi", 2);
        Element element2 = new Element("taidi", dog);
        cache.put(element2);
        Element value2 = cache.get("taidi");
        Dog dog2 = (Dog) value2.getObjectValue();
        System.out.println(dog2);

        System.out.println(cache.getSize());

        // 7. 刷新缓存
        cache.flush();

        // 8. 关闭缓存管理器
        cacheManager.shutdown();
    }

    public static class Dog{
        private int id;
        private String name;
        private int age;

        public Dog(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}

