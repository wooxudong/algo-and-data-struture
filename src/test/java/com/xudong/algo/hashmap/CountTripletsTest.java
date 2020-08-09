package com.xudong.algo.hashmap;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class CountTripletsTest {
    @Test
    void shouldCountTriplets() throws IOException {
        //given
        List<String> strings = Files.readAllLines(Paths.get("src/test/resource/countTripletsTest.txt"));
        String inputs = String.join(" ", strings);
        List<Long> arr = Arrays.stream(inputs.split(" "))
                .map(Long::parseLong)
                .collect(Collectors.toList());

        //when
        long triplets = new CountTriplet().countTriplets(arr, 3);

        //then
        assertThat(arr.size()).isEqualTo(100000);
        assertThat(triplets).isEqualTo(2325652489L);
    }
}
