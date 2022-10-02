package com.example.menudemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        TextView tv = findViewById(R.id.textView);
//        registerForContextMenu(tv);

//        Button bt_chon = findViewById(R.id.button_dialog);
//        bt_chon.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//            }
//        });

    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Mời bạn chọn con hàng:");
        menu.add(0, v.getId(), 0, "Thùy Dương");
        menu.add(0, v.getId(), 0, "Thảo Nhi");
        menu.add(0, v.getId(), 0, "Ny Vy");
        menu.add(0, v.getId(), 0, "Minh Anh");
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        Toast.makeText(this, "Bằng Nguyễn đã chọn con hàng tên làaaaa: " + item.getTitle(), Toast.LENGTH_SHORT).show();
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int listPosition = info.position;

        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menubar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mnInput:
                Intent intent1 = new Intent(MainActivity.this, InputActivity.class);
                startActivity(intent1);
                return true;
            case R.id.mnSearch:
                Intent intent2 = new Intent(MainActivity.this, SearchActivity.class);
                startActivity(intent2);
                return true;
            case R.id.mnExit:
                finish();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}