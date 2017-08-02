package xyz.sethy.websiteapi.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import redis.clients.jedis.Jedis;
import xyz.sethy.websiteapi.impl.forums.CoreCategory;
import xyz.sethy.websiteapi.impl.forums.CoreThread;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RedisCategoryDAO
{
    private final Gson gson;
    private final Jedis jedis;

    public RedisCategoryDAO()
    {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.jedis = new Jedis();
    }

    public void insert(CoreCategory link)
    {
        try(Jedis connection = jedis)
        {
            connection.set(getKey(link), this.gson.toJson(link));
        }
    }

    public void update(CoreCategory link)
    {
        try(Jedis connection = jedis)
        {
            connection.set(getKey(link), this.gson.toJson(link));
        }
    }

    public void delete(CoreCategory link)
    {
        try(Jedis connection = jedis)
        {
            connection.del(getKey(link));
        }
    }

    public CoreCategory find(UUID uuid)
    {

        try(Jedis connection = jedis)
        {
            final String json = connection.get(getKey(uuid));
            return this.gson.fromJson(json, CoreCategory.class);
        }
    }

    public List<CoreCategory> findAll()
    {
        try(Jedis connection = jedis)
        {
            return connection.keys(getKeyWithoutIdentifier() + ":*").stream()
                    .map(k -> this.gson.fromJson(connection.get(k), CoreCategory.class))
                    .collect(Collectors.toList());
        }
    }

    private String getKey(UUID uuid)
    {
        return getKeyWithoutIdentifier() + ":" + uuid.toString();
    }

    private String getKey(CoreCategory link)
    {
        return getKeyWithoutIdentifier() + ":" + link.getId();
    }

    private String getKeyWithoutIdentifier()
    {
        return "forum:category:";
    }
}
