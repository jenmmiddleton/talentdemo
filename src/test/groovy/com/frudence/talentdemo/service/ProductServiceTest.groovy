package com.frudence.talentdemo.service

import com.frudence.talentdemo.feign.RedSky
import com.frudence.talentdemo.model.Price
import com.frudence.talentdemo.model.Product
import com.frudence.talentdemo.repository.PriceRepository
import spock.lang.Specification
import spock.lang.Subject

class ProductServiceTest extends Specification {

    @Subject
    ProductService productService

    RedSky redSky = Mock()

    PriceRepository priceRepository = Mock()

    void setup() {
        productService = new ProductServiceImpl(
                redSky: redSky,
                priceRepository: priceRepository
        )
    }

    def "GetProduct returns a Product"() {
        setup:
            Integer id = 15117729
            Price price = new Price(id, 5.00d, "USD")

        when:
            def response = productService.getProduct(id)

        then:
            1 * redSky.getTitle(id) >> "Avatar"
            1 * priceRepository.findById(id) >> new Optional<Price>(price)
            response instanceof Product
            response.getId() == id
            response.getName() == "Avatar"
            response.getCurrentPrice() == price
    }

    def "GetProduct should return other available fields if the Title does not exist for a given ID"() {
        given:
            Integer id = 15643793
            Price price = new Price(id, 7.00d, "CSD")

        when:
            def response = productService.getProduct(id)

        then:
            1 * redSky.getTitle(id) >> { throw new Exception() }
            1 * priceRepository.findById(id) >> new Optional<Price>(price)
            response instanceof Product
            response.getId() == id
            response.getName() == null
            response.getCurrentPrice() == price
    }
}
