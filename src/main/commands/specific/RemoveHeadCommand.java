package main.commands.specific;

import main.commands.Command;
import main.entity.Person;
import main.entity.Persons;

public class RemoveHeadCommand extends Command {
	public RemoveHeadCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		if (args.length != 0) {
			System.err.println("В команде " + getName() + " не должно быть параметров");
		} else if (persons.isEmpty()) {
			System.err.println("Команда не может быть выполнена, т.к. коллекция пуста. Добавьте элементы в коллекцию с помощью команды add");
		}else {
			Person person = persons.poll();
			System.out.println("Удален Person: "+person.toString());
		}
	}
}
