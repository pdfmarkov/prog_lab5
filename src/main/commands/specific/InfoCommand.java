package main.commands.specific;

import main.commands.Command;
import main.entity.Persons;

public class InfoCommand extends Command {

	public InfoCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		if (args.length != 0) {
			System.err.println("В команде " + getName() + " не должно быть параметров");
		} else {
			System.out.println(persons.toString());
		}
	}
}
