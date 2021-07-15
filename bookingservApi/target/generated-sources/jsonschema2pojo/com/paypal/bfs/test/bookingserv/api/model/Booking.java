
package com.paypal.bfs.test.bookingserv.api.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * Booking resource
 * <p>
 * Booking resource object
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "first_name",
    "last_name",
    "birth_date",
    "checkin_date",
    "checkout_date",
    "total_price",
    "deposit",
    "address"
})
public class Booking {

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("Booking id")
    private Integer id;
    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    @JsonPropertyDescription("First name")
    private String firstName;
    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    @JsonPropertyDescription("Last name")
    private String lastName;
    /**
     * Date of Birth (yyyy/MM/dd)
     * 
     */
    @JsonProperty("birth_date")
    @JsonPropertyDescription("Date of Birth (yyyy/MM/dd)")
    private String birthDate;
    /**
     * Date of Check-in (yyyy/MM/dd)
     * 
     */
    @JsonProperty("checkin_date")
    @JsonPropertyDescription("Date of Check-in (yyyy/MM/dd)")
    private String checkinDate;
    /**
     * Date of Check-out (yyyy/MM/dd)
     * 
     */
    @JsonProperty("checkout_date")
    @JsonPropertyDescription("Date of Check-out (yyyy/MM/dd)")
    private String checkoutDate;
    /**
     * Total price
     * 
     */
    @JsonProperty("total_price")
    @JsonPropertyDescription("Total price")
    private Double totalPrice;
    /**
     * Deposit
     * 
     */
    @JsonProperty("deposit")
    @JsonPropertyDescription("Deposit")
    private Double deposit;
    /**
     * Address
     * 
     */
    @JsonProperty("address")
    @JsonPropertyDescription("Address")
    private Address address;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * Booking id
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     * First name
     * (Required)
     * 
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     * Last name
     * (Required)
     * 
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Date of Birth (yyyy/MM/dd)
     * 
     */
    @JsonProperty("birth_date")
    public String getBirthDate() {
        return birthDate;
    }

    /**
     * Date of Birth (yyyy/MM/dd)
     * 
     */
    @JsonProperty("birth_date")
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    /**
     * Date of Check-in (yyyy/MM/dd)
     * 
     */
    @JsonProperty("checkin_date")
    public String getCheckinDate() {
        return checkinDate;
    }

    /**
     * Date of Check-in (yyyy/MM/dd)
     * 
     */
    @JsonProperty("checkin_date")
    public void setCheckinDate(String checkinDate) {
        this.checkinDate = checkinDate;
    }

    /**
     * Date of Check-out (yyyy/MM/dd)
     * 
     */
    @JsonProperty("checkout_date")
    public String getCheckoutDate() {
        return checkoutDate;
    }

    /**
     * Date of Check-out (yyyy/MM/dd)
     * 
     */
    @JsonProperty("checkout_date")
    public void setCheckoutDate(String checkoutDate) {
        this.checkoutDate = checkoutDate;
    }

    /**
     * Total price
     * 
     */
    @JsonProperty("total_price")
    public Double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Total price
     * 
     */
    @JsonProperty("total_price")
    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * Deposit
     * 
     */
    @JsonProperty("deposit")
    public Double getDeposit() {
        return deposit;
    }

    /**
     * Deposit
     * 
     */
    @JsonProperty("deposit")
    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    /**
     * Address
     * 
     */
    @JsonProperty("address")
    public Address getAddress() {
        return address;
    }

    /**
     * Address
     * 
     */
    @JsonProperty("address")
    public void setAddress(Address address) {
        this.address = address;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Booking.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("firstName");
        sb.append('=');
        sb.append(((this.firstName == null)?"<null>":this.firstName));
        sb.append(',');
        sb.append("lastName");
        sb.append('=');
        sb.append(((this.lastName == null)?"<null>":this.lastName));
        sb.append(',');
        sb.append("birthDate");
        sb.append('=');
        sb.append(((this.birthDate == null)?"<null>":this.birthDate));
        sb.append(',');
        sb.append("checkinDate");
        sb.append('=');
        sb.append(((this.checkinDate == null)?"<null>":this.checkinDate));
        sb.append(',');
        sb.append("checkoutDate");
        sb.append('=');
        sb.append(((this.checkoutDate == null)?"<null>":this.checkoutDate));
        sb.append(',');
        sb.append("totalPrice");
        sb.append('=');
        sb.append(((this.totalPrice == null)?"<null>":this.totalPrice));
        sb.append(',');
        sb.append("deposit");
        sb.append('=');
        sb.append(((this.deposit == null)?"<null>":this.deposit));
        sb.append(',');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

}
