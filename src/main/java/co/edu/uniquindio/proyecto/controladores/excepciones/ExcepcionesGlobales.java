package co.edu.uniquindio.proyecto.controladores.excepciones;

import co.edu.uniquindio.proyecto.dto.MensajeDTO;
import co.edu.uniquindio.proyecto.dto.ValidacionDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ExcepcionesGlobales {
    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeDTO<String>> generalException(Exception e){
        return ResponseEntity.internalServerError().body( new MensajeDTO<>(true, e.getMessage())
        );
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<MensajeDTO> validationException(MethodArgumentNotValidException ex){
        List<ValidacionDTO> errores = new ArrayList<>();
        BindingResult results = ex.getBindingResult();
        for (FieldError e: results.getFieldErrors()) {
            errores.add( new ValidacionDTO(e.getField(), e.getDefaultMessage()) );
        }
        return ResponseEntity.badRequest().body( new MensajeDTO<>(true, errores) );
    }
}
