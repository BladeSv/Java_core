package by.epam.lab.mitrahovich.javacore.task1;

import java.util.ArrayList;
import java.util.List;

public class MainApp {

	public MainApp() {

	}

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		OwnClassLoader classLoader = new OwnClassLoader();
		List<Animal> animals = new ArrayList();

		Class cat = classLoader.findClass("Cat");
		Class dog = classLoader.findClass("Dog");

		animals.add((Animal) cat.newInstance());
		animals.add((Animal) dog.newInstance());

		animals.forEach((e) -> {
			e.Play();
			e.Voice();
		});

	}

}
