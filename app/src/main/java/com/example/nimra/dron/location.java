package com.example.nimra.dron;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class location extends AppCompatActivity {
   private TextView date,time,latitude,longitude;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference mDatabase;
    private String userID;
    private FirebaseDatabase mfirebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        mDatabase = FirebaseDatabase.getInstance().getReference("system");
        firebaseAuth = FirebaseAuth.getInstance();
        mfirebaseDatabase = FirebaseDatabase.getInstance();
        mDatabase = mfirebaseDatabase.getReference();

        date=(TextView)findViewById(R.id.date);
        latitude=(TextView)findViewById(R.id.latitude);
        longitude=(TextView)findViewById(R.id.longitude);
        time=(TextView)findViewById(R.id.time);



       mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    locationdetail detail = new locationdetail();
                    detail.setDate(ds.child("employee").child("gpslocation").child("1").getValue(locationdetail.class).getDate());
                  detail.setLatitude(ds.child("employee").child("gpslocation").child("1").getValue(locationdetail.class).getLatitude());
                    detail.setLongitude(ds.child("employee").child("gpslocation").child("1").getValue(locationdetail.class).getLongitude());
                    detail.setTime(ds.child("employee").child("gpslocation").child("1").getValue(locationdetail.class).getDate());

                    date.setText( detail.getDate());
                    latitude.setText(detail.getLatitude());
                    longitude.setText(detail.getLongitude());
                    time.setText(detail.getTime());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}
