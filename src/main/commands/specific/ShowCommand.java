package main.commands.specific;

import main.commands.Command;
import main.entity.Person;
import main.entity.Persons;


public class ShowCommand extends Command {
	public ShowCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		if (args.length != 0) {
			System.err.println("В команде " + getName() + " не должно быть параметров");
		} else if(persons.isEmpty()){
			System.out.println("Коллекция пустая. Данные внутри файла отсутствуют!");
		}
		else {
		for (Person person : persons) {
			System.out.println(person.toString());
		}
		}
	}
}
