package com.sukiwaka;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class DateTimeSample {
    public static void main(String[] args) {
        instantTimeSample();
        System.out.println();
        dateTimeSample();
    }

    private static void dateTimeSample() {
        LocalDateTime l1 = LocalDateTime.now();
        System.out.println(l1);
        LocalDateTime l2 = LocalDateTime.of(2014, 1, 1, 9, 5, 0, 0);
        System.out.println(l2);
        ZonedDateTime z1 = l2.atZone(ZoneId.of("Europe/London"));
        LocalDateTime l3 = z1.toLocalDateTime();
        System.out.println(l3);
    }

    private static void instantTimeSample() {
        // Instantとlong値との相互変換
        Instant i2 = Instant.ofEpochMilli(31920291332L);
        long l = i2.toEpochMilli();

        // ZoneDateTimeの生成
        ZonedDateTime z1 = ZonedDateTime.now();
        ZonedDateTime z2 = ZonedDateTime.of(2014, 1, 2, 3, 4, 5, 6, ZoneId.of("Asia/Tokyo"));

        // InstantとZoneDateTimeの相互変換
        Instant i3 = z2.toInstant();
        ZonedDateTime z3 = i3.atZone(ZoneId.of("Europe/London"));

        // ZoneDateTimeの利用
        System.out.println("東京:" + z2.getYear() + z2.getMonthValue() + z2.getDayOfMonth());
        System.out.println("ロンドン:" + z3.getYear() + z3.getMonthValue() + z3.getDayOfMonth());
        if (z2.isEqual(z3)) {
            System.out.println("これらは同じ瞬間を指しています。");
        }
    }
}
