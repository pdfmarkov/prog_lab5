package main.commands.specific;

import com.google.gson.JsonSyntaxException;
import main.commands.Command;
import main.entity.WrongPersonException;
import main.entity.Person;
import main.entity.Persons;

import java.util.Iterator;
import java.util.Scanner;

public class RemoveGreaterCommand extends Command {
	public RemoveGreaterCommand(Persons persons) {
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
			Person person = null;
			try {
				person = Person.parsePerson(Person.fillPerson(scanner).toJSON());
			} catch (WrongPersonException e) {
				System.err.println("Не удалось добавить Person");
			}  catch (JsonSyntaxException e) {
				System.err.println("Ошибка JSON синтаксиса");
			}
			Iterator<Person> iter = persons.iterator();
			while (iter.hasNext()) {
				Person p = iter.next();
				if (p.getId() > person.getId()) {
					persons.remove(p);
					iter = persons.iterator();
				}
			}

			System.out.println("Были удалены все элементы со значением выше " + person.getId());
		}
	}
}
