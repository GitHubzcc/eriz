package com.eriz.common.redis.service.impl;

import com.eriz.common.redis.cache.CityInfo;
import com.eriz.common.redis.cache.RedisUtil;
import com.eriz.common.redis.service.GeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.*;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.GeoOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: eriz 471295986@qq.com
 * @date: 2019/7/12 23:47
 */
@Service
public class GeoServiceImpl implements GeoService {

    private final String GEO_KEY = "ah-cities";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public Long saveCityInfoToRedis(Collection<CityInfo> cityInfos) {
        //log.info("start to save city info: {}.", JSON.toJSONString(cityInfos));

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        Set<RedisGeoCommands.GeoLocation<String>> locations = new HashSet<>();
        cityInfos.forEach(ci -> locations.add(new RedisGeoCommands.GeoLocation<String>(
                ci.getCity(), new Point(ci.getLongitude(), ci.getLatitude())
        )));

        //log.info("done to save city info.");
        return ops.geoAdd(GEO_KEY, locations);
    }

    @Override
    public List<Point> getCityPos(String[] cities) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return ops.geoPos(GEO_KEY, cities);
    }

    @Override
    public Distance getTwoCityDistance(String city1, String city2, Metric metric) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return metric == null ?
                ops.geoDist(GEO_KEY, city1, city2) : ops.geoDist(GEO_KEY, city1, city2, metric);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getPointRadius(
            Circle within, RedisGeoCommands.GeoRadiusCommandArgs args
    ) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return args == null ?
                ops.geoRadius(GEO_KEY, within) : ops.geoRadius(GEO_KEY, within, args);
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> getMemberRadius(
            String member, Distance distance, RedisGeoCommands.GeoRadiusCommandArgs args
    ) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return args == null ?
                ops.geoRadiusByMember(GEO_KEY, member, distance) : ops.geoRadiusByMember(GEO_KEY, member, distance, args);
    }

    @Override
    public List<String> getCityGeoHash(String[] cities) {

        GeoOperations<String, String> ops = redisTemplate.opsForGeo();

        return ops.geoHash(GEO_KEY, cities);
    }
}
