package com.gregorajdergmail.myweather.view;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gregorajdergmail.myweather.App;
import com.gregorajdergmail.myweather.R;
import com.gregorajdergmail.myweather.databinding.FragmentForecastListBinding;
import com.gregorajdergmail.myweather.presenter.viewObject.ForecastItemVO;
import com.gregorajdergmail.myweather.presenter.viewObject.ForecastVO;
import com.gregorajdergmail.myweather.util.Log;
import com.gregorajdergmail.myweather.view.adapter.WeatherItemRecyclerViewAdapter;

import javax.inject.Inject;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class ForecastListFragment extends Fragment {

    private static final String ARG_COLUMN_COUNT = "column-count";
    @Inject
    protected ForecastVO forecastVO;

    private OnListFragmentInteractionListener mListener;
    private LinearLayoutManager mLayoutManager;
    private WeatherItemRecyclerViewAdapter weatherItemRecyclerViewAdapter;


    public ForecastListFragment() {
    }


    public static ForecastListFragment newInstance(int columnCount) {
        ForecastListFragment fragment = new ForecastListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            int mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
        Log.d();
        App.getComponent().inject(this);
        forecastVO.onAttach();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentForecastListBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_forecast_list, container, false);
        View view = binding.getRoot();
        binding.setViewObject(forecastVO);

        if (forecastVO != null && forecastVO.getList() != null && forecastVO.getList().size() > 0) {
            RecyclerView mRecyclerView = (RecyclerView) view.findViewById(R.id.fragment_films_in_theatre_recycler);
            mRecyclerView.setNestedScrollingEnabled(false);
            mRecyclerView.setAdapter(new WeatherItemRecyclerViewAdapter(forecastVO.getList(), mListener));
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

//        if (context instanceof OnListFragmentInteractionListener) {
//            mListener = (OnListFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnListFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(ForecastItemVO item);
    }
}
