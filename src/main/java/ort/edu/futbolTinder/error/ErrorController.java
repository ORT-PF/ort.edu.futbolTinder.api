package ort.edu.futbolTinder.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class ErrorController {

    Logger logger = LoggerFactory.getLogger(ErrorController.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorDTO> handleNoHandlerFound(Exception e) {
        logger.error("Not found: ", e);
        return new ResponseEntity<>(new ErrorDTO("La ruta solicitada no existe", HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({MatchDoesntExistException.class})
    public ResponseEntity<ErrorDTO> handleNotFound(Exception e) {
        logger.error("Not found: ", e);
        return new ResponseEntity<>(new ErrorDTO("No se encontró un dato. " + e.getLocalizedMessage(), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({IllegalArgumentException.class, PlayerAlreadyJoinedException.class})
    public ResponseEntity<ErrorDTO> handleBadRequest(Exception e) {
        logger.error("Bad request: ", e);
        return new ResponseEntity<>(new ErrorDTO("Se han recibido datos inválidos. " + e.getLocalizedMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({QuotaExceededException.class})
    public ResponseEntity<ErrorDTO> handleConflict(Exception e) {
        logger.error("Conflict: ", e);
        return new ResponseEntity<>(new ErrorDTO("Conflicto de datos. " + e.getLocalizedMessage(), HttpStatus.CONFLICT.value()), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> handleAll(Exception e) {
        logger.error("Internal Server Error: ", e);
        return new ResponseEntity<>(new ErrorDTO("Error interno. Contacte a un desarrollador", HttpStatus.INTERNAL_SERVER_ERROR.value()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
