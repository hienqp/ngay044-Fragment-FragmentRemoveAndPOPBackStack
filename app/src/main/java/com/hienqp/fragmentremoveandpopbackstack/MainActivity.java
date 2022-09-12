package com.hienqp.fragmentremoveandpopbackstack;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void AddA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new AFragment(), "fragA");
        fragmentTransaction.commit();
    }

    public void AddB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new BFragment(), "fragB");
        fragmentTransaction.commit();
    }

    public void AddC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framelayout_contain_fragment, new CFragment(), "fragC");
        fragmentTransaction.commit();
    }

    public void RemoveA(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        AFragment aFragment = (AFragment) getFragmentManager().findFragmentByTag("fragA");
        if (aFragment != null) {
            fragmentTransaction.remove(aFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Fragment A chưa được thêm vào !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveB(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        BFragment bFragment = (BFragment) getFragmentManager().findFragmentByTag("fragB");
        if (bFragment != null) {
            fragmentTransaction.remove(bFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Fragment B chưa được thêm vào !!!", Toast.LENGTH_SHORT).show();
        }
    }

    public void RemoveC(View view) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        CFragment cFragment = (CFragment) getFragmentManager().findFragmentByTag("fragC");
        if (cFragment != null) {
            fragmentTransaction.remove(cFragment);
            fragmentTransaction.commit();
        } else {
            Toast.makeText(this, "Fragment C chưa được thêm vào !!!", Toast.LENGTH_SHORT).show();
        } 
    }
}