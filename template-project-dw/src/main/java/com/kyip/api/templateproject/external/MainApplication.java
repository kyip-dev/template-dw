package com.kyip.api.templateproject.external;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import org.glassfish.jersey.filter.LoggingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableMap;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.kyip.api.templateproject.external.health.Ping;
import com.kyip.api.templateproject.external.modules.TemplateProjectModule;
import com.kyip.api.templateproject.external.provider.CustomJsonReaderProvider;
import com.kyip.api.templateproject.external.provider.CustomJsonWriterProvider;
import com.kyip.api.templateproject.external.provider.ServiceExceptionMapper;
import com.kyip.api.templateproject.external.resource.TemplateResourceImpl;

public class MainApplication extends Application<MainConfiguration> {
	private static final Logger LOGGER = LoggerFactory.getLogger(MainApplication.class);

	@Override
	public String getName() {
		return "template-project";
	}

	public static void main(String[] args) throws Exception {
		new MainApplication().run(args);
	}

	@Override
	public void initialize(Bootstrap<MainConfiguration> bootstrap) {
		bootstrap.addBundle(new ViewBundle<MainConfiguration>() {
			@Override
			public ImmutableMap<String, ImmutableMap<String, String>> getViewConfiguration(MainConfiguration configuration) {
				return configuration.getViewRendererConfiguration();
			}
		});
		bootstrap.addBundle(new AssetsBundle("/assets"));

		LOGGER.info("initialized");
	}

	@Override
	public void run(MainConfiguration configuration, Environment environment) throws Exception {
		// register health checks
		environment.healthChecks().register("ping", new Ping(configuration));

		// register resource binds
		Injector injector = Guice.createInjector(new TemplateProjectModule(configuration));

		environment.jersey().register(injector.getInstance(TemplateResourceImpl.class));

		// register providers
		environment.jersey().register(injector.getInstance(CustomJsonReaderProvider.class));
		environment.jersey().register(injector.getInstance(CustomJsonWriterProvider.class));
		environment.jersey().register(ServiceExceptionMapper.class);

		environment.jersey().register(new LoggingFilter(java.util.logging.Logger.getLogger(MainApplication.class.getName()), true));

		LOGGER.info("run completed");
	}

}
