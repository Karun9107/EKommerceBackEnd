package com.ekommerce.config;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import com.ekommerce.model.Country;
import com.ekommerce.model.Product;
import com.ekommerce.model.ProductCategory;
import com.ekommerce.model.State;

@Configuration
public class EKommerceDataRestConfig implements RepositoryRestConfigurer {
	
	@Autowired
	EntityManager entityManager;
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

		Class<?>[] readOnlyClasses = {Product.class, ProductCategory.class, Country.class, State.class};
		HttpMethod[] unsupportedActions = {HttpMethod.PUT, HttpMethod.DELETE, HttpMethod.POST};
		
		for(Class<?> klass : readOnlyClasses) {
			disableHttpMethods(config, klass, unsupportedActions);
		}
		
		exposeIds(config);
	}
	
	private <T> void disableHttpMethods(RepositoryRestConfiguration config, Class<T> klass, HttpMethod[] unsupportedActions) {
		
		config.getExposureConfiguration()
		.forDomainType(klass)
		.withItemExposure((metadata, httpMethods)->httpMethods.disable(unsupportedActions))
		.withCollectionExposure((metadata, httpMethods)->httpMethods.disable(unsupportedActions));
	}
	
	private void exposeIds(RepositoryRestConfiguration config) {
		
		Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();
		
		List<Class<?>> entityList  = new ArrayList<>();
		
		for(EntityType<?> entity : entities) {
			entityList.add(entity.getJavaType());
		}
		
		config.exposeIdsFor(entityList.toArray( new Class[0]));
	}

}
