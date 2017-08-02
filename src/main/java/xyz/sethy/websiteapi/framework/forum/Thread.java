package xyz.sethy.websiteapi.framework.forum;

import com.skygrind.api.framework.user.User;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface Thread
{
    Integer getId();

    String getTitle();
    void setTitle(String title);

    String getBody();
    void setBody(String body);

    Date getPostedAt();
    User getAuthor();
    List<Reply> getReplies();
    Integer getRating();

    Boolean isSticky();
    void setSticky(Boolean sticky);

    Boolean isDeleted();
    void setDeleted(Boolean deleted);

    Boolean isLocked();
    void setLocked(Boolean locked);

    Integer getViews();
    void setViews(Integer views);
}
