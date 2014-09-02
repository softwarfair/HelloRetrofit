package org.softwarfair.yo;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.softwarfair.hostinfo.HostIpGetInfo;
import org.softwarfair.yo.beans.SubscriptionsResult;
import retrofit.RestAdapter;
import retrofit.client.Response;

@Ignore("Working some time, because Yo api does not like retrofit")
public class YoApiTest {

    private static YoApi client;

    private static final String API_KEY = ""; // Your api key here!
    private static final String YO_FRIEND = ""; // Your friend here!

    @BeforeClass
    public static void init() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(YoApi.BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        client = restAdapter.create(YoApi.class);
    }

    @Test
    public void testSubscribersCount() throws Exception {
        SubscriptionsResult subscriptionsResult = client.subscribersCount(API_KEY);
        Assert.assertEquals(0, subscriptionsResult.getResult());
    }

    @Test
    public void testYo() throws Exception {
        Response yoResponse = client.yo(API_KEY, YO_FRIEND);

        Assert.assertEquals(200, yoResponse.getStatus());
    }
}