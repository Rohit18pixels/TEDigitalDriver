package com.tedigital.driver.app.support;

/**
 * Created by Kamlesh Yadav on 12-07-2020.
 * Eighteen Pixels India Private Limited Lucknow U.P
 * kamlesh@18pixels.com
 */
public class Constants {

    public static final String BASE_PATH = "https://pixstory-assets.s3.amazonaws.com/";
    public static final String KEY_DEFAULT_ACTIVITY_BUNDLE = "DEFAULT_ACTIVITY_BUNDLE";
    public static final String KEY_DEFAULT_ACTIVITY_INTENT = "DEFAULT_ACTIVITY_INTENT";
    public static final String KEY_DEFAULT_ACTIVITY_INTENT_INT = "DEFAULT_ACTIVITY_INTENT_INT";
    public static final int REQUEST_PERMISSIONS = 1240;
    public static final int REQUEST_MICROPHONE = 1245;


    public static final String USER_ID = "userId";
    public static final String SUPPLIER_FIRST_NAME = "SupplierFName";
    public static final String SUPPLIER_LAST_NAME = "SupplierLName";
    public static final String USERFRIENDLY_ID = "UserfriendlyId";
    public static final String COMPANY_NAME = "company_name";
    public static final String PROFILE = "profile";
    public static final String IS_LOGIN = "islogin";

    public static final String DRIVER_ID = "driver_id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";
    public static final String MOBILE_NUMBER = "mobile_number";
    public static final String EMAIL = "driver_email";

/*TODO SUPPLIER Registration &
   PROFILE UPDATE
*  */
//    SUPPLIER PROFILE

    public static final String SP_COMPANY_NAME = "sp_company_name";
    public static final String SP_COMPANY_TYPE = "sp_company_type";
    public static final String SP_INCORPORATION_DATE = "sp_date";
    public static final String SP_PARTNER_NAME = "sp_partner_name";
    public static final String SP_DESIGNATION = "sp_designation";
    public static final String SP_MOBILE_NUMBER = "sp_mobile_number";
    public static final String SP_EMAIL = "sp_email";
    public static final String SP_TURN_OVER = "sp_turn_over";
    public static final String IS_SP_DONE = "is_p_done";

       // SP ADDRESS DETAILS
    public static final String SPAD_HOUSE_NO = "spad_house_no";
    public static final String SPAD_COLONY = "spad_colony";
    public static final String SPAD_CITY = "spad_city";
    public static final String SPAD_STATE = "spad_state";
    public static final String SPAD_PINCODE = "spad_pincode";
    public static final String IS_SPAD_DONE = "is_spad_done";

    // SP COMPANY KYC
    public static final String SPCK_PAN_NO = "spck_panno";
    public static final String SPCK_GST_NO = "spck_gstno";
    public static final String SPCK_REG_COPY = "spck_regCopy";
    public static final String IS_SPCK_DONE = "spck_done";

    // ADD USER
    public static final String FIRST_NAME2 = "first_name2";
    public static final String LAST_NAME2 = "last_name2";
    public static final String UserDesignation2 = "user_designation";
    public static final String EMAILID2 = "emailID2";
    public static final String MOBILE2 = "mobile2";

    //FLEET DETAILS

    public static final String FD_OWNTRUCK = "owntruck";
    public static final String FD_ATTACHTRUCK = "attachtruck";
    public static final String FD_TOTALTRUCK = "fd_totaltruck";
    public static final String FD_FASTTAGTRUCK = "fd_fasttagtruck";
    public static final String FD_GPSTAGTRUCK = "fd_gpstagtruck";
    public static final String FD_FUELCARD = "fd_fuelcard";


    public static final String TD_TRUCKDEPLOY_MODEL = "td_truckdeploymodel";
    public static final String TD_MARKETLOAD = "Market Load";
    public static final String TD_CONTACT = "Contact";
    public static final String TD_BOTH= "Both";


    //TRUCK DETAILS
    public static final String TD_TRUCKNumber = "td_trucknumber";
    public static final String TD_OWNERNAME = "td_ownername";
    public static final String TD_TRUCKTYPE = "td_trucktype";
    public static final String TD_MODELNUMBER = "td_modelnumber";
    public static final String TD_REGISTRATIONDATE = "td_regdate";
    public static final String TD_INSURANCEPOLICYNUMBER = "td_insurance_policy_number";
    public static final String TD_INSURANCEPOLICYDATE = "td_insurance_policy_date";
    public static final String TD_FCVALIDITYDATE = "td_FC_date";
    public static final String TD_POCVALIDITYDATE = "td_poc_date";

    //FLEET DETAILS DRIVER DETAILS
    public static final String FDDD_yearExp = "fddd_yoe";
    public static final String FDDD_NAME = "fddd_name";
    public static final String FDDD_DLNUMBER = "fddd_dlnumber";
    public static final String FDDD_DOB = "fddd_dob";
    public static final String FDDD_LICENSEVALIDITY = "fddd_licencsevalidity";
    public static final String FDDD_MOBILENUMBER = "fddd_mobile";
    public static final String FDDD_PHONETYPE = "fddd_phonetype";
    public static final String FDDD_LANGUAGETYPE = "fddd_languagetype";
    public static final String FDDD_BLOODGROUP = "fddd_bloodgroup";
    public static final String FDDD_LFVC = "fddd_lfvc";
    public static final String FDDD_SPECIALLICENSE = "fddd_sl";
    public static final String isFDDD_Done = "isFddddone";


    //DRIVER PROFILE

    //UPDATE PROFILE

    public static final String DUP_DOB = "dup_dob";
    public static final String DUP_BLOODGROUP = "dup_bloodGroup";
    public static final String DUP_ADDRESS = "dup_address";
    public static final String DUP_DRIVINGLICENSE = "dup_drivingLicense";
    public static final String DUP_DRIVINGLICENSEVALIDITY = "dup_dvaliditydrivingLicense";
    public static final String DUP_DRIVEREXPERIENCE = "dup_driverexperience";
    public static final String DUP_VEHICLELICENSETYPE = "dup_vehicleLicensetype";
    public static final String DUP_SPECIALLICENSE = "dup_specialLicense";
    public static final String DUP_SPECIALLICENSE_KEY = "dup_specialLicense_key";
    public static final String DUP_INSURANCEPOLICY = "dup_policyinsurace";
    public static final String DUP_INSURANCEPOLICYVALIDTY = "dup_policyinsuraceValidity";
    public static final String DUP_MOBILENUMBER = "dup_mobileNumber";
    public static final String DUP_DRIVERNAME = "dup_driverName";
    public static final String DUP_PHONETYPE= "dup_phoneType";
    public static final String DUP_LANGUAGES_KNOWN= "lan_known";
    public static final String DUP_MARITIAL_STATUS= "maritial_status";
    public static final String DUP_MARITIAL_STATUS_VALUE= "maritial_status_value";
    public static final String DUP_LAN_HINDI= "lan_hindi";
    public static final String DUP_LAN_ENGLISH= "lan_english";

    public static final String DUP_LAN_ENGLISH_bool = "boolEng";
    public static final String DUP_LAN_HINDI_bool= "boolHindi";
    //KYC

    public static final String DKYC_PANNUMBER = "dkyc_pan_number";
    public static final String DKYC_AADHARNUMBER = "dkyc_aadhar_number";
    public static final String DKYC_LICENSENUMBER = "dkyc_license_number";
    public static final String DKYC_TRUCKNUMBER = "dkyc_truck_number";
    public static final String DKYC_RCNUMBER = "dkyc_rc_number";

    public static final String DKYC_PAN = "dkyc_pan";
    public static final String DKYC_AADHARFRONT = "dkyc_aadhar_front";
    public static final String DKYC_AADHATBACK = "dkyc_aadhar_back";
    public static final String DKYC_LICENSEFRONT = "dkyc_license_front";
    public static final String DKYC_LICENSEBACK = "dkyc_license_back";
    public static final String DKYC_TRUCKFRONT = "dkyc_truck_front";
    public static final String DKYC_TRUCKSIDE = "dkyc_truck_side";
    public static final String DKYC_TRUCKBACK = "dkyc_truck_back";
    public static final String DKYC_RC = "dkyc_rc";
    public static final String DKYC_SELFIETRUCK = "dkyc_selfie_truck";
    public static final String DKYC_DRIVER_PROFILE_IMAGE = "dkyc_driver_profile_image";

}
