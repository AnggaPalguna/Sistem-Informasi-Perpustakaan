/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package projectuastest;

/**
 *
 * @author all
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class fKategori extends javax.swing.JFrame {

    /**
     * Creates new form Kategori
     */
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection net = sync.sync();
    
    public fKategori() {
        initComponents();
        judul();
        setTitle("Form Data Kategori");
        tampilData("");
        autonum();
        ikategori.setEditable(false);
        PUbah.setEnabled(false);
        PHapus.setEnabled(false);
    }
    
    private void tampilData(String string) {
         tabModel = (DefaultTableModel)tbkategori.getModel();
         tabModel.setRowCount(0);
         try {
             st = net.createStatement();
             rs = st.executeQuery("SELECT * FROM kategori ");
             String id_kategori;
             String nama_kategori;
             while(rs.next()){
                 id_kategori = rs.getString("id_kategori");
                 nama_kategori = rs.getString("nama_kategori");
                 tabModel.addRow(new Object[]{id_kategori, nama_kategori });
             }
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
         }
    
    public void tampil() {
         tabModel = (DefaultTableModel)tbkategori.getModel();
         tabModel.setRowCount(0);
         String src = TSearch.getText();
         try {
             st = net.createStatement();
             rs = st.executeQuery("SELECT * FROM kategori WHERE nama_kategori LIKE '%"+src+"%'");
             String id_kategori;
             String nama_kategori;
             while(rs.next()){
                 id_kategori = rs.getString("id_kategori");
                 nama_kategori = rs.getString("nama_kategori");
                 tabModel.addRow(new Object[]{id_kategori, nama_kategori });
             }
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
         }
    
    
    public void judul() {
    Object[] judul ={
    "id_kategori", "nama_kategori"
    };
    tabModel = new DefaultTableModel(null,judul);
    tbkategori.setModel(tabModel);
    }
    public void reset(){
    ikategori.setText("");
    knama.setText("");
    }
    public void autonum(){
       try{
           String sql = "SELECT MAX(RIGHT(id_kategori,2)) AS no_auto FROM kategori ";
           st = net.createStatement();
           rs = st.executeQuery(sql);
           
           if(rs.next()){
               String no_auto,nol_plus;
               int p;
               no_auto = Integer.toString(rs.getInt(1)+1);
               p = no_auto.length();
               nol_plus = "";
               for(int i =0;i<=2 -p;i++){
                   nol_plus = nol_plus+"0";
               }
               ikategori.setText("KT"+nol_plus+no_auto);
           }
       } catch (Exception e) {
           ikategori.setText("KT001");
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

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        PSimpan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbkategori = new javax.swing.JTable();
        jSlider1 = new javax.swing.JSlider();
        jPanel2 = new javax.swing.JPanel();
        idbuku = new javax.swing.JLabel();
        judul = new javax.swing.JLabel();
        ikategori = new javax.swing.JTextField();
        knama = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        TSearch = new javax.swing.JTextField();
        BSearch = new javax.swing.JButton();
        PTambah = new javax.swing.JButton();
        PUbah = new javax.swing.JButton();
        PHapus = new javax.swing.JButton();
        Kategori = new javax.swing.JLabel();
        BPinjam = new javax.swing.JButton();
        BBuku = new javax.swing.JButton();
        BUser = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jPanel4.setBackground(new java.awt.Color(255, 153, 153));

        PSimpan.setText("reset");
        PSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PSimpanActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));

        tbkategori.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Id_Kategori", "Nama_Kategori"
            }
        ));
        tbkategori.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbkategoriMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbkategori);

        jSlider1.setOrientation(javax.swing.JSlider.VERTICAL);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSlider1, javax.swing.GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        idbuku.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        idbuku.setText("ID Kategori");

        judul.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        judul.setText("nama_kategori");

        ikategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ikategoriActionPerformed(evt);
            }
        });

        knama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                knamaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(idbuku)
                    .addComponent(judul))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ikategori, javax.swing.GroupLayout.DEFAULT_SIZE, 215, Short.MAX_VALUE)
                    .addComponent(knama))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(11, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(idbuku)
                    .addComponent(ikategori, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(knama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(judul))
                .addGap(14, 14, 14))
        );

        BSearch.setText("Search");
        BSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(BSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(TSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 522, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PSimpan)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        PTambah.setText("Tambah");
        PTambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PTambahActionPerformed(evt);
            }
        });

        PUbah.setText("Ubah");
        PUbah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PUbahActionPerformed(evt);
            }
        });

        PHapus.setText("Hapus");
        PHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PHapusActionPerformed(evt);
            }
        });

        Kategori.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        Kategori.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Kategori.setText("Kategori");

        BPinjam.setText("Pinjam");
        BPinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BPinjamActionPerformed(evt);
            }
        });

        BBuku.setText("Buku");
        BBuku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BBukuActionPerformed(evt);
            }
        });

        BUser.setText("Data User");
        BUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BUserActionPerformed(evt);
            }
        });

        jButton1.setText("Home");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Kategori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)
                        .addGap(18, 18, 18)
                        .addComponent(BUser)
                        .addGap(18, 18, 18)
                        .addComponent(BBuku)
                        .addGap(18, 18, 18)
                        .addComponent(BPinjam)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PUbah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PTambah, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(BUser)
                        .addComponent(BBuku)
                        .addComponent(BPinjam)
                        .addComponent(jButton1))
                    .addComponent(Kategori, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(PTambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PUbah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(PHapus))
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(92, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(910, 675));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ikategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ikategoriActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ikategoriActionPerformed

    private void BSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BSearchActionPerformed
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_BSearchActionPerformed

    private void BBukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BBukuActionPerformed
        // TODO add your handling code here:
        fBuku fb = new fBuku();
        fb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BBukuActionPerformed

    private void BUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BUserActionPerformed
        // TODO add your handling code here:
        fUser fu = new fUser();
        fu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BUserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        fHome fh = new fHome();
        fh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void knamaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_knamaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_knamaActionPerformed

    private void PTambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PTambahActionPerformed
        // TODO add your handling code here:
        try{
        st=net.createStatement();
        st.executeUpdate("INSERT INTO kategori VALUES (' "+ikategori.getText()+"','"
        + knama.getText()+"')");
        tampilData("");
        JOptionPane.showMessageDialog(null, "Data berasal disimpan");
        reset();
        autonum();
        }catch (Exception e){
        e.printStackTrace();
        }
    }//GEN-LAST:event_PTambahActionPerformed

    private void tbkategoriMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbkategoriMouseClicked
        // TODO add your handling code here:
        ikategori.setText(tbkategori.getValueAt(tbkategori.getSelectedRow(),0).toString());
        knama.setText(tbkategori.getValueAt(tbkategori.getSelectedRow(),1).toString());
        PTambah.setEnabled(true);
        PUbah.setEnabled(true);
        PHapus.setEnabled(true);
    }//GEN-LAST:event_tbkategoriMouseClicked

    private void PSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PSimpanActionPerformed
        // TODO add your handling code here:
        reset();
        autonum();
    }//GEN-LAST:event_PSimpanActionPerformed

    private void PUbahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PUbahActionPerformed
        // TODO add your handling code here:
        try{
        st = net.createStatement();
        st.executeUpdate("Update kategori set id_kategori ='"+ikategori.getText()+"', nama_kategori = '"+knama.getText()+
                "' WHERE id_kategori = '"+ikategori.getText()+"'");
        tampilData("");
        JOptionPane.showMessageDialog(null, "Update Berhasil");
        reset();
        autonum();
        }catch(Exception e){
        e.printStackTrace();}
    }//GEN-LAST:event_PUbahActionPerformed

    private void PHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PHapusActionPerformed
        // TODO add your handling code here:
        try{
        int jawab;
        
        if((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data ?","konfirmasi",JOptionPane.YES_NO_OPTION))==0){
        st = net.createStatement();
        st.executeUpdate("DELETE FROM kategori WHERE id_kategori='"
        +tabModel.getValueAt(tbkategori.getSelectedRow(),0)+ "'");
        tampilData("");
        reset();
        autonum();
        }
        }catch(Exception e){
        e.printStackTrace();}
    }//GEN-LAST:event_PHapusActionPerformed

    private void BPinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BPinjamActionPerformed
        // TODO add your handling code here:
        fPinjam fp = new fPinjam();
        fp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BPinjamActionPerformed

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
            java.util.logging.Logger.getLogger(fKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fKategori.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fKategori().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BBuku;
    private javax.swing.JButton BPinjam;
    private javax.swing.JButton BSearch;
    private javax.swing.JButton BUser;
    private javax.swing.JLabel Kategori;
    private javax.swing.JButton PHapus;
    private javax.swing.JButton PSimpan;
    private javax.swing.JButton PTambah;
    private javax.swing.JButton PUbah;
    private javax.swing.JTextField TSearch;
    private javax.swing.JLabel idbuku;
    private javax.swing.JTextField ikategori;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel judul;
    private javax.swing.JTextField knama;
    private javax.swing.JTable tbkategori;
    // End of variables declaration//GEN-END:variables
}
