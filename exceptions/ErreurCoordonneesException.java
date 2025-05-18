package exceptions;

public class ErreurCoordonneesException extends Exception {
    private int x;
    private int y;

    public ErreurCoordonneesException(int _x, int _y){
        if(_x < 0 || _x > 7 || _y < 0 || _y > 7 )
            throw new IllegalArgumentException(getMessage());
    }

    public String getMessage(){
        return "X et Y doivent être compris entre 0 et 7.";
    }
}
