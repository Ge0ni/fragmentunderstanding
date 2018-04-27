package com.owono.android.fragmentunderstanding;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the reference of Button's
        final Button addButton = (Button) findViewById(R.id.addButton);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String msg = (String) addButton.getText();
                Log.i(TAG, "Text is'" + msg + "'right");
                if (msg.equals("LOAD F1")) {
                    Log.i(TAG, "in 1");
                    loadFragment(new DetailFragment());
                    addButton.setText("LOAD F2");
                }
                else if (msg.equals("LOAD F2")) {
                    Log.i(TAG, "in 2");
                    loadFragment(new MyListFragment());
                    addButton.setText("LOAD F1");
                }
            }
        });
    }

    public void loadFragment(Fragment fragment) {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frameOne, fragment);
        ft.commit();
    }
}