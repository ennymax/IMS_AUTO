package com.utility;

import java.time.Duration;
import java.time.LocalDateTime;

public class RandomNumbers {
    public long RandomNumbers() {
        LocalDateTime date = LocalDateTime.now();
        long seconds;
        seconds = Duration.between(date.withSecond(0).withMinute(0).withHour(0), date).getSeconds();
        System.out.println(seconds);
        return seconds;
    }
}
