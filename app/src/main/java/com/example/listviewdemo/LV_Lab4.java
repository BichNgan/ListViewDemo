package com.example.listviewdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class LV_Lab4 extends AppCompatActivity {

    EditText edtName;
    TextView tvItem;
    Button btnThem;
    ListView lvTenSV;
    ArrayList<String>lsName = new ArrayList<>();
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv_lab4);
        addControl();
        //------------------------
        //Gắn dữ liệu vào LV và hiển thị trên màn hình

        lsName.addAll(Arrays.asList(new String[]{"Ngân", "Hoa", "Lý", "Lan"}));
        lsName.add("Thanh");

        adapter = new ArrayAdapter<>(getApplicationContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,lsName);
        lvTenSV.setAdapter(adapter);
        //----------------------
        addEvent();

    }

    void addControl()
    {
        edtName=(EditText) findViewById(R.id.edtName);
        tvItem=(TextView) findViewById(R.id.tvItem);
        btnThem = (Button) findViewById(R.id.btnThem);
        lvTenSV = (ListView) findViewById(R.id.lvTenSV);
    }
    void addEvent()
    {
        //2/Chọn 1 item thì nó sẽ lấy thông tin của item đó
        lvTenSV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tvItem.setText(lsName.get(position));
            }
        });

        //3/Xóa 1 item
        lvTenSV.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog=createAlertDialog(position,adapter);
                alertDialog.show();

                return false;
            }
        });

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lsName.add(edtName.getText().toString());
                adapter.notifyDataSetChanged();//báo cho adapter biết dữ liệu có thay đổi, nó phải update lại lv
            }
        });

    }
    private AlertDialog createAlertDialog (int position, ArrayAdapter<String>adapter)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(LV_Lab4.this);
        builder.setTitle("Delete item!");
        builder.setMessage("Are you sure you want to delete item?");
        //Xử lý nút Yes
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                lsName.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        //Xử lý nút No
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which)
            {
                dialog.cancel();
            }
        });
        return  builder.create();
    }
}