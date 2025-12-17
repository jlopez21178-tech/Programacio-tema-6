package ex9;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class gestorVehicle {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Vehicle[] vehicles = new Vehicle[5];

		vehicles[0] = new Cotxe("Corsa", "gtxA", 2005, "Diesel", 10, 40);
		vehicles[1] = new Moto("Kawasaki", "A3", 2024, "Electric", 5, 37);
		vehicles[2] = new Camio("Yamaha", "400x", 2000, "Gasolina", 20,60);
		vehicles[3] = new Camio("Yamamoto", "abc", 2021, "Electric", 25, 64);
		vehicles[4] = new Cotxe("Lamborghini", "Cabrio", 2025, "Hybrid", 30, 50);

		for(int i = 0; i < 5; i++) {
			vehicles[i].mostrarInformacio();
			vehicles[i].costPerKm(100);
			System.out.println();
		}

		System.out.println("Quants de kilometres faran?");
		int km = sc.nextInt();

		costTotal(vehicles, km);
	}

	public static void costTotal(Vehicle[] vehicles, int km) {
		Arrays.sort(vehicles, Comparator.comparingInt(Vehicle::getCost));

		for(int i = 0; i < vehicles.length; i++) {
			vehicles[i].mostrarInformacio();
			vehicles[i].costPerKm(km);
			System.out.println();
		}
	}



}
