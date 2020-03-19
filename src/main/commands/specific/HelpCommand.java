package main.commands.specific;

import main.commands.Command;
import main.entity.Persons;

public class HelpCommand extends Command {

	public HelpCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) {
		if (args.length != 0) {
			System.err.println("В команде " + getName() + " не должно быть параметров");
		} else {
			StringBuilder builder = new StringBuilder();

			for (Command cmd : commands) {
				builder.append(cmd.toString()).append("\n");
			}

			System.out.println(builder.toString().trim());
		}
	}
}
