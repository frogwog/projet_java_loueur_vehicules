/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 20120032
 */
public class Date {
    private static String[] MOIS =
    {
        "January", "February", "March", 
        "April", "May", "June", "July", 
        "August", "September", "October", 
        "November", "December"
    };

    public static String getMoisIndex(int index)
    {
        try
        {
            return MOIS[index];
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            return null;
        }
    }


    /**
     * *******************************************************
     *
     * Object-level variables and methods
     *
     ********************************************************
     */
    private int jour;
    private String mois;
    private int annee;


    public Date(int jour, String mois, int annee)
    {
        this.jour = jour;
        this.mois = mois;
        this.annee = annee;
    }

    public String getMois()
    {
        return mois;
    }

    public int getJour()
    {
        return jour;
    }

    public int getAnnee()
    {
        return annee;
    }

    public void setJour(int jour)
    {
        this.jour = jour;
    }

    public void setMoisIndex(int index) throws Exception
    {
        try
        {
            this.mois = getMoisIndex(index);
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            throw new Exception("Invalid index for month: " + index);
        }
    }

    public void setAnnee(int annee)
    {
        this.annee = annee;
    }
    
    @Override
    public String toString()
    {
        return String.format("%2d %s %-2d", jour, mois, annee);
    }
}
    
    
}
