// Favalier est la fusion des deplacements possibles du FOU et du CAVALIER
// Une pièce qui se placera à la place des pions devant la dame et le roi

import java.util.ArrayList;


public class Favalier extends Piece{

    public Favalier(){
        super('B', new Position());
    }

    public Favalier(char couleur, Position position){
        super(couleur, position);
    }


    public String getType(){
        return new String("favalier");
    }

    public ArrayList<Position> getDeplacementPossible(Plateau pl){
        ArrayList<Position> liste = new ArrayList<Position>();
        liste.addAll(getDeplacementPossible1(pl));

        for (Position p_: getDeplacementPossible2(pl)){
            if (!positionExiste(liste, p_))
                liste.add(p_);
        }
        return liste;

    }
        

    public Boolean positionExiste(ArrayList<Position> liste, Position p){
        for (Position p_: liste){
            if (p.equals(p_))
            return true;
        }
        return false;
    }
  

    public ArrayList<Position> getDeplacementPossible1(Plateau pl)
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

    public ArrayList<Position> getDeplacementPossible2(Plateau pl)
    {
    ArrayList<Position> liste = new ArrayList<Position>();
    int positionDepartX = this.getPosition().getX();
    int positionDepartY = this.getPosition().getY();


    // Dans les 4 directions

    //Vers le haut-gauche
    boolean obstacle = false;
    int indiceX = positionDepartX - 1;
    int indiceY = positionDepartY + 1;
    while(!obstacle && (indiceX >= 0) && (indiceY < 8)){
        Piece pi = pl.getCase(indiceX, indiceY);
        if(pi == null)
        liste.add(new Position(indiceX, indiceY));
        else{
        obstacle = true;
        if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }
        indiceX = indiceX - 1;
        indiceY = indiceY + 1;
    }
    //Vers le bas-gauche
    obstacle = false;
    indiceX = positionDepartX - 1;
    indiceY = positionDepartY - 1;
    while(!obstacle && (indiceX >= 0) && (indiceY >= 0)){
        Piece pi = pl.getCase(indiceX, indiceY);
        if(pi == null)
        liste.add(new Position(indiceX, indiceY));
        else{
        obstacle = true;
        if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }
        indiceX = indiceX - 1;
        indiceY = indiceY - 1;
    }
    //Vers le haut-droite
    obstacle = false;
    indiceX = positionDepartX + 1;
    indiceY = positionDepartY + 1;
    while(!obstacle && (indiceX < 8) && (indiceY < 8)){
        Piece pi = pl.getCase(indiceX, indiceY);
        if(pi == null)
        liste.add(new Position(indiceX, indiceY));
        else{
        obstacle = true;
        if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }
        indiceX = indiceX + 1;
        indiceY = indiceY + 1;
    }
    //Vers le bas-droite
    obstacle = false;
    indiceX = positionDepartX + 1;
    indiceY = positionDepartY - 1;
    while(!obstacle && (indiceX < 8) && (indiceY >= 0)){
        Piece pi = pl.getCase(indiceX, indiceY);
        if(pi == null)
        liste.add(new Position(indiceX, indiceY));
        else{
        obstacle = true;
        if(pi.getCouleur() != this.getCouleur())
            liste.add(new Position(indiceX, indiceY));
        }
        indiceX = indiceX + 1;
        indiceY = indiceY - 1;
    }

    return liste;
    }
}