import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.common.FatalStartupException;
import com.github.tomakehurst.wiremock.common.FileSource;
import com.github.tomakehurst.wiremock.standalone.CommandLineOptions;
import mockpopulator.MockPopulator;
import mockpopulator.impl.D3MockPopulator;
import mockpopulator.impl.UnionFactsMockPopulator;
import wiremock.com.google.common.collect.ImmutableList;

import java.util.List;

import static com.github.tomakehurst.wiremock.core.WireMockApp.FILES_ROOT;
import static com.github.tomakehurst.wiremock.core.WireMockApp.MAPPINGS_ROOT;
import static java.lang.System.out;

public class WiremockStarterMain
{

	static
	{
		System.setProperty("org.mortbay.log.class", "com.github.tomakehurst.wiremock.jetty.LoggerAdapter");
	}

	private WireMockServer wireMockServer;
	private List<MockPopulator> mockPopulators = ImmutableList.of(
			new D3MockPopulator(),
			new UnionFactsMockPopulator()
	);

	public static void main(String[] args)
	{
		new WiremockStarterMain().run(args);
	}

	public void run(String... args)
	{
		CommandLineOptions options = new CommandLineOptions(args)
		{

		};

		FileSource fileSource = options.filesRoot();
		fileSource.createIfNecessary();
		FileSource filesFileSource = fileSource.child(FILES_ROOT);
		filesFileSource.createIfNecessary();
		FileSource mappingsFileSource = fileSource.child(MAPPINGS_ROOT);
		mappingsFileSource.createIfNecessary();

		wireMockServer = new WireMockServer(options);

		try
		{
			wireMockServer.start();
			// wireMockServer.usingFilesUnderDirectory("/th/to/files-and-mappings-root")
			out.println(this.getClass().getName());
			out.println();
			out.println(options);
		}
		catch (FatalStartupException e)
		{
			System.err.println(e.getMessage());
			System.exit(1);
		}

		// Stuff
		mockPopulators.forEach(MockPopulator::clearAllMappings);
		mockPopulators.forEach(MockPopulator::applyStubMappings);
	}

	public static class RequestNotifier extends ConsoleNotifier
	{
		public RequestNotifier(boolean verbose)
		{
			super(verbose);
		}

		@Override
		public void info(String message)
		{
			if (message.startsWith("Received request:"))
			{
				super.info(message);

			}
			else if (message.startsWith("Sending response"))
			{
				super.info(message.substring(0, Math.min(50, message.length())));
			}
		}
	}

}
