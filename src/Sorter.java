public abstract class Sorter {
	
	protected String name;
	
	public Sorter(String name){
		this.name=name;
	}
	
	/* metodo ausiliario per lo scambio di due elementi di un array */
	protected void scambia(double[] dati, int i, int j){
		double temp = dati[i];
		dati[i] = dati[j];
		dati[j] = temp;
	}
	
	public abstract void sort(double[] dati);
	
	public String getName(){
		return name;
	}

}
