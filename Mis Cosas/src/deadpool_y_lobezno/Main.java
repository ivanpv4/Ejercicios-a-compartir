package deadpool_y_lobezno;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		int vidaDeadpool = 0;
		int vidaWolverine = 0;
		int turno = 1;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Determina los puntos de vida de Deadpool: ");
		while (vidaDeadpool <= 0) {
			try {
				vidaDeadpool = sc.nextInt();
				if(vidaDeadpool <= 0) {
					System.out.println("Introduce un número superior a 0");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un número y que sea mayor que 0");
				sc.next();
			}
		}
		
		System.out.println("Determina los puntos de vida de Wolverine: ");
		while (vidaWolverine <= 0) {
			try{
				vidaWolverine = sc.nextInt();
				if(vidaWolverine <= 0) {
					System.out.println("Introduce un número superior a 0");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduce un número y que sea mayor que 0");
				sc.next();
			}
		}
		Personaje deadpool = new Personaje(vidaDeadpool);
		Personaje wolverine = new Personaje(vidaWolverine);

		do {
			System.out.println("\nTurno: " + turno);
			ataqueDeadpool(deadpool, wolverine);
			turno++;
			if (wolverine.getVida() <= 0) {
				break;
			}
			System.out.println("\nTurno: " + turno);
			ataqueWolverine(wolverine, deadpool);
			turno++;

		} while (deadpool.getVida() > 0 && wolverine.getVida() > 0);

		System.out.println("\n¡Terminó el combate!");
		if (deadpool.getVida() > 0) {
			System.out.println("\nEl ganador es Deadpool");
		} else {
			System.out.println("\nEl ganador es Wolverine");
		}

		sc.close();
	}

	public static void ataqueDeadpool(Personaje deadpool, Personaje wolverine) {

		int min = 10;
		int maxDead = 100;
		int ataqueDeadpool = min + (int) (Math.random() * ((maxDead - min) + 1));
		int esquiveWolverine = (int) (Math.random() * 100) + 1;

		System.out.println("\n--- PV Deadpool: " + deadpool.getVida() + " ---");
		System.out.println("--- PV Wolverine: " + wolverine.getVida() + " ---");
		if (!deadpool.getRegeneracion()) {
			System.out.println("\nDeadpool ataca...");
			if (esquiveWolverine < 81) {
				System.out.println("¡Causó " + ataqueDeadpool + " puntos de daño!");
				wolverine.setVida(wolverine.getVida() - ataqueDeadpool);
				if (ataqueDeadpool == maxDead) {
					System.out.println("¡Wow! ¡Le hizo el daño máximo!");
					wolverine.setRegeneracion(true);
				}
			} else {
				System.out.println("¡Wolverine esquivó el ataque!");
			}
		} else {
			System.out.println("\nDeadpool recibió el daño máximo y necesita recuperarse este turno");
			deadpool.setRegeneracion(false);
		}

		try {
			Thread.sleep(1000);
		} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void ataqueWolverine(Personaje wolverine, Personaje deadpool) {

		int min = 10;
		int maxWolve = 120;
		int ataqueWolverine = min + (int) (Math.random() * ((maxWolve - min) + 1));
		int esquiveDeadpool = (int) (Math.random() * 100) + 1;

		System.out.println("\n--- PV Deadpool: " + deadpool.getVida() + " ---");
		System.out.println("--- PV Wolverine: " + wolverine.getVida() + " ---");
		if (!wolverine.getRegeneracion()) {
			System.out.println("\nWolverine ataca...");
			if (esquiveDeadpool < 76) {
				System.out.println("¡Causó " + ataqueWolverine + " puntos de daño!");
				deadpool.setVida(deadpool.getVida() - ataqueWolverine);
				if (ataqueWolverine == maxWolve) {
					System.out.println("¡Wow! ¡Le hizo el daño máximo!");
					deadpool.setRegeneracion(true);
				}
			} else {
				System.out.println("¡Deadpool esquivó el ataque!");
			}
		} else {
			System.out.println("\nWolverine recibió el daño máximo y necesita recuperarse este turno");
			wolverine.setRegeneracion(false);
		}

		try {
			Thread.sleep(1000);
		} catch (IllegalArgumentException | InterruptedException e) {
			e.printStackTrace();
		}
	}

}
