package tk.cavinc.connexion.data.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

import tk.cavinc.connexion.utils.Func;

/**
 * Created by cav on 07.05.20.
 */

public class EventsModel {
    @SerializedName("event_type")
    @Expose
    private int mEventType;

    @SerializedName("event_msg")
    @Expose
    private String mMsg;

    @SerializedName("create_date")
    @Expose
    private String mDateEventStr;

    private Date mDateEvent;

    @SerializedName("user_name")
    @Expose
    private String mClientName;

    @SerializedName("to_guid")
    @Expose
    private String mClientGuid;

    public EventsModel(int eventType, String msg, Date dateEvent, String clientName, String clientGuid) {
        mEventType = eventType;
        mMsg = msg;
        mDateEvent = dateEvent;
        mClientName = clientName;
        mClientGuid = clientGuid;
    }

    public String getClientName() {
        return mClientName;
    }

    public String getClientGuid() {
        return mClientGuid;
    }

    public int getEventType() {
        return mEventType;
    }

    public String getMsg() {
        return mMsg;
    }

    public Date getDateEvent() {
        return mDateEvent;
    }

    public String getDateEventStr() {
        return mDateEventStr;
    }

    public void setDateEventStr(String dateEventStr) {
        mDateEventStr = dateEventStr;
        mDateEvent = Func.strToDate(mDateEventStr,"yyyy-MM-dd HH:mm");
    }
}
