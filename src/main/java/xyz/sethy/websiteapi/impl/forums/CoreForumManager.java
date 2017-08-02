package xyz.sethy.websiteapi.impl.forums;

import com.skygrind.api.API;
import xyz.sethy.websiteapi.WebsiteAPI;
import xyz.sethy.websiteapi.framework.forum.Category;
import xyz.sethy.websiteapi.framework.forum.ForumManager;
import xyz.sethy.websiteapi.framework.forum.Thread;
import xyz.sethy.websiteapi.framework.register.RegistrationLink;
import xyz.sethy.websiteapi.impl.register.CoreRegistrationLink;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class CoreForumManager implements ForumManager
{
    private final List<Category> categories;
    private final List<Thread> threads;

    public CoreForumManager()
    {
        this.categories = new ArrayList<>();
        this.threads = new ArrayList<>();
    }

    @Override
    public void load()
    {
        this.threads.addAll(WebsiteAPI.getRedisThreadDAO().findAll());
        this.categories.addAll(WebsiteAPI.getRedisCategoryDAO().findAll());
    }

    @Override
    public Category findCategoryById(final Integer id)
    {
        return this.categories.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Category> findCategoriesByParent(final Category category)
    {
        return this.categories.stream().filter(category1 -> category1.getParentCategory() != null && category1.getParentCategory().equals(category.getId())).map(category1 -> category).collect(Collectors.toList());
    }

    @Override
    public List<Category> findAllCategories()
    {
        return this.categories;
    }

    @Override
    public List<Thread> findThreadsByParent(final Category category)
    {
        return category.getThreads().stream().map(this::findById).collect(Collectors.toList());
    }

    @Override
    public Thread findById(final Integer id)
    {
        return this.threads.stream().filter(thread -> thread.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Thread> findAllThreads()
    {
        return this.threads;
    }

    @Override
    public void createRegistrationLink(final UUID uuid, final UUID userId)
    {
        CoreRegistrationLink registrationLink = new CoreRegistrationLink(uuid, userId);
        WebsiteAPI.getRedisLinkDAO().insert(registrationLink);
    }

    @Override
    public RegistrationLink getRegistrationLink(final UUID uuid)
    {
        return WebsiteAPI.getRedisLinkDAO().find(uuid);
    }
}
