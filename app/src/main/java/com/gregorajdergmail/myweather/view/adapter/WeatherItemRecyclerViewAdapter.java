package com.gregorajdergmail.myweather.view.adapter;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gregorajdergmail.myweather.R;
import com.gregorajdergmail.myweather.databinding.ForecastListItemBinding;
import com.gregorajdergmail.myweather.presenter.viewObject.ForecastItemVO;
import com.gregorajdergmail.myweather.view.ForecastListFragment.OnListFragmentInteractionListener;

import java.util.List;


public class WeatherItemRecyclerViewAdapter extends RecyclerView.Adapter<WeatherItemRecyclerViewAdapter.ViewHolder> {

    private List<ForecastItemVO> mValues ;
    private final OnListFragmentInteractionListener mListener;

    public WeatherItemRecyclerViewAdapter(List<ForecastItemVO> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.forecast_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        ForecastItemVO item = mValues.get(position);
        holder.binding.setListItem(item);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ForecastListItemBinding binding;

        public ViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
