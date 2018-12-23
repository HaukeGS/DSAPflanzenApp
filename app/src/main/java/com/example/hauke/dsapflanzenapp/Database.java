package com.example.hauke.dsapflanzenapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Database {

    private List<Plant> plants;
    private String[] allRegions;
    private String[] allTerritories;
    private String[] allMonths;

    Database(String[] allRegions, String[] allTerritories, String[] allMonths) {
        this.allRegions = allRegions;
        this.allTerritories = allTerritories;
        this.allMonths = allMonths;
        fillDatabase();
    }

    public List<Plant> getPlants() {
        return plants;
    }

    private void fillDatabase() {
        String input =
                "Alraune;Nordaventurien,Orkland,Bornland,Thorwal,Svelltland,Elfenland,Noerdliches_Mittelreich,Westliches_Mittelreich,Suedliches_Mittelreich,Tulamidenlande;Wald,Waldrand,Grasland;all\n" +
                "Alveranie;all;all;all\n" +
                "Arganstrauch;Al_Anfa,Waldinseln;Regenwald,Sumpf,Wald,Waldrand;all\n" +
                "Atan-Kifer;Bornland;Gebirge;all\n" +
                "Atmon;Tulamidenlande,Khom;Steppe,Hochland,Sumpf,Flussauen;Peraine\n" +
                "Axorda-Baum;Maraskan;Regenwald,Gebirge;all\n" +
                "Basilamine;Orkland;Wald,Waldrand;all\n" +
                "Belmart;Nordaventurien,Orkland,Bornland,Thorwal,Svelltland,Elfenland,Noerdliches_Mittelreich,Westliches_Mittelreich,Suedliches_Mittelreich,Oestliches_Mittelreich,Tulamidenlande;Wald,Waldrand;Peraine,Ingerimm,Rahja,Praios,Rondra,Efferd,Travia,Boron\n" +
                "Blutblatt;all;all;all\n" +
                "Boronie;Westliches_Mittelreich,Suedliches_Mittelreich,Oestliches_Mittelreich,Tulamidenlande,Horasreich,Khom,Al_Anfa,Waldinseln;Regenwald,Grasland;all";
        plants = new ArrayList<>();
        Scanner scanner = new Scanner(input);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Scanner lineScanner = new Scanner(line);
            lineScanner.useDelimiter(";");
            //name
            String name = lineScanner.next();
            //regions
            String regions = lineScanner.next();
            List<String> regionsList = new ArrayList<>();
            if (regions.equals("all")) {
                regionsList = Arrays.asList(allRegions);
            } else {
                Scanner regionScanner = new Scanner(regions);
                regionScanner.useDelimiter(",");
                while (regionScanner.hasNext()) {
                    regionsList.add(regionScanner.next());
                }
            }
            //territories
            String territories = lineScanner.next();
            List<String> territoriesList = new ArrayList<>();
            if (territories.equals("all")) {
                territoriesList = Arrays.asList(allTerritories);
            } else {
                Scanner territoriesScanner = new Scanner(territories);
                territoriesScanner.useDelimiter(",");
                while (territoriesScanner.hasNext()) {
                    territoriesList.add(territoriesScanner.next());
                }
            }
            //months
            String months = lineScanner.next();
            List<String> monthsList = new ArrayList<>();
            if (months.equals("all")) {
                monthsList = Arrays.asList(allMonths);
            } else {
                Scanner monthsScanner = new Scanner (months);
                monthsScanner.useDelimiter(",");
                while (monthsScanner.hasNext()) {
                    monthsList.add(monthsScanner.next());
                }
            }
            plants.add(new Plant(name, regionsList, territoriesList, monthsList));
        }

    }

    public enum Region {
        Nordaventurien,
        Orkland,
        Bornland,
        Thorwal,
        Svelltland,
        Elfenland,
        Noerdliches_Mittelreich,
        Westliches_Mittelreich,
        Suedliches_Mittelreich,
        Oestliches_Mittelreich,
        Maraskan,
        Tulamidenlande,
        Horasreich,
        Khom,
        Al_Anfa,
        Waldinseln
    }

    public enum Terrain {
        Eis,
        Wueste,
        Gebirge,
        Hochland,
        Steppe,
        Grasland,
        Flussufer,
        Kueste,
        Flussauen,
        Sumpf,
        Regenwald,
        Wald,
        Waldrand
    }

    public enum Month {
        Praios,
        Rondra,
        Efferd,
        Travia,
        Boron,
        Hesinde,
        Firun,
        Tsa,
        Phex,
        Peraine,
        Ingerimm,
        Rahja
    }
}
