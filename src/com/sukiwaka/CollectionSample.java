package com.sukiwaka;

import java.util.*;

class Hero {
    public String name;
}

public class CollectionSample {
    public static void main(String[] args) {
        hashMapSample();
    }

    private static void listProblemSample() {
        Hero h = new Hero();
        h.name = "mario";
        List<Hero> list = new ArrayList();
        list.add(h);

        // リストは参照渡しのため、格納後でも値が書き換わってしまう
        h.name = "sonic";
        System.out.println(list.get(0).name);
    }

    private static void hashMapSample() {
        Map<String, Integer> prefs = new HashMap<String, Integer>();
        prefs.put("kyoto", 255);
        prefs.put("tokyo", 1261);
        prefs.put("kumamoto", 181);
        int tokyo = prefs.get("tokyo");
        System.out.println("東京都の人口は、" + tokyo);
        prefs.remove("kyoto");
        prefs.put("kumamoto", 182);
        int kumamoto = prefs.get("kumamoto");
        System.out.println("熊本県の人口は、" + kumamoto);
        for (String key : prefs.keySet()) {
            int value = prefs.get(key);
            System.out.println(key + "の人口は、" + value);
        }
    }

    private static void treeSetSample() {
        Set<String> words = new TreeSet<>();
        words.add("dog");
        words.add("cat");
        words.add("wolf");
        words.add("panda");
        for (String s: words) {
            System.out.print(s + "→");
        }
    }

    private static void hashSetSample() {
        Set<String> colors = new HashSet<>();
        colors.add("赤");
        colors.add("青");
        colors.add("黄");
        colors.add("赤");
        System.out.println("色は" + colors.size() + "種類");
        for (String color : colors) {
            System.out.println(color);
        }
    }

    private static void iteratorSample() {
        ArrayList<String> names = new ArrayList<>();
        names.add("佐藤");
        names.add("鈴木");
        names.add("吉田");
        Iterator<String> it = names.iterator();
        while(it.hasNext()) {
            String e = it.next();
            System.out.println(e);
        }
    }
}
