package main.commands.specific;

import com.google.gson.JsonSyntaxException;
import main.commands.Command;
import main.entity.WrongPersonException;
import main.entity.Person;
import main.entity.Persons;

import java.util.Scanner;

public class AddIfMinCommand extends Command {
	public AddIfMinCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		Scanner scanner = new Scanner(System.in);
		if (args.length != 0) {
			System.err.println("В команде " + getName() + " не должно быть параметров");
		} else if (persons.isEmpty()) {
			System.err.println("Элемент не может быть добавлен, т.к. коллекция пуста. Добавьте элементы в коллекцию с помощью обычной команды add");
		} else {
				Person person = null;
			try {
				person = Person.parsePerson(Person.fillPerson(scanner).toJSON());
			} catch (WrongPersonException e){
				System.err.println("Не удалось добавить Person");
			}
			long min = Long.MAX_VALUE;
				for (Person p : persons) {
					if (p.getId() < min) {
						min = p.getId();
					}
				}

				if (min > person.getId()) {
					persons.add(person);
					System.out.println("Элемент добавлен, так как его значение " + person.getId() + " меньше чем минимальное " + min);
				} else {
					System.out.println("Элемент не добавлен, так как его значение " + person.getId() + " больше или равно минимальному " + min);
				}
			}
		}
	}

