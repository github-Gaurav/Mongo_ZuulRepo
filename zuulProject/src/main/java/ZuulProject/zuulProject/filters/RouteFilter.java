package ZuulProject.zuulProject.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class RouteFilter extends ZuulFilter{

	private static Logger log = LoggerFactory.getLogger(PostFilter.class);
	@Override
	public Object run() throws ZuulException {
		
		HttpServletRequest req = RequestContext.getCurrentContext().getRequest();
		log.info("The Route request filter is "+ req);
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "route";
	}

}
