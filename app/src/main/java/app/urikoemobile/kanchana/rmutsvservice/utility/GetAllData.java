package app.urikoemobile.kanchana.rmutsvservice.utility;

import android.content.Context;
import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

/**
 * Created by Urikoe on 11/8/2017.
 */

public class GetAllData extends AsyncTask<String,Void,String>{ // กด Alt+Enter ได้ protected ด้านล่าง

    private Context context;  //กด Alt+Insert จะได้ด้านล่าง

    public GetAllData(Context context) {
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        try {
            OkHttpClient okHttpClient = new OkHttpClient();
            Request.Builder builder = new Request.Builder();
            Request request = builder.url(strings[0]).build();
            Response response = okHttpClient.newCall(request).execute();
            return response.body().string();

        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }


    }
}// Main Class
