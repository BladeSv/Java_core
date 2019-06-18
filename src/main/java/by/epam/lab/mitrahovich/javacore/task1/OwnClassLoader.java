package by.epam.lab.mitrahovich.javacore.task1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OwnClassLoader extends ClassLoader {

	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {

		File file = new File(name + ".class");
		if (!file.isFile()) {
			throw new ClassNotFoundException();
		}
		try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
			byte b[] = new byte[(int) file.length()];

			is.read(b);

			return defineClass(name, b, 0, b.length);

		} catch (IOException e) {

			return super.findClass(name);
		}

	}

}
