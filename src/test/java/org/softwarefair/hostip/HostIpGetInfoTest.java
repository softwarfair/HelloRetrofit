package org.softwarefair.hostip;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import org.junit.BeforeClass;
import org.junit.Test;
import org.softwarfair.hostinfo.beans.HostInfo;
import org.softwarfair.hostinfo.HostIpGetInfo;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import java.util.Date;

import static org.junit.Assert.*;

public class HostIpGetInfoTest {

    private static HostIpGetInfo client;

    @BeforeClass
    public static void init() {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(HostIpGetInfo.BASE_URL)
                .setConverter(new GsonConverter(gson))
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .build();
        client = restAdapter.create(HostIpGetInfo.class);
    }

    @Test
    public void testGetInfoSimple() throws Exception {
        HostInfo info = client.getInfo("12.215.42.19");

        assertEquals("Aurora, TX", info.getCity());
        assertEquals("US", info.getCountryCode());
        assertNull(info.getLatitude());
        assertNull(info.getLongitude());
    }

    @Test
    public void testGetLatitude() throws Exception {
        HostInfo info = client.getInfo("12.215.42.19", Boolean.TRUE);

        assertEquals("Aurora, TX", info.getCity());
        assertEquals("US", info.getCountryCode());
        assertEquals(33.0582, info.getLatitude(), 4);
        assertEquals(-97.5159f, info.getLongitude(), 4);
    }
}