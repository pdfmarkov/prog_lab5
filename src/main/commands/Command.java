package main.commands;

import main.entity.Persons;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public abstract class Command {
	protected static ArrayList<Command> commands = new ArrayList<>();
	protected Persons persons;
	private String signature;
	private String description;

	public Command(Persons persons) {
		this.persons = persons;
	}

	/**
	 * Считвыает имя команды из строки
	 *
	 * @param command строка, которая содержит имя команды
	 * @return имя команды
	 */
	public static String parseName(String command) {
		return command.split(" ")[0];
	}

	/**
	 * Считывает параметры команды из строки
	 *
	 * @param args строка, которая содержит параметры команды
	 * @return параметры команды
	 */
	public static String[] parseArgs(String args) {
		String[] splitted = args.split(" ", 2);
		return splitted.length > 1 ? splitted[1].split(" ") : new String[]{};
	}

	/**
	 * Возвращает команду по ее имени
	 *
	 * @param name имя команды
	 * @return Command
	 * @throws NoSuchFieldException В случае если команда будет не найдена
	 */
	public static Command getCommand(String name) throws NoSuchFieldException {
		for (Command cmd : commands) {
			if (cmd.getName().equals(name)) {
				return cmd;
			}
		}
		throw new NoSuchFieldException("Команда '" + name + "' не была инициализирована.");
	}

	/**
	 * @return имя команды
	 */
	public String getName() {
		return signature.split(" ")[0];
	}

	public static void initCommand(Persons persons, String signature, String description, Class<? extends Command> clazz)
					throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
		Command command = clazz.getConstructor(Persons.class).newInstance(persons);
		command.signature = signature;
		command.description = description;
		commands.add(command);
	}

	@Override
	public String toString() {
		return signature + " - " + description;
	}

	public abstract void execute(String... args) throws IOException, NoSuchFieldException;
}
