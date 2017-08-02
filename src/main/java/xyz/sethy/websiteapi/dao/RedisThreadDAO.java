package xyz.sethy.websiteapi.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import redis.clients.jedis.Jedis;
import xyz.sethy.websiteapi.impl.forums.CoreThread;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RedisThreadDAO
{
    private final Gson gson;
    private final Jedis jedis;

    public RedisThreadDAO()
    {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.jedis = new Jedis();
    }

    public void insert(CoreThread link)
    {
        try(Jedis connection = jedis)
        {
            connection.set(getKey(link), this.gson.toJson(link));
        }
    }

    public void update(CoreThread link)
    {
        try(Jedis connection = jedis)
        {
            connection.set(getKey(link), this.gson.toJson(link));
        }
    }

    public void delete(CoreThread link)
    {
        try(Jedis connection = jedis)
        {
            connection.del(getKey(link));
        }
    }

    public CoreThread find(UUID uuid)
    {

        try(Jedis connection = jedis)
        {
            final String json = connection.get(getKey(uuid));
            return this.gson.fromJson(json, CoreThread.class);
        }
    }

    public List<CoreThread> findAll()
    {
        try(Jedis connection = jedis)
        {
            return connection.keys(getKeyWithoutIdentifier() + ":*").stream()
                    .map(k -> this.gson.fromJson(connection.get(k), CoreThread.class))
                    .collect(Collectors.toList());
        }
    }

    private String getKey(UUID uuid)
    {
        return getKeyWithoutIdentifier() + ":" + uuid.toString();
    }

    private String getKey(CoreThread link)
    {
        return getKeyWithoutIdentifier() + ":" + link.getId();
    }

    private String getKeyWithoutIdentifier()
    {
        return "forum:thread:";
    }
}
