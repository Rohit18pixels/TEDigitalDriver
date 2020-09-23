package com.jobportalemployer.asizone.presenter.utils;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class Constants {

    public static final SimpleDateFormat dateFormatter             = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
    public static final SimpleDateFormat dateFormatterYear             = new SimpleDateFormat("yyyy/MM/dd", Locale.US);

    public static final String LOGIN_ONETIME = "login_one" ;
    public static final String TOKEN = "token" ;
    public static final String ISLOGIN = "islogin" ;
    public static final String USER_ID="user_id";
    public static final String DEVICEID="deviceid";
    public static final String GUEST_ID="auth_id";
    public static final String USER_NAME="user_name";
    public static final String USER_MOBILE="user_mobile";
    public static final String USER_PASSWORD="user_pass";
    public static final String USER_EMAIL="user_email";
    public static final String USER_WALLET="user_wallet";
    public static final String USER_ROLE="user_role";
    public static final String USER_TOKEN="user_token";
    public static final String USER_REFERALCODE="user_ref_code";
    public static final String USER_ETAKAID="user_etakaid";
    public static final String USER_PROFILE_IMAGE="user_profile";
    public static final String QRCODE="qrcode";
    public static final String APP_PACKAGENAME="package";
    public static final String CompanyName="cname";
    public static final String EID = "eid";

    public static final String LANG_ID="lang_id";
    public static final String CountryId="countryId";
    public static final String PinCode="pincode";

    /*TODO
    SEEKBAR VALUES
    */
    public static final String SeekBarMin="minprice";
    public static final String SeekBarMax="maxprice";


    public static final String Pos="Pos";



    public static final String RAD_FM_NAME="RAD_FM_NAME";
    public static final String RAD_CHNL_NAME="RAD_CHNL_NAME";
    public static final String RAD_IMG_URL="RAD_IMG_URL";
    public static final String RAD_STREAM_URL="RAD_STREAM_URL";



    /*TODO
    HOTEL CONSTANTS VALUE
    * */
    public static final String DATEFORMAT_HOTEL = "EEE, dd MMM yy";
    public static final String SERVERDATEFORMAT_HOTEL = "dd/MM/yyyy";

    public static final String TOTALNIGHTS = "totalnights";

    public static final String CHECKIN_DATE = "checkIn";
    public static final String CHECKOUT_DATE = "checkOut";

    public static final String SENDDATE_CHECKIN = "senddatecheckIn";
    public static final String SENDDATE_CHECKOUT = "senddatecheckOut";

    public static final String SEARCH_CITY="cityName";
    public static final String SEARCH_CITY_CATID="catId";
    public static final String SEARCHCOUNTRY="countryName";
    public static final String SEARCHCOUNTRYID="countryId";


    public static final String ROOMCOUNT="roomcount";
    public static final String CHILDCOUNT="childcount";
    public static final String ADULTCOUNT="adultcount";



}
