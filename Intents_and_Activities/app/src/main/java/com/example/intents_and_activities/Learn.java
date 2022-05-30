package com.example.intents_and_activities;

import static android.view.View.*;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.printservice.CustomPrinterIconCallback;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class Learn extends AppCompatActivity {
    ListView listView;
    String list[]= {"Aa", "Bb", "Cc", "Dd", "Ee", "Ff" , "Gg" , "Hh" , "Ii", "Jj","Kk" ,"Ll" , "Mm" ,"Nn" ,"Oo" ,"Pp" , "Qq" , "Rr" , "Ss" , "Tt" , "Uu" , "Vv" , "Ww" ,"Xx" , "Yy" , "Zz" };
    //Button a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    int listIcon[]={
            R.drawable.a,
            R.drawable.b,
            R.drawable.c,
            R.drawable.d,
            R.drawable.e,
            R.drawable.f,
            R.drawable.g,
            R.drawable.h,
            R.drawable.i,
            R.drawable.j,
            R.drawable.k,
            R.drawable.l,
            R.drawable.m,
            R.drawable.n,
            R.drawable.o,
            R.drawable.p,
            R.drawable.q,
            R.drawable.r,
            R.drawable.s,
            R.drawable.t,
            R.drawable.u,
            R.drawable.v,
            R.drawable.w,
            R.drawable.x,
            R.drawable.y,
            R.drawable.z
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        listView = findViewById(R.id.lst_view);
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_listview, R.id.txt_view , list);
//        listView.setAdapter(arrayAdapter);
        CustomAdapter ArrayAdapter = new CustomAdapter((Application) getApplicationContext(), list, listIcon);
        listView.setAdapter(ArrayAdapter);

        listView.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

               switch(position){
                   case 0:
                       Intent intent = new Intent(Learn.this, A.class);
                       startActivity(intent);
                       break;

                   case 1:
                       Intent intent1 = new Intent(Learn.this, B.class);
                       startActivity(intent1);
                       break;

                   case 2:
                       C(this);
                       break;
                   case 3:
                       D(this);
                       break;
                   case 4:
                       E(this);
                       break;
                   case 5:
                       F(this);
                       break;
                   case 6:
                       G(this);
                       break;
                   case 7:
                       H(this);
                       break;
                   case 8:
                       I(this);
                       break;
                   case 9:
                       J(this);
                       break;
                   case 10:
                       K(this);
                       break;
                   case 11:
                       L(this);
                       break;
                   case 12:
                       M(this);
                       break;
                   case 13:
                       N(this);
                       break;
                   case 14:
                       O(this);
                       break;
                   case 15:
                       P(this);
                       break;
                   case 16:
                       Q(this);
                       break;
                   case 17:
                       Rr(this);
                       break;
                   case 18:
                       S(this);
                       break;
                   case 19:
                       T(this);
                       break;
                   case 20:
                       U(this);
                       break;
                   case 21:
                       V(this);
                       break;
                   case 22:
                       W(this);
                       break;
                   case 23:
                       X(this);
                       break;
                   case 24:
                       Y(this);
                       break;
                   case 25:
                       Z(this);
                       break;

               }

            }
        });





    }
//        public void A(View view) {
////            Intent intent = new Intent(Learn.this, A.class);
////            startActivity(intent);
////        }
////        public void B(View view) {
////            Intent intent = new Intent(Learn.this, B.class);
////            startActivity(intent);
////        }
            public void C(OnItemClickListener view) {
           Intent intent = new Intent(Learn.this, C.class);
            startActivity(intent);
        }
        public void D(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, D.class);
            startActivity(intent);
        }
        public void E(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, E.class);
            startActivity(intent);
        }

        public void F(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, F.class);
            startActivity(intent);
        }
        public void G(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, G.class);
            startActivity(intent);
        }
        public void H(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, H.class);
            startActivity(intent);
        }
        public void I(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, I.class);
            startActivity(intent);
        }
        public void J(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, J.class);
            startActivity(intent);
        }
        public void K(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, K.class);
            startActivity(intent);
        }
        public void L(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, L.class);
            startActivity(intent);
        }
        public void M(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, M.class);
            startActivity(intent);
        }
        public void N(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, N.class);
            startActivity(intent);
        }
        public void O(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, O.class);
            startActivity(intent);
        }
        public void P(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, P.class);
            startActivity(intent);
        }
        public void Q(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, Q.class);
            startActivity(intent);
        }
        public void Rr(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, Rr.class);
            startActivity(intent);
        }
        public void S(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, S.class);
            startActivity(intent);
        }
        public void T(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, T.class);
            startActivity(intent);
        }
        public void U(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, U.class);
            startActivity(intent);
        }
        public void V(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, V.class);
            startActivity(intent);
        }
        public void W(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, W.class);
            startActivity(intent);
        }
        public void X(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, X.class);
            startActivity(intent);
        }
        public void Y(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, Y.class);
            startActivity(intent);
        }
        public void Z(OnItemClickListener view) {
            Intent intent = new Intent(Learn.this, Z.class);
            startActivity(intent);
        }



}