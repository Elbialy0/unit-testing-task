package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StopWatchTest {
    @Test
    void giveStopWatchWithMinutesThenRecord(){

        StopWatch stopWatch = new StopWatch();

        stopWatch.record(5);
        Assertions.assertEquals(5,stopWatch.getMinutes());

    }
    @Test
    void giveStopWatchWithNegativeMinutesThenIgnored(){

        StopWatch stopWatch = new StopWatch();

        stopWatch.record(5);
        stopWatch.record(-4);

        Assertions.assertEquals(5,stopWatch.getMinutes());
    }
    @Test
    void giveStopWatchWithSixtyMinutesThenIncreaseHoursByOne(){
        StopWatch stopWatch = new StopWatch();

        stopWatch.record(66);

        Assertions.assertEquals(1,stopWatch.getHours());
    }
    @Test
    void giveStopWatchWithOneThousandFourHundredFortyThenIncreaseDaysByOne(){
        StopWatch stopWatch = new StopWatch();

        stopWatch.record(1440);
        Assertions.assertEquals(1,stopWatch.getDays());
    }

}
