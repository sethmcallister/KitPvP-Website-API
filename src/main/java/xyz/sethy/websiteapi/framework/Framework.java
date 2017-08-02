package xyz.sethy.websiteapi.framework;

import xyz.sethy.websiteapi.dao.RedisCategoryDAO;
import xyz.sethy.websiteapi.dao.RedisLinkDAO;
import xyz.sethy.websiteapi.dao.RedisThreadDAO;
import xyz.sethy.websiteapi.framework.forum.ForumManager;
import xyz.sethy.websiteapi.framework.leaderboards.LeaderboardManager;

/**
 * Created by seth on 06/07/17.
 */
public interface Framework
{
    LeaderboardManager getLeaderboardManager();
    ForumManager getForumManager();
    RedisLinkDAO getRedisLinkDAO();
    RedisCategoryDAO getRedisCategoryDAO();
    RedisThreadDAO getRedisThreadDAO();
}
