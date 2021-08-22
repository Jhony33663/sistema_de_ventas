/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import static APP.Cliente.getConnection;
import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;

/**
 *
 * @author Jhony
 */
public class Ingreso_productos extends javax.swing.JInternalFrame {

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
     * Creates new form Ingreso_productos
     */
    public Ingreso_productos() throws SQLException {
        initComponents();
        cargavendedor();
        ocultarvalidacion();
        transpareciabotones();

    }
    public void transpareciabotones() {
        btn_guardar.setOpaque(false);
        btn_guardar.setContentAreaFilled(false);
        btn_guardar.setBorderPainted(false);
        
        btn_consultar.setOpaque(false);
        btn_consultar.setContentAreaFilled(false);
        btn_consultar.setBorderPainted(false);
        
        btn_modificar.setOpaque(false);
        btn_modificar.setContentAreaFilled(false);
        btn_modificar.setBorderPainted(false);
        
        btn_limpiar.setOpaque(false);
        btn_limpiar.setContentAreaFilled(false);
        btn_limpiar.setBorderPainted(false);
        
        btn_eliminar.setOpaque(false);
        btn_eliminar.setContentAreaFilled(false);
        btn_eliminar.setBorderPainted(false);
        
        btn_back.setOpaque(false);
        btn_back.setContentAreaFilled(false);
        btn_back.setBorderPainted(false);
        
        btn_buscar.setOpaque(false);
        btn_buscar.setContentAreaFilled(false);
        btn_buscar.setBorderPainted(false);
    }
    
    //mostrar campos
    public void mostrarvalidacion() {
        lbl_aviso.setVisible(true);
        lbl_aviso1.setVisible(true);
        lbl_aviso2.setVisible(true);
        lbl_aviso3.setVisible(true);
        lbl_aviso4.setVisible(true);
        lbl_aviso5.setVisible(true);
        lbl_aviso6.setVisible(true);
        if (txt_cedula.getText().isEmpty()) {
            lbl_aviso7.setVisible(true);
        } else {
            lbl_aviso7.setVisible(false);
        }
    }

    public void ocultarvalidacion() {
        lbl_aviso.setVisible(false);
        lbl_aviso1.setVisible(false);
        lbl_aviso2.setVisible(false);
        lbl_aviso3.setVisible(false);
        lbl_aviso4.setVisible(false);
        lbl_aviso5.setVisible(false);
        lbl_aviso6.setVisible(false);
        lbl_aviso7.setVisible(false);
    }

    //limpiar cajas
    public void limpiarcajas() {
        txt_cedula.setText(null);
        txt_comprador.setText(null);
        txt_cantidad.setText(null);
        jdt.setDate(null);
        txt_producto.setText(null);
        txt_precio.setText(null);
        txt_telefono.setText(null);
        txt_correo.setText(null);
        txt_edad.setText(null);
        cbx_factura.setSelectedIndex(0);
        txt_total.setText(null);
        txt_subtotal.setText(null);
        txt_iva.setText(null);
    }

    //validar mail 
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

//cargartrabajador
    public void cargavendedor() throws SQLException {
        Connection conn = null;
        List<String> esp = new ArrayList<String>();
        int i = 0;

        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM empleados");
            rs = ps.executeQuery();

            while (rs.next()) {
                esp.add(rs.getString("Nombres"));
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
        while (i < esp.size()) {
            cbx_vendedor.addItem(esp.get(i));
            i++;
        }
        conn.close();
    }

    /*    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbx_vendedor = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        txt_subtotal = new javax.swing.JTextField();
        txt_iva = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        btn_consultar = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        btn_buscar = new javax.swing.JButton();
        lbl_aviso = new javax.swing.JLabel();
        lbl_aviso1 = new javax.swing.JLabel();
        lbl_aviso2 = new javax.swing.JLabel();
        lbl_aviso3 = new javax.swing.JLabel();
        lbl_aviso4 = new javax.swing.JLabel();
        lbl_aviso5 = new javax.swing.JLabel();
        lbl_aviso6 = new javax.swing.JLabel();
        lbl_aviso7 = new javax.swing.JLabel();
        txt_total = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        cbx_factura = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_edad = new javax.swing.JTextField();
        txt_correo = new javax.swing.JTextField();
        jdt = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txt_telefono = new javax.swing.JTextField();
        txt_precio = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_producto = new javax.swing.JTextField();
        txt_cantidad = new javax.swing.JTextField();
        btn_guardar = new javax.swing.JButton();
        btn_modificar = new javax.swing.JButton();
        txt_comprador = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btn_back = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("INGRESO PRODUCTOS");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbx_vendedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione" }));
        jPanel1.add(cbx_vendedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 160, -1));

        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("VENDEDOR");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 500, -1, -1));

        txt_subtotal.setEditable(false);
        jPanel1.add(txt_subtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 70, -1));

        txt_iva.setEditable(false);
        jPanel1.add(txt_iva, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 490, 70, -1));

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("IVA");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 460, -1, -1));

        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("SUBTOTAL");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 460, -1, -1));

        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/consultar.png"))); // NOI18N
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_consultar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 210, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/eliminar2.png"))); // NOI18N
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, 210, -1));

        btn_limpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/limpiar.png"))); // NOI18N
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_limpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 210, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/buscar3.png"))); // NOI18N
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, -1, -1));

        lbl_aviso.setForeground(new java.awt.Color(255, 153, 0));
        lbl_aviso.setText("CAMPO OBLIGATORIO (*)");
        jPanel1.add(lbl_aviso, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 210, -1, -1));

        lbl_aviso1.setForeground(new java.awt.Color(255, 153, 0));
        lbl_aviso1.setText("CAMPO OBLIGATORIO (*)");
        jPanel1.add(lbl_aviso1, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        lbl_aviso2.setForeground(new java.awt.Color(255, 153, 0));
        lbl_aviso2.setText("CAMPO OBLIGATORIO (*)");
        jPanel1.add(lbl_aviso2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 290, -1, -1));

        lbl_aviso3.setForeground(new java.awt.Color(255, 153, 0));
        lbl_aviso3.setText("CAMPO OBLIGATORIO (*)");
        jPanel1.add(lbl_aviso3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 290, -1, -1));

        lbl_aviso4.setForeground(new java.awt.Color(255, 153, 0));
        lbl_aviso4.setText("CAMPO OBLIGATORIO (*)");
        jPanel1.add(lbl_aviso4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        lbl_aviso5.setForeground(new java.awt.Color(255, 153, 0));
        lbl_aviso5.setText("CAMPO OBLIGATORIO (*)");
        jPanel1.add(lbl_aviso5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 370, -1, -1));

        lbl_aviso6.setForeground(new java.awt.Color(255, 153, 0));
        lbl_aviso6.setText("CAMPO OBLIGATORIO (*)");
        jPanel1.add(lbl_aviso6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 450, -1, -1));

        lbl_aviso7.setForeground(new java.awt.Color(255, 153, 0));
        lbl_aviso7.setText("CAMPO OBLIGATORIO (*)");
        jPanel1.add(lbl_aviso7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 140, -1, -1));

        txt_total.setEditable(false);
        jPanel1.add(txt_total, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 180, -1));

        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("TOTAL");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 530, -1, -1));

        cbx_factura.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione", "Consumidor Final", "Cliente" }));
        jPanel1.add(cbx_factura, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 150, -1));

        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("TIPO DE FACTURACION");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 390, -1, -1));

        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("EDAD");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, -1, -1));

        txt_edad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_edadKeyTyped(evt);
            }
        });
        jPanel1.add(txt_edad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 420, 160, -1));

        txt_correo.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_correoFocusLost(evt);
            }
        });
        jPanel1.add(txt_correo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 220, -1));
        jPanel1.add(jdt, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 150, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("CORREO ELECTRONICO");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, -1, -1));
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 160, -1));

        txt_precio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_precioKeyTyped(evt);
            }
        });
        jPanel1.add(txt_precio, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 260, 150, -1));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("TELEFONO");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 320, 80, -1));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("PRECIO");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("PRODUCTO");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 240, 70, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("FECHA DE COMPRA");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("CANTIDAD");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, -1, -1));

        txt_producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_productoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_producto, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 260, 160, -1));

        txt_cantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cantidadKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 160, -1));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/guardar2.png"))); // NOI18N
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 210, -1));

        btn_modificar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/modificar.png"))); // NOI18N
        btn_modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_modificarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_modificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 210, 50));

        txt_comprador.setEditable(false);
        jPanel1.add(txt_comprador, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 110, 230, -1));

        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 110, 160, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CEDULA");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("COMPRADOR");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 90, -1, -1));

        btn_back.setForeground(new java.awt.Color(255, 255, 255));
        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/REGRESAR_1.png"))); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, 210, -1));

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/ingreso de productos.png"))); // NOI18N
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 52, 650, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 60, 20, 510));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/producto.png"))); // NOI18N
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/carrito.png"))); // NOI18N
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 480, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Frame 1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        if (txt_cedula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor verifique los campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
            lbl_aviso7.setVisible(true);
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
                if (txt_comprador.getText().isEmpty() || txt_cantidad.getText().isEmpty() || txt_producto.getText().isEmpty() || txt_precio.getText().isEmpty() || txt_telefono.getText().isEmpty()
                        || txt_correo.getText().isEmpty() || txt_edad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor verifique los campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
                    mostrarvalidacion();
                } else {
                    float ca = Float.parseFloat((txt_cantidad.getText()));
                    float pro = Float.parseFloat((txt_precio.getText()));
                    float iva = (float) 1.12;

                    float preciosiniva;
                    float preciosiniva1;
                    float subtotal;
                    float total;
                    float calculoiva;
                    preciosiniva = ca * pro;
                    preciosiniva1 = ca * pro;
                    subtotal = preciosiniva / iva;
                    calculoiva = subtotal - preciosiniva;
                    String sbt = Float.toString(subtotal);
                    String cli = Float.toString(calculoiva);
                    txt_subtotal.setText(sbt);
                    txt_iva.setText(cli);
                    float sb = Float.parseFloat(txt_subtotal.getText());
                    float iv = Float.parseFloat(txt_iva.getText());
                    total = preciosiniva1;

                    String tt = Float.toString(total);

                    txt_total.setText(tt);

                    ocultarvalidacion();
                    Connection conn = null;
                    try {
                        //conexion a bd
                        conn = getConnection();
                        //datos y transformo a valores correspondientes
                        //consuta a la tabla
                        ps = conn.prepareStatement("INSERT INTO `ventas`(`Cedula`, `Nombres`, `Cantidad`, `Fecha`, `Producto`, `Precio`, `Telefono`, `Correo`, `Edad`, `Tipo`, `Vendedor`, `Total`)" + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
                        ps.setString(1, txt_cedula.getText());
                        ps.setString(2, txt_comprador.getText());
                        ps.setString(3, txt_cantidad.getText());
                        ps.setString(4, ((JTextField) jdt.getDateEditor().getUiComponent()).getText());
                        ps.setString(5, txt_producto.getText());
                        ps.setString(6, txt_precio.getText());
                        ps.setString(7, txt_telefono.getText());
                        ps.setString(8, txt_correo.getText());
                        ps.setString(9, txt_edad.getText());
                        ps.setString(10, cbx_factura.getSelectedItem().toString());
                        ps.setString(11, cbx_vendedor.getSelectedItem().toString());
                        ps.setString(12, txt_total.getText());

                        //ejecute consulta y valores
                        //execute accion de incerscion 
                        //res envia msg
                        int res = ps.executeUpdate();
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "VALORES ALMACENADOS");
                            ocultarvalidacion();
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
        if (txt_cedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "LLENE LOS CAMPOS PARA CONSULTAR", "ERROR", JOptionPane.WARNING_MESSAGE);
            lbl_aviso7.setVisible(true);
        } else {
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
                    if (txt_cedula.getText().length() > 0) {
                        lbl_aviso7.setVisible(false);
                    }
                    JOptionPane.showMessageDialog(null, "CEDULA CORRECTA");
                    try {
                        conn = getConnection();
                        ps = conn.prepareStatement("SELECT * FROM clientes WHERE dni=?");
                        ps.setString(1, txt_cedula.getText());
                        rs = ps.executeQuery();
                        if (rs.next()) {
                            txt_cedula.setText(rs.getString("dni"));
                            txt_comprador.setText(rs.getString("Nombres"));
                            txt_telefono.setText(rs.getString("Telefono"));
                        } else {
                            JOptionPane.showMessageDialog(null, "No existe la cedula");
                            limpiarcajas();
                        }

                        conn.close();
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "CEDULA INCORRECTA");
                }
            } else {
                JOptionPane.showMessageDialog(null, "VERIFIQUE LOS DIGITOS DE LA CEDULA");
            }
            Connection conn = null;
        }

    }//GEN-LAST:event_btn_buscarActionPerformed

    private void btn_modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_modificarActionPerformed
        // TODO add your handling code here:
        if (txt_cedula.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Por favor verifique los campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
            lbl_aviso7.setVisible(true);
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
                if (txt_comprador.getText().isEmpty() || txt_cantidad.getText().isEmpty() || txt_producto.getText().isEmpty() || txt_precio.getText().isEmpty() || txt_telefono.getText().isEmpty()
                        || txt_correo.getText().isEmpty() || txt_edad.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor verifique los campos obligatorios", "ERROR", JOptionPane.WARNING_MESSAGE);
                    mostrarvalidacion();
                } else {
                    float ca = Float.parseFloat((txt_cantidad.getText()));
                    float pro = Float.parseFloat((txt_precio.getText()));
                    float iva = (float) 1.21;
                    float total;
                    float subtotal;
                    float preciosininva = ca * pro;
                    float preciosininva1 = ca * pro;
                    float calculoiva;
                    subtotal = (float) (preciosininva / 1.12);
                    calculoiva = subtotal - preciosininva1;
                    total = preciosininva1;

                    String tt = Float.toString(total);
                    String sbt = Float.toString(subtotal);
                    String cli = Float.toString(calculoiva);
                    txt_subtotal.setText(sbt);
                    txt_iva.setText(cli);
                    txt_total.setText(tt);

                    ocultarvalidacion();
                    Connection conn = null;
                    String date = ((JTextField) jdt.getDateEditor().getUiComponent()).getText();
                    try {
                        conn = getConnection();
                        ps = conn.prepareStatement("UPDATE ventas SET Nombres=?,Cantidad=?, Fecha=?,Producto=?,Precio=?,Telefono=?,Correo=?,Edad=?,Tipo=?,Vendedor=?,Total=? WHERE Cedula=?");

                        ps.setString(1, txt_comprador.getText());
                        ps.setString(2, txt_cantidad.getText());
                        ps.setString(3, ((JTextField) jdt.getDateEditor().getUiComponent()).getText());
                        ps.setString(4, txt_producto.getText());
                        ps.setString(5, txt_precio.getText());
                        ps.setString(6, txt_telefono.getText());
                        ps.setString(7, txt_correo.getText());
                        ps.setString(8, txt_edad.getText());
                        ps.setString(9, cbx_factura.getSelectedItem().toString());
                        ps.setString(10,cbx_vendedor.getSelectedItem().toString());
                        txt_total.setText(tt);
                        ps.setString(11, txt_total.getText());
                        
                        ps.setString(12, txt_cedula.getText());
                        int res = ps.executeUpdate();
                        if (res > 0) {
                            JOptionPane.showMessageDialog(null, "Valores Almacenados");
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
        /*        */
    }//GEN-LAST:event_btn_modificarActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        // TODO add your handling code here:
        if (txt_comprador.getText().isEmpty() || txt_cantidad.getText().isEmpty() || txt_producto.getText().isEmpty() || txt_precio.getText().isEmpty() || txt_telefono.getText().isEmpty()
                || txt_correo.getText().isEmpty() || txt_edad.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "NO EXISTEN DATOS PARA LIMPIAR", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else {
            limpiarcajas();
        }

    }//GEN-LAST:event_btn_limpiarActionPerformed

    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void txt_productoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_productoKeyTyped
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Caracteres De Texto...");
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txt_productoKeyTyped

    private void txt_precioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_precioKeyTyped
        char caracter = evt.getKeyChar();
        if (((caracter < '0') || (caracter > '9'))
                && (caracter != KeyEvent.VK_BACK_SPACE)
                && (caracter != '.' || txt_precio.getText().contains("."))) {
            evt.consume();
        }         // TODO add your handling code here:
    }//GEN-LAST:event_txt_precioKeyTyped

    private void txt_cantidadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cantidadKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();          // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantidadKeyTyped

    private void txt_edadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_edadKeyTyped
        char c = evt.getKeyChar();
        if (c < '0' || c > '9')
            evt.consume();          // TODO add your handling code here:
    }//GEN-LAST:event_txt_edadKeyTyped

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM ventas WHERE Cedula=?");
            ps.setString(1, txt_cedula.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txt_cedula.setText(rs.getString("Cedula"));
                txt_comprador.setText(rs.getString("Nombres"));
                txt_cantidad.setText(rs.getString("Cantidad"));
                String date = rs.getString("Fecha");
                ((JTextField) jdt.getDateEditor().getUiComponent()).setText(date);
                txt_producto.setText(rs.getString("Producto"));
                txt_precio.setText(rs.getString("Precio"));
                txt_telefono.setText(rs.getString("Telefono"));
                txt_correo.setText(rs.getString("Correo"));
                txt_edad.setText(rs.getString("Edad"));
                cbx_factura.setSelectedItem(rs.getString("Tipo"));
                txt_total.setText(rs.getString("Total"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe la cedula");
                limpiarcajas();
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_btn_consultarActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        if (txt_cedula.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "DEBE ELIMINAR DESDE EL NUMERO DE CEDULA");
        } else {
            Connection conn = null;
            try {
                conn = getConnection();
                ps = conn.prepareStatement("DELETE FROM ventas WHERE Cedula=?");
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

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btn_backActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JButton btn_guardar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JButton btn_modificar;
    private javax.swing.JComboBox<String> cbx_factura;
    private javax.swing.JComboBox<String> cbx_vendedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private com.toedter.calendar.JDateChooser jdt;
    private javax.swing.JLabel lbl_aviso;
    private javax.swing.JLabel lbl_aviso1;
    private javax.swing.JLabel lbl_aviso2;
    private javax.swing.JLabel lbl_aviso3;
    private javax.swing.JLabel lbl_aviso4;
    private javax.swing.JLabel lbl_aviso5;
    private javax.swing.JLabel lbl_aviso6;
    private javax.swing.JLabel lbl_aviso7;
    private javax.swing.JTextField txt_cantidad;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_comprador;
    private javax.swing.JTextField txt_correo;
    private javax.swing.JTextField txt_edad;
    private javax.swing.JTextField txt_iva;
    private javax.swing.JTextField txt_precio;
    private javax.swing.JTextField txt_producto;
    private javax.swing.JTextField txt_subtotal;
    private javax.swing.JTextField txt_telefono;
    private javax.swing.JTextField txt_total;
    // End of variables declaration//GEN-END:variables
}
