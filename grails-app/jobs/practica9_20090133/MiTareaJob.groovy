package practica9_20090133



class MiTareaJob {
    static triggers = {
        simple name: 'myTrigger', startDelay: 60000, repeatInterval: 1000
        //simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
        sendMail {
            to "rensodarwin@gmail.com"
            subject "Evento"
            body 'estamos enviando info de eventos'
        }
    }
}
