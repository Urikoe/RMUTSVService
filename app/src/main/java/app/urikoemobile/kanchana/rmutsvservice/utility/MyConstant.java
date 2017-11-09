package app.urikoemobile.kanchana.rmutsvservice.utility;

/**
 * Created by Urikoe on 11/8/2017.
 */

public class MyConstant {
    private String urlPostData = "http://androidthai.in.th/rmuts/addDataMaster.php";
    private String urlGetAlluser = "http://androidthai.in.th/rmuts/getAllDataMaster.php";
    private String urlDeleteData = "http://androidthai.in.th/rmuts/deleteDataMaster.php";

    public String getUrlGetAlluser() {
        return urlGetAlluser;
    }

    public String getUrlPostData (){
        return urlPostData;

    }

    public String getUrlDeleteData() {
        return urlDeleteData;
    }

    public void setUrlDeleteData(String urlDeleteData) {
        this.urlDeleteData = urlDeleteData;
    }
}//Main Class
