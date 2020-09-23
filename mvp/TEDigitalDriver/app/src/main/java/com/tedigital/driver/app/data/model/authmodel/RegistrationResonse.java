package com.tedigital.driver.app.data.model.authmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class RegistrationResonse {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("bloodGroup")
    @Expose
    private String bloodGroup;
    @SerializedName("dlNumber")
    @Expose
    private String dlNumber;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("driverName")
    @Expose
    private String driverName;
    @SerializedName("licenseCategory")
    @Expose
    private String licenseCategory;
    @SerializedName("licenseValidity")
    @Expose
    private String licenseValidity;
    @SerializedName("mobileNumber")
    @Expose
    private String mobileNumber;
    @SerializedName("phoneType")
    @Expose
    private PhoneType phoneType;
    @SerializedName("languages")
    @Expose
    private List<String> languages = null;
    @SerializedName("specialLicense")
    @Expose
    private String specialLicense;
    @SerializedName("yearOfExp")
    @Expose
    private String yearOfExp;
    @SerializedName("availabilty")
    @Expose
    private String availabilty;
    @SerializedName("driverId")
    @Expose
    private String driverId;
    @SerializedName("userId")
    @Expose
    private String userId;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("maritalStatus")
    @Expose
    private String maritalStatus;
    @SerializedName("policyInsuranceNumber")
    @Expose
    private String policyInsuranceNumber;
    @SerializedName("insuranceValidityDate")
    @Expose
    private String insuranceValidityDate;
    @SerializedName("aadharCardKey")
    @Expose
    private String aadharCardKey;
    @SerializedName("licenseKey")
    @Expose
    private String licenseKey;
    @SerializedName("panNumberKey")
    @Expose
    private String panNumberKey;
    @SerializedName("truckFrontPhotoKey")
    @Expose
    private String truckFrontPhotoKey;
    @SerializedName("truckBackPhotoKey")
    @Expose
    private String truckBackPhotoKey;
    @SerializedName("truckSidePhotoKey")
    @Expose
    private String truckSidePhotoKey;
    @SerializedName("truckRCFrontPhotoKey")
    @Expose
    private String truckRCFrontPhotoKey;
    @SerializedName("truckRCBackPhotoKey")
    @Expose
    private String truckRCBackPhotoKey;
    @SerializedName("truckRCSidePhotoKey")
    @Expose
    private String truckRCSidePhotoKey;
    @SerializedName("panNumber")
    @Expose
    private String panNumber;
    @SerializedName("licenseNumber")
    @Expose
    private String licenseNumber;
    @SerializedName("aadharNumber")
    @Expose
    private String aadharNumber;
    @SerializedName("truckNumber")
    @Expose
    private String truckNumber;
    @SerializedName("truckRCNumber")
    @Expose
    private String truckRCNumber;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDlNumber() {
        return dlNumber;
    }

    public void setDlNumber(String dlNumber) {
        this.dlNumber = dlNumber;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getLicenseCategory() {
        return licenseCategory;
    }

    public void setLicenseCategory(String licenseCategory) {
        this.licenseCategory = licenseCategory;
    }

    public String getLicenseValidity() {
        return licenseValidity;
    }

    public void setLicenseValidity(String licenseValidity) {
        this.licenseValidity = licenseValidity;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public PhoneType getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneType phoneType) {
        this.phoneType = phoneType;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    public String getSpecialLicense() {
        return specialLicense;
    }

    public void setSpecialLicense(String specialLicense) {
        this.specialLicense = specialLicense;
    }

    public String getYearOfExp() {
        return yearOfExp;
    }

    public void setYearOfExp(String yearOfExp) {
        this.yearOfExp = yearOfExp;
    }

    public String getAvailabilty() {
        return availabilty;
    }

    public void setAvailabilty(String availabilty) {
        this.availabilty = availabilty;
    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getPolicyInsuranceNumber() {
        return policyInsuranceNumber;
    }

    public void setPolicyInsuranceNumber(String policyInsuranceNumber) {
        this.policyInsuranceNumber = policyInsuranceNumber;
    }

    public String getInsuranceValidityDate() {
        return insuranceValidityDate;
    }

    public void setInsuranceValidityDate(String insuranceValidityDate) {
        this.insuranceValidityDate = insuranceValidityDate;
    }

    public String getAadharCardKey() {
        return aadharCardKey;
    }

    public void setAadharCardKey(String aadharCardKey) {
        this.aadharCardKey = aadharCardKey;
    }

    public String getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(String licenseKey) {
        this.licenseKey = licenseKey;
    }

    public String getPanNumberKey() {
        return panNumberKey;
    }

    public void setPanNumberKey(String panNumberKey) {
        this.panNumberKey = panNumberKey;
    }

    public String getTruckFrontPhotoKey() {
        return truckFrontPhotoKey;
    }

    public void setTruckFrontPhotoKey(String truckFrontPhotoKey) {
        this.truckFrontPhotoKey = truckFrontPhotoKey;
    }

    public String getTruckBackPhotoKey() {
        return truckBackPhotoKey;
    }

    public void setTruckBackPhotoKey(String truckBackPhotoKey) {
        this.truckBackPhotoKey = truckBackPhotoKey;
    }

    public String getTruckSidePhotoKey() {
        return truckSidePhotoKey;
    }

    public void setTruckSidePhotoKey(String truckSidePhotoKey) {
        this.truckSidePhotoKey = truckSidePhotoKey;
    }

    public String getTruckRCFrontPhotoKey() {
        return truckRCFrontPhotoKey;
    }

    public void setTruckRCFrontPhotoKey(String truckRCFrontPhotoKey) {
        this.truckRCFrontPhotoKey = truckRCFrontPhotoKey;
    }

    public String getTruckRCBackPhotoKey() {
        return truckRCBackPhotoKey;
    }

    public void setTruckRCBackPhotoKey(String truckRCBackPhotoKey) {
        this.truckRCBackPhotoKey = truckRCBackPhotoKey;
    }

    public String getTruckRCSidePhotoKey() {
        return truckRCSidePhotoKey;
    }

    public void setTruckRCSidePhotoKey(String truckRCSidePhotoKey) {
        this.truckRCSidePhotoKey = truckRCSidePhotoKey;
    }

    public String getPanNumber() {
        return panNumber;
    }

    public void setPanNumber(String panNumber) {
        this.panNumber = panNumber;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(String aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getTruckNumber() {
        return truckNumber;
    }

    public void setTruckNumber(String truckNumber) {
        this.truckNumber = truckNumber;
    }

    public String getTruckRCNumber() {
        return truckRCNumber;
    }

    public void setTruckRCNumber(String truckRCNumber) {
        this.truckRCNumber = truckRCNumber;
    }

    public class PhoneType {

        @SerializedName("label")
        @Expose
        private String label;
        @SerializedName("value")
        @Expose
        private String value;

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

    }
}