package xyz.sethy.websiteapi.impl.leaderboards;

import com.skygrind.api.API;
import com.skygrind.api.framework.user.User;
import com.skygrind.api.framework.user.profile.Profile;
import com.skygrind.core.framework.user.CoreUserManager;
import xyz.sethy.websiteapi.framework.leaderboards.LeaderboardEntry;
import xyz.sethy.websiteapi.framework.leaderboards.LeaderboardManager;
import xyz.sethy.websiteapi.impl.leaderboards.comparator.LeaderboardEntryComparator;
import xyz.sethy.websiteapi.impl.leaderboards.comparator.ProfileDeathComparator;
import xyz.sethy.websiteapi.impl.leaderboards.comparator.ProfileKillComparator;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Created by seth on 06/07/17.
 */
public class CoreLeaderboardManager implements LeaderboardManager
{
    @Override
    public List<LeaderboardEntry> getLeaderboardEntries(String server, Integer page)
    {
        switch (server.toLowerCase())
        {
            case "kitpvp_kills":
            {
                return getTopKills(page);
            }
            case "kitpvp_deaths":
            {
                return getTopDeaths(page);
            }
            default:
                return new LinkedList<>();
        }
    }

    private List<LeaderboardEntry> getTopKills(Integer page)
    {
        Queue<LeaderboardEntry> leaderboardEntries = new PriorityQueue<>(new LeaderboardEntryComparator());
        for(User user : ((CoreUserManager)API.getUserManager()).getUserDataDriver().findAll())
        {
            Profile profile = user.getProfile("kitpvp");
            if(profile == null)
                continue;

            profile.set("uuid", user.getUniqueId());
            LeaderboardEntry entry = new CoreLeaderboardEntry(0, user.getUniqueId(), String.valueOf(profile.getDouble("kills").intValue()));
            leaderboardEntries.add(entry);
        }
        List<LeaderboardEntry> entries = new LinkedList<>();
        int i = 0;
        while(!leaderboardEntries.isEmpty())
        {
            i++;
            LeaderboardEntry leaderboardEntry = leaderboardEntries.poll();
            leaderboardEntry.setPlace(i);
            System.out.println("score = " + leaderboardEntry.getScore());
            entries.add(leaderboardEntry);
        }
        return entries;
    }

    private List<LeaderboardEntry> getTopDeaths(Integer page)
    {
        List<LeaderboardEntry> entries = new LinkedList<>();
        Set<Profile> profiles = new TreeSet<>(new ProfileDeathComparator());
        for(User user : ((CoreUserManager)API.getUserManager()).getUserDataDriver().findAll())
        {
            Profile profile = user.getProfile("kitpvp");
            if(profile == null)
                continue;

            profile.set("uuid", user.getUniqueId());
            profiles.add(profile);
        }

        Map<Profile, Integer> map = new ConcurrentHashMap<>();
        int i = 0;
        for(Profile profile : profiles)
        {
            map.put(profile, i);
            i++;
        }

        int maxPages = profiles.size() / 10;
        maxPages++;

        if(page > maxPages || page == 0)
            page = 1;

        final int start = (page - 1) * 10;
        int index = 0;

        for(final Map.Entry<Profile, Integer> entry : map.entrySet())
        {
            if (index++ < start)
                continue;

            if(index > (start + 10))
                break;

            User user = API.getUserManager().findByUniqueId((UUID) entry.getKey().getObject("uuid"));

            LeaderboardEntry leaderboardEntry = new CoreLeaderboardEntry(index, user.getUniqueId(), String.valueOf(entry.getKey().getDouble("deaths").intValue()));
            entries.add(leaderboardEntry);
        }
        return entries;

    }
}
