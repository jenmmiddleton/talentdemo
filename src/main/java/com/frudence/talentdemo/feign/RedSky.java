package com.frudence.talentdemo.feign;

import feign.Feign;
import feign.Param;
import feign.RequestLine;
import feign.gson.GsonDecoder;
import org.springframework.stereotype.Service;

@Service
public class RedSky {

    interface RedSkyFeign {
        @RequestLine("GET /v2/pdp/tcin/{id}?excludes=taxonomy,price,promotion,bulk_ship,rating_and_review_reviews,rating_and_review_statistics,question_answer_statistics")
        RedSkyBody getProduct(@Param("id") Integer id);
    }

    static class RedSkyBody {
        Product product;
    }

    static class Product {
        Item item;
    }

    static class Item {
        ProductDescription product_description;
    }

    static class ProductDescription {
        String title;
    }

    public String getTitle(Integer id) {
        RedSkyFeign redSkyFeign = Feign.builder()
                                       .decoder(new GsonDecoder())
                                       .target(RedSkyFeign.class, "https://redsky.target.com"); //MUST be https to work
        // Fetch the product
        RedSkyBody redSkyBody = redSkyFeign.getProduct(id);
        return redSkyBody.product.item.product_description.title;
    }
}
