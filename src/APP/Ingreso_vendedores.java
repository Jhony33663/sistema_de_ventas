/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import static APP.Ingreso_productos.getConnection;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

//LIBRERIA EXCEL
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

//PASO 1 LIBERIAS
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import javax.swing.RowFilter;
import static javax.swing.UIManager.getString;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Jhony
 */
public class Ingreso_vendedores extends javax.swing.JInternalFrame {

    private TableRowSorter TRSFiltro;
    TableRowSorter trs = null;
    DefaultTableModel modelo = new DefaultTableModel();
    private final String ruta = System.getProperties().getProperty("user.dir");
    Connection con = null;
    public static Connection conn;
    public static final String DRIVER = "com.mysql.jdbc.Driver";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";
    public static final String URL = "jdbc:mysql://localhost:3306/sistemaventas";
    PreparedStatement ps;
    ResultSet rs;

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER);
            conn = (Connection) DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    /**
     * Creates new form Ingreso_vendedores
     */
    public Ingreso_vendedores() {
        initComponents();
        ocultar();
        mostrardatos();
        transpareciabotones();
        this.tabladatos.setModel(modelo);
        this.modelo.addColumn("id");
        this.modelo.addColumn("Cedula");
        this.modelo.addColumn("Nombres");
        this.modelo.addColumn("Edad");
        this.modelo.addColumn("Celular");
        this.modelo.addColumn("Correo");
        this.modelo.addColumn("Direccion");
        this.modelo.addColumn("Fecha");
    }
    private float empleados;
    public void transpareciabotones() {
        btn_guardar.setOpaque(false);
        btn_guardar.setContentAreaFilled(false);
        btn_guardar.setBorderPainted(false);
        
        btn_buscar.setOpaque(false);
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.setBorderPainted(false);
        
        btn_modificar.setOpaque(false);
        btn_modificar.setContentAreaFilled(false);
        btn_modificar.setBorderPainted(false);
        
        btn_modificar.setOpaque(false);
        btn_modificar.setContentAreaFilled(false);
        btn_modificar.setBorderPainted(false);
        
        btn_eliminar.setOpaque(false);
        btn_eliminar.setContentAreaFilled(false);
        btn_eliminar.setBorderPainted(false);
        
        btn_actualizar.setOpaque(false);
        btn_actualizar.setContentAreaFilled(false);
        btn_actualizar.setBorderPainted(false);
        
        btn_back.setOpaque(false);
        btn_back.setContentAreaFilled(false);
        btn_back.setBorderPainted(false);
        
        btn_pdf.setOpaque(false);
        btn_pdf.setContentAreaFilled(false);
        btn_pdf.setBorderPainted(false);
        
        btn_excel.setOpaque(false);
        btn_excel.setContentAreaFilled(false);
        btn_excel.setBorderPainted(false);
    }
//limpiar cajas
    public void limpiarcajas() {
        txt_cedula.setText(null);
        txt_nombres.setText(null);
        txt_edad.setText(null);
        jdt.setDate(null);
        txt_celular.setText(null);
        txt_correo.setText(null);
        txt_direccion.setText(null);
    }
//ocualtar

    public void ocultar() {
        lbl_v1.setVisible(false);
        lbl_v2.setVisible(false);
        lbl_v3.setVisible(false);
        lbl_v4.setVisible(false);
        lbl_v5.setVisible(false);
        lbl_v6.setVisible(false);

    }
//Filtro    
    public void Filtro(){
        
        int ColumntaTabla =  1;
        TRSFiltro.setRowFilter(RowFilter.regexFilter(txt_filtro.getText(),ColumntaTabla));
    }
    
//validacion email

    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        pat = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            return true;
        } else {
            return false;
        }
    }
//validacion campos

    public void validaciones() {
        if (txt_cedula.getText().isEmpty()) {
            lbl_v1.setVisible(true);
        }
        if (txt_cedula.getText().length() > 0) {
            lbl_v1.setVisible(false);
        }
        if (txt_nombres.getText().isEmpty()) {
            lbl_v2.setVisible(true);
        }
        if (txt_nombres.getText().length() > 0) {
            lbl_v2.setVisible(false);
        }
        if (txt_edad.getText().isEmpty()) {
            lbl_v3.setVisible(true);
        }
        if (txt_edad.getText().length() > 0) {
            lbl_v3.setVisible(false);
        }
        if (txt_celular.getText().isEmpty()) {
            lbl_v4.setVisible(true);
        }
        if (txt_celular.getText().length() > 0) {
            lbl_v4.setVisible(false);
        }
        if (txt_correo.getText().isEmpty()) {
            lbl_v5.setVisible(true);
        }
        if (txt_correo.getText().length() > 0) {
            lbl_v5.setVisible(false);
        }
        if (txt_direccion.getText().isEmpty()) {
            lbl_v6.setVisible(true);
        }
        if (txt_direccion.getText().length() > 0) {
            lbl_v6.setVisible(false);
        }
    }

    //mostrarentabla
    public void mostrardatos() {
        try {
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/sistemaventas", "root", "");
            String sql = "SELECT * FROM empleados";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            tabladatos.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jCalendar1 = new com.toedter.calendar.JCalendar();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        txt_cedula = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        txt_edad = new javax.swing.JTextField();
        txt_celular = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        jdt = new com.toedter.calendar.JDateChooser();
        lbl_v2 = new javax.swing.JLabel();
        lbl_v3 = new javax.swing.JLabel();
        lbl_v4 = new javax.swing.JLabel();
        lbl_v5 = new javax.swing.JLabel();
        lbl_v6 = new javax.swing.JLabel();
        lbl_v1 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_actualizar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        btn_excel = new javax.swing.JButton();
        btn_pdf = new javax.swing.JToggleButton();
        jLabel8 = new javax.swing.JLabel();
        lbl_name = new javax.swing.JTextField();
        txt_filtro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel11 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        jButton7.setText("jButton7");

        setClosable(true);
        setIconifiable(true);
        setTitle("VENDEDORES");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "id", "Cedula", "Nombres", "Edad", "Celular", "Correo", "Direccion", "Fecha"
            }
        ));
        tabladatos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabladatosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabladatos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 630, 130));
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 150, -1));
        jPanel1.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, 150, -1));
        jPanel1.add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 150, -1));
        jPanel1.add(txt_celular, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 260, 150, -1));

        txt_correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_correoFocusLost(evt);
            }
        });
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 160, -1));
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 120, 160, -1));
        jPanel1.add(jdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 160, -1));

        lbl_v2.setText("CAMPO REQUERIDO (*)");
        jPanel1.add(lbl_v2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 150, -1, -1));

        lbl_v3.setText("CAMPO REQUERIDO (*)");
        jPanel1.add(lbl_v3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, -1, -1));

        lbl_v4.setText("CAMPO REQUERIDO (*)");
        jPanel1.add(lbl_v4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, -1, -1));

        lbl_v5.setText("CAMPO REQUERIDO (*)");
        jPanel1.add(lbl_v5, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 70, -1, -1));

        lbl_v6.setText("CAMPO REQUERIDO (*)");
        jPanel1.add(lbl_v6, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 150, -1, -1));

        lbl_v1.setText("CAMPO REQUERIDO (*)");
        jPanel1.add(lbl_v1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("DIRECCION");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("CEDULA");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("NOMBRES");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("EDAD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 170, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CELULAR");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("CORREO ELECTRONICO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 20, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("FECHA DE NACIMIENTO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 170, -1, -1));

        btn_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/actualizar tabla.png"))); // NOI18N
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 190, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar2.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 190, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar.png"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 190, -1));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, 190, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 190, -1));

        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/REGRESAR_1.png"))); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 370, 190, -1));

        btn_excel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Excel.png"))); // NOI18N
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });
        jPanel1.add(btn_excel, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 560, -1, -1));

        btn_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/PDF.png"))); // NOI18N
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });
        jPanel1.add(btn_pdf, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 500, -1, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("ASIGNAR NOMBRE AL ARCHIVO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 540, -1, -1));
        jPanel1.add(lbl_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 570, 200, 30));

        txt_filtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_filtroKeyTyped(evt);
            }
        });
        jPanel1.add(txt_filtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 330, 180, 30));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("BUSCAR POR CEDULA / RUC");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 340, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 320, 630, -1));

        jProgressBar1.setStringPainted(true);
        jPanel1.add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 620, -1, -1));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/klipartz.com.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 20, 10, 280));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Frame .png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 890, 650));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        if (txt_cedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE LLENAR CEDULA PARA ELIMINAR", "ERROR", JOptionPane.ERROR_MESSAGE);
        } else {
            Connection conn = null;
            try {
                conn = getConnection();
                ps = conn.prepareStatement("DELETE FROM empleados WHERE cedula=?");
                ps.setInt(1, Integer.parseInt(txt_cedula.getText()));
                int res = ps.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "DATOS ELIMINADOS");
                    limpiarcajas();
                } else {

                    JOptionPane.showMessageDialog(null, "Error al eliminar datos");
                    limpiarcajas();
                }
                conn.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        validaciones();
        if (txt_cedula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor verifique los campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        if (txt_cedula.getText().length() == 10) {
            int c, suma = 0, acum, resta = 0;
            String lec;
            lec = txt_cedula.getText();
            String cedula = lec;
            for (int i = 0; i < cedula.length() - 1; i++) {
                c = Integer.parseInt(cedula.charAt(i) + "");
                if (i % 2 == 0) {
                    c = c * 2;
                    if (c > 9) {
                        c = c - 9;
                    }

                }
                suma = suma + c;
            }
            if (suma % 10 != 0) {
                acum = ((suma / 10) + 1) * 10;
                resta = acum - suma;
            }
            int ultimo = Integer.parseInt(cedula.charAt(9) + "");
            if (ultimo == resta) {

                JOptionPane.showMessageDialog(null, "CEDULA CORRECTA");
                if (txt_nombres.getText().isEmpty() || txt_cedula.getText().isEmpty() || txt_edad.getText().isEmpty() || txt_celular.getText().isEmpty() || txt_correo.getText().isEmpty()
                        || txt_direccion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor verifique los campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    Connection conn = null;
                    try {
                        //conexion a bd
                        conn = getConnection();
                        //datos y transformo a valores correspondientes
                        //consuta a la tabla
                        ps = conn.prepareStatement("INSERT INTO `empleados`(`Cedula`, `Nombres`, `Edad`, `Celular`, `Correo`, `Direccion`,`Fecha`)" + "VALUES(?,?,?,?,?,?,?)");
                        ps.setString(1, txt_cedula.getText());
                        ps.setString(2, txt_nombres.getText());
                        ps.setString(3, txt_edad.getText());
                        ps.setString(4, txt_celular.getText());
                        ps.setString(5, txt_correo.getText());
                        ps.setString(6, txt_direccion.getText());
                        ps.setString(7, ((JTextField) jdt.getDateEditor().getUiComponent()).getText());

                        //ejecute consulta y valores
                        //execute accion de incerscion 
                        //res envia msg
                        int res = ps.executeUpdate();
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "VALORES ALMACENADOS");
                            limpiarcajas();
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR AL ALMACENAR LOS DATOS...");
                            limpiarcajas();
                        }
                        conn.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "CEDULA INCORRECTA");
            }
        } else {
            JOptionPane.showMessageDialog(null, "VERIFIQUE LOS DIGITOS DE LA CEDULA");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_correoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_correoFocusLost
        if (isEmail(txt_correo.getText())) {

        } else {
            JOptionPane.showMessageDialog(null, "Email incorrecto", "Validar email", JOptionPane.INFORMATION_MESSAGE);
            txt_correo.requestFocus();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_correoFocusLost

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        validaciones();
        Connection conn = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM empleados WHERE Cedula=?");
            ps.setString(1, txt_cedula.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txt_cedula.setText(rs.getString("Cedula"));
                txt_nombres.setText(rs.getString("Nombres"));
                txt_edad.setText(rs.getString("Edad"));
                txt_celular.setText(rs.getString("Celular"));
                txt_correo.setText(rs.getString("Correo"));
                txt_direccion.setText(rs.getString("Direccion"));
                String date = rs.getString("Fecha");
                ((JTextField) jdt.getDateEditor().getUiComponent()).setText(date);
            } else {
                JOptionPane.showMessageDialog(null, "No existe la cedula");
                limpiarcajas();
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        validaciones();
        if (txt_cedula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor verifique los campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        if (txt_cedula.getText().length() == 10) {
            int c, suma = 0, acum, resta = 0;
            String lec;
            lec = txt_cedula.getText();
            String cedula = lec;
            for (int i = 0; i < cedula.length() - 1; i++) {
                c = Integer.parseInt(cedula.charAt(i) + "");
                if (i % 2 == 0) {
                    c = c * 2;
                    if (c > 9) {
                        c = c - 9;
                    }

                }
                suma = suma + c;
            }
            if (suma % 10 != 0) {
                acum = ((suma / 10) + 1) * 10;
                resta = acum - suma;
            }
            int ultimo = Integer.parseInt(cedula.charAt(9) + "");
            if (ultimo == resta) {

                JOptionPane.showMessageDialog(null, "CEDULA CORRECTA");
                if (txt_nombres.getText().isEmpty() || txt_cedula.getText().isEmpty() || txt_edad.getText().isEmpty() || txt_celular.getText().isEmpty() || txt_correo.getText().isEmpty()
                        || txt_direccion.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor verifique los campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
                } else {
                    String date = ((JTextField) jdt.getDateEditor().getUiComponent()).getText();
                    Connection conn = null;
                    try {
                        //conexion a bd
                        conn = getConnection();
                        //datos y transformo a valores correspondientes
                        //consuta a la tabla
                        ps = conn.prepareStatement("UPDATE empleados SET Nombres=?, Edad=?, Celular=?, Correo=?, Direccion=?,Fecha=? WHERE Cedula=?");

                        ps.setString(1, txt_nombres.getText());
                        ps.setString(2, txt_edad.getText());
                        ps.setString(3, txt_celular.getText());
                        ps.setString(4, txt_correo.getText());
                        ps.setString(5, txt_direccion.getText());
                        ps.setString(6, ((JTextField) jdt.getDateEditor().getUiComponent()).getText());
                        ps.setString(7, txt_cedula.getText());
                        //ejecute consulta y valores
                        //execute accion de incerscion 
                        //res envia msg
                        int res = ps.executeUpdate();
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "VALORES ALMACENADOS");
                            limpiarcajas();
                        } else {
                            JOptionPane.showMessageDialog(null, "ERROR AL ALMACENAR LOS DATOS...");
                            limpiarcajas();
                        }
                        conn.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "CEDULA INCORRECTA");
            }
        } else {
            JOptionPane.showMessageDialog(null, "VERIFIQUE LOS DIGITOS DE LA CEDULA");
        }

    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        // TODO add your handling code here:
        mostrardatos();
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        // TODO add your handling code here:
        try{
            //FileInputStream file = new FileInputStream(new File(ruta+"//Excel.xlsx"));
            Thread t = new Thread(){
                public void run(){

                    XSSFWorkbook workbook = new XSSFWorkbook();
                    XSSFSheet hoja = workbook.createSheet();

                    XSSFRow fila = hoja.createRow(0);
                    fila.createCell(0).setCellValue("id");
                    fila.createCell(1).setCellValue("Cedula");
                    fila.createCell(2).setCellValue("Nombres");
                    fila.createCell(3).setCellValue("Edad");
                    fila.createCell(4).setCellValue("Celular");
                    fila.createCell(5).setCellValue("Correo");
                    fila.createCell(6).setCellValue("Direccion");
                    fila.createCell(7).setCellValue("Fecha");
                    

                    jProgressBar1.setMaximum(tabladatos.getRowCount());
                    XSSFRow filas;
                    Rectangle rect;
                    for(int i=0; i<tabladatos.getRowCount(); i++){

                        rect = tabladatos.getCellRect(i, 0 , true);
                        try{
                            tabladatos.scrollRectToVisible(rect);
                        }catch(java.lang.ClassCastException e){}

                        tabladatos.setRowSelectionInterval(i, i);

                        jProgressBar1.setValue((i+1));

                        filas = hoja.createRow((i+1));
                        filas.createCell(0).setCellValue(tabladatos.getValueAt(i, 0).toString());
                        filas.createCell(1).setCellValue(tabladatos.getValueAt(i, 1).toString());
                        filas.createCell(2).setCellValue(tabladatos.getValueAt(i, 2).toString());
                        filas.createCell(3).setCellValue(tabladatos.getValueAt(i, 3).toString());
                        filas.createCell(4).setCellValue(tabladatos.getValueAt(i, 4).toString());
                        filas.createCell(5).setCellValue(tabladatos.getValueAt(i, 5).toString());
                        filas.createCell(6).setCellValue(tabladatos.getValueAt(i, 6).toString());
                        filas.createCell(7).setCellValue(tabladatos.getValueAt(i, 7).toString());
                        

                        try{
                            Thread.sleep(20);
                        }catch (InterruptedException ex){
                            Logger.getLogger(Ver_ventas.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                    jProgressBar1.setValue(0);
                    jProgressBar1.setString("Abriendo Excel...");
                    JOptionPane.showMessageDialog(null, "ARCHIVO CREADO");
                    try{
                        workbook.write(new FileOutputStream(new File(ruta+"//Empleados.xlsx")));
                        Desktop.getDesktop().open(new File(ruta+"//Empleados.xlsx"));
                    }catch(Exception ex){
                        Logger.getLogger(Ver_ventas.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            };
            t.start();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_btn_excelActionPerformed

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed
        // TODO add your handling code here:
        try {
            generar(lbl_name.getText());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_pdfActionPerformed

    private void tabladatosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabladatosMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_tabladatosMouseClicked

    private void txt_filtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_filtroKeyTyped
        txt_filtro.addKeyListener(new KeyAdapter(){

            public void keyReleased (final KeyEvent e){

                String cadena = (txt_filtro.getText());
                txt_filtro.setText(cadena);
                Filtro();
            }
        });
        TRSFiltro = new TableRowSorter(tabladatos.getModel());
        tabladatos.setRowSorter(TRSFiltro);
    }//GEN-LAST:event_txt_filtroKeyTyped
    //pdf   
    public void generar(String nombre) throws FileNotFoundException, DocumentException {
        FileOutputStream archivo = new FileOutputStream(nombre + ".pdf");
        Document documento = new Document();
        PdfWriter.getInstance(documento, archivo);
        documento.open();
        Paragraph parrafo = new Paragraph(empleados);
        
        parrafo.setAlignment(1);
        documento.add(parrafo);
        PdfPTable table = new PdfPTable(8);
        table.addCell(tabladatos.getColumnName(0));
        table.addCell(tabladatos.getColumnName(1));
        table.addCell(tabladatos.getColumnName(2));
        table.addCell(tabladatos.getColumnName(3));
        table.addCell(tabladatos.getColumnName(4));
        table.addCell(tabladatos.getColumnName(5));
        table.addCell(tabladatos.getColumnName(6));
        table.addCell(tabladatos.getColumnName(7));
        
        
        
        
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM empleados");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                table.addCell(rs.getString("id"));
                table.addCell(rs.getString("Cedula"));
                table.addCell(rs.getString("Nombres"));
                table.addCell(rs.getString("Edad"));
                table.addCell(rs.getString("Celular"));
                table.addCell(rs.getString("Correo"));
                table.addCell(rs.getString("Direccion"));
                table.addCell(rs.getString("Fecha"));
                
            }
            rs.close();
            ps.close();
            conn.close();
        } catch (Exception e) {
            System.out.println("ERROR" + e.getMessage());
        }
        
        
        documento.add(table);
        documento.close();
        JOptionPane.showMessageDialog(null, "ARCHIVO CREADO");
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JToggleButton btn_pdf;
    private javax.swing.JButton jButton7;
    private com.toedter.calendar.JCalendar jCalendar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JDateChooser jdt;
    private javax.swing.JTextField lbl_name;
    private javax.swing.JLabel lbl_v1;
    private javax.swing.JLabel lbl_v2;
    private javax.swing.JLabel lbl_v3;
    private javax.swing.JLabel lbl_v4;
    private javax.swing.JLabel lbl_v5;
    private javax.swing.JLabel lbl_v6;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_celular;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_filtro;
    private javax.swing.JTextField txt_nombres;
    // End of variables declaration//GEN-END:variables
}
