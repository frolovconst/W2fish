package com.example.carioca.w2rcgfish;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by carioca on 04/06/2017.
 */

public class ArticleFragment extends Fragment {
    OnArticleSelectedListener mCallback;
    public final static String ARG_POSITION = "position";

    public interface OnArticleSelectedListener{
        public void OnArticleSelected(String message);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            mCallback = (OnArticleSelectedListener) activity;
        }
        catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnArticleSelectedListener interface");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_article, container, false);
    }

    public void updateArticleFragment(String message){
        TextView textView = (TextView) getView().findViewById(R.id.textView_art);
        textView.setText(message);
    }


}
