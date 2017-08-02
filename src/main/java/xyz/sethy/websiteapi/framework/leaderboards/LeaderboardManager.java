package xyz.sethy.websiteapi.framework.leaderboards;

import java.util.List;

/**
 * Created by seth on 06/07/17.
 */
public interface LeaderboardManager
{
    List<LeaderboardEntry> getLeaderboardEntries(String server, Integer page);
}
