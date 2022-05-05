package project;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONLIKE {
    public static Map<String,String> myJson(String temp){
        Map<String,String> map = new HashMap<String, String>();
        String temp1=temp.replace("\"","");
        String temp2=temp1.replace("{","").replace("}","");
        String[] str = temp2.split(",");
        for (int i =0; i< str.length;i = i+1){
            String[] pail = str[i].split(":");
            map.put(pail[0],pail[1]);
        }
        return map;
    }

}
