package mathiasschoepke;

import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.Forward;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.Path;

@RewriteConfiguration
public class ConfigurationProvider extends HttpConfigurationProvider {

	@Override
	public int priority() {
		return 0;
	}

	@Override
	public Configuration getConfiguration(final ServletContext context) {
		return ConfigurationBuilder.begin()
				// .addRule().perform(Log.message(Level.INFO, "Rewrite is
				// active."))

				.addRule().when(Path.matches("/")).perform(Forward.to("/index.xhtml"))

				.addRule().when(Path.matches("/employees")).perform(Forward.to("/employees.xhtml"))

				.addRule().when(Path.matches("/employees/{id}")).perform(Forward.to("/employee.xhtml"))

				.addRule().when(Path.matches("/projects")).perform(Forward.to("/projects.xhtml"))

				.addRule().when(Path.matches("/projects/{id}")).perform(Forward.to("/project.xhtml"));
	}
}