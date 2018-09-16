package com.frudence.talentdemo.repository

import com.frudence.talentdemo.model.Price
import spock.lang.Specification
import spock.lang.Subject

class PriceRepositoryTest extends Specification {

    @Subject
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