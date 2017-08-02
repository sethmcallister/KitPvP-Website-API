package xyz.sethy.websiteapi.impl.forums;

import xyz.sethy.websiteapi.WebsiteAPI;
import xyz.sethy.websiteapi.framework.forum.Category;
import xyz.sethy.websiteapi.framework.forum.Thread;

import java.util.ArrayList;
import java.util.List;

public class CoreCategory implements Category
{
    private final Integer id;
    private final Integer parentCategory;
    private String name;
    private String description;
    private final List<Integer> threads;
    private String postPermission;
    private String viewPermission;

    public CoreCategory(final Integer id, final Integer parentCategory, final String name, final String description)
    {
        this.id = id;
        this.parentCategory = parentCategory;
        this.name = name;
        this.description = description;
        this.threads = new ArrayList<>();
        this.postPermission = "";
        this.viewPermission = "";
    }

    @Override
    public Integer getId()
    {
        return this.id;
    }

    @Override
    public Integer getParentCategory()
    {
        return this.parentCategory;
    }

    @Override
    public Integer getTotalViews()
    {
        Integer views = 0;
        for(Integer i : this.threads)
        {
            Thread thread = WebsiteAPI.getForumManager().findById(i);
            views += thread.getViews();
        }
        return views;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public String getDescription()
    {
        return description;
    }

    @Override
    public void setDescription(final String description)
    {
        this.description = description;
    }

    @Override
    public String getViewPermission()
    {
        return viewPermission;
    }

    @Override
    public void setViewPermission(final String permission)
    {
        this.viewPermission = permission;
    }

    @Override
    public String getPostPermission()
    {
        return postPermission;
    }

    @Override
    public void setPostPermission(final String permission)
    {
        this.postPermission = permission;
    }

    @Override
    public void setName(final String name)
    {
        this.name = name;
    }

    @Override
    public List<Integer> getThreads()
    {
        return this.threads;
    }
}
