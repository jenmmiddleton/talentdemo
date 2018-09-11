import com.frudence.talentdemo.controller.MyRetailController
import com.frudence.talentdemo.model.Price
import com.frudence.talentdemo.model.Product
import com.frudence.talentdemo.service.ProductService
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.MvcResult
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Specification
import spock.lang.Subject

class MyRetailControllerTest extends Specification {

    @Subject
    MyRetailController myRetailController

    ProductService productService = Mock()

    MockMvc mockMvc

    void setup() {
        myRetailController = new MyRetailController(
                productService: productService
        )

        mockMvc = MockMvcBuilders.standaloneSetup(myRetailController).build()
    }

    def "GetProduct should call ProductService"() {
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

    def "GetProduct should call GET request at /products/{id}"() {
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
            MvcResult mvcResult = mockMvc.perform(get("/products/" + id))
                                         .andExpect(status().isOk())
                                         .andReturn()

        then:
            1 * productService.getProduct(id) >> product
            mvcResult.getResponse().getContentAsString() == "{\"id\":15117729,\"name\":\"Avatar\",\"current_price\":{\"value\":5.0,\"currency_code\":\"USD\"}}"
    }
}
