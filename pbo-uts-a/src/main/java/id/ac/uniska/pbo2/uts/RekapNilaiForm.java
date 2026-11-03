// Nama: Muhammad
// NPM : 2410010593
package id.ac.uniska.pbo2.uts;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.*;
import java.awt.Color;
import java.awt.event.ActionEvent;

public class RekapNilaiForm extends javax.swing.JFrame {

    private final NilaiTableModel tableModel = new NilaiTableModel();

    public RekapNilaiForm() {
        setContentPane(contentPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null);

        initCustomLogic();
    }

    private void initCustomLogic() {
        setTitle("Rekap Nilai Mahasiswa");
        tblNilai.setModel(tableModel);

        lblError.setForeground(Color.RED);
        lblError.setText("");


        txtNpm.putClientProperty("JTextField.placeholderText", "10 digit angka");
        txtTugas.putClientProperty("JTextField.placeholderText", "0 sampai 100");
        txtUts.putClientProperty("JTextField.placeholderText", "0 sampai 100");
        txtUas.putClientProperty("JTextField.placeholderText", "0 sampai 100");

        btnSimpan.addActionListener(this::btnSimpanActionPerformed);
        btnBersihkan.addActionListener(this::btnBersihkanActionPerformed);

        getRootPane().setDefaultButton(btnSimpan);

        updateRingkasan();
    }

    private void btnSimpanActionPerformed(ActionEvent evt) {
        lblError.setText("");
        String npm = txtNpm.getText().trim();
        String nama = txtNama.getText().trim();
        String strTugas = txtTugas.getText().trim();
        String strUts = txtUts.getText().trim();
        String strUas = txtUas.getText().trim();


        if (!npm.matches("\\d{10}")) {
            lblError.setText("NPM harus 10 digit angka");
            txtNpm.requestFocus();
            return;
        }


        if (tableModel.isNpmExist(npm)) {
            lblError.setText("NPM " + npm + " sudah terdaftar");
            txtNpm.requestFocus();
            return;
        }

        if (nama.isEmpty()) {
            lblError.setText("Nama wajib diisi");
            txtNama.requestFocus();
            return;
        }


        int tugas = validasiNilai(strTugas, "Tugas", txtTugas);
        if (tugas == -1) return;

        int uts = validasiNilai(strUts, "UTS", txtUts);
        if (uts == -1) return;

        int uas = validasiNilai(strUas, "UAS", txtUas);
        if (uas == -1) return;


        NilaiMahasiswa dataBaru = new NilaiMahasiswa(npm, nama, tugas, uts, uas);
        tableModel.tambahNilai(dataBaru);

        bersihkanForm();
        updateRingkasan();
    }

    private int validasiNilai(String input, String namaField, JTextField fieldComponent) {
        try {
            int val = Integer.parseInt(input);
            if (val < 0 || val > 100) {
                lblError.setText("Nilai " + namaField + " harus angka bulat 0 sampai 100");
                fieldComponent.requestFocus();
                return -1;
            }
            return val;
        } catch (NumberFormatException e) {
            lblError.setText("Nilai " + namaField + " harus angka bulat 0 sampai 100");
            fieldComponent.requestFocus();
            return -1;
        }
    }

    private void btnBersihkanActionPerformed(ActionEvent evt) {
        bersihkanForm();
    }

    private void bersihkanForm() {
        txtNpm.setText("");
        txtNama.setText("");
        txtTugas.setText("");
        txtUts.setText("");
        txtUas.setText("");
        lblError.setText("");
        txtNpm.requestFocus();
    }

    private void updateRingkasan() {
        lblRingkasan.setText(tableModel.getRingkasanText());
    }

    public static void main(String[] args) {
        FlatLightLaf.setup();
        java.awt.EventQueue.invokeLater(() -> {
            new RekapNilaiForm().setVisible(true);
        });
    }


    private javax.swing.JPanel contentPane;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextField txtNpm;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtTugas;
    private javax.swing.JTextField txtUts;
    private javax.swing.JTextField txtUas;
    private javax.swing.JButton btnSimpan;
    private javax.swing.JButton btnBersihkan;
    private javax.swing.JLabel lblError;
    private javax.swing.JTable tblNilai;
    private javax.swing.JLabel lblRingkasan;
}