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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class fPinjam extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    public Statement st;
    public ResultSet rs;
    public DefaultTableModel tabModel;
    Connection net = sync.sync();
    
    public fPinjam() {
        initComponents();
        tampilData("");
        autonum();
        setTitle("form data pinjam");
        cbadmin();
        cbbuku();
        cbuser();
        judul();
        ipinjam.setEditable(false);
        hapus.setEnabled(false);
        ubah.setEnabled(false);
    }
    
    private void tampilData(String string) {
         tabModel = (DefaultTableModel)tbpinjam.getModel();
         tabModel.setRowCount(0);
         try {
             st = net.createStatement();
             rs = st.executeQuery("SELECT * FROM pinjam ");
             String id_pinjam;
             String id_admin;
             String id_user;
             String id_buku;
             String tgl_pinjam;
             String tgl_kembali;
             String det_pinjam;
             while(rs.next()){
                 id_pinjam = rs.getString("id_pinjam");
                 id_admin = rs.getString("id_admin");
                 id_user = rs.getString("id_user");
                 id_buku = rs.getString("id_buku");
                 tgl_pinjam = rs.getString("tgl_pinjam");
                 tgl_kembali = rs.getString("tgl_kembali");
                 det_pinjam = rs.getString("det_pinjam");
                 tabModel.addRow(new Object[]{ id_pinjam, id_admin, id_user, id_buku, tgl_pinjam, tgl_kembali, det_pinjam });
             }
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
         }
    
    public void tampil() {
         tabModel = (DefaultTableModel)tbpinjam.getModel();
         tabModel.setRowCount(0);
         String src = Ksearch.getText();
         
         try {
             st = net.createStatement();
             rs = st.executeQuery("SELECT * FROM pinjam WHERE id_pinjam LIKE '%"+src+"%'");
             String id_pinjam;
             String id_admin;
             String id_user;
             String id_buku;
             String tgl_pinjam;
             String tgl_kembali;
             String det_pinjam;
             while(rs.next()){
                 id_pinjam = rs.getString("id_pinjam");
                 id_admin = rs.getString("id_admin");
                 id_user = rs.getString("id_user");
                 id_buku = rs.getString("id_buku");
                 tgl_pinjam = rs.getString("tgl_pinjam");
                 tgl_kembali = rs.getString("tgl_kembali");
                 det_pinjam = rs.getString("det_pinjam");
                 tabModel.addRow(new Object[]{ id_pinjam, id_admin, id_user, id_buku, tgl_pinjam, tgl_kembali, det_pinjam });
             }
             
         } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e.getMessage());
         }
         }
    
    public void cbbuku(){
       try{
           st = net.createStatement();
           String sql = "SELECT * FROM buku";
           rs = st.executeQuery(sql);
           
           while(rs.next()){
               ibuku.addItem(rs.getString("id_buku"));     
           }       
       }catch(Exception e){
           
       }
   }
    public void cbuser(){
       try{
           st = net.createStatement();
           String sql = "SELECT * FROM user";
           rs = st.executeQuery(sql);
           
           while(rs.next()){
               iuser.addItem(rs.getString("id_user"));     
           }       
       }catch(Exception e){
           
       }
   }
    public void cbadmin(){
       try{
           st = net.createStatement();
           String sql = "SELECT * FROM admin";
           rs = st.executeQuery(sql);
           
           while(rs.next()){
               iadmin.addItem(rs.getString("id_admin"));     
           }       
       }catch(Exception e){
           
       }
   }
    
    public void judul() {
    Object[] judul ={
    "id_pinjam", "id_admin", "id_user", "id_buku", "tgl_pinjam", "tgl_kembali", "det_pinjam"
    };
    tabModel = new DefaultTableModel(null,judul);
    tbpinjam.setModel(tabModel);
    }
    public void reset(){
    ipinjam.setText("");
    iadmin.setSelectedItem("--select id--");
    iuser.setSelectedItem("--select id--");
    ibuku.setSelectedItem("--select id--");
    tpinjam.setDate(null);
    tkembali.setDate(null);
    dpinjam.setText("");
    }
    
    public static Date getTanggalFromTable(JTable table,int kolom){
    JTable tabel = table;
    String str_tgl = String.valueOf(table.getValueAt(table.getSelectedRow(),kolom));
    Date tanggal = null;
    try{
    tanggal = new SimpleDateFormat("yyyy-MM-dd").parse(str_tgl);
    }catch(ParseException ex){
       Logger.getLogger(fPinjam.class.getName()).log(Level.SEVERE,null,ex);
    }
        return tanggal;
    }
    
    public void autonum(){
       try{
           String sql = "SELECT MAX(RIGHT(id_pinjam,2)) AS no_auto FROM pinjam ";
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
               ipinjam.setText("PJ"+nol_plus+no_auto);
           }
       } catch (Exception e) {
           ipinjam.setText("PJ001");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        search = new javax.swing.JToggleButton();
        Ksearch = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        ipinjam = new javax.swing.JTextField();
        IDpinjam = new javax.swing.JLabel();
        IDUser = new javax.swing.JLabel();
        IDadmin = new javax.swing.JLabel();
        Tglpinjam = new javax.swing.JLabel();
        Tglkembali = new javax.swing.JLabel();
        dpinjam = new javax.swing.JTextField();
        Detailpinjam = new javax.swing.JLabel();
        iuser = new javax.swing.JComboBox<>();
        ibuku = new javax.swing.JComboBox<>();
        tpinjam = new com.toedter.calendar.JDateChooser();
        tkembali = new com.toedter.calendar.JDateChooser();
        iadmin = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbpinjam = new javax.swing.JTable();
        ubah = new javax.swing.JToggleButton();
        hapus = new javax.swing.JToggleButton();
        tambah = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        simpan = new javax.swing.JToggleButton();
        Home = new javax.swing.JButton();
        Datauser = new javax.swing.JButton();
        Kategori = new javax.swing.JButton();
        Buku = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 255));

        jLabel1.setFont(new java.awt.Font("Arial Black", 0, 24)); // NOI18N
        jLabel1.setText("Data Pinjam");

        jPanel2.setBackground(new java.awt.Color(255, 153, 153));

        search.setText("Search");
        search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchActionPerformed(evt);
            }
        });

        Ksearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KsearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(search, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Ksearch, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(search, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Ksearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4.setBackground(new java.awt.Color(204, 204, 204));

        IDpinjam.setText("ID Pinjam");

        IDUser.setText("ID User");

        IDadmin.setText("ID Buku");

        Tglpinjam.setText("Tgl Pinjam");

        Tglkembali.setText("Tgl Kembali");

        dpinjam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dpinjamActionPerformed(evt);
            }
        });

        Detailpinjam.setText("Detail Pinjam ");

        iuser.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select id--" }));

        ibuku.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select id--" }));

        tpinjam.setDateFormatString("yyyy-MM-dd");

        tkembali.setDateFormatString("yyyy-MM-dd");

        iadmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--select id--" }));
        iadmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iadminActionPerformed(evt);
            }
        });

        jLabel2.setText("ID Admin");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(IDadmin)
                    .addComponent(IDUser)
                    .addComponent(IDpinjam)
                    .addComponent(Detailpinjam)
                    .addComponent(Tglkembali)
                    .addComponent(jLabel2)
                    .addComponent(Tglpinjam))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(iuser, 0, 371, Short.MAX_VALUE)
                        .addComponent(ibuku, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tpinjam, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tkembali, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ipinjam, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(iadmin, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ipinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(IDpinjam))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(iadmin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(iuser, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDUser, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ibuku, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IDadmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tpinjam, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tglpinjam, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tkembali, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Tglkembali, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dpinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Detailpinjam))
                .addGap(27, 27, 27))
        );

        jScrollPane2.setEnabled(false);

        tbpinjam.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Pinjam", "ID Admin", "ID User", "ID Buku", "Tgl Pinjam", "Tgl Kembali", "Detail Pinjam"
            }
        ));
        tbpinjam.setCellSelectionEnabled(true);
        tbpinjam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbpinjamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbpinjam);
        tbpinjam.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        ubah.setText("Ubah");
        ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ubahActionPerformed(evt);
            }
        });

        hapus.setText("Hapus");
        hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hapusActionPerformed(evt);
            }
        });

        tambah.setText("Tambah");
        tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tambahActionPerformed(evt);
            }
        });

        jButton1.setText("tampilkan");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        simpan.setText("reset");
        simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                simpanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(hapus, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ubah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tambah, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                            .addComponent(simpan)))
                    .addComponent(jScrollPane2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tambah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ubah)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(hapus)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(simpan))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        Home.setText("Home");
        Home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HomeActionPerformed(evt);
            }
        });

        Datauser.setText("Data User");
        Datauser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatauserActionPerformed(evt);
            }
        });

        Kategori.setText("Kategori");
        Kategori.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                KategoriActionPerformed(evt);
            }
        });

        Buku.setText("Buku");
        Buku.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BukuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(76, 76, 76)
                        .addComponent(Home)
                        .addGap(18, 18, 18)
                        .addComponent(Datauser)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Kategori)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(Buku)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Home)
                    .addComponent(Datauser)
                    .addComponent(Kategori)
                    .addComponent(Buku)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );

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

        setSize(new java.awt.Dimension(712, 632));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchActionPerformed
        // TODO add your handling code here:
        tampil();
    }//GEN-LAST:event_searchActionPerformed

    private void KsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KsearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_KsearchActionPerformed

    private void ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ubahActionPerformed
        // TODO add your handling code here:
            String tampil = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat (tampil);
            String tpin = String.valueOf(fm.format(tpinjam.getDate()));
            String tkel = String.valueOf(fm.format(tkembali.getDate()));
        try{
        st = net.createStatement();
        st.executeUpdate("Update pinjam set id_pinjam ='"+ipinjam.getText()+"', id_admin = '"+iadmin.getSelectedItem()+"', id_user = '"+iuser.getSelectedItem()+"', id_buku ='"+ibuku.getSelectedItem()+"', tgl_pinjam ='"+
                tpin+"', tgl_kembali ='"+tkel+"', det_pinjam ='"+dpinjam.getText()+
                "' WHERE id_pinjam= '"+ipinjam.getText()+"'");
        tampilData("");
        JOptionPane.showMessageDialog(null, "Update Berhasil");
        reset();
        autonum();
        }catch(Exception e){
        e.printStackTrace();}
    }//GEN-LAST:event_ubahActionPerformed

    private void hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hapusActionPerformed
        // TODO add your handling code here:
        try{
        int jawab;
        
        if((jawab = JOptionPane.showConfirmDialog(null, "Ingin menghapus data ?","konfirmasi",JOptionPane.YES_NO_OPTION))==0){
        st = net.createStatement();
        st.executeUpdate("DELETE FROM pinjam WHERE id_pinjam='"
        +tabModel.getValueAt(tbpinjam.getSelectedRow(),0)+ "'");
        tampilData("");
        reset();
        autonum();
        }
        }catch(Exception e){
        e.printStackTrace();}
    
    }//GEN-LAST:event_hapusActionPerformed

    private void tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tambahActionPerformed
        // TODO add your handling code here:
        try{
            String tampil = "yyyy-MM-dd";
            SimpleDateFormat fm = new SimpleDateFormat (tampil);
            String tpin = String.valueOf(fm.format(tpinjam.getDate()));
            String tkel = String.valueOf(fm.format(tkembali.getDate()));
        st=net.createStatement();
        st.executeUpdate("INSERT INTO pinjam VALUES (' "+ipinjam.getText()+"','"
        + iadmin.getSelectedItem()+"','"+iuser.getSelectedItem()+"','"+ ibuku.getSelectedItem()+"','"+ tpin+"','"+ tkel+"','"
        + dpinjam.getText()+"')");
        tampilData("");
        JOptionPane.showMessageDialog(null, "Data berasal disimpan");
        reset();
        autonum();
        }catch (Exception e){
        e.printStackTrace();
        }
    }//GEN-LAST:event_tambahActionPerformed

    private void simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_simpanActionPerformed
        // TODO add your handling code here:
        reset();
        autonum();
    }//GEN-LAST:event_simpanActionPerformed

    private void BukuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BukuActionPerformed
        // TODO add your handling code here:
        fBuku fb = new fBuku();
        fb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BukuActionPerformed

    private void dpinjamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dpinjamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dpinjamActionPerformed

    private void HomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HomeActionPerformed
        // TODO add your handling code here:
        fHome fh = new fHome();
        fh.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_HomeActionPerformed

    private void tbpinjamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbpinjamMouseClicked
        // TODO add your handling code here:
        ipinjam.setText(tbpinjam.getValueAt(tbpinjam.getSelectedRow(),0).toString());
        iadmin.setSelectedItem(tbpinjam.getValueAt(tbpinjam.getSelectedRow(),1).toString());
        iuser.setSelectedItem(tbpinjam.getValueAt(tbpinjam.getSelectedRow(),2).toString());
        ibuku.setSelectedItem(tbpinjam.getValueAt(tbpinjam.getSelectedRow(),3).toString());
        tpinjam.setDate(getTanggalFromTable(tbpinjam,4));
        tkembali.setDate(getTanggalFromTable(tbpinjam,5));
        dpinjam.setText(tbpinjam.getValueAt(tbpinjam.getSelectedRow(),6).toString());
        tambah.setEnabled(true);
        ubah.setEnabled(true);
        hapus.setEnabled(true);
    }//GEN-LAST:event_tbpinjamMouseClicked

    private void KategoriActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_KategoriActionPerformed
        // TODO add your handling code here:
        fKategori pk = new fKategori();
        pk.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_KategoriActionPerformed

    private void DatauserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatauserActionPerformed
        // TODO add your handling code here:
        fUser fu = new fUser();
        fu.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_DatauserActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        tampilData("");
        autonum();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void iadminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iadminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_iadminActionPerformed

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
            java.util.logging.Logger.getLogger(fPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fPinjam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fPinjam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Buku;
    private javax.swing.JButton Datauser;
    private javax.swing.JLabel Detailpinjam;
    private javax.swing.JButton Home;
    private javax.swing.JLabel IDUser;
    private javax.swing.JLabel IDadmin;
    private javax.swing.JLabel IDpinjam;
    private javax.swing.JButton Kategori;
    private javax.swing.JTextField Ksearch;
    private javax.swing.JLabel Tglkembali;
    private javax.swing.JLabel Tglpinjam;
    private javax.swing.JTextField dpinjam;
    private javax.swing.JToggleButton hapus;
    private javax.swing.JComboBox<String> iadmin;
    private javax.swing.JComboBox<String> ibuku;
    private javax.swing.JTextField ipinjam;
    private javax.swing.JComboBox<String> iuser;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton search;
    private javax.swing.JToggleButton simpan;
    private javax.swing.JToggleButton tambah;
    private javax.swing.JTable tbpinjam;
    private com.toedter.calendar.JDateChooser tkembali;
    private com.toedter.calendar.JDateChooser tpinjam;
    private javax.swing.JToggleButton ubah;
    // End of variables declaration//GEN-END:variables
}
