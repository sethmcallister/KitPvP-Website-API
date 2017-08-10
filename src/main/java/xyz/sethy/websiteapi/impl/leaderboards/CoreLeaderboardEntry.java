package xyz.sethy.websiteapi.impl.leaderboards;

import com.skygrind.api.API;
import com.skygrind.api.framework.user.User;
import com.skygrind.core.framework.user.CoreUserManager;
import xyz.sethy.websiteapi.framework.leaderboards.LeaderboardEntry;

import java.util.UUID;

/**
 * Created by seth on 06/07/17.
 */
public class CoreLeaderboardEntry implements LeaderboardEntry
{
    private Integer place;
    private final UUID profile;
    private final String score;

    public CoreLeaderboardEntry(final Integer place, final UUID profile, final String score)
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
        return ((CoreUserManager) API.getUserManager()).getUserDataDriver().findById(profile);
    }

    @Override
    public String getScore()
    {
        return score;
    }

    @Override
    public void setPlace(final Integer place)
    {
        this.place = place;
    }
}
