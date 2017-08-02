package xyz.sethy.websiteapi.impl.forums;

import xyz.sethy.websiteapi.framework.forum.Reply;

import java.util.Date;
import java.util.UUID;

public class CoreReply implements Reply
{
    private final Integer parentThread;
    private final UUID author;
    private String title;
    private String post;
    private final Date postedAt;

    public CoreReply(final Integer parentThread, final UUID author, final String title, final String post)
    {
        this.parentThread = parentThread;
        this.author = author;
        this.title = title;
        this.post = post;
        this.postedAt = new Date(System.currentTimeMillis());
    }

    @Override
    public Integer getParentThread()
    {
        return this.parentThread;
    }

    @Override
    public UUID getAuthor()
    {
        return this.author;
    }

    @Override
    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String getPost()
    {
        return this.post;
    }

    @Override
    public Date getPostedAt()
    {
        return new Date(this.postedAt.getTime());
    }
}
