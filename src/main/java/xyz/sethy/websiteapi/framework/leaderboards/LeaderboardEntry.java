package xyz.sethy.websiteapi.framework.leaderboards;


import com.skygrind.api.framework.user.User;

/**
 * Created by seth on 06/07/17.
 */
public interface LeaderboardEntry
{
    Integer getPlace();
    User getUser();
    String getScore();
    void setPlace(Integer place);
}
