/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;

/**
 *
 * @author Asus
 */
public class Aplication extends javax.swing.JFrame {
    String messageAbout = "Estadísticas es una aplicación de análisis de imágenes.\nEl usuario podrá obtener"
            + " datos estadísticos acerca de los tres colores RGB (máximo, \nmínimo y promedio) en una imagen de tipo jpg o png a elegir por el usuario. "
            + "\nCreadores: Víctor Herrera Delgado y Miguel"
            + " Herrera Álvarez.\nVersión: 1.0\n"
            + "Versión de Java: 1.8.0_181 ";
    private int maximos[] = new int[3];
    private int minimos[] = new int[3];
    private int promedios[] = new int[3];
    static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    /**
     * Creates new form Aplication
     */
    JScrollBar barraVertical, barraHorizontal;
    JViewport viewPort;
    Mat originalImage;
    BufferedImage image;
    JFileChooser fc = new JFileChooser();
    EstadisticasImagen estImg = new EstadisticasImagen();
    
    class ManejadorBarra implements AdjustmentListener{
        
        @Override
        public void adjustmentValueChanged(AdjustmentEvent e) {
            if(originalImage != null){
                actualizaDatos();
            }
            
        }
    }
    public Aplication() {
        initComponents();
        
        panelDeslizante.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        panelDeslizante.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        
        viewPort = panelDeslizante.getViewport();
        barraVertical = panelDeslizante.getVerticalScrollBar();
        barraHorizontal = panelDeslizante.getHorizontalScrollBar();
        barraVertical.addAdjustmentListener(new ManejadorBarra());
        barraHorizontal.addAdjustmentListener(new ManejadorBarra());
        
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("ArchivosJPG","jpg","jpeg");
        fc.addChoosableFileFilter(filtro);
        FileNameExtensionFilter filtro2 = new FileNameExtensionFilter("ArchivosPNG","png");
        fc.addChoosableFileFilter(filtro2);
        fc.setAcceptAllFileFilterUsed(false);
        this.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        this.addWindowListener(new WindowAdapter(){
                public void windowClosing(WindowEvent e){
                    int res =JOptionPane.showConfirmDialog(null,"¿Está seguro de que quiere salir de la aplicación?","Salir",JOptionPane.YES_NO_OPTION);
                    if(res==0)
                        System.exit(0);//cierra aplicacion
                }
            });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelDeslizante = new javax.swing.JScrollPane();
        lienzo1 = new Lienzo();
        panelRojo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        rojoMaxText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        rojoProText = new javax.swing.JTextField();
        rojoMinText = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        verdMaxText = new javax.swing.JTextField();
        verdProText = new javax.swing.JTextField();
        verdMinText = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        azulMaxText = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        azulProText = new javax.swing.JTextField();
        azulMinText = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        menuArchivo = new javax.swing.JMenu();
        optionAbrir = new javax.swing.JMenuItem();
        optionSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        optionAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1100, 730));

        panelDeslizante.setAutoscrolls(true);
        panelDeslizante.setMinimumSize(new java.awt.Dimension(850, 600));
        panelDeslizante.setPreferredSize(new java.awt.Dimension(902, 600));

        lienzo1.setMinimumSize(new java.awt.Dimension(900, 619));

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 627, Short.MAX_VALUE)
        );

        panelDeslizante.setViewportView(lienzo1);

        panelRojo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Rojo");

        rojoMaxText.setEditable(false);
        rojoMaxText.setText("0");
        rojoMaxText.setFocusable(false);

        jLabel4.setText("Máximo");

        jLabel5.setText("Promedio");

        jLabel6.setText("Mínimo");

        rojoProText.setEditable(false);
        rojoProText.setText("0");
        rojoProText.setFocusable(false);

        rojoMinText.setEditable(false);
        rojoMinText.setText("0");
        rojoMinText.setFocusable(false);

        javax.swing.GroupLayout panelRojoLayout = new javax.swing.GroupLayout(panelRojo);
        panelRojo.setLayout(panelRojoLayout);
        panelRojoLayout.setHorizontalGroup(
            panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRojoLayout.createSequentialGroup()
                .addGroup(panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelRojoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(panelRojoLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rojoMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rojoMinText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rojoProText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelRojoLayout.setVerticalGroup(
            panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelRojoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rojoMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(rojoProText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelRojoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rojoMinText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setText("Verde");

        jLabel7.setText("Máximo");

        jLabel8.setText("Promedio");

        jLabel9.setText("Mínimo");

        verdMaxText.setEditable(false);
        verdMaxText.setText("0");
        verdMaxText.setFocusable(false);

        verdProText.setEditable(false);
        verdProText.setText("0");
        verdProText.setFocusable(false);

        verdMinText.setEditable(false);
        verdMinText.setText("0");
        verdMinText.setFocusable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verdMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verdMinText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(verdProText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verdMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(verdProText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(verdMinText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Azul");

        jLabel10.setText("Máximo");

        azulMaxText.setEditable(false);
        azulMaxText.setText("0");
        azulMaxText.setFocusable(false);

        jLabel11.setText("Mínimo");

        jLabel12.setText("Promedio");

        azulProText.setEditable(false);
        azulProText.setText("0");
        azulProText.setFocusable(false);

        azulMinText.setEditable(false);
        azulMinText.setText("0");
        azulMinText.setFocusable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(18, 18, 18)
                                .addComponent(azulProText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(azulMinText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(azulMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(azulMaxText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(azulProText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(azulMinText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jLabel13.setText("Víctor Herrera Delgado");

        jLabel15.setText("Miguel Herrera Álvarez");

        menuArchivo.setText("Archivo");

        optionAbrir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        optionAbrir.setText("Abrir archivo");
        optionAbrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionAbrirActionPerformed(evt);
            }
        });
        menuArchivo.add(optionAbrir);

        optionSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        optionSalir.setText("Salir");
        optionSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionSalirActionPerformed(evt);
            }
        });
        menuArchivo.add(optionSalir);

        jMenuBar1.add(menuArchivo);

        jMenu2.setText("Ayuda");

        optionAcercaDe.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        optionAcercaDe.setText("Acerca de");
        optionAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optionAcercaDeActionPerformed(evt);
            }
        });
        jMenu2.add(optionAcercaDe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelRojo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addComponent(panelDeslizante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDeslizante, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelRojo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel15)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void optionAbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionAbrirActionPerformed
        int res = fc.showOpenDialog(null);
        if (res == JFileChooser.APPROVE_OPTION) {
            File fichero = fc.getSelectedFile();
            if (fichero.exists()){
                originalImage = Imgcodecs.imread(fichero.getAbsolutePath());
                image = (BufferedImage) HighGui.toBufferedImage(originalImage);
                lienzo1.setImage(image);
                panelDeslizante.setMaximumSize(new Dimension(image.getWidth(),image.getHeight()));
                actualizaDatos();
                viewPort.setViewPosition(new Point(0, 0));
            }else{
                JOptionPane.showMessageDialog(null,"La imagen seleccionada no existe","Error",JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_optionAbrirActionPerformed

    private void optionSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionSalirActionPerformed
        int res =JOptionPane.showConfirmDialog(null,"¿Está seguro de que quiere salir de la aplicación?","Salir",JOptionPane.YES_NO_OPTION);
        if(res == JOptionPane.YES_OPTION) System.exit(0);
    }//GEN-LAST:event_optionSalirActionPerformed

    private void optionAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optionAcercaDeActionPerformed
        JOptionPane.showMessageDialog(null,messageAbout,"Acerca de",JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_optionAcercaDeActionPerformed
    private void actualizaDatos(){
        
        Dimension size = viewPort.getExtentSize();
        Point esquinaSuperior = viewPort.getViewPosition();
        
        if(size.getHeight() >= image.getHeight() && size.getWidth() >= image.getWidth()) { 
            size.setSize(image.getWidth(),image.getHeight());
            estImg.calculaEstadisticas((originalImage), esquinaSuperior, size);
        }
            
        else if (size.getHeight() >= image.getHeight()){
            size.setSize( size.getWidth(),image.getHeight());
            estImg.calculaEstadisticas((originalImage), esquinaSuperior, size);
            
        }
        else if (size.getWidth() >= image.getWidth()){
        size.setSize(image.getWidth(),  size.getHeight());
            estImg.calculaEstadisticas((originalImage), esquinaSuperior, size);
        }
        else{ 
            estImg.calculaEstadisticas((originalImage), esquinaSuperior, size);
            
        
        }
        panelDeslizante.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
            panelDeslizante.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        maximos= estImg.getMaximo();
        promedios = estImg.getPromedio();
        minimos = estImg.getMinimo();
        rojoMaxText.setText(maximos[2] + "");
        verdMaxText.setText(maximos[1] + "");
        azulMaxText.setText(maximos[0] + "");
        rojoProText.setText(promedios[2] + "");
        verdProText.setText(promedios[1] + "");
        azulProText.setText(promedios[0] + "");
        rojoMinText.setText(minimos[2] + "");
        verdMinText.setText(minimos[1] + "");
        azulMinText.setText(minimos[0] + "");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Aplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Aplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Aplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Aplication.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Aplication practica6 = new Aplication();
                practica6.setTitle("Estadísticas Subimagen");
                practica6.setLocationRelativeTo(null);
                practica6.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField azulMaxText;
    private javax.swing.JTextField azulMinText;
    private javax.swing.JTextField azulProText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private Lienzo lienzo1;
    private javax.swing.JMenu menuArchivo;
    private javax.swing.JMenuItem optionAbrir;
    private javax.swing.JMenuItem optionAcercaDe;
    private javax.swing.JMenuItem optionSalir;
    private javax.swing.JScrollPane panelDeslizante;
    private javax.swing.JPanel panelRojo;
    private javax.swing.JTextField rojoMaxText;
    private javax.swing.JTextField rojoMinText;
    private javax.swing.JTextField rojoProText;
    private javax.swing.JTextField verdMaxText;
    private javax.swing.JTextField verdMinText;
    private javax.swing.JTextField verdProText;
    // End of variables declaration//GEN-END:variables
}