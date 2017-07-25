package mockpopulator.impl;

import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import wiremock.com.google.common.collect.ImmutableList;

import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;

public class D3MockPopulator extends AbstractMockPopulator
{
	private static final String D3_REQUEST = "foo/bar";
	@Override
	public List<StubMapping> getStubMappings()
	{
		return ImmutableList.of(
				post(urlEqualTo(D3_REQUEST)).withHeader("system_identifier", containing(""))
						.withHeader("auth_header", containing(""))
						.withRequestBody(equalToJson(
								"{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111123456\",\n \"imsi\":\"123456000000000\"\n}",
								true,
								true))
						.willReturn(aResponse().withBodyFile("15-No_fact_from_Union_response.json")
								.withHeader("Content-Type", "application/json")
								.withStatus(200))
						.build()
		);
	}
}
