package ZuulProject.zuulProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import ZuulProject.zuulProject.filters.ErrorFilter;
import ZuulProject.zuulProject.filters.PostFilter;
import ZuulProject.zuulProject.filters.PreFilter;
import ZuulProject.zuulProject.filters.RouteFilter;

@SpringBootApplication
@EnableZuulProxy
public class ZuulProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulProjectApplication.class, args);
	}
	
	@Bean
    public PreFilter preFilter() {
        return new PreFilter();
    }
    @Bean
    public PostFilter postFilter() {
        return new PostFilter();
    }
    @Bean
    public ErrorFilter errorFilter() {
        return new ErrorFilter();
    }
    @Bean
    public RouteFilter routeFilter() {
        return new RouteFilter();
    }
	 
}
