public class Buero {
    private Queue<Person> _angestellte ;
    public Buero Flur() {
        return new Buero();
    }
    private Buero() {
        _angestellte = new Queue<Person>();
    }

    public void einlassen() {
        _angestellte.dequeue();
    }                              
    public void hintenAnstellen(Person p) {
        _angestellte.enqueue(p);
    }                           
    public void sprechStundeBeenden() {
        while(!_angestellte.isEmpty()) {
            _angestellte.dequeue();
        }
    }                                                                                                                                                                                                    
}