package kolek.krzysztof.pum.overloads;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

import kolek.krzysztof.pum.interfaces.IActivityWait;
import kolek.krzysztof.pum.interfaces.ILoadData;
import kolek.krzysztof.pum.network.RetrieveFeedTask;


public class PUMActivityData<T> implements IActivityWait {
    private ILoadData<T> _activity;
    private List<T> _data;
    private String _url;
    final Class<T> typeParameterClass;

    public PUMActivityData(String jsonUrl, ILoadData<T> activity, Class<T> typeParameterClass) {
        this.typeParameterClass = typeParameterClass;
        _url = jsonUrl;
        this._activity = activity;

        RetrieveFeedTask task = new RetrieveFeedTask(this);
        task.execute(this._url);
    }

    @Override
    public void GetData(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        _data = mapper.readValue(json, mapper.getTypeFactory().constructCollectionType(List.class, this.typeParameterClass));
        _activity.LoadData(_data);
    }

}
