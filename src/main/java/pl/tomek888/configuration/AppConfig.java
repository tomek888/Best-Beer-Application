package pl.tomek888.configuration;

import java.util.Locale;

import javax.persistence.EntityManagerFactory;
import javax.validation.Validator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.format.FormatterRegistry;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import pl.tomek888.converters.BeerConverter;
import pl.tomek888.converters.UserConverter;


@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan(basePackages = "pl.tomek888")
@EnableJpaRepositories(basePackages = "pl.tomek888.repositories")
public class AppConfig extends WebMvcConfigurerAdapter {

	@Bean
	public  LocalEntityManagerFactoryBean entityManagerFactory() {
		LocalEntityManagerFactoryBean emfb = new LocalEntityManagerFactoryBean();
		emfb.setPersistenceUnitName("BestBeerPersistenceUnit");
		return emfb;
	}

	@Bean
	public JpaTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager tm = new JpaTransactionManager(emf);
		return tm;
	}

	@Bean
	FileLoader fileLoader() {
		return new FileLoader();
	}

	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("/resources/").setCachePeriod(31556926);
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(getBeerConverter());
		registry.addConverter(getUserConverter());
		
	}
	

	@Bean
	public BeerConverter getBeerConverter() {
		return new BeerConverter();
	}

	@Bean
	public UserConverter getUserConverter() {
		return new UserConverter();
	}
//
//	@Bean
//	public ClientConverter getClientConverter() {
//		return new ClientConverter();
//	}
	
	@Bean(name="localeResolver")
	public LocaleContextResolver getLocaleContextResolver() {
	SessionLocaleResolver localeResolver = new SessionLocaleResolver();
	localeResolver.setDefaultLocale(new Locale("pl","PL"));
	return localeResolver; }
	
	@Bean
	public Validator validator() {
	return new LocalValidatorFactoryBean();
	}


}