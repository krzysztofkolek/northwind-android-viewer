package kolek.krzysztof.pum.network;

import android.os.AsyncTask;

import java.io.IOException;

import kolek.krzysztof.pum.interfaces.IActivityWait;
import kolek.krzysztof.pum.network.EasyHttpClient;


public class RetrieveFeedTask extends AsyncTask<String, Void, String> {
    private Exception exception;
    private IActivityWait _parent;
    private String data;

    public RetrieveFeedTask(IActivityWait parent)
    {
        this._parent = parent;
    }

    protected String doInBackground(String... url) {
        String jsonString = "";
        try {
            EasyHttpClient client = new EasyHttpClient();
            try {
                        jsonString = client.get(url[0]);

            }
            catch (Exception ex)
            {
                String stack =ex.toString();

            }
        } catch (Exception e) {
            this.exception = e;
            return null;
        }
        data = jsonString;
        return jsonString;
    }

    @Override
    protected void onPostExecute(String feed) {
        try {
            _parent.GetData(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
