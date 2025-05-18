import java.util.ArrayList;

public class Tavalier extends Piece {

    public Tavalier(){
        super('B', new Position());
    }

    public Tavalier(char couleur, Position position){ 
        super(couleur, position);
    }

    public Boolean positionExiste(ArrayList<Position> liste, Position p_){
        for(Position p: liste){
            if(p.equals(p_))
                return true;
        }

        return false;
    }


    public String getType(){
        return new String("tavalier");
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pa1){
        ArrayList<Position> liste = new ArrayList<Position>();
        liste.addAll(getDeplacementPossibleTour(pa1));

        for(Position p: getDeplacementPossibleCavalier(pa1)){
            if(!positionExiste(liste, p))
                liste.add(p);
        }

        return liste;
    }

    public ArrayList<Position> getDeplacementPossibleTour(Plateau pl){
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();

        // Dans les 4 directions

        //Vers le bas
        boolean obstacle = false;
        int indiceX = positionDepartX;
        int indiceY = positionDepartY-1;
        while(!obstacle && indiceY>=0){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else{
            obstacle = true;
            if(pi.getCouleur() != this.getCouleur())
                liste.add(new Position(indiceX, indiceY));
            }
            indiceY = indiceY-1;
        }
        //Vers le haut
        obstacle = false;
        indiceX = positionDepartX;
        indiceY = positionDepartY+1;
        while(!obstacle && indiceY<=7){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else{
            obstacle = true;
            if(pi.getCouleur() != this.getCouleur())
                liste.add(new Position(indiceX, indiceY));
            }
            indiceY = indiceY+1;
        }

        //Vers la gauche
        obstacle = false;
        indiceX = positionDepartX-1;
        indiceY = positionDepartY;
        while(!obstacle && indiceX>=0){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else{
            obstacle = true;
            if(pi.getCouleur() != this.getCouleur())
                liste.add(new Position(indiceX, indiceY));
            }
            indiceX = indiceX-1;
        }
        //Vers le haut
        obstacle = false;
        indiceX = positionDepartX+1;
        indiceY = positionDepartY;
        while(!obstacle && indiceX<=7){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else{
            obstacle = true;
            if(pi.getCouleur() != this.getCouleur())
                liste.add(new Position(indiceX, indiceY));
            }
            indiceX = indiceX+1;
        }

        return liste;
    }

    public ArrayList<Position> getDeplacementPossibleCavalier(Plateau pl)
    {
        ArrayList<Position> liste = new ArrayList<Position>();
        int positionDepartX = this.getPosition().getX();
        int positionDepartY = this.getPosition().getY();
        

        // . . . . .
        // . . . . .
        // . . C . .
        // X . . . .
        // . . . . .
        int indiceX = positionDepartX-2;
        int indiceY = positionDepartY-1;
        if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }

        // . . . . .
        // X . . . .
        // . . C . .
        // . . . . .
        // . . . . .
        indiceX = positionDepartX-2;
        indiceY = positionDepartY+1;
        if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }

        // . X . . .
        // . . . . .
        // . . C . .
        // . . . . .
        // . . . . .
        indiceX = positionDepartX-1;
        indiceY = positionDepartY+2;
        if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }

        // . . . X .
        // . . . . .
        // . . C . .
        // . . . . .
        // . . . . .
        indiceX = positionDepartX+1;
        indiceY = positionDepartY+2;
        if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }

        // . . . . .
        // . . . . X
        // . . C . .
        // . . . . .
        // . . . . .
        indiceX = positionDepartX+2;
        indiceY = positionDepartY+1;
        if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }

        // . . . . .
        // . . . . .
        // . . C . .
        // . . . . X
        // . . . . .
        indiceX = positionDepartX+2;
        indiceY = positionDepartY-1;
        if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }

        // . . . . .
        // . . . . .
        // . . C . .
        // . . . . .
        // . . . X .
        indiceX = positionDepartX+1;
        indiceY = positionDepartY-2;
        if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }

        // . . . . .
        // . . . . .
        // . . C . .
        // . . . . .
        // . X . . .
        indiceX = positionDepartX-1;
        indiceY = positionDepartY-2;
        if((indiceX >= 0) && (indiceX < 8) && (indiceY >= 0) && (indiceY < 8)){
            Piece pi = pl.getCase(indiceX, indiceY);
            if(pi == null)
            liste.add(new Position(indiceX, indiceY));
            else if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }

        return liste;
    }
}
