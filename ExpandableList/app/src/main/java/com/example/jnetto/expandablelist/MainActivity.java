package com.example.jnetto.expandablelist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expandableListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // get the listview
        expandableListView = (ExpandableListView) findViewById(R.id.lvExp);

        // preparing list data
        populateListData();

        expandableListAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // setting list adapter
        expandableListView.setAdapter(expandableListAdapter);
    }

    /*
     * Preparing the list data
     */
    private void populateListData() {

        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding child data
        listDataHeader.add("Parana");
        listDataHeader.add("Santa Catarina");
        listDataHeader.add("Rio Grande");

        // Adding child data
        List<String> parana = new ArrayList<String>();
        parana.add("Curitiba");
        parana.add("Ponta Grossa");
        parana.add("Londrina");

        List<String> santaCatarina = new ArrayList<String>();
        santaCatarina.add("Florianopolis");
        santaCatarina.add("Blumenau");
        santaCatarina.add("Abdon Batista");

        List<String> rioGrande = new ArrayList<String>();
        rioGrande.add("Gramado");
        rioGrande.add("Canela");
        rioGrande.add("Porto Alegre");

        // Header, Child data
        listDataChild.put(listDataHeader.get(0), parana);
        listDataChild.put(listDataHeader.get(1), santaCatarina);
        listDataChild.put(listDataHeader.get(2), rioGrande);
    }
}
