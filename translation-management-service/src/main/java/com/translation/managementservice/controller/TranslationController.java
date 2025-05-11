package com.translation.managementservice.controller;

import com.translation.managementservice.model.Translation;
import com.translation.managementservice.service.TranslationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/translations")
public class TranslationController {
    @Autowired
    private TranslationService translationService;

    @PostMapping("/create")
    public Translation createTranslation(@RequestBody Translation translation) {
        return translationService.creatTranslation(translation);
    }

    @PutMapping("/{id}")
    public Translation updateTranslation(@PathVariable Long id, @RequestBody Translation translation) {
        return translationService.updateTranslation(id, translation);
    }

    @GetMapping
    public List<Translation> getAllTranslations() {
        return translationService.getAllTranslations();
    }

    @GetMapping("/search/locale/{locale}")
    public List<Translation> searchByLocale(@PathVariable String locale) {
        return translationService.searchByLocale(locale);
    }

    @GetMapping("/search/tag/{tag}")
    public List<Translation> searchByTag(@PathVariable String tag) {
        return translationService.searchByTag(tag);
    }

    @GetMapping("/search/key/{key}")
    public List<Translation> searchByKey(@PathVariable String key) {
        return translationService.searchByTranslationKey(key);
    }

    @GetMapping("/search/content/{content}")
    public List<Translation> searchByContent(@PathVariable String content) {
        return translationService.searchByContent(content);
    }

    @GetMapping("/export/json")
    public List<Translation> exportTranslations() {
        return translationService.getAllTranslations();
    }
}
