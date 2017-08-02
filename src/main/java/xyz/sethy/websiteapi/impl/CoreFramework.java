package xyz.sethy.websiteapi.impl;

import xyz.sethy.websiteapi.dao.RedisCategoryDAO;
import xyz.sethy.websiteapi.dao.RedisLinkDAO;
import xyz.sethy.websiteapi.dao.RedisThreadDAO;
import xyz.sethy.websiteapi.framework.Framework;
import xyz.sethy.websiteapi.framework.forum.ForumManager;
import xyz.sethy.websiteapi.framework.leaderboards.LeaderboardManager;
import xyz.sethy.websiteapi.impl.forums.CoreForumManager;
import xyz.sethy.websiteapi.impl.leaderboards.CoreLeaderboardManager;

/**
 * Created by seth on 06/07/17.
 */
public class CoreFramework implements Framework
{
    private final LeaderboardManager leaderboardManager;
    private final ForumManager forumManager;
    private final RedisLinkDAO redisLinkDAO;
    private final RedisCategoryDAO redisCategoryDAO;
    private final RedisThreadDAO redisThreadDAO;

    public CoreFramework()
    {
        this.leaderboardManager = new CoreLeaderboardManager();
        this.forumManager = new CoreForumManager();
        this.redisLinkDAO = new RedisLinkDAO();
        this.redisCategoryDAO = new RedisCategoryDAO();
        this.redisThreadDAO = new RedisThreadDAO();
    }

    public LeaderboardManager getLeaderboardManager()
    {
        return leaderboardManager;
    }

    @Override
    public ForumManager getForumManager()
    {
        return forumManager;
    }

    @Override
    public RedisLinkDAO getRedisLinkDAO()
    {
        return redisLinkDAO;
    }

    @Override
    public RedisCategoryDAO getRedisCategoryDAO()
    {
        return redisCategoryDAO;
    }

    @Override
    public RedisThreadDAO getRedisThreadDAO()
    {
        return redisThreadDAO;
    }
}
