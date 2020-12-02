package com.example.snowtam_pointet_vallee.Controller;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.snowtam_pointet_vallee.Model.Airport;

import java.util.HashMap;


public class SwipeAdapter extends FragmentStatePagerAdapter {

    HashMap<Integer,Snowtam> listSnowtam = new HashMap<>();

    public SwipeAdapter(FragmentManager fm, HashMap<Integer, Airport> listSnowtam){
        super(fm);
        this.listSnowtam = listSnowtam;
        System.out.println("list size " + listSnowtam.size());
        /*
        if (listSnowtam.isEmpty()){
            listSnowtam.put(0,new Snowtam("test"));
            listSnowtam.put(1,new Snowtam("test2"));
        }

         */
    }


    @NonNull
    @Override
    public androidx.fragment.app.Fragment getItem(int position) {
        Fragment pageFragment = new FragmentPage();
        Bundle bundle = new Bundle();
        bundle.putInt("pageNumber",position);
        System.out.println("position " + position);
        bundle.putString("data", (String) ((Snowtam) listSnowtam.get(position)).getOriginal());
        System.out.println("data " + (String) listSnowtam.get(position).getOriginal());
        pageFragment.setArguments(bundle);

        return pageFragment;
    }

    @Override
    public int getCount() {
        //return 1;
        return listSnowtam.size();
    }
}
