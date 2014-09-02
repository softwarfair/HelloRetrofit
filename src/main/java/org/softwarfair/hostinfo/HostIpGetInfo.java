package org.softwarfair.hostinfo;

import org.softwarfair.hostinfo.beans.HostInfo;
import retrofit.http.GET;
import retrofit.http.Query;

public interface HostIpGetInfo {
    public static final String BASE_URL = "http://api.hostip.info/";

    @GET("/get_json.php")
    public HostInfo getInfo(@Query("ip") String ip, @Query("position") Boolean position);

    @GET("/get_json.php")
    public HostInfo getInfo(@Query("ip") String ip);

}
