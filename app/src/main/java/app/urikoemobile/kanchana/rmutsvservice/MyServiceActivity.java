package app.urikoemobile.kanchana.rmutsvservice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import app.urikoemobile.kanchana.rmutsvservice.fragment.ServiceFragment;

public class MyServiceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

//        Add Fragement
        if (savedInstanceState==null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contentServiceFragment, new ServiceFragment());

        }

    }//Main Method
}//Main Class
