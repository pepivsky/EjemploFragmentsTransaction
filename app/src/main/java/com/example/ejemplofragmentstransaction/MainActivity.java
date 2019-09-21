package com.example.ejemplofragmentstransaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button addA, addB, removeA, removeB, replaceA, replaceB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addA = (Button)findViewById(R.id.AddA);
        addB = (Button)findViewById(R.id.AddB);

        removeA = (Button) findViewById(R.id.RemoveA);
        removeB = (Button) findViewById(R.id.RemoveB);

        replaceA = (Button) findViewById(R.id.ReplaceA);
        replaceB = (Button) findViewById(R.id.ReplaceB);



        addA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declaramos el objeto fragment
                FragmentA fragmentA = new FragmentA();
                //Declaramos el objeto fragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();
                //Declaramos un objeto frgamentTransaction para empezar la transaccion
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //le agregamos el fragment con el metodo add que recibe el contendor y el fragment
                fragmentTransaction.add(R.id.frameLayout,fragmentA,"FragmentA");
                //Ejecutamos el commit para que esto tenga efecto y se agregue el fragment
                fragmentTransaction.commit();


            }
        });

        removeA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                //Encontrar el fragment por el TAG
                FragmentA fragmentA = (FragmentA) fragmentManager.findFragmentByTag("FragmentA");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //If para comprobar que exista el fragment A y así poder eliminarlo
                if (fragmentA!= null){
                    fragmentTransaction.remove(fragmentA);
                    fragmentTransaction.commit();
                }


            }
        });
            //Remplaza lo que haya por el fragment A
        replaceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentA fragmentA = new FragmentA();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameLayout,fragmentA,"FragmentA");
                transaction.commit();


            }
        });



        addB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Declaramos el objeto fragment
                FragmentB fragmentB = new FragmentB();
                //Declaramos el objeto fragmentManager
                FragmentManager fragmentManager = getSupportFragmentManager();
                //Declaramos un objeto frgamentTransaction para empezar la transaccion
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //le agregamos el fragment con el metodo add que recibe el contendor y el fragment
                fragmentTransaction.add(R.id.frameLayout,fragmentB,"FragmentB");
                //Ejecutamos el commit para que esto tenga efecto y se agregue el fragment
                fragmentTransaction.commit();

            }
        });

        removeB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getSupportFragmentManager();

                //Encontrar el fragment por el TAG
                //FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("FragmentA");
                FragmentB fragmentB = (FragmentB) fragmentManager.findFragmentByTag("FragmentB");
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                //If para comprobar que exista el fragment A y así poder eliminarlo
                if (fragmentB!= null){
                    fragmentTransaction.remove(fragmentB);
                    fragmentTransaction.commit();
                }

            }
        });

        replaceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentB fragmentB = new FragmentB();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.frameLayout,fragmentB,"FragmentB");
                transaction.commit();

            }
        });
    }
}
