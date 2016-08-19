package kolek.krzysztof.pum.pumkrzysztofkolek;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.mainMenu_ListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                String str = ((AppCompatTextView) view).getText().toString();
                Intent intent;
                switch (str) {
                    case "Employees":
                        intent = new Intent(getApplicationContext(), EmployeeActivity.class);
                        startActivity(intent);
                        break;
                    case "Customers":
                        intent = new Intent(getApplicationContext(), CustomerActivity.class);
                        startActivity(intent);
                        break;
                    case "Suppliers":
                        intent = new Intent(getApplicationContext(), SupplierActivity.class);
                        startActivity(intent);
                        break;
                    case "SQL":
                        intent = new Intent(getApplicationContext(), SQLViewerActivity.class);
                        startActivity(intent);
                        break;
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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




}
