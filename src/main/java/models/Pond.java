package models;

public class Pond
{

    private static final int POND_SIZE = 6;

    private Field[] fieldsInPond;

    public Pond()
    {
        this.fieldsInPond = new Field[POND_SIZE];
    }

    public Field[] getFieldsInPond()
    {
        return fieldsInPond;
    }
}
