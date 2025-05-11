package com.translation.managementservice.service;

import com.translation.managementservice.model.Translation;
import com.translation.managementservice.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TranslationService {
    @Autowired
    private TranslationRepository translationRepository;

    public Translation creatTranslation(Translation translation) {
        return translationRepository.save(translation);
    }

    @CachePut(value = "translations", key = "#updatedTranslation.id")
    public Translation updateTranslation(Long id, Translation updatedTranslation) {
        return translationRepository.findById(id)
                .map(translation -> {
                    translation.setLocale(updatedTranslation.getLocale());
                    translation.setTranslationKey(updatedTranslation.getTranslationKey());
                    translation.setContent(updatedTranslation.getContent());
                    translation.setTag(updatedTranslation.getTag());
                    return translationRepository.save(translation);
                })
                .orElse(null);
    }

    @Cacheable("translations")
    public List<Translation> getAllTranslations() {
        return (List<Translation>) translationRepository.findAll();
    }

    @Cacheable(value = "translations", key = "#locale")
    public List<Translation> searchByLocale(String locale) {
        return translationRepository.findByLocale(locale);
    }

    @Cacheable(value = "translations", key = "#tag")
    public List<Translation> searchByTag(String tag) {
        return translationRepository.findByTag(tag);
    }

    @Cacheable(value = "translations", key = "#key")
    public List<Translation> searchByTranslationKey(String key) {
        return translationRepository.findByTranslationKey(key);
    }

    @Cacheable(value = "translations", key = "#content")
    public List<Translation> searchByContent(String content) {
        return translationRepository.findByContent(content);
    }
}
