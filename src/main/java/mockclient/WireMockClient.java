package mockclient;

/**
 * Created by rgovindarajan on 20/07/17.
 */

import com.github.tomakehurst.wiremock.client.HttpAdminClient;

public class WireMockClient {

    //private WireMock wireMock;
    private static final String WIREMOCK_HOST = "localhost";
    private static final Integer WIREMOCK_PORT = 8088;

    private static final WireMockClient wiremockClient = new WireMockClient();
    private static HttpAdminClient wiremockAdminClient = new HttpAdminClient(WIREMOCK_HOST, WIREMOCK_PORT);

    public static WireMockClient getInstance()
    {
        return wiremockClient;
    }
    public HttpAdminClient getWiremockAdminClient()
    {

        return wiremockAdminClient;

    }
}
