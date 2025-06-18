package Modeller;

public class Vechicle {
    private String vechicleNumber;
    private VechicleType vechicletype;

    public Vechicle(String vechicleNumber, VechicleType vechicletype) {
        this.vechicleNumber = vechicleNumber;
        this.vechicletype = vechicletype;
    }

    public String getVechicleNumber() {
        return vechicleNumber;
    }

    public void setVechicleNumber(String vechicleNumber) {
        this.vechicleNumber = vechicleNumber;
    }

    public VechicleType getVechicletype() {
        return vechicletype;
    }

    public void setVechicletype(VechicleType vechicletype) {
        this.vechicletype = vechicletype;
    }
}


