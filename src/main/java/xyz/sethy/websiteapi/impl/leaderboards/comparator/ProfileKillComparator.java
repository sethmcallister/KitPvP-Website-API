package xyz.sethy.websiteapi.impl.leaderboards.comparator;


import com.skygrind.api.framework.user.profile.Profile;

import java.util.Comparator;
import java.util.Objects;

/**
 * Created by seth on 06/07/17.
 */
public class ProfileKillComparator implements Comparator<Profile>
{
    @Override
    public int compare(Profile o1, Profile o2)
    {
        Integer kills1 = o1.getDouble("kills").intValue();
        Integer kills2 = o1.getDouble("kills").intValue();
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
