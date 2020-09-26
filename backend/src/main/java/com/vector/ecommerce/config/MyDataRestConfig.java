package com.vector.ecommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;

import com.vector.ecommerce.dao.ProductRepository;
import com.vector.ecommerce.entity.Country;
import com.vector.ecommerce.entity.Product;
import com.vector.ecommerce.entity.ProductCategory;
import com.vector.ecommerce.entity.State;

@Configuration
public class MyDataRestConfig implements RepositoryRestConfigurer {

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {

        HttpMethod[] theUnsupportedActions = {HttpMethod.PUT, HttpMethod.POST, HttpMethod.DELETE, HttpMethod.PATCH};

        // disable HTTP methods for Product: PUT, POST, DELETE and PATCH
        disableHttpMethods(Product.class , config, theUnsupportedActions);
        disableHttpMethods(ProductCategory.class , config, theUnsupportedActions);
        disableHttpMethods(Country.class , config, theUnsupportedActions);
        disableHttpMethods(State.class , config, theUnsupportedActions);
        // disable HTTP methods for ProductCategory: PUT, POST, DELETE and PATCH
        
       config.exposeIdsFor(ProductCategory.class);
       config.exposeIdsFor(Product.class);
       config.exposeIdsFor(Country.class);
       config.exposeIdsFor(State.class);
    }

	private void disableHttpMethods(Class theClass , RepositoryRestConfiguration config, HttpMethod[] theUnsupportedActions) {
		config.getExposureConfiguration()
                .forDomainType(theClass)
                .withItemExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions))
                .withCollectionExposure((metdata, httpMethods) -> httpMethods.disable(theUnsupportedActions));
	}
}