package com.example.listviewdemo;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class LV_Activity extends AppCompatActivity {
    EditText edtCom;
    Button btnAdd;
    ListView lvCom;

   // String [] lsCom = new String[]{"Google","Tesla", "Meta","VNG","FPT","TGDĐ","Apple"};
    ArrayList<String> arrayListCom = new ArrayList<>();
    ArrayAdapter<String> adapter;
    //------------------
    ListView lvTC;
    ArrayList<TraiCay> arrayListTC=new ArrayList<>();
    CustomAdapterTC adapterTC;

    int[]lsHinhAnh = new int[]{R.drawable.apple, R.drawable.pineapple, R.drawable.mango,R.drawable.litchi,R.drawable.banana};
    String[]lsTen=new String[]{"Táo","Thơm","Xoài", "Dau","Chuối"};
    int[]lsGia=new int[]{100,20,50,80,15};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lv);
        Intent intent =getIntent();
        addControls();
        addEvents();
        //Hiển thị dữ liệu lên LV
        String[] temp=getResources().getStringArray(R.array.list_company);
        Collections.addAll(arrayListCom, temp);

         adapter = new ArrayAdapter<String>(LV_Activity.this,
                android.R.layout.simple_spinner_dropdown_item,arrayListCom);
        lvCom.setAdapter(adapter);
        //=======================================
       arrayListTC=TraiCay.initArrayListTraiCay(lsHinhAnh,lsTen,lsGia);
       adapterTC=new CustomAdapterTC(LV_Activity.this,R.layout.layout_item_traicay,arrayListTC);
       lvTC.setAdapter(adapterTC);
    }
    private  void addControls()
    {
        edtCom=(EditText) findViewById(R.id.edtCom);
        btnAdd=(Button) findViewById(R.id.btnAdd);
        lvCom=(ListView) findViewById(R.id.lvCom);
        lvTC=(ListView) findViewById(R.id.lvTraiCay);
    }
    private  void addEvents()
    {
        //Click chọn từng item và lấy giá trị của item đó
        lvCom.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(LV_Activity.this,"Giá trị được chọn là: " + arrayListCom.get(position),
                        Toast.LENGTH_SHORT).show();
            }
        });
        //Thêm phần tử vào LV
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st=edtCom.getText().toString();
                arrayListCom.add(0,st);
                adapter.notifyDataSetChanged();
            }
        });

        //Xoá item trong LV bằng sự kiện long-click trên item đó
        lvCom.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog alertDialog=createAlertDialog(position,adapter);
                alertDialog.show();
                return false;
            }
        });
    }
    private AlertDialog createAlertDialog (int position, ArrayAdapter<String>adapter)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(LV_Activity.this);
        builder.setTitle("Delete item!");
        builder.setMessage("Are you sure you want to delete item?");
        //Xử lý nút Yes
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                arrayListCom.remove(position);
                adapter.notifyDataSetChanged();
            }
        });
        //Xử lý nút No
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        return  builder.create();
    }


}