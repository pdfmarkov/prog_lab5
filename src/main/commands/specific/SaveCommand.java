package main.commands.specific;

import main.commands.Command;
import main.entity.Persons;

public class SaveCommand extends Command {
	public SaveCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		if (args.length != 0) {
			System.err.println("В команде " + getName() + " не должно быть параметров");
		} else {
			persons.save();
		}
	}
}
