package app.urikoemobile.kanchana.rmutsvservice.utility;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import app.urikoemobile.kanchana.rmutsvservice.R;

/**
 * Created by Urikoe on 11/9/2017.
 */

public class ListViewAdapter extends BaseAdapter { //กด Alt+Enter เพื่อสร้าง Method ด้านล่าง

    private Context context;
    private String[] nameString, catString, userString, passString; //สร้างตัวแปร 4 ตัว แล้วกด Alt+Insert เพื่อสร้าง Construtor

    public ListViewAdapter(Context context,
                           String[] nameString,
                           String[] catString,
                           String[] userString,
                           String[] passString) {

        this.context = context;
        this.nameString = nameString;
        this.catString = catString;
        this.userString = userString;
        this.passString = passString;
    }

    @Override
    public int getCount() {
        return nameString.length;// สร้าง Listview ทั้งหมดว่ามีกี่อัน return 20;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.layout_listview, viewGroup, false); //การสร้าง view

        //ทำ Duplicate กด Ctrl+D
        //เรียง Code ให้สวย  Drak ทั้งบรรทัด แล้วกด Ctrl+Alt+L
        TextView nameTextView = view1.findViewById(R.id.txtName);
        TextView catTextView = view1.findViewById(R.id.txtCategory);
        TextView userTextView = view1.findViewById(R.id.txtUser);
        TextView passTextView = view1.findViewById(R.id.txtPassword);

        //setText คือการกำหนดตค่าให้กับTextView
        nameTextView.setText(nameString[i]);
        catTextView.setText(catString[i]);
        userTextView.setText(userString[i]);
        passTextView.setText(passString[i]);

        return view1;
    }
}//Main Class

