package com.gquasar.galgotiasunifest2017;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class Fragment_AboutUs extends Fragment {

    View mainView;
    Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainView=inflater.inflate(R.layout.fragment_fragment__about_us,container,false);
        context = mainView.getContext();

        return mainView;
    }

}
