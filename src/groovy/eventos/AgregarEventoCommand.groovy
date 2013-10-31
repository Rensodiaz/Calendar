package eventos

/**
 * Created with IntelliJ IDEA.
 * User: Renso
 * Date: 10/28/13
 * Time: 8:53 PM
 * To change this template use File | Settings | File Templates.
 */
@grails.validation.Validateable
class AgregarEventoCommand {
    String titulo;
    Date fechaInicio;

    static constraints={
        titulo(nullable: false);
        fechaInicio(nullable: false);
    }
}
