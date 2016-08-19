package kolek.krzysztof.pum.pumkrzysztofkolek;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import kolek.krzysztof.pum.interfaces.ISaveData;
import kolek.krzysztof.pum.models.Employee;


public class DetailedEmployeeActivity extends ActionBarActivity {
    private Employee _data;
    private ISaveData<Employee> _saveDal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_employee);
        Intent i = getIntent();
        _data = (Employee) i.getSerializableExtra("Employee");
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
                Intent intent = new Intent(getApplicationContext(), EmployeeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void SetData(Employee data) {

        String input = data.getPhoto();
        input = input.replace("\r\n", "").replace("\\r\\n", "");
        byte [] byteArray = android.util.Base64.decode(input, android.util.Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 78, byteArray.length - 78);

        ((ImageView) findViewById(R.id.EmployeePhoto)).setImageBitmap(bitmap);
        ((EditText) findViewById(R.id.FirstName_TextBox)).setText(data.getFirstName());
        ((EditText) findViewById(R.id.LastName_TextBox)).setText(data.getLastName());
        ((EditText) findViewById(R.id.Title_TextBox)).setText(data.getTitle());
        ((EditText) findViewById(R.id.TitleOfCourtesy_TextBox)).setText(data.getTitleOfCourtes());
        ((EditText) findViewById(R.id.BirthDate_TextBox)).setText(data.getBirthDate());
        ((EditText) findViewById(R.id.Adress_TextBox)).setText(data.getAddress());
        ((EditText) findViewById(R.id.City_TextBox)).setText(data.getCity());
        ((EditText) findViewById(R.id.Region_TextBox)).setText(data.getRegion());
        ((EditText) findViewById(R.id.PostalCode_TextBox)).setText(data.getPostalCode());
        ((EditText) findViewById(R.id.Country_TextBox)).setText(data.getCountry());
        ((EditText) findViewById(R.id.HomePhone_TextBox)).setText(data.getHomePhone());


    }

    private void UpdateDataInModel() {
        _data.setFirstName(((EditText) findViewById(R.id.FirstName_TextBox)).getText().toString());
        _data.setLastName(((EditText) findViewById(R.id.LastName_TextBox)).getText().toString());
        _data.setTitle(((EditText) findViewById(R.id.Title_TextBox)).getText().toString());
        _data.setTitleOfCourtes(((EditText) findViewById(R.id.TitleOfCourtesy_TextBox)).getText().toString());
        _data.setBirthDate(((EditText) findViewById(R.id.BirthDate_TextBox)).getText().toString());
        _data.setAddress(((EditText) findViewById(R.id.Adress_TextBox)).getText().toString());
        _data.setCity(((EditText) findViewById(R.id.City_TextBox)).getText().toString());
        _data.setRegion(((EditText) findViewById(R.id.Region_TextBox)).getText().toString());
        _data.setPostalCode(((EditText) findViewById(R.id.PostalCode_TextBox)).getText().toString());
        _data.setCountry(((EditText) findViewById(R.id.Country_TextBox)).getText().toString());
        _data.setHomePhone(((EditText) findViewById(R.id.HomePhone_TextBox)).getText().toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_detailed_employee, menu);
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
