package com.example.onlybounty.dao;

import com.example.onlybounty.model.Kid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class KidsDAOImpl implements KidsDAO{
    private final EntityManager entityManager;

    @Autowired
    public KidsDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public List<Kid> getAllKids() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Kid> cq = cb.createQuery(Kid.class);
        Root<Kid> rootEntry = cq.from(Kid.class);
        CriteriaQuery<Kid> all = cq.select(rootEntry);

        TypedQuery<Kid> allQuery = entityManager.createQuery(all);
        return allQuery.getResultList();
    }

    @Override
    public Kid saveKid(Kid kid) {
        return entityManager.merge(kid);
    }

    @Override
    public Kid getKid(int id) {
        return entityManager.find(Kid.class, id); // Use find method
    }

    @Override
    public void deleteKid(int id) {
        Kid kid = entityManager.find(Kid.class, id); // First find the entity
        if (kid != null) {
            entityManager.remove(kid); // Use remove method to delete
        }
    }
}