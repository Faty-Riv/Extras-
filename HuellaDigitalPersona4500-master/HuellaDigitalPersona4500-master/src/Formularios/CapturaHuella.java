package Formularios;

import com.digitalpersona.onetouch.DPFPDataPurpose;
import com.digitalpersona.onetouch.DPFPFeatureSet;
import com.digitalpersona.onetouch.DPFPGlobal;
import com.digitalpersona.onetouch.DPFPSample;
import com.digitalpersona.onetouch.DPFPTemplate;
import com.digitalpersona.onetouch.capture.DPFPCapture;
import com.digitalpersona.onetouch.capture.event.DPFPDataAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPDataEvent;
import com.digitalpersona.onetouch.capture.event.DPFPErrorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPErrorEvent;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPReaderStatusEvent;
import com.digitalpersona.onetouch.capture.event.DPFPSensorAdapter;
import com.digitalpersona.onetouch.capture.event.DPFPSensorEvent;
import com.digitalpersona.onetouch.processing.DPFPEnrollment;
import com.digitalpersona.onetouch.processing.DPFPFeatureExtraction;
import com.digitalpersona.onetouch.processing.DPFPImageQualityException;
import com.digitalpersona.onetouch.verification.DPFPVerification;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import BD.ConexionBD;
import com.digitalpersona.onetouch.verification.DPFPVerificationResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpResponse;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContextBuilder;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;


/**
 *
 * @author Jhon Moreira
 */
public class CapturaHuella extends javax.swing.JFrame {
    
    //Url Api de consumo
    private final String URL_ENDPOINT = "https://donaldsbarbershop.net/crear/control/huelladigital";
    //El empleado solo se modifica en la bd del servidor remoto
    private final String ID_EMPLEADO = "0";
    //El id de la empresa puede ser modificado aqui segun donde este el dispositivo
    private final String ID_EMPRESA = "5";

    /** Crea un nuevo formulario de captura para huellas digitales */
    public CapturaHuella() {
        try {
         UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
         } catch (Exception e) {
         JOptionPane.showMessageDialog(null, "Imposible modificar el tema visual", "Lookandfeel inválido.",
         JOptionPane.ERROR_MESSAGE);
         }
        initComponents();
        txtArea.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panHuellas = new javax.swing.JPanel();
        lblImagenHuella = new javax.swing.JLabel();
        panBtns = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Receptor de Huellas - Donalds Heredia, Plaza Real Cariari ");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new java.awt.BorderLayout());

        panHuellas.setBackground(new java.awt.Color(255, 255, 255));
        panHuellas.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, null, null));
        panHuellas.setPreferredSize(new java.awt.Dimension(400, 235));
        panHuellas.setLayout(new java.awt.BorderLayout());
        panHuellas.add(lblImagenHuella, java.awt.BorderLayout.CENTER);

        getContentPane().add(panHuellas, java.awt.BorderLayout.PAGE_START);

        panBtns.setBackground(new java.awt.Color(255, 255, 255));
        panBtns.setBorder(javax.swing.BorderFactory.createTitledBorder(null, null, null, null));
        panBtns.setPreferredSize(new java.awt.Dimension(400, 250));
        panBtns.setLayout(new java.awt.BorderLayout());

        txtArea.setColumns(20);
        txtArea.setFont(new java.awt.Font("Lucida Sans", 1, 10)); // NOI18N
        txtArea.setLineWrap(true);
        txtArea.setRows(10);
        txtArea.setMinimumSize(new java.awt.Dimension(100, 20));
        txtArea.setPreferredSize(new java.awt.Dimension(200, 180));
        jScrollPane1.setViewportView(txtArea);

        panBtns.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnGuardar.setText("Guardar Nueva Huella");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(274, Short.MAX_VALUE)
                .addComponent(btnGuardar)
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        panBtns.add(jPanel1, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(panBtns, java.awt.BorderLayout.SOUTH);

        setSize(new java.awt.Dimension(459, 529));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Iniciar();
	start();
        EstadoHuellas();
        btnGuardar.setEnabled(false);
    }//GEN-LAST:event_formWindowOpened

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        stop();
    }//GEN-LAST:event_formWindowClosing

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        guardarHuella();
        Reclutador.clear();
        lblImagenHuella.setIcon(null);
        start();
    }//GEN-LAST:event_btnGuardarActionPerformed

//Varible que permite iniciar el dispositivo de lector de huella conectado
// con sus distintos metodos.
private DPFPCapture Lector = DPFPGlobal.getCaptureFactory().createCapture();

//Varible que permite establecer las capturas de la huellas, para determina sus caracteristicas
// y poder estimar la creacion de un template de la huella para luego poder guardarla
private DPFPEnrollment Reclutador = DPFPGlobal.getEnrollmentFactory().createEnrollment();

//Esta variable tambien captura una huella del lector y crea sus caracteristcas para auntetificarla
// o verificarla con alguna guardada en la BD
private DPFPVerification Verificador = DPFPGlobal.getVerificationFactory().createVerification();

//Variable que para crear el template de la huella luego de que se hallan creado las caracteriticas
// necesarias de la huella si no ha ocurrido ningun problema
private DPFPTemplate template;
public static String TEMPLATE_PROPERTY = "template";

protected void Iniciar(){
   Lector.addDataListener(new DPFPDataAdapter() {
    @Override public void dataAcquired(final DPFPDataEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    //EnviarTexto("La Huella Digital ha sido Capturada");
    ProcesarCaptura(e.getSample());
    }});}
   });

   Lector.addReaderStatusListener(new DPFPReaderStatusAdapter() {
    @Override public void readerConnected(final DPFPReaderStatusEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    EnviarTexto("El Sensor de Huella Digital esta Activado o Conectado");
    }});}
    @Override public void readerDisconnected(final DPFPReaderStatusEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    EnviarTexto("El Sensor de Huella Digital esta Desactivado o no Conectado");
    }});}
   });

   Lector.addSensorListener(new DPFPSensorAdapter() {
    @Override public void fingerTouched(final DPFPSensorEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    EnviarTexto("El dedo ha sido colocado sobre el Lector de Huella");
    EnviarTexto("Realizando lectura dactilar...");
    }});}
    @Override public void fingerGone(final DPFPSensorEvent e) {
    SwingUtilities.invokeLater(new Runnable() {	public void run() {
    //EnviarTexto("El dedo ha sido quitado del Lector de Huella");
    }});}
   });

   Lector.addErrorListener(new DPFPErrorAdapter(){
    public void errorReader(final DPFPErrorEvent e){
    SwingUtilities.invokeLater(new Runnable() {  public void run() {
    EnviarTexto("Error: "+e.getError());
    }});}
   });
}

 public DPFPFeatureSet featuresinscripcion;
 public DPFPFeatureSet featuresverificacion;

public  void ProcesarCaptura(DPFPSample sample)
{
    // Procesar la muestra de la huella y crear un conjunto de características con el propósito de inscripción.
    featuresinscripcion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_ENROLLMENT);

    // Procesar la muestra de la huella y crear un conjunto de características con el propósito de verificacion.
    featuresverificacion = extraerCaracteristicas(sample, DPFPDataPurpose.DATA_PURPOSE_VERIFICATION);

    // Comprobar la calidad de la muestra de la huella y lo añade a su reclutador si es bueno
    if (featuresinscripcion != null)
        try{
        System.out.println("Las Caracteristicas de la Huella han sido creada");
        Reclutador.addFeatures(featuresinscripcion);// Agregar las caracteristicas de la huella a la plantilla a crear

        // Dibuja la huella dactilar capturada.
        Image image=CrearImagenHuella(sample);
        DibujarHuella(image);

        try {
            identificarHuella();
        } catch (IOException ex) {
            Logger.getLogger(CapturaHuella.class.getName()).log(Level.SEVERE, null, ex);
        }


        }catch (DPFPImageQualityException ex) {
        System.err.println("Error: "+ex.getMessage());
        }

        finally {
        EstadoHuellas();
        // Comprueba si la plantilla se ha creado.
           switch(Reclutador.getTemplateStatus())
           {
               case TEMPLATE_STATUS_READY:	// informe de éxito y detiene  la captura de huellas
               stop();
               setTemplate(Reclutador.getTemplate());
               EnviarTexto("La Plantilla de la Huella ha Sido Creada, ya puede Guardarla");
               btnGuardar.setEnabled(true);
               btnGuardar.grabFocus();
               break;

               case TEMPLATE_STATUS_FAILED: // informe de fallas y reiniciar la captura de huellas
               Reclutador.clear();
               stop();
               EstadoHuellas();
               setTemplate(null);
               JOptionPane.showMessageDialog(CapturaHuella.this, "La Plantilla de la Huella no pudo ser creada, Repita el Proceso", "Inscripcion de Huellas Dactilares", JOptionPane.ERROR_MESSAGE);
               start();
               break;
           }
                }
}

 public  DPFPFeatureSet extraerCaracteristicas(DPFPSample sample, DPFPDataPurpose purpose){
     DPFPFeatureExtraction extractor = DPFPGlobal.getFeatureExtractionFactory().createFeatureExtraction();
     try {
      return extractor.createFeatureSet(sample, purpose);
     } catch (DPFPImageQualityException e) {
      return null;
     }
}

public  Image CrearImagenHuella(DPFPSample sample) {
	return DPFPGlobal.getSampleConversionFactory().createImage(sample);
}

public void DibujarHuella(Image image) {
        lblImagenHuella.setIcon(new ImageIcon(
        image.getScaledInstance(lblImagenHuella.getWidth(), lblImagenHuella.getHeight(), Image.SCALE_DEFAULT)));
        repaint();
}

public  void EstadoHuellas(){
	EnviarTexto("Plantillas necesarias para guardar una nueva huella : "+ Reclutador.getFeaturesNeeded());
}

public void EnviarTexto(String string) {
        txtArea.append(string + "\n");
}

public  void start(){
	Lector.startCapture();
	EnviarTexto("Utilizando el Lector de Huella Dactilar ");
}

public  void stop(){
        Lector.stopCapture();
        //EnviarTexto("No se está usando el Lector de Huella Dactilar ");
}

public DPFPTemplate getTemplate() {
    return template;
}

public void setTemplate(DPFPTemplate template) {
        DPFPTemplate old = this.template;
	this.template = template;
	firePropertyChange(TEMPLATE_PROPERTY, old, template);
}

ConexionBD con=new ConexionBD();
 /*
  * Guarda los datos de la huella digital actual en la base de datos
  */
public void guardarHuella(){
     //Obtiene los datos del template de la huella actual
     ByteArrayInputStream datosHuella = new ByteArrayInputStream(template.serialize());
     Integer tamañoHuella=template.serialize().length;

     //Pregunta el nombre de la persona a la cual corresponde dicha huella
     String nombre = JOptionPane.showInputDialog("Nombre Empleado:");
     try {
     //Establece los valores para la sentencia SQL
     Connection c=con.conectar(); //establece la conexion con la BD
     PreparedStatement guardarStmt = c.prepareStatement("INSERT INTO somhue(huenombre, huehuella) values(?,?)");

     guardarStmt.setString(1,nombre);
     guardarStmt.setBinaryStream(2, datosHuella,tamañoHuella);
     //Ejecuta la sentencia
     guardarStmt.execute();
     guardarStmt.close();
     JOptionPane.showMessageDialog(null,"Huella Guardada Correctamente");
     con.desconectar();
     btnGuardar.setEnabled(false);
     } catch (SQLException ex) {
     //Si ocurre un error lo indica en la consola
     System.err.println("Error al guardar los datos de la huella.");
     }finally{
     con.desconectar();
     }
   }

 /**
  * Identifica a una persona registrada por medio de su huella digital
  */
  public void identificarHuella() throws IOException{
     try {
       //Establece los valores para la sentencia SQL
       Connection c=con.conectar();
       
       //Obtiene todas las huellas de la bd
       PreparedStatement identificarStmt = c.prepareStatement("SELECT huenombre,huehuella FROM somhue");
       ResultSet rs = identificarStmt.executeQuery();

       //Si se encuentra el nombre en la base de datos
       while(rs.next()){
       //Lee la plantilla de la base de datos
       byte templateBuffer[] = rs.getBytes("huehuella");
       String nombre=rs.getString("huenombre");
       //Crea una nueva plantilla a partir de la guardada en la base de datos
       DPFPTemplate referenceTemplate = DPFPGlobal.getTemplateFactory().createTemplate(templateBuffer);
       //Envia la plantilla creada al objeto contendor de Template del componente de huella digital
       setTemplate(referenceTemplate);

       // Compara las caracteriticas de la huella recientemente capturda con la
       // alguna plantilla guardada en la base de datos que coincide con ese tipo
       DPFPVerificationResult result = Verificador.verify(featuresverificacion, getTemplate());

       //compara las plantilas (actual vs bd)
       //Si encuentra correspondencia dibuja el mapa
       //e indica el nombre de la persona que coincidió.
       if (result.isVerified()){
       //Envia el registro al servidor
       apiEnviarRegistro(nombre);
       Reclutador.clear();
       stop();
       setTemplate(null);
       lblImagenHuella.setIcon(null);
       start();
       return;
                               }
       }
       //Si no encuentra alguna huella correspondiente al nombre lo indica con un mensaje
       EnviarTexto("Empleado No Existe");
       setTemplate(null);
       } catch (SQLException e) {
       //Si ocurre un error lo indica en la consola
       System.err.println("Error al identificar huella dactilar."+e.getMessage());
       } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CapturaHuella.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyStoreException ex) {
            Logger.getLogger(CapturaHuella.class.getName()).log(Level.SEVERE, null, ex);
        } catch (KeyManagementException ex) {
            Logger.getLogger(CapturaHuella.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
       con.desconectar();
       }
   }

/*
* @param args the command line arguments
*/

private void apiEnviarRegistro(String nombre) throws NoSuchAlgorithmException, KeyStoreException, KeyManagementException
{
    String fecha = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    String hora = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date());
    
    SSLContextBuilder builder = new SSLContextBuilder();
    builder.loadTrustMaterial(null, new TrustStrategy() {
         public boolean isTrusted(final X509Certificate[] chain, String authType) throws CertificateException {
              return true;
         }
    });
    SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(builder.build());

    CloseableHttpClient httpClient = HttpClients.custom().setSSLSocketFactory(sslsf).build();

    try {

        HttpPost request = new HttpPost(URL_ENDPOINT);
        List params = new ArrayList();
        params.add(new BasicNameValuePair("nombre", nombre));
        params.add(new BasicNameValuePair("fecha", fecha));
        params.add(new BasicNameValuePair("hora", hora));
        params.add(new BasicNameValuePair("id_empleado", ID_EMPLEADO ));
        params.add(new BasicNameValuePair("id_empresa", ID_EMPRESA));
        request.addHeader("content-type", "application/x-www-form-urlencoded");
        request.setEntity(new UrlEncodedFormEntity(params));
        HttpResponse response = httpClient.execute(request);
        int code = response.getStatusLine().getStatusCode();
        
        if(code == 200)
        {
            JOptionPane.showMessageDialog(null,"Tu registro quedó almacenado: "+ fecha ,nombre, JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            JOptionPane.showMessageDialog(null, "Ha ocurrido un problema contactando al servidor externo.\nRevisa conexion a internet e intenta de nuevo","Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //Limpia la consola de eventos
        txtArea.setText(null);
        
    }catch (Exception ex) {
        System.out.println(ex.getMessage());
    } 
}
  
  
public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CapturaHuella().setVisible(true);
            }
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGuardar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblImagenHuella;
    private javax.swing.JPanel panBtns;
    private javax.swing.JPanel panHuellas;
    private javax.swing.JTextArea txtArea;
    // End of variables declaration//GEN-END:variables

}
