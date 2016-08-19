package kolek.krzysztof.pum.pumkrzysztofkolek;

import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;

import kolek.krzysztof.pum.Tools.FileUtilities;
import kolek.krzysztof.pum.Tools.JsonFormatter;
import kolek.krzysztof.pum.interfaces.IUpdateViewFromResponse;
import kolek.krzysztof.pum.network.PostFeedTask;


public class SQLViewerActivity extends ActionBarActivity implements IUpdateViewFromResponse {
    private IUpdateViewFromResponse _updateViewFromResponse;
    public static String RESULT = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sqlviewer);
        _updateViewFromResponse = this;
        findViewById(R.id.loadingPanel).setVisibility(View.INVISIBLE);
        ((TextView) findViewById(R.id.Answer_TextView)).setMovementMethod(new ScrollingMovementMethod());
        ((Button) findViewById(R.id.btnSubmit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                findViewById(R.id.loadingPanel).setVisibility(View.VISIBLE);
                JSONObject jsonObject = new JSONObject();
                try {
                    jsonObject.accumulate("Query", ((EditText) findViewById(R.id.editText)).getText());
                    jsonObject.accumulate("Table", ((Spinner) findViewById(R.id.spinner1)).getSelectedItem().toString());
                    PostFeedTask post = new PostFeedTask(jsonObject, getApplicationContext().getResources().getString(R.string.Sql_api_set));
                    post.set_updateInterface(_updateViewFromResponse);
                    post.execute("");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
        ((Button) findViewById(R.id.button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    File log = new File(Environment.getExternalStorageDirectory(), "Log1.txt");
                    BufferedWriter out = new BufferedWriter(new FileWriter(log.getAbsolutePath(), false));
                    out.write(((TextView) findViewById(R.id.Answer_TextView)).getText().toString());
                    out.close();
                    Toast.makeText(getApplicationContext(), "Saved.", Toast.LENGTH_LONG);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "There was an error.", Toast.LENGTH_LONG);
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sqlviewer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void UpdateInterface(String result) {
        SQLViewerActivity.RESULT = result.replace("#n#", "\n");
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                findViewById(R.id.loadingPanel).setVisibility(View.INVISIBLE);
                ((TextView) findViewById(R.id.Answer_TextView)).setText(SQLViewerActivity.RESULT);
            }
        });
    }
}
