import spock.lang.Specification
import spock.lang.Subject

class MyRetailControllerTest extends Specification {

    @Subject
    MyRetailController myRetailController

    void setup() {
        myRetailController = new MyRetailController()
    }

    def "GetProduct returns a value if id is an Integer"() {
        given:
            def id = 15117729

        when:
            def response = myRetailController.getProduct(id)

        then:
            response instanceof String
    }
}
