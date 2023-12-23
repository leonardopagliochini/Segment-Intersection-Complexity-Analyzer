import java.util.Random;

public class QuickSorter extends Sorter {

	public QuickSorter() {
		super("QuickSort");
	}

	@Override
	public void sort(double [] dati) {
		Random generator = new Random();
		int n = dati.length;  // numero di elementi
		qSortRic(dati,0, generator.nextInt(n-2)+1);

	}

	private void qSortRic(double[] dati, int p, int r){
		if (p<r){//se ci sono almeno due elementi
			int q = partition(dati,p,r); // partiziona
			qSortRic(dati,p, q-1); // ordina da p a q-1
			qSortRic(dati,q+1, r); // ordina da q+1 a r
		}
	}

	protected int partition(double[] dati, int p, int r){
		double x = dati[r];
		int i = p-1;
	
		for (int j = p; j<=r-1; j++)
			if (dati[j]<=x){
				i = i + 1;
				scambia(dati,i, j);
			}
	
		scambia(dati,i+1, r);
		return i+1;
	}

}
