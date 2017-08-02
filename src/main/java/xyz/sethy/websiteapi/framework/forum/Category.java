package xyz.sethy.websiteapi.framework.forum;

import java.util.List;

public interface Category
{
    Integer getId();
    Integer getParentCategory();
    Integer getTotalViews();
    String getName();
    String getDescription();
    void setDescription(String description);

    String getViewPermission();
    void setViewPermission(String permission);

    String getPostPermission();
    void setPostPermission(String permission);

    void setName(String name);

    List<Integer> getThreads();
}
