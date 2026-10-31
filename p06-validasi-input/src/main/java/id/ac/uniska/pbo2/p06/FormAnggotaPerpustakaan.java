/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package id.ac.uniska.pbo2.p06;

import static id.ac.uniska.pbo2.p06.FormAnggota.warnaKesalahan;
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
public class FormAnggotaPerpustakaan extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(FormAnggotaPerpustakaan.class.getName());

    /**
     * Creates new form FormAnggotaPerpustakaan
     */
    /** Membuat form baru. */
    public FormAnggotaPerpustakaan() {
        initComponents();
        
        judulLabel.putClientProperty("FlatLaf.styleClass", "h2");
        keteranganLabel.putClientProperty("FlatLaf.style", "foreground: $Label.disabledForeground");
        dataDiriLabel.putClientProperty("FlatLaf.styleClass", "h4");
        kontakLabel.putClientProperty("FlatLaf.styleClass", "h4");
        emailField.putClientProperty("JTextField.placeholderText", "nama@contoh.com");
        hpField.putClientProperty("JTextField.placeholderText", "08xxxxxxxxxx");
        getRootPane().setDefaultButton(daftarButton);
        pack(); // hitung ulang ukuran setelah gaya huruf berubah
        setMinimumSize(getSize()); // jendela tidak dapat dikecilkan melebihi ukuran awal
        setLocationRelativeTo(null);
        
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
if (prodiComboBox.getSelectedIndex() == 0) {
kesalahan = "Pilih salah satu program studi";
}
return tandai(prodiComboBox, prodiPesanLabel, kesalahan);
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
salah.add(prodiComboBox);
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
|| !alamatField.getText().isBlank();
}

private void kosongkan() {
for (JTextField isian : List.of(npmField, namaField, emailField, hpField)) {
isian.setText("");
}
alamatField.setText("");
prodiComboBox.setSelectedIndex(0);
mahasiswaRadio.setSelected(true);
setujuCheck.setSelected(false);
tandai(npmField, npmPesanLabel, null);
tandai(namaField, namaPesanLabel, null);
tandai(prodiComboBox, prodiPesanLabel, null);
tandai(emailField, emailPesanLabel, null);
tandai(hpField, hpPesanLabel, null);
statusLabel.setText(" ");
npmField.requestFocusInWindow();
}


private void tampilkanRingkasan() {
    String jenisAnggota;

    if (mahasiswaRadio.isSelected()) {
        jenisAnggota = "Mahasiswa";
    } else if (dosenRadio.isSelected()) {
        jenisAnggota = "Dosen";
    } else {
        jenisAnggota = "Umum";
    }

    String pesan = "NPM: " + npmField.getText()
            + "\nNama Lengkap: " + namaField.getText()
            + "\nProgram Studi: "
            + prodiComboBox.getSelectedItem()
            + "\nJenis Anggota: " + jenisAnggota
            + "\nEmail: " + emailField.getText()
            + "\nNomor HP: " + hpField.getText()
            + "\nAlamat: " + alamatField.getText();

    javax.swing.JOptionPane.showMessageDialog(
            this,
            pesan,
            "Ringkasan Data Anggota",
            javax.swing.JOptionPane.INFORMATION_MESSAGE
    );
}
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        buttonGroup1 = new javax.swing.ButtonGroup();
        headerPanel = new javax.swing.JPanel();
        judulLabel = new javax.swing.JLabel();
        keteranganLabel = new javax.swing.JLabel();
        tombolPanel = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        batalButton = new javax.swing.JButton();
        daftarButton = new javax.swing.JButton();
        isiForm = new javax.swing.JPanel();
        formPanel = new javax.swing.JPanel();
        npmLabel = new javax.swing.JLabel();
        namaLabel = new javax.swing.JLabel();
        prodiLabel = new javax.swing.JLabel();
        jenisLabel = new javax.swing.JLabel();
        dataDiriLabel = new javax.swing.JLabel();
        npmField = new javax.swing.JTextField();
        namaField = new javax.swing.JTextField();
        prodiComboBox = new javax.swing.JComboBox<>();
        kontakLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        hpLabel = new javax.swing.JLabel();
        alamatLabel = new javax.swing.JLabel();
        emailField = new javax.swing.JTextField();
        hpField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        alamatField = new javax.swing.JTextArea();
        setujuCheck = new javax.swing.JCheckBox();
        persetujuanLabel = new javax.swing.JLabel();
        npmPesanLabel = new javax.swing.JLabel();
        namaPesanLabel = new javax.swing.JLabel();
        prodiPesanLabel = new javax.swing.JLabel();
        emailPesanLabel = new javax.swing.JLabel();
        hpPesanLabel = new javax.swing.JLabel();
        jenisPanel = new javax.swing.JPanel();
        mahasiswaRadio = new javax.swing.JRadioButton();
        umumRadio = new javax.swing.JRadioButton();
        dosenRadio = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        headerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(16, 16, 8, 16));
        headerPanel.setLayout(new javax.swing.BoxLayout(headerPanel, javax.swing.BoxLayout.Y_AXIS));

        judulLabel.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        judulLabel.setText("FORM ANGGOTA PERPUSTAKAAN");
        headerPanel.add(judulLabel);

        keteranganLabel.setText("Silakan lengkapi data anggota perpustakaan");
        headerPanel.add(keteranganLabel);

        getContentPane().add(headerPanel, java.awt.BorderLayout.PAGE_START);

        tombolPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 16, 16));
        tombolPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT));
        tombolPanel.add(statusLabel);

        batalButton.setText("Batal");
        batalButton.addActionListener(this::batalButtonActionPerformed);
        tombolPanel.add(batalButton);

        daftarButton.setText("Daftar");
        daftarButton.setEnabled(false);
        daftarButton.addActionListener(this::daftarButtonActionPerformed);
        tombolPanel.add(daftarButton);

        getContentPane().add(tombolPanel, java.awt.BorderLayout.PAGE_END);

        isiForm.setLayout(new java.awt.BorderLayout());

        formPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(8, 16, 8, 16));
        formPanel.setLayout(new java.awt.GridBagLayout());

        npmLabel.setDisplayedMnemonic('P');
        npmLabel.setLabelFor(npmField);
        npmLabel.setText("NPM");
        npmLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 10);
        formPanel.add(npmLabel, gridBagConstraints);

        namaLabel.setLabelFor(namaField);
        namaLabel.setText("Nama Lengkap");
        namaLabel.setToolTipText("");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        formPanel.add(namaLabel, gridBagConstraints);

        prodiLabel.setLabelFor(prodiComboBox);
        prodiLabel.setText("Program Studi");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        formPanel.add(prodiLabel, gridBagConstraints);

        jenisLabel.setText("Jenis Anggota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        formPanel.add(jenisLabel, gridBagConstraints);

        dataDiriLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        dataDiriLabel.setText("Data Anggota");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 6, 4);
        formPanel.add(dataDiriLabel, gridBagConstraints);

        npmField.setToolTipText("Hanya Angka tepat 10 digit");
        npmField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                npmFieldFocusLost(evt);
            }
        });
        npmField.addActionListener(this::npmFieldActionPerformed);
        npmField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                npmFieldKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                npmFieldKeyTyped(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        formPanel.add(npmField, gridBagConstraints);

        namaField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                namaFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        formPanel.add(namaField, gridBagConstraints);

        prodiComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Program Studi", "Sistem informasi", "Teknik Informatika" }));
        prodiComboBox.addItemListener(this::prodiComboBoxItemStateChanged);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        formPanel.add(prodiComboBox, gridBagConstraints);

        kontakLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        kontakLabel.setText("Kontak");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 2, 0);
        formPanel.add(kontakLabel, gridBagConstraints);

        emailLabel.setLabelFor(emailField);
        emailLabel.setText("Email");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        formPanel.add(emailLabel, gridBagConstraints);

        hpLabel.setLabelFor(hpField);
        hpLabel.setText("Nomor HP");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        formPanel.add(hpLabel, gridBagConstraints);

        alamatLabel.setLabelFor(alamatField);
        alamatLabel.setText("Alamat");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHEAST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 2, 0);
        formPanel.add(alamatLabel, gridBagConstraints);

        emailField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                emailFieldFocusLost(evt);
            }
        });
        emailField.addActionListener(this::emailFieldActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        formPanel.add(emailField, gridBagConstraints);

        hpField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                hpFieldFocusLost(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        formPanel.add(hpField, gridBagConstraints);

        alamatField.setColumns(20);
        alamatField.setRows(5);
        jScrollPane1.setViewportView(alamatField);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 3, 0);
        formPanel.add(jScrollPane1, gridBagConstraints);

        setujuCheck.setText("Setuju dengan  tata tertib perpustakaan");
        setujuCheck.addItemListener(this::setujuCheckItemStateChanged);
        setujuCheck.addActionListener(this::setujuCheckActionPerformed);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(setujuCheck, gridBagConstraints);

        persetujuanLabel.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        persetujuanLabel.setText("Persetujuan");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(8, 0, 2, 0);
        formPanel.add(persetujuanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(npmPesanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(namaPesanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(prodiPesanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(emailPesanLabel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(hpPesanLabel, gridBagConstraints);

        jenisPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 12, 12));

        mahasiswaRadio.setText("Mahasiswa");
        jenisPanel.add(mahasiswaRadio);

        umumRadio.setText("Umum");
        umumRadio.addActionListener(this::umumRadioActionPerformed);
        jenisPanel.add(umumRadio);

        dosenRadio.setText("Dosen");
        jenisPanel.add(dosenRadio);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        formPanel.add(jenisPanel, gridBagConstraints);

        isiForm.add(formPanel, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(isiForm, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void npmFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_npmFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_npmFieldActionPerformed

    private void umumRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_umumRadioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_umumRadioActionPerformed

    private void emailFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailFieldActionPerformed

    private void setujuCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setujuCheckActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_setujuCheckActionPerformed

    private void batalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_batalButtonActionPerformed
        // TODO add your handling code here:
        batal();
    }//GEN-LAST:event_batalButtonActionPerformed

    private void daftarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daftarButtonActionPerformed
        daftar ();
    }//GEN-LAST:event_daftarButtonActionPerformed

    private void setujuCheckItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_setujuCheckItemStateChanged
        // TODO add your handling code here:
        daftarButton.setEnabled(setujuCheck.isSelected());
    }//GEN-LAST:event_setujuCheckItemStateChanged

    private void npmFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npmFieldKeyReleased
        // TODO add your handling code here:
        int jumlahDigit = 0;

    for (char karakter : npmField.getText().toCharArray()) {
        if (Character.isDigit(karakter)) {
            jumlahDigit++;
        }
    }

    npmLabel.setText(jumlahDigit + " dari 10 digit");
    }//GEN-LAST:event_npmFieldKeyReleased

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int jawab = javax.swing.JOptionPane.showConfirmDialog(
            this,
            "Keluar dari aplikasi?",
            "Konfirmasi",
            javax.swing.JOptionPane.YES_NO_OPTION
    );

    if (jawab == javax.swing.JOptionPane.YES_OPTION) {
        dispose();
        }
    }//GEN-LAST:event_formWindowClosing

    private void npmFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_npmFieldKeyTyped
        boolean penuh = npmField.getText().length() >= 10
                    && npmField.getSelectedText() == null;
            if (!Character.isDigit(evt.getKeyChar()) || penuh) {
                evt.consume(); // karakter tidak dimasukkan ke isian
            }
    }//GEN-LAST:event_npmFieldKeyTyped

    private void npmFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_npmFieldFocusLost
        if (!npmField.getText().isBlank()) {
                periksaNpm();
            }
    }//GEN-LAST:event_npmFieldFocusLost

    private void namaFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namaFieldFocusLost
        if (!namaField.getText().isBlank()) {
                periksaNama();
            }
    }//GEN-LAST:event_namaFieldFocusLost

    private void emailFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_emailFieldFocusLost
        if (!emailField.getText().isBlank()) {
                periksaEmail();
        }
    }//GEN-LAST:event_emailFieldFocusLost

    private void hpFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hpFieldFocusLost
        if (!hpField.getText().isBlank()) {
                periksaHp();
            }
    }//GEN-LAST:event_hpFieldFocusLost

    private void prodiComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_prodiComboBoxItemStateChanged
        if (evt.getStateChange() == ItemEvent.SELECTED) {
                periksaProdi();
            }
    }//GEN-LAST:event_prodiComboBoxItemStateChanged

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
        java.awt.EventQueue.invokeLater(() -> new FormAnggotaPerpustakaan().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea alamatField;
    private javax.swing.JLabel alamatLabel;
    private javax.swing.JButton batalButton;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton daftarButton;
    private javax.swing.JLabel dataDiriLabel;
    private javax.swing.JRadioButton dosenRadio;
    private javax.swing.JTextField emailField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JLabel emailPesanLabel;
    private javax.swing.JPanel formPanel;
    private javax.swing.JPanel headerPanel;
    private javax.swing.JTextField hpField;
    private javax.swing.JLabel hpLabel;
    private javax.swing.JLabel hpPesanLabel;
    private javax.swing.JPanel isiForm;
    private javax.swing.JScrollPane jScrollPane1;
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
    private javax.swing.JLabel persetujuanLabel;
    private javax.swing.JComboBox<String> prodiComboBox;
    private javax.swing.JLabel prodiLabel;
    private javax.swing.JLabel prodiPesanLabel;
    private javax.swing.JCheckBox setujuCheck;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel tombolPanel;
    private javax.swing.JRadioButton umumRadio;
    // End of variables declaration//GEN-END:variables
}
