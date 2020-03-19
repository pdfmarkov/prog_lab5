package main.commands.specific;

import main.commands.Command;
import main.entity.Location;
import main.entity.Person;
import main.entity.Persons;

import java.util.Scanner;

public class CountGreaterThanLocationCommand extends Command {
	public CountGreaterThanLocationCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		Scanner scanner = new Scanner(System.in);
		if (args.length != 0) {
			System.err.println("В команде " + getName() + " не должно быть параметров");
		} else if (persons.isEmpty()) {
			System.err.println("Команда не может быть выполнена, т.к. коллекция пуста. Добавьте элементы в коллекцию с помощью команды add");
		}else {
			Location location = Location.parseLocation(Location.fillLocation(scanner).toJSON());
			int counter = 0;

			for (Person person : persons) {
				if (person.getLocation().length() > location.length()) {
					counter++;
				}
			}

			System.out.println("Количество элементов большее заданного: " + counter);
		}
	}
}
