package tw.com.jeff.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.accept.ContentNegotiationManager;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import tw.com.jeff.filter.LoginFilter;
import tw.com.jeff.home.viewResolver.ExcelViewResolver;
@Configuration
@EnableWebMvc
@ComponentScan(basePackages= {"tw.com.jeff"})
public class WebAppConfig extends WebMvcConfigurerAdapter {
	@Bean
	public ViewResolver jspViewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	     registry.addResourceHandler("/CSS/**")
	             .addResourceLocations("/WEB-INF/views/CSS/");
	     registry.addResourceHandler("/images/**")
	             .addResourceLocations("/WEB-INF/views/images/");
	     registry.addResourceHandler("/js/**")
	     		 .addResourceLocations("/WEB-INF/views/js/");
	     registry.addResourceHandler("/xml/**")
	     		 .addResourceLocations("/WEB-INF/views/xml/");
	}
	@Bean
	public LoginFilter loginFilter() {
		return new LoginFilter();
	}
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.defaultContentType(MediaType.APPLICATION_JSON);
	}
	@Bean
	public ViewResolver contentNegotiatingViewResolver(ContentNegotiationManager manager) {
		ContentNegotiatingViewResolver cnvr = new ContentNegotiatingViewResolver();
		cnvr.setContentNegotiationManager(manager);
		List<ViewResolver> resolvers = new ArrayList<ViewResolver>();
		resolvers.add(excelViewResolver());

		cnvr.setViewResolvers(resolvers);
		return cnvr;
	}
	@Bean
	public ViewResolver excelViewResolver() {
		System.out.println("excelViewResolver");
		return new ExcelViewResolver();
	}
	@Bean
	public CommonsMultipartResolver multipartResolver() {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		resolver.setDefaultEncoding("UTF-8");
		resolver.setMaxUploadSize(81920000);
		return resolver;
	}
	
	
}
