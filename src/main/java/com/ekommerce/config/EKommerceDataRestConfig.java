package com.ekommerce.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ekommerce.model.Product;
import com.ekommerce.model.ProductCategory;

@Configuration
public class EKommerceDataRestConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {
		HttpMethod theUnsupportedActions[] = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};
		config.getExposureConfiguration()
		.forDomainType(Product.class)
		.withItemExposure((metadata, httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata, httpMethods)->httpMethods.disable(theUnsupportedActions));
		
		config.getExposureConfiguration()
		.forDomainType(ProductCategory.class)
		.withItemExposure((metadata, httpMethods)->httpMethods.disable(theUnsupportedActions))
		.withCollectionExposure((metadata, httpMethods)->httpMethods.disable(theUnsupportedActions));
	}

}
