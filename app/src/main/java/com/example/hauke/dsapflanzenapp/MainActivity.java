package com.example.hauke.dsapflanzenapp;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnRegions;
    Button btnTerritory;
    Button btnMonths;
    ListView listView;

    String[] listRegions;
    boolean[] checkedRegions;

    String[] listTerritories;
    boolean[] checkedTerritories;

    String[] listMonths;
    boolean[] checkedMonths;

    List<Plant> listItems;
    ArrayAdapter<Plant> adapter;

    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRegions = findViewById(R.id.btnRegions);
        btnTerritory = findViewById(R.id.btnTerritory);
        btnMonths = findViewById(R.id.btnMonths);
        listView = findViewById(R.id.listView);

        listRegions = getResources().getStringArray(R.array.regions);
        listTerritories = getResources().getStringArray(R.array.territories);
        listMonths = getResources().getStringArray(R.array.months);

        checkedRegions = new boolean[listRegions.length];
        checkedTerritories = new boolean[listTerritories.length];
        checkedMonths = new boolean[listMonths.length];

        database = new Database(listRegions, listTerritories, listMonths);
        listItems = new ArrayList<>(database.getPlants());
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        initializeBtnRegions();
        initializeBtnTerritories();
        initializeBtnMonths();
    }

    private void initializeBtnRegions() {
        btnRegions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder regionBuilder = new AlertDialog.Builder(MainActivity.this);
                regionBuilder.setTitle("Gebiete");
                regionBuilder.setMultiChoiceItems(listRegions, checkedRegions, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if (isChecked) {
                            //ToDo
                        }
                    }
                });
                regionBuilder.setCancelable(false);
                regionBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        filterPlants();
                    }
                });
                regionBuilder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                regionBuilder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedRegions.length; i++) {
                            checkedRegions[i] = false;
                        }
                        filterPlants();
                    }
                });
                AlertDialog dialog = regionBuilder.create();
                dialog.show();
            }
        });
    }

    private void initializeBtnTerritories() {
        btnTerritory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder regionBuilder = new AlertDialog.Builder(MainActivity.this);
                regionBuilder.setTitle("Verbreitung");
                regionBuilder.setMultiChoiceItems(listTerritories, checkedTerritories, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if (isChecked) {
                            //ToDo
                        }
                    }
                });
                regionBuilder.setCancelable(false);
                regionBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        filterPlants();
                    }
                });
                regionBuilder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                regionBuilder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedTerritories.length; i++) {
                            checkedTerritories[i] = false;
                        }
                        filterPlants();
                    }
                });
                AlertDialog dialog = regionBuilder.create();
                dialog.show();
            }
        });
    }

    private void initializeBtnMonths() {
        btnMonths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder regionBuilder = new AlertDialog.Builder(MainActivity.this);
                regionBuilder.setTitle("Erntemonate");
                regionBuilder.setMultiChoiceItems(listMonths, checkedMonths, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int position, boolean isChecked) {
                        if (isChecked) {
                            //ToDo
                        }
                    }
                });
                regionBuilder.setCancelable(false);
                regionBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        filterPlants();
                    }
                });
                regionBuilder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                regionBuilder.setNeutralButton("Clear", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i = 0; i < checkedMonths.length; i++) {
                            checkedMonths[i] = false;
                        }
                        filterPlants();
                    }
                });
                AlertDialog dialog = regionBuilder.create();
                dialog.show();
            }
        });
    }

    public void filterPlants() {
        List<Plant> results = new ArrayList<>(database.getPlants());
        List<String> regions = new ArrayList<>();
        for (int i = 0; i < listRegions.length; i++) {
            if (checkedRegions[i])
                regions.add(listRegions[i]);
        }
        if (regions.isEmpty())
            regions.addAll(Arrays.asList(listRegions));
        List<String> territories = new ArrayList<>();
        for (int i = 0; i < listTerritories.length; i++) {
            if (checkedTerritories[i])
                territories.add(listTerritories[i]);
        }
        if (territories.isEmpty())
            territories.addAll(Arrays.asList(listTerritories));
        List<String> months = new ArrayList<>();
        for (int i = 0; i < listMonths.length; i++) {
            if (checkedMonths[i])
                months.add(listMonths[i]);
        }
        if (months.isEmpty())
            months.addAll(Arrays.asList(listMonths));
        List<Plant> temp = new ArrayList<>();
        for (Plant p : results) {
            for (String s : regions) {
                if (p.getRegions().contains(s)) {
                    temp.add(p);
                    break;
                }
            }
        }
        results.retainAll(temp);
        temp.clear();
        for (Plant p : results) {
            for (String s : territories) {
                if (p.getTerritories().contains(s)) {
                    temp.add(p);
                    break;
                }
            }
        }
        results.retainAll(temp);
        temp.clear();
        for (Plant p : results) {
            for (String s : months) {
                if (p.getMonths().contains(s)) {
                    temp.add(p);
                    break;
                }
            }
        }
        results.retainAll(temp);
        System.out.println(results);
        listItems.clear();
        listItems.addAll(results);
        adapter.notifyDataSetChanged();

    }
}
