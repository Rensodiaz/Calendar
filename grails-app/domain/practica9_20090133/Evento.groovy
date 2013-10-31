package practica9_20090133

class Evento {

    String title;
    Date start;

    static constraints = {
        title(nullable: true);
        start(nullable: true);
    }
}
