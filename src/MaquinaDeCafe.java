public class MaquinaDeCafe {

    private Cafetera cafetera;

    Vaso vasosPequeno;
    Vaso vasosMediano;
    Vaso vasosGrande;

    private Azucarero azucarero;

    public Cafetera getCafetera() {
        return cafetera;
    }

    public void setCafetera(Cafetera cafetera) {
        this.cafetera = cafetera;
    }

    public Vaso getVasosPequeno() {
        return vasosPequeno;
    }

    public void setVasosPequeno(Vaso vasosPequeno) {
        this.vasosPequeno = vasosPequeno;
    }

    public Vaso getVasosMediano() {
        return vasosMediano;
    }

    public void setVasosMediano(Vaso vasosMediano) {
        this.vasosMediano = vasosMediano;
    }

    public Vaso getVasosGrande() {
        return vasosGrande;
    }

    public void setVasosGrande(Vaso vasosGrande) {
        this.vasosGrande = vasosGrande;
    }

    public Azucarero getAzucarero() {
        return azucarero;
    }

    public void setAzucarero(Azucarero azucarero) {
        this.azucarero = azucarero;
    }

    public Vaso getTipoDeVaso(String tipoDeVaso) {

        if (tipoDeVaso.equalsIgnoreCase("pequeno")) {
            return vasosPequeno;
        }

        if (tipoDeVaso.equalsIgnoreCase("mediano")) {
            return vasosMediano;
        }

        if (tipoDeVaso.equalsIgnoreCase("grande")) {
            return vasosGrande;
        }

        return null;
    }

    public String getVasoDeCafe(
            Vaso tipoDeVaso,
            int cantidadVasos,
            int cantidadAzucar) {

        if (!tipoDeVaso.hasVasos(cantidadVasos)) {
            return "No hay Vasos";
        }

        int cantidadCafe =
                tipoDeVaso.getContenido() * cantidadVasos;

        if (!cafetera.hasCafe(cantidadCafe)) {
            return "No hay Cafe";
        }

        if (!azucarero.hasAzucar(cantidadAzucar)) {
            return "No hay Azucar";
        }

        tipoDeVaso.giveVasos(cantidadVasos);

        cafetera.giveCafe(cantidadCafe);

        azucarero.giveAzucar(cantidadAzucar);

        return "Felicitaciones";
    }

}
