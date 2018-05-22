package entity;

public enum ZaalType {
    BREUGHELZAAL("Breughel zaal"),
    CARDIJNZAAL("Cardijn zaal"),
    FEESTZAAL("Feest zaal"),
    KEUKEN("Keuken"),
    RECEPTIEZAAL("Receptie zaal"),
    KLEINEKEUKEN("Kleine keuken");

    private String zaalType;

    ZaalType(String zaalType){
        this.zaalType = zaalType;
    }

    public String getZaalType(){
        return zaalType;
    }
}
