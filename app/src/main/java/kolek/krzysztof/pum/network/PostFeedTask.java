package kolek.krzysztof.pum.network;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import kolek.krzysztof.pum.interfaces.IUpdateViewFromResponse;


public class PostFeedTask extends AsyncTask<String, Void, Void> {
    JSONObject jsonObject;
    String context;
    private IUpdateViewFromResponse _updateInterface;

    public PostFeedTask(JSONObject jsonObject, String context) {
        this.jsonObject = jsonObject;
        this.context = context;
    }

    public void set_updateInterface(IUpdateViewFromResponse _updateInterface) {
        this._updateInterface = _updateInterface;
    }

    @Override
    protected Void doInBackground(String... urls) {
        InputStream inputStream = null;
        String result = "";
        try {

            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(context);

            String json = "";

            json = jsonObject.toString();

            StringEntity se = new StringEntity(json);

            httpPost.setEntity(se);

            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");



            HttpResponse httpResponse = httpclient.execute(httpPost);

            inputStream = httpResponse.getEntity().getContent();

            if (inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

            if(_updateInterface != null)
                _updateInterface.UpdateInterface(result);

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        // 11. return result
        //return result;
        return null;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }
}
