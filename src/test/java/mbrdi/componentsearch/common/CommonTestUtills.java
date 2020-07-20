package mbrdi.componentsearch.common;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
public class CommonTestUtills {

	/**
	 * Read the Json stream and create an object of type T
	 *
	 * @param filename      name of the file
	 * @param typeReference reference object
	 * @return object of type T
	 */
	public static <T> T readObject(String filename, TypeReference<?> typeReference) {

		try {
			InputStream inputStream = getInputStreamByName(filename);
			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
			return (T) objectMapper.readValue(inputStream, typeReference);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	// search both file system and class resources for the file specified in fileName
	private static InputStream getInputStreamByName(String fileName) {
		File file = new File(fileName);
		try {
			return file.exists() ?
					new FileInputStream(fileName) :
					new ClassPathResource(fileName).getInputStream();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Check whether the file exists in the class path or the file system
	 *
	 * @param fileName name of the file
	 * @return true if the file exists
	 */
	public static boolean fileResourceExists(String fileName) {
		return new ClassPathResource(fileName).exists() || new File(fileName).exists();
	}

}
