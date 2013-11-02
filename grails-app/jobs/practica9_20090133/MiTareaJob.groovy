package practica9_20090133

import evento.EventosService


class MiTareaJob {

    EventosService eventService = new EventosService();
    static triggers = {
        //cron name: 'miTrigger', cronExpression: "0 1 6-7 ? * FRI";
        //cron name: 'cronTrigger', cronExpression: "0 0 2 ? * MON-FRI"
        simple name: 'mySimpleTrigger', startDelay: 15000
    }

    def execute() {
        eventService.sendTaskReminders()
        log.info("Task reminders sent on ${new Date()}")
    }
}