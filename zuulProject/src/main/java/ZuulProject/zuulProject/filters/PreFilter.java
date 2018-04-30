package ZuulProject.zuulProject.filters;



import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class PreFilter extends ZuulFilter{
	
	private static Logger log = LoggerFactory.getLogger(PreFilter.class);

	@Override
	public Object run() throws ZuulException {
		
		RequestContext request = RequestContext.getCurrentContext();
		HttpServletRequest req = request.getRequest();
		System.out.println("The req is "+ req);
		log.info("The request is "+ req);
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
		return "pre";
	}

}
