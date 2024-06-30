/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package instock2;
import javax.swing.JTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static instock2.koneksi.getKoneksi;
import javax.swing.table.DefaultTableModel;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;


/**
 *
 * @author erick
 */
public class INPUTFORM extends javax.swing.JFrame {

   
    DefaultTableModel TM = new DefaultTableModel();

    public INPUTFORM() throws SQLException  {
        initComponents();
        instock_table.setModel(TM);
        TM.addColumn("id_brg");
        TM.addColumn("nama_brg");
        TM.addColumn("jumlah");
        TM.addColumn("kondisi");
        TM.addColumn("tgl_input");
        
        List_all();
        kosongkanform();
//        loadphoto("");
    }

   private void loadphoto(String idx){
        String nopic = "src/img/nopic.png";
        String img = "src/img/"+idx+".png";

        BufferedImage phototeman = inputimg.loadImage(img);
        if (phototeman == null) {
            phototeman = inputimg.loadImage(nopic);
        }
        ImageIcon iconphoto = new ImageIcon(phototeman);
        imgData.setIcon(iconphoto);
    }
   
    private void List_all () throws SQLException {
        
        TM.getDataVector().removeAllElements();       
        TM.fireTableDataChanged();
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
            
            String sql = "SELECT * FROM barang_instockk";
            PreparedStatement PS = cnn.prepareStatement(sql);
            ResultSet rs = PS.executeQuery();
            
            while(rs.next()){
                
                String idBrg = rs.getString("id_brg");
                String namaBrg = rs.getString("nama_brg");
                String jumlah = rs.getString("jumlah");
                String kondisi = rs.getString("kondisi");
                String tglInput = rs.getString("tgl_input");
        
                Object[] dta = new Object[5];
                dta [0] = idBrg;
                dta [1] = namaBrg;
                dta [2] = jumlah;
                dta [3] = kondisi;
                dta [4] = tglInput;
                TM.addRow(dta);

                hasil_id.setText(idBrg);
                hasil_nama.setText(namaBrg);
                hasil_jumlah.setText(jumlah);
                hasil_kondisi.setText(kondisi);
                hasil_tgl.setText(tglInput);
            }
           
        }
        
    }
    
    private  void storeData() throws SQLException{
        Connection cnn = getKoneksi();
        String nama = txtNama.getText();
        String jumlah = txtJumlah.getText();
        String kondisi = txtKondisi.getText();
        String tgl = txtTanggal.getText();
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "INSERT INTO barang_instockk(nama_brg,jumlah,kondisi,tgl_input) VALUES (?,?,?,?);");
            PS.setString(1, nama);
            PS.setString(2, jumlah);
            PS.setString(3 ,kondisi);
            PS.setString(4, tgl);
            PS.executeUpdate();
        }

    }
    
    private void updateData() throws SQLException {
        Connection cnn = getKoneksi();
        
        if(!cnn.isClosed()){
            PreparedStatement PS = cnn.prepareStatement(
            "UPDATE barang_instockk SET nama_brg=?,jumlah=?,kondisi=?,tgl_input=? WHERE id_brg =?;");
            PS.setString(1, txtNama.getText());
            PS.setString(2, txtJumlah.getText());
            PS.setString(3, txtKondisi.getText());
            PS.setString(4 ,txtTanggal.getText());
            PS.setString(5 ,hasil_id.getText());
            PS.executeUpdate();
            cnn.close();
        }
        
    }
    
    private void destroyData() throws SQLException {
        
        Connection cnn = getKoneksi();
        if(!cnn.isClosed()){
        
            PreparedStatement PS = cnn.prepareStatement(
            "DELETE FROM barang_instockk WHERE id_brg =?;");
            PS.setString(1, hasil_id.getText());
            PS.executeUpdate();
            cnn.close();
        }

    }
    
    private void kosongkanform(){
        
        txtNama.setText("");
        txtJumlah.setText("");
        txtKondisi.setText("");
        txtTanggal.setText("");
    }
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        instock_table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        imgData = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNama = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        txtKondisi = new javax.swing.JTextField();
        txtTanggal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnInput = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnTutup = new javax.swing.JButton();
        hasil_id = new javax.swing.JLabel();
        hasil_nama = new javax.swing.JLabel();
        hasil_jumlah = new javax.swing.JLabel();
        hasil_kondisi = new javax.swing.JLabel();
        hasil_tgl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        instock_table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Id barang", "Nama Barang", "Jumlah", "Kondisi Barang", "Tanggal Input"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        instock_table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                instock_tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(instock_table);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SISTEM INPUT SARANA PRASARANA INSTIKI ( INSTOCK )");

        imgData.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 5));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Form Input");

        txtNama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNamaActionPerformed(evt);
            }
        });

        jLabel4.setText("Nama barang ");

        jLabel5.setText("Jumlah Barang ");

        jLabel6.setText("Kondisi ");

        jLabel7.setText("Tanggal Input ");

        btnInput.setText("Input");
        btnInput.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnInputMouseClicked(evt);
            }
        });
        btnInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInputActionPerformed(evt);
            }
        });

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnTutup.setText("TUTUP FORM");
        btnTutup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTutupActionPerformed(evt);
            }
        });

        hasil_id.setText("id_barang");

        hasil_nama.setText("nama_barang");

        hasil_jumlah.setText("jumlah_barang");

        hasil_kondisi.setText("kondisi_barang");

        hasil_tgl.setText("tanggal_input");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTanggal, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtKondisi, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtJumlah, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(txtNama, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(btnTutup, javax.swing.GroupLayout.DEFAULT_SIZE, 427, Short.MAX_VALUE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                                .addComponent(imgData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(62, 62, 62))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnInput, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnUpdate, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnHapus, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hasil_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hasil_nama, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hasil_jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(hasil_kondisi, javax.swing.GroupLayout.DEFAULT_SIZE, 187, Short.MAX_VALUE)
                                    .addComponent(hasil_tgl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(imgData, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(hasil_id, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hasil_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hasil_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(hasil_kondisi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(hasil_tgl, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtJumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtKondisi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTanggal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnInput, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnHapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(btnTutup, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtNamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNamaActionPerformed

    private void btnTutupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTutupActionPerformed
        if(btnTutup.getText().equals("Tutup Form")){
            dispose();
        }else{
            btnTutup.setText("Tutup Form");
            btnInput.setText("Input");
        }
    }//GEN-LAST:event_btnTutupActionPerformed

    private void instock_tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_instock_tableMouseClicked
        hasil_id.setText(instock_table.getValueAt( instock_table.getSelectedRow(),0).toString());
        txtNama.setText(instock_table.getValueAt( instock_table.getSelectedRow(),1).toString());
        txtJumlah.setText(instock_table.getValueAt( instock_table.getSelectedRow(),2).toString());
        txtKondisi.setText(instock_table.getValueAt( instock_table.getSelectedRow(),3).toString());
        txtTanggal.setText(instock_table.getValueAt( instock_table.getSelectedRow(),4).toString());
        hasil_nama.setText(instock_table.getValueAt( instock_table.getSelectedRow(),1).toString());
        hasil_jumlah.setText(instock_table.getValueAt( instock_table.getSelectedRow(),2).toString());
        hasil_kondisi.setText(instock_table.getValueAt( instock_table.getSelectedRow(),3).toString());
        hasil_tgl.setText(instock_table.getValueAt( instock_table.getSelectedRow(),4).toString());
        loadphoto(hasil_id.getText());
    }//GEN-LAST:event_instock_tableMouseClicked

    private void btnInputMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInputMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInputMouseClicked

    private void btnInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInputActionPerformed
        if(btnInput.getText().equals("Input")){
        btnInput.setText("Simpan");
        btnTutup.setText("Batal");
        kosongkanform();
        instock_table.setEnabled(false);
        }else{
            btnInput.setText("Input");
            btnTutup.setText("Tutup Form");
            instock_table.setEnabled(true);
            try {
                storeData();
                List_all();
            } catch (SQLException ex) {
                Logger.getLogger(INPUTFORM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnInputActionPerformed

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
        if(btnUpdate.getText().equals("update")){
        btnUpdate.setText("Simpan");
        btnTutup.setText("Batal");
        }else{
            btnUpdate.setText("update");
            btnTutup.setText("Tutup Form");
        try {
                updateData();
                List_all();
                JOptionPane.showMessageDialog(this, "Data telah diupdate");
            } catch (SQLException ex) {
                Logger.getLogger(INPUTFORM.class.getName()).log(Level.SEVERE, null, ex);
            }
        }     
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        int jwb = JOptionPane.showOptionDialog(
                this, 
                "Apakah anda yakin akan menghapus data dengan nim : "+ hasil_id.getText() + "?" , 
                "Hapus data", 
                JOptionPane.YES_NO_OPTION, 
                JOptionPane.WARNING_MESSAGE, 
                null, 
                null, 
                null);
        if(jwb == JOptionPane.YES_OPTION){
           try {
            destroyData();
            List_all();
            JOptionPane.showMessageDialog(this, "Data telah dihapus");
        } catch (SQLException ex) {
            Logger.getLogger(INPUTFORM.class.getName()).log(Level.SEVERE, null, ex);
        }  
        }
    }//GEN-LAST:event_btnHapusActionPerformed

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
            java.util.logging.Logger.getLogger(INPUTFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INPUTFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INPUTFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INPUTFORM.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new INPUTFORM().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(INPUTFORM.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnInput;
    private javax.swing.JButton btnTutup;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JLabel hasil_id;
    private javax.swing.JLabel hasil_jumlah;
    private javax.swing.JLabel hasil_kondisi;
    private javax.swing.JLabel hasil_nama;
    private javax.swing.JLabel hasil_tgl;
    private javax.swing.JLabel imgData;
    private javax.swing.JTable instock_table;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtKondisi;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTanggal;
    // End of variables declaration//GEN-END:variables
}
