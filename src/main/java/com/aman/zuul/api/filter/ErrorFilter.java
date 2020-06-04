/**
 * 
 */
package com.aman.zuul.api.filter;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author amanb
 *
 */
public class ErrorFilter extends ZuulFilter {

	private static  Logger log=LoggerFactory.getLogger(ErrorFilter.class);
	/* (non-Javadoc)
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see com.netflix.zuul.IZuulFilter#run()
	 */
	@Override
	public Object run() throws ZuulException {
		HttpServletResponse response=RequestContext.getCurrentContext().getResponse();
		
		log.info("Error Filter: "+String.format("Response status  to %d", response.getStatus()));
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "error";
	}

	/* (non-Javadoc)
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 1;
	}

}
