package com.store.politech.shared;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;

import jakarta.transaction.Transactional;

@NoRepositoryBean
public interface BaseJpaRepository<T extends BaseEntity> extends JpaRepository<T, Long>, JpaSpecificationExecutor<T> {

  @Query("SELECT e FROM #{#entityName} e WHERE e.isDeleted = false")
  List<T> findAllActive();

  @Query("SELECT e FROM #{#entityName} e WHERE e.isDeleted = true")
  List<T> findAllDeleted();

  @Query("SELECT e FROM #{#entityName} e WHERE e.id = :id AND e.isDeleted = false")
  Optional<T> findByIdActive(Long id);

  @Query("SELECT COUNT(e) FROM #{#entityName} e WHERE e.isDeleted = false")
  long countActive();

  @Query("SELECT COUNT(e) FROM #{#entityName} e WHERE e.isDeleted = true")
  long countDeleted();

  @Transactional
  default void delete(Long id) {
    Optional<T> entity = findById(id);
    if (entity.isPresent()) {
      T e = entity.get();
      e.setIsDeleted(true);
      save(e);
    }
  }

  @Transactional
  default int deleteAllById(List<Long> ids) {
    List<T> entities = findAllById(ids);
    if (entities.isEmpty())
      return 0;
    entities.forEach(e -> e.setIsDeleted(true));
    saveAll(entities);
    return entities.size();
  }

  @Transactional
  default int deleteAll(List<T> entities) {
    if (entities.isEmpty())
      return 0;
    entities.forEach(e -> e.setIsDeleted(true));
    saveAll(entities);
    return entities.size();
  }

  @Transactional
  @Modifying
  @Query("DELETE #{#entityName} e WHERE e.id IN :ids ")
  int hardDelete(List<Long> ids);

  @Transactional
  @Modifying
  @Query("DELETE #{#entityName} e WHERE e.id = :id ")
  int hardDelete(Long id);

  @Transactional
  default boolean restore(Long id) {
    Optional<T> entity = findById(id);
    if (entity.isPresent() && entity.get().getIsDeleted()) {
      T e = entity.get();
      e.setIsDeleted(false);
      save(e);
      return true;
    }
    return false;
  }
}