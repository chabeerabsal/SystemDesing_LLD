package Modeller;

public class Vehicle {
    private String vechicleNumber;
    private VehicleType vechicletype;

    public Vehicle(String vechicleNumber, VehicleType vechicletype) {
        this.vechicleNumber = vechicleNumber;
        this.vechicletype = vechicletype;
    }

    public String getVechicleNumber() {
        return vechicleNumber;
    }

    public void setVechicleNumber(String vechicleNumber) {
        this.vechicleNumber = vechicleNumber;
    }

    public VehicleType getVechicletype() {
        return vechicletype;
    }

    public void setVechicletype(VehicleType vechicletype) {
        this.vechicletype = vechicletype;
    }
}


