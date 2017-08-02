package xyz.sethy.websiteapi.impl.forums;

import com.skygrind.api.API;
import com.skygrind.api.framework.user.User;
import xyz.sethy.websiteapi.framework.forum.Reply;
import xyz.sethy.websiteapi.framework.forum.Thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class CoreThread implements Thread
{
    private final Integer id;
    private String title;
    private String body;
    private final Date postedAt;
    private final UUID author;
    private final List<Reply> replies;
    private Integer rating;
    private Boolean sticky;
    private Boolean deleted;
    private Boolean locked;
    private Integer views;

    public CoreThread(final Integer id, final String title, final String body, final UUID author)
    {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postedAt = new Date(System.currentTimeMillis());
        this.author = author;
        this.replies = new ArrayList<>();
        this.rating = 0;
        this.sticky = false;
        this.deleted = false;
        this.locked = false;
        this.views = 0;
    }

    @Override
    public Integer getId()
    {
        return id;
    }

    @Override
    public String getTitle()
    {
        return title;
    }

    @Override
    public void setTitle(final String title)
    {
        this.title = title;
    }

    @Override
    public String getBody()
    {
        return body;
    }

    @Override
    public void setBody(final String body)
    {
        this.body = body;
    }

    @Override
    public Date getPostedAt()
    {
        return postedAt;
    }

    @Override
    public User getAuthor()
    {
        return API.getUserManager().findByUniqueId(author);
    }

    @Override
    public List<Reply> getReplies()
    {
        return replies;
    }

    @Override
    public Integer getRating()
    {
        return rating;
    }

    @Override
    public Boolean isSticky()
    {
        return sticky;
    }

    @Override
    public void setSticky(final Boolean sticky)
    {
        this.sticky = sticky;
    }

    @Override
    public Boolean isDeleted()
    {
        return deleted;
    }

    @Override
    public void setDeleted(final Boolean deleted)
    {
        this.deleted = deleted;
    }

    @Override
    public Boolean isLocked()
    {
        return locked;
    }

    @Override
    public void setLocked(final Boolean locked)
    {
        this.locked = locked;
    }

    @Override
    public Integer getViews()
    {
        return views;
    }

    @Override
    public void setViews(final Integer views)
    {
        this.views = views;
    }
}
