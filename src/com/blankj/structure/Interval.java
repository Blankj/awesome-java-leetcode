package com.blankj.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/19
 *     desc  :
 * </pre>
 */
public class Interval {
    public int start;
    public int end;

    public Interval() {
        start = 0;
        end = 0;
    }

    public Interval(int s, int e) {
        start = s;
        end = e;
    }

    /**
     * 创建测试数据
     *
     * @param data [[X,X],[X,X],[X,X]]
     * @return {@link List<Interval>}
     */
    public static List<Interval> createTestData(String data) {
        List<Interval> list = new ArrayList<>();
        String[] d = data.substring(1, data.length() - 1).split("],\\[");
        for (String s : d) {
            String[] sub = s.split(",");
            list.add(new Interval(Integer.valueOf(sub[0]), Integer.valueOf(sub[1])));
        }
        return list;
    }

    public static void print(List<Interval> list) {
        if (list == null) {
            System.out.println("null");
            return;
        }
        StringBuilder sb = new StringBuilder();
        for (Interval interval : list) {
            sb.append("[")
                    .append(interval.start)
                    .append(",")
                    .append(interval.end)
                    .append("],");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
