package com.jdkgroup.bottomlayoutsimple;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.jdkgroup.bottomlayout.R;

import java.util.ArrayList;
import java.util.List;

public class ActivityBottomLayoutSimple extends AppCompatActivity implements AdapterBottomLayoutSimple.ItemListener {

    private Button btnDialog;
    BottomSheetBehavior behavior;
    private BottomSheetDialog mBottomSheetDialog;
    private AdapterBottomLayoutSimple mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_layout_simple);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.va_back);

        btnDialog = (Button) findViewById(R.id.btnDialog);

        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBottomSheetDialog();
            }
        });

        View bottomSheet = findViewById(R.id.bottom_sheet);
        behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // React to state change
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // React to dragging events
            }
        });
    }


    private void showBottomSheetDialog() {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }

        mBottomSheetDialog = new BottomSheetDialog(this);
        View view = getLayoutInflater().inflate(R.layout.custom_bottom_layout, null);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new AdapterBottomLayoutSimple(createItems(), new AdapterBottomLayoutSimple.ItemListener() {
            @Override
            public void onItemClick(ModelMenu item) {
                if (mBottomSheetDialog != null) {
                    mBottomSheetDialog.dismiss();
                }
            }
        }));

        mBottomSheetDialog.setContentView(view);
        mBottomSheetDialog.show();
        mBottomSheetDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mBottomSheetDialog = null;
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    public List<ModelMenu> createItems() {

        ArrayList<ModelMenu> items = new ArrayList<>();
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 1"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 2"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 3"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 4"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 1"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 2"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 3"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 4"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 1"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 2"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 3"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 4"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 1"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 2"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 3"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 4"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 1"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 2"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 3"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 4"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 1"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 2"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 3"));
        items.add(new ModelMenu(R.mipmap.ic_launcher, "Item 4"));
        return items;
    }

    @Override
    public void onItemClick(ModelMenu item) {
        behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
