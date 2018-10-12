package com.dimon.tryjava.basicKnow.myEnum;

import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Map.Entry;

public class EnumTest1 {

  /*  public static void main(String[] args)
    {
        EnumDay01[] eds = EnumDay01.values();
        for (EnumDay01 ed : eds)
        {
            System.out.println(ed.name() + "：" + ed.getValue());
        }
    }*/

    public static void main(String[] args)
    {
        EnumSet<EnumDay0> es = EnumSet.allOf(EnumDay0.class);
        for (EnumDay0 ed : es)
            System.out.println(ed.name() + "：" + ed.ordinal());

        System.out.println("\n-----EnumSet和EnumMap之间的分隔线-----\n");

        EnumMap<EnumDay0, String> em = new EnumMap<EnumDay0, String>(EnumDay0.class);
        em.put(EnumDay0.SUNDAY, "星期天");
        em.put(EnumDay0.MONDAY, "星期一");
        em.put(EnumDay0.TUESDAY, "星期二");
        em.put(EnumDay0.WEDNESDAY, "星期三");
        em.put(EnumDay0.THRUSDAY, "星期四");
        em.put(EnumDay0.FRIDAY, "星期五");
        em.put(EnumDay0.SATURDAY, "星期六");

        Iterator<Entry<EnumDay0, String>> iterator = em.entrySet().iterator();
        while (iterator.hasNext())
        {
            Entry<EnumDay0, String> entry = iterator.next();
            System.out.println(entry.getKey().name() + "：" + entry.getValue());
        }
    }


}
