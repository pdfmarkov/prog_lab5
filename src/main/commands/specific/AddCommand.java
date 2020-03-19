package main.commands.specific;

import com.google.gson.JsonSyntaxException;
import main.commands.Command;
import main.entity.WrongPersonException;
import main.entity.Person;
import main.entity.Persons;

import java.util.Scanner;

public class AddCommand extends Command {

	public AddCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		Scanner scanner = new Scanner(System.in);
		if (args.length != 0) {
			System.err.println("В команде " + getName() + " не должно быть параметров");
		} else {
			try {
				persons.add(Person.parsePerson(Person.fillPerson(scanner).toJSON()));
			}  catch (WrongPersonException e) {
				System.err.println("Не удалось добавить Person в коллекцию");
			}  catch (JsonSyntaxException e) {
				System.err.println("Ошибка JSON синтаксиса");
			}
		}
	}

}
