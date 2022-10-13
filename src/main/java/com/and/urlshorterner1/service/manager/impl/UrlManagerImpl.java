package com.and.urlshorterner1.service.manager.impl;

import com.and.urlshorterner1.entry.Url;
import com.and.urlshorterner1.service.manager.URLService;
import com.and.urlshorterner1.service.manager.UrlManager;
import com.google.common.hash.Hashing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotBlank;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class UrlManagerImpl implements UrlManager {
    @Autowired
    private RedisTemplate<String, Url> redisTemplate;

    @Override
    public String getUrlByKey(@NotBlank String key) {
        Url url = redisTemplate.opsForValue().get(key);
        return url.getUrl();
    }

    @Override
    public Url shortenUrl(@NotBlank String url) {
        //this is a library that helps us to the same thing as base 62 does (murmur3)
        // generating murmur3 based hash key as short URL
        //String key = Hashing.murmur3_32().hashString(url, Charset.defaultCharset()).toString();

        URLService urlService = new URLService();
        String key=urlService.longToShort(url);
        Url shortUrlEntry = Url.builder().key(key).createdAt(LocalDateTime.now()).url(url).build();

        //store in redis
        redisTemplate.opsForValue().set(key, shortUrlEntry, 36000L, TimeUnit.SECONDS);

        return shortUrlEntry;
    }
}