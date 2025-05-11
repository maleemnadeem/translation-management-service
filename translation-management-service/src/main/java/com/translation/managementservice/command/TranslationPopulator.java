package com.translation.managementservice.command;

import com.translation.managementservice.model.Translation;
import com.translation.managementservice.repository.TranslationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class TranslationPopulator implements CommandLineRunner {
    @Autowired
    private TranslationRepository translationRepository;

    @Override
    public void run(String... args) throws Exception {
        int numberOfRecords = 100000;
        for (int i = 0; i < numberOfRecords; i++) {
            Translation translation = Translation.builder()
                    .locale(getRandomLocale())
                    .translationKey("key" + i)
                    .content("Content for translation " + i)
                    .tag("tag" + (i % 10))
                    .build();
            //translationRepository.save(translation);

            if (i % 1000 == 0) {
                System.out.println("Inserted " + i + " records...");
            }
        }
        System.out.println("Database populated with " + numberOfRecords + " records.");
    }

    private String getRandomLocale() {
        String[] locales = {"en", "fr", "es", "de", "it"};
        Random rand = new Random();
        return locales[rand.nextInt(locales.length)];
    }
}
