package com.example.myapplication;
import android.os.Bundle;
import android.os.Handler;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Contact> ContactList= new ArrayList<>();;
    private ContactAdapter contactAdapter;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        random = new Random();
            Contact contact = new Contact();
        prepareContactData();
        //find view by id and attaching adapter for the RecyclerView
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        contactAdapter = new ContactAdapter(recyclerView, ContactList, this);
        recyclerView.setAdapter(contactAdapter);
        //set load more listener for the RecyclerView adapter
        contactAdapter.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                if (ContactList.size() <= 10) {
                    ContactList.add(null);
                    contactAdapter.notifyItemInserted(ContactList.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ContactList.remove(ContactList.size() - 1);
                            contactAdapter.notifyItemRemoved(ContactList.size());

                            //Generating more data
                            int index = ContactList.size();
                            int end = index+1 ;
                            for (int i = index ; i < end; i++) {
                                Contact contact = new Contact();

//                                ContactList.add(contact);
                            }
                            contactAdapter.notifyDataSetChanged();
                            contactAdapter.setLoaded();
                        }
                    }, 3000);
                } else {
                    Toast.makeText(MainActivity.this, "Loading data completed", Toast.LENGTH_SHORT).show();
                }  }        });   }

    public void prepareContactData() {
        Contact Contact = new Contact("A","apple");
        ContactList.add(Contact);

        Contact = new Contact("B", "banana");
        ContactList.add(Contact);

        Contact = new Contact("C", "cat");
        ContactList.add(Contact);

        Contact = new Contact("D", "door");
        ContactList.add(Contact);

        Contact = new Contact("E", "eeeee");
        ContactList.add(Contact);

        Contact = new Contact("F", "ffff");
        ContactList.add(Contact);

        Contact = new Contact("G", "ggggggg");
        ContactList.add(Contact);

        Contact = new Contact("H", "");
        ContactList.add(Contact);

        Contact = new Contact("I", "");
        ContactList.add(Contact);

        Contact = new Contact("J", "");
        ContactList.add(Contact);

        Contact = new Contact("K", "");
        ContactList.add(Contact);

        Contact = new Contact("L", "");
        ContactList.add(Contact);

        Contact = new Contact("M", "");
        ContactList.add(Contact);

        Contact = new Contact("N", "");
        ContactList.add(Contact);

        Contact = new Contact("O", "");
        ContactList.add(Contact);

        Contact = new Contact("P", "");
        ContactList.add(Contact);

        Contact = new Contact("Q", "");
        ContactList.add(Contact);

        Contact = new Contact("R", "");
        ContactList.add(Contact);

        Contact = new Contact("S", "");
        ContactList.add(Contact);

        Contact = new Contact("T", "");
        ContactList.add(Contact);

        Contact = new Contact("U", "");
        ContactList.add(Contact);

        Contact = new Contact("V", "");
        ContactList.add(Contact);

        Contact = new Contact("W", "");
        ContactList.add(Contact);

        Contact = new Contact("X", "");
        ContactList.add(Contact);

        Contact = new Contact("Y", "");
        ContactList.add(Contact);

        Contact = new Contact("Z", "");
        ContactList.add(Contact);

        Contact = new Contact("Aa","apple");
        ContactList.add(Contact);

        Contact = new Contact("Bb", "banana");
        ContactList.add(Contact);

        Contact = new Contact("Cc", "cat");
        ContactList.add(Contact);

        Contact = new Contact("Dd", "door");
        ContactList.add(Contact);

        Contact = new Contact("Ee", "eeeee");
        ContactList.add(Contact);

        Contact = new Contact("Ff", "ffff");
        ContactList.add(Contact);

        Contact = new Contact("Gg", "ggggggg");
        ContactList.add(Contact);

        Contact = new Contact("Hh", "");
        ContactList.add(Contact);

        Contact = new Contact("Ii", "");
        ContactList.add(Contact);

        Contact = new Contact("Jj", "");
        ContactList.add(Contact);

        Contact = new Contact("Kk", "");
        ContactList.add(Contact);

        Contact = new Contact("Ll", "");
        ContactList.add(Contact);

        Contact = new Contact("Mm", "");
        ContactList.add(Contact);

        Contact = new Contact("Nn", "");
        ContactList.add(Contact);

        Contact = new Contact("Oo", "");
        ContactList.add(Contact);

        Contact = new Contact("Pp", "");
        ContactList.add(Contact);

        Contact = new Contact("Qq", "");
        ContactList.add(Contact);

        Contact = new Contact("Rr", "");
        ContactList.add(Contact);

        Contact = new Contact("Ss", "");
        ContactList.add(Contact);

        Contact = new Contact("Tt", "");
        ContactList.add(Contact);

        Contact = new Contact("Uu", "");
        ContactList.add(Contact);

        Contact = new Contact("Vv", "");
        ContactList.add(Contact);

        Contact = new Contact("Ww", "");
        ContactList.add(Contact);

        Contact = new Contact("Xx", "");
        ContactList.add(Contact);

        Contact = new Contact("Yy", "");
        ContactList.add(Contact);

        Contact = new Contact("Zz", "");
        ContactList.add(Contact);



        // notify adapter about data set changes
        // so that it will render the list with new data
//        contactAdapter.notifyDataSetChanged();
    }


}