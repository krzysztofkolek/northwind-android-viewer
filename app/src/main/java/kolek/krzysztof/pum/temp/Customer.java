package kolek.krzysztof.pum.temp;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.google.gson.annotations.SerializedName;

@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonInclude(JsonInclude.Include.NON_NULL)
//@Generated("org.jsonschema2pojo")
//@JsonPropertyOrder({
//        "CustomerID",
//        "CompanyName",
//        "ContactName",
//        "ContactTitle",
//        "Address",
//        "City",
//        "Region",
//        "PostalCode",
//        "Country",
//        "Phone",
//        "Fax",
//        "Orders",
//        "CustomerDemographics"
//})
public class Customer {

    @SerializedName("CustomerID")
    private String CustomerID;
    @SerializedName("CompanyName")
    private String CompanyName;
    @SerializedName("ContactName")
    private String ContactName;
    @SerializedName("ContactTitle")
    private String ContactTitle;
    @SerializedName("Address")
    private String Address;
    @SerializedName("City")
    private String City;
    @SerializedName("PostalCode")
    private String PostalCode;
    @SerializedName("Country")
    private String Country;
    @SerializedName("Phone")
    private String Phone;
    @SerializedName("Fax")
    private String Fax;


    public Customer(String CustomerID, String CompanyName, String ContactName, String ContactTitle, String Address, String City, String PostalCode, String Country, String Phone, String Fax) {
        this.CustomerID = CustomerID;
        this.CompanyName = CompanyName;
        this.ContactName = ContactName;
        this.ContactTitle = ContactTitle;
        this.Address = Address;
        this.City = City;
        this.PostalCode = PostalCode;
        this.Country = Country;
        this.Phone = Phone;
        this.Fax = Fax;
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
}