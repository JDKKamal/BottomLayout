package com.jdkgroup.bottomlayoutsearch.Adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.jdkgroup.bottomlayout.R;
import com.jdkgroup.bottomlayoutsearch.Adapter.model.ModelProduct;

import java.util.ArrayList;
import java.util.List;

public class ActivityBottomLayoutSearch extends AppCompatActivity implements AdapterBottomLayoutSearch.ItemListener {

    private Button btnDialog;
    private BottomSheetBehavior behavior;
    private BottomSheetDialog mBottomSheetDialog;

    private Activity activity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_layout_simple);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.va_back);

        activity = this;

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
        View view = getLayoutInflater().inflate(R.layout.custom_bottom_layout_search, null);
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        final EditText edtSearch = (EditText) view.findViewById(R.id.edtSearch);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(new AdapterBottomLayoutSearch(activity, createItems(), new AdapterBottomLayoutSearch.ItemListener() {
            @Override
            public void onItemClick(ModelProduct product) {
                if (mBottomSheetDialog != null) {
                    Toast.makeText(activity, product.getProductName(), Toast.LENGTH_SHORT).show();
                    mBottomSheetDialog.dismiss();
                }
            }
        }));

        edtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence cs, int arg1, int arg2, int arg3) {
                final List<ModelProduct> filteredList = new ArrayList<>();
                for (int i = 0; i < createItems().size(); i++) {
                    final String text = createItems().get(i).getProductName().toLowerCase();
                    if (text.contains(cs.toString())) {
                        filteredList.add(createItems().get(i));
                    }
                }
                recyclerView.setAdapter(new AdapterBottomLayoutSearch(activity, filteredList, new AdapterBottomLayoutSearch.ItemListener() {
                    @Override
                    public void onItemClick(ModelProduct product) {
                        if (mBottomSheetDialog != null) {
                            Toast.makeText(activity, product.getProductName(), Toast.LENGTH_SHORT).show();
                            mBottomSheetDialog.dismiss();
                        }
                    }
                }));
            }

            @Override
            public void beforeTextChanged(CharSequence cs, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable arg0) {
            }
        });

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

    public List<ModelProduct> createItems() {

        ArrayList<ModelProduct> items = new ArrayList<>();
        items.add(new ModelProduct(1, "Item 1"));
        items.add(new ModelProduct(2, "Item 2"));
        items.add(new ModelProduct(3, "Item 3"));
        items.add(new ModelProduct(4, "Item 4"));
        items.add(new ModelProduct(4, "Item 5"));

        return items;
    }

    @Override
    public void onItemClick(ModelProduct item) {
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
