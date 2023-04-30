package org.zerock.myapp.filter;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2

@WebFilter(
	dispatcherTypes = {
			DispatcherType.REQUEST,
			DispatcherType.FORWARD,
			DispatcherType.INCLUDE,
			DispatcherType.ERROR
	}, 
	urlPatterns = { "/*" }
)
public class NewFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L;

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) 
			throws IOException, ServletException {
		log.trace("doFilter(req,res,chain) invoked.");
		
//		========================================================
		DispatcherType dispatcherType = req.getDispatcherType();
		log.info("\t+ dispatcherType: {}", dispatcherType);
//		========================================================
		
		try {
			//전처리
			chain.doFilter(req, res);
			//후처리
		} catch(Exception e) {
			throw new ServletException(e);
		} //try-catch

	} //doFilter

} //end class





