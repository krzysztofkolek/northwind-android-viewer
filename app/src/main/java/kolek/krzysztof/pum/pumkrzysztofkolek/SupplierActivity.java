package kolek.krzysztof.pum.pumkrzysztofkolek;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;

import kolek.krzysztof.pum.Tools.SupplierComparator;
import kolek.krzysztof.pum.interfaces.ILoadData;
import kolek.krzysztof.pum.models.Supplier;
import kolek.krzysztof.pum.overloads.PUMActivityData;


public class SupplierActivity extends ActionBarActivity  implements ILoadData<Supplier> {
    private PUMActivityData<Supplier> _dal;
    private ListView _lv;
    private List<Supplier> _data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_supplier);

        this._dal = new PUMActivityData<Supplier>(getString(R.string.Supplier_api), this, Supplier.class);
        ((Button)findViewById(R.id.MainMenu_Button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent;
                intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        ((Button)findViewById(R.id.sort_Button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listView = (ListView) findViewById(R.id.customers_ListView);
                ArrayAdapter adapeter = (ArrayAdapter)listView.getAdapter();
                adapeter.sort(new SupplierComparator());
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_supplier, menu);
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
    public void LoadData(List<Supplier> data) {
        _data = data;
        _lv=(ListView) findViewById(R.id.customers_ListView);
        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, data);

        // Assign adapter to ListView
        _lv.setAdapter(adapter);

        _lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1,
                                    int position, long arg3) {
                // TODO Auto-generated method stub
                int itemPosition     = position;

                Intent intent;
                intent = new Intent(getApplicationContext(), DetailedSupplierActivity.class);
                intent.putExtra("Supplier", _data.get(itemPosition));
                startActivity(intent);
            }
        });

        findViewById(R.id.loadingPanel).setVisibility(View.GONE);
    }

}
