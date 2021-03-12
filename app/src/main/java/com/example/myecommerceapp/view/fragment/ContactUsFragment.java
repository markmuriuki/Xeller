/*
 * Copyright (c) 2017. http://hiteshsahu.com- All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * If you use or distribute this project then you MUST ADD A COPY OF LICENCE
 * along with the project.
 *  Written by Hitesh Sahu <hiteshkrsahu@Gmail.com>, 2017.
 */
package com.example.myecommerceapp.view.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.core.view.GravityCompat;
import androidx.appcompat.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myecommerceapp.R;
import com.example.myecommerceapp.util.Utils;
//import com.example.myecommerceapp.util.Utils.AnimationType;
import com.example.myecommerceapp.view.activities.ECartHomeActivity;

import java.util.Objects;


// TODO: Auto-generated Javadoc

/**
 * Fragment that appears in the "content_frame", shows a animal.
 */
public class ContactUsFragment extends Fragment {

    private Toolbar mToolbar;

    /**
     * Instantiates a new settings fragment.
     */
    public ContactUsFragment() {
        // Empty constructor required for fragment subclasses
    }

    public static Fragment newInstance() {
        // TODO Auto-generated method stub
        return new ContactUsFragment();
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.frag_about, container,
                false);

        Objects.requireNonNull(getActivity()).setTitle("Contact Us");


        mToolbar = (Toolbar) rootView.findViewById(R.id.htab_toolbar);
        if (mToolbar != null) {
            ((ECartHomeActivity) getActivity()).setSupportActionBar(mToolbar);
        }

        if (mToolbar != null) {
            Objects.requireNonNull(((ECartHomeActivity) getActivity()).getSupportActionBar())
                    .setDisplayHomeAsUpEnabled(true);

            mToolbar.setNavigationIcon(R.drawable.ic_drawer);


        }

        assert mToolbar != null;
        mToolbar.setNavigationOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ECartHomeActivity) Objects.requireNonNull(getActivity())).getmDrawerLayout()
                        .openDrawer(GravityCompat.START);
            }
        });

        mToolbar.setTitleTextColor(Color.WHITE);

        rootView.findViewById(R.id.locations).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                    }
                });

        rootView.findViewById(R.id.contact_us).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        Intent callIntent = new Intent(Intent.ACTION_DIAL);
                        callIntent.setData(Uri.parse("tel:" + "8888813275"));
                        startActivity(callIntent);

                    }
                });

        rootView.setFocusableInTouchMode(true);
        rootView.requestFocus();
        rootView.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if (event.getAction() == KeyEvent.ACTION_UP
                        && keyCode == KeyEvent.KEYCODE_BACK) {

                    Utils.switchContent(R.id.frag_container,
                            Utils.HOME_FRAGMENT,
                            ((ECartHomeActivity) (getContext())),
                            Utils.AnimationType.SLIDE_UP);

                }
                return true;
            }
        });

        rootView.findViewById(R.id.site_dev).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent browserIntent = new Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("http://hiteshsahu.com/"));
                        startActivity(browserIntent);

                    }
                });

        rootView.findViewById(R.id.email).setOnClickListener(
                new OnClickListener() {

                    @Override
                    public void onClick(View v) {

                        final Intent emailIntent = new Intent(
                                Intent.ACTION_SEND);
                        emailIntent.setType("text/plain");
                        emailIntent
                                .putExtra(
                                        Intent.EXTRA_EMAIL,
                                        new String[]{"hiteshkrsahu@gmail.com"});
                        emailIntent.putExtra(
                                Intent.EXTRA_SUBJECT,
                                "Hello There");
                        emailIntent.putExtra(Intent.EXTRA_TEXT,
                                "Add Message here");

                        emailIntent.setType("message/rfc822");

                        try {
                            startActivity(Intent.createChooser(emailIntent,
                                    "Send email using..."));
                        } catch (android.content.ActivityNotFoundException ex) {
                            Toast.makeText(getActivity(),
                                    "No email clients installed.",
                                    Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        return rootView;
    }
}
