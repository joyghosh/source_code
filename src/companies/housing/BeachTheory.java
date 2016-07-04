package companies.housing;

/***
 * 
 * @author Joy Ghosh
 * 
 * Which building can see the beach?
 */

public class BeachTheory{
    
    public static void main(String []args){
            
            int arr[] = {4, 5, 2, 3, 6};
            int canSeeTheBeach = arr[0]; int howManyCanSee = 1;
            for(int i=1; i<arr.length; i++)
                if(arr[i] > canSeeTheBeach){
                    ++howManyCanSee;
                    canSeeTheBeach = arr[i];
                }
                
            System.out.println("Number of buildings who can see the beach: "+howManyCanSee);
    }
}
