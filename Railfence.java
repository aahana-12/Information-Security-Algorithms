package ISPractical;

public class Railfence {

    public static char[][] encrypt(String text,int key){
      int col = text.length();
      int row = key;
      boolean check = false;
      int j=0;
      char[][] rail = new char[row][col];
       //fill the rail
      for(int i=0;i<row;i++){
          for(int k=0;k<col;k++){
              rail[i][k]='*';
          }
      }

      for(int i=0;i<col;i++){
          if(j==0||j==key-1) check=!check ;
          rail[j][i]=text.charAt(i);

          if(check)
              j++;
          else j--;
      }
      //print rails for visualisation
      for(int i=0;i<row;i++){
          for(int k=0;k<col;k++){
              System.out.print(" "+rail[i][k]);
          }
          System.out.println();
      }

      String enc ="";
        for(int i=0;i<row;i++){
            for(int k=0;k<col;k++){
                if(rail[i][k]!='*'){
                    enc += rail[i][k]+"";
                }
            }

        }
         System.out.println("The encrypted text is "+enc);

      return rail;
    }

    public static String decrypt(char[][] rails,int key){
        String text ="";
        int col = rails[0].length;
         int j=0;
         boolean check=false;
         for(int i=0;i<col;i++){
             if(j==0||j==key-1)check=!check;
             text +=rails[j][i];

             if(check)
                 j++;
             else j--;
         }
        return text;
    }

    public static void main(String[] args){
            char[][] ans = encrypt("AMSTERDAM",3);
            //System.out.println(ans);
        String txt = decrypt(ans,3);
        System.out.println(txt);
    }
}
