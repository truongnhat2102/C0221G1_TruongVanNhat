package manage_vehicle.Common;

import manage_vehicle.Model.Motorbike;
import manage_vehicle.Model.Oto;
import manage_vehicle.Model.Truck;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class WriterAndReader {
    static List<Oto> otos = new ArrayList<>();
    static List<Truck> trucks = new ArrayList<>();
    static List<Motorbike> motorbikes = new ArrayList<>();

    public static void write(String path, String line, boolean status) {
        try {
            FileWriter data = new FileWriter(path, status);
            BufferedWriter bfw = new BufferedWriter(data);
            bfw.write(line + "\n");
            System.out.println("done");
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(String path) {
        try {
            FileReader data = new FileReader(path);
            BufferedReader bfr = new BufferedReader(data);
            String line = null;
            while ((line = bfr.readLine()) != null) {
                String[] arr = line.split(",");
                if (arr.length == 6) {
                    Oto oto = new Oto(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5]);
                    otos.add(oto);
                } else if (Integer.parseInt(arr[4]) < 15) {
                    Truck truck = new Truck(arr[0], arr[1], arr[2], arr[3], arr[4]);
                    trucks.add(truck);
                } else if (Integer.parseInt(arr[4]) > 50) {
                    Motorbike motorbike = new Motorbike(arr[0], arr[1], arr[2], arr[3], arr[4]);
                    motorbikes.add(motorbike);
                }
            }
            bfr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Oto> getOtos() {
        return otos;
    }

    public static List<Truck> getTrucks() {
        return trucks;
    }

    public static List<Motorbike> getMotorbikes() {
        return motorbikes;
    }
}
