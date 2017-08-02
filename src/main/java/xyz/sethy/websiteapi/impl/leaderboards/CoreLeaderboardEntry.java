package xyz.sethy.websiteapi.impl.leaderboards;

import com.skygrind.api.framework.user.User;
import xyz.sethy.websiteapi.framework.leaderboards.LeaderboardEntry;

/**
 * Created by seth on 06/07/17.
 */
public class CoreLeaderboardEntry implements LeaderboardEntry
{
    private final Integer place;
    private final User profile;
    private final String score;

    public CoreLeaderboardEntry(final Integer place, final User profile, final String score)
    {
        this.place = place;
        this.profile = profile;
        this.score = score;
    }

    @Override
    public Integer getPlace()
    {
        return place;
    }

    @Override
    public User getUser()
    {
        return profile;
    }

    @Override
    public String getScore()
    {
        return score;
    }
}
