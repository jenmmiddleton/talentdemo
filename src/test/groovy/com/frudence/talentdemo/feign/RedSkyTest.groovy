package com.frudence.talentdemo.feign

import spock.lang.Specification
import spock.lang.Subject

class RedSkyTest extends Specification {

    @Subject
    RedSky redSky

    def setup() {
        redSky = new RedSky()
    }

    def "getTitle from Feign API"() {
        when:
            def response = redSky.getTitle(13860428)

        then:
            response instanceof String
            response == "The Big Lebowski (Blu-ray)"
    }
}
