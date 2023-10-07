import java.util.Scanner;

public class cramerV2 {
    final int [][] A2 = new int[2][2];
    final int [][] A3 = new int[3][3];

    static int controlCount;
    Scanner scanner = new Scanner(System.in);
    public void run(){
        boolean control = equationCount();
        if(control){
            findA();
            findB();
        }
    }
    private boolean equationCount(){
        System.out.print("Denklem sayisini giriniz(2 ve 3 vardir): ");
        int m = scanner.nextInt();

        if(m==2){
            controlCount = 2;
            return true;
        }
        else if(m==3){
            controlCount = 3;
            return true;
        }
        else{
            System.out.println("Hatali Giris!");
            return false;
        }
    }

    private void findA(){
        if(controlCount == 2) {
            System.out.println("2x2 matrisinizin elemanlarını giriniz(a,b | c,d) : ");
            for (int i =0; i<2; i++){
                for (int j=0; j<2;j++){
                    A2[i][j] = scanner.nextInt();
                }
            }

            System.out.print("A2 matrisi : ");
            for(int i = 0; i<2; i++){
                for(int j=0; j<2; j++){
                    System.out.print(A2[i][j] + " ");
                }
                System.out.print("\n\t\t\t");
            }
            System.out.println();
        }
        else{
            System.out.println("3x3 matrisinizin elemanlarını giriniz (a,b,c | d,e,f | g,h,i ) : ");
            for (int i =0; i<3; i++){
                for (int j=0; j<3;j++){
                    A3[i][j] = scanner.nextInt();
                }
            }

            System.out.print("A3 matrisi : ");
            for(int i = 0; i<3; i++){
                for(int j=0; j<3; j++){
                    System.out.print(A3[i][j] + " ");
                }
                System.out.print("\n\t\t\t");
            }
            System.out.println();
        }
    }


    static int[] B2 = new int[2];
    static int[] B3 = new int[3];
    private void findB(){
        if(controlCount==2){
            System.out.println("2x2 matrisinizin b elemanlarını giriniz(b1,b2) : ");
            B2[0] = scanner.nextInt();
            B2[1] = scanner.nextInt();
            findXY();
        }
        else {
            System.out.println("3x3 matrisinizin b elemanlarını giriniz(b1,b2,b3) : ");
            B3[0] = scanner.nextInt();
            B3[1] = scanner.nextInt();
            B3[2] = scanner.nextInt();
            findXYZ();
        }
    }

    private void findXYZ(){
        int [][] X = new int[3][3];
        int [][] Y = new int[3][3];
        int [][] Z = new int[3][3];

        for(int i=0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(i==0){
                    X[j][i] = B3[j];
                }
                else
                    X[j][i] = A3[j][i];
            }
        }

        for(int i=0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(i==1){
                    Y[j][i] = B3[j];
                }
                else
                    Y[j][i] = A3[j][i];
            }
        }

        for(int i=0; i<3; i++){
            for(int j = 0; j<3; j++){
                if(i==2){
                    Z[j][i]= B3[j];
                }
                else
                    Z[j][i] = A3[j][i];
            }
        }
        // yazdıralım
        displayMatrix("X", X);
        displayMatrix("Y", Y);
        displayMatrix("Z", Z);

        System.out.println();
        System.out.println("--- Sonuclar ---");
        //Sarrus Yontemi
        float detResult_X = ((X[0][0]*X[1][1]*X[2][2]) + (X[0][1]*X[1][2]*X[2][0]) + (X[0][2]*X[1][0]*X[2][1])) - ((X[0][2]*X[1][1]*X[2][0]) + (X[0][0]*X[1][2]*X[2][1]) + (X[0][1]*X[1][0]*X[2][2]));
        float detResult_A = ((A3[0][0]*A3[1][1]*A3[2][2]) + (A3[0][1]*A3[1][2]*A3[2][0]) + (A3[0][2]*A3[1][0]*A3[2][1])) - ((A3[0][2]*A3[1][1]*A3[2][0]) + (A3[0][0]*A3[1][2]*A3[2][1]) + (A3[0][1]*A3[1][0]*A3[2][2]));
        float x = detResult_X/detResult_A;
          
        float detResult_Y = ((Y[0][0]*Y[1][1]*Y[2][2]) + (Y[0][1]*Y[1][2]*Y[2][0]) + (Y[0][2]*Y[1][0]*Y[2][1])) - ((Y[0][2]*Y[1][1]*Y[2][0]) + (Y[0][0]*Y[1][2]*Y[2][1]) + (Y[0][1]*Y[1][0]*Y[2][2]));
        float y = detResult_Y/detResult_A;
            
        float detResult_Z = ((Z[0][0]*Z[1][1]*Z[2][2]) + (Z[0][1]*Z[1][2]*Z[2][0]) + (Z[0][2]*Z[1][0]*Z[2][1])) - ((Z[0][2]*Z[1][1]*Z[2][0]) + (Z[0][0]*Z[1][2]*Z[2][1]) + (Z[0][1]*Z[1][0]*Z[2][2]));
        float z = detResult_Z/detResult_A;
            
            if(detResult_A == 0){
                System.out.println("Sonsuz Çözüm vardır veya Çözülemez!");
            }
            else {
                System.out.println("detResult_X : " + detResult_X);
                System.out.println("detResult_A : " + detResult_A);
                System.out.println("x:"+x);

                System.out.println("\ndetResult_Y : " + detResult_Y);
                System.out.println("detResult_A : " + detResult_A);
                System.out.println("y:"+y);

                System.out.println("\ndetResult_Z : " + detResult_Z);
                System.out.println("detResult_A : " + detResult_A);
                System.out.println("z:"+z);
            }

    }

    private void findXY(){

            int[][] X = new int[2][2];
            int[][] Y = new int[2][2];

            // for döngüsüne gerek yok az işlem var
            X[0][0] = B2[0];
            X[1][0] = B2[1];
            X[0][1] = A2[0][1];
            X[1][1] = A2[1][1];

            Y[0][1] = B2[0];
            Y[1][1] = B2[1];
            Y[0][0] = A2[0][0];
            Y[1][0] = A2[1][0];

            System.out.print("\nX : ");
            for (int j=0; j<2; j++){
                for (int k=0; k<2; k++)
                    System.out.print(X[j][k] + " ");
                System.out.print("\n\t");
            }

            System.out.print("\nY : ");
            for (int j=0; j<2; j++) {
                for (int k = 0; k < 2; k++)
                    System.out.print(Y[j][k] + " ");
                System.out.print("\n\t");
            }

            float detResult_X = X[0][0]*X[1][1] - X[1][0]*X[0][1];
            float detResult_A = A2[0][0]*A2[1][1] - A2[1][0]*A2[0][1];
            float x = detResult_X/detResult_A;
                System.out.println("\nSonuçlar\ndetResult_X : " + detResult_X);
                System.out.println("detResult_A : " + detResult_A);
                System.out.println("x:"+x);

            float detResult_Y = Y[0][0]*Y[1][1] - Y[1][0]*Y[0][1];
            float y = detResult_Y/detResult_A;
                System.out.println("\ndetResult_Y : " + detResult_Y);
                System.out.println("detResult_A : " + detResult_A);
                System.out.println("y:"+y);

    }

    private void displayMatrix(String name, int[][] matrix) {
        System.out.println("\n" + name + " : ");
        for (int[] row : matrix) {
            for (int element : row) {
                System.out.print(element + " ");
            }
            System.out.println();
        }
    }


}

