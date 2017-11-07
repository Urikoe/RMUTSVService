package app.urikoemobile.kanchana.rmutsvservice.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.urikoemobile.kanchana.rmutsvservice.R;

/**
 * Created by Urikoe on 11/6/2017.
 */

public class MainFragment extends Fragment {

//Manager Worker after onCreateView Success
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        //Register COntroller

        registerCOntroller();
    }//Main Method

    private void registerCOntroller() {
        TextView textView = getView().findViewById(R.id.txtRegister);
        textView .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragement_main, container, false);
        return view;
    }
}//Main Class
