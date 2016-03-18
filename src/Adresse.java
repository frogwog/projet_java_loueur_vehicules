public class Adresse {

    private int numero;
    private String rue;
    private int CP;
    public String ville;

    public Adresse (int num, String rue, int CP, String ville) {
        this.numero = num;
        this.rue = rue;
        this.CP = CP;
        this.ville = ville;
    }

    public int getNumero()
    {
        return numero;
    }

    public String getRue()
    {
        return rue;
    }

    public int getCP()
    {
        return CP;
    }

    public String getVille()
    {
        return ville;
    }

    public void setNumero(int num)
    {
        this.numero = num;
    }

    public void setRue(String rue)
    {
        this.rue = rue;
    }

    public void setCP(int CP)
    {
        this.CP = CP;
    }

    public void setVille(String ville)
    {
        this.ville = ville;
    }

}
