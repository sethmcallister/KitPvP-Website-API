package xyz.sethy.websiteapi.impl.register;

import xyz.sethy.websiteapi.framework.register.RegistrationLink;

import java.util.UUID;

public class CoreRegistrationLink implements RegistrationLink
{
    private final UUID linkId;
    private final UUID userId;

    public CoreRegistrationLink(final UUID linkId, final UUID userId)
    {
        this.linkId = linkId;
        this.userId = userId;
    }

    @Override
    public UUID getLinkId()
    {
        return linkId;
    }

    @Override
    public UUID getUserId()
    {
        return userId;
    }
}
