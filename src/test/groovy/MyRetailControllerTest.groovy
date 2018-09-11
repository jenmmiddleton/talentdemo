import com.frudence.talentdemo.controller.MyRetailController
import com.frudence.talentdemo.model.Product
import spock.lang.Specification
import spock.lang.Subject

class MyRetailControllerTest extends Specification {

    @Subject
    MyRetailController myRetailController

    void setup() {
        myRetailController = new MyRetailController()
    }

    def "GetProduct returns a Product if id is an Integer"() {
        given:
            Integer id = 15117729

        when:
            def response = myRetailController.getProduct(id)

        then:
            response instanceof Product
            response.getId() == id
    }
}
