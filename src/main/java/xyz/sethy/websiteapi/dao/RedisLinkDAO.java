package xyz.sethy.websiteapi.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import redis.clients.jedis.Jedis;
import xyz.sethy.websiteapi.framework.register.RegistrationLink;
import xyz.sethy.websiteapi.impl.register.CoreRegistrationLink;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class RedisLinkDAO
{
    private final Gson gson;
    private final Jedis jedis;

    public RedisLinkDAO()
    {
        this.gson = new GsonBuilder().setPrettyPrinting().create();
        this.jedis = new Jedis("172.17.0.1", 6379);
    }

    public void insert(CoreRegistrationLink link)
    {
        try(Jedis connection = jedis)
        {
            connection.set(getKey(link), this.gson.toJson(link));
        }
    }

    public void update(CoreRegistrationLink link)
    {
        try(Jedis connection = jedis)
        {
            connection.set(getKey(link), this.gson.toJson(link));
        }
    }

    public void delete(CoreRegistrationLink link)
    {
        try(Jedis connection = jedis)
        {
            connection.del(getKey(link));
        }
    }

    public RegistrationLink find(UUID uuid)
    {

        try(Jedis connection = jedis)
        {
            final String json = connection.get(getKey(uuid));
            return this.gson.fromJson(json, CoreRegistrationLink.class);
        }
    }

    public List<RegistrationLink> findAll()
    {
        try(Jedis connection = jedis)
        {
            return connection.keys(getKeyWithoutIdentifier() + ":*").stream()
                    .map(k -> this.gson.fromJson(connection.get(k), CoreRegistrationLink.class))
                    .collect(Collectors.toList());
        }
    }

    private String getKey(UUID uuid)
    {
        return getKeyWithoutIdentifier() + ":" + uuid.toString();
    }

    private String getKey(RegistrationLink link)
    {
        return getKeyWithoutIdentifier() + ":" + link.getLinkId();
    }

    private String getKeyWithoutIdentifier()
    {
        return "forum:link:";
    }
}
