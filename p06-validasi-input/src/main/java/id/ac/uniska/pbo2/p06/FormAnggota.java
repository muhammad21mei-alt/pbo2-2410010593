/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.uniska.pbo2.p06;

import com.formdev.flatlaf.FlatLaf;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class FormAnggota extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAnggota.class.getName());

    /**
     * Creates new form FormAnggota
     */
    public FormAnggota() {
        initComponents();
        // Gaya huruf dan placeholder FlatLaf
        judulLabel.putClientProperty("FlatLaf.styleClass", "h2");
        keteranganLabel.putClientProperty("FlatLaf.style", "foreground: $Label.disabledForeground");
        dataAnggotaLabel.putClientProperty("FlatLaf.styleClass", "h4");
        kontakLabel.putClientProperty("FlatLaf.styleClass", "h4");
        npmField.putClientProperty("JTextField.placeholderText", "Contoh: 2410010123");
        emailField.putClientProperty("JTextField.placeholderText", "nama@contoh.com");
        hpField.putClientProperty("JTextField.placeholderText", "08xxxxxxxxxx");
        
        
        for (JLabel pesan : List.of(npmPesanLabel, namaPesanLabel, prodiPesanLabel, emailPesanLabel,
                hpPesanLabel)) {
            pesan.putClientProperty("FlatLaf.styleClass", "small");
            pesan.setForeground(warnaKesalahan());
        }
        
        statusLabel.setForeground(warnaKesalahan());
        getRootPane().setDefaultButton(daftarButton);
        pack();
        setMinimumSize(getSize());
        setLocationRelativeTo(null);
    }
    
    private boolean periksaNpm() {
return tandai(npmField, npmPesanLabel, Validator.npm(npmField.getText()));
}
private boolean periksaNama() {
return tandai(namaField, namaPesanLabel, Validator.nama(namaField.getText()));
}
private boolean periksaProdi() {
String kesalahan = null;
if (prodiCombo.getSelectedIndex() == 0) {
kesalahan = "Pilih salah satu program studi";
}
return tandai(prodiCombo, prodiPesanLabel, kesalahan);
}
private boolean periksaEmail() {
return tandai(emailField, emailPesanLabel, Validator.email(emailField.getText()));
}
private boolean periksaHp() {
return tandai(hpField, hpPesanLabel, Validator.nomorHp(hpField.getText()));
}
/** Menandai isian dengan garis merah dan pesan. Mengembalikan true jika isian valid. */
private boolean tandai(JComponent isian, JLabel pesan, String kesalahan) {
isian.putClientProperty("JComponent.outline", (kesalahan == null) ? null : "error");
pesan.setText((kesalahan == null) ? " " : kesalahan);
return kesalahan == null;
}
private void daftar() {
// Semua isian diperiksa agar pengguna melihat seluruh kesalahan sekaligus
List<JComponent> salah = new ArrayList<>();
if (!periksaNpm()) {
salah.add(npmField);
}
if (!periksaNama()) {
salah.add(namaField);
}
if (!periksaProdi()) {
salah.add(prodiCombo);
}
if (!periksaEmail()) {
salah.add(emailField);
}
if (!periksaHp()) {
salah.add(hpField);
}
if (!salah.isEmpty()) {
statusLabel.setText(salah.size() + " isian perlu diperbaiki");
salah.get(0).requestFocusInWindow(); // arahkan pengguna ke kesalahan pertama
return;
}

statusLabel.setText(" ");
String pesan = "Pendaftaran berhasil."
+ "\n\nNPM: " + npmField.getText()
+ "\nNama: " + namaField.getText().trim()
+ "\nJenis anggota: " + jenisAnggota();
JOptionPane.showMessageDialog(this, pesan, "Pendaftaran Berhasil",
JOptionPane.INFORMATION_MESSAGE);
kosongkan();
}
private String jenisAnggota() {
if (dosenRadio.isSelected()) {
return "Dosen";
}
if (umumRadio.isSelected()) {
return "Umum";
}
return "Mahasiswa";
}
private void batal() {
// Aksi yang menghapus data meminta konfirmasi terlebih dahulu
if (adaIsian()) {
int jawab = JOptionPane.showConfirmDialog(this,
"Data yang sudah diisi akan dihapus. Lanjutkan?", "Konfirmasi",
JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

if (jawab != JOptionPane.YES_OPTION) {
return;
}
}
kosongkan();
}
private boolean adaIsian() {
return !npmField.getText().isBlank() || !namaField.getText().isBlank()
|| !emailField.getText().isBlank() || !hpField.getText().isBlank()
|| !alamatArea.getText().isBlank();
}
private void kosongkan() {
for (JTextField isian : List.of(npmField, namaField, emailField, hpField)) {
isian.setText("");
}
alamatArea.setText("");
prodiCombo.setSelectedIndex(0);
mahasiswaRadio.setSelected(true);
setujuCheck.setSelected(false);
tandai(npmField, npmPesanLabel, null);
tandai(namaField, namaPesanLabel, null);
tandai(prodiCombo, prodiPesanLabel, null);
tandai(emailField, emailPesanLabel, null);
tandai(hpField, hpPesanLabel, null);
statusLabel.setText(" ");
npmField.requestFocusInWindow();
}


/** Merah yang mudah dibaca: lebih gelap di tema terang, lebih terang di tema gelap. */ /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jenisGroup = new javax.swing.ButtonGroup();
        headerPanel = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        keteranganLabel = new javax.swing.JLabel();
        isiPanel = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        dataAnggotaLabel = new javax.swing.JLabel();
        npmLabel = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        prodiLabel = new javax.swing.JLabel();
        jenisLabel = new javax.swing.JLabel();
        kontakLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        hpLabel = new javax.swing.JLabel();
        alamatLabel = new javax.swing.JLabel();
        npmField = new javax.swing.JTextField();
        namaField = new javax.swing.JTextField();
        prodiCombo = new javax.swing.JComboBox<>();
        jenisPanel = new javax.swing.JPanel();
        mahasiswaRadio = new javax.swing.JRadioButton();
        dosenRadio = new javax.swing.JRadioButton();
        umumRadio = new javax.swing.JRadioButton();
        emailField = new javax.swing.JTextField();
        hpField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatArea = new javax.swing.JTextArea();
        setujuCheck = new javax.swing.JCheckBox();
        npmPesanLabel = new javax.swing.JLabel();
        namaPesanLabel = new javax.swing.JLabel();
        prodiPesanLabel = new javax.swing.JLabel();
        emailPesanLabel = new javax.swing.JLabel();
        hpPesanLabel = new javax.swing.JLabel();
        bawahPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        tombolPanel = new javax.swing.JPanel();
        batalButton = new javax.swing.JButton();
        daftarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Pendaftaran Anggota Perpustakaan");

        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 8, 16));
        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.Y_AXIS));

        judulLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        judulLabel.setText("Pendaftaran Anggota");
        headerPanel.add(judulLabel);

        keteranganLabel.setText("Semua isian wajib diisi, kecuali alamat");
        headerPanel.add(keteranganLabel);

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        isiPanel.setLayout(new java.awt.BorderLayout());

        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16));
        formPanel.setLayout(new java.awt.GridBagLayout());

        dataAnggotaLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dataAnggotaLabel.setText("Data Anggota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(dataAnggotaLabel, gridBagConstraints);

        npmLabel.setDisplayedMnemonic('P');
        npmLabel.setLabelFor(npmField);
        npmLabel.setText("NPM");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(npmLabel, gridBagConstraints);

        namaLabel.setDisplayedMnemonic('N');
        namaLabel.setLabelFor(namaField);
        namaLabel.setText("Nama Lengkap");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(namaLabel, gridBagConstraints);

        prodiLabel.setDisplayedMnemonic('R');
        prodiLabel.setLabelFor(prodiCombo);
        prodiLabel.setText("Program Studi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(prodiLabel, gridBagConstraints);

        jenisLabel.setDisplayedMnemonic('J');
        jenisLabel.setText("Jenis Anggota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(jenisLabel, gridBagConstraints);

        kontakLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kontakLabel.setText("Kontak");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(kontakLabel, gridBagConstraints);

        emailLabel.setDisplayedMnemonic('E');
        emailLabel.setLabelFor(emailField);
        emailLabel.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(emailLabel, gridBagConstraints);

        hpLabel.setDisplayedMnemonic('H');
        hpLabel.setLabelFor(hpField);
        hpLabel.setText("Nomor HP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(hpLabel, gridBagConstraints);

        alamatLabel.setDisplayedMnemonic('L');
        alamatLabel.setLabelFor(alamatArea);
        alamatLabel.setText("Alamat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(alamatLabel, gridBagConstraints);

        npmField.setToolTipText("Hanya angka, tepat 10 digit");
        npmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                npmFieldFocusLost(evt);
            }
        });
        npmField.addActionListener(this::npmFieldActionPerformed);
        npmField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                npmFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPanel.add(npmField, gridBagConstraints);

        namaField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                namaFieldFocusLost(evt);
            }
        });
        namaField.addActionListener(this::namaFieldActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPanel.add(namaField, gridBagConstraints);

        prodiCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih program studi", "Teknik Informatika", "Sistem Informasi", "Manajemen Informatika" }));
        prodiCombo.addItemListener(this::prodiComboItemStateChanged);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPanel.add(prodiCombo, gridBagConstraints);

        jenisPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 12));

        mahasiswaRadio.setMnemonic('M');
        mahasiswaRadio.setText("Mahasiswa");
        jenisPanel.add(mahasiswaRadio);

        dosenRadio.setMnemonic('D');
        dosenRadio.setText("Dosen");
        dosenRadio.addActionListener(this::dosenRadioActionPerformed);
        jenisPanel.add(dosenRadio);

        umumRadio.setMnemonic('U');
        umumRadio.setText("Umum");
        jenisPanel.add(umumRadio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPanel.add(jenisPanel, gridBagConstraints);

        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        emailField.addActionListener(this::emailFieldActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPanel.add(emailField, gridBagConstraints);

        hpField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hpFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPanel.add(hpField, gridBagConstraints);

        alamatArea.setColumns(20);
        alamatArea.setRows(5);
        jScrollPane1.setViewportView(alamatArea);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        formPanel.add(jScrollPane1, gridBagConstraints);

        setujuCheck.setMnemonic('T');
        setujuCheck.setText("Saya setuju dengan tata tertib perpustakaan");
        setujuCheck.addItemListener(this::setujuCheckItemStateChanged);
        setujuCheck.addActionListener(this::setujuCheckActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        formPanel.add(setujuCheck, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(npmPesanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(namaPesanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(prodiPesanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(emailPesanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 2, 2, 0);
        formPanel.add(hpPesanLabel, gridBagConstraints);

        isiPanel.add(formPanel, java.awt.BorderLayout.LINE_START);

        bawahPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 8, 8, 8));
        bawahPanel.setLayout(new java.awt.BorderLayout());
        bawahPanel.add(statusLabel, java.awt.BorderLayout.LINE_START);

        tombolPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 8, 0));

        batalButton.setMnemonic('B');
        batalButton.setText("Batal");
        batalButton.addActionListener(this::batalButtonActionPerformed);
        tombolPanel.add(batalButton);

        daftarButton.setText("Daftar");
        daftarButton.setEnabled(false);
        daftarButton.addActionListener(this::daftarButtonActionPerformed);
        tombolPanel.add(daftarButton);

        bawahPanel.add(tombolPanel, java.awt.BorderLayout.LINE_END);

        isiPanel.add(bawahPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(isiPanel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void npmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npmFieldActionPerformed

    private void namaFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_namaFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_namaFieldActionPerformed

    private void dosenRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dosenRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dosenRadioActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void npmFieldKeyTyped(java.awt.event.KeyEvent evt) {                                  
        {//GEN-FIRST:event_npmFieldKeyTyped
// Pencegahan kesalahan: NPM hanya menerima angka dan paling banyak 10 digit
            boolean penuh = npmField.getText().length() >= 10
                    && npmField.getSelectedText() == null;
            if (!Character.isDigit(evt.getKeyChar()) || penuh) {
                evt.consume(); // karakter tidak dimasukkan ke isian
            }
        }                                 
    }//GEN-LAST:event_npmFieldKeyTyped

    private void npmFieldFocusLost(java.awt.event.FocusEvent evt) {                                   
        {//GEN-FIRST:event_npmFieldFocusLost
// Umpan balik segera, tetapi isian kosong baru diperiksa saat Daftar diklik
            if (!npmField.getText().isBlank()) {
                periksaNpm();
            }
        }                                  
    }//GEN-LAST:event_npmFieldFocusLost

    private void namaFieldFocusLost(java.awt.event.FocusEvent evt) {                                    
        {//GEN-FIRST:event_namaFieldFocusLost
            if (!namaField.getText().isBlank()) {
                periksaNama();
            }
        }                                   
    }//GEN-LAST:event_namaFieldFocusLost

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {                                     
        {//GEN-FIRST:event_emailFieldFocusLost
            if (!emailField.getText().isBlank()) {
                periksaEmail();
            }
        }                                    
    }//GEN-LAST:event_emailFieldFocusLost

    private void hpFieldFocusLost(java.awt.event.FocusEvent evt) {                                  
        {//GEN-FIRST:event_hpFieldFocusLost
            if (!hpField.getText().isBlank()) {
                periksaHp();
            }
        }                                 
    }//GEN-LAST:event_hpFieldFocusLost

    private void prodiComboItemStateChanged(java.awt.event.ItemEvent evt) {                                            
        {//GEN-FIRST:event_prodiComboItemStateChanged
            if (evt.getStateChange() == ItemEvent.SELECTED) {
                periksaProdi();
            }
        }                                           
    }//GEN-LAST:event_prodiComboItemStateChanged

    private void setujuCheckItemStateChanged(java.awt.event.ItemEvent evt) {                                             
        {//GEN-FIRST:event_setujuCheckItemStateChanged
            daftarButton.setEnabled(setujuCheck.isSelected());
        }                                            
    }//GEN-LAST:event_setujuCheckItemStateChanged

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        {//GEN-FIRST:event_batalButtonActionPerformed
            batal();
        }                                           
    }//GEN-LAST:event_batalButtonActionPerformed

    private void daftarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        {//GEN-FIRST:event_daftarButtonActionPerformed
            daftar();
        }                                            
    }//GEN-LAST:event_daftarButtonActionPerformed

    private void setujuCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setujuCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setujuCheckActionPerformed

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new FormAnggota().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatArea;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JButton batalButton;
    private javax.swing.JPanel bawahPanel;
    private javax.swing.JButton daftarButton;
    private javax.swing.JLabel dataAnggotaLabel;
    private javax.swing.JRadioButton dosenRadio;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailPesanLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField hpField;
    private javax.swing.JLabel hpLabel;
    private javax.swing.JLabel hpPesanLabel;
    private javax.swing.JPanel isiPanel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.ButtonGroup jenisGroup;
    private javax.swing.JLabel jenisLabel;
    private javax.swing.JPanel jenisPanel;
    private javax.swing.JLabel judulLabel;
    private javax.swing.JLabel keteranganLabel;
    private javax.swing.JLabel kontakLabel;
    private javax.swing.JRadioButton mahasiswaRadio;
    private javax.swing.JTextField namaField;
    private javax.swing.JLabel namaLabel;
    private javax.swing.JLabel namaPesanLabel;
    private javax.swing.JTextField npmField;
    private javax.swing.JLabel npmLabel;
    private javax.swing.JLabel npmPesanLabel;
    private javax.swing.JComboBox<String> prodiCombo;
    private javax.swing.JLabel prodiLabel;
    private javax.swing.JLabel prodiPesanLabel;
    private javax.swing.JCheckBox setujuCheck;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel tombolPanel;
    private javax.swing.JRadioButton umumRadio;
    // End of variables declaration//GEN-END:variables

    static Color warnaKesalahan() {
        return FlatLaf.isLafDark() 
                ? new Color(0xFF8A80) 
                : new Color(0xC62828);}
    
}
