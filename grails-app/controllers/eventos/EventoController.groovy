package eventos

import grails.converters.JSON
import practica9_20090133.Evento
import eventos.AgregarEventoCommand;
import evento.EventosService;

class EventoController {
    EventosService event = new EventosService();

    def listaEventos() {
        render Evento.list() as JSON
    }

    def calendario(){

    }

    def gregarEvento(AgregarEventoCommand form){

        if (!event.agregarEvento(form)){
            flash.validacionForm = true;
            flash.mensajeValidacionForm = "INCONVENIENTE: Problemas al agregar el evento.";
            redirect(action: "calendario");
        }else{
            flash.validacionForm = false;
            flash.mensajeValidacionForm = "EVENTO AGREGADO EXITOSAMENTE!.";
            redirect(action: "calendario");
        }
    }
}
