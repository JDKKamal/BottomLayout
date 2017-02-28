package com.jdkgroup.bottomlayout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jdkgroup.bottomlayoutsearch.Adapter.ActivityBottomLayoutSearch;
import com.jdkgroup.bottomlayoutsimple.ActivityBottomLayoutSimple;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tvBottomLayoutSimple, tvBottomLayoutSearch;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBottomLayoutSimple = (TextView) findViewById(R.id.tvBottomLayoutSimple);
        tvBottomLayoutSearch = (TextView) findViewById(R.id.tvBottomLayoutSearch);

        tvBottomLayoutSimple.setOnClickListener(this);
        tvBottomLayoutSearch.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvBottomLayoutSimple:
                intent = new Intent(getApplicationContext(), ActivityBottomLayoutSimple.class);
                startActivity(intent);
                break;

            case R.id.tvBottomLayoutSearch:
                intent = new Intent(getApplicationContext(), ActivityBottomLayoutSearch.class);
                startActivity(intent);
                break;
        }
    }
}

