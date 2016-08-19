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
public class Employee implements Serializable, IModelSave {
    @JsonProperty("Photo")
    public String Photo;
    @JsonProperty("PostalCode")
    public String PostalCode;
    @JsonProperty("Region")
    public String Region;
    @JsonProperty("ReportsTo")
    public String ReportsTo;
    @JsonProperty("Title")
    public String Title;
    @JsonProperty("TitleOfCourtes")
    public String TitleOfCourtes;
    @JsonProperty("Address")
    public String Address;
    @JsonProperty("BirthDate")
    public String BirthDate;
    @JsonProperty("City")
    public String City;
    @JsonProperty("Country")
    public String Country;
    @JsonProperty("EmployeeID")
    public String EmployeeID;
    @JsonProperty("Extension")
    public String Extension;
    @JsonProperty("FirstName")
    public String FirstName;
    @JsonProperty("HireDate")
    public String HireDate;
    @JsonProperty("HomePhone")
    public String HomePhone;
    @JsonProperty("LastName")
    public String LastName;

    public Employee() {
    }

    public Employee(String photo, String postalCode, String region, String reportsTo, String title, String titleOfCourtes, String address, String birthDate, String city, String country, String employeeID, String extension, String firstName, String hireDate, String homePhone, String lastName) {
        Photo = photo;
        PostalCode = postalCode;
        Region = region;
        ReportsTo = reportsTo;
        Title = title;
        TitleOfCourtes = titleOfCourtes;
        Address = address;
        BirthDate = birthDate;
        City = city;
        Country = country;
        EmployeeID = employeeID;
        Extension = extension;
        FirstName = firstName;
        HireDate = hireDate;
        HomePhone = homePhone;
        LastName = lastName;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getPostalCode() {
        return PostalCode;
    }

    public void setPostalCode(String postalCode) {
        PostalCode = postalCode;
    }

    public String getRegion() {
        return Region;
    }

    public void setRegion(String region) {
        Region = region;
    }

    public String getReportsTo() {
        return ReportsTo;
    }

    public void setReportsTo(String reportsTo) {
        ReportsTo = reportsTo;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getTitleOfCourtes() {
        return TitleOfCourtes;
    }

    public void setTitleOfCourtes(String TitleOfCourtes) {
        TitleOfCourtes = TitleOfCourtes;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String birthDate) {
        BirthDate = birthDate;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getEmployeeID() {
        return EmployeeID;
    }

    public void setEmployeeID(String employeeID) {
        EmployeeID = employeeID;
    }

    public String getExtension() {
        return Extension;
    }

    public void setExtension(String extension) {
        Extension = extension;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getHireDate() {
        return HireDate;
    }

    public void setHireDate(String hireDate) {
        HireDate = hireDate;
    }

    public String getHomePhone() {
        return HomePhone;
    }

    public void setHomePhone(String homePhone) {
        HomePhone = homePhone;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    @Override
    public String toString() {
        return this.getFirstName() + " " + this.getLastName() + " " + this.getTitle();
    }

    @Override
    public void Save(Context context) {
        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("Photo", this.Photo);
            jsonObject.accumulate("PostalCode", this.PostalCode);
            jsonObject.accumulate("Region", this.Region);
            jsonObject.accumulate("ReportsTo", this.ReportsTo);
            jsonObject.accumulate("Title", this.Title);
            jsonObject.accumulate("TitleOfCourtes", this.TitleOfCourtes);
            jsonObject.accumulate("Address", this.Address);
            jsonObject.accumulate("BirthDate", this.BirthDate);
            jsonObject.accumulate("City", this.City);
            jsonObject.accumulate("Country", this.Country);
            jsonObject.accumulate("EmployeeID", this.EmployeeID);
            jsonObject.accumulate("Extension", this.Extension);
            jsonObject.accumulate("FirstName", this.FirstName);
            jsonObject.accumulate("HireDate", this.HireDate);
            jsonObject.accumulate("HomePhone", this.HomePhone);
            jsonObject.accumulate("LastName", this.LastName);
            PostFeedTask post = new PostFeedTask(jsonObject, context.getResources().getString(R.string.Employee_api_set));
            post.execute("");

        } catch (Exception e) {
            Log.d("Customer", e.getLocalizedMessage());
        }
    }
}
