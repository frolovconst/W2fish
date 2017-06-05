package com.example.carioca.w2rcgfish;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.carioca.w2rcgfish.Fragments.AlternativeFragment;

public class FragmentActivity extends AppCompatActivity
        implements
                    ArticleFragment.OnArticleSelectedListener,
                    AlternativeFragment.OnAlternativeFragmentSelectedListener

{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        if (findViewById(R.id.fragment_container) != null) {

            // However, if we're being restored from a previous state,
            // then we don't need to do anything and should return or else
            // we could end up with overlapping fragments.
            if (savedInstanceState != null) {
                return;
            }

            // Create a new Fragment to be placed in the activity layout
            ArticleFragment firstFragment = new ArticleFragment();

            // In case this activity was started with special instructions from an
            // Intent, pass the Intent's extras to the fragment as arguments
            firstFragment.setArguments(getIntent().getExtras());

            // Add the fragment to the 'fragment_container' FrameLayout
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, firstFragment).commit();
        }
    }

    @Override
    public void OnArticleSelected(String message) {
        AlternativeFragment alternativeFragment = (AlternativeFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_alternative);

        if(alternativeFragment != null){
            alternativeFragment.updateAlternativeFragment(message);
        }
        else{
            AlternativeFragment newFragment = new AlternativeFragment();
            Bundle args = new Bundle();
            args.putString(AlternativeFragment.ARG_POSITION, message);
            newFragment.setArguments(args);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            transaction.replace(R.id.fragment_container, newFragment);
            transaction.addToBackStack(null);
            transaction.commit();
        }

    }

    @Override
    public void OnAlternativeFragmentSelected(String message) {
        ArticleFragment articleFragment = (ArticleFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_article);

        if(articleFragment != null){
            articleFragment.updateArticleFragment(message);
        }
    }

    public void OnAltTransitionButtonClick(View view){
        OnAlternativeFragmentSelected("Alternative fragment selected");
    }


    public void OnArticleTransitionButtonClick(View view){
        OnArticleSelected("Article fragment selected");
    }


}
