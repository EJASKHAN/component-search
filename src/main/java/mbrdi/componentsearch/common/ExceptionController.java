package mbrdi.componentsearch.common;

import mbrdi.componentsearch.model.ItemsDTO;
import mbrdi.componentsearch.model.PlacesDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Ejaskhan
 * @Date 20 July 2020
 */
@ControllerAdvice
public class ExceptionController extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<PlacesDTO> handleConflict(Exception exception) {
		PlacesDTO placesDTO = new PlacesDTO();
		ItemsDTO itemsDTO = new ItemsDTO();

		String[] message = exception.getMessage().contains("message") ? exception.getMessage().split("message") :
				(exception.getMessage().contains("error_description") ?
						exception.getMessage().split("error_description") : null);

		itemsDTO.setMessage(message != null && message.length > 1 ? message[1].replaceAll
				("[^a-zA-Z0-9']", " ").trim() : exception.getMessage());

		List<ItemsDTO> itemsDTOList = new ArrayList<>();
		itemsDTOList.add(itemsDTO);
		placesDTO.setItemsDTOS(itemsDTOList);
		return new ResponseEntity<>(placesDTO, exception instanceof HttpClientErrorException ?
				((HttpClientErrorException) exception).getStatusCode() :
				HttpStatus.BAD_REQUEST);
	}
}
