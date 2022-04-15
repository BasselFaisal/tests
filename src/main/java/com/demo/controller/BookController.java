package com.demo.controller;

import com.demo.model.Book;
import com.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.cache.CacheManager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private CacheManager cacheManager;

    @GetMapping
    public void main(){


        Book book = new Book("Bassel");

        bookRepository.save(book);

        bookRepository.findById(1L);


        List<String> test = new ArrayList<>();
        test.add("1");
        test.add("2");
        test.add("3");
        test.add("4");
        redisTemplate.opsForList().rightPushAll("test", test);
        
        Map<Object,Object> map = redisTemplate.opsForHash().entries("books");
        redisTemplate.hasKey("books");
        redisTemplate.setKeySerializer(new StringRedisSerializer());

        //        cacheManager.getCacheNames().forEach(cacheName -> {
//                    Map<String, String> cacheObject = getCache(cacheName);
//                    cacheObject.entrySet().stream().peek(entry -> {
//                        System.out.println(entry.getKey() + " = " + entry.getValue());
//                    });
//                }
        //        int size = CacheManager.ALL_CACHE_MANAGERS.get(0).getCache("com.demo.model.Book").getSize();

//        assertThat(size, greaterThan(0));

    }
//
//    public String getValue(String cacheName, String key) {
//        cacheManager.getC`ache(cacheName).get(key);
//    }
//
//    public Map<String, String> getCache(String cacheName) {
//        return redisTemplate
////                .keys(cacheName+"*")
//                .parallelStream()
//                .map(key -> {
//                            Map<String, String> cacheEntries = new HashMap<>();
//                            cacheEntries.put(key, getValue(cacheName, key));
//                            return cacheEntries;
//                        }
//                )
//                .collect(Collectors.toList());
//    }

}
