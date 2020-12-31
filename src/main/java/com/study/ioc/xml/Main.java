package com.study.ioc.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class Main {
        public static void main(String[] args) {
            HashMap map = new HashMap<Integer, Integer>();
            map.put(1, "wangyi");
            changeHashMap(map);
            for (Iterator it = map.keySet().iterator(); it.hasNext();) {
                Object key = it.next();
                System.out.println(key + "=" + map.get(key));
            }
        }
        static void changeHashMap(HashMap map) {
            map = new HashMap<Integer, String>();
            map.put(1, "163");
        }
    }


