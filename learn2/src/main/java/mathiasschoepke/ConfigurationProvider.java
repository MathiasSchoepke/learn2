package mathiasschoepke;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;

@RewriteConfiguration
public class ConfigurationProvider extends HttpConfigurationProvider {

	@Override
	public int priority() {
		return 10;
	}

	@Override
	public Configuration getConfiguration(final ServletContext context) {
		return ConfigurationBuilder.begin()

				.addRule(Join.path("/").to("/index.xhtml"))

				.addRule(Join.path("/employees").to("/employees.xhtml"))

				.addRule(Join.path("/employees/{id}").to("/employee.xhtml"))

				.addRule(Join.path("/projects").to("/projects.xhtml"));
	}
}