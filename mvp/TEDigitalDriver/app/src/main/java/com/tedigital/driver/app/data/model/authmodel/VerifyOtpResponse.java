package com.tedigital.driver.app.data.model.authmodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Kamlesh Yadav on 14-07-2020.
 * Eighteen Pixels India Private Limited Lucknow U.P
 * kamlesh@18pixels.com
 */
public class VerifyOtpResponse {

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

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

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
    private Object address;
    @SerializedName("maritalStatus")
    @Expose
    private String maritalStatus;
    @SerializedName("policyInsuranceNumber")
    @Expose
    private Object policyInsuranceNumber;
    @SerializedName("insuranceValidityDate")
    @Expose
    private Object insuranceValidityDate;
    @SerializedName("aadharCardKey")
    @Expose
    private Object aadharCardKey;
    @SerializedName("licenseKey")
    @Expose
    private Object licenseKey;
    @SerializedName("panNumberKey")
    @Expose
    private Object panNumberKey;
    @SerializedName("truckFrontPhotoKey")
    @Expose
    private Object truckFrontPhotoKey;
    @SerializedName("truckBackPhotoKey")
    @Expose
    private Object truckBackPhotoKey;
    @SerializedName("truckSidePhotoKey")
    @Expose
    private Object truckSidePhotoKey;
    @SerializedName("truckRCFrontPhotoKey")
    @Expose
    private Object truckRCFrontPhotoKey;
    @SerializedName("truckRCBackPhotoKey")
    @Expose
    private Object truckRCBackPhotoKey;
    @SerializedName("truckRCSidePhotoKey")
    @Expose
    private Object truckRCSidePhotoKey;
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

    public String getSelfieWithTruckKey() {
        return selfieWithTruckKey;
    }

    public void setSelfieWithTruckKey(String selfieWithTruckKey) {
        this.selfieWithTruckKey = selfieWithTruckKey;
    }

    @SerializedName("selfieWithTruckKey")
    @Expose
    private String selfieWithTruckKey;

    public String getDriverProfileImageKey() {
        return driverProfileImageKey;
    }

    public void setDriverProfileImageKey(String driverProfileImageKey) {
        this.driverProfileImageKey = driverProfileImageKey;
    }

    @SerializedName("driverProfileImageKey")
    @Expose
    private String driverProfileImageKey;

    public String getSpecialLicencekey() {
        return specialLicencekey;
    }

    public void setSpecialLicencekey(String specialLicencekey) {
        this.specialLicencekey = specialLicencekey;
    }

    @SerializedName("specialLicencekey")
    @Expose
    private String specialLicencekey;

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

    public Object getAddress() {
        return address;
    }

    public void setAddress(Object address) {
        this.address = address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Object getPolicyInsuranceNumber() {
        return policyInsuranceNumber;
    }

    public void setPolicyInsuranceNumber(Object policyInsuranceNumber) {
        this.policyInsuranceNumber = policyInsuranceNumber;
    }

    public Object getInsuranceValidityDate() {
        return insuranceValidityDate;
    }

    public void setInsuranceValidityDate(Object insuranceValidityDate) {
        this.insuranceValidityDate = insuranceValidityDate;
    }

    public Object getAadharCardKey() {
        return aadharCardKey;
    }

    public void setAadharCardKey(Object aadharCardKey) {
        this.aadharCardKey = aadharCardKey;
    }

    public Object getLicenseKey() {
        return licenseKey;
    }

    public void setLicenseKey(Object licenseKey) {
        this.licenseKey = licenseKey;
    }

    public Object getPanNumberKey() {
        return panNumberKey;
    }

    public void setPanNumberKey(Object panNumberKey) {
        this.panNumberKey = panNumberKey;
    }

    public Object getTruckFrontPhotoKey() {
        return truckFrontPhotoKey;
    }

    public void setTruckFrontPhotoKey(Object truckFrontPhotoKey) {
        this.truckFrontPhotoKey = truckFrontPhotoKey;
    }

    public Object getTruckBackPhotoKey() {
        return truckBackPhotoKey;
    }

    public void setTruckBackPhotoKey(Object truckBackPhotoKey) {
        this.truckBackPhotoKey = truckBackPhotoKey;
    }

    public Object getTruckSidePhotoKey() {
        return truckSidePhotoKey;
    }

    public void setTruckSidePhotoKey(Object truckSidePhotoKey) {
        this.truckSidePhotoKey = truckSidePhotoKey;
    }

    public Object getTruckRCFrontPhotoKey() {
        return truckRCFrontPhotoKey;
    }

    public void setTruckRCFrontPhotoKey(Object truckRCFrontPhotoKey) {
        this.truckRCFrontPhotoKey = truckRCFrontPhotoKey;
    }

    public Object getTruckRCBackPhotoKey() {
        return truckRCBackPhotoKey;
    }

    public void setTruckRCBackPhotoKey(Object truckRCBackPhotoKey) {
        this.truckRCBackPhotoKey = truckRCBackPhotoKey;
    }

    public Object getTruckRCSidePhotoKey() {
        return truckRCSidePhotoKey;
    }

    public void setTruckRCSidePhotoKey(Object truckRCSidePhotoKey) {
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