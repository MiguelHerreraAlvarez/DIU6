/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Asus
 */
import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import org.opencv.core.Core;
import static org.opencv.core.Core.mean;
import static org.opencv.core.Core.minMaxLoc;
import static org.opencv.core.Core.split;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
public class EstadisticasImagen {
    public final int AZUL = 0;
    public final int VERDE = 1;
    public final int ROJO = 2;
    private final int[] Componentes = {ROJO, VERDE, AZUL};
    
    private int maximo[] = new int[3];
    private int minimo[] = new int[3];
    private int promedio[] = new int[3];
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    public int[] getMaximo() {
        return maximo;
    }

    public int[] getMinimo() {
        return minimo;
    }

    public int[] getPromedio() {
        return promedio;
    }
    
    public void calculaEstadisticas(Mat imagenColor, Point esqSupIzda,
            Dimension dimVista) {
        // crea la subimagen correspondiente al viewport
        System.out.println("Esquina: "+ esqSupIzda.x+ "," + esqSupIzda.y);
        System.out.println("Esquina: "+ esqSupIzda.x+ "," + esqSupIzda.y);
        try{
        Mat subimagen = new Mat(imagenColor,new Rect(esqSupIzda.x, esqSupIzda.y,
                dimVista.width, dimVista.height) );
        ArrayList<Mat> bgr = new ArrayList<>();
        split(subimagen, bgr);
        
        // separa los tres canales de la subimagen BGR
        

        // estadisticas 
        EstadisticasImagen res = new EstadisticasImagen();

        for (int c : res.Componentes) {
            // obtiene el máximo y mínimo del canal c de la subimagen
            Core.MinMaxLocResult minmax = minMaxLoc(bgr.get(c));
            // calcula el premodio del canal c de la subimagen
            Scalar prom_scalar = mean(bgr.get(c));

            this.maximo[c] = (int) minmax.maxVal;
            this.minimo[c] = (int) minmax.minVal;
            this.promedio[c] = (int) prom_scalar.val[0];
        }
        }catch(org.opencv.core.CvException e){
            
        }
    }
}