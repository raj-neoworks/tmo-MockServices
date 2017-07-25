package mockpopulator.impl;

import com.github.tomakehurst.wiremock.client.HttpAdminClient;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import mockclient.WireMockClient;
import mockpopulator.MockPopulator;

import java.util.List;

public abstract class AbstractMockPopulator implements MockPopulator
{
	WireMockClient wiremockClientObj = WireMockClient.getInstance();
	private HttpAdminClient wmAdminClient = wiremockClientObj.getWiremockAdminClient();

	@Override
	public void clearAllMappings()
	{
		wmAdminClient.resetMappings();
	}

	@Override
	public void applyStubMappings()
	{
		getStubMappings().forEach(stubMapping -> wmAdminClient.addStubMapping(stubMapping));
	}

	public abstract List<StubMapping> getStubMappings();
}
