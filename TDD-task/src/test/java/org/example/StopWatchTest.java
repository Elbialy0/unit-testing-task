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

}
