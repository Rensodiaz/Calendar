import practica9_20090133.Evento

class BootStrap {

    def init = { servletContext ->

        new Evento(title: "Reunion de proyecto", start: new Date()).save(failOnError: true)
    }
    def destroy = {
    }
}
