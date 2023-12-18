package springdatademo.demo;

import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QuerydslJpaRepository;

import java.io.Serializable;

public class MyRepositoryImpl <T, ID extends Serializable> extends QuerydslJpaRepository<T, ID> implements MyRepository<T, ID> {

    private EntityManager entityManager;

    public MyRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager, EntityManager entityManager1) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager1;
    }

    @Override
    public boolean contains(T entity) {
        return entityManager.contains(entity);
    }
}
