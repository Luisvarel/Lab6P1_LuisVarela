/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab6p1_luisvarela;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author Luis Andres Varela
 */
public class Lab6P1_LuisVarela {
    static Scanner lea= new Scanner( System.in);
    static random rand=new random(System.in);
        /**
     * @param args the command line arguments
     */
    public static int menu(){
        System.out.println("1.¿Cuántos primos tienes?");
        System.out.println("2.Frecuencia de letras");
        System.out.println("3.Salir");
        int opcion=lea.nextInt();
        return opcion;
    }
    
    public static int[] Frecuencia_de_L(int[]a,String palabra){
        String letra="abcdefghijklmnopqrstuvwxyzñ";
        int contador=0;
        for(int q=0;q<palabra.length();q++){
            for(int w=0;w<letra.length();w++){
                if((int)palabra.charAt(contador)==65533&&w==letra.length()-1){
                    a[26]++;
                }else if(letra.charAt(w)==palabra.charAt(contador)){
                    a[w]++;
                }
            }
            contador++;
        }
        return a;
    }
    
    public static int[]genRandArray(int tamaño,int inferior,int superior){
        
        int []arreglo=new int[tamaño];
        int randint=rand.nextInt(superior-inferior)+inferior;
        
    }
    public static void main(String[] args) {
        boolean salir=true;
        while(salir){
            switch(menu()){
                case 1:{
                    System.out.println("Ingrese el tamaño del arreglo a generar:");
                    int tamaño=lea.nextInt();
                    while(tamaño<=1){
                        System.out.println("Ingrese el tamaño del arreglo debe ser mayor que 1:");
                        tamaño = lea.nextInt();
                    }
                    System.out.println("Ingrese el límite inferior: ");
                    int inferior=lea.nextInt();
                    System.out.println("Ingrese el límite superior:");
                    int superior=lea.nextInt();
                    while(inferior>=superior){
                        System.out.println("El límite inferior es mayor que el límite superior: ");
                        System.out.println("Ingrese el límite inferior: ");
                        inferior = lea.nextInt();
                        System.out.println("Ingrese el límite superior:");
                        superior = lea.nextInt();
                    }
                    genRandArray(tamaño,inferior,superior);
                }
                break;
                case 2:{
                    System.out.println("Ingrese una palabra:");
                    String palabra=lea.next();
                    String palabra_en_M=palabra.toUpperCase();
                    int contador=0;
                    for(int i=0;i<palabra.length();i++){
                        if((int)palabra.charAt(i)==65533){
                            contador--;
                        }else if(palabra.charAt(i)==palabra_en_M.charAt(i)){
                            contador++;
                        }
                        
                    }
                    if(contador>0){
                        System.out.println("Error ingrese la palabra en minúsculas");
                    }else{
                        int []a=new int[27];
                        System.out.println(Arrays.toString(Frecuencia_de_L(a,palabra)));
                        System.out.println("[a, b, c, d, e, f, g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z, otros]");
                    }
                    
                }
                break;
                case 3:{
                    salir=false;
                }
                break;
                default:
                    System.out.println("Error");
            }
        }
        // TODO code application logic here
    }
    
}
