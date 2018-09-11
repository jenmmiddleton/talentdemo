import com.frudence.talentdemo.controller.MyRetailController
import com.frudence.talentdemo.model.Price
import com.frudence.talentdemo.model.Product
import com.frudence.talentdemo.service.MyRetailService
import spock.lang.Specification
import spock.lang.Subject

class MyRetailControllerTest extends Specification {

    @Subject
    MyRetailController myRetailController

    MyRetailService myRetailService = Mock()

    void setup() {
        myRetailController = new MyRetailController(
                myRetailService: myRetailService
        )
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

    def "GetProduct should call MyRetailService"() {
        given:
            Integer id = 15117729
            Price price = new Price(
                    id: id,
                    value: 5.00,
                    currencyCode: "USD"
            )

            Product product = new Product(
                    id: id,
                    name: "Avatar",
                    currentPrice: price
            )

        when:
            def response = myRetailController.getProduct(id)

        then:
            1 * myRetailService.getProduct(id) >> product
            response == product
    }
}
