
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author John Vincent
 */
public class Assignment5 {
private BinarySearchTree [] dictionary;
private long found;
private long notFound; 
private long compsFound;
private long compsNotFound;

    public Assignment5(){
    dictionary= new BinarySearchTree[26];
    for (int i = 0; i < dictionary.length; i++)
       dictionary[i] = new BinarySearchTree<String>(); 
    found=0;
    notFound=0;
    compsFound=0;
    compsNotFound=0;    
}
    /**
     *
     * @param fName
     * populates dictionary an array of BinarySearchTree with strings from file fName
     */

        public void populateDictionary(String fName){
        File f=new File(fName);
        try{
            Scanner input = new Scanner(f);           
            while (input.hasNext()){
                   String word = input.next();
                  word=word.toLowerCase();
                  this.dictionary[word.charAt(0)-97].insert(word);
            }//while file
            
            input.close();
        }catch(IOException e){
            System.out.println("file reading failed");
        }//catch
        }//populateDictionary
        
public void spellCheck(String fName){
        int[] count=new int[1];
        File f=new File(fName);
        try{
            Scanner input = new Scanner(f);
            
            while (input.hasNext()){
                String rLine=input.nextLine();
                rLine=rLine.replaceAll("[^A-Za-z' ]", "");
                rLine=rLine.toLowerCase();
                Scanner line = new Scanner(rLine);
                
        while (line.hasNext()) {
            String word = line.next();          
                  count[0]=0;
                 // System.out.println(":           "+word+":");
                  if(!word.isEmpty()){
                  if(word.charAt(0)>96 &&word.charAt(0)<123){
                  if(this.dictionary[word.charAt(0)-97].search(word,count)){
                   found++;                     
                   compsFound+=count[0];
                     // System.out.println("");
                  } else {
                      notFound++;
                      compsNotFound+=count[0];
                     // System.out.println("not");
                  }
                  }}
        }//while line
            }//while file
            input.close();
        }catch(IOException e){
            System.out.println("file reading failed");
        }//catch
        }//spellCheck


    public static void main(String[] args) {
        Assignment5 one=new Assignment5();
        one.populateDictionary("random_dictionary.txt");
        one.spellCheck("oliver.txt");
        System.out.println("Found: "+one.found);
        System.out.println("Not Found: "+one.notFound);
        System.out.printf("Average comparisons for word found: %.2f",(one.compsFound/(double)one.found));
        System.out.printf("\nAverage comparisons for word not found: %.2f",(one.compsNotFound/(double)one.notFound),"\n");   
        System.out.println("");
    }
    
}
