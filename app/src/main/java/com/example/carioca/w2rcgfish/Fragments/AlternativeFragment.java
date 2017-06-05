package com.example.carioca.w2rcgfish.Fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.carioca.w2rcgfish.ArticleFragment;
import com.example.carioca.w2rcgfish.R;

/**
 * Created by carioca on 04/06/2017.
 */

public class AlternativeFragment extends android.support.v4.app.Fragment {

    AlternativeFragment.OnAlternativeFragmentSelectedListener mCallback;
    public final static String ARG_POSITION = "position";

    public interface OnAlternativeFragmentSelectedListener{
        public void OnAlternativeFragmentSelected(String message);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try {
            mCallback = (OnAlternativeFragmentSelectedListener)activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnAlternativeFragmentSelectedListener interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_alternative, container, savedInstanceState == null?false:savedInstanceState.getString(ArticleFragment.ARG_POSITION));
        String message;
        if(savedInstanceState != null){
            message = savedInstanceState.getString(ArticleFragment.ARG_POSITION);
            updateAlternativeFragment(message);
        }
        return inflater.inflate(R.layout.fragment_alternative, container, false);

    }



    public void updateAlternativeFragment(String message){
        TextView textView = (TextView) getView().findViewById(R.id.textView_alt);
        if (textView == null)
            Log.d("KOS", "not ok");
        textView.setText(message);
    }
}
