package xyz.sethy.websiteapi.impl.leaderboards.comparator;


import com.skygrind.api.framework.user.profile.Profile;

import java.util.Comparator;
import java.util.Objects;

public class ProfileDeathComparator implements Comparator<Profile>
{
    @Override
    public int compare(final Profile o1, final Profile o2)
    {
        Integer kills1 = o1.getDouble("deaths").intValue();
        Integer kills2 = o1.getDouble("deaths").intValue();
        if(kills1 > kills2)
            return -1;
        else if(kills1 < kills2)
            return 1;
        else if(Objects.equals(kills1, kills2))
            return 0;
        else
            return 0;
    }
}
