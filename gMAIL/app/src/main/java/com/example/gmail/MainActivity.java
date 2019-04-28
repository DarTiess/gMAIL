package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public  boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        TextView headerView=(TextView)findViewById(R.id.header);
        Intent intent;
        switch (id){
            case R.id.forBuissness:
                headerView.setText("Для бизнеса");
                return true;
            case R.id.Enter:
                intent = new Intent(this, EnterActivity.class);
                startActivity(intent);
                return true;
            case R.id.CreateNew:
                intent = new Intent(this, CreateActivity.class);
                startActivity(intent);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onClickButt(View view) {
    }
}
