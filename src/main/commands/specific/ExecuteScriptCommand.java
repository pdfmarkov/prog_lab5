package main.commands.specific;

import main.commands.Command;
import main.entity.Location;
import main.entity.Person;
import main.entity.Persons;

import java.io.*;
import java.nio.file.NoSuchFileException;
import java.rmi.server.ExportException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ExecuteScriptCommand extends Command {
	public ExecuteScriptCommand(Persons persons) {
		super(persons);
	}

	@Override
	public void execute(String... args) throws IOException, NoSuchFieldException {
		if (args.length != 1) {
			System.err.println("В команде " + getName() + " должен быть 1 параметр");

		} else {
				File file = new File(args[0]);
				if (!file.exists()) System.err.println("Скрипта не существует");
				else if (file.exists() && !file.canRead()) System.err.println("Скрипт невозможно прочитать, проверьте права файла(права на чтение)");
				else if (file.exists() && !file.canExecute()) System.err.println("Скрипт невозможно выполнить, проверьте права файла (права на выполнение)");
				else {
				Scanner scanner = new Scanner(file);
				while (scanner.hasNextLine()) {
					String line = scanner.nextLine().trim();
					List<String> collection = Arrays.asList(line.split(" "));
					if (collection.get(0).equals("execute_script")) {
						if (!persons.isEmpty()) {
							Command cmd = Command.getCommand(Command.parseName(collection.get(0)));
							cmd.execute(collection.get(1));
						} else System.err.println("Коллекция пустая, рекурсия прервалась");
					} else {
						Command cmd = Command.getCommand(Command.parseName(line));
						String[] arg = Command.parseArgs(line);
						cmd.execute(arg);
					}
				}
				}
			}
		}
}

