package cn.asyysy.core;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsyysyCoreApplicationTests {

    @Test
    public void contextLoads() {

    }

    @Test
    public void mapTest() {
        int aHundredMillion = 500;

        Map<Integer, Integer> map = new HashMap<>();

        long s1 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map.put(i, i);
        }
        long s2 = System.currentTimeMillis();

        System.out.println("未初始化容量，耗时 ： " + (s2 - s1));


        Map<Integer, Integer> map1 = new HashMap<>(aHundredMillion / 2);

        long s5 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map1.put(i, i);
        }
        long s6 = System.currentTimeMillis();

        System.out.println("初始化容量5000000，耗时 ： " + (s6 - s5));


        Map<Integer, Integer> map2 = new HashMap<>(aHundredMillion);

        long s3 = System.currentTimeMillis();
        for (int i = 0; i < aHundredMillion; i++) {
            map2.put(i, i);
        }
        long s4 = System.currentTimeMillis();

        System.out.println("初始化容量为10000000，耗时 ： " + (s4 - s3));
    }
}
