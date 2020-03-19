package main.commands.specific;

import main.commands.Command;
import main.entity.Person;
import main.entity.Persons;
import main.entity.SameIdException;
import org.omg.CosNaming.NamingContextPackage.NotFound;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class UpdateCommand extends Command {

	public UpdateCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(Arrays.toString(args));
		if (args.length != 1) {
			System.err.println("В команде " + getName() + " должно быть 1 параметр");
		} else if (persons.isEmpty()) {
			System.err.println("Команда не может быть выполнена, т.к. коллекция пуста. Добавьте элементы в коллекцию с помощью команды add");
		} else {
			try {
				Integer id = Integer.parseInt(args[0]);
				int i=0;
				for (Person p : persons) if (id == p.getId()) i++;
				if (i==0) System.out.println("Не существует элемента с таким индетификатором");
				else persons.update(id, Person.parsePerson(Person.fillPerson(scanner).toJSON()));
			} catch (NotFound notFound) {
				System.err.println("Не существует элемента с таким индетификатором");
			} catch (Exception e) {
				System.err.println("Вы ввели данные не верно.");
			}
		}
	}
}
