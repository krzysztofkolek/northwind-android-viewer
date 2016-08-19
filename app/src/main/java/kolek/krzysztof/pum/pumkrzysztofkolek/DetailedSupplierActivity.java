package kolek.krzysztof.pum.pumkrzysztofkolek;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import kolek.krzysztof.pum.interfaces.ISaveData;
import kolek.krzysztof.pum.models.Customer1;
import kolek.krzysztof.pum.models.Supplier;


public class DetailedSupplierActivity extends ActionBarActivity {
    private Supplier _data;
    private ISaveData<Supplier> _saveDal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_supplier);
        Intent i = getIntent();
        _data = (Supplier) i.getSerializableExtra("Supplier");
        SetData(_data);

        ((Button) findViewById(R.id.Save_Button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UpdateDataInModel();
                _saveDal.SaveData(_data);
            }
        });
        ((Button) findViewById(R.id.Cancel_Button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), CustomerActivity.class);
                startActivity(intent);
            }
        });
    }

    private void SetData(Supplier data) {
        ((EditText) findViewById(R.id.CompanyName_TextBox)).setText(_data.getCompanyName());
        ((EditText) findViewById(R.id.ContractName_TextBox)).setText(_data.getContactName());
        ((EditText) findViewById(R.id.ContractTitle_TextBox)).setText(_data.getContactTitle());
        ((EditText) findViewById(R.id.Adress_TextBox)).setText(_data.getAddress());
        ((EditText) findViewById(R.id.Region_TextBox)).setText(_data.getRegion());
        ((EditText) findViewById(R.id.City_TextBox)).setText(_data.getCity());
        ((EditText) findViewById(R.id.PostalCode_TextBox)).setText(_data.getPostalCode());
        ((EditText) findViewById(R.id.Country_TextBox)).setText(_data.getCountry());
        ((EditText) findViewById(R.id.Phone_TextBox)).setText(_data.getPhone());
        ((EditText) findViewById(R.id.Fax_TextBox)).setText(_data.getFax());
    }

    private void UpdateDataInModel() {
        _data.setCompanyName(((EditText) findViewById(R.id.CompanyName_TextBox)).getText().toString());
        _data.setContactName(((EditText) findViewById(R.id.ContractName_TextBox)).getText().toString());
        _data.setContactTitle(((EditText) findViewById(R.id.ContractTitle_TextBox)).getText().toString());
        _data.setAddress(((EditText) findViewById(R.id.Adress_TextBox)).getText().toString());
        _data.setRegion(((EditText) findViewById(R.id.Region_TextBox)).getText().toString());
        _data.setCity(((EditText) findViewById(R.id.City_TextBox)).getText().toString());
        _data.setPostalCode(((EditText) findViewById(R.id.PostalCode_TextBox)).getText().toString());
        _data.setCountry(((EditText) findViewById(R.id.Country_TextBox)).getText().toString());
        _data.setPhone(((EditText) findViewById(R.id.Phone_TextBox)).getText().toString());
        _data.setFax(((EditText) findViewById(R.id.Fax_TextBox)).getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detailed_supplier, menu);
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
