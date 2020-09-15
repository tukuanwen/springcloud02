package com.tu.mybatisDemo.redisDemo;

import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.mybatis.caches.redis.RedisCache;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RedisTestCase {

    private static final String DEFAULT_ID = "REDIS";

    private static RedisCache cache;

    @BeforeAll
    public static void newCache() {
        cache = new RedisCache(DEFAULT_ID);
    }

    @Test
    public void shouldDemonstrateCopiesAreEqual() {
        System.out.println(cache);
        cache = new RedisCache(DEFAULT_ID);

        for (int i = 0; i < 1000; i++) {
            cache.putObject(i, i);
            assertEquals(i, cache.getObject(i));
        }
        System.out.println(cache.getSize());
    }

    @Test
    public void shouldRemoveItemOnDemand() {
        cache.putObject(0, 0);
        assertNotNull(cache.getObject(0));
        cache.removeObject(0);
        assertNull(cache.getObject(0));
    }

    @Test
    public void shouldFlushAllItemsOnDemand() {
        for (int i = 0; i < 5; i++) {
            cache.putObject(i, i);
        }
        assertNotNull(cache.getObject(0));
        assertNotNull(cache.getObject(4));
        cache.clear();
        assertNull(cache.getObject(0));
        assertNull(cache.getObject(4));
    }

    @Test
    public void shouldNotCreateCache() {
        assertThrows(IllegalArgumentException.class, () -> {
            cache = new RedisCache(null);
        });
    }

    @Test
    public void shouldVerifyCacheId() {
        assertEquals("REDIS", cache.getId());
    }

    @Test
    public void shouldVerifyToString() {
        assertEquals("Redis {REDIS}", cache.toString());
    }

    @Test
    public void shouldDeleteExpiredCache() throws Exception {
        // set timeout to 3 secs

        cache.putObject(0, 0);
        Thread.sleep(2000);
        cache.putObject(1, 1);
        // 2 secs : not expired yet
        assertEquals(0, cache.getObject(0));
        Thread.sleep(2000);
        // 4 secs : should be expired
        assertNull(cache.getObject(0));
        assertNull(cache.getObject(1));
        // Make sure timeout is re-set
        cache.putObject(2, 2);
        Thread.sleep(2000);
        // 2 secs : not expired yet
        cache.putObject(3, 3);
        assertEquals(2, cache.getObject(2));
        Thread.sleep(2000);
        // 4 secs : should be expired
        assertNull(cache.getObject(2));
        assertNull(cache.getObject(3));
    }
}
