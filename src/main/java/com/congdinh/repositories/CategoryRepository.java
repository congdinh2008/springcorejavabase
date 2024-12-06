package com.congdinh.repositories;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.congdinh.entities.Category;

import jakarta.transaction.Transactional;

@Repository
@Transactional
public class CategoryRepository implements ICategoryRepository {

    private final SessionFactory sessionFactory;

    public CategoryRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Category> findAll() {
        Session session = sessionFactory.openSession();
        List<Category> categories = session.createQuery("from Category", Category.class).list();
        session.close();
        return categories;
    }

    @Override
    public Category findById(Long id) {
        Session session = sessionFactory.openSession();
        Category category = session.get(Category.class, id);
        session.close();
        return category;
    }

    @Override
    public void create(Category category) {
        Session session = sessionFactory.openSession();
        session.persist(category);
        session.close();
    }

    @Override
    public void update(Category category) {
        Session session = sessionFactory.openSession();
        session.merge(category);
        session.close();
    }

    @Override
    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        var existing = session.get(Category.class, id);
        session.remove(existing);
        session.close();
    }
}
