package xyz.sethy.websiteapi;

import xyz.sethy.websiteapi.dao.RedisCategoryDAO;
import xyz.sethy.websiteapi.dao.RedisLinkDAO;
import xyz.sethy.websiteapi.dao.RedisThreadDAO;
import xyz.sethy.websiteapi.framework.Framework;
import xyz.sethy.websiteapi.framework.forum.ForumManager;
import xyz.sethy.websiteapi.framework.leaderboards.LeaderboardManager;

/**
 * Created by seth on 06/07/17.
 */
public abstract class WebsiteAPI
{
    private static Framework framework;

    public static void setFramework(Framework coreFramework)
    {
        framework = coreFramework;
        framework.getForumManager().load();
    }

    public static LeaderboardManager getLeaderboardManager()
    {
        return framework.getLeaderboardManager();
    }

    public static ForumManager getForumManager()
    {
        return framework.getForumManager();
    }

    public static RedisLinkDAO getRedisLinkDAO()
    {
        return framework.getRedisLinkDAO();
    }

    public static RedisThreadDAO getRedisThreadDAO()
    {
        return framework.getRedisThreadDAO();
    }

    public static RedisCategoryDAO getRedisCategoryDAO()
    {
        return framework.getRedisCategoryDAO();
    }
}
