package main.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;

public enum Country {
	UNITED_KINGDOM, VATICAN, ITALY;

	/**
	 * Заполняет объект данными полученные из консоли
	 *
	 * @param scanner
	 * @return Country
	 */
	static Country fillCountry(Scanner scanner) {
		while (true) {
			System.out.println("Введите одно из значений: uk, vatican, italy");
			String color = scanner.nextLine().trim();
			switch (color) {
				case "":
					return null;
				case "uk":
					return UNITED_KINGDOM;
				case "vatican":
					return VATICAN;
				case "italy":
					return ITALY;
				default:
					System.err.println("Вы ввели несуществующее значение.");
			}
		}
	}

	/**
	 * Заполняет объект данными, полученные из файла
	 *
	 * @param scanner
	 * @return Country
	 * @throws IOException В случае ошибки в файле
	 */
	static Country fillCountryFromFile(Scanner scanner) throws IOException {
		String color = scanner.nextLine().trim();
		switch (color) {
			case "":
				return null;
			case "uk":
				return UNITED_KINGDOM;
			case "vatican":
				return VATICAN;
			case "italy":
				return ITALY;
			default:
				throw new IOException("Вы ввели неверные данные.");
		}
	}


}
