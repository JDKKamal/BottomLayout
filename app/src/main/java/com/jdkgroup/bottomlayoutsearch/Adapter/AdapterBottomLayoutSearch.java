package com.jdkgroup.bottomlayoutsearch.Adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jdkgroup.bottomlayout.R;
import com.jdkgroup.bottomlayoutsearch.Adapter.model.ModelProduct;

import java.util.List;

public class AdapterBottomLayoutSearch extends RecyclerView.Adapter<AdapterBottomLayoutSearch.ViewHolder> {

    private List<ModelProduct> alAttributeValue;
    private ItemListener itemListener;
    private Activity activity;

    public AdapterBottomLayoutSearch(Activity activity, List<ModelProduct> alAttributeValue, ItemListener itemListener) {
        this.alAttributeValue = alAttributeValue;
        this.itemListener = itemListener;
        this.activity = activity;
    }

    public void setListener(ItemListener listener) {
        itemListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_bottom_layout_search, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setData(alAttributeValue.get(position));
    }

    @Override
    public int getItemCount() {
        return alAttributeValue.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView tvProductName;
        public ModelProduct attributeValue;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            tvProductName = (TextView) itemView.findViewById(R.id.tvProductName);
        }

        public void setData(ModelProduct attributeValue) {
            this.attributeValue = attributeValue;
            tvProductName.setText(attributeValue.getProductName());
        }

        @Override
        public void onClick(View v) {
            if (itemListener != null) {
                itemListener.onItemClick(attributeValue);
            }
        }
    }

    public interface ItemListener {
        void onItemClick(ModelProduct item);
    }
}
