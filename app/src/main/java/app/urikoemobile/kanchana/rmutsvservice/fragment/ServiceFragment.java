package app.urikoemobile.kanchana.rmutsvservice.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toolbar;

import org.json.JSONArray;
import org.json.JSONObject;

import app.urikoemobile.kanchana.rmutsvservice.MyServiceActivity;
import app.urikoemobile.kanchana.rmutsvservice.R;
import app.urikoemobile.kanchana.rmutsvservice.utility.GetAllData;
import app.urikoemobile.kanchana.rmutsvservice.utility.ListViewAdapter;
import app.urikoemobile.kanchana.rmutsvservice.utility.MyConstant;

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

//        Create ListView
        createListView();//สร้าง Auto Method โดยกด Ctrl+Alt+M
    }

    private void createListView() {
        ListView listView = getView().findViewById(R.id.livUser);
        MyConstant myConstant = new MyConstant();

        try {
            GetAllData getAllData = new GetAllData(getActivity());
            getAllData.execute(myConstant.getUrlGetAlluser());
            String resultJSON = getAllData.get();
            Log.d("9novV1", "JSON==>"+ resultJSON);

            JSONArray jsonArray = new JSONArray(resultJSON);

            //จองหน่วยความจำที่เป็น Array
            String[] nameStrings = new String[jsonArray.length()];
            String[] catStrings = new String[jsonArray.length()];
            String[] userStrings = new String[jsonArray.length()];
            String[] passwordStrings = new String[jsonArray.length()];

            //ใช้ for อ่านค่าตามจำนวน Record ของ Array
            for (int i=0; i<jsonArray.length(); i+=1) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                nameStrings[i] = jsonObject.getString("Name");
                catStrings[i] = jsonObject.getString("Category");
                userStrings[i] = jsonObject.getString("User");
                passwordStrings[i] = jsonObject.getString("Password");

            }//for
            //ให้ Adapter ทำการแสดงบน list view
            ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(),
                    nameStrings, catStrings, userStrings, passwordStrings);
                listView.setAdapter(listViewAdapter);

        } catch (Exception e) {
            e.printStackTrace(); // ถ้ามี Error ให้ทำการ PrintTrace Errorขึ้นมา
        }


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
