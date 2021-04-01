package com.xudong.algo.array;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FraudulentActivityNotificationsTest {
    @Test
    void shouldReturnCorrectNotifications() throws IOException {
        //given
        List<String> strings = Files.readAllLines(Paths.get("src/test/resource/fraudulentActivityNotificationTest.txt"));
        String inputs = String.join(" ", strings);
        int[] arr = Arrays.stream(inputs.split(" "))
                .map(Integer::parseInt)
                .mapToInt(i->i)
                .toArray();


        int notifications = new FraudulentActivityNotifications().countNotification(arr, 5);

        assertThat(arr.length).isEqualTo(200000);
        assertThat(notifications).isEqualTo(1026);

    }
}
