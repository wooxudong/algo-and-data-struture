package com.xudong.algo.heap;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LRUCacheTest {

    @Test
    void shouldAddAPair_andReturnRightValue() {
        //given
        int capacity = 3;
        LRUCache cache = new LRUCache(capacity);

        //when
        cache.put(2, 1);

        //then
        int value = cache.get(2);
        assertThat(value).isEqualTo(1);
    }

    @Test
    void shouldAddMorePairs_andReturnRightValue() {
        //given
        int capacity = 3;
        LRUCache cache = new LRUCache(capacity);

        //when
        cache.put(2, 1);
        cache.put(3, 4);


        //then
        int value = cache.get(3);
        assertThat(value).isEqualTo(4);
    }

    @Test
    void shouldAddMorePairs_andEvictKeyWhenExceedCapacity() {
        //given
        int capacity = 2;
        LRUCache cache = new LRUCache(capacity);

        //when
        cache.put(2, 1);
        cache.put(3, 4);
        cache.put(5, 8);


        //then
        int value = cache.get(2);
        assertThat(value).isEqualTo(-1);
    }

    @Test
    void shouldAddMorePairs_andEvictLRUKeyWhenExceedCapacity() {
        //given
        int capacity = 2;
        LRUCache cache = new LRUCache(capacity);

        //when
        cache.put(2, 1);
        cache.put(3, 4);
        cache.put(5, 8);


        //then
        assertThat(cache.get(3)).isEqualTo(4);
        assertThat(cache.get(2)).isEqualTo(-1);
    }

    @Test
    void leetCode_example() {
        LRUCache cache = new LRUCache(2 /* capacity */);

        cache.put(1, 1);
        cache.put(2, 2);
        assertThat(cache.get(1)).isEqualTo(1);
        cache.put(3, 3);    // evicts key 2
        assertThat(cache.get(2)).isEqualTo(-1);
        cache.put(4, 4);    // evicts key 1
        assertThat(cache.get(1)).isEqualTo(-1);       // returns -1 (not found)

        assertThat(cache.get(3)).isEqualTo(3);       // returns 3
        assertThat(cache.get(4)).isEqualTo(4);       // returns 4
    }


}