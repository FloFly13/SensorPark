
/**
 * Created by flofly on 22/12/2017.
 */
public class Sensor  {
    private int id;
    private int range;
    private int rate;
    private String opt;
    private int etat;
    private int oldEtat;

    public Sensor(int id, int range, int rate, String opt, int etat, int oldEtat) {
        this.id = id;
        this.range = range;
        this.rate = rate;
        this.opt = opt;
        this.etat = etat;
        this.oldEtat = oldEtat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getOpt() {
        return opt;
    }

    public void setOpt(String opt) {
        this.opt = opt;
    }




    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getOldEtat() {
        return oldEtat;
    }

    public void setOldEtat(int oldEtat) {
        this.oldEtat = oldEtat;
    }
}
