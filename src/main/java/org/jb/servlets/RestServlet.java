package org.jb.servlets;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.glassfish.jersey.servlet.ServletContainer;

/**
 * Servlet implementation class RestServlet
 */
@WebServlet(urlPatterns="/rest/*",name="RestServlet",initParams=@WebInitParam(name="jersey.config.server.provider.packages",value="org.jb.rest"))
public class RestServlet extends ServletContainer {

	private static final long serialVersionUID = 1L;

}
