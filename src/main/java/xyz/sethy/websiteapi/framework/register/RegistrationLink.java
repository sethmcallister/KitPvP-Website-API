package xyz.sethy.websiteapi.framework.register;

import java.util.UUID;

public interface RegistrationLink
{
    UUID getLinkId();
    UUID getUserId();
}
