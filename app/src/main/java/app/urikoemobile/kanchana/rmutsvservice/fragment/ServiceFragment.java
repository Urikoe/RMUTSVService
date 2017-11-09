package app.urikoemobile.kanchana.rmutsvservice.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toolbar;

import app.urikoemobile.kanchana.rmutsvservice.MyServiceActivity;
import app.urikoemobile.kanchana.rmutsvservice.R;

/**
 * Created by Urikoe on 11/9/2017.
 */

public class ServiceFragment extends Fragment{

    public static ServiceFragment serviceInstance(String[] strings) {

        ServiceFragment serviceFragment = new ServiceFragment();
        Bundle bundle = new Bundle();
        bundle.putStringArray("Login",strings);
        serviceFragment.setArguments(bundle);

        return serviceFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        //รับค่าจาก MainFragement ส่งไปที่ ServiceFragement
        String[] strings = getArguments().getStringArray("Login");
        Log.d("9novV1", "Login(1) On ServiceFragment ==>" + strings[1]);

//        Create Toolbar  (strings[1]) อากิวเมน
        createToolbar(strings[1]);

    }

    private void createToolbar(String strTitle) {
        android.support.v7.widget.Toolbar toolbar = getView().findViewById(R.id.toolbarService);
        ((MyServiceActivity)getActivity()).setSupportActionBar(toolbar);
        ((MyServiceActivity) getActivity()).getSupportActionBar().setTitle(strTitle);
        ((MyServiceActivity) getActivity()).getSupportActionBar().setSubtitle("Who Loged");


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_service, container, false);
        return view;


    }
}
