package com.example.firebasedatabase25022020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 : Gui du lieu dang string
        // Tao ra 1 node
//        myRef.child().child("").setValue();
        // Tao ra 1 child
//        myRef.child("chuoi").setValue("Hello").addOnSuccessListener(new OnSuccessListener<Void>() {
//            @Override
//            public void onSuccess(Void aVoid) {
//                Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//            }
//        });
        // 2 : Object
//        Xeco xedap = new Xeco("xedap",2);
//        myRef.child("phuongtien").setValue(xedap).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(MainActivity.this, "Thanh cong", Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(MainActivity.this, "That bai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
        // 3 : Hash map
//        Map<String, String> map = new HashMap<>();
//        map.put("value1","Data");
//
//        Iterable iterable = map.values();
//        while (iterable.iterator().hasNext()){
//            Log.d("BBB",iterable.iterator().next().toString());
//        }
        // 4 : Dang mang
//        Xeco xehoi = new Xeco("xehoi",4);
//        Xeco xebagac = new Xeco("xebagac",3);
//
//        myRef.child("xeco").push().setValue(xehoi);
//        myRef.child("xeco").push().setValue(xebagac);

        // Doc du lieu
        //1 : Doc du lieu dang string
//        myRef.child("chuoi").addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                String value = (String) dataSnapshot.getValue();
//                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        myRef.child("phuongtien").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Xeco xeco = dataSnapshot.getValue(Xeco.class);
                Toast.makeText(MainActivity.this, xeco.getTen(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
