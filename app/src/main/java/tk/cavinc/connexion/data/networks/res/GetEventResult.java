package tk.cavinc.connexion.data.networks.res;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import tk.cavinc.connexion.data.models.EventsModel;

/**
 * Created by cav on 07.05.20.
 */

/*
{
    "item_count": 2,
    "result": 200,
    "events": [
        {
            "user_name": "хурмт",
            "create_date": "2020-05-07 15:22",
            "event_type": 0,
            "to_guid": "847b6ade-58b4-4d3a-b167-d97154130421",
            "event_msg": "Тест 12"
        },
        {
            "user_name": "Иван",
            "create_date": "2020-05-07 15:01",
            "event_type": 0,
            "to_guid": "476a7890-bb45-4a70-80d0-132129da8a58",
            "event_msg": "Тест"
        }
    ]
}
 */
public class GetEventResult {
    @SerializedName("status")
    @Expose
    private Boolean status;

    @SerializedName("result")
    @Expose
    private Integer result;

    @SerializedName("error")
    @Expose
    private String error;

    @SerializedName("item_count")
    @Expose
    private int itemCount;

    @SerializedName("events")
    @Expose
    private List<EventsModel> mEventsModelList;

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public List<EventsModel> getEventsModelList() {
        return mEventsModelList;
    }

    public void setEventsModelList(List<EventsModel> eventsModelList) {
        mEventsModelList = eventsModelList;
    }
}
