package com.frudence.talentdemo;

import com.frudence.talentdemo.model.Price;
import com.frudence.talentdemo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TalentdemoApplication implements CommandLineRunner {

    @Autowired
    PriceRepository priceRepository;

    @Override
    public void run(String... args) throws Exception {
        // Clears Database
        priceRepository.deleteAll();

        // Initialize Data
        priceRepository.save(new Price(13860428, 13.49, "USD"));
        priceRepository.save(new Price(15117729, 999.99, "JPY"));
        priceRepository.save(new Price(16483589, 36.50, "USD"));
        priceRepository.save(new Price(16696652, 75.25, "AUD"));
        priceRepository.save(new Price(16752456, 1.00, "USD"));
        priceRepository.save(new Price(15643793, 5.57, "CSD"));
    }

    public static void main(String[] args) {
        SpringApplication.run(TalentdemoApplication.class, args);
    }
}
