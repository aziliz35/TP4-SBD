
public class Laplace {

	private double e;
	private boolean test;
	private double budget;


	public Laplace(double e, boolean test){
		this.e = e;
		this.test = test;
		this.budget=e;
	}


	public double getE() {
		return e;
	}


	public void setE(double e) {
		this.e = e;
	}


	public boolean isTest() {
		return test;
	}


	public void setTest(boolean test) {
		this.test = test;
	}


	public double getBudget() {
		return budget;
	}


	public void setBudget(double budget) {
		this.budget = budget;
	}


	static double randomWithRange(double min, double max)
	{
		double range =  ((max - min) * 1);     
		return (double)(Math.random() * range) + min;
	}


	public double genNoise(int sensibilite, double b){
		double bruit=0;

		if(this.budget>=0){
			if(!test)
			{
				this.budget -= b;
			}
			double lambda = sensibilite/this.getE();
			double u=randomWithRange(-0.5,0.5);
			double ln=1-2*Math.abs(u);
			double signu =Math.signum(u);
			bruit=-lambda*signu*Math.log(ln);
		}
		return bruit;

	}

}


