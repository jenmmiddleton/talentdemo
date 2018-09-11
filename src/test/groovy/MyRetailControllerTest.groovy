import com.frudence.talentdemo.controller.MyRetailController
import com.frudence.talentdemo.model.Price
import com.frudence.talentdemo.model.Product
import com.frudence.talentdemo.service.ProductService
import spock.lang.Specification
import spock.lang.Subject

class MyRetailControllerTest extends Specification {

    @Subject
    MyRetailController myRetailController

    ProductService productService = Mock()

    void setup() {
        myRetailController = new MyRetailController(
                productService: productService
        )
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
            response instanceof Product
            response.getId() == id
            1 * productService.getProduct(id) >> product
            response == product
    }
}
