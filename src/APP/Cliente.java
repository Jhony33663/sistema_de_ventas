/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package APP;

import com.mysql.jdbc.Connection;
import java.awt.HeadlessException;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.*;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.table.DefaultTableModel;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author jonad
 */
public class Cliente extends javax.swing.JInternalFrame {

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
     * Creates new form Cliente
     */
    public Cliente() {
        initComponents();
        transpareciabotones();
        this.table.setModel(modelo);
        this.modelo.addColumn("Cedula / Ruc");
        this.modelo.addColumn("Nombres");
        this.modelo.addColumn("Telefono");
        this.modelo.addColumn("Dirección");
        this.modelo.addColumn("Razon Social");
    }

    public void limpiarcajas() {
        txt_cedula.setText(null);
        txt_direccion.setText(null);
        txt_nombres.setText(null);
        txt_razon.setText(null);
        txt_telefono.setText(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    DefaultTableModel modelo = new DefaultTableModel();

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txt_razon = new javax.swing.JTextField();
        txt_direccion = new javax.swing.JTextField();
        txt_telefono = new javax.swing.JTextField();
        txt_nombres = new javax.swing.JTextField();
        txt_cedula = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btn_mostrar = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        btn_eliminar = new javax.swing.JButton();
        btn_guardar = new javax.swing.JToggleButton();
        btn_buscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Cliente");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_razon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_razonKeyTyped(evt);
            }
        });
        jPanel1.add(txt_razon, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 240, -1));

        txt_direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_direccionKeyTyped(evt);
            }
        });
        jPanel1.add(txt_direccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 240, -1));

        txt_telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_telefonoKeyTyped(evt);
            }
        });
        jPanel1.add(txt_telefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 190, 240, -1));

        txt_nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_nombresKeyTyped(evt);
            }
        });
        jPanel1.add(txt_nombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 240, -1));

        txt_cedula.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cedulaActionPerformed(evt);
            }
        });
        txt_cedula.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_cedulaKeyTyped(evt);
            }
        });
        jPanel1.add(txt_cedula, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 240, -1));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cedula / Ruc", "Nombres", "Telefono", "Dirección", "Razon Social"
            }
        ));
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setPreferredWidth(50);
            table.getColumnModel().getColumn(1).setPreferredWidth(100);
            table.getColumnModel().getColumn(2).setPreferredWidth(50);
            table.getColumnModel().getColumn(3).setPreferredWidth(80);
            table.getColumnModel().getColumn(4).setPreferredWidth(80);
        }

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 570, 590));

        btn_mostrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Group 49.png"))); // NOI18N
        btn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mostrarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_mostrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 180, 70));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_new_copy_32px.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 430, -1, -1));

        btn_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_delete_24px.png"))); // NOI18N
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_eliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 500, 230, 40));

        btn_guardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/save_32px.png"))); // NOI18N
        btn_guardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_guardarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 430, -1, -1));

        btn_buscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/icons8_update_32px.png"))); // NOI18N
        btn_buscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 60, -1));

        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Razon Social");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 290, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Dirección");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 230, -1, -1));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 170, -1, -1));

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombres");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 100, -1, 20));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cedula / Ruc");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/Frame 1.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, 0, 1100, 670));

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

    private void txt_cedulaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cedulaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cedulaActionPerformed

    private void btn_guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_guardarActionPerformed
        // TODO add your handling code here:
        if (txt_cedula.getText().length() > 0 && txt_nombres.getText().length() > 0 && txt_telefono.getText().length() > 0 && txt_direccion.getText().length() > 0 && txt_razon.getText().length() > 0) {
            this.modelo.addRow(new Object[]{this.txt_cedula.getText(), this.txt_nombres.getText(), this.txt_telefono.getText(),
                this.txt_direccion.getText(), this.txt_razon.getText()});
            Connection conn = null;
            try {
                //conexion a bd
                conn = getConnection();
                //datos y transformo a valores correspondientes
                //consuta a la tabla
                ps = conn.prepareStatement("INSERT INTO `clientes`(`dni`, `nombres`, `telefono`, `direccion`, `razon`)" + "VALUES(?,?,?,?,?)");
                ps.setString(1, txt_cedula.getText());
                ps.setString(2, txt_nombres.getText());
                ps.setString(3, txt_telefono.getText());
                ps.setString(4, txt_direccion.getText());
                ps.setString(5, txt_razon.getText());

                //ejecute consulta y valores
                //execute accion de incerscion 
                //res envia msg
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
        } else {
            JOptionPane.showMessageDialog(rootPane, "Los Campos Deben Estar Llenos ...");
        }
    }//GEN-LAST:event_btn_guardarActionPerformed

    private void txt_cedulaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cedulaKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese Solo numeros de 10 digitos...");
        }
    }//GEN-LAST:event_txt_cedulaKeyTyped

    private void txt_nombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nombresKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Caracteres De Texto...");
        }
    }//GEN-LAST:event_txt_nombresKeyTyped

    private void txt_telefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_telefonoKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isLetter(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese Solo numeros de 10 digitos...");
        }
    }//GEN-LAST:event_txt_telefonoKeyTyped

    private void txt_direccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_direccionKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Caracteres De Texto...");
        }
    }//GEN-LAST:event_txt_direccionKeyTyped

    private void txt_razonKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_razonKeyTyped
        // TODO add your handling code here:
        char validar = evt.getKeyChar();
        if (Character.isDigit(validar)) {
            getToolkit().beep();
            evt.consume();
            JOptionPane.showMessageDialog(rootPane, "Ingrese Solo Caracteres De Texto...");
        }
    }//GEN-LAST:event_txt_razonKeyTyped

        public void transpareciabotones() {
        btn_mostrar.setOpaque(false);
        btn_mostrar.setContentAreaFilled(false);
        btn_mostrar.setBorderPainted(false);
        }
        
    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("SELECT * FROM clientes WHERE dni=?");
            ps.setString(1, txt_cedula.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                txt_cedula.setText(rs.getString("dni"));
                txt_nombres.setText(rs.getString("nombres"));
                txt_telefono.setText(rs.getString("telefono"));
                txt_direccion.setText(rs.getString("direccion"));
                txt_razon.setText(rs.getString("razon"));
            } else {
                JOptionPane.showMessageDialog(null, "No existe el numero de cedula");
                limpiarcajas();
            }

            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }//GEN-LAST:event_btn_buscarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("UPDATE clientes SET nombres=?, telefono=?, direccion=?, razon=? WHERE dni=?");
            
            ps.setString(1, txt_nombres.getText());
            ps.setString(2, txt_telefono.getText());
            ps.setString(3, txt_direccion.getText());
            ps.setString(4, txt_razon.getText());
            ps.setString(5, txt_cedula.getText());
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Valores Actualizados con exito");
                limpiarcajas();
            } else {
                JOptionPane.showMessageDialog(null, "ERROR VERIFIQUE LOS CAMPOS AL ACTUALIZAR");
                limpiarcajas();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btn_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_eliminarActionPerformed
        // TODO add your handling code here:
        Connection conn = null;
        try {
            conn = getConnection();
            ps = conn.prepareStatement("DELETE FROM clientes WHERE dni=?");
            ps.setInt(1, Integer.parseInt(txt_cedula.getText()));
            int res = ps.executeUpdate();
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Datos eliminados");
                limpiarcajas();
            } else {

                JOptionPane.showMessageDialog(null, "Error al eliminar datos");
                limpiarcajas();
            }
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }        
    }//GEN-LAST:event_btn_eliminarActionPerformed

    private void btn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mostrarActionPerformed
        // TODO add your handling code here:
        Imprimir_tabla framet = new Imprimir_tabla();
        this.setVisible(false);
        framet.setVisible(true);
    }//GEN-LAST:event_btn_mostrarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_buscar;
    private javax.swing.JButton btn_eliminar;
    private javax.swing.JToggleButton btn_guardar;
    private javax.swing.JToggleButton btn_mostrar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_cedula;
    private javax.swing.JTextField txt_direccion;
    private javax.swing.JTextField txt_nombres;
    private javax.swing.JTextField txt_razon;
    private javax.swing.JTextField txt_telefono;
    // End of variables declaration//GEN-END:variables
}
