package krupex1.th.in.android.krupex1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import krupex1.th.in.android.krupex1.fragment.MainFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Add Flagment
        if (savedInstanceState == null) {

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.contenMainFragment, new MainFragment())  //control enter
                    .commit();
        }

        }  // Main Method
    }// main class
