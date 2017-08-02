package xyz.sethy.websiteapi.framework.forum;


import xyz.sethy.websiteapi.framework.register.RegistrationLink;

import java.util.List;
import java.util.UUID;

public interface ForumManager
{
    Category findCategoryById(Integer id);
    List<Category> findCategoriesByParent(Category category);
    List<Category> findAllCategories();

    List<Thread> findThreadsByParent(Category category);
    Thread findById(Integer id);
    List<Thread> findAllThreads();

    void createRegistrationLink(UUID uuid, UUID userId);
    RegistrationLink getRegistrationLink(UUID uuid);
    void load();
}
