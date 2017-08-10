package xyz.sethy.websiteapi.impl.leaderboards.comparator;

import xyz.sethy.websiteapi.framework.leaderboards.LeaderboardEntry;

import java.util.Comparator;
import java.util.Objects;

public class LeaderboardEntryComparator implements Comparator<LeaderboardEntry>
{
    @Override
    public int compare(final LeaderboardEntry o1, final LeaderboardEntry o2)
    {
        Integer place1 = o1.getPlace();
        Integer place2 = o2.getPlace();
        if(place1 > place2)
            return -1;
        else if(place1 < place2)
            return 1;
        else if(Objects.equals(place1, place2))
            return 0;
        else
            return 0;
    }
}
