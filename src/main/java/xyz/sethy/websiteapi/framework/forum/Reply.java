package xyz.sethy.websiteapi.framework.forum;

import java.util.Date;
import java.util.UUID;

public interface Reply
{
    Integer getParentThread();
    UUID getAuthor();
    String getTitle();
    String getPost();
    Date getPostedAt();
}
