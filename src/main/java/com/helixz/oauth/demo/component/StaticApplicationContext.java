package com.helixz.oauth.demo.component;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Chamith
 *
 */
@Component
public class StaticApplicationContext implements ApplicationContextAware {

	private static ApplicationContext context;

	public void setApplicationContext(ApplicationContext context) {
		StaticApplicationContext.context = context;
	}

	public static ApplicationContext getApplicationContext() {
		return context;
	}

}
