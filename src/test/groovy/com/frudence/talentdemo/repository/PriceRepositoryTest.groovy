package com.frudence.talentdemo.repository

import com.frudence.talentdemo.model.Price
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest
import spock.lang.Specification
import spock.lang.Subject

@DataMongoTest
class PriceRepositoryTest extends Specification {

    @Subject
    @Autowired
    PriceRepository priceRepository

    def "findById returns a price"() {
        setup:
            def id = 13860428

        when:
            Optional<Price> price = priceRepository.findById(id);

        then:
            price.isPresent()
            price.get().getId() == id
            price.get().getValue() == 13.49
            price.get().getCurrencyCode() == "USD"
    }
}