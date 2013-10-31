package evento
import eventos.AgregarEventoCommand;
import practica9_20090133.Evento;

class EventosService {

    boolean agregarEvento(AgregarEventoCommand form) {

        if (new Evento(title: form.titulo, start: form.fechaInicio).save(failOnError: true)){
           return true;
        }else {
            return false;
        }
    }

}
