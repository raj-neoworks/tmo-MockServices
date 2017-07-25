package MockComponents;

/**
 * Created by rgovindarajan on 20/07/17.
 */
import mockclient.WireMockClient;
import com.github.tomakehurst.wiremock.client.HttpAdminClient;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.junit.Test;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class mockAlerts {
    private static final String union_facts_request = "/unionthreaded/v2/facts";
    WireMockClient wiremockClientObj = WireMockClient.getInstance();
    private HttpAdminClient wmAdminClient = wiremockClientObj.getWiremockAdminClient();

    public mockAlerts()
    {
        //this.wmAdminClient = wiremockClientObj.getWiremockAdminClient();
    }

    @Test
    public void unionFacts_signalStrengthProblem_stub()
    {
        StubMapping stubMap;
        wmAdminClient.resetMappings();
        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111222333444555\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("01-signal_strength_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111222333444555\"\n}", true, true)).willReturn(aResponse().withBodyFile("01-signal_strength_1_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111222333444666\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("02-data_usage_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111222333444777\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("03-customer_status_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111000000000000\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("04-No_fact_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"110011000000555\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("04-No_fact_1_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"110012000000555\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("04-No_fact_2_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"110013000000555\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("04-No_fact_3_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"110014000000555\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("04-No_fact_4_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"501111111111111\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("04-No_fact_5_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"601111111111111\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("04-No_fact_6_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000100\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("05-Union_merge_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000200\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("06-Union_No_facts_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000300\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("07-Union_Full_facts_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000400\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("08-Union_No_facts_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000500\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("09-Union_Full_false_facts_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000600\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("10-Union_facts_Alert_id_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"701111111111111\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("10-Union_facts-Alert_id_1_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"801111111111111\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("10-Union_facts-Alert_id_2_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"901111111111111\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("10-Union_facts-Alert_id_3_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"707111111111111\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("10-Union_facts-Alert_id_4_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000700\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("11-Union_facts-Tags_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000800\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("12-Union_facts-conflict_1_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000900\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("13-Union_facts-conflict_2_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111000110\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("14-Union_facts-duplicate_facts_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        stubMap = post(urlEqualTo(union_facts_request)).withHeader("system_identifier", containing("")).withHeader("auth_header", containing("")).withRequestBody(equalToJson("{\n \"msisdn\":\"1234567890\",\n \"imei\":\"111111111123456\",\n \"imsi\":\"123456000000000\"\n}", true, true)).willReturn(aResponse().withBodyFile("15-No_fact_from_Union_response.json").withHeader("Content-Type", "application/json").withStatus(200)).build();
        wmAdminClient.addStubMapping(stubMap);

        System.out.println("List of all Stubbings => "+wmAdminClient.listAllStubMappings());
    }
}
