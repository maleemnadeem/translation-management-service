package com.translation.managementservice.repository;

import com.translation.managementservice.model.Translation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TranslationRepository extends CrudRepository<Translation, Long> {
    List<Translation> findByLocale(String locale);

    List<Translation> findByTag(String tag);

    List<Translation> findByTranslationKey(String key);

    List<Translation> findByContent(String content);
}
