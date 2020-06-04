/**
 * 
 */
package com.aman.zuul.api.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * @author amanb
 *
 */
public class PreFilter extends ZuulFilter {

	private static  Logger log=LoggerFactory.getLogger(PreFilter.class);
	
	/* (non-Javadoc)
	 * @see com.netflix.zuul.IZuulFilter#shouldFilter()
	 */
	@Override
	public boolean shouldFilter() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.netflix.zuul.IZuulFilter#run()
	 */
	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext ctx=RequestContext.getCurrentContext();
		HttpServletRequest req=ctx.getRequest();
		
		log.info("PreFilter: "+String.format("%s request to %s", req.getMethod(),req.getRequestURL().toString()));
		return null;
	}

	/* (non-Javadoc)
	 * @see com.netflix.zuul.ZuulFilter#filterType()
	 */
	@Override
	public String filterType() {
		return "pre";
	}

	/* (non-Javadoc)
	 * @see com.netflix.zuul.ZuulFilter#filterOrder()
	 */
	@Override
	public int filterOrder() {
		return 1;
	}

}
