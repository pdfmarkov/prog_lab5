package main.commands.specific;

import main.commands.Command;
import main.entity.Persons;
import org.omg.CosNaming.NamingContextPackage.NotFound;

public class RemoveCommand extends Command {
	public RemoveCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		if (args.length != 1) {
			System.err.println("В команде " + getName() + " должен быть 1 параметр");
		} else if (persons.isEmpty()) {
			System.err.println("Команда не может быть выполнена, т.к. коллекция пуста. Добавьте элементы в коллекцию с помощью команды add");
		}else {
			try {
				long id = Long.parseLong(args[0]);
				persons.remove(id);
			} catch (NotFound notFound) {
				System.err.println("Не существует элемента с таким индетификатором");
			} catch (Exception e) {
				System.err.println("Вы ввели данные не верно.");
			}
		}
	}
}
