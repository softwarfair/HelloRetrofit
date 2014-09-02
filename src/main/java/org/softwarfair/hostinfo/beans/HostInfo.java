package org.softwarfair.hostinfo.beans;

import com.google.gson.annotations.SerializedName;
import lombok.Value;

@Value
public class HostInfo {
    private String countryName;
    private String countryCode;
    private String city;
    private String ip;
    @SerializedName("lat")
    private Float latitude;
    @SerializedName(("lng"))
    private Float longitude;

}
