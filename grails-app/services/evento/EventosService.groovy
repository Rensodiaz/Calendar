package evento
import eventos.AgregarEventoCommand;
import practica9_20090133.Evento;

class EventosService {

    /*
     Guardar el evento en la base de datos
      */
    boolean agregarEvento(AgregarEventoCommand form) {

        if (new Evento(title: form.titulo, start: form.fechaInicio).save(failOnError: true)){
           return true;
        }else {
            return false;
        }
    }

    /*
        Eviando notificacion en el tiempo indicado
     */
    def sendTaskReminders(){
        def tasks = Evento.findAllByStartGreaterThan(new Date()); //.findAllByDueDateLessThan(new Date())
        tasks.each{task ->
            if (task.Enviado==false){
                sendMail {
                    to "rensodarwin@gmail.com"
                    subject "Notificacion Evento: "+task.title;
                    body """Evento programado para la hora:
                    ${task.start.format("dd-MM-yyy HH:mm")}"""
                }
                task.Enviado=false;
                task.save(failOnError: true);
            }
        }
    }

}
