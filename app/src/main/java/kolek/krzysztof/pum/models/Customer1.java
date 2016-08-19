package kolek.krzysztof.pum.models;


import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kolek.krzysztof.pum.interfaces.IModalAction;
import kolek.krzysztof.pum.interfaces.IModalData;
import kolek.krzysztof.pum.interfaces.IModelSave;
import kolek.krzysztof.pum.network.PostFeedTask;
import kolek.krzysztof.pum.pumkrzysztofkolek.R;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer1 implements IModalData<Customer1>, IModalAction<Customer1>, Serializable, IModelSave {
    @JsonProperty("CustomerID")
    private String CustomerID;
    @JsonProperty("CompanyName")
    private String CompanyName;
    @JsonProperty("ContactName")
    private String ContactName;
    @JsonProperty("ContactTitle")
    private String ContactTitle;
    @JsonProperty("Address")
    private String Address;
    @JsonProperty("City")
    private String City;
    @JsonProperty("PostalCode")
    private String PostalCode;
    @JsonProperty("Country")
    private String Country;
    @JsonProperty("Phone")
    private String Phone;
    @JsonProperty("Fax")
    private String Fax;

    public Customer1() {
    }

    public Customer1(String customerID, String companyName, String contactName, String contactTitle, String address, String city, String postalCode, String country, String phone, String fax) {
        CustomerID = customerID;
        CompanyName = companyName;
        ContactName = contactName;
        ContactTitle = contactTitle;
        Address = address;
        City = city;
        PostalCode = postalCode;
        Country = country;
        Phone = phone;
        Fax = fax;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public void setCustomerID(String customerID) {
        CustomerID = customerID;
    }

    public String getCompanyName() {
        return CompanyName;
    }

    public void setCompanyName(String companyName) {
        CompanyName = companyName;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getContactTitle() {
        return ContactTitle;
    }

    public void setContactTitle(String contactTitle) {
        ContactTitle = contactTitle;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getFax() {
        return Fax;
    }

    public void setFax(String fax) {
        Fax = fax;
    }

    @Override
    public String toString() {
        return CompanyName;
    }

    @Override
    public Map<String, String> GetModalData() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("CustomerID", this.CustomerID);
        map.put("CompanyName", this.CompanyName);
        map.put("ContactName", this.ContactName);
        map.put("ContactTitle", this.ContactTitle);
        map.put("Address", this.Address);
        map.put("City", this.City);
        map.put("PostalCode", this.PostalCode);
        map.put("Country", this.Country);
        map.put("Phone", this.Phone);
        map.put("Fax", this.Fax);
        return map;
    }

    @Override
    public String[] FormatedData() {
        List<String> list = new ArrayList<String>();
        for (Map.Entry item : GetModalData().entrySet()) {
            list.add(item.getKey() + " " + item.getValue());
        }
        return (String[]) list.toArray();
    }

    @Override
    public void Action(int position) {

    }

    @Override
    public void Save(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("CustomerID", this.CustomerID);
            jsonObject.accumulate("CompanyName", this.CompanyName);
            jsonObject.accumulate("ContactName", this.ContactName);
            jsonObject.accumulate("ContactTitle", this.ContactTitle);
            jsonObject.accumulate("Address", this.Address);
            jsonObject.accumulate("City", this.City);
            jsonObject.accumulate("PostalCode", this.PostalCode);
            jsonObject.accumulate("Country", this.Country);
            jsonObject.accumulate("Phone", this.Phone);
            jsonObject.accumulate("Fax", this.Fax);

            PostFeedTask post = new PostFeedTask(jsonObject, context.getResources().getString(R.string.Customer_api_set));
            post.execute("");

        } catch (Exception e) {
            Log.d("Customer", e.getLocalizedMessage());
        }

        // 11. return result
        //return result;
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
