package com.kevicsalazar.appkit_java;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Kevin Salazar
 */
public abstract class BaseActivity extends AppCompatActivity {

    /**
     * The onCreate base will set the view specified in [.getLayout] and will
     * inject dependencies and views.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        setupComponent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        if (getPresenter() != null) getPresenter().onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (getPresenter() != null) getPresenter().onStop();
    }

    /**
     * @return The layout that's gonna be the activity view.
     */
    protected abstract int getLayout();

    /**
     * @return The presenter attached to the activity. This must extends from [BasePresenter]
     */
    protected abstract BasePresenter getPresenter();

    /**
     * Setup UIComponent
     */
    protected abstract void setupComponent();

}
