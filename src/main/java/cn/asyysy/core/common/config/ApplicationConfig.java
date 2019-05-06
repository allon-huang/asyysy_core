package cn.asyysy.core.common.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;


//@EnableConfigurationProperties(RemoteProperties.class)
public class ApplicationConfig {
    @Autowired
    private Environment env;

    public static void main(String[] args){
        //System.out.println("12");
        //EntityListUtils.class;

       //System.out.println(env.getProperty("asyysy.wx_token"));
       //System.out.println(ApplicationConfig.getProperty("wx_token"));
        //init();
        //ApplicationConfig.getProperty("wx_token");
    }
   /* public static void init(){*/
   /*     Map<String,String> map = System.getenv();*/
   /*     Set<Map.Entry<String,String>> entries = map.entrySet();*/
   /*     for (Map.Entry<String, String> entry : entries) {*/
   /*         System.out.println(entry.getKey() + ":" + entry.getValue());*/
   /*     }*/
   /*     System.out.println(map.get("wx_token"));*/
/*
*/

   /* }*/

    /*public static  String getProperty(String key){
         return env.getProperty(key);
    }*/


}
