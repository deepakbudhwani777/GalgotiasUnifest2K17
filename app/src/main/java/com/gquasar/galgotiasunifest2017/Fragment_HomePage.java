package com.gquasar.galgotiasunifest2017;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Fragment_HomePage extends Fragment {

    CustomAdapter customAdapter;
    ViewPager viewPager;
    public static final String[] TITLES= {"\nEVENTS\n","\nGALLERY\n","\nREGISTER\n","\nCONTACTS\n","\nABOUT\n","\nDEVELOPERS\n"};
    public static final Integer[] IMAGES= {R.drawable.pic1,R.drawable.pic3,R.drawable.pic4,R.drawable.pic1,R.drawable.pic5,R.drawable.pic3};
    private RecyclerView recyclerView;
    View mainView;
    private Context context;
    public Fragment_HomePage() {}

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        mainView=inflater.inflate(R.layout.fragment_fragment__home_page,container,false);
        context = mainView.getContext();

        recyclerView = (RecyclerView)mainView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false));
        populatRecyclerView();
        populateViewPager(context,mainView);
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(context, recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
                    @Override public void onItemClick(View view, int position) {
                        if(position==0)
                        {
                            Intent intent=new Intent(context,Activity_Events.class);
                            startActivity(intent);
                            getActivity().finish();
                        }
                        if(position==1)
                        {
                            Intent intent=new Intent(context,Activity_Gallery.class);
                            startActivity(intent);
                        }
                        if(position==2)
                        {
                            Fragment fr=new Fragment_Register();
                            FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                            fc.replaceFragment(fr,"Register");
                        }
                        if(position==3)
                        {
                            Fragment fr=new Fragment_Contacts();
                            FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                            fc.replaceFragment(fr,"Contacts");
                        }
                        if(position==4)
                        {
                            Fragment fr=new Fragment_AboutUs();
                            FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                            fc.replaceFragment(fr,"About");
                        }
                        if(position==5)
                        {
                            Fragment fr=new Fragment_Developers();
                            FragmentChangeListener fc=(FragmentChangeListener)getActivity();
                            fc.replaceFragment(fr,"Developers");
                        }
                    }

                    @Override public void onLongItemClick(View view, int position) {
                        // do whatever
                    }
                })
        );

        return mainView;
    }
    public void populateViewPager(Context context, View view) {
        ViewPager viewPager;
        CustomAdapter adapter;
        adapter=new CustomAdapter(context);
        viewPager=(ViewPager)view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(1);
        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.tabDots);
        tabLayout.setupWithViewPager(viewPager,true);
    }
    private void populatRecyclerView() {
        ArrayList<DataModel> arrayList = new ArrayList<>();
        for (int i = 0; i < TITLES.length; i++) {
            arrayList.add(new DataModel(TITLES[i],IMAGES[i]));
        }
        RecyclerAdapter  adapter = new RecyclerAdapter(arrayList,context);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        recyclerView.setItemViewCacheSize(5);

    }

}