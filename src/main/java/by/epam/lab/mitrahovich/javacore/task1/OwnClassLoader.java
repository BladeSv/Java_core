package by.epam.lab.mitrahovich.javacore.task1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class OwnClassLoader extends ClassLoader {

	@Override
	public Class findClass(String name) throws ClassNotFoundException {
		byte[] b = loadClassFromFile(name);
		String packegeName = "by.epam.lab.mitrahovich.javacore.task1.";
		return defineClass(packegeName + name, b, 0, b.length);
	}

	private byte[] loadClassFromFile(String fileName) throws ClassNotFoundException {

		File file = new File("src\\main\\java\\by\\epam\\lab\\mitrahovich\\javacore\\task1\\" + fileName + ".class");
		System.out.println(fileName);
		System.out.println(file.getAbsolutePath());
		if (!file.isFile()) {
			throw new ClassNotFoundException();
		}
		byte[] buffer;

		ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
		try {
			InputStream inputStream = new FileInputStream(file);

			int nextValue = 0;

			while ((nextValue = inputStream.read()) != -1) {
				byteStream.write(nextValue);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffer = byteStream.toByteArray();
		return buffer;
	}

}
