package modelos;

public class Data {

    private int dia;
    private int mes;
    private int dataNascimento;

    public Data(int dia, int mes, int dataNascimento) {
        this.dia = dia;
        this.mes = mes;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString(){
        return "" +this.dia + "/" + this.mes + "/" + this.dataNascimento;

    }


}
