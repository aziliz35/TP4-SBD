import java.util.Arrays;


public class LaunchMe {

	public LaunchMe() {

	}


	static double randomWithRange(int min, int max)
	{
		int range =  ((max - min) * 1);     
		return (double)(Math.random() * range) + min;
	}

	public static int[] tableauInt(int n, int max)
	{
		int tab[] = new int[n];

		for(int i=0; i<n;i++){
			double var= randomWithRange(0,max);
			tab[i]= (int) Math.round(var);
		}
		return tab;
	}

	private static int count(int[] tab) {
		int max =50;
		int count = 0;
		for(int i=0; i<tab.length;i++){

			if(tab[i] > max/2){
				count++;
			}

		}
		return count;
	}

	public static void main(String[] args)  {



		Laplace lplc=new Laplace(0.01, false);
		double conf=0.01;
		double laplace=lplc.genNoise(1,conf);


		System.out.println("resultat ="+laplace); 


		//---------------------------QUESTION 5-----------------------------------
		System.out.println("Question 5 : ");

		//tableau 1
		int tab1[] = tableauInt(10,50);
		double e1 = 1000;
		Laplace laplace1 = new Laplace(e1,false);
		int count1= count(tab1);
		double bruit1 = laplace1.genNoise(1,e1 );
		System.out.println("Test sur tableau 1 : ");		
		System.out.println(" Count avec valeur non perturbée = " + count1);
		System.out.println("Pour un bruit = " + bruit1 + " le count = " + (count1+bruit1));

		//tableau 2
		int tab2[] = tableauInt(100,50);  
		double e2 = 1;
		Laplace laplace2 = new Laplace(e2,false);
		int count2= count(tab2);
		double bruit2 = laplace2.genNoise(1,e2 );
		System.out.println("Test sur tableau 2 : ");		
		System.out.println(" Count avec valeur non perturbée = " + count2);
		System.out.println("Pour un bruit = " + bruit2 + " le count = " + (count2+bruit2));

		//tableau 3
		int tab3[] = tableauInt(100,50);
		double e3 = 0.001;
		Laplace laplace3 = new Laplace(e3,false);
		int count3= count(tab3);
		double bruit3 = laplace3.genNoise(1,e3 );
		System.out.println("Test sur tableau 3 : ");		
		System.out.println(" Count avec valeur non perturbée = " + count3);
		System.out.println("Pour un bruit = " + bruit3 + " le count = " + (count3+bruit3));
	}




}
