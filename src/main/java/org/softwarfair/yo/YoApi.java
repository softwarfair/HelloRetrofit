package org.softwarfair.yo;

import org.softwarfair.yo.beans.SubscriptionsResult;
import retrofit.client.Response;
import retrofit.http.*;

public interface YoApi {

    public static final String BASE_URL = "https://api.justyo.co";

    @FormUrlEncoded
    @POST("/yo")
    Response yo(@Field("api_token") String token, @Field("username") String user);

    @GET("/subscribers_count")
    SubscriptionsResult subscribersCount(@Query("api_token") String token);

}
