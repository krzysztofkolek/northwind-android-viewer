package kolek.krzysztof.pum.models;

import android.content.Context;
import android.util.Log;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONObject;

import java.io.Serializable;

import kolek.krzysztof.pum.interfaces.IModelSave;
import kolek.krzysztof.pum.network.PostFeedTask;
import kolek.krzysztof.pum.pumkrzysztofkolek.R;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Supplier implements Serializable, IModelSave {

    @JsonProperty("SupplierID")
    public String SupplierID;
    @JsonProperty("CompanyName")
    public String CompanyName;
    @JsonProperty("ContactName")
    public String ContactName;
    @JsonProperty("ContactTitle")
    public String ContactTitle;
    @JsonProperty("Address")
    public String Address;
    @JsonProperty("City")
    public String City;
    @JsonProperty("Region")
    public String Region;
    @JsonProperty("PostalCode")
    public String PostalCode;
    @JsonProperty("Country")
    public String Country;
    @JsonProperty("Phone")
    public String Phone;
    @JsonProperty("Fax")
    public String Fax;
    @JsonProperty("HomePage")
    public String HomePage;

    public Supplier() {
    }

    public Supplier(String supplierID, String companyName, String contactName, String contactTitle, String address, String city, String region, String postalCode, String country, String phone, String fax, String homePage) {
        SupplierID = supplierID;
        CompanyName = companyName;
        ContactName = contactName;
        ContactTitle = contactTitle;
        Address = address;
        City = city;
        Region = region;
        PostalCode = postalCode;
        Country = country;
        Phone = phone;
        Fax = fax;
        HomePage = homePage;
    }

    public String getSupplierID() {
        return SupplierID;
    }

    public void setSupplierID(String supplierID) {
        SupplierID = supplierID;
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

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
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

    public String getHomePage() {
        return HomePage;
    }

    public void setHomePage(String homePage) {
        HomePage = homePage;
    }

    @Override
    public String toString() {
        return this.CompanyName;
    }

    @Override
    public void Save(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("SupplierID", this.SupplierID);
            jsonObject.accumulate("CompanyName", this.CompanyName);
            jsonObject.accumulate("ContactName", this.ContactName);
            jsonObject.accumulate("ContactTitle", this.ContactTitle);
            jsonObject.accumulate("Address", this.Address);
            jsonObject.accumulate("City", this.City);
            jsonObject.accumulate("PostalCode", this.PostalCode);
            jsonObject.accumulate("Country", this.Country);
            jsonObject.accumulate("Phone", this.Phone);
            jsonObject.accumulate("Fax", this.Fax);

            PostFeedTask post = new PostFeedTask(jsonObject, context.getResources().getString(R.string.Supplier_api_set));
            post.execute("");

        } catch (Exception e) {
            Log.d("Customer", e.getLocalizedMessage());
        }
    }
}
