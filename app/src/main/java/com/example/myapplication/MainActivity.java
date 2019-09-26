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

    private List<Contact> ContactList;
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
                if (ContactList.size() <= 20) {
                    ContactList.add(null);
                    contactAdapter.notifyItemInserted(ContactList.size() - 1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            ContactList.remove(ContactList.size() - 1);
                            contactAdapter.notifyItemRemoved(ContactList.size());

                            //Generating more data
                            int index = ContactList.size();
                            int end = index + 10;
                            for (int i = index; i < end; i++) {
                                Contact contact = new Contact();

                                ContactList.add(contact);
                            }
                            contactAdapter.notifyDataSetChanged();
                            contactAdapter.setLoaded();
                        }
                    }, 5000);
                } else {
                    Toast.makeText(MainActivity.this, "Loading data completed", Toast.LENGTH_SHORT).show();
                }  }        });   }

    public void prepareContactData() {
        Contact Contact = new Contact("hj","dfd");
        ContactList.add(Contact);

        Contact = new Contact("Inside Out", "Animation");
        ContactList.add(Contact);

        Contact = new Contact("Star Wars: Episode VII - The Force Awakens", "Action");
        ContactList.add(Contact);

        Contact = new Contact("Shaun the Sheep", "Animation");
        ContactList.add(Contact);

        Contact = new Contact("The Martian", "Science Fiction & Fantasy");
        ContactList.add(Contact);

        Contact = new Contact("Mission: Impossible Rogue Nation", "Action");
        ContactList.add(Contact);

        Contact = new Contact("Up", "Animation");
        ContactList.add(Contact);

        Contact = new Contact("Star Trek", "Science Fiction");
        ContactList.add(Contact);

        Contact = new Contact("The LEGO Contact", "Animation");
        ContactList.add(Contact);

        Contact = new Contact("Iron Man", "Action & Adventure");
        ContactList.add(Contact);

        Contact = new Contact("Aliens", "Science Fiction");
        ContactList.add(Contact);

        Contact = new Contact("Chicken Run", "Animation");
        ContactList.add(Contact);

        Contact = new Contact("Back to the Future", "Science Fiction");
        ContactList.add(Contact);

        Contact = new Contact("Raiders of the Lost Ark", "Action & Adventure");
        ContactList.add(Contact);

        Contact = new Contact("Goldfinger", "Action & Adventure");
        ContactList.add(Contact);

        Contact = new Contact("Guardians of the Galaxy", "Science Fiction & Fantasy");
        ContactList.add(Contact);

        // notify adapter about data set changes
        // so that it will render the list with new data
        contactAdapter.notifyDataSetChanged();
    }


}