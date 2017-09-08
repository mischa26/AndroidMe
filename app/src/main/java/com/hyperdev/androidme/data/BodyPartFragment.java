package com.hyperdev.androidme.data;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hyperdev.androidme.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class BodyPartFragment extends Fragment {

    private View head;
    private View body;
    private View leg;
    private int countIndex;
    private int bodyIndex;
    private int legIndex;
    private List<Integer> intergerList;
    private List<Integer> viewBody;
    private List<Integer> viewLeg;
    private Random random;
    private List<Integer> mPartsNumber;
    private int mListPosition;
    private static final String PARTS_LIST = "parts_list";
    private static final String PARTS_NUMBER = "parts_number";


    public BodyPartFragment() {
        intergerList = AndroidImageAssets.getHeads();
        viewBody = AndroidImageAssets.getBodies();
        viewLeg = AndroidImageAssets.getLegs();
        countIndex=0;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_blank,container, false);
        head = view.findViewById(R.id.Head);
        body = view.findViewById(R.id.Body);
        leg = view.findViewById(R.id.Legs);

        if(savedInstanceState != null){
            mPartsNumber = savedInstanceState.getIntegerArrayList(PARTS_LIST);
            mListPosition = savedInstanceState.getInt(PARTS_NUMBER);
        }

        head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(countIndex == intergerList.size()){
                    countIndex = 0;
                }
                head.setBackground(ResourcesCompat.getDrawable(getResources(), intergerList.get(countIndex++), null));
            }
        });

        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                if(bodyIndex == viewBody.size()){
                    bodyIndex = 0;
                }
                body.setBackground(ResourcesCompat.getDrawable(getResources(), viewBody.get(bodyIndex++), null));
                }
        });

        leg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(legIndex == viewLeg.size()){
                    legIndex = 0;
                }
                leg.setBackground(ResourcesCompat.getDrawable(getResources(), viewLeg.get(legIndex++), null));
            }
        });
        return  view;
    }

    public void setPartList(List<Integer> partList) {

        this.mPartsNumber = partList;
    }

    public void setListPosition(int mListPosition) {

        this.mListPosition = mListPosition;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList(PARTS_LIST, (ArrayList<Integer>)mPartsNumber);
        outState.putInt(PARTS_NUMBER,mListPosition);
    }
}
